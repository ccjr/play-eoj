package mobi.playeoj.android;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ListDefinitions extends ListActivity {

    private DatabaseAdapter mDbHelper;
    private Cursor mCursor;
    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setTitle("Play EoJ >> Glossary");
        
        // Get all of the rows from the database and create the item list
        mDbHelper = new DatabaseAdapter(this);
        mDbHelper.open();
        fillData();
    }
    
    private void fillData() {
        // Get all of the rows from the database and create the item list
        mCursor = mDbHelper.fetchAllDefinitions();
        startManagingCursor(mCursor);
        
        // Now create a simple cursor adapter and set it to display
        SimpleCursorAdapter definitions = 
        	    new SimpleCursorAdapter(this, 
        	    		android.R.layout.simple_list_item_1, 
        	    		mCursor, 
        	    		new String[]{DatabaseAdapter.DEFINITION_KEY_NAME}, 
        	    		new int[]{android.R.id.text1});
        setListAdapter(definitions);
    }
    
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        
        mCursor = mDbHelper.fetchDefinition(id);
        startManagingCursor(mCursor);

        String description = mCursor.getString(
            mCursor.getColumnIndexOrThrow(DatabaseAdapter.DEFINITION_KEY_DESCRIPTION));
        String name = mCursor.getString(
            mCursor.getColumnIndexOrThrow(DatabaseAdapter.DEFINITION_KEY_NAME));

        new AlertDialog.Builder(ListDefinitions.this)
            .setMessage(name + ": " + description).show();
    }
}
