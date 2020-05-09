package com.example.itemcard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Kullanici_Hesaplari extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kullanici__hesaplari);

        Button anasayfa=(Button) findViewById(R.id.ansyf);

        anasayfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent anasayfa=new Intent(getApplicationContext(),Anasayfa.class);
                startActivity(anasayfa);
            }
        });
    }
}
