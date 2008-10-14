module CardsHelper
  def title_for(options)
    title = "#{options[:race]} #{options[:element]}"
    title.blank? ? "All Cards" : title
  end
end