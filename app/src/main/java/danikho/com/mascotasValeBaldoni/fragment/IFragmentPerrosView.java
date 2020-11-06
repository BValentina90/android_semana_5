package danikho.com.mascotasValeBaldoni.fragment;

import java.util.ArrayList;

import danikho.com.mascotasValeBaldoni.adapter.MascotaAdaptador;
import danikho.com.mascotasValeBaldoni.pojo.Mascota;

public interface IFragmentPerrosView {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptador(MascotaAdaptador adaptador);
}
