package mobi.playeoj.android;

import android.app.Activity;
import android.os.Bundle;

public class ShowCard extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setTitle("Card >> " + this.getIntent().getExtras().getString("title"));
        setContentView(R.layout.show_card);
    }
}
