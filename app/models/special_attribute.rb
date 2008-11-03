class SpecialAttribute < ActiveRecord::Base
  validates_presence_of :card_id, :definition_id
  belongs_to :card
  belongs_to :definition
end