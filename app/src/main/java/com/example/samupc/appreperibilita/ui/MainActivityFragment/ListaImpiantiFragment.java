package com.example.samupc.appreperibilita.ui.MainActivityFragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.samupc.appreperibilita.R;
import com.example.samupc.appreperibilita.data.ListaImpiantiAdapter;

public class ListaImpiantiFragment extends Fragment {

    private ListView listView;

    public ListaImpiantiFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_lista_impianti, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        listView = (ListView) view.findViewById(R.id.listImpianti);

        //TEST DI ADAPTER
        ListaImpiantiAdapter listaImpiantiAdapter= new ListaImpiantiAdapter(getContext(),new String[]{"Zona1","Tezt"});

        listView.setAdapter(listaImpiantiAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(getContext(), "Clicked ListItem" + position, Toast.LENGTH_LONG).show();
            }
        });

        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    public void onDetach() {
        super.onDetach();
    }


}
