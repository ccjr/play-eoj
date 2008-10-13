class CreateCards < ActiveRecord::Migration
  def self.up
    create_table :cards do |t|
      t.integer :number
      t.integer :set
      t.string :title
      t.string :element
      t.string :race
      t.integer :summoning_cost
      t.integer :activation_cost
      t.integer :health_points
      t.string :attack
      t.string :rarity
      t.integer :card_limit
      t.integer :race_limit
      t.string :special_attributes
      t.text :body

      t.timestamps
    end
  end

  def self.down
    drop_table :cards
  end
end