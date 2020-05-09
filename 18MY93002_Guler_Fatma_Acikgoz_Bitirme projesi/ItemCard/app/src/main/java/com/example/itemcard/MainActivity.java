package com.example.itemcard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private final FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    private static final String LOG_TAG = "Otomatik internet Kontrol¸";
    private NetworkChangeReceiver receiver;//Network dinleyen receiver objemizin referans˝
    private ProgressDialog loginProgress;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        receiver = new NetworkChangeReceiver();
        registerReceiver(receiver, filter);

        Button yardimgit=(Button) findViewById(R.id.yardimsayfa);
        Button giris=(Button) findViewById(R.id.giris);
        Button kayit=(Button) findViewById(R.id.kayit);
        final EditText email_giris=(EditText) findViewById(R.id.email_giris);
        final EditText sifre_giris=(EditText) findViewById(R.id.sifre_giriss);
        loginProgress=new ProgressDialog(this);
        mAuth=FirebaseAuth.getInstance();

        giris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=email_giris.getText().toString();
                String sifre=sifre_giris.getText().toString();

                if (TextUtils.isEmpty(email)|| TextUtils.isEmpty(sifre))
                {
                    loginProgress.setTitle("Hata!");
                    loginProgress.setMessage("Boş alanlar var!");
                    loginProgress.setCanceledOnTouchOutside(false);
                    loginProgress.show();
                }

                else if (!TextUtils.isEmpty((email))|| !TextUtils.isEmpty(sifre))
                {
                    loginProgress.setTitle("Oturum Açılıyor!");
                    loginProgress.setMessage("Lütfen Bekleyiniz!");
                    loginProgress.setCanceledOnTouchOutside(false);
                    loginProgress.show();
                    kullaniciGirisi(email,sifre);

                }
            }
        });


        kayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent a=new Intent(MainActivity.this, Kayit_Ol.class);
                startActivity(a);
            }
        });

        yardimgit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent a=new Intent(getApplicationContext(), Yardim.class);
                startActivity(a);
            }
        });
    }

    private void kullaniciGirisi(String email, String sifre) {

        mAuth.signInWithEmailAndPassword(email,sifre).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful())
                {
                    loginProgress.dismiss();
                    Toast.makeText(getApplicationContext(), "Giriş Başarılı!",Toast.LENGTH_SHORT).show();
                    Intent anasayfa=new Intent(getApplicationContext(),Anasayfa.class);
                    startActivity(anasayfa);
                }
                else
                {
                    loginProgress.dismiss();
                    Toast.makeText(getApplicationContext(), "Giriş Yapılamadı!"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                }

            }
        });

    }

    @Override
    protected void onDestroy() { //Activity Kapatıldığı zaman receiver durduralacak.Uygulama arka plana alındığı zamanda receiver çalışmaya devam eder
        Log.v(LOG_TAG, "onDestory");
        super.onDestroy();

        unregisterReceiver(receiver);//receiver durduruluyor

    }
}