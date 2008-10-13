class FixCardsCostFields < ActiveRecord::Migration
  def self.up
    change_column :cards, :summoning_cost, :string
    change_column :cards, :activation_cost, :string
    change_column :cards, :health_points, :string
  end

  def self.down
    change_column :cards, :summoning_cost, :integer
    change_column :cards, :activation_cost, :integer
    change_column :cards, :health_points, :integer
  end
end