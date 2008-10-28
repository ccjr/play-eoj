package mobi.playeoj.android;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseAdapter {

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
    private static final int DATABASE_VERSION = 1;

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

            // add some data for testing
            addDefinition(db, "Quickness", "Lorem ipsum dolor sit..");
            addDefinition(db, "Magic Attack", "Lorem ipsum dolor sit..");
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