package danikho.com.mascotasValeBaldoni.db;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

import danikho.com.mascotasValeBaldoni.R;
import danikho.com.mascotasValeBaldoni.pojo.Mascota;

public class ConstructorMascotas {
    private Context context;
    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){
        /*
        ArrayList<Mascota> mascotasValeBaldoni = new ArrayList<>();

        mascotasValeBaldoni.add(new Mascota(0, R.drawable.perrito1,"Lenin", "0"));
        mascotasValeBaldoni.add(new Mascota(1, R.drawable.gatito1,"Agata", "0"));
        mascotasValeBaldoni.add(new Mascota(2,R.drawable.gatito2,"MarcoTulio", "0"));
        mascotasValeBaldoni.add(new Mascota(3, R.drawable.perrito2,"Remolina", "0"));
        mascotasValeBaldoni.add(new Mascota(4, R.drawable.perrito3,"Natal", "0"));

        return mascotasValeBaldoni;

         */
        BaseDatos db = new BaseDatos(context);
        ArrayList<Mascota> mascotas = db.obtenerTodasLasMascotas();
        if (mascotas.size() == 0){
            insertar8Mascotas(db);
        }
        return db.obtenerTodasLasMascotas();
    }
    public void insertar8Mascotas(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Indio");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.indio);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Cowboy");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.gaucho);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Obrero");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.bombero);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Police");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.policia);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Soldier");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.soldado);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Perro6");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.perrito1);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Perro7");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.perrito2);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Perro8");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.perrito3);
        db.insertarMascota(contentValues);






    }

    public void puntuarMsacota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_RATING_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_RATING_RATING, 1);
        db.insertarRating(contentValues);
    }

    public int obtenerRatingMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerRatingMascota(mascota);
    }

}
