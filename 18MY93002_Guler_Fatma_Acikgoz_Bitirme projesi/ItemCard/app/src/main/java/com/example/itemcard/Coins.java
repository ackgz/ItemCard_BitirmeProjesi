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

public class Coins extends AppCompatActivity {
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
    TextView lolcyazi, divisioncyazi, forzacyazi, redcyazi;
    TextView lolcfiyat, divisioncfiyat, forzacfiyat, redcfiyat;
    Button lolcoins, divisioncoins, forzacoins,redcoins, sepet;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coins);

        mAuth=FirebaseAuth.getInstance();


        lolcyazi=(TextView) findViewById(R.id.lolcyazi);
        divisioncyazi=(TextView) findViewById(R.id.divisioncyazi);
        forzacyazi=(TextView) findViewById(R.id.forzacyazi);
        redcyazi=(TextView) findViewById(R.id.redcyazi);


        lolcfiyat=(TextView) findViewById(R.id.lolcfiyat);
        divisioncfiyat=(TextView) findViewById(R.id.divisioncfiyat);
        forzacfiyat=(TextView) findViewById(R.id.forzacfiyat);
        redcfiyat=(TextView) findViewById(R.id.redcfiyat);


        lolcoins=(Button) findViewById(R.id.lolcoins);
        divisioncoins=(Button) findViewById(R.id.divisioncoins);
        forzacoins=(Button) findViewById(R.id.forzacoins);
        redcoins=(Button) findViewById(R.id.redcoins);
        sepet=(Button) findViewById(R.id.sepet);



        lolcoins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String urunad=lolcyazi.getText().toString();
                String urunfiyat=lolcfiyat.getText().toString();

                SQLLiteVeriTabanı vt=new SQLLiteVeriTabanı(Coins.this);
                vt.VeriEkle(urunad,urunfiyat);
                Toast.makeText(getApplicationContext(), "Eklendi!",Toast.LENGTH_SHORT).show();
            }
        });

        divisioncoins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String urunad=divisioncyazi.getText().toString();
                String urunfiyat=divisioncfiyat.getText().toString();

                SQLLiteVeriTabanı vt=new SQLLiteVeriTabanı(Coins.this);
                vt.VeriEkle(urunad,urunfiyat);
                Toast.makeText(getApplicationContext(), "Eklendi!",Toast.LENGTH_SHORT).show();
            }
        });

        forzacoins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String urunad=forzacyazi.getText().toString();
                String urunfiyat=forzacfiyat.getText().toString();

                SQLLiteVeriTabanı vt=new SQLLiteVeriTabanı(Coins.this);
                vt.VeriEkle(urunad,urunfiyat);
                Toast.makeText(getApplicationContext(), "Eklendi!",Toast.LENGTH_SHORT).show();
            }
        });



        redcoins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String urunad=redcyazi.getText().toString();
                String urunfiyat=redcfiyat.getText().toString();

                SQLLiteVeriTabanı vt=new SQLLiteVeriTabanı(Coins.this);
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
