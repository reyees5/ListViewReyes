package com.example.portatil.practicalistviews;

import android.widget.ImageView;

/**
 * Created by Portatil on 03/01/2017.
 */

//Clase que tindra diversas atributs que volem mostrar en un listview complex el cual mostrara
    //per cada casella del listviw un objecte de la clase titular.
public class Titular{

    private String titulo;
    private String subtitulo;
    private String imagen;

    public Titular(String tit, String sub,String img){
        titulo = tit;
        subtitulo = sub;
        imagen = img ;
    }


    public String getTitulo(){
        return  titulo;
    }

    public String getSubtitulo(){
        return subtitulo;
    }

    public String getImagen(){        return imagen;    }



}