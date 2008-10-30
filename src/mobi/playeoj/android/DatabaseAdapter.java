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
                    + "name string not null, number integer not null);";
    private static final String DEFINITIONS_TABLE_CREATE =
        "create table definitions (_id integer primary key autoincrement, "
                + "name string not null, description text not null);";

    private static final String DATABASE_NAME = "play_eoj";
    private static final String CARDS_TABLE = "cards";
    private static final String DEFINITIONS_TABLE = "definitions";
    private static final int DATABASE_VERSION = 3;

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
            // TODO: add all cards
            db.execSQL(CARDS_TABLE_CREATE);
        }

        private void addDefinitions(SQLiteDatabase db) {
            // TODO: add all definitions
            db.execSQL(DEFINITIONS_TABLE_CREATE);

            // GENERATED CODE, CHANGE IN data:android TASK
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