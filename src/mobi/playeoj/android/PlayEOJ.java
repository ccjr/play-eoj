package mobi.playeoj.android;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class PlayEOJ extends ListActivity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Use an existing ListAdapter that will map an array
        // of strings to TextViews
        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, mStrings));
        getListView().setTextFilterEnabled(true);
    }

    private String[] mStrings = {
    	"All Cards", "By Element", "By Race", "By Affiliation", "Glossary", "About"
    };
}