class AddCardsMisprint < ActiveRecord::Migration
  def self.up
    add_column :cards, :misprint, :boolean, :default => false
  end

  def self.down
    remove_column :cards, :misprint
  end
end