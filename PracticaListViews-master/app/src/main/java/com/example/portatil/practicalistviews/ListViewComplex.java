package com.example.portatil.practicalistviews;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewComplex extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_complex);

        AdaptadorTitulares adaptador = new AdaptadorTitulares(this, datos);

        ListView lstOpciones = (ListView)findViewById(R.id.LstOpciones);

        lstOpciones.setAdapter(adaptador);

        //on click para escoltar quin pack del listview s'ha pres
        //i dir alguna cosa sobre ell nostre cas el titol que te
        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> arg0, View vista, int posicion,
                                    long id) {
                //
               long lugar=arg0.getItemIdAtPosition(posicion);
                // For Long Short Toast
                Toast.makeText(getApplicationContext(), datos[posicion].getTitulo(), Toast. LENGTH_SHORT).show();

            }
        });

    }
    //declarem un array del tipus titular que omplim amb camps
    //la clase la tenim declarada apart!
    private Titular[] datos =
            new Titular[]{
                    new Titular("Part 1", "Subpart del 1","1"),
                    new Titular("Part 2", "Subpart del 2","2"),
                    new Titular("Part 3", "Subpart del 3","3"),
                    new Titular("Part 4", "Subpart del 4","4")
            };


    class AdaptadorTitulares extends ArrayAdapter<Titular> {

        //instanciem el array que em declat adalt
        Titular[] datos;
        public AdaptadorTitulares(Context context, Titular[] datos) {
            super(context, R.layout.component_listview_complex, datos);
            //necesari perque funcioni!!!
            this.datos=datos;
        }

        //metode que agafa el list view i omple  amb un objecte cada part del listview simple.
        //Por asi decirlo
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.component_listview_complex, null);

            //Part 1, que es el titol gran declarem i agafem la info del array
            TextView lblTitulo = (TextView)item.findViewById(R.id.LblTitulo);
            lblTitulo.setText(datos[position].getTitulo());
            //Part 2, que es el subtitol mes petit que e titol, declarem i agafem la info del array
            TextView lblSubtitulo = (TextView)item.findViewById(R.id.LblSubTitulo);
            lblSubtitulo.setText(datos[position].getSubtitulo());
            //imagen a declarar i instancia per utilitzarlo com un 3 element en el listview
            ImageView imagen = (ImageView)item.findViewById(R.id.icon);

            if (datos [position].getImagen().equals("1")){
                imagen.setImageDrawable(parent.getResources().getDrawable(R.drawable.bocajuniors));
            }
            if (datos [position].getImagen().equals("2")){
                imagen.setImageDrawable(parent.getResources().getDrawable(R.drawable.borusia));
            }
            if (datos [position].getImagen().equals("3")){
                imagen.setImageDrawable(parent.getResources().getDrawable(R.drawable.escudomonaco));
            }
            if (datos [position].getImagen().equals("4")){
                imagen.setImageDrawable(parent.getResources().getDrawable(R.drawable.napoles));
            }



            return(item);
        }
    }
}
