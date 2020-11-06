package danikho.com.mascotasValeBaldoni;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import danikho.com.mascotasValeBaldoni.adapter.PageAdapter;
import danikho.com.mascotasValeBaldoni.fragment.FragmentPerfil;
import danikho.com.mascotasValeBaldoni.fragment.FragmentPerros;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        setUpViewPager();

        ImageView top5 = findViewById(R.id.iv5star);
        top5.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, Top5Activity.class);
            startActivity(i);
        });

        Toolbar toolbar = findViewById(R.id.miactionbar);
        setSupportActionBar(toolbar);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mi_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mAbout:
                Intent i = new Intent(this, ActivityAbout.class);
                startActivity(i);
                break;
            case R.id.mContacto:
                Intent i2 = new Intent(this, ActivityContacto.class);
                startActivity(i2);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new FragmentPerros());
        fragments.add(new FragmentPerfil());

        return fragments;
    }

    public void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.casa);
        tabLayout.getTabAt(1).setIcon(R.drawable.face);
    }


}