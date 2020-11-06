package danikho.com.mascotasValeBaldoni;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import danikho.com.mascotasValeBaldoni.adapter.MascotaAdaptador;
import danikho.com.mascotasValeBaldoni.db.ConstructorMascotas;
import danikho.com.mascotasValeBaldoni.pojo.Mascota;

import static java.lang.Integer.parseInt;

public class Top5Activity extends AppCompatActivity {
    private RecyclerView listMascotas;
    ArrayList<Mascota> mascotas2 = new ArrayList<>();

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top5);

        ImageView star = findViewById(R.id.iv5star);

        star.setVisibility(View.INVISIBLE);

        Toolbar toolbar = findViewById(R.id.miactionbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        listMascotas = (RecyclerView) findViewById(R.id.rvTop5);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);

        listMascotas.setLayoutManager(llm);
        initMascotas2();
        inicilizarAdaptador2();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mi_menu, menu);
        return true;
    }

    private void inicilizarAdaptador2(){
        MascotaAdaptador adaptador2 = new MascotaAdaptador(mascotas2, this);
        listMascotas.setAdapter(adaptador2);
    }

    public void initMascotas2(){
        ConstructorMascotas constructorMascotas = new ConstructorMascotas(this);
        ArrayList<Mascota> mascotasDes;
        mascotasDes = constructorMascotas.obtenerDatos();

        for (Mascota mascota: mascotasDes) {
            mascota.setRating(String.valueOf(constructorMascotas.obtenerRatingMascota(mascota)));
        }

        Collections.sort(mascotasDes, new Comparator<Mascota>() {
            @Override
            public int compare(Mascota m1, Mascota m2) {
                return Integer.compare(parseInt(m2.getRating()), parseInt(m1.getRating()));
            }
        });

        for (int i = 0; i < 5; i++){
            mascotas2.add(mascotasDes.get(i));
        }



    }
}
