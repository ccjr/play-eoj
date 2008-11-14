package mobi.playeoj.android;

import mobi.playeoj.android.model.Card;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListFilters extends ListActivity {

    private String[] mFilters;
    private String mField;
    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Play EoJ >> Filter cards");
        
        mFilters = (String[])this.getIntent().getExtras().get("filter");
        mField = this.getIntent().getExtras().getString("field");
        
        // Use an existing ListAdapter that will map an array of strings to TextViews
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mFilters));
        getListView().setTextFilterEnabled(true);
    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        
        String selected = ((TextView)v).getText().toString();
        String[] cards = Card.list(mField, selected);

        Intent i = new Intent(this, ListCards.class);
        i.putExtra("cards", cards);
        startActivity(i);
    }
}
