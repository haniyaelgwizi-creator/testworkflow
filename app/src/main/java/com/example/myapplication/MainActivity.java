package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView tvHallo;
    private EditText etName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Liaison XML ↔ Java
        tvHallo = findViewById(R.id.tvHALLO);
        etName = findViewById(R.id.eTName);
    }

    // Méthode appelée quand on clique sur le bouton
    public void onClick(View view) {
        if (etName.getText().length() == 0) {
            tvHallo.setText("Bonjour");
        } else {
            String str = etName.getText().toString();
            String strr = "HALLO " + str;
            tvHallo.setText(strr);
        }
    }
}