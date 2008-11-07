package mobi.playeoj.android;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseAdapter {

    public static final String DEFINITION_KEY_NAME = "name";
    public static final String DEFINITION_KEY_DESCRIPTION = "description";
	
    private static final String TAG = "DatabaseAdapter";
    private DatabaseHelper mDbHelper;
    private SQLiteDatabase mDb;
    
    /**
     * Database creation SQL statement
     */
    private static final String CARDS_TABLE_CREATE =
            "create table cards (_id integer primary key autoincrement, "
                    + "number integer, set string, title string, element, string, "
                    + "race string, summoning_cost string, activation_cost string, health_points string, "
                    + "attack string, rarity string, body text, affiliation string, "
                    + "attack_direction string, defence_direction string, limit string);";

    private static final String DEFINITIONS_TABLE_CREATE =
        "create table definitions (_id integer primary key autoincrement, "
                + "name string not null, description text not null);";

    private static final String DATABASE_NAME = "play_eoj";
    private static final String CARDS_TABLE = "cards";
    private static final String DEFINITIONS_TABLE = "definitions";
    private static final int DATABASE_VERSION = 4;

    private final Context mCtx;

    private static class DatabaseHelper extends SQLiteOpenHelper {

        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            // add the data
            addCards(db);
            addDefinitions(db);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS cards");
            db.execSQL("DROP TABLE IF EXISTS definitions");
            onCreate(db);
        }

        private void addCards(SQLiteDatabase db) {
            db.execSQL(CARDS_TABLE_CREATE);

            // GENERATED CODE, CHANGE IN data:android:cards TASK
            addCard(db, 112, "2", "Flame Guard Recruit", "Fire",
                                    "Demon", "1", "1", "2",
                                    "0 +", "Common", "Flame Guard Recruit adds 2 to its attack if the target creature is on a Water field.", "Dhees Empire",
                                    "Front Back Strike", "Front Back Blind Left Right", "");
            addCard(db, 243, "3", "Skeleton Archer", "Earth",
                                    "Undead", "1", "1", "2",
                                    "1", "Common", "While Skeleton Archer is on a non-Earth field, he gains <i>Resurrection</i>.", "Novogus Dynasty",
                                    "Standard Ranged", "Standard Blind Back", "");
            addCard(db, 189, "2", "Spire of Juno", "",
                                    "Sacred", "8", "8", "8",
                                    "8", "Ultra Rare", "Spire of Juno does not belong to any element.<br /><br />Spire of Juno can use Incarnation on any allied non-Biolith creature.<br /><br />If there are any enemy Biolith creatures on the board during your opponent's Resolution Phase, you gain 2 mana.", "Unknown",
                                    "Standard Magic", "None", "1 of card");
            addCard(db, 192, "2", "Granvenoa Altar", "Spell",
                                    "Ritual", "0", "", "",
                                    "", "Uncommon", "Discard a creature.  Steal 1 mana from your opponent.", "",
                                    "", "", "1 of card, 3 of race");
            addCard(db, 201, "2", "Aluhjan Fieldbond", "Spell",
                                    "Conjuration", "2", "", "",
                                    "", "Common", "Target creature has <i>fieldmorph.</i>", "",
                                    "", "", "");
            addCard(db, 104, "1", "Ice Flood of Okunada", "Spell",
                                    "Dominion", "0", "", "",
                                    "", "Uncommon", "Discard 2 creatures (at least one must be a Water creature). This spell targets all enemies on and adjacent to a selected Water field. Target creatures are dealt magic damage equal to the number of Water fields.", "",
                                    "", "", "3 of race");
            addCard(db, 120, "2", "Parmetic Deathspeaker", "Fire",
                                    "Demon", "4", "3", "4",
                                    "2", "Rare", "When Parmetic Deathspeaker is summoned, the allied creature directly in front of her gains 2 HP.", "Church of Parmus",
                                    "Standard Magic", "None Blind Back", "");
            addCard(db, 24, "1", "Wolf Ninja", "Water",
                                    "Human", "3", "2", "3",
                                    "1", "Uncommon", "Wolf Ninja gains invisibility while at least one allied Swallow Ninja is on the board.  If Wolf Ninja damages a creature on a Water field, it changes place with that creature (who cannot counterattack).", "Yaksha",
                                    "Arc Longrange Strike", "Arc Blind Back", "");
            addCard(db, 190, "2", "Fist of Juno", "",
                                    "Sacred", "9", "9", "9",
                                    "9", "Ultra Rare", "Fist of Juno does not belong to any element.<br /><br />Fist of Juno can use Incarnation on any allied non-Biolith creature.<br /><br />Enemies on Biolith fields and fields adjacent to Biolith fields cannot <i>Dodge</i> attacks.", "Unknown",
                                    "Lancer", "Standard Blind Back", "1 of card");
            addCard(db, 288, "3", "Romili Reloaded", "Biolith",
                                    "Hero", "4", "4", "4",
                                    "2", "Ultra Rare", "Romili's <i>Magic Attach</i> targets all enemies of the same element as the target.<br /><br />Romili <i>Possesses</i> adjacent enemy creatures on Biolith fields.<br /><br />Subtract 1 from the Activation Cost of any adjacent creature.<br /><br />While an allied Lesser Granvenoa is on the board, fields adjacent to allied Lesser Granvenoa are also treated as Biolith fields.", "",
                                    "Magic Nuke", "None Blind Back", "1 of race");
            addCard(db, 146, "2", "Dwarf Sniper", "Earth",
                                    "Dwarf", "2", "1", "3",
                                    "1", "Common", "Enemies within the 2 fields in front of Dwarf Sniper cannot <i>Dodge.</i><br /><br />While an allied Blackhood Dwarf Vulitra is on the board, Dwarf Sniper gains +1 <i>Protection.</i>", "Blackhoods",
                                    "Selective Front", "Standard Blind Back", "");
            addCard(db, 309, "3", "Vizak's Proclamation", "Spell",
                                    "Sorcery", "2", "", "",
                                    "", "Rare", "Choose a creature on the board.  While it is on the board, it will deal 1 magic damage to all adjacent enemies each time you summon a creature.  Playing this card ends your turn.", "",
                                    "", "", "");
            addCard(db, 106, "1", "Wrathful Winds of Juno", "Spell",
                                    "Dominion", "0", "", "",
                                    "", "Uncommon", "Discard 2 creatures (at least one must be a Wood creature). This spell targets all enemies on and adjacent to a selected Wood field. Target creatures are dealt magic damage equal to the number of Wood fields.", "",
                                    "", "", "3 of race");
            addCard(db, 237, "3", "Don's Double", "Water",
                                    "Merfolk", "5", "3", "5",
                                    "1+", "Common", "While Don's Double is on a non-Water field, he must use his secondary attack.<br /><br />While on a Water field, Don's Double's Attack is equal to 1 plus the number of cards in your hand.<br /><br />While another allied Corsez Family creature is on the board, each time an allied creature <i>Dodges</i> an attack, steal mana from your opponent equal to the number of <i>Dodge</i> attempts the creature has.", "Corsez Family",
                                    "Front Back Strike::Full Circle Barrage", "Front Back Blind Left Right", "");
            addCard(db, 97, "1", "Healing Shower", "Spell",
                                    "Conjuration", "2", "", "",
                                    "", "Common", "All allied creatures of a chosen element gain 3 HP.", "",
                                    "", "", "");
            addCard(db, 200, "2", "Binding Shadows", "Spell",
                                    "Conjuration", "1", "", "",
                                    "", "Rare", "Your opponent must discard a card.", "",
                                    "", "", "");
            addCard(db, 63, "1", "Juno Tree Haunt", "Wood",
                                    "Titan", "3", "1", "1",
                                    "2", "Rare", "Destroy Juno Tree Haunt if it is on a non-Wood field.", "Northern Forces",
                                    "Selective Front", "Standard Blind Back", "");
            addCard(db, 305, "3", "Val's Secret Message", "Spell",
                                    "Dominion", "0", "", "",
                                    "", "Uncommon", "The target allied creature's element is changed to Earth.  This spell has no effect on creatures that do not belong to any element.", "",
                                    "", "", "3 of race");
            addCard(db, 210, "2", "Benediction of Juno", "Spell",
                                    "Sorcery", "3", "", "",
                                    "", "Rare", "Choose a creature on a field.  Until the end of your next turn <b>all creatures of the same element as the target gain <i>Fieldmorph</i>.  Playing this card ends your turn.</b>", "",
                                    "", "", "");
            addCard(db, 218, "3", "Flame Wyvern", "Fire",
                                    "Dragon", "4", "3", "4",
                                    "1+", "Rare", "Flame Wyvern's Attack is equal to 1 plus the number of other Fire creatures on the board.<br /><br />While Flame Wyvern is on a Fire field, other allied creatures gain +1 <i>Magic Protection</i>.<br /><br />While an allied Bone Drake is on the board, all allied creatures other than itself gain Dragon Invocation with no Summoning Cost.", "Dhees Empire",
                                    "Selective Front", "Standard Blind Arc", "");
            addCard(db, 86, "1", "Wormak, Biolith Heir", "Biolith",
                                    "Betrayer", "4", "2", "4",
                                    "2 +", "Ultra Rare", "If the target is an enemy Biolith, Wormak's Attack is equal to 2 plus the number of non-Biolith creatures on the board.  Gain 1 mana each time an enemy is summoned.", "",
                                    "Standard Magic", "Standard Blind Back", "1 of race");
            addCard(db, 2, "1", "Hellfire Spitter", "Fire",
                                    "Bug", "1", "1", "1",
                                    "1", "Common", "", "",
                                    "Selective Full Circle", "Full", "");
            addCard(db, 239, "3", "Missionary Ship", "Water",
                                    "Weapon", "6", "3", "4",
                                    "2", "Uncommon", "While an allied creature is adjacent to Missionary Ship, the affiliation of all non-Biolith creatures in your library, hand, and on the board is changed to Church of Parmus.<br /><br />When an enemy creature uses an attack action while Missionary Ship is on a non-Biolith field, you may discard 2 creature cards from your hand to cancel the action.  Your opponent's Activation Cost is not returned.<br /><br />Each time you summon a creature to a non-Fire field, you may choose a non-Ultra Rare creature from the library with the same affiliation as the summoned creature, reveal it, add it to your hand, then shuffle your library.", "Church of Parmus",
                                    "Left Right Longrange", "Left Right", "");
            addCard(db, 295, "3", "Se Hollyn Battle Hymn", "Spell",
                                    "Conjuration", "2", "", "",
                                    "", "Common", "Choose one allied creature.  The creature and any adjacent allies gain 2 HP.", "",
                                    "", "", "");
            addCard(db, 169, "2", "Tolicore Zealot", "Wood",
                                    "Missionary", "4", "3", "3",
                                    "2", "Uncommon", "You steal the exit mana of all enemy Earth creatures.<br /><br />During <b>your opponent's</b> Resolution Phase, your opponent must discard a card for each allied Fire Missionary creature on the board. <br /><br />Subtract 2 from the Summoning Cost of allied Fire Missionary creatures (minimum 1).", "Church of Parmus",
                                    "Selective Front", "Standard Blind Back", "5 of race");
            addCard(db, 214, "3", "Crimson Mimic", "Fire",
                                    "Egg", "2", "1", "2",
                                    "0", "Rare", "Instead of an attack action, you may sacrifice Crimson Mimic and summon any non-Ultra Rare Fire creature (other than another Crimson Mimic) from your hand in its place at no Summoning Cost.  The new creature may be placed in any orientation, but cannot attack in the turn it was summoned.  This does not end your turn.", "",
                                    "No Attack", "None Blind Back", "");
            addCard(db, 180, "2", "Biolith Transporter", "Biolith",
                                    "Bug", "4", "4", "3",
                                    "0", "Common", "If Biolith Transporter attacks (but does not destroy) any creature, the creatures on the field in front of and field to the right of Biolith Transporter switch locations.<br /><br />If there's a creature on only one of those fields, that creature still swaps fields.<br /><br />There is no counterattack.", "Biolith Castle",
                                    "90 Degree Right", "None Blind Back", "");
            addCard(db, 7, "1", "Flame Ascetic", "Fire",
                                    "Human", "3", "3 -", "3",
                                    "2 +", "Common", "Flame Ascetic adds 2 to its Attack half the time.  The Activation Cost to attack with Flame Ascetic is 2 less than listed.", "Cult of Mourning",
                                    "Standard", "Standard Blind Back", "");
            addCard(db, 77, "1", "Morning Star Warrior", "Biolith",
                                    "Mech", "4", "2", "3",
                                    "2 +", "Common", "Morning Star Warrior adds 2 to its Attack if the target creature has 5 or more HPs.  Morning Star Warrior gains Protection equal to the number of allied Biolith creatures.", "Biolith Castle",
                                    "Selective Front", "Standard Blind Back", "");
            addCard(db, 36, "1", "Blue Cubic", "Water",
                                    "Egg", "1", "1", "1",
                                    "0", "Rare", "Sacrifice Blue Cubic to Summon a non-cubic Water creature in its place (facing any direction) without paying the Summoning Cost.  The summoned creature cannot attack this turn.  This does not end your turn.", "Unknown",
                                    "No Attack", "None Blind Arc", "");
            addCard(db, 290, "3", "The Eye of Juno", "",
                                    "God", "10", "2", "2",
                                    "0", "Ultra Rare", "The Eye of Juno does not belong to any element.<br /><br /><i>Incarnation</i> on any allied non-Biolith creature.<br /><br />Each time a creature is summoned, Eye of Juno gains 1 HP.<br /><br />In each Resolution Phase, any enemy creature with the same orientation as The Eye whose Summoning Cost is equal to or less than The Eye's HP is destroyed.<br /><br />Each time any creature is destroyed, you may search your library for a Sacred creature, reveal it and put it in your hand.  Then shuffle your library.", "Unknown",
                                    "No Attack", "None", "1 of race");
            addCard(db, 38, "1", "Verzar Foot Soldier", "Earth",
                                    "Human", "1", "1", "2",
                                    "1 +", "Common", "Verzar Foot Soldier adds 1 to his Attack if at least one other allied Verzar Foot Soldier is on the board.", "Val na Vos",
                                    "Standard", "Standard Blind Back", "");
            addCard(db, 259, "3", "Goblin Fanfare", "Wood",
                                    "Goblin", "1", "1", "2",
                                    "0", "Uncommon", "If there are no enemy creatures on the board, your opponent loses 2 mana when you summon Goblin Fanfare.<br /><br />While Goblin Fanfare is on the board, subtract 1 from the Activation Cost to rotate allied Green Bandits creatures.", "Green Bandits",
                                    "No Attack", "None Blind Back", "");
            addCard(db, 167, "2", "Goblin Fort", "Wood",
                                    "Base", "4", "3", "6",
                                    "1", "Rare", "Each time an allied Green Bandits creature is summoned, switch the printed HP and Attack of that creature. <br /><br />Allied Green Bandits creatures gain a Dodge attempt if their remaining HP is 1. <br /><br />Destroy Goblin Fort if it is on an Earth field.", "Green Bandits",
                                    "Selective Full Circle", "Full", "");
            addCard(db, 69, "1", "Inquisitor Koog", "Wood",
                                    "Betrayer", "3", "2", "3",
                                    "2 +", "Ultra Rare", "Inquisitor Koog adds 1 to his Attack if the target creature is a Wood creature.  If Inquisitor Koog is destroyed, you gain additional mana equal to the number of enemies.", "Church of Parmus",
                                    "Selective Arc", "Arc Blind Back", "1 of race");
            addCard(db, 268, "3", "Elven Scout Mistress", "Wood",
                                    "Elf", "5", "2", "4",
                                    "2", "Common", "If Elven Scout Mistress attacks from a Water or Wood field, any damage she inflicts will reduce the target's Summoning Cost instead of HPs (minimum 1).  If the target's Summoning Cost was 1, it loses HPs as normal.<br /><br />While Elven Scout Mistress is on a Fire or Earth field, non-adjacent enemies cannot move or rotate.", "Til Vorg Monarchy",
                                    "Standard Magic", "None Blind Back", "");
            addCard(db, 178, "2", "Biolith War Chariot", "Biolith",
                                    "Weapon", "4", "4", "4",
                                    "2 +", "Common", "When Biolith War Chariot attacks a creature whose Summoning Cost is 4 or more, it adds 2 to its Attack.", "Biolith Castle",
                                    "90 Degree Right", "90 Degree Right Blind 90 Degree", "");
            addCard(db, 28, "1", "Queen's Servant", "Water",
                                    "Elemental", "4", "2", "1",
                                    "1", "Rare", "If Queen's Servant is destroyed, steal 1 mana from your opponent.", "Tritonan Queendom",
                                    "Standard Magic", "None Blind Back", "");
            addCard(db, 3, "1", "Freedonian Wanderer", "Fire",
                                    "Elemental", "2", "1", "2",
                                    "1", "Common", "While Freedonian Wanderer is on a non-Fire field, you gain 1 mana each time you summon an allied creature.", "",
                                    "Standard", "Standard Blind Back", "");
            addCard(db, 96, "1", "Clare Wil's Banner", "Spell",
                                    "Conjuration", "1", "", "",
                                    "", "Common", "Add 2 to the Attack of one allied creature until the end of the turn.", "",
                                    "", "", "");
            addCard(db, 293, "3", "Theraclave Tollgate", "Spell",
                                    "Ritual", "0", "", "",
                                    "", "Uncommon", "During this turn and your opponent's next turn, your opponent cannot gain mana outside of the mana phase.  This can only be case if there is at least one enemy creature on the board.", "",
                                    "", "", "1 of card");
            addCard(db, 157, "2", "Vamas, Tomb Sentinel", "Earth",
                                    "Betrayer", "5", "4", "5",
                                    "2 +", "Ultra Rare", "While Vamas, Tomb Sentinel is on a non-Earth field, it must use its secondary attack. <br /><br />Vamas adds 1 to its Attack for each Undead creature in your graveyard. <br /><br />Each time an enemy creature is destroyed, choose 1 Earth creature that is not an Ultra Rare from your graveyard and return it to your hand.", "Novogus Dynasty",
                                    "Selective Full Circle::Full Circle Barrage", "Full", "");
            addCard(db, 66, "1", "Elven Death Dancer", "Wood",
                                    "Elf", "5", "4", "3",
                                    "1", "Rare", "If Elven Death Dancer damages (but does not destroy) a creature, she switches locations with that creature (who cannot counterattack).  Enemies on adjacent fields add 3 to their Activation Cost.", "Black Forest",
                                    "Standard Magic", "None Blind Back", "");
            addCard(db, 310, "3", "Juno's Admonition", "Spell",
                                    "Sorcery", "3", "", "",
                                    "", "Rare", "Choose a creature on the board.  While it is on the board, any fields whose reverse side is the same element as the creature are <i>fieldquaked</i> in either player's Resolution Phase.<br /><br />This spell has no effect on creatures with no element.<br /><br />Playing this card ends your turn.", "",
                                    "", "", "");
            addCard(db, 147, "2", "Battering Ram", "Earth",
                                    "Weapon", "3", "3", "3",
                                    "1 +", "Uncommon", "When Battering Ram attacks a Base creature, it adds 3 to its Attack.<br /><br />Adjacent allied creatures gain +1 <i>Protection</i>", "Val na Vos",
                                    "Lancer", "Standard Blind Back", "");
            addCard(db, 164, "2", "Goblin Basher", "Wood",
                                    "Goblin", "3", "2", "3",
                                    "1", "Common", "", "Green Bandits",
                                    "Arc Barrage", "Arc Blind Back", "");
            addCard(db, 126, "2", "General Lug", "Fire",
                                    "Warlord", "6", "5", "4",
                                    "3", "Ultra Rare", "General Lug's Magic attack targets all enemies on and adjacent to the target Fire field.  <br /><br />While General Lug is on the board, creatures with <i>Invisibility</i> can be attacked as though they didn't have that ability.  <br /><br />Subtract 1 from the Summoning Cost of other allied Fire creatures (minimum 1).", "Dhees Empire",
                                    "Magic Blast", "None Blind Back", "1 of race");
            addCard(db, 13, "1", "Infernal Sciondar Dragon", "Fire",
                                    "Dragon", "7", "4 -", "8",
                                    "5 +", "Rare", "Infernal Sciondar Dragon's Attack is equal to 5 plus the number of other Fire creatures on the board.  While Infernal Sciondar Dragon is on a Fire field, its Activation Cost to attack is 3 less than listed.", "Dhees Empire",
                                    "Selective Front", "Standard Blind Back", "");
            addCard(db, 209, "2", "Seer Vizak's Cleansing", "Spell",
                                    "Sorcery", "3", "", "",
                                    "", "Rare", "Fieldquake all fields whose reverse side is the same as the target field's reverse side. This has no effect on a field whose reverse side is Biolith. Playing this card ends your turn.", "",
                                    "", "", "");
            addCard(db, 197, "2", "Lament for Clare Wil", "Spell",
                                    "Conjuration", "1", "", "",
                                    "", "Common", "All enemies are dealt magic damage equal to the number of <i>Dodge</i> attempts they have.", "",
                                    "", "", "");
            addCard(db, 292, "3", "Corsez Oath", "Spell",
                                    "Ritual", "0", "", "",
                                    "", "Uncommon", "Choose one allied affiliation.  You gain mana equal to the number of allied creatures with the same affiliation as the target on the board.", "",
                                    "", "", "1 of card");
            addCard(db, 297, "3", "Mesmer's Lecture", "Spell",
                                    "Conjuration", "1", "", "",
                                    "", "Common", "Draw a number of cards equal to the difference between the number of allied creatures and enemy creatures on the board.", "",
                                    "", "", "");
            addCard(db, 162, "2", "Leapfrog Boss", "Wood",
                                    "Anthromorph", "2", "1", "1",
                                    "1", "Common", "If Leapfrog Boss is destroyed, your oponent loses 1 mana for each Wood field.", "Green Bandits",
                                    "Standard Ranged", "Standard Blind Back", "");
            addCard(db, 41, "1", "Giant Axe Dwarf", "Earth",
                                    "Dwarf", "2", "1", "3",
                                    "1 +", "Common", "Giant Axe Dwarf adds 1 to his Attack for every allied Stone Wing Dwarf on the board.", "Hammer Valley",
                                    "Standard", "Standard Blind Back", "");
            addCard(db, 161, "2", "White Tree Haunt", "Wood",
                                    "Titan", "2", "1", "1",
                                    "0", "Uncommon", "Enemy creatures that are destroyed adjacent to White Tree Haunt do not generate exit mana.<br /><br />Destroy White Tree Haunt if it is on non-Wood field.", "Northern Forces",
                                    "No Attack", "None Blind Full", "");
            addCard(db, 172, "2", "Prince Lusirion", "Wood",
                                    "Hero", "5", "3", "5",
                                    "2", "Ultra Rare", "Each time an Elf creature is summoned, you may choose a Wood creature from your graveyard that is not Ultra Rare, and return it to your hand.<br /><br />Each time an enemy is summoned to an adjacent field, your opponent discards a card.<br /><br />All other non-Elf creatures add 2 to their activation cost.", "Til Vorg Monarchy",
                                    "Full Longrange Strike", "Full", "1 of race");
            addCard(db, 128, "2", "Queen's Courier", "Water",
                                    "Elemental", "1", "1", "2",
                                    "0", "Common", "When Queen's Courier is summoned, draw 2 cards, then discard 2 cards.", "Tritonan Queendom",
                                    "No Attack", "None Blind Back", "");
            addCard(db, 88, "1", "Guardian Watchtower", "Biolith",
                                    "Ancient", "6", "3", "10",
                                    "1", "Ultra Rare", "Magic Attack targets all enemies of the same element.  When damaging a creature, that creature is rotated 180 degrees and cannot counter.  While an allied Scion is on the board, gain mana equal to the number of allied creatures during your Resolution Phas", "Biolith Castle",
                                    "Magic Nuke", "None", "1 of race");
            addCard(db, 160, "2", "Elven Soul Hunter", "Wood",
                                    "Elf", "1", "1", "1",
                                    "1", "Common", "If Elven Soul Hunter is destroyed on a non-Wood field, take any 1 creature from your graveyard with 3 or less Summoning Cost that is not called Elven Soul Hunter and is not Ultra Rare, and shuffle it into your library.", "Til Vorg Monarchy",
                                    "Standard Ranged", "Standard Blind Back", "");
            addCard(db, 229, "3", "Darkwater Syren", "Water",
                                    "Undead", "2", "1", "2",
                                    "0", "Common", "Creatures adjacent to Darkwater Syren cannot be targeted by spells.<br /><br />If Darkwater Syren is destroyed, choose any creature on a Water field and move it to the field she was previously on without changing its orientation.", "Church of Parmus",
                                    "Standard", "Standard Blind Back", "");
            addCard(db, 116, "2", "Beacon of Cai-Shae", "Fire",
                                    "Weapon", "3", "2", "1",
                                    "0", "Common", "While an allied Did the Enlightened is on the board, all allied creatures gain", "Cai-Shae",
                                    "No Attack", "None", "");
            addCard(db, 73, "1", "Biolith Bomber", "Biolith",
                                    "Blitz", "3", "2", "3",
                                    "1 +", "Common", "Biolith Bomber adds 2 to its Attack if the target creature has a Summoning Cost of 2 or lower.", "Biolith Castle",
                                    "Left Right Longrange Strike", "Full", "");
            addCard(db, 307, "3", "Biolith Infestation", "Spell",
                                    "Dominion", "0", "", "",
                                    "", "Ultra Rare", "Choose an allied creature on the board.  While it is on a non-Biolith field, no enemy creature can receive a field bonus.", "",
                                    "", "", "1 of race");
            addCard(db, 284, "3", "Centipede Tank", "Biolith",
                                    "Weapon", "6", "4", "6",
                                    "3", "Rare", "While Centipede Tank is on a Biolith field, it must use its secondary <i>Magic Attack</i> which targets all creatures of the same race as the target.<br /><br />While Centipede tank is on a non-Biolith field, add 1 to the Summoning Cost of any enemy creature of the same element as the field Centipede Tank is on.", "Biolith Castle",
                                    "Arc Barrage::Magic Nuke", "None Blind Back", "");
            addCard(db, 45, "1", "Se Hollyn Fortress", "Earth",
                                    "Base", "4", "2", "4",
                                    "1", "Uncommon", "Allied creatures on adjaent fields gain +2 Protection.  Destroy Se Hollyn Fortress if it is on a Wood field.", "Val na Vos",
                                    "Selective Full Circle", "Full", "");
            addCard(db, 151, "2", "Dwarf Battlebuggy", "Earth",
                                    "Dwarf", "3", "2", "3",
                                    "1 +", "Common", "When Dwarf Battlebuggy attacks a non-adjacent enemy, it adds 1 to it's Attack.<br /><br />While there is an allied Dwarf creature adjacent to Dwarf Battlebuggy, Dwarf Battlebuggy gains <i>Decoy</i> for adjacent enemies (Those enemies can only attack creatures with <i>Decoy</i>).", "Hammer Valley",
                                    "Selective Arc", "Arc Blind Back", "");
            addCard(db, 177, "2", "Biolith Centurion", "Biolith",
                                    "Mech", "3", "2", "4",
                                    "1", "Common", "While Biolith Centurion is on a Biolith field, subtract 1 from the Activation Cost of adjacent allied creatures.", "Biolith Castle",
                                    "Standard", "Standard Blind Back", "");
            addCard(db, 225, "3", "Ragin Pyrathrax", "Fire",
                                    "Dragon", "8", "4", "8",
                                    "5+", "Ultra-Rare", "Raging Pyrathrax can only be summoned if 2 or more Fire creatures are on the board.<br /><br />Raging Pyrathrax's Attack is equal to 5 plus the number of other creatures on the board.<br /><br />While Raging Pyrathrax is on a non-Biolith field, all other allied creatures gain +2 <i>Magic Protection</i>.<br /><br />While Raging Pyrathrax is on a non-Biolith field, each time any creature uses an attack action, all enemy creatures adjacent to Raging Pyrathrax take 1 magic damage.", "",
                                    "Selective Front", "Standard Blind Back", "1 of card");
            addCard(db, 273, "3", "Wild Dendrovort", "Wood",
                                    "Dragon", "8", "4", "8",
                                    "5 +", "Ultra Rare", "Wild Dendrovort can only be summoned when 2 or more Wood creatures are on the board.<br /><br />Wild Dendrovort's Attack is equal to 5 plus the number of Wood creatures in your graveyard.<br /><br />While Wild Dendrovort is on a non-Biolith field, all adjacent allied creatures get +2 HP.<br /><br />While Wild Dendrovort is on a non-Biolith field, each time any creature rotates, all enemy creatures adjacent to Wild Dendrovort take 1 magic damage.", "",
                                    "Selective Front", "Standard Blind Back", "1 of card");
            addCard(db, 238, "3", "Tritonan Sacred Court", "Water",
                                    "Base", "6", "4", "4",
                                    "2", "Rare", "Tritonan Sacred Court's <i>Magic Attack</i> targets all enemies of the same element as the target.<br /><br />If at least one creature is summoned in your opponent's turn while Tritonan Sacred Court is on a non-Water field, in their Resolution Phase you must both offer the top card of your libraries to the Eye for <i>Judgment</i>.  If you win, steal 1 mana from your opponent.<br /><br />While an enemy Biolith creature is on the board, all other allied non-Biolith creatures get +2 HPs.", "Tritonan Queendom",
                                    "Magic Nuke", "None Blind Back", "");
            addCard(db, 158, "2", "Marshal Akhum", "Earth",
                                    "Warlord", "6", "3", "7",
                                    "1", "Ultra Rare", "Magic Attack targets all enemies on and adjacent to the target Earth field. <br /><br />If your opponent forces you to discard one or more cards, they must discard instead of you.  <br /><br />Subtract 1 from the Summoning Cost of other allied Earth creatures (minimum 1).", "Novogus Dynasty",
                                    "Magic Blast", "None Blind Back", "1 of race");
            addCard(db, 277, "3", "Barrager", "Biolith",
                                    "Mech", "3", "1", "3",
                                    "1", "Common", "While an enemy creature is on an adjacent field, Barrager attacks the same target twice.  The target creature's counterattack occurs after the second attack.", "Biolith Castle",
                                    "Selective Front", "Standard Blind Back", "");
            addCard(db, 224, "3", "Logan Zurtur", "Fire",
                                    "Betrayer", "4", "4", "4",
                                    "2+", "Ultra-Rare", "While Logan Zurtur is adjacent to 2 or more enemy creatures, he must use his secondary attack.<br /><br />While Logan Zurtur is on a Fire field, he attacks the same target twice.  The target creature's counterattack occurs after the second attack.<br /><br />Logan Zurtur adds 1 to his attack if the target is a Fire creature.", "Unknown",
                                    "Standard::Arc Barrage", "Arc Blind Back", "1 of race");
            addCard(db, 31, "1", "Dragon of Voice Sea", "Water",
                                    "Dragon", "7", "4", "8",
                                    "5 +", "Rare", "Dragon of Voice Sea's Attack is equal to 5 plus the number of other Water creatures on the board.  While Dragon of Voice Sea is on a Water field, if you summon a creature to an adjacent field, draw a card.", "Tritonan Queendom",
                                    "Selective Front", "Standard Blind Back", "");
            addCard(db, 294, "3", "Elven Subterfuge", "Spell",
                                    "Conjuration", "2", "", "",
                                    "", "Common", "Your opponent must take the top card from their library and put it into their graveyard.", "",
                                    "", "", "");
            addCard(db, 109, "1", "Seer Vizak's Calamity", "Spell",
                                    "Sorcery", "5", "", "",
                                    "", "Rare", "Fieldquake all fields. Playing this card ends your turn.", "",
                                    "", "", "");
            addCard(db, 132, "2", "Aluhja Moving Citadel", "Water",
                                    "Base", "3", "1", "3",
                                    "1", "Uncommon", "Each adjacent enemy gets -1 HP for each <i>Protection</i> it has.<br /><br />Destroy Aluhja Moving Citadel if it is on a Fire field.", "Church of Parmus",
                                    "Standard Magic", "Standard Blind Back", "");
            addCard(db, 48, "1", "Verzar Elephant Brigade", "Earth",
                                    "Elemental", "5", "3", "5",
                                    "2", "Uncommon", "Verzar Elephant Brigade must use its secondary attack while it is on an Earth field.  While Verzar Elephant Brigade is on an Earth field, allied creatures on adjacent fields add 2 to their attack and 1 to their Activation Cost.", "Val na Vos",
                                    "Lancer::Standard", "Standard Blind Back", "");
            addCard(db, 184, "2", "Biolith Battleship", "Biolith",
                                    "Weapon", "7", "4", "8",
                                    "2", "Ultra Rare", "<b>While Biolith Battleship is on a Biolith field,</b> Biolith Battleship intercepts a summoned enemy creature <i>half the time.</i><br /><br /><b>While on a non-Biolith field</b> all other allied creatures add <b>+2</b> <i>Magic Protection.</i>", "Biolith Castle",
                                    "Standard Magic", "None", "1 of card");
            addCard(db, 15, "1", "Warden Hilda", "Fire",
                                    "Betrayer", "3", "2", "4",
                                    "2 +", "Ultra Rare", "Warden Hilda adds 1 to her Attack if the target creature is a Fire creature.  While on a non-Fire field, Hilda gains Possession of all enemies on Fire fields.", "Cai-Shae",
                                    "Selective Front", "Standard Blind Back", "1 of race");
            addCard(db, 193, "2", "Caisen Riot", "Spell",
                                    "Ritual", "0", "", "",
                                    "", "Uncommon", "Each player loses 1 mana for each of their allied creatures.", "",
                                    "", "", "1 of card, 3 of race");
            addCard(db, 299, "3", "Mourning Reanimation", "Spell",
                                    "Conjuration", "2", "", "",
                                    "", "Rare", "Sacrifice an allied creature.  Search your graveyard for a non-Ultra Rare creature of the same element as the sacrificed creature and summon it to the same field (facing any direction without paying the Summoning Cost.<br /><br />You cannot summon the same creature as one that was summoned in this turn or with the same name as the sacrificed creature.<br /><br />The summoned creature cannot attack this turn.<br /><br />Playing this card ends your turn.", "",
                                    "", "", "");
            addCard(db, 276, "3", "Biolith Transmorph", "Biolith",
                                    "Mech", "3", "3", "4",
                                    "1", "Rare", "Instead of an attack action, you may sacrifice Biolith Transmorph and summon any non-Ultra Rare elemental creature (other than another Biolith Transmorph) from your library in its place at no Summoning Cost.<br /><br />The new creature may be placed in any orientation, but cannot attac kin the turn in which it was summoned.  This does not end your turn.  Then shuffle your library.", "Biolith Castle",
                                    "Standard", "Standard Blind Back", "");
            addCard(db, 270, "3", "Moggy Howdah", "Wood",
                                    "Beast", "6", "2", "4",
                                    "1", "Uncommon", "While Moggy Howdah is on a non-Biolith field, all other allied creatures with the same orientation as Moggy Howdah gain <i>Invisibility</i>.<br /><br />Destroy Moggy Howdah if it is on an Earth field.", "Green Bandits",
                                    "Full Longrange Strike", "Full", "");
            addCard(db, 188, "2", "Hammer of Juno", "",
                                    "Sacred", "6", "4", "5",
                                    "0", "Rare", "Hammer of Juno does not belong to any element.<br /><br />Hammer of Juno can use Incarnation on any allied non-Biolith creature.<br /><br />If Hammer of Juno attacks (but does not destroy) a creature, return that creature to its owner's hand f its Summoning Cost is equal to or less than Hammer of Juno's current HP.", "Unknown",
                                    "Selective Front", "Standard Blind Back", "");
            addCard(db, 246, "3", "Ochre Mimic", "Earth",
                                    "Egg", "2", "1", "2",
                                    "0", "Rare", "When an allied Earth creature is destroyed and put in your graveyard, you may sacrifice Ochre Mimic and summon any non-Ultra Rare Earth creature (other than another Ochre Mimic) from your graveyard in its place at no Summoning Cost.  The new creature may be placed in any orientation, but cannot attack in the turn it was summoned.  This does not end your turn.", "",
                                    "No Attack", "None Blind Back", "");
            addCard(db, 61, "1", "Twin Goblins", "Wood",
                                    "Goblin", "2", "1", "3",
                                    "1", "Common", "", "Green Bandits",
                                    "Front Back Strike", "Front Back", "");
            addCard(db, 42, "1", "Spider Ninja", "Earth",
                                    "Human", "3", "2", "2",
                                    "1", "Uncommon", "Spider Ninja gains Invisibility while at least one allied Wolf Ninja is on the board.  If Spider Ninja damages a creature on an Earth field, it switches locations with that creature (who cannot counterattack).", "Yaksha",
                                    "Standard Magic", "None Blind Back", "");
            addCard(db, 127, "2", "Cloudrunner Marauder", "Water",
                                    "Merfolk", "1", "1", "2",
                                    "1", "Common", "While an allied Siam, Traitor of the Seas is on the board, if Cloudrunner Marauder is destroyed, steal 1 mana from your opponent.", "Siam Pirates",
                                    "Selective Front", "Standard Blind Back", "");
            addCard(db, 67, "1", "Juno Forest Dragon", "Wood",
                                    "Dragon", "7", "4", "8",
                                    "5 +", "Rare", "Juno Forest Dragon's Attack is equal to 5 plus the number of other Wood creatures on the board.  While Juno Forest Dragon is on a Wood field, enemies on adjacent fields add 2 to their Activation Cost.", "Til Vorg Monarchy",
                                    "Selective Front", "Standard Blind Back", "");
            addCard(db, 11, "1", "Triceptaur Behemoth", "Fire",
                                    "Beast", "5", "5", "4",
                                    "5 -", "Rare", "When Triceptaur Behemoth attacks 2 creatures, subtract 2 from its Attack.  When attacking 3 creatures, subtract 4 from its Attack.", "Dhees Empire",
                                    "Arc Barrage", "Arc Blind Back", "");
            addCard(db, 137, "2", "Aluhja Zealot", "Water",
                                    "Missionary", "4", "3", "3",
                                    "2", "Uncommon", "You steal the exit mana of enemy Fire creatures.<br /><br />Add 1 to the Summoning Cost of spells cast by your opponent for each allied Wood Missionary creature.<br /><br />Subtract 2 from the Summoning Cost of allied Wood Missionary creatures (minimum 1).", "Church of Parmus",
                                    "Standard Magic", "None Blind Back", "5 of race");
            addCard(db, 5, "1", "Firefly Ninja", "Fire",
                                    "Human", "3", "2", "2",
                                    "1", "Uncommon", "While Firefly Ninja is on a Fire field it gains Perfect Dodge.  Firefly Ninja gains Invisibility while at least one allied Spider Ninja is on the board.", "Yaksha",
                                    "Standard", "Standard Blind Back", "");
            addCard(db, 125, "2", "Shaman Zolda", "Fire",
                                    "Betrayer", "5", "4", "3",
                                    "2", "Ultra Rare", "During your opponent's Resolution Phase, choose another creature with Summoning Cost less than or equal to the number of Lizard creatures in your graveyard. Return that creature to its owner's hand.", "Dhees Empire",
                                    "Standard Magic", "None Blind Back", "1 of race");
            addCard(db, 191, "2", "Absolver Sacrament", "Spell",
                                    "Ritual", "0", "", "",
                                    "", "Uncommon", "Sacrifice an allied creature. You gain mana equal to the sacrificed creature's Summoning Cost.", "",
                                    "", "", "1 of card, 3 of race");
            addCard(db, 242, "3", "Clare Wil the Valiant", "Water",
                                    "Noble", "6", "3", "4",
                                    "2+", "Phantom", "While Clare Wil is adjacent to two or more allied creatures, she must use her secondary magic attack, which targets all enemy creatures on fields of the same element as the target field.<br /><br />When attacking a non-Water creature, Clare Wilís attack equals 2 plus the number of Water fields.<br /><br />Add 1 to the Summoning Cost of enemy Biolith creatures on non-Biolith fields (including newly summoned creatures)All adjacent allied Water creatures gain Fieldmorph.", "Tritonan Queendom",
                                    "Lancer::Magic Blast", "Standard Blind Back", "1 of race");
            addCard(db, 140, "2", "Sarma of Tinoa", "Water",
                                    "Hero", "5", "3", "4",
                                    "3", "Ultra Rare", "When Sarma of Tinoa is summoned, other allied Water creatures on Water fields gain HP equal to the number of Water fields.<br /><br />If Sarma of Tinoa attacks (but does not destroy) a creature, that creature is pushed back one field in the direction of the attack (provided the field is empty) and cannot counterattack.<br /><br />Add 2 to the Summoning Cost of enemies on adjacent fields.", "Tritonan Queendom",
                                    "Selective Arc", "Arc Blind Back", "1 of race");
            addCard(db, 202, "2", "Aluhjan Spellshield", "Spell",
                                    "Conjuration", "1", "", "",
                                    "", "Rare", "During this turn and your opponent's next turn, they cannot cast spells.", "",
                                    "", "", "");
            addCard(db, 148, "2", "Novogus Bandwagon", "Earth",
                                    "Undead", "3", "2", "2",
                                    "0", "Rare", "While there is an Undead creature adjacent to Novogus Bandwagon, all other allied Undead creatures gain <i>Decoy</i> for all enemies. (Those enemies can only attack creatures with Decoy)<br /><br />Destroy Novogus Bandwagon if it is on a Wood field.", "Novogus Dynasty",
                                    "No Attack", "None", "");
            addCard(db, 176, "2", "Flailmonger", "Biolith",
                                    "Mech", "3", "2", "4",
                                    "1", "Uncommon", "Add 2 to the Summoning Cost of any enemy summoned within the 2 fields in front of Flailmonger.", "Biolith Castle",
                                    "Lancer", "Standard Blind Back", "");
            addCard(db, 255, "3", "Parmetic Vengeress", "Earth",
                                    "Human", "6", "4", "6",
                                    "2+", "Rare", "Parmetic Vengress's <i>Magic Attack</i> only targets enemies within her Attack Zones.<br /><br />Parmetic Vengress's Attack is equal to 2 plus the number of Church of Parmus creatures in your graveyard.<br /><br />If your creatures outnumber enemy creatures, Parmetic Vengress' attack does not damage the target but your opponent loses mana equal to the HPs it would have inflicted.  If your opponent's mana was 0, the target loses HPs as normal.<br /><br />Each time an enemy creature is destroyed, you may choose on non-Ultra Rare Church of Parmus creature from your graveyard and return it to your hand.", "Church of Parmus",
                                    "", "None Blind Back", "");
            addCard(db, 43, "1", "Novogus Catapult", "Earth",
                                    "Weapon", "3", "1", "4",
                                    "2", "Uncommon", "If Novogus Catapult is destroyed, you gain mana equal to the number of Earth fields.", "Novogus Dynasty",
                                    "Standard Ranged", "Standard Blind Back", "");
            addCard(db, 248, "3", "Forgotten Fortress", "Earth",
                                    "Base", "3", "2", "4",
                                    "0", "Uncommon", "While Forgotten Fortress is on a non-Earth field, if an allied Earth creature is summoned adjacent to Forgotten Fortress, or if Forgotten Fortress is summoned adjacent to an allied Earth creature, all Wood fields on the board are <i>fieldquaked</i>.<br /><br />While Forgotten Fortress is on the board, any Biolith creature on a non-Biolith field gets -1HP.<br /><br />Destroy Forgotten Fortress if it is on a Woodl field.", "Val na Vos",
                                    "No Attack", "None", "");
            addCard(db, 117, "2", "Shrine of Mourning", "Fire",
                                    "Base", "3", "2", "3",
                                    "1", "Uncommon", "If there are no enemy Fire creatures on the board, subtract 1 from the Attack of all adjacent enemies.<br /><br />If an allied Cult of Mourning creature would add to its attack <i>half the time</i>, it now always adds to its attack.", "Cult of Mourning",
                                    "Standard Magic", "None Blind Back", "");
            addCard(db, 111, "2", "Flame Novice", "Fire",
                                    "Human", "1", "1", "1",
                                    "1 +", "Common", "Flame Novice adds 1 to its Attack <i>half the time.</i><br /><br />Each adjacent enemy gets -1 HP for each of its <i>Dodge</i> attempts.", "Cult of Mourning",
                                    "Standard", "Standard Blind Back", "");
            addCard(db, 304, "3", "Building The Granvil", "Spell",
                                    "Dominion", "0", "", "",
                                    "", "Uncommon", "The target allied creature's element is changed to Water.  This spell has no effect on creatures that do not belong to any element.", "",
                                    "", "", "3 of race");
            addCard(db, 232, "3", "Corsez Moving Citadel", "Water",
                                    "Base", "3", "2", "3",
                                    "0", "Common", "While Corsez Moving Castle is on a non-Water field, add 1 to the Summoning Cost of any adjacent enemy creatures.<br /><br />All other allied creatures gain a <i>Dodge</i> attempt against attacks from enemy Biolith creatures on non-Biolith fields.<br /><br />Destroy Corsez Moving Castle if it is on a Fire field.", "Corsez Family",
                                    "Selective Full Circle", "Full", "");
            addCard(db, 91, "1", "Parmetic Holy Feast", "Spell",
                                    "Ritual", "0", "", "",
                                    "", "Uncommon", "Discard a creature.  You gain 2 mana.", "",
                                    "", "", "1 of card, 3 of race");
            addCard(db, 9, "1", "Lesser Granvenoa", "Fire",
                                    "Base", "4", "2", "4",
                                    "2", "Uncommon", "Fields adjacent to Lesser Granvenoa cannot be fieldquaked or exchanged.  Destroy Lesser Granvenoa if it is on a Water field.", "Cai-Shae",
                                    "Selective Full Circle", "Full", "");
            addCard(db, 217, "3", "Cai-Shae Brazier", "Fire",
                                    "Weapon", "3", "3", "1",
                                    "0", "Common", "While Cai-Shae Brazier is on the board, any Biolith creature on a non-Biolith field subtracts 1 from its Attack.<br /><br />Each time an allied creature is destroyed on a Fire field, you may choose another creature on the board and return it to its owner's hand by paying mana equal to its Summoning Cost plus 1.<br /><br />No field can be fieldquaked or exchanged while a Sciondar Fire God is in your graveyard.", "Cai-Shae",
                                    "No Attack", "None Blind Back", "");
            addCard(db, 196, "2", "Aluhjan Regeneration", "Spell",
                                    "Conjuration", "4", "", "",
                                    "", "Common", "Choose a creature that is not Ultra Rare of the same element as the target allied creature from your graveyard, and summon it without paying the Summoning Cost.  The summoned creature cannot attack this turn.<br /><br />If this effect summons a creature, your turn ends.", "",
                                    "", "", "");
            addCard(db, 47, "1", "Dungeon of Ten Tyrants", "Earth",
                                    "Base", "4", "2", "4",
                                    "1", "Uncommon", "While Dungeon of Ten Tyrants is on a non-Earth field, gain 1 mana during your Resolution Phase.  Destroy Dungeon of Ten Tyrants if it is on a Wood Field.", "Val na Vos",
                                    "Selective Full Circle", "Full", "");
            addCard(db, 199, "2", "Ninja Fate Enhancer", "Spell",
                                    "Conjuration", "1", "", "",
                                    "", "Common", "Choose a creature on the board then reveal the top card of your library.  If the card is the same race as the target creature, you may summon it without paying its Summoning Cost.<br /><br />If summoned, the creature cannot attack this turn and your turn ends.  If you do not summon it, put it into your graveyard.", "",
                                    "", "", "");
            addCard(db, 95, "1", "Yuga's Mesmerizing Fog", "Spell",
                                    "Conjuration", "1", "", "",
                                    "", "Common", "Choose one allied creature. Rotate all adjacent enemies so that their backs are facing that creature.", "",
                                    "", "", "");
            addCard(db, 155, "2", "Novogus Sinbearer", "Earth",
                                    "Undead", "5", "3", "5",
                                    "0", "Rare", "While Novogus Sinbearer is on an Earth field, each time another allied creature is destroyed, you gain 1 mana for each Undead creature in your graveyard.<br /><br />While Novogus Sinbearer is on a non-Earth field, all other allied creatures gain +1 Protection.<br /><br />Destroy Novogus Sinbearer if it is on a Wood field.", "Novogus Dynasty",
                                    "No Attack", "None", "");
            addCard(db, 25, "1", "Cloud Runner", "Water",
                                    "Weapon", "3", "2", "2",
                                    "1", "Uncommon", "When Cloud Runner is summoned, draw cards equal to the number of Water fields.", "Siam Pirates",
                                    "Left Right Longrange", "Left Right Blind Front Back", "");
            addCard(db, 231, "3", "Corsez Henchman", "Water",
                                    "Merfolk", "3", "1", "3",
                                    "1", "Common", "Each time Corsez Henchman is rotated, look at the top card in your library.<br /><br />Instead of taking an attack action with Corsez Henchman, you may draw a card.", "Corsez Family",
                                    "Selective Arc", "Arc Blind Back", "");
            addCard(db, 134, "2", "Shadow Diver", "Water",
                                    "Human", "3", "2", "2",
                                    "1", "Common", "Shadow Diver always attacks the back of his target.", "Corsez Family",
                                    "Standard", "Standard Blind Back", "");
            addCard(db, 114, "2", "Partmole Warhound", "Fire",
                                    "Beast", "2", "1", "2",
                                    "1", "Common", "Allied creatures on adjacent fields gain +1 Magic Protection.", "Dhees Empire",
                                    "Standard", "Standard Blind Back", "");
            addCard(db, 59, "1", "Elven Berserker Maiden", "Wood",
                                    "Elf", "2", "2", "3",
                                    "1 +", "Uncommon", "While Elven Berserker Maiden has exactly 1 HP, she adds 2 to her Attack and gains a Dodge attempt.", "Black Forest",
                                    "Selective Front", "Standard Blind Back", "");
            addCard(db, 280, "3", "Biolith Sentry", "Biolith",
                                    "Mech", "4", "4", "4",
                                    "2 +", "Uncommon", "While on a Biolith field, Biolith Sentry's Attack is equal to 2 plus the number of cards in your hand.", "Biolith Castle",
                                    "Selective Full Circle", "Full", "");
            addCard(db, 1, "1", "Flame Magus", "Fire",
                                    "Human", "1", "1", "1",
                                    "1", "Common", "", "Church of Parmus",
                                    "Standard Magic", "None Blind Full", "");
            addCard(db, 216, "3", "Flame Lizard Barracks", "Fire",
                                    "Base", "3", "2", "4",
                                    "1", "Uncommon", "Each adjacent allied Lizard creature gains 1 additional attack action.<br /><br />Instead of declaring an attack action, any allied creature may move to an empty field, facing any direction.<br /><br />Destroy Flame Lizard Barracks if it is on a Water field.", "Dhees Empire",
                                    "Selective Full Circle", "Full", "");
            addCard(db, 244, "3", "Verzar Defender", "Earth",
                                    "Human", "1", "1", "2",
                                    "0", "Common", "Verzar Defender gains +2 <i>Protection</i> if at least one other allied Verzar Defender is on the board.", "Val na Vos",
                                    "Standard", "Standard Blind Back", "");
            addCard(db, 153, "2", "Dwarf Battle Forge", "Earth",
                                    "Base", "4", "3", "5",
                                    "0", "Uncommon", "Any Fire fields adjacent to Dwarf Battle Forge are also treated as Earth fields.<br /><br />All allied Dwarf creatures add 1 to their Attack.<br /><br />Destroy Dwarf Battle Forge if it is on a  Wood field.", "Hammer Valley",
                                    "No Attack", "None", "");
            addCard(db, 150, "2", "Verzar Golem", "Earth",
                                    "Elemental", "3", "3", "3",
                                    "0 +", "Rare", "Verzar Golem adds 1 to its Attack for each empty field.", "Val na Vos",
                                    "Standard", "Standard Blind Back", "");
            addCard(db, 22, "1", "Aluhja Priestess", "Water",
                                    "Human", "2", "1", "1",
                                    "1", "Common", "While on a Water field, Aluhja Priestess gains one Dodge attempt.", "Church of Parmus",
                                    "Standard Magic", "None Blind Full", "");
            addCard(db, 156, "2", "Archbishop Jirva", "Earth",
                                    "Hero", "5", "3", "5",
                                    "1 +", "Ultra Rare", "Archbisshop Jirva adds your current mana to his attack.<br /><br />You gain 1 mana during your reosultion phase.", "Hammer Valley",
                                    "Standard Magic", "None Blind Back", "1 of race");
            addCard(db, 33, "1", "Siam, Traitor of the Seas", "Water",
                                    "Betrayer", "3", "2", "4",
                                    "2 +", "Ultra Rare", "Siam attacks the same target twice.  The counterattack of target creature ocurs after second attack.  Siam adds 1 to his Attack if the target creature is a Water creature.  All enemies on Water fields subtract 1 from their Attack.", "",
                                    "Standard", "Standard Blind Back", "1 of race");
            addCard(db, 269, "3", "Berserker Princess", "Wood",
                                    "Elf", "5", "3", "3",
                                    "2 +", "Uncommon", "While Berserker Princess has exactly 1 HP, she gets +2 Attack and <i>Dodge</i>.<br /><br />While Berserker Princess is on a non-Biolith field, all non-Elf creatures generate no exit mana.", "Black Forest",
                                    "Selective Front", "Standard Blind Back", "");
            addCard(db, 267, "3", "Leapfrog Warchief", "Wood",
                                    "Anthromorph", "4", "2", "4",
                                    "2", "Uncommon", "While Leapfrog Warchief is on the board, all other allied Green Bandits creatures subtract 1 from their Activation Cost.<br /><br />Each time an enemy is summoned to a field adjacent to Leapfrog Warchief, your opponent must discard a card.", "Green Bandits",
                                    "Standard Ranged", "Standard Blind Back", "");
            addCard(db, 240, "3", "Reverend Father Vlo", "Water",
                                    "Warlord", "4", "3", "3",
                                    "1", "Ultra Rare", "Reverend Father Vlo's <i>Magic Attack</i> targets all enemies on and adjacent to the target Water field.<br /><br />When Reverend Father Vlo is summoned, you may take a Didi the Enlightened from your library, reveal it, and add it to your hand, then shuffle your library.<br /><br />Water <i>Invocation</i> (non-Ultra Rare cards only).<br /><br />While your creatures outnumber enemy creatures, all adjacent alied creatures gain a <i>Dodge</i> attempt and subtract 2 from their Attack.", "Okunada Monastery",
                                    "Magic Blast", "None Blind Back", "1 of race");
            addCard(db, 165, "2", "Goblin Bomber", "Wood",
                                    "Goblin", "3", "2", "3",
                                    "2", "Common", "", "Green Bandits",
                                    "Selective Front", "Standard Blind Back", "");
            addCard(db, 129, "2", "Frost Guards", "Water",
                                    "Elemental", "2", "1", "3",
                                    "1", "Common", "Frost Guards gain <i>Perfect Dodge</i> when attacked by Fire creatures.", "Tritonan Queendom",
                                    "Left Right Strike", "Left Right", "");
            addCard(db, 275, "3", "Architekt", "Biolith",
                                    "Mech", "3", "2", "4",
                                    "0", "Common", "All other allied creatures of the same element as the field Architekt is on gain +2 <i>Protection</i><br /><br />Any creature adjacent to Architekt cannot move or rotate.", "Biolith Castle",
                                    "No Attack", "None", "1 of race");
            addCard(db, 21, "1", "Tritonan Harpoonsman", "Water",
                                    "Merfolk", "2", "1", "2",
                                    "1", "Common", "While on a Water field, Tritonan Harpoonsman gains one Dodge attempt.", "Tritonan Queendom",
                                    "Lancer", "Standard Blind Back", "");
            addCard(db, 195, "2", "Dhee's Command", "Spell",
                                    "Conjuration", "3", "", "",
                                    "", "Common", "Choose one allied creature that you can activate to attack.  The target creature attacks without paying its Activation Cost.", "",
                                    "", "", "");
            addCard(db, 85, "1", "Tino Son of Scion", "Biolith",
                                    "Hero", "4", "3", "4",
                                    "1 +", "Ultra Rare", "Tino's Magic Attack targets all enemies of the same elemnt as the target.  While Tino is on a Biolith field, his Attack is equal to 1 plus the number of other allied Biolith creatures.  Gain 1 mana each time you summon a creature.", "Biolith Castle",
                                    "Magic Nuke", "None Blind Back", "1 of race");
            addCard(db, 40, "1", "Skeleton Soldier", "Earth",
                                    "Undead", "2", "1", "2",
                                    "1", "Common", "If Skeleton Soldier is destroyed, you gain 1 additional mana.", "Novogus Dynasty",
                                    "90 Degree Left", "90 Degree Left Blind 90 Degree", "");
            addCard(db, 258, "3", "King Sanavaan", "Earth",
                                    "Noble", "6", "3", "6",
                                    "2+", "Phantom", "While King Sanavaan is adjecent to 2 or more allied creatures, he must use his secondary <i>Magic Attack</i>, which targets all enemy creatures of the same race as the target.<br /><br />When attacking a non-Earth creature, King Sanavaan's attack is equal to 2 plus the number of Earth fields.<br /><br />While King Sanavaan is on the board, enemy Biolith creatures on non-Biolith fields get -2 HP.<br /><br />All adjacent allied Earth creatures gain Fieldmorph.", "Val na Vos",
                                    "Left Right Strike::Magic Blast", "Left Right", "1 of race");
            addCard(db, 84, "1", "Ouroboros Dragon", "Biolith",
                                    "Dragon", "7", "4", "10",
                                    "7 +", "Ultra Rare", "Ouroboros Dragon's Attack is equal to 7 plus the number of other Biolith creatures on the board.  While Ouroboros Dragon is on a Biolith field, no field can be fieldquaked or exchanged.", "Biolith Castle",
                                    "Selective Front", "Standard Blind Back", "1 of card");
            addCard(db, 57, "1", "Bewitching Elf Archeress", "Wood",
                                    "Elf", "1", "1", "2",
                                    "1", "Common", "When Archeress damages (but does not destroy) a creature, that creature is rotated 180 degrees and cannot counterattack.", "Northern Forces",
                                    "Standard Ranged", "Standard Blind Back", "");
            addCard(db, 8, "1", "Partmole Flame Guard", "Fire",
                                    "Demon", "3", "2", "3",
                                    "1 +", "Uncommon", "Partmole Flame Guard adds 2 to its Attack if at least one target creature is on a Water field.", "Dhees Empire",
                                    "Lancer", "Standard Blind Back", "");
            addCard(db, 274, "3", "Pope-Queen Cyrstin II", "Wood",
                                    "Noble", "6", "4", "5",
                                    "2 +", "Ultra Rare", "While Pope-Queen Cyrstin II is adjacent to two or more enemy creatures, she must use her secondary <i>Magic Attack</i>, which targets all enemy creatures of the same element as the target.<br /><br />When attacking a non-Wood creature, Pope-Queen Cyrstin II's attack is equal to 2 plus the number of Wood fields.<br /><br />In your opponent's resolution phase, your opponent loses mana equal to the number of enemy Biolith creatures on non-Biolith fields.<br /><br />All adjacent allied Wood creatures gain Fieldmorph.", "",
                                    "Standard Ranged::Magic Blast", "Standard Blind Back", "1 of race");
            addCard(db, 121, "2", "Noram Zealot", "Fire",
                                    "Missionary", "4", "2", "3",
                                    "1", "Uncommon", "You steal the exit mana of enemy Water creatures.<br /><br />Subtract 1 from the Attack of adjacent enemies for each allied Earth Missionary creature.<br /><br />Subtract 2 from the Summoning Cost of allied Earth Missionary Creatures (minimum 1).", "Church of Parmus",
                                    "Lancer", "Standard Blind Back", "5 of race");
            addCard(db, 163, "2", "Elven Plaguedancer", "Wood",
                                    "Elf", "2", "2", "2",
                                    "1", "Uncommon", "If Elven Plaguedancer attacks (but does not destroy) a creature, that creature is rotated 180 degrees and cannot counterattack.<br /><br />While Elven Plaguedancer is on a Wood field, add 1 to the Activation Cost of adjacent enemy creatures.", "Black Forest",
                                    "Standard Magic", "None Blind Back", "");
            addCard(db, 74, "1", "Biolith Stinger", "Biolith",
                                    "Bug", "3", "2", "1",
                                    "0", "Rare", "If Biolith Stinger damages (but does not destroy) a creature, it switches locations with that creature (who cannot counterattack).", "Biolith Castle",
                                    "Selective Full Circle", "Full", "");
            addCard(db, 35, "1", "Goddess Tritona", "Water",
                                    "God", "9", "5", "9",
                                    "3", "Ultra Rare", "Goddess Tritona's Magic Attack targets all enemies on non-Water fields.  Destroy Goddess Tritona if she is on a Biolith field.", "Unknown",
                                    "Magic Nuke", "None", "1 of race");
            addCard(db, 250, "3", "Bone Drake", "Earth",
                                    "Dragon", "4", "3", "4",
                                    "1+", "Rare", "Bone Drake's Attack is equal to 1 plus the number of other Earth creatures on the board.<br /><br />While Bone Drake is on an Earth field, adjacent allied creatures gain +1 <i>Protection</i>.<br /><br />While an allied Sea Serpent is on the board, all allied creatures other than itself gain Dragon <i>Invocation</i> with no Summoning Cost.", "Novogus Dynasty",
                                    "Standard Ranged", "Standard Blind Arc", "");
            addCard(db, 87, "1", "Scion Biolith Lord", "Biolith",
                                    "Noble", "6", "3", "5",
                                    "2", "Ultra Rare", "Scion's Magic Attack targets all enemies of the same element as the target.  All other allied Biolith creatures subtract 2 from their Activation Cost.", "Biolith Castle",
                                    "Magic Nuke", "None Blind Back", "1 of race");
            addCard(db, 79, "1", "Behemoth Groundbreaker", "Biolith",
                                    "Weapon", "4", "3", "4",
                                    "1", "Uncommon", "When Behemoth Groundbreaker is summoned, fieldquake all adjacent fields.", "Biolith Castle",
                                    "Standard", "Standard Blind Back", "");
            addCard(db, 14, "1", "Didi the Enlightened", "Fire",
                                    "Hero", "3", "2", "4",
                                    "2 +", "Ultra Rare", "Didi attacks the same target twice.  The target's counterattack occurs after the second attack.  Didi adds 1 to his Attack if the target creature is on a Fire field.  While Didi is on the board, no Fire field can be fieldquaked or exchanged.", "Cai-Shae",
                                    "Standard", "Standard Blind Back", "1 of race");
            addCard(db, 265, "3", "Goblin Chickenrider", "Wood",
                                    "Goblin", "3", "2", "3",
                                    "1", "Common", "Each time Goblin Chickenrider rotates, he gains <i>Invisibility</i> until the end of the following player's turn.<br /><br />While an allied Preacher Noova is on the board, Goblin Chickenrider subtracts 1 from his Activation Cost to rotate.", "Green Bandits",
                                    "Selective Full Circle", "Full", "");
            addCard(db, 16, "1", "Crucible King Dios IV", "Fire",
                                    "Noble", "6", "4", "6",
                                    "3 + -", "Ultra Rare", "King Dios attacks the same target twice.  The counterattack of the target creature occurs after second attack.<br /><br />While King Dios is on a Fire field, he must use his Magic Attack, which affects the target and all enemies adjacent to it.  The attack value is equal to the number of Fire fields.", "Dhees Empire",
                                    "Standard::Magic Blast", "Standard Blind Back", "1 of race");
            addCard(db, 245, "3", "Stone Wing Veteran", "Earth",
                                    "Dwarf", "2", "1", "2",
                                    "1", "Common", "While Stone Wing Veteran is on the board, each time your opponent sacrifices a creature to summon another, you gain mana equal to the number of unoccupied fields.<br /><br />Stone Wing Veteran gains +1 <i>Protection</i> if at least one allied Giant Axe Dwarf is on the board.", "Hammer Valley",
                                    "Selective Full Circle", "Full", "");
            addCard(db, 83, "1", "Arc Satellite Cannon", "Biolith",
                                    "Blitz", "5", "4", "5",
                                    "4", "Rare", "", "Biolith Castle",
                                    "Standard Magic", "None Blind Back", "");
            addCard(db, 308, "3", "First Fall of Scion", "Spell",
                                    "Sorcery", "3", "", "",
                                    "", "Rare", "Discard your entire hand.  Your opponent must reveal their hand and discard as many creatures (of their choice) as you did.  Playing this card ends your turn.", "",
                                    "", "", "");
            addCard(db, 219, "3", "Mourning Cenobite", "Fire",
                                    "Human", "4", "2", "3",
                                    "2+", "Common", "Mourning Cenobite adds 2 to its Attack <i>half the time</i>.<br /><br />If Mourning Cenobite attacks from a Fire or Earth field, any damage he inflicts will reduce the target's Attack instead of HPs.  If the target's Attack is less than 1, it loses HPs as normal.", "Cult of Mourning",
                                    "Standard Magic", "None Blind Back", "");
            addCard(db, 90, "1", "White Cubic", "",
                                    "Egg", "1", "1", "1",
                                    "0", "Ultra Rare", "White Cubic does not belong to any element.  Sacrifice White Cubic to summon any creaute in its place (facing any direction) without paying the Summoning Cost.  This summoned creautre cannot attack this turn.  This does not end your turn.", "Unknown",
                                    "No Attack", "None Blind Arc", "1 of card");
            addCard(db, 220, "3", "Mourning Buffalo", "Fire",
                                    "Beast", "5", "2", "5",
                                    "2", "Uncommon", "Adjacent enemy creatures with <i>Invisibility</i> can be attacked as if they did not have that ability.<br /><br />Each time Mourning Buffalo declares an attack action, subtract 1 from the Attack of all non-adjacent enemy creatures.<br /><br />While an allied Cult of Mourning creature is on the board, subtract 1 from Mourning Buffalo's Activation Cost to attack.", "Cult of Mourning",
                                    "Selective Front", "Standard Blind Back", "");
            addCard(db, 89, "1", "Phaseus, Biolith God", "Biolith",
                                    "God", "9", "6", "12",
                                    "4", "Ultra Rare", "Phaseus's Magic Attack targets all enemies.  Destroy Phaseus if he is on a non-Biolith field.", "Biolith Castle",
                                    "Magic Nuke", "None", "1 of race");
            addCard(db, 54, "1", "Yellow Cubic", "Earth",
                                    "Egg", "1", "1", "1",
                                    "0", "Rare", "Sacrifice Yellow Cubic to summon a non-cubic Earth creature in its place (facing any direction) without paying the Summoning Cost.  The summoned creature cannot attack this turn.  This does not end your turn.", "Unknown",
                                    "No Attack", "None Blind Arc", "");
            addCard(db, 93, "1", "Summoner Mesmer's Lapse", "Spell",
                                    "Ritual", "0", "", "",
                                    "", "Uncommon", "Discard a creature. Your opponent loses mana equal to the summoning cost of the discarded creature.", "",
                                    "", "", "1 of card, 3 of race");
            addCard(db, 23, "1", "Tentacles of Possession", "Water",
                                    "Beast", "2", "1", "2",
                                    "0", "Uncommon", "Tentacles of Possession gain Possession of the enemy directly in front of it.", "",
                                    "No Attack", "None Blind Back", "");
            addCard(db, 272, "3", "Mandragora Triplet", "Wood",
                                    "Betrayer", "4", "2", "4",
                                    "2", "Ultra Rare", "Mandragora Triplet's <i>Magic Attack</i> only targets enemies within her Attack Zones.<br /><br />After Mandragora Triplet attacks, if there is another allied Mandragora Triplet on the board who has not yet attacked and has one of the original targets in her Attack Zones, she will attack without paying the Activation Cost.<br /><br />while enemy creatures outnumber your creatures on the board, all other allied creatures get +1 Attack and +1 Activation Cost.", "Church of Parmus",
                                    "", "None Blind Back", "3 of race");
            addCard(db, 230, "3", "Indigo Mimic", "Water",
                                    "Egg", "2", "1", "2",
                                    "0", "Rare", "When you successfully cast a spell, you may sacrifice Indigo Mimic and summon any non-Ultra Rare Water creature (other than another Indigo Mimic) from your hand in its place at no Summoning Cost.  The new creature may be placed in any orientation, but cannot attack in the turn it was summoned.  This does not end your turn.", "",
                                    "No Attack", "None Blind Back", "");
            addCard(db, 92, "1", "Goghlie Altar", "Spell",
                                    "Ritual", "0", "", "",
                                    "", "Uncommon", "Both players gain mana equal to the number of enemies on the board.", "",
                                    "", "", "1 of card, 3 of race");
            addCard(db, 99, "1", "Great Tolicore Quake", "Spell",
                                    "Conjuration", "4", "", "",
                                    "", "Rare", "Fieldquake all fields of the chosen element.", "",
                                    "", "", "");
            addCard(db, 124, "2", "Fire Witch Freedonia", "Fire",
                                    "Hero", "5", "4", "5",
                                    "2 +", "Ultra Rare", "Fire Witch Freedonia's Magic attack targets all enemies of the same element as the target.<br /><br />When Freedonia attacks a Biolith creature, add your current mana to her attack. While Fire Witch Freedonia is on a field, adjacent allied creatures have return.", "",
                                    "Magic Nuke", "None Blind Back", "1 of race");
            addCard(db, 181, "2", "Archiver", "Biolith",
                                    "Mech", "5", "3", "5",
                                    "0", "Rare", "The adjacent field in front of the Archiver is also treated as a Biolith field.<br /><br />Each time an allied creature is summoned, other allied creatures of the same element as the summoned creature gain 1 HP.", "Biolith Castle",
                                    "No Attack", "None", "");
            addCard(db, 118, "2", "Behemorph", "Fire",
                                    "Beast", "3", "3", "3",
                                    "1 +", "Uncommon", "When Behemorph is summoned, half the time add 2 to its Attack and it must use its secondary attack.", "Cai-Shae",
                                    "Standard::Arc Barrage", "Arc Blind Back", "");
            addCard(db, 123, "2", "Flameheart", "Fire",
                                    "Beast", "5", "3", "4",
                                    "0", "Uncommon", "Any Earth field within the 2 Fields in front of Flameheart is also treated as a Fire field.<br /><br />Other Allied Creatures gain +2 Magic Protection.<br /><br />Subtract 1 from the Summoning Cost of other allied Fire creatures (minimum 1).", "Dhees Empire",
                                    "No Attack", "None Blind Back", "");
            addCard(db, 311, "3", "Dioskuri", "Biolith",
                                    "Ancient", "12", "3", "5",
                                    "2", "Ultra Rare", "This creature can only be summoned by <i>Incarnation</i> on either allied Pollux or allied Kastor.<br /><br />Dioskuri's <i>Magic Attack</i> targets all enemy creatures.  Dioskuri's Attack is equal to 2 plus both players' combined mana.<br /><br />If you put Dioskuri on top of Pollux to create Dioskuri, the creature steals exit mana from enemies on Biolith fields.<br /><br />If you put Dioskuri on top of Kastor to create Dioskuri, all other allied creatures on Biolith fields gain 1 HP in each Resolution Phase while Dioskuri is on the board.", "Biolith Castle",
                                    "Magic Nuke", "None Blind Back", "1 of card");
            addCard(db, 149, "2", "Novogus Warrior", "Earth",
                                    "Undead", "3", "2", "2",
                                    "2", "Uncommon", "", "Novogus Dynasty",
                                    "Front Back Strike", "Front Back", "");
            addCard(db, 257, "3", "Callous Gaiakhan", "Earth",
                                    "Dragon", "8", "4", "8",
                                    "5+", "Ultra-Rare", "Callous Gaiakhan can only be summoned if 2 or more Earth creatures are on the board.<br /><br />Callous Gaiakhan's Attack is equal to 5 plus the total mana of both players.<br /><br />While Callous Gaiakhan is on a non-Biolith field, all adjacent allies gain +2 <i>Protection</i>.<br /><br />While Callous Gaiakhan is on a non-Biolith field, each time either player gains 1 mana outside of the Mana Charge phase, Gaiakhan deals 1 magic damage to all adjacent enemies.", "",
                                    "Selective Front", "Standard Blind Back", "1 of card");
            addCard(db, 44, "1", "Dark Yokozuna Sekimaru", "Earth",
                                    "Titan", "3", "2", "3",
                                    "2", "Uncommon", "If Dark Yokozuna Sekimaru attacks (but does not destroy) a creature, that creature is pushed back one field in the direction of the attack (provided the field is empty) and cannot counterattack.", "Val na Vos",
                                    "Standard", "Standard Blind Back", "");
            addCard(db, 75, "1", "Imperial Biolith Guard", "Biolith",
                                    "Mech", "3", "2", "4",
                                    "2", "Common", "Gain 1 mana each time you summon a creature to a Biolith field.", "Biolith Castle",
                                    "Left Right Strike", "Left Right", "");
            addCard(db, 166, "2", "Darksword Samurai", "Wood",
                                    "Human", "4", "3", "4",
                                    "1 +", "Rare", "Darksword Samurai's Attack is equal to 1 plus the number of other creatures on the board.<br /><br />Subtract 2 from the Attack of adjacent allied creatures.", "Nagirashu",
                                    "Standard", "Standard Blind Back", "");
            addCard(db, 39, "1", "Stone Wing Dwarf", "Earth",
                                    "Dwarf", "1", "1", "1",
                                    "1", "Common", "Stone Wing Dwarf gains Protection equal to the number of allied Giant Axe Dwarves on the board.", "Hammer Valley",
                                    "Selective Full Circle", "Full", "");
            addCard(db, 144, "2", "Relentless Skeleton", "Earth",
                                    "Undead", "1", "1", "1",
                                    "1", "Common", "While Relentless Skeleton is on a non-Earth field, he gains <i>Resurrection.</i>", "Novogus Dynasty",
                                    "Standard", "Standard Blind Back", "");
            addCard(db, 256, "3", "Captain Xerabis", "Earth",
                                    "Hero", "4", "3", "5",
                                    "2+", "Ultra-Rare", "Xerabis adds 1 to his Attack if any target creature is on an Earth field.<br /><br />While your creatures outnumber enemies, all other allied creatures get +1 <i>Protection</i> and -1 Attack.<br /><br />While another allied Dwarf creature is on the board, Xerabis gains <i>Decoy</i> for all adjacent enemies.", "Novogus Dynasty",
                                    "Full Longrange Strike", "Full", "1 of race");
            addCard(db, 10, "1", "Partmole Fire Oracle", "Fire",
                                    "Demon", "4", "2", "3",
                                    "2", "Uncommon", "If Partmole Fire Oracle is destroyed, all allied creatures on board gain 1 HP.", "Church of Parmus",
                                    "Standard Magic", "None Blind Back", "");
            addCard(db, 261, "3", "Elven Berserker Witch", "Wood",
                                    "Elf", "2", "1", "2",
                                    "1", "Common", "While Elven Berserker Witch has exactly 1 HP, she gets +1 Attack and a <i>Dodge</i> attempt.", "Black Forest",
                                    "Standard Magic", "None Blind Back", "");
            addCard(db, 203, "2", "Festival of Fire", "Spell",
                                    "Dominion", "0", "", "",
                                    "", "Uncommon", "Discard two cards (at least one must be a Fire creature).<br /><br />During your opponent's next turn, add 3 to the Summoning Cost of creatures on non-Fire fields.", "",
                                    "", "", "3 of race");
            addCard(db, 198, "2", "Mesmer's Envoy", "Spell",
                                    "Conjuration", "1", "", "",
                                    "", "Rare", "Draw 3 cards, then shuffle 2 cards from your hand into your library.", "",
                                    "", "", "");
            addCard(db, 152, "2", "Dwarf Warbanner", "Earth",
                                    "Dwarf", "4", "2", "4",
                                    "0", "Uncommon", "All Dwarf creatures subtract 1 from their Attack and gain +1 <i>Protection</i> for each Dwarf creature on the board.", "Hammer Valley",
                                    "No Attack", "None Blind Back", "");
            addCard(db, 205, "2", "Festival of Earth", "Spell",
                                    "Dominion", "0", "", "",
                                    "", "Uncommon", "Discard two creatures (at least one must be a Earth creature).<br /><br />During your opponent's next turn, add 3 to the Summoning Cost of creatures on non-Earth fields.", "",
                                    "", "", "3 of race");
            addCard(db, 279, "3", "Toxic Intruder", "Biolith",
                                    "Mech", "4", "3", "4",
                                    "2", "Uncommon", "After Toxic Intruder attacks (but does not destroy) a creature, the target loses half of its HP (rounded down).", "Biolith Castle",
                                    "Standard", "Standard Blind Back", "");
            addCard(db, 108, "1", "Scion's Riotous Impunity", "Spell",
                                    "Sorcery", "2", "", "",
                                    "", "Rare", "Starting from the center field, all creatures engage in battle, clockwise one at a time.  Playing this card ends your turn.", "",
                                    "", "", "");
            addCard(db, 34, "1", "Imposter Queen Anfisa", "Water",
                                    "Noble", "6", "2", "5",
                                    "2", "Ultra Rare", "When on a water field, Imposter Queen Anfisa gains Possession of all enemies on adjacent fields.", "Tritonan Queendom",
                                    "Standard Magic", "None Blind Back", "1 of race");
            addCard(db, 119, "2", "Flame Lizard Commander", "Fire",
                                    "Lizard", "4", "4", "4",
                                    "3", "Rare", "Gain 1 mana each time you summon an allied Lizard creature.  <br /><br />All other allied Lizard creatures subtract 1 from their Activation Cost.", "Dhees Empire",
                                    "Lancer", "Standard Blind Arc", "");
            addCard(db, 194, "2", "Elven Dismissal", "Spell",
                                    "Conjuration", "0", "", "",
                                    "", "Rare", "X is equal to 1 plus the Summoning Cost of the target creature.<br /><br />Choose a creature adjacent to an allied creature. Return the target creature to its owner's hand.", "",
                                    "", "", "");
            addCard(db, 264, "3", "Juno Spirit Fox", "Wood",
                                    "Beast", "3", "2", "2",
                                    "1", "Uncommon", "Each time an enemy creature adjacent to Juno Spirit Fox is destroyed, your opponent must place the top card of their library into their graveyard.<br /><br />While Juno Spirit Fox is on the board, any Biolith Creature on a non-Biolith field adds 2 to its Activation Cost.<br /><br />While an Exalted Elven Deity is in your graveyard, the maximum number of cards in your opponent's hand is reduced by 1.", "",
                                    "Standard", "Standard Blind Back", "");
            addCard(db, 159, "2", "Tree Foxes", "Wood",
                                    "Beast", "1", "2", "1",
                                    "1", "Common", "When Tree Foxes is summoned, rotate any creature directly in front of it 180 degrees.", "",
                                    "Standard", "Standard Blind Back", "");
            addCard(db, 81, "1", "Taurus Monolith", "Biolith",
                                    "Titan", "5", "3", "6",
                                    "3", "Uncommon", "If Taurus Monolith attacks (but does not destroy) a creature, that creature is pushed back one field in the direction of the attack (provided the field is empty) and cannot counterattack.", "Biolith Castle",
                                    "Lancer", "Standard Blind Back", "");
            addCard(db, 58, "1", "Sleeptrap", "Wood",
                                    "Plant", "2", "1", "2",
                                    "0", "Common", "Enemies on adjacent fields add 1 to their Activation Cost.", "",
                                    "Standard", "Standard Blind Back", "");
            addCard(db, 139, "2", "Aluhja Inquisitrix", "Water",
                                    "Human", "5", "3", "5",
                                    "2", "Rare", "Each time a creature is summoned to a Water field, you may search your library for any number of creatures with the same name as the summoned creature, reveal them and put them into your hand.  Then shuffle your library.  <br /><br />All other allied Church of Parmus creatures gain 1 Dodge attempt.", "Church of Parmus",
                                    "Standard Magic", "None Blind Back", "");
            addCard(db, 138, "2", "Queen's Emissary", "Water",
                                    "Elemental", "5", "3", "3",
                                    "0", "Uncommon", "A Wood field adjacent to Queen's Emissary is also treated as a Water field.<br /><br />Queen's Emissary gains <i>Possession</i> of all enemy creatures on adjacent Water fields.", "Tritonan Queendom",
                                    "No Attack", "None", "");
            addCard(db, 168, "2", "Reaper's Golem", "Wood",
                                    "Elemental", "4", "3", "3",
                                    "1", "Uncommon", "Any Water field within the 2 fields in front of Reaper's Golem is also treated as a Wood field. <br /><br />During your opponent's turn, each time an allied creature is destroyed, choose a creature from your graveyard with 3 or less Summoning Cost that is not Ultra Rare, and shuffle it into your library.<br /><br />All allied Elf creatures on adjacent Wood fields gain Invisibility.", "Til Vorg Monarchy",
                                    "Standard Ranged", "Standard Blind Back", "");
            addCard(db, 46, "1", "Novogus Golem", "Earth",
                                    "Beast", "4", "2", "3",
                                    "2", "Rare", "Novogus Golem gains Protection equal to the number of empty fields.", "Novogus Dynasty",
                                    "Standard", "Standard Blind Back", "");
            addCard(db, 113, "2", "Flame Lizard Archer", "Fire",
                                    "Lizard", "2", "2", "2",
                                    "1", "Common", "Flame Lizard Archer attacks the same target twice.  The target's counterattack occurs after the second attack.", "Dhees Empire",
                                    "Standard Ranged", "Standard Blind Back", "");
            addCard(db, 6, "1", "Great Minos of Sciondar", "Fire",
                                    "Titan", "3", "2 -", "1",
                                    "2", "Rare", "The Activation Cost to attack with Great Minos is 1 less than listed.  Destroy Great Minos if he is on a non-Fire field.", "",
                                    "Lancer", "Standard Blind Back", "");
            addCard(db, 80, "1", "Dragoon Dragon Cavalry", "Biolith",
                                    "Mech", "5", "3", "5",
                                    "3 +", "Uncommon", "Dragoon Dragoon Cavalry attacks the same target twice.  The counterattack of the target creature occurs after the second attack.<br /><br />All enemy dragons subtract 3 from their attack.", "Biolith Castle",
                                    "Standard", "Standard Blind Back", "");
            addCard(db, 32, "1", "Mercenary Savior Latoo", "Water",
                                    "Hero", "3", "2", "3",
                                    "2", "Ultra Rare", "Latoo adds 1 to his Attack if at least one target creature is on a Water field.  While Latoo is on the board, all other allied creatures on Water fields gain one Dodge attempt.", "Tritonan Queendom",
                                    "Lancer", "Standard Blind Back", "1 of race");
            addCard(db, 286, "3", "Pollux", "Biolith",
                                    "Ancient", "4", "3", "4",
                                    "2", "Ultra Rare", "Instead of a rotate action, you may take a Kastor from your library, reveal it, and put it into your hand.  Then shuffle your library.<br /><br />If Kastor is on the board, instead of taking an attack action, you may place Pollux on top of Kastor.  This will create Dioskuri, a creature with the two cards' combined HP, Attack equal to 2 plus both players' combined mana, and a <i>Magic Attack</i> that targets all enemy creatures.<br /><br />If you put Pollus on top of Kastor to create Dioskuri, all other allied creatures on Biolith fields gain 1 HP in each Resolution Phase while Dioskuri is on the board.", "Biolith Castle",
                                    "Standard Magic::Magic Nuke", "None Blind Back", "1 of card");
            addCard(db, 26, "1", "Dancing Temptress", "Water",
                                    "Undead", "3", "2", "1",
                                    "0", "Rare", "If Dancing Temptress is destroyed, you steal 1 mana from the owner of the creature on the field in front of her.  If Dancing Temptress is destroyed, the creature on the field in front of her is moved to the field she was previously on.", "",
                                    "Standard", "Standard Blind Back", "");
            addCard(db, 62, "1", "Swallow Ninja", "Wood",
                                    "Human", "3", "2", "3",
                                    "1", "Uncommon", "Swallow Ninja gains Invisibility while at least one allied Firefly Ninja is on the board.  When Swallow Ninja damages (but does not destroy) a creature, that creature is rotated so that its back faces Swallow Ninja.  The target creature cannot counter.", "Yaksha",
                                    "Lancer", "Standard Blind Back", "");
            addCard(db, 291, "3", "Venoan Hard Bargain", "Spell",
                                    "Ritual", "0", "", "",
                                    "", "Uncommon", "Both players reveal the top card of their libraries for <i>Judgment</i>.  If you win, you gain mana equal to the number of enemy creatures on the board.  If you lose, your opponent gains 1 mana.  If it's a tie, nothing happens.", "",
                                    "", "", "1 of card");
            addCard(db, 221, "3", "Torrid Nightmare", "Fire",
                                    "Demon", "5", "4", "4",
                                    "0", "Uncommon", "Torrid Nightmare's <i>Magic Attack</i> targets all enemies of the same race as the target.<br /><br />If Torrid Nightmare attacks (but does not destroy) a creature, the target loses half of its HP (rounded down).<br /><br />Each time an allied Church of Parmus creature is destroyed, all other allied creatures gain 1 HP.", "Church of Parmus",
                                    "Magic Nuke", "None Blind Back", "");
            addCard(db, 208, "2", "Scion's Revelation", "Spell",
                                    "Sorcery", "1", "", "",
                                    "", "Rare", "Choose creatures from your graveyard that are not Ultra Rare up to the number of cards in your hand.  Discard your hand then return the chosen cards to your hand.<br /><br /><b>Playing this card ends your turn.</b>", "",
                                    "", "", "");
            addCard(db, 226, "3", "Carlo the Scorched", "Fire",
                                    "Noble", "6", "4", "4",
                                    "2+", "Phantom", "While two or more enemy creatures are adjacent to Carlo, he must use his secondary <i>Magic Attack</i> which targets all adjacent enemies.<br /><br />If at least one target is a non-Fire creature, Carloís attack is equal to 2 plus the number of fire fields.<br /><br />Subtract 2 from the attack of any enemy Biolith creatures on non-Biolith fields.<br /><br />All adjacent allied Fire creatures gain Fieldmorph.", "Dhees Empire",
                                    "Standard::Magic Blast", "Standard Blind Back", "1 of race");
            addCard(db, 71, "1", "Exalted Elven Deity", "Wood",
                                    "God", "9", "5", "9",
                                    "3", "Ultra Rare", "Exalted Elven Diety's Magic Attack targets all enemies on non-Wood fields.  Destroy Exalted Elven Dieth if it is on a Biolith field.", "Unknown",
                                    "Magic Nuke", "None", "1 of race");
            addCard(db, 103, "1", "Sciondar Inferno", "Spell",
                                    "Dominion", "0", "", "",
                                    "", "Uncommon", "Discard 2 creatures (at least one must be a Fire creature).  This spell targets all enemies on and adjacent to a selected Fire field.  Target creatures are dealt magic damage equal to the number of Fire fields.", "",
                                    "", "", "3 of race");
            addCard(db, 235, "3", "Siam's Sentinel", "Water",
                                    "Merfolk", "4", "3", "4",
                                    "2", "Uncommon", "While Siam's Sentinel is on a non-Biolith field, all allied creatures with the same orientation as Siam's Sentinel gain <i>Perfect Dodge</i>.", "Siam Pirates",
                                    "Lancer", "Standard Blind Back", "");
            addCard(db, 136, "2", "Okunada Moving Temple", "Water",
                                    "Base", "4", "2", "3",
                                    "1", "Rare", "While Okunada Moving Temple is on a non-Water field, adjacent allied creatures gain <i>Perfect Dodge</i> in your opponent's turn.<br /><br />Destroy Okunada Moving Temple if it is on a Fire field.", "Okunada Monastery",
                                    "Selective Full Circle", "Full", "");
            addCard(db, 303, "3", "Dhees Migration", "Spell",
                                    "Dominion", "0", "", "",
                                    "", "Uncommon", "The target allied creature's element is changed to Fire.  This spell has no effect on creatures that do not belong to any element.", "",
                                    "", "", "3 of race");
            addCard(db, 50, "1", "Arelai the Protector", "Earth",
                                    "Hero", "3", "2", "3",
                                    "2 +", "Ultra Rare", "Arelai gains Protection equal to the number of Earth fields.  Arelai adds 1 to his Attack if at least one target creature is on an Earth field.  All other allied creatures on Earth fields gain +1 Protection.", "Saint Val Devotee",
                                    "Front Back Strike", "Front Back", "1 of race");
            addCard(db, 68, "1", "Edin the Persecuted", "Wood",
                                    "Hero", "3", "2", "3",
                                    "2 +", "Ultra Rare", "Edin adds 1 to her Attack if the target creature is on a Wood field.  All other allied creatures on Wood fields gain Invisibility.", "Northern Forces",
                                    "Standard Magic", "None Blind Back", "1 of race");
            addCard(db, 206, "2", "Festival of Wood", "Spell",
                                    "Dominion", "0", "", "",
                                    "", "Uncommon", "Discard two creatures (at least one must be a Wood creature).<br /><br />During your opponent's next turn, add 3 to the Summoning Cost of creatures on non-Wood fields.", "",
                                    "", "", "3 of race");
            addCard(db, 145, "2", "Far Land Sand Dog", "Earth",
                                    "Beast", "2", "1", "2",
                                    "1", "Common", "Far Land Sand Dog gains <i>Decoy</i> for the enemy directly in front of him. (That enemy can only attack creatures with <i>Decoy</i>)", "Saint Val Devotee",
                                    "Standard Ranged", "Standard Blind Back", "");
            addCard(db, 271, "3", "Ronin Nagirashu", "Wood",
                                    "Human", "6", "4", "5",
                                    "3", "Rare", "If Ronin Nagirashu damages (but does not destroy) a creature, that creature is rotated 180 degrees and cannot counterattack.<br /><br />If Ronin Nagirashu is destroyed on a non-Wood field, count the number of Wood fields; your opponent must take that many cards from the top of their library and put them in their graveyard.<br /><br />While an enemy Biolith creature is on a non-Biolith field, your opponent must discard 1 card in their Resolution Phase.", "Nagirashu",
                                    "90 Degree Right", "90 Degree Right Blind Back", "");
            addCard(db, 234, "3", "Sea Serpent", "Water",
                                    "Dragon", "4", "3", "4",
                                    "1+", "Rare", "Sea Serpent's Attack is equal to 1 plus the number of other Water creatures on the board.<br /><br />While Sea Serpent is on a Water field, all adjacent allied creatures gain one <i>Dodge</i> attempt.<br /><br />While an allied Arboreal Wyrm is on the board, all allied creatures other than itself gain Dragon <i>Invocation</i> with no Summoning Cost.", "Tritonan Queendom",
                                    "Standard Ranged", "Standard Blind Arc", "");
            addCard(db, 101, "1", "Tinoan Telekinesis", "Spell",
                                    "Conjuration", "2", "", "",
                                    "", "Uncommon", "Move 1 allied creature to an empty field without changing its orientation.", "",
                                    "", "", "");
            addCard(db, 222, "3", "Flame Lizard General", "Fire",
                                    "Lizard", "6", "4", "5",
                                    "3+", "Uncommon", "Flame Lizard General's Attack is equal to 3 plus the number of other allied Fire creatures on the board.<br /><br />Subtract 1 from the Summoning Cost of allied creatures summoned to Fire fields within the 2 fields to the front, back, left, or right.  The minimum Summoning Cost is 1.", "Dhees Empire",
                                    "Lancer", "Standard Blind Arc", "");
            addCard(db, 12, "1", "Pursuer of Saint Dhees", "Fire",
                                    "Demon", "6", "6 -", "4",
                                    "5 +", "Rare", "Pursuer of Saint Dhees' Attack is equal to 5 plus the number of other creatures on the board.  The Activation Cost to attack with Pursuer of Saint Dhees is 5 less than listed.", "",
                                    "Standard", "Standard Blind Back", "");
            addCard(db, 29, "1", "Moving Isle of Kadena", "Water",
                                    "Beast", "4", "2", "4",
                                    "1", "Rare", "If Moving Isle of Kadena is summoned to a non-Water field, steal mana from your opponent equal to the number of Water fields.  Destroy Moving Isle of Kadena if it is on a Fire field.", "Tritonan Queendom",
                                    "Selective Full Circle", "Full", "");
            addCard(db, 107, "1", "Blinding Skies", "Spell",
                                    "Dominion", "0", "", "",
                                    "", "Ultra Rare", "Discard 2 creatures (at least one must be a Biolith creature).  This spell targets all enemies on and adjacent to Biolith fields.  Target creatures are dealt magic damage equal to the number of Biolith fields.  Each target creature is only affected once.", "",
                                    "", "", "1 of race");
            addCard(db, 285, "3", "Kastor", "Biolith",
                                    "Ancient", "4", "3", "4",
                                    "2", "Ultra Rare", "Instead of a rotate action, you may take a Pollux from your library, reveal it, and put it into your hand.  Then suffle your library.<br /><br />If Pollux is on the board, instead of taking an attack action, you may place Kastor on top of Pollux.  This will create Dioskuri, a creature with the two cards' combined HP, Attack equal to 2 plus both players' combined mana, and a <i>Magic Attack</i> that targets all enemy creatures.<br /><br />If you put Kastor on top of Pollux to creatue Dioskuri, the creature steals exit mana from enemies on Biolith fields.", "Biolith Castle",
                                    "Selective Front::Magic Nuke", "Standard Blind Back", "1 of card");
            addCard(db, 100, "1", "Summoner Mesmer's Errand", "Spell",
                                    "Conjuration", "1", "", "",
                                    "", "Common", "Draw 2 cards.", "",
                                    "", "", "");
            addCard(db, 142, "2", "Admiral Belta", "Water",
                                    "Warlord", "6", "2", "5",
                                    "1", "Ultra Rare", "Magic Attack targets all enemies on and adjacent to the target Water field.  <br /><br />During your Resolution Phase, fieldquake all Fire fields. <br /><br />Subtract 1 from the Summoning Cost of other allied Water creatures (min 1).", "Tritonan Queendom",
                                    "Magic Blast", "None Blind Back", "1 of race");
            addCard(db, 182, "2", "Battle Master", "Biolith",
                                    "Mech", "6", "4", "6",
                                    "3", "Ultra Rare", "Battle Master attacks the same target twice.  The target's counterattack occurs after the second attack.<br /><br />When Battle Master is summoned, you may take a Scion, Biolith Lord from your library, reveal it to your opponent, and put it into your hand.  Then shuffle your library.<br /><br />Enemies within the 2 fields to the front, back, left, and right of battle master add 2 to their Activation Cost and cannot <i>Dodge</i>", "Biolith Castle",
                                    "Full Longrange Strike", "Full", "1 of card");
            addCard(db, 215, "3", "Lizard Shocktrooper", "Fire",
                                    "Lizard", "3", "2", "3",
                                    "2", "Common", "Each time you declare an attack action with Lizard Shocktrooper, add 1 to its Attack and 1 to its Activation Cost to rotate.", "Dhees Empire",
                                    "Standard", "Standard Blind Back", "");
            addCard(db, 51, "1", "Black Hood Dwarf Vulitra", "Earth",
                                    "Betrayer", "3", "2", "4",
                                    "2 +", "Ultra Rare", "Vulitra adds 1 to his Attack if at least one target creature is an Earth creature.  If Vulitra is destroyed on a non-Earth field, your opponent must discard cards equal to the number of Earth fields.", "Blackhoods",
                                    "Lancer", "Standard Blind Back", "1 of race");
            addCard(db, 49, "1", "Undead Dragon", "Earth",
                                    "Dragon", "7", "4", "8",
                                    "5 +", "Rare", "Undead Dragon's Attack is equal to 5 plus the number of other Earth creatures on the board.  While Undead Dragon is on an Earth field, gain 1 additional mana whenever an adjacent allied creature is destroyed.", "Novogus Dynasty",
                                    "Selective Front", "Standard Blind Back", "");
            addCard(db, 141, "2", "Corleo, Venoan Capo", "Water",
                                    "Betrayer", "5", "3", "4",
                                    "2 +", "Ultra Rare", "Corleo's Attack is equal to 2 plus the number of other allied Corsez Family creatures.<br /><br />Each time an allied creature <i>dodges</i> an attack, steal 1 mana from your opponent for each allied Corsez Family creature.<br /><br />Other allied creatures gain 1 <i>Dodge</i> attempt.", "Corsez Family",
                                    "Standard", "Standard Blind Back", "1 of race");
            addCard(db, 37, "1", "Verzar Canine", "Earth",
                                    "Beast", "1", "1", "1",
                                    "1", "Common", "Allied creatures on adjacent fields gain +1 Protection.", "Val na Vos",
                                    "Standard", "Standard Blind Back", "");
            addCard(db, 102, "1", "Tinoan Teleportation", "Spell",
                                    "Conjuration", "3", "", "",
                                    "", "Uncommon", "Switch the locations of two allied creatures without changing  their orientation.", "",
                                    "", "", "");
            addCard(db, 281, "3", "Biolith Mage Guard", "Biolith",
                                    "Mech", "5", "4", "5",
                                    "2", "Rare", "Biolith Mage Guard's <i>Magic Attack</i> targets all enemies of the same race as the target.<br /><br />When your opponent casts a spell, you may discard 1 spell card from your hand to cancel the action.  Your opponent's Casting Cost is not returned.", "Biolith Castle",
                                    "Magic Nuke", "None Blind Back", "");
            addCard(db, 60, "1", "Samurai Nagirashu", "Wood",
                                    "Human", "2", "2", "2",
                                    "2", "Uncommon", "If Samurai Nagirashu is destroyed on a Wood field, your opponent must discard 1 card.", "Nagirashu",
                                    "Standard", "Standard Blind Back", "");
            addCard(db, 65, "1", "Juno Prisoner Trap", "Wood",
                                    "Plant", "4", "2", "4",
                                    "0", "Uncommon", "When an enemy is summoned to a field adjacent to Juno Prisoner Trap, all other allied creatures gain 1 HP.  Destroy Prisoner Trap if it is on an Earth field.", "Black Forest",
                                    "Selective Full Circle", "Full", "");
            addCard(db, 266, "3", "Arboreal Wyrm", "Wood",
                                    "Dragon", "4", "3", "4",
                                    "1 +", "Rare", "Arboreal Wyrm's Attack is equal to 1 plus the number of other Wood creatures on the board.<br /><br />While Arboreal Wyrm is on a Wood field, adjacent allied creatures get +1 HP.<br /><br />While an allied Flame Wyvern is on the board, all allied creatures other than itself gain Dragon <i>Invocation</i> with no Summoning Cost.", "Til Vorg Monarchy",
                                    "Selective Front", "Standard Blind Arc", "");
            addCard(db, 174, "2", "Lord Hu", "Wood",
                                    "Warlord", "6", "4", "4",
                                    "2", "Ultra Rare", "Lord Hu's Magic Attack targets all enemies on and adjacent to the target Wood field.<br /><br />Each time an enemy is destroyed, you gain 1 mana.  <br /><br />Subtract 1 from the Summoning cost of other allied Wood creatures (minimum 1).", "Til Vorg Monarchy",
                                    "Magic Blast", "None Blind Back", "1 of race");
            addCard(db, 115, "2", "Partmole Axethrower", "Fire",
                                    "Lizard", "3", "3", "2",
                                    "2", "Common", "", "Dhees Empire",
                                    "Arc Longrange Strike", "Arc Blind Back", "");
            addCard(db, 287, "3", "Atomic Rudra", "Biolith",
                                    "Dragon", "6", "3", "5",
                                    "3 +", "Ultra Rare", "Atomic Rudra's Attack is equal to 3 plus the number of other creatures with the same element as the target creature.<br /><br />While Rudra is on the board, any creature on a non-Biolith field loses HP equal to its combined <i>Protection, Magic Protection</i> and <i>Dodge</i> attempts.<br /><br />Each time an allied creature is summoned to a field adjacent to Atomic Rudra, Rudra deals 1 magic damage to all enemy creatures with the same element as the summoned creature.", "Biolith Castle",
                                    "Selective Front", "Standard Blind Back", "1 of card");
            addCard(db, 306, "3", "The New Capital", "Spell",
                                    "Dominion", "0", "", "",
                                    "", "Uncommon", "The target allied creature's element is changed to Wood.  This spell has no effect on creatures that do not belong to any element.", "",
                                    "", "", "3 of race");
            addCard(db, 262, "3", "Jade Mimic", "Wood",
                                    "Egg", "2", "1", "2",
                                    "0", "Rare", "Instead of a rotate action, you may sacrifice Jade Mimic and summon any non-Ultra Rare Wood creature (other than another Jade Mimic) from your graveyard in its place at no Summoning Cost.  The new creature may be placed in any orientation, but cannot attack in the turn it was summoned.  This does not end your turn.", "",
                                    "No Attack", "None", "");
            addCard(db, 76, "1", "Biolith Battle Chariot", "Biolith",
                                    "Weapon", "4", "4", "5",
                                    "3", "Common", "", "Biolith Castle",
                                    "90 Degree Right", "90 Degree Right Blind Back", "");
            addCard(db, 282, "3", "Prototype behemoth", "Biolith",
                                    "Weapon", "5", "2", "5",
                                    "2", "Uncommon", "Each time Prototype Behemoth rotates, all fields with the same element as the field it is on are <i>fieldquaked.</i>", "Biolith Castle",
                                    "Lancer", "Standard Blind Back", "");
            addCard(db, 18, "1", "Red Cubic", "Fire",
                                    "Egg", "1", "1", "1",
                                    "0", "Rare", "Sacrifice Red Cubic to summon a non-cubic Fire creature in its place (facing any direction) without paying the Summoning Cost.  The summoned creature cannot attack on this turn.  This does not end your turn.", "Unknown",
                                    "No Attack", "None Blind Arc", "");
            addCard(db, 70, "1", "Green Erlking Zomba", "Wood",
                                    "Noble", "6", "3", "6",
                                    "3", "Ultra Rare", "Zomba must use its secondary attack while it is on a Wood field.  While Zomba is on a Wood field, each time an allied creature is destroyed, your opponent must discard a card.", "Green Bandits",
                                    "Lancer::Standard", "Standard Blind Back", "1 of race");
            addCard(db, 233, "3", "Aluhja Prioress", "Water",
                                    "Human", "3", "3", "3",
                                    "2", "Uncommon", "When an enemy creature uses a rotate action while Aluhja Prioress is on a non-Biolith field, you may discard 1 creature card from your hand to cancel the action.  Your opponent's Activation Cost is not returned.", "Church of Parmus",
                                    "Standard Magic", "None Blind Back", "");
            addCard(db, 204, "2", "Festival of Water", "Spell",
                                    "Dominion", "0", "", "",
                                    "", "Uncommon", "Discard two creatures (at least one must be a Water creature).<br /><br />During your opponent's next turn, add 3 to the Summoning Cost of creatures on non-Water fields.", "",
                                    "", "", "3 of race");
            addCard(db, 135, "2", "Ship's Surgeon", "Water",
                                    "Merfolk", "4", "2", "4",
                                    "2", "Rare", "Each time an allied Siam Pirates creature dodges an attack, steal 1 mana from your opponent.  <br /><br />Each time an allied Water creature is destroyed, you may search your library for a creature that is not Ultra Rare, reveal it and put it in your hand. Then, shuffle your library.", "Siam Pirates",
                                    "Standard", "Standard Blind Back", "");
            addCard(db, 82, "1", "Aegis Citadel", "Biolith",
                                    "Base", "5", "3", "5",
                                    "1", "Rare", "All other allied creatures of the same element as the field Aegis citadel is on gain Invisibility.", "Biolith Castle",
                                    "Selective Full Circle", "Full", "");
            addCard(db, 4, "1", "Partmole Flame Lizard", "Fire",
                                    "Lizard", "2", "2 -", "2",
                                    "2", "Common", "The Activation Cost to attack with Partmole Flame Lizard is 1 less than listed.", "Dhees Empire",
                                    "Standard", "Standard Blind Back", "");
            addCard(db, 185, "2", "Biolith Temple", "Biolith",
                                    "Base", "7", "5", "7",
                                    "3", "Ultra Rare", "Biolith Temple's Magic Attack targets all enemies of the same race as the target.<br /><br />Each time an enemy is summoned, choose a creature from your graveyard that is not Ultra Rare, and shuffle it into your library.<br /><br />Each time an allied Church of Parmus creature is summoned, you may choose a Church of Parmus creature from your graveyard that is not Ultra Rare, and return it to your hand.<br /><br />If an allied Scion, Biolith Lord is on the board, you steal the exit mana of enemy creatures.", "Biolith Castle",
                                    "Magic Nuke", "None", "1 of card");
            addCard(db, 241, "3", "Capricious Hydromancer", "Water",
                                    "Dragon", "8", "4", "8",
                                    "5+", "Ultra-Rare", "Capricious Hydromancer can only be summoned if 2 or more Water creatures are on the board.<br /><br />Hydromancer's Attack is equal to 5 plus the number of cards in your hand.<br /><br />While Hydromancer is on a non-Biolith field, adjacent allied creatures gain 2 <i>Dodge</i> attempts.<br />While Capricious Hydromancer is on a non-Biolith field, each time either player draws a card outside of their Draw phase, all enemy creatures adjacent to Hydromancer take 1 magic damage.", "",
                                    "Selective Front", "Standard Blind Back", "1 of card");
            addCard(db, 122, "2", "Flame Archmage", "Fire",
                                    "Human", "5", "4", "3",
                                    "2", "Rare", "Flame Archmage's <i>Magic Attack</i> targets all enemies of the same race as the target.<br /><br />Subtract 1 from the Summoning Cost of other allied Church of Parmus creatures (minimum 1).", "Church of Parmus",
                                    "Magic Nuke", "None Blind Back", "");
            addCard(db, 253, "3", "Dark Ozeki Kihomaru", "Earth",
                                    "Titan", "5", "3", "5",
                                    "1+", "Uncommon", "Dark Ozeki Kihomaru's Attack is equal to 1 plus your opponent's current mana.<br /><br />If Dark Ozeki Kihomaru attacks (but does not destroy) a creature, that creature is pushed back one field in the direction of the attack (provided the field is empty) and cannot counterattack.", "Val na Vos",
                                    "Lancer", "Standard Blind Back", "");
            addCard(db, 154, "2", "Visvar Vaas Zealot", "Earth",
                                    "Missionary", "4", "2", "3",
                                    "2", "Uncommon", "You steal the exit mana of enemy Wood creatures.<br /><br />During <b>your opponent's</b> Resolution Phase, your opponent loses mana equal to the number of allied Water Missionary creatures.<br /><br />Subtract 2 from the Summoning Cost of allied Water Missionary creatures (minimum 1).", "Church of Parmus",
                                    "Standard", "Standard Blind Back", "5 of race");
            addCard(db, 289, "3", "Scion Triumphant", "Biolith",
                                    "Noble", "9", "6", "8",
                                    "2", "Ultra Rare", "Scion Triumphant can only be summoned when two or more Biolith creatures are on the board.<br /><br />Magic attack targets all enemies.<br /><br />While Scion Triumphant is on a Biolith field, in your opponent's resolution phase, choose a non-Biolith creature on the board who's summoning cost is less than or equal to the number of Biolith fields and return it to its owners hand.Any empty field is also treated as a Biolith field.", "Biolith Castle",
                                    "Magic Nuke", "None Blind Back", "1 of race");
            addCard(db, 186, "2", "Sciondar Gateway", "Biolith",
                                    "Ancient", "7", "5", "6",
                                    "0", "Ultra Rare", "Each time an enemy is summoned, reveal the top card of your library.  If the revealed card is a Biolith creature, you may summon it immediately if you are able.  If you do not summon it, put it into your graveyard.  That creature cannot attack this turn.<br /><br />Biolith <i>Invocation</i>.<br /><br />Subtract 1 from the Summoning Cost of other allied Biolith creatures (minimum 1).", "Biolith Castle",
                                    "No Attack", "None", "1 of race");
            addCard(db, 227, "3", "Blue Lycanthrope", "Water",
                                    "Anthromorph", "1", "1", "1",
                                    "0+", "Uncommon", "When summoned, <i>half the time</i> Blue Lycanthrope adds 1 to her Attack, gains <i>Perfect Dodge</i> and must use her secondary attack.<br /><br />No player can steal mana if Goddess Tritona is in your graveyard.", "Tritonan Queendom",
                                    "Standard::Selective Front", "Standard Blind Back", "");
            addCard(db, 213, "3", "Fire Witch's Familiar", "Fire",
                                    "Demon", "2", "12", "1+",
                                    "-", "Uncommon", "If the target is an enemy Biolith, Fire Witch's Familiar's Attack is equal to 1 plus the number of enemy Biolith creatures.", "",
                                    "Standard Magic", "None Blind Arc", "");
            addCard(db, 98, "1", "Fissures of Goghlie", "Spell",
                                    "Conjuration", "2", "", "",
                                    "", "Common", "Fieldquake any 1 field.", "",
                                    "", "", "");
            addCard(db, 283, "3", "Scion's Peace", "Biolith",
                                    "Blitz", "6", "2", "7",
                                    "1", "Rare", "Scion's Peace loses 1 HP during each Resolution Phase, unless this would cause it to fall below 1 HP.<br /><br />Scion's Peace adds 1 to its Attack during each Resolution Phase.<br /><br />While Scion's Peace is on a Biolith field, it gains <i>Perfect Dodge</i>", "Biolith Castle",
                                    "Standard Magic", "None", "");
            addCard(db, 187, "2", "Sword of Juno", "",
                                    "Sacred", "6", "4", "5",
                                    "4", "Rare", "Sword of Juno does not belong to any element.<br /><br />Sword of Juno can use Incarnation on any allied non-Biolith creature.<br /><br />Subtract 2 from the Attack of enemy creatures within the 2 fields in front of Sword of Juno.", "Unknown",
                                    "Selective Front", "Standard Blind Back", "");
            addCard(db, 183, "2", "Magic Master", "Biolith",
                                    "Mech", "6", "4", "6",
                                    "2", "Ultra Rare", "Magic Master's magic attack targets all enemies of the same element as the target.<br /><br />Adjacent allied creatures cannot be targeted by spells.<br /><br />All allied Church of Parmus creatures add 1 to their Attack.", "Biolith Castle",
                                    "Magic Nuke", "None Blind Back", "1 of card");
            addCard(db, 175, "2", "Athenix Citadel", "Biolith",
                                    "Base", "3", "2", "4",
                                    "1", "Uncommon", "All other allied creatures of the same element as the field where Athenix Citadel is located gain +1 Magic Protection.", "Biolith Castle",
                                    "Standard Magic", "None", "");
            addCard(db, 302, "3", "Yaksha Disguise", "Spell",
                                    "Conjuration", "0", "", "",
                                    "", "Rare", "Discard a non-Ultra Rare creature from your hand.  Choose a non-Ultra Rare allied creature on the board.  This creature's race changes to that of the discarded creature.", "",
                                    "", "", "");
            addCard(db, 20, "1", "Tritonan Ice Guard", "Water",
                                    "Elemental", "1", "1", "1",
                                    "1", "Common", "When Tritonan Ice Guard is summoned to a non-Water field, draw a card.", "Tritonan Queendom",
                                    "Standard", "Standard Blind Back", "");
            addCard(db, 133, "2", "Ghost Ship", "Water",
                                    "Weapon", "3", "2", "1",
                                    "0", "Common", "Ghost Ship gains <i>Possession</i> of enemy creatures on Water fields within the 2 fields in front of it.", "Unknown",
                                    "No Attack", "None", "");
            addCard(db, 236, "3", "Queen's Commissioner", "Water",
                                    "Elemental", "5", "3", "1",
                                    "2", "Uncommon", "If your mana is less than your opponent's, Queen Commissioner's attack does not damage the target but steals mana equal to the HPs it would have inflicted.  If your opponent's mana was 0, the target loses HPs as normal.<br /><br />Destroy Queen's Commissioner if it is on a non-Water field.", "Tritonan Queendom",
                                    "Standard Magic", "None Blind Back", "");
            addCard(db, 64, "1", "Elven Rider", "Wood",
                                    "Elf", "4", "2", "4",
                                    "2", "Uncommon", "If Elven Rider is destroyed on a non-Wood field, your opponent must discard cards equal to the number of Wood fields.", "Til Vorg Monarchy",
                                    "Lancer", "Standard Blind Back", "");
            addCard(db, 263, "3", "Bewitching Elf Huntress", "Wood",
                                    "Elf", "3", "2", "3",
                                    "1", "Common", "If Bewitching Elf Huntress attacks (but does not destroy) a creature, that creature is moved to the field directly in front of her (provided the field is empty) and cannot counterattack.<br /><br />While an allied Prince Lusirion is on the board, Bewitching Elf Huntress gets +1 HP.", "Til Vorg Monarchy",
                                    "Lancer", "Standard Blind Back", "");
            addCard(db, 212, "3", "Rageflame Spitter", "Fire",
                                    "Bug", "1", "1", "2",
                                    "1", "Common", "Enemy creatures adjacent to Rageflame Spitter cannot be sacrificed.", "",
                                    "Standard", "Standard Blind Back", "");
            addCard(db, 105, "1", "Fist of Verzar", "Spell",
                                    "Dominion", "0", "", "",
                                    "", "Uncommon", "Discard 2 creatures (at least one must be an Earth creature). This spell targets all enemies on and adjacent to a selected Earth field. Target creatures are dealt magic damage equal to the number of Earth fields.", "",
                                    "", "", "3 of race");
            addCard(db, 223, "3", "Partmole Scout Balloon", "Fire",
                                    "Lizard", "6", "4", "6",
                                    "3", "Rare", "While Partmole Scout Balloon is on a non-Fire field, if an enemy creature is summoned within the Attack Zone of any allied Lizard creature, they intercept the summoned enemy creature <i>half the time</i>.<br /><br />While your creatures outnumber enemy creatures on the board, all other allied creatures gain <i>Quickness</i>", "Dhees Empire",
                                    "Selective Full Circle", "Full", "");
            addCard(db, 254, "3", "Blackhood Caravan", "Earth",
                                    "Base", "6", "3", "5",
                                    "2", "Uncommon", "While an allied Dwarf creature is on the board, enemies within 2 fields to the front, back, left and right of Blackhood Caravan cannot <i>Dodge</i>.<br /><br />Each time a field is <i>fieldquaked</i>, any allies within 2 fields to the front, back, left, and right of Blackhood Caravan gain +1 <i>Protection</i>.<br /><br />Destroy Blackhood Caravan if it is on a Wood Field.", "Blackhoods",
                                    "Full Longrange Strike", "Full", "");
            addCard(db, 143, "2", "Verzar Swordsman", "Earth",
                                    "Human", "1", "2", "1",
                                    "2", "Common", "", "Saint Val Devotee",
                                    "Standard", "Standard Blind Arc", "");
            addCard(db, 278, "3", "Biolith Deathgarden", "Biolith",
                                    "Base", "4", "2", "5",
                                    "0", "Rare", "If your opponent does not summon a creature during their turn, you receive mana equal to the number of Biolith fields in their Resolution Phase.<br /><br />Adjacent allied Plant creatures get +1 Attack.<br /><br />all allied Plant creatures gain 1 HP in each Resolution Phase.", "Biolith Castle",
                                    "No Attack", "None Blind Back", "");
            addCard(db, 110, "1", "Call of Timeless Juno", "Spell",
                                    "Sorcery", "5", "", "",
                                    "", "Rare", "Exchange two fields.  Creatures remain in the same location while the fields are exchanged.  Playing this card ends your turn.", "",
                                    "", "", "");
            addCard(db, 170, "2", "Alchemist's Lab", "Wood",
                                    "Base", "5", "3", "4",
                                    "2", "Uncommon", "While Alchemist's Lab is on a non-Wood field, each time your opponent summons a creature to an adjacent field, they put the top card of their library into their graveyard.<br /><br />Allied Elf creatures cannot be targeted by spells.<br /><br />Destroy Alchemist's Lab if it is on an Earth field.", "Black Forest",
                                    "Standard Magic", "None", "");
            addCard(db, 301, "3", "Yaksha Stimulants", "Spell",
                                    "Conjuration", "4", "", "",
                                    "", "Common", "Switch the HP and Attack of the target creature.", "",
                                    "", "", "");
            addCard(db, 247, "3", "Dwarf Miner", "Earth",
                                    "Dwarf", "3", "2", "3",
                                    "1", "Uncommon", "Each tiem a field adjacent to Dwarf Miner is <i>fieldquaked</i>, you gain 1 mana.<br /><br />If Dwarf Miner attacks while adjacent to an allied Dwarf creature, the target's field is <i>fieldquaked</i> and the target creature cannot couterattack.", "Hammer Valley",
                                    "Standard", "Standard Blind Back", "");
            addCard(db, 56, "1", "Green Lycanthrope", "Wood",
                                    "Anthromorph", "1", "1", "1 +",
                                    "0 +", "Common", "When Green Lycanthrope is summoned, half the time add 3 to its HP and 2 to its Attack.", "Til Vorg Monarchy",
                                    "Standard", "Standard Blind Back", "");
            addCard(db, 131, "2", "Siam's Lookout", "Water",
                                    "Merfolk", "3", "1", "3",
                                    "1", "Common", "Each time an allied creature is summoned, draw a card then shuffle a card from your hand into your library.", "Siam Pirates",
                                    "Standard", "Standard Blind Back", "");
            addCard(db, 55, "1", "Leapfrog Bandit", "Wood",
                                    "Anthromorph", "1", "1", "1",
                                    "1", "Common", "If Leapfrog Bandit is destroyed on a non-Wood field, your opponent must discard 1 card.", "Green Bandits",
                                    "Standard Ranged", "Standard Blind Back", "");
            addCard(db, 298, "3", "Drunken Demolition", "Spell",
                                    "Conjuration", "3", "", "",
                                    "", "Common", "<i>Fieldquake</i> any one field and the adjacent field in front of it.", "",
                                    "", "", "");
            addCard(db, 173, "2", "Preacher Noova", "Wood",
                                    "Betrayer", "5", "4", "4",
                                    "3", "Ultra Rare", "Each time a Green Bandits creature is summoned to an adjacent field, your opponent puts the top card of their library into their graveyard.<br /><br />Each time a non-Wood enemy is destroyed, choose a Green Bandits creature from your graveyard that is not Ultra Rare and return it to your hand.", "Green Bandits",
                                    "Standard Magic", "None Blind Back", "1 of race");
            addCard(db, 249, "3", "Roving Penitentiary", "Earth",
                                    "Base", "3", "2", "4",
                                    "1", "Common", "If Roving Penitentiary is destroyed on a Fire, Water or Biolith field, you gain mana equal to the total <i>Protection</i> of all adjacent allied creatures.<br /><br />While Novogus Gravekeeper is in your graveyard, enemy creatures cannot <i>Dodge</i>.<br />Destroy Roving Penitentiary if it is on a Wood field.", "Novogus Dynasty",
                                    "Selective Full Circle", "Full", "");
            addCard(db, 207, "2", "Biolith Ascension", "Spell",
                                    "Dominion", "0", "", "",
                                    "", "Ultra Rare", "Choose one allied non-Biolith creature.  You  may sacrifice the target creature to summon a Biolith creature in its place (facing any direction) without paying the Summoning Cost.<br /><br />The summoned creature cannot attack this turn.<br /><br />This does not end your turn.", "",
                                    "", "", "1 of race");
            addCard(db, 52, "1", "Undead King Novogus", "Earth",
                                    "Noble", "6", "3", "6",
                                    "2", "Ultra Rare", "If Undead King Novogus is on a non-Earth field and damages a creature, fieldquake the target creature's field.  The target creature cannot counterattack.", "Novogus Dynasty",
                                    "Standard Magic", "None Blind Back", "1 of race");
            addCard(db, 94, "1", "Beguiling Fog", "Spell",
                                    "Conjuration", "0", "", "",
                                    "", "Common", "Rotate target creature in any direction.", "",
                                    "", "", "");
            addCard(db, 72, "1", "Green Cubic", "Wood",
                                    "Egg", "1", "1", "1",
                                    "0", "Rare", "Sacrifice Green Cubic to summon a non-cubic Wood creature in its place (facing any direction) without paying the Summoning Cost.  The summoned creature cannot attack this turn.  This does not end your turn.", "Unknown",
                                    "No Attack", "None Blind Arc", "");
            addCard(db, 130, "2", "Venoan Spy", "Water",
                                    "Merfolk", "2", "2", "2",
                                    "1", "Uncommon", "Each time another allied creature is destroyed, draw a card.", "Corsez Family",
                                    "Standard", "Standard Blind Back", "");
            addCard(db, 252, "3", "Novogus War Mammoth", "Earth",
                                    "Beast", "5", "3", "5",
                                    "2", "Uncommon", "While Novogus War Mammoth is on a non-Earth field, it must use its secondary attack.<br /><br />After Novogus War Mammoth attacks, all target creatures' fields are <i>fieldquaked.</i>.  Target creatures cannot counterattack.", "Novogus Dynasty",
                                    "Standard::Lancer", "Standard Blind Back", "");
            addCard(db, 251, "3", "Blackhood Anti-Mystic", "Earth",
                                    "Dwarf", "4", "3", "4",
                                    "2+", "Common", "Blackhod Anti-Mystic adds 1 to his Attack if at least one target creature has a <i>Magic Attack</i>.<br /><br />Each time an allied creature is summoned to a Biolith field, <i>fieldquake</i> that field.<br /><br />While an allied Blackhood Caravan is on the board, all allied Dwarf creatures gain +2 <i>Magic Protection</i>.", "Blackhoods",
                                    "Lancer", "Standard Blind Back", "");
            addCard(db, 27, "1", "Venoan Assassin", "Water",
                                    "Human", "3", "2", "3",
                                    "2", "Common", "Venoan Assassin always attacks the back of its target.", "Corsez Family",
                                    "Standard", "Standard Blind Back", "");
            addCard(db, 296, "3", "Parmetic Castigation", "Spell",
                                    "Conjuration", "0", "", "",
                                    "", "Rare", "Discard a creature.  Choose an enemy creature adjacent to an allied creature.  That creature takes magic damage equal to your opponent's current mana.", "",
                                    "", "", "");
            addCard(db, 17, "1", "Sciondar Fire God", "Fire",
                                    "God", "9", "5", "9",
                                    "3", "Ultra Rare", "Sciondar Fire God's Magic Attack targets all enemies on non-Fire fields.  Destroy Sciondar Fire God if he is on a Biolith Field.", "Unknown",
                                    "Magic Nuke", "None", "1 of race");
            addCard(db, 179, "2", "Behemoth Terrorformer", "Biolith",
                                    "Weapon", "4", "2", "4",
                                    "1", "Uncommon", "After Behemoth Terrorformer attacks a creature, exchange its field with the target's field.", "Biolith Castle",
                                    "Selective Arc", "Arc Blind Back", "");
            addCard(db, 171, "2", "Elven Night Rider", "Wood",
                                    "Elf", "5", "4", "4",
                                    "2 +", "Rare", "Elven Night Rider's Attack is equal to 2 plus the number of Elf creatures on the board.<br /><br />While Elven Night Rider is on a non-Wood field, each time an allied Elf creature is destroyed, Elven Night Rider gains 1 HP.<br /><br />Enemies within the 2 fields in front of Elven Night Rider cannot <i>Dodge</i>.", "Black Forest",
                                    "Lancer", "Standard Blind Back", "");
            addCard(db, 228, "3", "Cloudrunner Shipmate", "Water",
                                    "Merfolk", "1", "2", "2",
                                    "1", "Common", "Each time Cloudrunner Shipmate is rotated, draw a card.<br /><br />While an allied Siam, Traitor of the Seas is on the board, subtract 1 from Cloudrunner Shipmate's Activation Cost to rotate.", "Siam Pirates",
                                    "Standard Ranged", "Standard Blind Back", "");
            addCard(db, 300, "3", "Aluhja Seduction", "Spell",
                                    "Conjuration", "2", "", "",
                                    "", "Common", "Rotate the target creature and all other creatures of the same element owned by the same player so that they have the same orientation.", "",
                                    "", "", "");
            addCard(db, 30, "1", "Don of Venoa", "Water",
                                    "Titan", "5", "3", "3",
                                    "2", "Rare", "While on a Water field, Don must use his sceondary attack.  Don gains one Dodge attempt for each adjacent enemy.  Adjacent allied creatures gain one Dodge attempt.", "Corsez Family",
                                    "Front Back Strike::Full Circle Barrage", "Full", "");
            addCard(db, 53, "1", "Novogus Gravekeeper", "Earth",
                                    "God", "9", "5", "9",
                                    "3", "Ultra Rare", "Novogus Gravekeeper's Magic Attack targets all enemies on non-Earth fields.  Destroy Novogus Gravekeeper if it is on a Biolith field.", "Unknown",
                                    "Magic Nuke", "None", "1 of race");
            addCard(db, 19, "1", "Monk Elder of Okunada", "Water",
                                    "Merfolk", "1", "1", "1",
                                    "0", "Common", "All allied creatures on adjacent fields gain one Dodge attempt.", "Okunada Monastery",
                                    "Standard", "Standard Blind Back", "");
            addCard(db, 78, "1", "Biolith Ninja", "Biolith",
                                    "Mech", "4", "2", "4",
                                    "2", "Rare", "While Biolith Ninja is on a Biolith field, it gains Perfect Dodge.  Biolith Ninja always attacks the back of its target.", "Biolith Castle",
                                    "Standard", "Standard Blind Back", "");
            addCard(db, 211, "3", "Partmole Gatekeeper", "Fire",
                                    "Demon", "1", "2", "1",
                                    "1+", "Common", "Partmole Gatekeeper adds 1 to its Attack if at least one target creature is on a water field.<br /><br />If no enemy creatures are on the board, add 1 to the Summoning Cost of an enemy creature summoned 1 or 2 fields in front of Partmole Gatekeeper", "Dhees Empire",
                                    "90 Degree Right", "90 Degree Right Blind 90 Degree", "");
            addCard(db, 260, "3", "Slumbertrap", "Wood",
                                    "Plant", "1", "1", "1",
                                    "1", "Common", "When you summon Slumbertrap, your opponent must show you their current hand.<br /><br />If an allied Sleeptrap is on the board, all allied Plant creatures add 1 to their Attack in your Resolution Phase.", "",
                                    "Standard", "Standard Blind Back", "");
        }

        private void addDefinitions(SQLiteDatabase db) {
            db.execSQL(DEFINITIONS_TABLE_CREATE);

            // GENERATED CODE, CHANGE IN data:android:definitions TASK
            addDefinition(db, "Activation Cost", "The amount of mana you must spend to make one of your creatures attack or turn 90º on its field.");
            addDefinition(db, "Adjacent", "A neighboring field, on the horizontal or vertical axis (not diagonal).");
            addDefinition(db, "Affiliation", "A creature group label used to trigger certain special rules and combos. For example: Flame Magus and Aluhja Priestess are both affiliated to the Church of Parmus.");
            addDefinition(db, "Attack", "All creatures have an Attack score. This is the amount of damage it inflicts (Hit Points deducted) when it attacks another creature. An attack may be either physical or a Magic Attack.");
            addDefinition(db, "Attack Zones", "The fields that a creature can attack with respect to its location and orientation. The black box shows the creature’s location on the board with the white side at the front. Red arrows show default target(s), pink arrows are optional targets. For Magic Attacks a pink arrow on a purple burst indicates that the field will be targeted if conditions are met.");
            addDefinition(db, "Blind side", "If a creature is attacked from a field on its blind side, the attacker gains a +1 bonus to its Attack. The blind side is often located to a creature’s rear but this is not always the case. Some creatures have multiple blind sides, while others have none at all.");
            addDefinition(db, "Board", "The playing area, consisting of 9 fields.");
            addDefinition(db, "Deck", "Each player must have a deck of 30 Summoning Cards to play THE EYE OF JUDGMENT™.");
            addDefinition(db, "Decoy", "A creature with the decoy ability distracts affected enemy creatures so that they can only target creatures with decoy. Note: if a creature with a multi-field Attack Zone targets the decoy creature, it will attack all creatures in the other default fields as well.");
            addDefinition(db, "Defense Zones", "Each of the four fields adjacent to a creature can be described as strong (the creature can counterattack if attacked from this field), weak (it cannot counterattack) or blind (it cannot counterattack and its attacker gains a +1 Attack bonus). The black box shows the creature’s location on the board with the white side at the front. A blue arrow indicates a strong field, white fields are weak and B is blind.");
            addDefinition(db, "Destroyed", "When one of your creatures on the board reaches zero Hit Points, it must be put into your Graveyard. This normally gives you 1 point of exit mana.");
            addDefinition(db, "Discard", "Placing a card from your hand into your graveyard.");
            addDefinition(db, "Dodge", "A creature with Dodge avoids all damage from physical attacks half the time. A creature may have more than one Dodge attempt – only one needs to succeed to negate all damage.");
            addDefinition(db, "Draw", "Taking a card from your library into your hand.");
            addDefinition(db, "Element", "There are five elements in THE EYE OF JUDGMENT™: the four Prime Elements (Fire, Water, Earth and Wood) and Biolith. Fire is the opposite of Water; Earth is the opposite of Wood; Biolith has no opposite.");
            addDefinition(db, "Enemy creature", "Any creature owned by your opponent.");
            addDefinition(db, "Exit mana", "When one of your creatures is destroyed, you receive 1 mana. Some creatures in BIOLITH REBELLION SET 2 have the ability to steal or deprive the opposing player of exit mana.");
            addDefinition(db, "Field", "There are 9 Fields arranged in a 3 x 3 grid to form the board. Field tiles are double-sided and show an element on each side.");
            addDefinition(db, "Field bonus", "A creature’s Hit Points are increased (+2) while it occupies a field that matches its element.");
            addDefinition(db, "Field order", "The position of each field is numbered as follows:  1 2 3  4 5 6  7 8 9  When several events need to be resolved at the same time, they are worked out in field order.");
            addDefinition(db, "Field penalty", "A creature’s Hit Points are reduced (-2) while it occupies a field whose element is the opposite of its own.");
            addDefinition(db, "Fieldmorph", "The target field becomes the same element as the creature occupying it. Fieldmorph is lost if the creature is moved from the field.");
            addDefinition(db, "Fieldquake", "An effect that causes a field tile to be flipped over to its reverse side.");
            addDefinition(db, "Fortress", "A Fortress cannot attack. It may counterattack, if able to do so.");
            addDefinition(db, "Graveyard", "A face-up card pile where you must place any of your cards that are discarded, sacrificed, destroyed or cast (spells).");
            addDefinition(db, "Half the time", "Literally, a 50% chance that something will happen.");
            addDefinition(db, "Hand", "The cards held by a player and kept hidden from his opponent. You start with a hand of 5 cards and may never hold more than 7 cards at the end of your turn.");
            addDefinition(db, "Hit Points (HPs)", "Used to measure a creature’s life. Hit Points are reduced when a creature takes damage from an attack or spell. When a creature’s HPs reach zero, it is destroyed.");
            addDefinition(db, "Incarnation", "Incarnation is a form of summoning. A creature with Incarnation may be brought onto the board on top of an existing allied creature of the same element. You must sacrifice the allied creature on the board to summon the new creature onto that field, paying the difference between the Summoning Cost of the new creature and that of the sacrificed creature. The summoned creature cannot attack on the turn it is summoned, but this does not end your turn. You cannot use Incarnation to summon a creature of the same name as the one you sacrifice. Any power that is triggered by summoning will also be triggered by Incarnation.");
            addDefinition(db, "Intercept", "Every time a new enemy creature is summoned, a creature with this ability attacks at no Activation Cost the summoned enemy half the time before it can make its attack. This happens if the enemy is within the intercepting creature’s Attack Zone, and is not treated as an Activation.");
            addDefinition(db, "Invisibility", "When a creature gains Invisibility it avoids all damage from physical and Magic Attacks and spells which cause direct damage.");
            addDefinition(db, "Invocation", "Lets you incarnate (see incarnation) a creature onto another creature of the same element / race etc. However, you cannot summon the same creature as one that was summoned in this turn or with the same name as the sacrificed creature.");
            addDefinition(db, "Library", "The deck of 30 cards that you draw from throughout the game. Shuffled and placed face down at the start of the game.");
            addDefinition(db, "Location", "The field that a creature is standing on.");
            addDefinition(db, "Magic Attack", "Unless otherwise stated on the card, a Magic Attack targets 1 enemy creature of your choice. Magic Attacks cannot be counter-attacked and are not affected by Dodge attempts or Protection.");
            addDefinition(db, "Magic Protection", "This functions like Protection but only protects against Magic Attack (not physical) damage.");
            addDefinition(db, "Mana", "Magical energy used for summoning and activating creatures, and casting spells. You receive 2 points of mana in the second phase of your turn. When one of your creatures is destroyed, you receive 1 point of exit mana.");
            addDefinition(db, "Mulligan", "Before starting the duel, if you are not happy with your hand of 5 cards, you can shuffle them back into your library and draw another 5 cards. You can only do this once per game.");
            addDefinition(db, "Orientation", "The direction a creature is facing with the top edge of the card always considered to be the front. Orientation must be considered when working out a creature’s Attack and Defense Zones.");
            addDefinition(db, "Owner", "The owner of the card remains the same throughout the duel, even if a creature is possessed.");
            addDefinition(db, "Perfect Dodge", "A creature with Perfect Dodge avoids all damage from physical attacks all the time.");
            addDefinition(db, "Phase", "A player’s turn is divided into 5 phases which must be carried out in order: 1) Draw card 2) Mana charge 3) Actions/Spells 4) Summon a creature 5) Turn Resolution.");
            addDefinition(db, "Physical Attack", "All attacks cause physical damage unless the attack is specified as a Magic Attack. Physical attacks can be reduced by Protection or negated completely by a successful Dodge attempt.");
            addDefinition(db, "Possession", "When you gain Possession of an enemy creature you can activate it in your actions phase as if it were one of your own creatures. The possessed creature cannot be activated by its original owner. Creatures that are possessed upon summoning do not carry out their initial attack. A possessed creature cannot be activated on the turn it is possessed. Creatures with the power of Possession may themselves be possessed.");
            addDefinition(db, "Prayer", "Creatures affected by prayer cannot dodge by any means.");
            addDefinition(db, "Protection", "When a creature has Protection, the damage from a physical attack is reduced by the amount of that protection. For example, Protection +2 would reduce an Attack of 4 to an Attack of 2. In the case of a creature that attacks more than once, each attack is reduced by the Protection.");
            addDefinition(db, "Quickness", "A creature with Quickness counterattacks before the attack of a creature without Quickness. Attacking a creature with Quickness can be dangerous – if the counterattack destroys the attacking creature, it cannot attack at all. If both attacker and target have Quickness, the attacker attacks first as normal.");
            addDefinition(db, "Race", "A creature group label used to trigger certain special rules and combos. For example: Dancing Temptress and Skeleton Soldier are both of the Undead race.");
            addDefinition(db, "Resurrection", "If a creature with this ability is destroyed and you hold a duplicate of it in your hand, you may summon the duplicate to the previously occupied field by spending 1 mana. This summoning occurs in your opponent’s turn and the summoned creature does not receive a free attack.");
            addDefinition(db, "Return", "If a creature is destroyed, you may return it to your hand (instead of the graveyard) by paying 1 mana. Note: all the rules for creature destruction apply even if the creature is returned, including exit mana.");
            addDefinition(db, "Sacrifice", "You must remove one of your creatures from the board and put it into your graveyard. Unlike creature destruction, this does not generate exit mana.");
            addDefinition(db, "Spell", "A magical effect that may be cast in your actions phase. Spells may help you and/or your creatures or harm your opponent. When a spell’s effects have been resolved, its card is put into your graveyard.");
            addDefinition(db, "Summoning Cards", "THE EYE OF JUDGMENT™ creature and spell cards are collectively known as Summoning Cards.");
            addDefinition(db, "Summoning Cost", "The amount of mana that you must spend to summon a creature or cast a spell.");
            addDefinition(db, "Summoning Lock", "The summoning lock is lifted when there are a total of 4 or more creatures on the board. Creatures with the padlock icon cannot be summoned until the summoning lock is lifted. Biolith creatures ignore the summoning lock if they are summoned to a Biolith field.");
            addDefinition(db, "Turn", "A player’s turn consists of 5 phases.");
        }
        
        private void addDefinition(SQLiteDatabase db, String name, String definition) {
            ContentValues initialValues = new ContentValues();
            initialValues.put("name", name);
            initialValues.put("description", definition);
            db.insert("definitions", null, initialValues);
        }

        private void addCard(SQLiteDatabase db, int number, String set, String title, String element,
        			String race, String summoning_cost, String activation_cost, String health_points,
        			String attack, String rarity, String body, String affiliation, 
        			String attack_direction, String defence_direction, String limit) {
            ContentValues initialValues = new ContentValues();
            initialValues.put("number", number);
            initialValues.put("set", set);
            initialValues.put("title", title);
            initialValues.put("element", element);
            initialValues.put("race", race);
            initialValues.put("summoning_cost", summoning_cost);
            initialValues.put("activation_cost", activation_cost);
            initialValues.put("health_points", health_points);
            initialValues.put("attack", attack);
            initialValues.put("rarity", rarity);
            initialValues.put("body", body);
            initialValues.put("affiliation", affiliation);
            initialValues.put("attack_direction", attack_direction);
            initialValues.put("defence_directions", defence_direction);
            initialValues.put("limit", limit);
            db.insert("cards", null, initialValues);
        }
    }

    /**
     * Constructor - takes the context to allow the database to be
     * opened/created
     * 
     * @param ctx the Context within which to work
     */
    public DatabaseAdapter(Context ctx) {
        this.mCtx = ctx;
    }

    /**
     * Open the cards database. If it cannot be opened, try to create a new
     * instance of the database. If it cannot be created, throw an exception to
     * signal the failure
     * 
     * @return this (self reference, allowing this to be chained in an
     *         initialization call)
     * @throws SQLException if the database could be neither opened or created
     */
    public DatabaseAdapter open() throws SQLException {
        mDbHelper = new DatabaseHelper(mCtx);
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }
    
    public void close() {
        mDbHelper.close();
    }

    /**
     * Return a Cursor over the list of all cards in the database
     * 
     * @return Cursor over all cards
     */
    public Cursor fetchAllCards() {
        return mDb.query(CARDS_TABLE, new String[] {"_id", "name",
                "number"}, null, null, null, null, null);
    }

    /**
     * Return a Cursor positioned at the card that matches the given rowId
     * 
     * @param rowId id of note to retrieve
     * @return Cursor positioned to matching card, if found
     * @throws SQLException if note could not be found/retrieved
     */
    public Cursor fetchCard(long rowId) throws SQLException {
        Cursor mCursor =
                mDb.query(true, CARDS_TABLE, new String[] {"_id",
                        "name", "number"}, "_id" + "=" + rowId, null,
                        null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    /**
     * Return a Cursor over the list of all definitions in the database
     *
     * @return Cursor over all cards
     */
    public Cursor fetchAllDefinitions() {
        return mDb.query(DEFINITIONS_TABLE, new String[] {"_id", "name",
                "description"}, null, null, null, null, null);
    }

    /**
     * Return a Cursor positioned at the card that matches the given rowId
     *
     * @param rowId id of note to retrieve
     * @return Cursor positioned to matching card, if found
     * @throws SQLException if note could not be found/retrieved
     */
    public Cursor fetchDefinition(long rowId) throws SQLException {
        Cursor mCursor =
                mDb.query(true, DEFINITIONS_TABLE, new String[] {"_id",
                        "name", "description"}, "_id" + "=" + rowId, null,
                        null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
}