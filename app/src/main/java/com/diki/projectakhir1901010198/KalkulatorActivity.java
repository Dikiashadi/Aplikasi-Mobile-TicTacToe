package com.diki.projectakhir1901010198;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class KalkulatorActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editTextLayar;
    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    Button buttonTambah, buttonKurang, buttonBagi, buttonKali;
    Button buttonClear, buttonSamadengan;


    public static double nilaiSekarang=0;
    public static String operasiSekarangan="";
    public  static  double hasil=0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulator);
        init();
    }

    void init() {
        editTextLayar = (EditText)findViewById(R.id.editTextLayar);
        button0 = (Button) findViewById(R.id.button0);
        button0.setOnClickListener(this);

        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);

        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(this);

        button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(this);

        button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(this);

        button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(this);

        button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(this);

        buttonTambah = (Button) findViewById(R.id.buttonTambah);
        buttonTambah.setOnClickListener(this);

        buttonKurang = (Button) findViewById(R.id.buttonKurang);
        buttonKurang.setOnClickListener(this);

        buttonBagi = (Button) findViewById(R.id.buttonBagi);
        buttonBagi.setOnClickListener(this);

        buttonKali = (Button) findViewById(R.id.buttonKali);
        buttonKali.setOnClickListener(this);

        buttonClear = (Button) findViewById(R.id.buttonClear);
        buttonClear.setOnClickListener(this);

        buttonSamadengan = (Button) findViewById(R.id.buttonSamadengan);
        buttonSamadengan.setOnClickListener(this);
    }

    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button0:
                editTextLayar.setText(editTextLayar.getText().toString().trim()+"0");
                break;
            case R.id.button1:
                editTextLayar.setText(editTextLayar.getText().toString().trim()+"1");
                break;
            case R.id.button2:
                editTextLayar.setText(editTextLayar.getText().toString().trim()+"2");
                break;
            case R.id.button3:
                editTextLayar.setText(editTextLayar.getText().toString().trim()+"3");
                break;
            case R.id.button4:
                editTextLayar.setText(editTextLayar.getText().toString().trim()+"4");
                break;
            case R.id.button5:
                editTextLayar.setText(editTextLayar.getText().toString().trim()+"5");
                break;
            case R.id.button6:
                editTextLayar.setText(editTextLayar.getText().toString().trim()+"6");
                break;
            case R.id.button7:
                editTextLayar.setText(editTextLayar.getText().toString().trim()+"7");
                break;
            case R.id.button8:
                editTextLayar.setText(editTextLayar.getText().toString().trim()+"8");
                break;
            case R.id.button9:
                editTextLayar.setText(editTextLayar.getText().toString().trim()+"9");
                break;


            case R.id.buttonTambah:

                if (editTextLayar.getText().toString().trim().equals("")){
                    Toast.makeText(KalkulatorActivity.this, "Angka Harus Di Isi",Toast.LENGTH_SHORT).show();
                    return;
                }


                operasiSekarangan="tambah";
                nilaiSekarang = Double.parseDouble(editTextLayar.getText().toString());
                editTextLayar.setText("");
                break;
            case R.id.buttonKurang:
                if (editTextLayar.getText().toString().trim().equals("")){
                    Toast.makeText(KalkulatorActivity.this, "Angka Harus Di Isi",Toast.LENGTH_SHORT).show();
                    return;
                }

                operasiSekarangan="kurang";
                nilaiSekarang = Double.parseDouble(editTextLayar.getText().toString());
                editTextLayar.setText("");
                break;
            case R.id.buttonBagi:
                if (editTextLayar.getText().toString().trim().equals("")){
                    Toast.makeText(KalkulatorActivity.this, "Angka Harus Di Isi",Toast.LENGTH_SHORT).show();
                    return;
                }

                operasiSekarangan="bagi";
                nilaiSekarang = Double.parseDouble(editTextLayar.getText().toString());
                editTextLayar.setText("");
                break;
            case R.id.buttonKali:
                if (editTextLayar.getText().toString().trim().equals("")){
                    Toast.makeText(KalkulatorActivity.this, "Angka Harus Di Isi",Toast.LENGTH_SHORT).show();
                    return;
                }

                operasiSekarangan="kali";
                nilaiSekarang = Double.parseDouble(editTextLayar.getText().toString());
                editTextLayar.setText("");
                break;

            case R.id.buttonClear:
                nilaiSekarang=0;
                editTextLayar.setText("");
                break;

            case R.id.buttonSamadengan:

                if (operasiSekarangan.equals("tambah")) {
                    hasil = nilaiSekarang+Double.parseDouble(editTextLayar.getText().toString().trim());

                }
                if (operasiSekarangan.equals("kurang")) {
                    hasil = nilaiSekarang-Double.parseDouble(editTextLayar.getText().toString().trim());

                }
                if (operasiSekarangan.equals("bagi")) {
                    hasil = nilaiSekarang/Double.parseDouble(editTextLayar.getText().toString().trim());

                }
                if (operasiSekarangan.equals("kali")) {
                    hasil = nilaiSekarang*Double.parseDouble(editTextLayar.getText().toString().trim());

                }

                int nilaiTemp = (int) hasil;
                if (nilaiTemp == hasil) {
                    editTextLayar.setText(String.valueOf((int) hasil));
                }else {
                    editTextLayar.setText(String.valueOf(hasil));
                }

                break;
        }
    }
}