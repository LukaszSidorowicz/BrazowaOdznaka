package com.example.lukasz.brazowaodznaka;

import android.content.Intent;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lukasz.brazawaodznaka.R;

import java.io.IOException;
import java.util.List;

public class Stajnia extends AppCompatActivity {
    Integer myInt=0;
    String Pytanie;
    BazaHelper myDbHelper;
    Button poprzed;
    Button nast;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wyswietlanie_pytan);
        myDbHelper = new BazaHelper(this);
        text = (TextView) findViewById(R.id.text1);
        poprzed = (Button) findViewById(R.id.poprzednie);
        nast = (Button) findViewById(R.id.nastepne);

        try {
            myDbHelper.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Niepowodzenie tworzenia bazy");
        }



        try {
            myDbHelper.openDataBase();
        } catch (SQLException sqle) {
            throw sqle;
        }

        final List<String> names = myDbHelper.selectWords10();
        Pytanie = names.get(myInt);
        text.setText(Pytanie);
        nast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myInt++;
                Integer safe = names.size()-1;
                if (myInt<=safe && myInt >=0){
                    Pytanie = names.get(myInt);
                    text.setText(Pytanie);}

                else {
                    Toast.makeText(getApplicationContext(),"Nie ma już więcej pytań w tym dziale.", Toast.LENGTH_LONG).show();
                }
            }
        });

        poprzed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myInt--;
                Integer safe = names.size()-1;
                if (myInt<=safe && myInt >=0){
                    Pytanie = names.get(myInt);
                    text.setText(Pytanie);}
                else {
                    Toast.makeText(getApplicationContext(),"Nie ma pytania o numerze 0 i niżej.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void menu (View view) {
        Intent menu = new Intent (getApplicationContext(), MainActivity.class);
        startActivity(menu);
    }

}

