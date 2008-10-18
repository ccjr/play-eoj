class AddCardsLimit < ActiveRecord::Migration
  def self.up
    add_column :cards, :limit, :string
  end

  def self.down
    remove_column :cards, :limit
  end
end
