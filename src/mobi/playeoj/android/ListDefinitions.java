package mobi.playeoj.android;

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

        // Get all of the rows from the database and create the item list
        mDbHelper = new DatabaseAdapter(this);
        mDbHelper.open();
        fillData();

        getListView().setTextFilterEnabled(true);
    }
    
    private void fillData() {
        // Get all of the rows from the database and create the item list
        mCursor = mDbHelper.fetchAllDefinitions();
        startManagingCursor(mCursor);
        
        // Create an array to specify the fields we want to display in the list (only TITLE)
        String[] from = new String[]{"name"};

        // and an array of the fields we want to bind those fields to (in this case just text1)
        int[] to = new int[]{};
        
        // Now create a simple cursor adapter and set it to display
        SimpleCursorAdapter notes = 
        	    new SimpleCursorAdapter(this, R.layout.definitions_list, mCursor, from, to);
        setListAdapter(notes);
    }
    
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        
        mCursor = mDbHelper.fetchDefinition(id);
    }
}
