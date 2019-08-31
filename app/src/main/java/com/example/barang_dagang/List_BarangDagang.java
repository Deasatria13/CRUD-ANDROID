package com.example.barang_dagang;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class List_BarangDagang extends AppCompatActivity {
    private DataSource dataSource;
    private ArrayList<BarangDagang>daftarBarang;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__barang_dagang);

        listView = (ListView)findViewById(R.id.list_view);
        daftarBarang = new ArrayList<BarangDagang>();

        dataSource = new DataSource(this);
        dataSource.open();
        daftarBarang = dataSource.readsemuaBarang();

        ArrayAdapter<BarangDagang> adapter =
                new ArrayAdapter<BarangDagang>(
                        this, android.R.layout.simple_list_item_1,
                        daftarBarang);
        listView.setAdapter(adapter);

    }




    public void kembali(View view) {
        dataSource.close();
        Intent i = new Intent(List_BarangDagang.this, input_barang.class);
        startActivity(i);
        this.finish();
    }
}
