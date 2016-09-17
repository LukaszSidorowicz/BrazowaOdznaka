package com.example.lukasz.brazowaodznaka;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;


public class BazaHelper extends SQLiteOpenHelper {


    //Domyslna sciezka androida do bazy.
    private static String DB_PATH = "";
    private static String DB_NAME = "brazawa_odznaka2.db";
    private static String BHP = "BHP";
    private static String konNatura = "konNatura";
    private static String cachyUzytkowe = "CechyUzytkowe";
    private static String chodySkokiTeren= "ChodySkokiTeren";
    private static String pielegnacja= "Pielegnacja";
    private static String podstJazdKonnej= "PodstJazdKonn";
    private static String podstZachUj="PodstawyZachUj";
    private static String siodlanie = "Siodlanie";
    private static String sprzet = "Sprzet";
    private static String stajnia = "Stajnia";
    private static String teoriaKlasJazdKonn = "TeorKlasJazdKonn";
    private static String wyprowadzanie = "Wyprowadzanie";
    private static String zdrowieKoni = "ZdrowieKoni";
    private static String zywienie= "Zywienie";
    private SQLiteDatabase myDataBase;
    private final Context myContext;

    /**
     * Konstruktor
     * dostosowujacy sciezke do nowszych wersji androida
     */

    public BazaHelper(Context context) {
        super(context, DB_NAME, null, 1);
        if (android.os.Build.VERSION.SDK_INT >= 4.2) {
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        } else {
            DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        }
        this.myContext = context;
    }

    /**
     * Tworzy pusta baze danych w systemie i nadpisuje istniejaca wczesniej baza.
     */
    public void createDataBase() throws IOException {

        boolean dbExist = checkDataBase();

        if (dbExist) {
            //nic nie robi, gdy baza istnieje
        } else {
            this.getWritableDatabase();
            //Poprzez wywolanie tej metody zostanie utworzonna pusta baza danych w sciezce
            //aplikacji, po to zeby mozna bylo ja nadpisac istniejaca baza.
            try {
                copyDataBase();
            } catch (IOException e) {
                throw new Error("Blad kopiowania bazy");
            }
        }

    }

    /**
     * Sprawdzanie, czy baza istnieje, zeby uniknac kopiowania przy kazdym otwieraniu aplikacji
     * @return true jesli istjnieje false jesli nie
     */
    private boolean checkDataBase() {

        SQLiteDatabase checkDB = null;

        try {
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException e) {

            //baza jeszcze nie istnieje.

        }
        if (checkDB != null) {
            checkDB.close();
        }

        return checkDB != null ? true : false;
    }

    /**
     * Kopiowanie istniejacej bazy do dopiero co utworzonej
     * poprze kopiowanie strumienia bajtow
     */

    private void copyDataBase() throws IOException {

        //Orwieranie bazy lokalnej jako strumien weijsciowy
        InputStream myInput = myContext.getAssets().open(DB_NAME);

        // Sciezka do utworzonej pustej bazy
        String outFileName = DB_PATH + DB_NAME;

        //Otwieranie pustej bazy jako strumienia wejsciwego
        OutputStream myOutput = new FileOutputStream(outFileName);

        //transfer bajtow we-wy
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }

        //zamkniecie strumieni
        myOutput.flush();
        myOutput.close();
        myInput.close();

    }

    public void openDataBase() throws SQLException {

        //Otwarcie bazy
        String myPath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);

    }

    @Override
    public synchronized void close() {
        if (myDataBase != null)
            myDataBase.close();
        super.close();

    }

    public List<String> selectWords() {
        List<String> list = new ArrayList<String>();
        Cursor cursor = this.myDataBase.query(BHP, new String[] { "Lp", "Pytanie", "Odpowiedz" }, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                list.add(cursor.getString(0)+". \n\nPytanie:\n" + cursor.getString(1) + "\n\nOdpowiedż:\n" + cursor.getString(2));
            } while (cursor.moveToNext());
        }
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        return list;
    }

    public List<String> selectWords2() {
        List<String> list = new ArrayList<String>();
        Cursor cursor = this.myDataBase.query(konNatura, new String[] { "Lp", "Pytanie", "Odpowiedz" }, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                list.add(cursor.getString(0)+". \n\nPytanie:\n" + cursor.getString(1) + "\n\nOdpowiedż:\n" + cursor.getString(2));
            } while (cursor.moveToNext());
        }
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        return list;
    }

    public List<String> selectWords3() {
        List<String> list = new ArrayList<String>();
        Cursor cursor = this.myDataBase.query(cachyUzytkowe, new String[] { "Lp", "Pytanie", "Odpowiedz" }, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                list.add(cursor.getString(0)+". \n\nPytanie:\n" + cursor.getString(1) + "\n\nOdpowiedż:\n" + cursor.getString(2));
            } while (cursor.moveToNext());
        }
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        return list;
    }
    public List<String> selectWords4() {
        List<String> list = new ArrayList<String>();
        Cursor cursor = this.myDataBase.query(chodySkokiTeren, new String[] { "Lp", "Pytanie", "Odpowiedz" }, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                list.add(cursor.getString(0)+". \n\nPytanie:\n" + cursor.getString(1) + "\n\nOdpowiedż:\n" + cursor.getString(2));
            } while (cursor.moveToNext());
        }
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        return list;
    }

    public List<String> selectWords5() {
        List<String> list = new ArrayList<String>();
        Cursor cursor = this.myDataBase.query(pielegnacja, new String[] { "Lp", "Pytanie", "Odpowiedz" }, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                list.add(cursor.getString(0)+". \n\nPytanie:\n" + cursor.getString(1) + "\n\nOdpowiedż:\n" + cursor.getString(2));
            } while (cursor.moveToNext());
        }
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        return list;
    }

    public List<String> selectWords6() {
        List<String> list = new ArrayList<String>();
        Cursor cursor = this.myDataBase.query(podstJazdKonnej, new String[] { "Lp", "Pytanie", "Odpowiedz" }, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                list.add(cursor.getString(0)+". \n\nPytanie:\n" + cursor.getString(1) + "\n\nOdpowiedż:\n" + cursor.getString(2));
            } while (cursor.moveToNext());
        }
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        return list;
    }

    public List<String> selectWords7() {
        List<String> list = new ArrayList<String>();
        Cursor cursor = this.myDataBase.query(podstZachUj, new String[] { "Lp", "Pytanie", "Odpowiedz" }, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                list.add(cursor.getString(0)+". \n\nPytanie:\n" + cursor.getString(1) + "\n\nOdpowiedż:\n" + cursor.getString(2));
            } while (cursor.moveToNext());
        }
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        return list;
    }

    public List<String> selectWords8() {
        List<String> list = new ArrayList<String>();
        Cursor cursor = this.myDataBase.query(siodlanie, new String[] { "Lp", "Pytanie", "Odpowiedz" }, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                list.add(cursor.getString(0)+". \n\nPytanie:\n" + cursor.getString(1) + "\n\nOdpowiedż:\n" + cursor.getString(2));
            } while (cursor.moveToNext());
        }
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        return list;
    }

    public List<String> selectWords9() {
        List<String> list = new ArrayList<String>();
        Cursor cursor = this.myDataBase.query(sprzet, new String[] { "Lp", "Pytanie", "Odpowiedz" }, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                list.add(cursor.getString(0)+". \n\nPytanie:\n" + cursor.getString(1) + "\n\nOdpowiedż:\n" + cursor.getString(2));
            } while (cursor.moveToNext());
        }
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        return list;
    }
    public List<String> selectWords10() {
        List<String> list = new ArrayList<String>();
        Cursor cursor = this.myDataBase.query(stajnia, new String[] { "Lp", "Pytanie", "Odpowiedz" }, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                list.add(cursor.getString(0)+". \n\nPytanie:\n" + cursor.getString(1) + "\n\nOdpowiedż:\n" + cursor.getString(2));
            } while (cursor.moveToNext());
        }
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        return list;
    }

    public List<String> selectWords11() {
        List<String> list = new ArrayList<String>();
        Cursor cursor = this.myDataBase.query(teoriaKlasJazdKonn, new String[] { "Lp", "Pytanie", "Odpowiedz" }, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                list.add(cursor.getString(0)+". \n\nPytanie:\n" + cursor.getString(1) + "\n\nOdpowiedż:\n" + cursor.getString(2));
            } while (cursor.moveToNext());
        }
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        return list;
    }
    public List<String> selectWords12() {
        List<String> list = new ArrayList<String>();
        Cursor cursor = this.myDataBase.query(wyprowadzanie, new String[] { "Lp", "Pytanie", "Odpowiedz" }, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                list.add(cursor.getString(0)+". \n\nPytanie:\n" + cursor.getString(1) + "\n\nOdpowiedż:\n" + cursor.getString(2));
            } while (cursor.moveToNext());
        }
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        return list;
    }
    public List<String> selectWords13() {
        List<String> list = new ArrayList<String>();
        Cursor cursor = this.myDataBase.query(zdrowieKoni, new String[] { "Lp", "Pytanie", "Odpowiedz" }, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                list.add(cursor.getString(0)+". \n\nPytanie:\n" + cursor.getString(1) + "\n\nOdpowiedż:\n" + cursor.getString(2));
            } while (cursor.moveToNext());
        }
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        return list;
    }

    public List<String> selectWords14() {
        List<String> list = new ArrayList<String>();
        Cursor cursor = this.myDataBase.query(zywienie, new String[] { "Lp", "Pytanie", "Odpowiedz" }, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                list.add(cursor.getString(0)+". \n\nPytanie:\n" + cursor.getString(1) + "\n\nOdpowiedż:\n" + cursor.getString(2));
            } while (cursor.moveToNext());
        }
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        return list;
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}