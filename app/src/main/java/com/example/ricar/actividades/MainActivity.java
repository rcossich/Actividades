package com.example.ricar.actividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;


import java.util.Date;


public class MainActivity extends AppCompatActivity {
    EditText   etNombre;
    DatePicker dpFecha;
    EditText   etTelefono;
    EditText   etEmail;
    EditText   etDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle parametros2 = getIntent().getExtras();

        if (parametros2 != null) {
            etNombre       = (EditText) findViewById(R.id.etNombre);
            dpFecha        = (DatePicker) findViewById(R.id.dpFecha);
            etTelefono     = (EditText) findViewById(R.id.etTelefono);
            etEmail        = (EditText) findViewById(R.id.etEmail);
            etDescripcion  = (EditText) findViewById(R.id.etDescripcion);
            etNombre.setText(parametros2.getString(getResources().getString(R.string.pnombre)));
            etTelefono.setText(parametros2.getString(getResources().getString(R.string.ptelefono)));
            etEmail.setText(parametros2.getString(getResources().getString(R.string.pcorreo)));
            etDescripcion.setText(parametros2.getString(getResources().getString(R.string.pdescripcion)));
        }
    }

    protected void siguiente(View v){
        etNombre       = (EditText) findViewById(R.id.etNombre);
        dpFecha        = (DatePicker) findViewById(R.id.dpFecha);
        etTelefono     = (EditText) findViewById(R.id.etTelefono);
        etEmail        = (EditText) findViewById(R.id.etEmail);
        etDescripcion  = (EditText) findViewById(R.id.etDescripcion);

        Intent i = new Intent(this,VerificarDatos.class);
        i.putExtra("nombre",etNombre.getText().toString());
        long anio = dpFecha.getYear();
        int mes  = dpFecha.getMonth();
        int dia  = dpFecha.getDayOfMonth();
        String fecha = String.valueOf(dia).concat("/").concat(String.valueOf(mes)).concat("/").concat(String.valueOf(anio));
        i.putExtra("fecha",fecha);
        i.putExtra("telefono",etTelefono.getText().toString());
        i.putExtra("correo",etEmail.getText().toString());
        i.putExtra("descripcion",etDescripcion.getText().toString());
        startActivity(i);
    }
}
