package com.example.constraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;

public class Homee extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{
    private ListView list;
    private ListviewAdapter adapter;
    String[] listnama;

    public static ArrayList<ClassNama> classNamaArrayList = new ArrayList<ClassNama>();
    Bundle bundle = new Bundle();
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homee);

        listnama = new String[]{"Aisyah", "Renita", "Jesica", "Gita", "Gabi", "Putri", "Nisa", "Jihan", "Fida", "Hera"};
        list = findViewById(R.id.listkont);
        classNamaArrayList = new ArrayList<>();
        for (int i = 0; i < listnama.length; i++)
        {
            ClassNama classNama = new ClassNama(listnama[i]);
            classNamaArrayList.add(classNama);
        }
        adapter = new ListviewAdapter(this);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String nama = classNamaArrayList.get(position).getName();
                bundle.putString("a",nama.trim());

                PopupMenu pm = new PopupMenu(getApplicationContext(),view);
                pm.setOnMenuItemClickListener(Homee.this);
                pm.inflate(R.menu.popup_menu);
                pm.show();
            }
        });
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case R.id.mnview:
                intent = new Intent(getApplicationContext(),LihatData.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.mnedit:
                Toast.makeText(getApplicationContext(), "Ini untuk edit Kontak", Toast.LENGTH_SHORT).show();
                break;
        }
        return false;
    }
}