package com.example.barang_dagang;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class input_barang extends AppCompatActivity {
    EditText textNamaBarang,textHargaBarang,textStokBarang,textDiskonBarang;
    String nama;
    double harga;
    int stok;
    DataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_barang);

        textNamaBarang = (EditText)findViewById(R.id.textNamaBarang);
        textHargaBarang = (EditText)findViewById(R.id.textHargaBarang);
        textStokBarang = (EditText)findViewById(R.id.textStokBarang);
        textDiskonBarang = (EditText)findViewById(R.id.create_diskon_barang);

        dataSource =  new DataSource(this);

    }

    public void Keluar(View view) {
        Intent menu =new Intent(this, MainActivity.class);
    }

    public void lihatDaftar(View view) {
        Intent i = new Intent(input_barang.this, List_BarangDagang.class);
        startActivity(i);
        this.finish();
    }

    public void keluarApp(View view) {
        dataSource.close();
        this.finish();
    }

    public void Simpan(View view) {

        String nama =  textNamaBarang.getText().toString();
        double harga = Double.parseDouble(textHargaBarang.getText().toString());
        int stok =  Integer.parseInt(textStokBarang.getText().toString());
        double diskon = Double.parseDouble(textDiskonBarang.getText().toString());

        dataSource.open();
        long id = dataSource.createBarang(nama,harga,stok,diskon);
        if (id>0){
            Toast.makeText(getBaseContext(),"Data Tersimpan!!!",Toast.LENGTH_SHORT).show();
                    dataSource.close();

            Intent i = new Intent(input_barang.this, List_BarangDagang.class);
            startActivity(i);
            this.finish();
        }else{
            Toast.makeText(getBaseContext(),"Data tidak tersimpan!!!",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
