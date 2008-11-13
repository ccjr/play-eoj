package mobi.playeoj.android;

import mobi.playeoj.android.model.Card;
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
            getString(R.string.all_cards), getString(R.string.by_element),
            getString(R.string.by_race), getString(R.string.by_affiliation),
            getString(R.string.glossary), getString(R.string.about)
        };
        
        // Use an existing ListAdapter that will map an array of strings to TextViews
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menuStrings));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        switch(position) {
        case MENU_ALL_CARDS:
            showAllCards();
            break;
        case MENU_BY_ELEMENT:
            showFilter(Card.ELEMENTS);
            break;
        case MENU_BY_RACE:
            showFilter(Card.RACES);
            break;
        case MENU_BY_AFFILIATION:
            showFilter(Card.AFFILIATIONS);
            break;
        case MENU_GLOSSARY:
            showGlossary();
            break;
        case MENU_ABOUT:
            showAbout();
            break;
        }
    }

    private void showAllCards() {
        Intent i = new Intent(this, ListCards.class);
        i.putExtra("cards", Card.ALL_TITLES);
        startActivity(i);
    }

    private void showGlossary() {
        Intent i = new Intent(this, ListDefinitions.class);
        startActivity(i);
    }
    
    private void showFilter(String[] filter) {
        Intent i = new Intent(this, ListFilters.class);
        i.putExtra("filter", filter);
        startActivity(i);
    }

    private void showAbout() {
        Intent i = new Intent(this, About.class);
        startActivity(i);
    }
}