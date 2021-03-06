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
    directions = []
    unless card.attack_directions.blank?
      card.attack_directions.split("::").collect do |attack|
        directions << image_tag("directions/attack_#{attack.gsub(" ", "_").downcase}.png")
      end
    end
    unless card.defense_directions.blank?
      card.defense_directions.split("::").collect do |defense|
        directions << image_tag("directions/defense_#{defense.gsub(" ", "_").downcase}.png")
      end
    end
    return directions.join
  end
  
  def special_attributes(card)
    card.special_attributes.collect do |special_attribute|
      link_to special_attribute.description, "##{dom_id(special_attribute.definition)}"
    end.join(', ')
  end
  
  def misprint_text(card)
    "<br /><br /><i>Note: The text on the printed card is incorrect.</i>" if card.misprint?
  end
end