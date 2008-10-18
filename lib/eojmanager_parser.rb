#!/usr/bin/env ruby

fire_cards = "211,Partmole Gatekeeper,Demon,Dhees Empire,Common,1/2,1,1+,-
212,Rageflame Spitter,Bug,None,Common,1/1,2,1,-
213,Fire Witch's Familiar,Demon,None,Uncommon,2/12,1+,-
214,Crimson Mimic,Egg,None,Rare,2/1,2,0,-
215,Lizard Shocktrooper,Lizard,Dhees Empire,Common,3/2,3,2,-
216,Flame Lizard Barracks,Base,Dhees Empire,Uncommon,3/2,4,1,-
217,Cai-Shae Brazier,Weapon,Cai-Shae,Common,3/3,1,0,-
218,Flame Wyvern,Dragon,Dhees Empire,Rare,4/3,4,1+,-
219,Mourning Cenobite,Human,Cult of Mourning,Common,4/2,3,2+,-
220,Mourning Buffalo,Beast,Cult of Mourning,Uncommon,5/2,5,2,-
221,Torrid Nightmare,Demon,Church of Parmus,Uncommon,5/4,4,0,-
222,Flame Lizard General,Lizard,Dhees Empire,Uncommon,6/4,5,3+,-
223,Partmole Scout Balloon,Lizard,Dhees Empire,Rare,6/4,6,3,-
224,Logan Zurtur,Betrayer,Unknown,Ultra-Rare,4/4,4,2+,1 of race
225,Ragin Pyrathrax,Dragon,None,Ultra-Rare,8/4,8,5+,1 of card
226,Carlo the Scorched,Noble,Dhees Empire,Phantom,6/4,4,2+,1 of race"

water_cards = "227,Blue Lycanthrope,Anthromorph,Tritonan Queendom,Uncommon,1/1,1,0+,-
228,Cloudrunner Shipmate,Merfolk,Siam Pirates,Common,1/2,2,1,-
229,Darkwater Syren,Undead,Church of Parmus,Common,2/1,2,0,-
230,Indigo Mimic,Egg,None,Rare,2/1,2,0,-
231,Corsez Henchman,Merfolk,Corsez Family,Common,3/1,3,1,-
232,Corsez Moving Citadel,Base,Corsez Family,Common,3/2,3,0,-
233,Aluhja Prioress,Human,Church of Parmus,Uncommon,3/3,3,2,-
234,Sea Serpent,Dragon,Tritonan Queendom,Rare,4/3,4,1+,-
235,Siam's Sentinel,Merfolk,Siam Pirates,Uncommon,4/3,4,2,-
236,Queen's Commissioner,Elemental,Tritonan Queendom,Uncommon,5/3,1,2,-
237,Don's Double,Merfolk,Corsez Family,Common,5/3,5,1+,-
238,Tritonan Sacred Court,Base,Tritonan Queendom,Rare,6/4,4,2,-
239,Missionary Ship,Weapon,Church of Parmus,Uncommon,6/3,4,2,-
241,Capricious Hydromancer,Dragon,None,Ultra-Rare,8/4,8,5+,1 of card
242,Clare Wil the Valiant,Noble,Tritonan Queendom,Phantom,6 /3,4,2+,1 of race"

earth_cards = "243,Skeleton Archer,Undead,Novogus Dynasty,Common,1/1,2,1,-
244,Verzar Defender,Human,Val na Vos,Common,1/1,2,0,-
245,Stone Wing Veteran,Dwarf,Hammer Valley,Common,2/1,2,1,-
246,Ochre Mimic,Egg,None,Rare,2/1,2,0,-
247,Dwarf Miner,Dwarf,Hammer Valley,Uncommon,3/2,3,1,-
248,Forgotten Fortress,Base,Val na Vos,Uncommon,3/2,4,0,-
249,Roving Penitentiary,Base,Novogus Dynasty,Common,3/2,4,1,-
250,Bone Drake,Dragon,Novogus Dynasty,Rare,4/3,4,1+,-
251,Blackhood Anti-Mystic,Dwarf,Black Hoods,Common,4/3,4,2+,-
252,Novogus War Mammoth,Beast,Novogus Dynasty,Uncommon,5/3,5,2,-
253,Dark Ozeki Kihomaru,Titan,Val na Vos,Uncommon,5/3,5,1+,-
254,Blackhood Caravan,Base,Black Hoods,Uncommon,6/3,5,2,-
255,Parmetic Vengeress,Human,Church of Parmus,Rare,6/4,6,2+,-
256,Captain Xerabis,Hero,Novogus Dynasty,Ultra-Rare,4/3,5,2+,1 of race
257,Callous Gaiakhan,Dragon,None,Ultra-Rare,8/4,8,5+,1 of card
258,King Sanavaan,Noble,Val na Vos,Phantom,6/3,6,2+,1 of race"

cards_to_save = Array.new
earth_cards.split("\n").each do |card|
  # set all values
  set = '3'
  number = card.split(',')[0]
  title = card.split(',')[1]
  element = 'Earth'
  race = card.split(',')[2]
  affiliation = card.split(',')[3]
  rarity = card.split(',')[4]
  s_cost = card.split(',')[5].split('/').first
  a_cost = card.split(',')[5].split('/').last
  hp = card.split(',')[6]
  attack = card.split(',')[7]
  limit = card.split(',')[8]
  
  unless title.empty?
    card_to_save = "#{number}_#{title.downcase.gsub(' ', '_')}:\n"
    card_to_save << "  set: #{set}\n" unless set.empty?
    card_to_save << "  number: #{number}\n" unless number.empty?
    card_to_save << "  title: #{title}\n" unless title.empty?
    card_to_save << "  element: #{element}\n" unless element.empty?
    card_to_save << "  race: #{race}\n" unless race.empty?
    card_to_save << "  affiliation: #{affiliation}\n" unless (affiliation == 'None')
    card_to_save << "  summoning_cost: #{s_cost}\n" unless s_cost.empty?
    card_to_save << "  activation_cost: #{a_cost}\n" unless a_cost.empty?
    card_to_save << "  health_points: #{hp}\n" unless hp.empty?
    card_to_save << "  attack: #{attack}\n" unless attack.empty?
    card_to_save << "  rarity: #{rarity}\n" unless rarity.empty?
    card_to_save << "  limit: #{limit}\n" unless (limit == '-')
    cards_to_save << card_to_save
  end
end
puts cards_to_save.join("\n")