class CreateSpecialAttributes < ActiveRecord::Migration
  def self.up
    create_table :special_attributes do |t|
      t.integer :card_id
      t.integer :definition_id
      t.boolean :grants
      t.boolean :gains
      t.boolean :plus
      t.boolean :minus

      t.timestamps
    end
  end

  def self.down
    drop_table :special_attributes
  end
end