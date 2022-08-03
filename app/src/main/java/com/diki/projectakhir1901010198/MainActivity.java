package com.diki.projectakhir1901010198;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
    Button logout,profile,balok,bola,kalkulator,creative;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);

        logout = (Button)findViewById(R.id.btn_logout);
        profile = (Button)findViewById(R.id.btn_Profile);
        balok = (Button)findViewById(R.id.btn_Balok);
        bola = (Button)findViewById(R.id.btn_Bola);
        kalkulator = (Button)findViewById(R.id.btn_Calc);
        creative = (Button)findViewById(R.id.btn_creative);


        Boolean checkSession = db.checkSession("ada");
        if (checkSession == false) {
            Intent loginIntent = new Intent(MainActivity.this, WelcomeActivity.class);
            startActivity(loginIntent);
            finish();
        }

        // logout
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean updtSession = db.upgradeSession("kosong", 1);
                if (updtSession == true) {
                    Toast.makeText(getApplicationContext(), "Berhasil Keluar", Toast.LENGTH_SHORT).show();
                    Intent loginIntent = new Intent(MainActivity.this, WelcomeActivity.class);
                    startActivity(loginIntent);

                }
            }
        });

        //profile
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profileIntent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(profileIntent);

            }
        });
        //Balok
        balok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent balokIntent = new Intent(MainActivity.this, BalokActivity.class);
                startActivity(balokIntent);

            }
        });
        //Bola
        bola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bolaIntent = new Intent(MainActivity.this, BolaActivity.class);
                startActivity(bolaIntent);

            }
        });
        //kalkulator
        kalkulator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kalkulatorIntent = new Intent(MainActivity.this, KalkulatorActivity.class);
                startActivity(kalkulatorIntent);

            }
        });
        //Creative
        creative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent creativeIntent = new Intent(MainActivity.this, CreativeActivity.class);
                startActivity(creativeIntent);
            }
        });

    }
}
