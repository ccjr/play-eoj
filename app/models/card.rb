class Card < ActiveRecord::Base
  validates_presence_of :number, :title

  named_scope :races, :select => 'distinct race', :order => 'race'
  named_scope :affiliations, :select => 'distinct affiliation', :order => 'affiliation', :conditions => 'affiliation IS NOT NULL'
  
  named_scope :where_title, lambda {|title| { :conditions => ["cards.title like ?", "%#{title}%"] }}
  named_scope :where_number, lambda {|number| { :conditions => ["cards.number = ?", number] }}
  named_scope :where_element, lambda {|element| { :conditions => ["cards.element = ?", element] }}
  named_scope :where_race, lambda {|race| { :conditions => ["cards.race = ?", race] }}
  named_scope :where_affiliation, lambda {|affiliation| { :conditions => ["cards.affiliation = ?", affiliation] }}
  
  ELEMENTS = %w{ Biolith Earth Fire Water Wood Spell }

  def self.list(options={})
    order = options[:order] || 'title'
    listings = (listings || self).where_title(options[:title]) unless options[:title].blank?
    listings = (listings || self).where_number(options[:number]) unless options[:number].blank?
    listings = (listings || self).where_element(options[:element]) unless options[:element].blank?
    listings = (listings || self).where_race(options[:race]) unless options[:race].blank?
    listings = (listings || self).where_affiliation(options[:affiliation]) unless options[:affiliation].blank?
    return (listings || self).all(:order => order)
  end
  
  def first_letter_of_title
    title.first
  end
  
  def spell?
    self.element == 'Spell'
  end
  
  def element_class
    self.element.blank? ? 'none' : self.element.downcase
  end
  def rarity_class
    "#{self.rarity.gsub(' ','_').downcase}_#{self.set}"
  end
end