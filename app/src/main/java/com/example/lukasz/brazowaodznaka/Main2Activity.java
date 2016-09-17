package com.example.lukasz.brazowaodznaka;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.lukasz.brazawaodznaka.R;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void stajnia (View view){
        Intent stajnia = new Intent(getApplicationContext(), Stajnia.class);
        startActivity(stajnia);
    }
    public void teoria (View view){
        Intent teoria = new Intent(getApplicationContext(), TeoriaKlasJazdKonnej.class);
        startActivity(teoria);
    }

    public void wyprowadzanie (View view){
        Intent wyprowadzanie = new Intent(getApplicationContext(), Wyprowadzanie.class);
        startActivity(wyprowadzanie);
    }

    public void zdrowie (View view){
        Intent zdrowie = new Intent(getApplicationContext(), ZdrowieKoni.class);
        startActivity(zdrowie);
    }
    public void zywienie (View view){
        Intent zywienie = new Intent(getApplicationContext(), Zywienie.class);
        startActivity(zywienie);
    }

    public void powrot (View view){
        Intent powrot = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(powrot);
    }



}
