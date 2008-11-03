class RemoveCardsSpecialAttributes < ActiveRecord::Migration
  def self.up
    remove_column :cards, :special_attributes
  end

  def self.down
    add_column :cards, :special_attributes, :string
  end
end