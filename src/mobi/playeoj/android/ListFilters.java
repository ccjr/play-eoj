package mobi.playeoj.android;

import mobi.playeoj.android.model.Card;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListFilters extends ListActivity {

    private String[] mFilters;
    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Play EoJ >> Filter cards");
        
        // Use an existing ListAdapter that will map an array of strings to TextViews
        mFilters = Card.ELEMENTS;
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mFilters));
        getListView().setTextFilterEnabled(true);
    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        
        // Nothing for the time being        
    }

    public void setFilters(String[] filters) {
        mFilters = filters;
    }
}
