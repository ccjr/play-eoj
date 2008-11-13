package mobi.playeoj.android;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListCards extends ListActivity {
    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Play EoJ >> Cards");
        
        String[] cards = (String[])this.getIntent().getExtras().get("cards");
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cards));
        getListView().setTextFilterEnabled(true);
    }
    
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String title = ((TextView)v).getText().toString();
        Intent i = new Intent(this, ShowCard.class);
        i.putExtra("title", title);
        startActivity(i);
    }
}
