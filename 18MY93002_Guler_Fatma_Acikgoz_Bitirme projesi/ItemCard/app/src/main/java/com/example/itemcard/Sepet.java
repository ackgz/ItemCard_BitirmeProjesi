package com.example.itemcard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class Sepet extends AppCompatActivity {

    ListView VeriListele;
    int idBul=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sepet);


        Button urunler=(Button) findViewById(R.id.satin_albtn);
        Button geri=(Button) findViewById(R.id.geriansyf);
        Button sil=(Button) findViewById(R.id.sil);
        VeriListele=(ListView) findViewById(R.id.listele_urunler);



        Listele();

        sil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLLiteVeriTabanı vt = new SQLLiteVeriTabanı(Sepet.this);
                vt.VeriSil(idBul);
                ListViewItem();
                Listele();

            }
        });


        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(getApplicationContext(), Anasayfa.class);
                startActivity(a);
            }
        });

        urunler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(getApplicationContext(), Urunler.class);
                startActivity(a);
            }
        });




    }

    public void Listele(){
        SQLLiteVeriTabanı vt = new SQLLiteVeriTabanı(Sepet.this);
        List<String> list = vt.VeriListele();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(Sepet.this, android.R.layout.simple_list_item_1,android.R.id.text1,list);
        VeriListele.setAdapter(adapter);
    }

    public void ListViewItem() {
        VeriListele.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = VeriListele.getItemAtPosition(position).toString();
                String[] itemBol = item.split(" - ");
                idBul = Integer.valueOf(itemBol[0].toString());

            }
        });
    }

}
