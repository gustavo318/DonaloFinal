package com.jgmayer.donalologin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.jgmayer.donalologin.R.id.btnProdCancelar;
import static com.jgmayer.donalologin.R.id.btnProdCancelar2;
import static com.jgmayer.donalologin.R.id.btnPublicar;
import static com.jgmayer.donalologin.R.id.btnPublicar2;

public class NuevasPublicaciones extends AppCompatActivity implements View.OnClickListener {
    EditText tip,pro,des,con;
    Button reg2,can2;
    daoPublicacion dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nuevas_publicaciones);

        tip =(EditText)findViewById(R.id.TipoPublicacion);
        pro=(EditText)findViewById(R.id.Producto);
        des=(EditText)findViewById(R.id.Descripcion);
        con=(EditText)findViewById(R.id.Contacto);


        reg2=(Button)findViewById(btnPublicar2);
        can2=(Button)findViewById(btnProdCancelar2);

        reg2.setOnClickListener(this);
        can2.setOnClickListener(this);
        dao=new daoPublicacion(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case btnPublicar2:

                Publicacion p= new Publicacion();
                p.setTipo(tip.getText().toString());
                p.setProducto(pro.getText().toString());
                p.setDescripcion(des.getText().toString());
                p.setContacto(con.getText().toString());
                if(!p.isNull()){
                    Toast.makeText(this,"ERROR:Campos Vacios",Toast.LENGTH_LONG).show();
                } else if (dao.insertPublicacion(p)){
                    Toast.makeText(this,"Publicacion Exitosa!!!",Toast.LENGTH_LONG).show();
                    Intent i4= new Intent(NuevasPublicaciones.this,VerPublicaciones.class);
                    startActivity(i4);
                    finish();

                }
                break;
            case btnProdCancelar2:

                Intent i6= new Intent(NuevasPublicaciones.this,Inicio.class);
                startActivity(i6);
                finish();
                break;


        }

    }
}