package mobi.playeoj.android;

import mobi.playeoj.android.model.Definition;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListDefinitions extends ListActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Play EoJ >> Glossary");
        
        // Use an existing ListAdapter that will map an array of strings to TextViews
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Definition.ALL_DESCRIPTIONS));
        getListView().setTextFilterEnabled(true);
    }
        
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        
        Definition definition = Definition.ALL_DEFINITIONS[position];
        new AlertDialog.Builder(ListDefinitions.this)
            .setMessage(definition.getName() + ": " + definition.getDescription()).show();
    }
}
