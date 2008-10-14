class Card < ActiveRecord::Base
  validates_presence_of :number, :title

  named_scope :races, :select => 'distinct race', :order => 'race'
  named_scope :where_number, lambda {|number| { :conditions => ["cards.number = ?", number] }}
  named_scope :where_element, lambda {|element| { :conditions => ["cards.element = ?", element] }}
  named_scope :where_race, lambda {|race| { :conditions => ["cards.race = ?", race] }}
  
  ELEMENTS = %w{ Fire Earth Water Wood Spell }

  def self.list(options={})
    order = options[:order] || 'title'
    listings = (listings || self).where_number(options[:number]) unless options[:number].blank?
    listings = (listings || self).where_element(options[:element]) unless options[:element].blank?
    listings = (listings || self).where_race(options[:race]) unless options[:race].blank?
    return (listings || self).all(:order => order)
  end
  
  def first_letter_of_title
    title.first
  end
end