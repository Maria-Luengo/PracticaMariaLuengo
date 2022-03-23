package com.example.practicamarialuengo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Capturamos elemntos
        LinearLayout objLayout = findViewById(R.id.layoutMain);
        TextView txtBienvenido = findViewById(R.id.txtBienvenido);
        Button btn1 =findViewById(R.id.btn1);
        ListView lista1 = findViewById(R.id.list1);

        txtBienvenido.setTextColor(Color.WHITE);

        //Imagen de fondo
        objLayout.setBackground(getDrawable(R.drawable.fondo));

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lista1.setVisibility(View.VISIBLE);
            }
        });

        //Array con los elemtos de la lista
        String[ ] datosList1 = new String[ ]{"Cumpleaños","Fiestas","Ciudad", "Mar","Playa","Montaña"};
        //Array Adapter para añadir el array al ListView
        ArrayAdapter<String> adapterA = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1,datosList1);
        //mandamos al ListView el ArrayAdapter
        lista1.setAdapter(adapterA);

        //5) evento on click a los elementos de mi lista
        lista1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent i1 = new Intent(MainActivity.this, Dos.class);
                Bundle b1 = new Bundle();
                if(i==0){
                    Toast.makeText(getApplicationContext(), "Has seleccionado Cumpleaños", Toast.LENGTH_SHORT).show();
                    b1.putString("foto", "fotoCumple");
                    i1.putExtras(b1);
                    startActivity(i1);
                }else if(i == 1){
                    Toast.makeText(getApplicationContext(), "Has seleccionado Fiestas", Toast.LENGTH_SHORT).show();
                    b1.putString("foto", "fotoFiestas");
                    i1.putExtras(b1);
                    startActivity(i1);
                }else if(i == 2){
                    Toast.makeText(getApplicationContext(), "Has seleccionado Ciudad", Toast.LENGTH_SHORT).show();
                    b1.putString("foto", "fotoCiudad");
                    i1.putExtras(b1);
                    startActivity(i1);
                }else if(i == 3){
                    Toast.makeText(getApplicationContext(), "Has seleccionado Mar", Toast.LENGTH_SHORT).show();
                    b1.putString("foto", "fotoMar");
                    i1.putExtras(b1);
                    startActivity(i1);
                }else if(i == 4){
                    Toast.makeText(getApplicationContext(), "Has seleccionado Montaña", Toast.LENGTH_SHORT).show();
                    b1.putString("foto", "fotoPlaya");
                    i1.putExtras(b1);
                    startActivity(i1);
                }else if(i == 5){
                    Toast.makeText(getApplicationContext(), "Has seleccionado Montaña", Toast.LENGTH_SHORT).show();
                    b1.putString("foto", "fotoMontania");
                    i1.putExtras(b1);
                    startActivity(i1);
                }
                else{
                    Intent iReset = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(iReset);
                }
            }
        });
    }
}