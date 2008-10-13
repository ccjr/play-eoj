class Card < ActiveRecord::Base
  validates_presence_of :number, :title
end