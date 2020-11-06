package danikho.com.mascotasValeBaldoni.presentador;

import android.content.Context;

import java.util.ArrayList;

import danikho.com.mascotasValeBaldoni.db.ConstructorMascotas;
import danikho.com.mascotasValeBaldoni.fragment.IFragmentPerrosView;
import danikho.com.mascotasValeBaldoni.pojo.Mascota;

public class FragmentPerrosPresenter implements IFragmentPerrosPresenter {
    IFragmentPerrosView iFragmentPerrosView;
    Context context;
    ConstructorMascotas constructorMascotas;
    ArrayList<Mascota> mascotas;

    public FragmentPerrosPresenter(IFragmentPerrosView iFragmentPerrosView, Context context) {
        this.iFragmentPerrosView = iFragmentPerrosView;
        this.context = context;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRecyclerView();

    }

    @Override
    public void mostrarMascotasRecyclerView() {
        iFragmentPerrosView.inicializarAdaptador(iFragmentPerrosView.crearAdaptador(mascotas));
        iFragmentPerrosView.generarLinearLayoutVertical();
    }
}
