package mobi.playeoj.android;

import mobi.playeoj.android.model.Card;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListCards extends ListActivity {
    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Play EoJ >> Cards");
        
        // Use an existing ListAdapter that will map an array of strings to TextViews
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Card.ALL_TITLES));
        getListView().setTextFilterEnabled(true);
    }
    
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent i = new Intent(this, ShowCard.class);
        startActivity(i);
    }
}
