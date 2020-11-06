package danikho.com.mascotasValeBaldoni.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import danikho.com.mascotasValeBaldoni.R;
import danikho.com.mascotasValeBaldoni.adapter.MascotaAdaptador;
import danikho.com.mascotasValeBaldoni.pojo.Mascota;
import danikho.com.mascotasValeBaldoni.presentador.FragmentPerrosPresenter;
import danikho.com.mascotasValeBaldoni.presentador.IFragmentPerrosPresenter;

public class FragmentPerros extends Fragment implements IFragmentPerrosView {


    private RecyclerView listaMascotas;
    private IFragmentPerrosPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_perros, container, false);

        listaMascotas = v.findViewById(R.id.rvMascotas);

        presenter = new FragmentPerrosPresenter(this, getContext());
        return v;
    }

    public void inicializarListaMascotas(){

    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(RecyclerView.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptador(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}