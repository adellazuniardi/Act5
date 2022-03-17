package com.example.constraintlayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText eemail, epassword;
    Button btsignin;
    String nama, password;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //method untuk menampilkan menu
        getMenuInflater().inflate(R.menu.menu , menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mnDaftar)
        {
         //method untuk memanggil activity "FormPendaftaran"
         Intent i = new Intent(getApplicationContext(), FormPendaftaran.class);
         startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eemail=findViewById(R.id.edEmail);
        epassword=findViewById(R.id.edPassword);
        btsignin=findViewById(R.id.edSignIn);

        btsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nama = eemail.getText().toString();
                password = epassword.getText().toString();
                String email = "adel@cobamail.com";
                String pass = "rant666";

                if (nama.equals("") || password.equals("")) {
                    Toast.makeText(MainActivity.this, "User atau Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if (nama.equals(email) && password.equals(pass)){
                        Toast.makeText(MainActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                        eemail.getText().clear();
                        epassword.getText().clear();

                        Bundle b = new Bundle();
                        b.putString("a", nama.trim());
                        b.putString("b",password.trim());
                        Intent i = new Intent(getApplicationContext(), Home.class);
                        i.putExtras(b);
                        startActivity(i);
                    }
                    else {
                        if (password.equals(pass)) {
                            Toast.makeText(MainActivity.this, "Email Salah", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            if (nama.equals(email)) {
                                Toast.makeText(MainActivity.this, "Password Salah", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(MainActivity.this, "Email dan Password Salah!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }

            }
        });
    }
}

