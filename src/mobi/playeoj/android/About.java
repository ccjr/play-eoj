package mobi.playeoj.android;

import android.app.Activity;
import android.os.Bundle;

public class About extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setTitle("Play EoJ >> About");
        setContentView(R.layout.about);
    }
}
