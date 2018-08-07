package com.example.samupc.appreperibilita.data;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.samupc.appreperibilita.R;

public class ListaImpiantiAdapter extends ArrayAdapter<String>{

    private Context context;
    private String[] values;


    public ListaImpiantiAdapter(@NonNull Context context, String[]values) {
        super(context, -1, values);
        this.context = context;
        this.values=values;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //TEST DI ADAPTER
        View view = inflater.inflate(R.layout.list_layout, parent, false);
        TextView idZona= view.findViewById(R.id.idZona);
        TextView via=view.findViewById(R.id.via);

        idZona.setText(values[0]);
        via.setText(values[1]);

        return view;
    }
}
