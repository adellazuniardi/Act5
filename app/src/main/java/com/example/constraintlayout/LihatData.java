package com.example.constraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class LihatData extends AppCompatActivity {
    TextView tvnama, tvnomor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);
        tvnama = findViewById(R.id.tvNamaKontak);
        tvnomor = findViewById(R.id.tvnotelp);

        Bundle bundle = getIntent().getExtras();

        String nama = bundle.getString("a");
        switch (nama)
        {
            case "Aisyah":
                tvnama.setText("Aisyah B");
                tvnomor.setText("085867402560");
                break;
            case "Renita":
                tvnama.setText("Renita R");
                tvnomor.setText("085867402555");
                break;
            case "Jesica":
                tvnama.setText("X Jesica");
                tvnomor.setText("081867404262");
                break;
            case "Gita":
                tvnama.setText("Gita GG");
                tvnomor.setText("088374532962");
                break;
            case "Gabi":
                tvnama.setText("Gabi P");
                tvnomor.setText("089847401526");
                break;
            case "Putri":
                tvnama.setText("Putri L");
                tvnomor.setText("084862202524");
                break;
            case "Nisa":
                tvnama.setText("Nisa B");
                tvnomor.setText("085267872666");
                break;
            case "Jihan":
                tvnama.setText("Jihan J");
                tvnomor.setText("082832402520");
                break;
            case "Fida":
                tvnama.setText("Fida S");
                tvnomor.setText("081261405861");
                break;
            case "Hera":
                tvnama.setText("Hera M");
                tvnomor.setText("085827432444");
                break;
        }
    }
}