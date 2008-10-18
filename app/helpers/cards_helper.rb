module CardsHelper
  def title_for(options)
    title = "#{options[:race]} #{options[:element]}"
    title.blank? ? "All Cards" : title
  end
  
  def link_to_element(element)
    link_to element, "/cards/element/#{element}"
  end

  def link_to_race(race)
    link_to race, "/cards/race/#{race}"
  end

  def link_to_affiliation(affiliation)
    link_to affiliation, "/cards/affiliation/#{affiliation}"
  end
  
  def directions(card)
    unless card.attack_directions.blank?
      card.attack_directions.split("::").collect do |attack|
        image_tag "http://eojinfo.com/images/attack_#{attack.gsub(" ", "_").downcase}.png"
      end
    end +
    unless card.defense_directions.blank?
      card.defense_directions.split("::").collect do |defense|
        image_tag "http://eojinfo.com/images/defense_#{defense.gsub(" ", "_").downcase}.png"
      end
    end
  end
end