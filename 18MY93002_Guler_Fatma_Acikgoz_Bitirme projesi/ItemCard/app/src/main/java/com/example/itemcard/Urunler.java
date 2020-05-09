package com.example.itemcard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class Urunler extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urunler);

        SQLLiteVeriTabanı db=new SQLLiteVeriTabanı(Urunler.this);

        Button geri=(Button) findViewById(R.id.geri_ansyf);



        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent a=new Intent(getApplicationContext(),Anasayfa.class);
                startActivity(a);


            }
        });


    }

}
