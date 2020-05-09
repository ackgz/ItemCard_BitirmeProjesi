package com.example.itemcard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;


import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;


public class SQLLiteVeriTabanı extends SQLiteOpenHelper {

    public SQLLiteVeriTabanı(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static final String DATABASE_NAME = "ItemCard";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLO_Urunler = "Urunler";
    private static final String ROW_ID = "id";
    private static final String ROW_UrunAd = "urun";
    private static final String ROW_Fiyat = "fiyat";


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLO_Urunler + "("
                + ROW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ROW_UrunAd + " TEXT NOT NULL, "
                + ROW_Fiyat + " TEXT NOT NULL)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLO_Urunler);
        onCreate(db);

    }

    public void VeriEkle(String urun, String fiyat) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues cv = new ContentValues();
            cv.put(ROW_UrunAd, urun);
            cv.put(ROW_Fiyat, fiyat);
            db.insert(TABLO_Urunler, null, cv);
        } catch (Exception e) {
        }
        db.close();
    }

    public List<String> VeriListele() {
        List<String> veriler = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            String[] stunlar = {ROW_ID, ROW_UrunAd, ROW_Fiyat,};
            Cursor cursor = db.query(TABLO_Urunler, stunlar, null, null, null, null, null);
            while (cursor.moveToNext()) {
                veriler.add(cursor.getInt(0)
                        + " - "
                        + cursor.getString(1)
                        + " - "
                        + cursor.getString(2));
            }
        } catch (Exception e) {

        }
        db.close();
        return veriler;
    }

    public void VeriSil(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            String where = ROW_ID + " = " + id;
            db.delete(TABLO_Urunler, where, null);
        } catch (Exception e) {
        }
        db.close();
    }

    public void VeriDuzenle(int id, String urun, String fiyat) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues cv = new ContentValues();
            cv.put(ROW_UrunAd, urun);
            cv.put(ROW_Fiyat, fiyat);
            String where = ROW_ID + " = '" + id + "'";
            db.update(TABLO_Urunler, cv, where, null);
        } catch (Exception e) {
        }
        db.close();
    }


}
