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
end