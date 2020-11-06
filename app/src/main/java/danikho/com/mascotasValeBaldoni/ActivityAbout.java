package danikho.com.mascotasValeBaldoni;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ActivityAbout extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        ImageView star = findViewById(R.id.iv5star);

        star.setVisibility(View.INVISIBLE);

        Toolbar toolbar = findViewById(R.id.miactionbar);
        setSupportActionBar(toolbar);

    }
}
