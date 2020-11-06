package danikho.com.mascotasValeBaldoni.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import danikho.com.mascotasValeBaldoni.db.ConstructorMascotas;
import danikho.com.mascotasValeBaldoni.pojo.Mascota;
import danikho.com.mascotasValeBaldoni.R;

import static java.lang.Integer.parseInt;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.activity = activity;
        this.mascotas = mascotas;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_mascotas, viewGroup, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder mascotaViewHolder, int i) {
        final Mascota mascota = mascotas.get(i);
        mascotaViewHolder.imgMascota.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombre.setText(mascota.getNombre());
        ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
        mascotaViewHolder.tvCalificacion.setText(String.valueOf(constructorMascotas.obtenerRatingMascota(mascota)));

        mascotaViewHolder.imgbtCalificar.setOnClickListener(v -> {
            /*
            int count = parseInt(mascota.getRating()) +1;
            mascota.setRating(String.valueOf(count));
            notifyDataSetChanged();
             */
            constructorMascotas.puntuarMsacota(mascota);
            mascotaViewHolder.tvCalificacion.setText(String.valueOf(constructorMascotas.obtenerRatingMascota(mascota)));
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgMascota;
        private TextView tvNombre;
        private TextView tvCalificacion;
        private ImageButton imgbtCalificar;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgMascota = (ImageView) itemView.findViewById(R.id.ivFoto);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
            tvCalificacion = (TextView) itemView.findViewById(R.id.tvRating);
            imgbtCalificar = (ImageButton) itemView.findViewById(R.id.ivHuesoBlanco);
        }
    }
}