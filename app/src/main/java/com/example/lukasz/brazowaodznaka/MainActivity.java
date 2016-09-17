package com.example.lukasz.brazowaodznaka;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.lukasz.brazawaodznaka.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void info (View view) {
        Intent intentInfo = new Intent (getApplicationContext(), WyswietlanieBazy.class);
        startActivity(intentInfo);
    }

    public void BHP (View view){
        Intent BHP = new Intent(getApplicationContext(), WyswietlaniePytan.class);
        startActivity(BHP);
    }

    public void cechyUzytkowe (View view){
        Intent CechyUzytkowe = new Intent(getApplicationContext(), CechyUzytkowe.class);
        startActivity(CechyUzytkowe);
    }

    public void skoki (View view){
        Intent skoki = new Intent(getApplicationContext(), Skoki.class);
        startActivity(skoki);
    }
    public void pielegnuj (View view){
        Intent pielegnuj = new Intent(getApplicationContext(), Pielegnacja.class);
        startActivity(pielegnuj);
    }

    public void podstawyjazdy (View view){
        Intent podstawyjazdy = new Intent(getApplicationContext(), PodstawyJazdyKonne.class);
        startActivity(podstawyjazdy);
    }

    public void zachowanieNaUj (View view){
        Intent zachowanieNaUj = new Intent(getApplicationContext(), PodstawyZachowaniaNaUjezdzalni.class);
        startActivity(zachowanieNaUj);
    }

    public void siodlanie (View view){
        Intent siodlanie = new Intent(getApplicationContext(), Siodlanie.class);
        startActivity(siodlanie);
    }

    public void sprzet (View view){
        Intent sprzet = new Intent(getApplicationContext(), Sprzet.class);
        startActivity(sprzet);
    }
    public void dalsze (View view){
        Intent dalsze = new Intent(getApplicationContext(), Main2Activity.class);
        startActivity(dalsze);
    }



}
