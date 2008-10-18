class AddCardsDirections < ActiveRecord::Migration
  def self.up
    add_column :cards, :attack_directions, :string
    add_column :cards, :defense_directions, :string
  end

  def self.down
    remove_column :cards, :defense_directions
    remove_column :cards, :attack_directions
  end
end
