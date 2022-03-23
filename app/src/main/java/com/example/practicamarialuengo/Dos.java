package com.example.practicamarialuengo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Dos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dos);

        //Capturamos elemtos
        LinearLayout layout = findViewById(R.id.layoutDos);
        EditText edtxt = findViewById(R.id.edTxt1);
        Switch tg = findViewById(R.id.switch1);
        RadioGroup rg1 = findViewById(R.id.radioGroup1);
        Button btnAplicar = findViewById(R.id.btnAplicar1);
        Button btnVolver = findViewById(R.id.btnVolver1);


        //Imagen de fondo
        layout.setBackground(getDrawable(R.drawable.fondo5));

        tg.setText("CAMBIAR TEMA");
        //CAMBIAR EL TEMA
        tg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tg.isChecked()){
                    tg.setText("TEMA 1");
                    layout.setBackground(getDrawable(R.drawable.fondo2));
                    btnAplicar.setBackgroundColor(Color.parseColor("#3a86ff"));
                    btnVolver.setBackgroundColor(Color.parseColor("#3a86ff"));

                }else{
                    tg.setText("TEMA 2");
                    layout.setBackground(getDrawable(R.drawable.fondo5));
                    btnAplicar.setBackgroundColor(Color.parseColor("#ff006e"));
                    btnVolver.setBackgroundColor(Color.parseColor("#ff006e"));
                }
            }
        });


        //Recibe el bundle con la imagen de fondo y la manda a la actibity 3
        Bundle bFondo = getIntent().getExtras();
        String fondo = bFondo.getString("foto");

        //Intent Y Bundle GLOBAL para mandar: texto y fuente
        Intent intent = new Intent(Dos.this, Tres.class);
        Bundle bundle = new Bundle();
        bundle.putString("foto", fondo);

        //CAPTURAMOS LA SELECCIÓN DEL RADIO BUTTON
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                TextView seleccion = findViewById(i);
                String fuente = seleccion.getText().toString();
                //Toast.makeText(getApplicationContext(),"Has seleccionado "+fuente,
                        //Toast.LENGTH_SHORT).show();
                bundle.putString("fuente", fuente);
                intent.putExtras(bundle);
            }
        });

        btnAplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mensaje =edtxt.getText().toString();
                bundle.putString("mensaje", mensaje);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(Dos.this, MainActivity.class);
                startActivity(i1);
            }
        });
    }

}