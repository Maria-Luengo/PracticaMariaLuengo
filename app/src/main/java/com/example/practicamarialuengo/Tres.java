package com.example.practicamarialuengo;

import static android.widget.Toast.*;

import static com.example.practicamarialuengo.R.color.white;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Tres extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tres);

        //capturamos elemtos
        RelativeLayout layout = findViewById(R.id.layoutTres);
        TextView mensaje = findViewById(R.id.txtFiestasAplicado);
        Button btnBajar = findViewById(R.id.btnBajar);
        Button btnSubir = findViewById(R.id.btnSubir);
        Button btnAmpliar = findViewById(R.id.btnAmpliar);
        Button btnReducir = findViewById(R.id.btnReducir);
        Button btnAplicar = findViewById(R.id.btnGuardar1);
        Button btnVolver = findViewById(R.id.btnVolver1_1);
        Button btnTerminar = findViewById(R.id.btnTerminar);

        //btnTerminar.setVisibility(View.INVISIBLE);

        //CAMBIAMOS EL COLOR DE LOS BOTONES
        btnBajar.setBackgroundColor(Color.parseColor("#FF00ACC1"));
        btnSubir.setBackgroundColor(Color.parseColor("#FF00ACC1"));
        btnTerminar.setBackgroundColor(Color.parseColor("#FFFFFF"));
       // btnTerminar.setTextColor(Color.GRAY);
        btnTerminar.setTextColor(Color.GRAY);


        //MENU COLORES CON SPINER
        final String[] colores = new String[]{"Texto blanco","Texto rojo", "Texto turquesa",
                "Texto morado", "Texto verde", "Texto amarillo", "Texto naranja", "Texto negro"};

        final Spinner spinner = findViewById(R.id.Colores);
        spinner.setBackgroundColor(Color.parseColor("#ff006e"));
        //spinner.setBackgroundColor(Color.GRAY);

        //creamos array y metemos el contexto (this es más local y get aplication context es más global, le metemos el array de datos)
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, colores);
        spinner.setAdapter(adaptador);

        //evento seleccionar
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        mensaje.setTextColor(Color.WHITE);
                        break;
                    case 1:
                        mensaje.setTextColor(Color.parseColor("#E91E63"));
                        break;
                    case 2:
                        mensaje.setTextColor(Color.parseColor("#FF00ACC1"));
                        break;
                    case 3:
                        mensaje.setTextColor(Color.parseColor("#8E24AA"));
                        break;
                    case 4:
                        mensaje.setTextColor(Color.parseColor("#C0CA33"));
                        break;
                    case 5:
                        mensaje.setTextColor(Color.parseColor("#FDD835"));
                        break;
                    case 6:
                        mensaje.setTextColor(Color.parseColor("#F57F17"));
                        break;
                    case 7:
                        mensaje.setTextColor(Color.BLACK);
                        break;
                    default:
                        mensaje.setTextColor(Color.BLUE);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                makeText(getApplicationContext(), "No has seleccionado ninguna opcion", LENGTH_SHORT).show();
            }
        });

        //Recibe Bundle's
        Bundle bundleFoto = getIntent().getExtras();
        String fondo = bundleFoto.getString("foto");

        Bundle bundle = getIntent().getExtras();
        String txt=bundle.getString("mensaje");
        String tipografia = bundle.getString("fuente");

        //Aplico Bundle a TextView
        mensaje.setText(txt);

        //aplico Bundle a SW para detectar categoría y poner la imagen de fondo
        switch (fondo){
            case "fotoCumple":
                layout.setBackground(getDrawable(R.drawable.cumple3));
                break;
            case "fotoFiestas":
                layout.setBackground(getDrawable(R.drawable.year2));
                break;
            case "fotoCiudad":
                layout.setBackground(getDrawable(R.drawable.ciudad2));
                break;
            case "fotoMar":
                layout.setBackground(getDrawable(R.drawable.mar));
                break;
            case "fotoPlaya":
                layout.setBackground(getDrawable(R.drawable.playa));
                break;
            case "fotoMontania":
                layout.setBackground(getDrawable(R.drawable.monuntain1));
                break;
            default:
                layout.setBackground(getDrawable(R.drawable.year1));
                break;
        }


        //aplico Bundle a SW para detectar la tipografía seleccionada
        switch (tipografia){
            case "FUENTE_1":
                Typeface typeface1 = getResources().getFont(R.font.font1);
                mensaje.setTypeface(typeface1);
                break;
            case "FUENTE_2":
                Typeface typeface2 = getResources().getFont(R.font.font2);
                mensaje.setTypeface(typeface2);
                break;
            case "FUENTE_3":
                Typeface typeface3 = getResources().getFont(R.font.font3);
                mensaje.setTypeface(typeface3);
                break;
            case "FUENTE_4":
                Typeface typeface4 = getResources().getFont(R.font.font4);
                mensaje.setTypeface(typeface4);
                break;
            case "FUENTE_5":
                Typeface typeface5 = getResources().getFont(R.font.font5);
                mensaje.setTypeface(typeface5);
                break;
           default:
                Typeface typeface6 = getResources().getFont(R.font.font);
                mensaje.setTypeface(typeface6);
                break;
        }


        //SUBIR Y BAJAR TEXTO
        btnSubir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //float X= mensaje.getX();
                float Y = mensaje.getY();
                Y-=40;
                mensaje.setY(Y);
            }
        });
      btnBajar.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              //float X= mensaje.getX();
              float Y = mensaje.getY();
              Y+=40;
              mensaje.setY(Y);
          }
        });

        //AMPLIAR Y REDUCIR TEXTO
        btnAmpliar.setOnClickListener(new View.OnClickListener() {
            int tamanio = 48;
            @Override
            public void onClick(View view) {
                mensaje.setTextSize(tamanio+=5);
            }
        });
        btnReducir.setOnClickListener(new View.OnClickListener() {
            int tamanio = 48;
            @Override
            public void onClick(View view) {
                mensaje.setTextSize(tamanio-=5);
            }
        });

        //OCULTAMOS EL TOGGLE BUTON Y EL BOTÓN DE GUARDAR
       btnAplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnAplicar.setVisibility(View.INVISIBLE);
                btnSubir.setVisibility(View.INVISIBLE);
                btnBajar.setVisibility(View.INVISIBLE);
                btnAmpliar.setVisibility(View.INVISIBLE);
                btnReducir.setVisibility(View.INVISIBLE);
                btnTerminar.setVisibility(View.VISIBLE);
                spinner.setVisibility(View.INVISIBLE);
                btnTerminar.setVisibility(View.VISIBLE);
            }
        });

        //INTENT PARA VOLVER A DOS
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Tres.this, Dos.class);
                startActivity(intent);
            }
        });

        btnTerminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentT=new Intent(Tres.this, Cuatro.class);
                startActivity(intentT);
            }
        });

    }
}