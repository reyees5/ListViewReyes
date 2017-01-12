package com.example.portatil.practicalistviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewSimple extends AppCompatActivity {
    //declarem array de 1 element
    final String []  datos = new String[]{"Part1", "Part2", "Part3", "Part4", "Part5"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_simple);

        ListView lstOpciones = (ListView) findViewById(R.id.LstOpciones);

        //Utilitzem l'array adapter del tipus string(tious de dades que tenim al array declarat)
        //per posar la informacio e el list view que esta al layout!
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, datos);

        lstOpciones.setAdapter(adaptador);


    }
}
