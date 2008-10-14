class Card < ActiveRecord::Base
  validates_presence_of :number, :title
  named_scope :races, :select => 'distinct race', :order => 'race'
  
  def first_letter_of_title
    title.first
  end
end