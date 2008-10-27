package mobi.playeoj.android;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PlayEOJ extends ListActivity {
	
    private static final int MENU_ALL_CARDS = 0;

    private String[] mStrings = {
     	"All Cards", "By Element", "By Race", "By Affiliation", "Glossary", "About"
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Use an existing ListAdapter that will map an array of strings to TextViews
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mStrings));
        getListView().setTextFilterEnabled(true);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        switch(position) {
        case MENU_ALL_CARDS:
            Log.w("onListItemClick", "user wants all cards");
            break;
        }
    }
}