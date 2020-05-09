package com.example.itemcard;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Anasayfa extends AppCompatActivity {
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anasayfa);
        Button oyun=(Button) findViewById(R.id.oyunlar);
        Button coin=(Button) findViewById(R.id.coins);
        Button silah=(Button) findViewById(R.id.silah);
        Button karakterler=(Button) findViewById(R.id.karakterler);
        Button hesaplar=(Button) findViewById(R.id.kullanici_hesaplari);
        Button sepet=(Button) findViewById(R.id.sepet);

        mAuth=FirebaseAuth.getInstance();


        oyun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent oyun=new Intent(getApplicationContext(), Oyunlar.class);
                startActivity(oyun);
            }
        });

        coin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent coinn=new Intent(getApplicationContext(), Coins.class);
                startActivity(coinn);
            }
        });

        silah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent silahh=new Intent(getApplicationContext(), Silahlar.class);
                startActivity(silahh);
            }
        });

        karakterler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent karakter=new Intent(getApplicationContext(), Karakterler.class);
                startActivity(karakter);
            }
        });

        hesaplar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hesaplarr=new Intent(getApplicationContext(),Kullanici_Hesaplari.class);
                startActivity(hesaplarr);
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


}
