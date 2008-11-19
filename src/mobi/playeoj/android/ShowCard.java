package mobi.playeoj.android;

import mobi.playeoj.android.model.Card;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowCard extends Activity {

    Card mCard;
    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCard = Card.findByTitle(this.getIntent().getExtras().getString("title")); 
        
        this.setTitle("Card >> " + mCard.getTitle());
        setContentView(R.layout.show_card);
        
        // set the elements to display all information
        ((TextView)findViewById(R.id.card_title)).setText(mCard.getTitle() + " - #" + mCard.getNumber());
        ((ImageView)findViewById(R.id.card_element)).setImageResource(setElementImage());

        ((TextView)findViewById(R.id.card_summoning_cost)).setText("Summoning: " + mCard.getSummoning_cost());
        ((TextView)findViewById(R.id.card_activation_cost)).setText("Activation: " + mCard.getActivation_cost());
        
        ((TextView)findViewById(R.id.card_race)).setText(mCard.getRace() + " / " + mCard.getAffiliation());
        ((TextView)findViewById(R.id.card_description)).setText(mCard.getBody());
    }
    
    private int setElementImage() {
	if (mCard.getElement().equals("Fire")) {
	    return R.drawable.fire;
	} else if (mCard.getElement().equals("Water")) {
	    return R.drawable.water;
	} else if (mCard.getElement().equals("Wood")) {
	    return R.drawable.wood;
	} else if (mCard.getElement().equals("Earth")) {
	    return R.drawable.earth;
	} else if (mCard.getElement().equals("Biolith")) {
	    return R.drawable.biolith;
	} else if (mCard.getElement().equals("Spell")) {
	    return R.drawable.spell;
	} else {
	    return R.drawable.none;
	}
    }
}
