package com.example.ricar.actividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class VerificarDatos extends AppCompatActivity {

    TextView tv2Nombre;
    TextView tv2Fecha;
    TextView tv2Tel;
    TextView tv2Email;
    TextView tv2Descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verificar_datos);

        Bundle parametros = getIntent().getExtras();

        tv2Nombre      = (TextView) findViewById(R.id.tv2Nombre);
        tv2Fecha       = (TextView) findViewById(R.id.tv2Fecha);
        tv2Tel         = (TextView) findViewById(R.id.tv2Tel);
        tv2Email       = (TextView) findViewById(R.id.tv2Email);
        tv2Descripcion = (TextView) findViewById(R.id.tv2Descripcion);
        tv2Nombre.setText(parametros.getString(getResources().getString(R.string.pnombre)));
        tv2Fecha.setText(parametros.getString(getResources().getString(R.string.pfecha)));
        tv2Tel.setText(parametros.getString(getResources().getString(R.string.ptelefono)));
        tv2Email.setText(parametros.getString(getResources().getString(R.string.pcorreo)));
        tv2Descripcion.setText(parametros.getString(getResources().getString(R.string.pdescripcion)));
    }

    protected void editar(View v) {
        Intent i = new Intent(this,MainActivity.class);
        i.putExtra("nombre",tv2Nombre.getText().toString());
        i.putExtra("fecha",tv2Fecha.getText().toString());
        i.putExtra("telefono",tv2Tel.getText().toString());
        i.putExtra("correo",tv2Email.getText().toString());
        i.putExtra("descripcion",tv2Descripcion.getText().toString());
        startActivity(i);
    }
}
