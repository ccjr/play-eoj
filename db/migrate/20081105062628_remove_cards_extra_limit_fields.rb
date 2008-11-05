class RemoveCardsExtraLimitFields < ActiveRecord::Migration
  def self.up
    remove_column :cards, :card_limit
    remove_column :cards, :race_limit
  end

  def self.down
    add_column :cards, :card_limit, :string
    add_column :cards, :race_limit, :string
  end
end