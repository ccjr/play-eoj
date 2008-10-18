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
  affiliation = elements[5].inner_html
  s_cost = elements[6].inner_html
  a_cost = elements[7].inner_html
  hp = elements[8].inner_html
  attack = elements[9].inner_html
  special_attributes = elements[12].inner_html
  body = elements[13].inner_html.gsub("\r\n","")
  
  direction_elements = (doc/"td.td_cards_gui")
  attack_directions  = direction_elements.search('img[@src*="/attack"]').collect{|i| i.parent.children.first}.join("::")
  defense_directions = direction_elements.search('img[@src*="/defense"]').collect{|i| i.parent.children.first}.join("::")
  
  # rarity element has its own class
  rarity = ''
  ['common', 'uncommon', 'rare', 'ultra_rare'].each {|r| rarity = r.titleize if (doc/"td.td_carddetail_#{r}").any?}
  
  unless title.empty?
    card = "#{number}_#{title.downcase.gsub(' ', '_')}:\n"
    card << "  set: #{set}\n" unless set.empty?
    card << "  number: #{number}\n" unless number.empty?
    card << "  title: #{title}\n" unless title.empty?
    card << "  element: #{element}\n" unless element.empty?
    card << "  race: #{race}\n" unless race.empty?
    card << "  affiliation: #{affiliation}\n" unless affiliation.empty?
    card << "  summoning_cost: #{s_cost}\n" unless s_cost.empty?
    card << "  activation_cost: #{a_cost}\n" unless a_cost.empty?
    card << "  health_points: #{hp}\n" unless hp.empty?
    card << "  attack: #{attack}\n" unless attack.empty?
    card << "  rarity: #{rarity}\n" unless rarity.empty?
    card << "  special_attributes: #{special_attributes}\n" unless special_attributes.empty?
    card << "  attack_directions: #{attack_directions}\n" unless attack_directions.empty?
    card << "  defense_directions: #{defense_directions}\n" unless defense_directions.empty?
    unless body.empty?
      card << "  body: |" 
      card << "    #{body}"
    end
    cards << card
  end
end
puts cards.join("\n")