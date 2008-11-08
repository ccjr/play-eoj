require 'rubygems'
require 'hpricot'
require 'open-uri'
require 'active_support'

namespace :data do
  # Android related tasks
  namespace :android do

    desc "Creates code to insert all definitions"
    task(:definitions => :environment) do
      puts "// GENERATED CODE, CHANGE IN data:android:definitions TASK"
      definitions = Definition.all(:order => 'name')
      definitions.each do |definition|
        puts "public static final Definition #{definition.name.upcase.gsub(' ', '_')} = new Definition(\"#{definition.name}\", \"#{definition.description}\");"
      end
      puts "public static final Definition[] ALL_DEFINITIONS = { #{definitions.collect{|d| d.name.upcase.gsub(' ', '_')}.join(", ")} };"
      puts "public static final String[] ALL_NAMES = { #{definitions.collect {|d| "\"#{d.name}\""}.join(", ")} };"
    end

    task(:special_attributes => :environment) do
      puts "// GENERATED CODE, CHANGE IN data:android:special_attributes TASK"
      SpecialAttribute.all.each do |special_attribute|
        puts "addSpecialAttribute(db, #{special_attribute.card_id}, #{special_attribute.definition_id}, #{special_attribute.grants?},
                        #{special_attribute.gains?}, #{special_attribute.plus?}. #{special_attribute.minus?});"
      end
    end
    
    task(:cards => :environment) do
      puts "// GENERATED CODE, CHANGE IN data:android:cards TASK"
      # TODO: escape double quotes in body field - after removing HTML from body
      Card.all.each do |card|
        puts "addCard(db, #{card.number}, \"#{card.set}\", \"#{card.title}\", \"#{card.element}\",
                        \"#{card.race}\", \"#{card.summoning_cost}\", \"#{card.activation_cost}\", \"#{card.health_points}\",
                        \"#{card.attack}\", \"#{card.rarity}\", \"#{card.body}\", \"#{card.affiliation}\",
                        \"#{card.attack_directions}\", \"#{card.defense_directions}\", \"#{card.limit}\");"
      end
    end
    
  end
  
  # eojinfo.com related tasks
  namespace :eojinfo do

    desc "Creates code to insert all definitions"
    task(:special_attributes => :environment) do
      # page for all cards
      doc = Hpricot(open("http://eojinfo.com/cards.php"))
      pages = (doc/"table#cards_table//a").collect{|e| e.attributes['href']}.uniq

      pages.each do |page|
        # page for 1 card
        doc = Hpricot(open("http://eojinfo.com/#{page}"))
        elements = (doc/"td.td_carddetail")

        # set all values
        number = elements[1].inner_html
        special_attributes = elements[12].inner_html

        special_attributes.split(',').each do |special_attribute|
          card = Card.find_by_number(number)

          grants = special_attribute.starts_with? 'Grants'
          gains = special_attribute.starts_with? 'Gains'
          plus = special_attribute.ends_with? '+'
          minus = special_attribute.ends_with? '-'

          definition_name = special_attribute.gsub(/Grants/, '').gsub(/Gains/, '').gsub(/\+/, '').gsub(/-/, '').gsub(/Power/, '')
          definition_name.gsub!(/&nbsp;/, ' ')
          definition_name.strip!
          # some common substitutions
          definition_name = 'Hit Points (HPs)' if definition_name == 'HP'
          definition = Definition.find_by_name(definition_name)
          raise "Invalid definition: *#{definition_name}* *#{special_attribute}*" if definition.nil?

          yml = "#{number}_#{card.title.downcase.gsub(' ', '_')}_#{definition.name.downcase.gsub(' ', '_')}:\n"
          yml << "  card: #{card.id}\n"
          yml << "  definition_id: #{definition.id}\n"
          yml << "  grants: true\n" if grants
          yml << "  gains: true\n" if gains
          yml << "  plus: true\n" if plus
          yml << "  minus: true\n" if minus
          puts yml
        end
      end
    end
  
  end
  
end