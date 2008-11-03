class SpecialAttribute < ActiveRecord::Base
  validates_presence_of :card_id, :definition_id
  belongs_to :card
  belongs_to :definition
  
  def description
    description = ''
    description << 'Grants ' if self.grants?
    description << 'Gains ' if self.gains?
    description << self.definition.name
    description << ' +' if self.plus?
    description << ' -' if self.minus?
    return description    
  end
end