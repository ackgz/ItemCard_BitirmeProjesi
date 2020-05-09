package com.example.itemcard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.strictmode.WebViewMethodCalledOnWrongThreadViolation;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Silahlar extends AppCompatActivity {

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
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_silahlar);

        mAuth=FirebaseAuth.getInstance();

        Button geri=(Button) findViewById(R.id.ansyf);

        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(getApplicationContext(), Anasayfa.class);
                startActivity(a);
            }
        });
    }
}