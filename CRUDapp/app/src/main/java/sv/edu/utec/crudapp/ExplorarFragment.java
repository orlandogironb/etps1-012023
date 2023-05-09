package sv.edu.utec.crudapp;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import sv.edu.utec.crudapp.adapatadores.LstProvedoresAdapter;
import sv.edu.utec.crudapp.datos.Provedores;
import sv.edu.utec.crudapp.entidades.EntProvedores;


public class ExplorarFragment extends Fragment {
RecyclerView listaProvedores;
ArrayList<EntProvedores> AlistProve;
Context context;
    public ExplorarFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        view=inflater.inflate(R.layout.fragment_explorar, container, false);
        listaProvedores=view.findViewById(R.id.rcvLstProveedores);

        listaProvedores.setLayoutManager(new LinearLayoutManager(context));

        Provedores dbProve = new Provedores(context);

        AlistProve=new ArrayList<>();
        LstProvedoresAdapter adapter=new LstProvedoresAdapter(dbProve.mostrarProvedor());
        listaProvedores.setAdapter(adapter);
        // Inflate the layout for this fragment
        return view;
    }
}