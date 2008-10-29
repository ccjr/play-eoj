package mobi.playeoj.android;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PlayEOJ extends ListActivity {

    private static final int MENU_ALL_CARDS = 0;
    private static final int MENU_BY_ELEMENT = 1;
    private static final int MENU_BY_RACE = 2;
    private static final int MENU_BY_AFFILIATION = 3;
    private static final int MENU_GLOSSARY = 4;
    private static final int MENU_ABOUT = 5;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] menuStrings =  {
             	"All Cards", "By Element", "By Race", "By Affiliation", "Glossary", getString(R.string.about)
        };
        
        // Use an existing ListAdapter that will map an array of strings to TextViews
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menuStrings));
        getListView().setTextFilterEnabled(true);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        switch(position) {
        case MENU_ALL_CARDS:
            showCard();
            break;
        case MENU_BY_ELEMENT:
            showCard();
            break;
        case MENU_BY_RACE:
            showCard();
            break;
        case MENU_BY_AFFILIATION:
            showCard();
            break;
        case MENU_GLOSSARY:
            showGlossary();
            break;
        case MENU_ABOUT:
            showAbout();
            break;
        }
    }
    
    private void showCard() {
        Intent i = new Intent(this, ShowCard.class);
        startActivity(i);
    }
    
    private void showGlossary() {
        Intent i = new Intent(this, ListDefinitions.class);
        startActivity(i);
    }

    private void showAbout() {
    	// TODO: Show a styled resource
    }
}