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

public class Karakterler extends AppCompatActivity {

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
    TextView lolkyazi, divisionkyazi, forzakyazi, redkyazi;
    TextView lolkfiyat, divisionkfiyat, forzakfiyat, redkfiyat;
    Button lolkarakter, divisionkarakter, forzaarabalar,redkarakter, sepet;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_karakterler);

        mAuth=FirebaseAuth.getInstance();


        lolkyazi=(TextView) findViewById(R.id.lolkyazi);
        divisionkyazi=(TextView) findViewById(R.id.divisionkyazi);
        forzakyazi=(TextView) findViewById(R.id.forzakyazi);
        redkyazi=(TextView) findViewById(R.id.redkyazi);


        lolkfiyat=(TextView) findViewById(R.id.lolkfiyat);
        divisionkfiyat=(TextView) findViewById(R.id.divisionkfiyat);
        forzakfiyat=(TextView) findViewById(R.id.forzakfiyat);
        redkfiyat=(TextView) findViewById(R.id.redkfiyat);


        lolkarakter=(Button) findViewById(R.id.lolkarakter);
        divisionkarakter=(Button) findViewById(R.id.divisionkarakter);
        forzaarabalar=(Button) findViewById(R.id.forzaarabalar);
        redkarakter=(Button) findViewById(R.id.redkarakter);
        sepet=(Button) findViewById(R.id.sepet);



        lolkarakter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String urunad=lolkyazi.getText().toString();
                String urunfiyat=lolkfiyat.getText().toString();

                SQLLiteVeriTabanı vt=new SQLLiteVeriTabanı(Karakterler.this);
                vt.VeriEkle(urunad,urunfiyat);
                Toast.makeText(getApplicationContext(), "Eklendi!",Toast.LENGTH_SHORT).show();
            }
        });

        divisionkarakter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String urunad=divisionkyazi.getText().toString();
                String urunfiyat=divisionkfiyat.getText().toString();

                SQLLiteVeriTabanı vt=new SQLLiteVeriTabanı(Karakterler.this);
                vt.VeriEkle(urunad,urunfiyat);
                Toast.makeText(getApplicationContext(), "Eklendi!",Toast.LENGTH_SHORT).show();
            }
        });

        forzaarabalar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String urunad=forzakyazi.getText().toString();
                String urunfiyat=forzakfiyat.getText().toString();

                SQLLiteVeriTabanı vt=new SQLLiteVeriTabanı(Karakterler.this);
                vt.VeriEkle(urunad,urunfiyat);
                Toast.makeText(getApplicationContext(), "Eklendi!",Toast.LENGTH_SHORT).show();
            }
        });



        redkarakter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String urunad=redkyazi.getText().toString();
                String urunfiyat=redkfiyat.getText().toString();

                SQLLiteVeriTabanı vt=new SQLLiteVeriTabanı(Karakterler.this);
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
