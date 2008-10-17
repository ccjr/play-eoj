#!/usr/bin/env ruby

require 'rubygems'
require 'hpricot'
require 'open-uri'
require 'active_support'

# page for all cards
doc = Hpricot(open("http://eojinfo.com/cards.php"))
pages = (doc/"table#cards_table//a").collect{|e| e.attributes['href']}.uniq
cards = Array.new

pages.each do |page|
  # page for 1 card
  doc = Hpricot(open("http://eojinfo.com/#{page}"))
  elements = (doc/"td.td_carddetail")

  # set all values
  set = elements[0].inner_html
  number = elements[1].inner_html
  title = elements[2].inner_html
  element = elements[3].inner_html
  race = elements[4].inner_html
  s_cost = elements[6].inner_html
  a_cost = elements[7].inner_html
  hp = elements[8].inner_html
  attack = elements[9].inner_html
  special_attributes = elements[12].inner_html
  body = elements[13].inner_html
  
  direction_elements = (doc/"td.td_cards_gui")
  unless direction_elements.empty?
    attack_directions  = direction_elements[0].children.first if direction_elements[0] and direction_elements[0].children.any?
    defense_directions = direction_elements[1].children.first if direction_elements[1] and direction_elements[1].children.any?
  end
  
  # rarity element has its own class
  rarity = ''
  ['common', 'uncommon', 'rare', 'ultra_rare'].each {|r| rarity = r.titleize if (doc/"td.td_carddetail_#{r}").any?}
  
  card =
"#{number}_#{title.downcase.gsub(' ', '_')}:
  set: #{set}
  number: #{number}
  title: \"#{title}\"
  element: #{element}
  race: #{race}
  summoning_cost: #{s_cost}
  activation_cost: #{a_cost}
  health_points: #{hp}
  attack: #{attack}
  rarity: #{rarity}
  special_attributes: #{special_attributes}
  attack_directions: #{attack_directions}
  defense_directions: #{defense_directions}
  body: \"#{body}\""
  cards << card
end
puts cards.join("\n")