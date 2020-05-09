package com.example.itemcard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Oyunlar extends AppCompatActivity {

    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.anasayfa) {
            Intent anasayfabtn=new Intent(getApplicationContext(),
                    Anasayfa.class);
            startActivity(anasayfabtn);
        }
        if (id == R.id.oyunlar) {
            Intent oyunlar=new Intent(getApplicationContext(),
                    Oyunlar.class);
            startActivity(oyunlar);
        }
        if (id == R.id.coins) {
            Intent coins=new Intent(getApplicationContext(),
                    Coins.class);
            startActivity(coins);
        }
        if (id == R.id.silah) {
            Intent notebook=new Intent(getApplicationContext(),
                    Silahlar.class);
            startActivity(notebook);
        }
        if (id == R.id.redsilahlar) {
            Intent karakterler=new Intent(getApplicationContext(),
                    Karakterler.class);
            startActivity(karakterler);
        }

        if (id == R.id.cikis) {
            mAuth.signOut();
            Toast.makeText(getApplicationContext(), "OTURUM KAPATILDI!",Toast.LENGTH_SHORT).show();
            Intent girissayfa=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(girissayfa);
        }
        return super.onOptionsItemSelected(item);
    }

    int idBul=0;
    TextView csyazi, fifayazi, lolyazi, divisionyazi, forzayazi, pesyazi, redyazi, tombyazi;
    TextView csfiyat, fifafiyat, lolfiyat, divisionfiyat, forzafiyat, pesfiyat, redfiyat, tombfiyat;
    Button csbuy, fifabuy, lolbuy, divisionbuy, forzabuy, pesbuy, redbuy, tombbuy, sepet;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyunlar);

        mAuth=FirebaseAuth.getInstance();

        csyazi=(TextView) findViewById(R.id.csyazi);
        fifayazi=(TextView) findViewById(R.id.fifayazi);
        lolyazi=(TextView) findViewById(R.id.lolyazi);
        divisionyazi=(TextView) findViewById(R.id.divisionyazi);
        forzayazi=(TextView) findViewById(R.id.forzayazi);
        pesyazi=(TextView) findViewById(R.id.pesyazi);
        redyazi=(TextView) findViewById(R.id.redyazi);
        tombyazi=(TextView) findViewById(R.id.tombyazi);

        csfiyat=(TextView) findViewById(R.id.csfiyat);
        fifafiyat=(TextView) findViewById(R.id.fifafiyat);
        lolfiyat=(TextView) findViewById(R.id.lolfiyat);
        divisionfiyat=(TextView) findViewById(R.id.divisionfiyat);
        forzafiyat=(TextView) findViewById(R.id.forzafiyat);
        pesfiyat=(TextView) findViewById(R.id.pesfiyat);
        redfiyat=(TextView) findViewById(R.id.redfiyat);
        tombfiyat=(TextView) findViewById(R.id.tombfiyat);


        csbuy=(Button) findViewById(R.id.csbuy);
        fifabuy=(Button) findViewById(R.id.fifabuy);
        lolbuy=(Button) findViewById(R.id.lolbuy);
        divisionbuy=(Button) findViewById(R.id.divisionbuy);
        forzabuy=(Button) findViewById(R.id.forzabuy);
        pesbuy=(Button) findViewById(R.id.pesbuy);
        redbuy=(Button) findViewById(R.id.redbuy);
        tombbuy=(Button) findViewById(R.id.tombbuy);
        sepet=(Button) findViewById(R.id.sepet);


        csbuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String urunad=csyazi.getText().toString();
                String urunfiyat=csfiyat.getText().toString();

                SQLLiteVeriTabanı vt=new SQLLiteVeriTabanı(Oyunlar.this);
                vt.VeriEkle(urunad,urunfiyat);
                Toast.makeText(getApplicationContext(), "Eklendi!",Toast.LENGTH_SHORT).show();
            }
        });

        fifabuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String urunad=fifayazi.getText().toString();
                String urunfiyat=fifafiyat.getText().toString();

                SQLLiteVeriTabanı vt=new SQLLiteVeriTabanı(Oyunlar.this);
                vt.VeriEkle(urunad,urunfiyat);
                Toast.makeText(getApplicationContext(), "Eklendi!",Toast.LENGTH_SHORT).show();
            }
        });

        lolbuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String urunad=lolyazi.getText().toString();
                String urunfiyat=lolfiyat.getText().toString();

                SQLLiteVeriTabanı vt=new SQLLiteVeriTabanı(Oyunlar.this);
                vt.VeriEkle(urunad,urunfiyat);
                Toast.makeText(getApplicationContext(), "Eklendi!",Toast.LENGTH_SHORT).show();
            }
        });

        divisionbuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String urunad=divisionyazi.getText().toString();
                String urunfiyat=divisionfiyat.getText().toString();

                SQLLiteVeriTabanı vt=new SQLLiteVeriTabanı(Oyunlar.this);
                vt.VeriEkle(urunad,urunfiyat);
                Toast.makeText(getApplicationContext(), "Eklendi!",Toast.LENGTH_SHORT).show();
            }
        });

        forzabuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String urunad=forzayazi.getText().toString();
                String urunfiyat=forzafiyat.getText().toString();

                SQLLiteVeriTabanı vt=new SQLLiteVeriTabanı(Oyunlar.this);
                vt.VeriEkle(urunad,urunfiyat);
                Toast.makeText(getApplicationContext(), "Eklendi!",Toast.LENGTH_SHORT).show();
            }
        });

        pesbuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String urunad=pesyazi.getText().toString();
                String urunfiyat=pesfiyat.getText().toString();

                SQLLiteVeriTabanı vt=new SQLLiteVeriTabanı(Oyunlar.this);
                vt.VeriEkle(urunad,urunfiyat);
                Toast.makeText(getApplicationContext(), "Eklendi!",Toast.LENGTH_SHORT).show();
            }
        });


        redbuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String urunad=redyazi.getText().toString();
                String urunfiyat=redfiyat.getText().toString();

                SQLLiteVeriTabanı vt=new SQLLiteVeriTabanı(Oyunlar.this);
                vt.VeriEkle(urunad,urunfiyat);
                Toast.makeText(getApplicationContext(), "Eklendi!",Toast.LENGTH_SHORT).show();
            }
        });

        tombbuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String urunad=tombyazi.getText().toString();
                String urunfiyat=tombfiyat.getText().toString();

                SQLLiteVeriTabanı vt=new SQLLiteVeriTabanı(Oyunlar.this);
                vt.VeriEkle(urunad,urunfiyat);
                Toast.makeText(getApplicationContext(), "Eklendi!",Toast.LENGTH_SHORT).show();
            }
        });




        sepet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(getApplicationContext(), Sepet.class);
                startActivity(a);
            }
        });

    }
}
