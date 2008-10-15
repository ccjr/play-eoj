class AddCardsAffiliation < ActiveRecord::Migration
  def self.up
    add_column :cards, :affiliation, :string
  end

  def self.down
    remove_column :cards, :affiliation
  end
end