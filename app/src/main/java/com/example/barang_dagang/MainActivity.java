package com.example.barang_dagang;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void inputBarang(View view) {
        Intent halamanInputBarang = new Intent(this, input_barang.class);
        startActivity(halamanInputBarang);
        this.finish();
    }

    public void lihatBarang(View view) {
        Intent halamanMenu = new Intent(this, MainActivity.class);
        startActivity(halamanMenu);
        this.finish();
    }
}
