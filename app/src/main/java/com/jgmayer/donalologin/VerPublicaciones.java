package com.jgmayer.donalologin;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class VerPublicaciones extends AppCompatActivity {
    ListView lista;
    daoPublicacion dao;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ver_publicaciones);
        lista=(ListView)findViewById(R.id.lista);

        dao=new daoPublicacion(this);
        ArrayList<Publicacion> l= dao.selectPublicacion();
        ArrayList<String> list=new ArrayList<String>();
        for (Publicacion u:l) {
            list.add(u.getTipo()+" "+u.getProducto()+"\n"+u.getDescripcion()+"\n"+"Contacto: "+u.getContacto()+"\n");
        }
        ArrayAdapter<String> a = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,list);
        lista.setAdapter(a);






    }
}