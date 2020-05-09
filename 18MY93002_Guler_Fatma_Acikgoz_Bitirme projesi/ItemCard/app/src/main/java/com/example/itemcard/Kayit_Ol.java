package com.example.itemcard;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Kayit_Ol<Register> extends AppCompatActivity{

    private static final String LOG_TAG = "Otomatik internet Kontrol¸";
    private NetworkChangeReceiver receiver;//Network dinleyen receiver objemizin referans˝

    private EditText kullanici_mail;
    private EditText kullanici_sifre;
    private Button kayitol;
    private ProgressDialog registerProgress;
    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit__ol);


        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        receiver = new NetworkChangeReceiver();
        registerReceiver(receiver, filter);


        kullanici_mail=(EditText) findViewById(R.id.mail);
        kullanici_sifre=(EditText) findViewById(R.id.sifre_giriss);
        kayitol=(Button) findViewById(R.id.kayit_ol);
        registerProgress=new ProgressDialog(this);
        mAuth=FirebaseAuth.getInstance();

        kayitol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e_mail=kullanici_mail.getText().toString();
                String password=kullanici_sifre.getText().toString();



                if (TextUtils.isEmpty(e_mail)|| TextUtils.isEmpty(password))
                {
                    registerProgress.setTitle("Hata!");
                    registerProgress.setMessage("Boş alanlar var!");
                    registerProgress.setCanceledOnTouchOutside(false);
                    registerProgress.show();
                }

                else if(!TextUtils.isEmpty(e_mail)|| !TextUtils.isEmpty(password))
                {
                    registerProgress.setTitle("Kaydediliyor!");
                    registerProgress.setMessage("Hesap oluşturuluyor bekleyiniz!");
                    registerProgress.setCanceledOnTouchOutside(false);
                    registerProgress.show();
                    register_user(e_mail,password);

                }
            }
        });


        Button girisbutton=(Button) findViewById(R.id.girisbtn);
        Button yardim=(Button) findViewById(R.id.yardim);


        girisbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent giris=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(giris);
            }
        });

        yardim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent yardim=new Intent(getApplicationContext(),Yardim.class);
                startActivity(yardim);
            }
        });


    }

    private void register_user(String e_mail, String password) {
        mAuth.createUserWithEmailAndPassword(e_mail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful())
                {
                    registerProgress.dismiss();
                    Intent mainIntent=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(mainIntent);
                }
                else
                {
                    registerProgress.dismiss();
                    Toast.makeText(getApplicationContext(), "Hata: "+task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    }
