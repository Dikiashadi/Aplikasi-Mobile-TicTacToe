package com.diki.projectakhir1901010198;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BolaActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtJari;
    private Button btnHitung;
    private TextView Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bola);

        edtJari = findViewById(R.id.edt_jari);
        btnHitung = findViewById(R.id.btn_hitung);
        Result = findViewById(R.id.result);

        btnHitung.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_hitung) {
            String inputJariJari = edtJari.getText().toString().trim();

            boolean isEmptyFields = false;
            boolean isInvalidDouble = false;

            if (TextUtils.isEmpty(inputJariJari)) {
                isEmptyFields = true;
                edtJari.setError("Field ini tidak boleh kosong");
            }

            Double JariJari = toDouble(inputJariJari);


            if (JariJari == null) {
                isInvalidDouble = true;
                edtJari.setError("Field ini harus berupa nomer yang valid");
            }

            if (!isEmptyFields && !isInvalidDouble) {
                double volume = 1.33 * 3.14 * JariJari * JariJari * JariJari;
                Result.setText(String.valueOf(volume));
            }
        }
    }

    private Double toDouble(String str) {
        try {
            return Double.valueOf(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}