package com.example.practicamarialuengo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Cuatro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuatro);

        //capturar elementos
        LinearLayout layout = findViewById(R.id.layoutCuatro);
        TextView txtGracias = findViewById(R.id.txtGracias);
        Button btn = findViewById(R.id.btn1);
        TextView like = findViewById(R.id.like);

        txtGracias.setTextColor(Color.WHITE);

        //Imagen de fondo
        layout.setBackground(getDrawable(R.drawable.fondoo));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                like.setVisibility(View.VISIBLE);
            }
        });
    }



    //BUSCAR MENU INFLATE EN LA API
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.Opcion1:
                Intent intent = new Intent(Cuatro.this, MainActivity.class);
                startActivity(intent);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}


