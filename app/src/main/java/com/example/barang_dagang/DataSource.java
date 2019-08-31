package com.example.barang_dagang;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DataSource {
    private  SQLiteDatabase database;
    private DBHelper dbhelper;
    private String[] semuakolom = {
            DBHelper.KOLOM_ID_BARANG,
            DBHelper.KOLOM_NAMA_BARANG,
            DBHelper.KOLOM_HARGA_BARANG,
            DBHelper.KOLOM_STOK_BARANG,
            DBHelper.KOLOM_PERSEN_DISKON
    };

    public DataSource(Context context) {
       dbhelper = new DBHelper(context);
    }

   public void open(){
        try {
            database = dbhelper.getWritableDatabase();
        }catch (SQLException e){
            Log.w(DataSource.class.getName(), "Error "+ e);
        }
   }

    public void close(){
        dbhelper.close();
    }

    public long createBarang(String nama, double harga, int stok,double diskon){
      ContentValues data = new ContentValues();
      data.put(DBHelper.KOLOM_NAMA_BARANG, nama);
      data.put(DBHelper.KOLOM_HARGA_BARANG,harga);
      data.put(DBHelper.KOLOM_STOK_BARANG,stok);
      data.put(DBHelper.KOLOM_PERSEN_DISKON,diskon);

      return  database.insert(DBHelper.NAMA_TABLE,null,data);

    }

    public ArrayList<BarangDagang>readsemuaBarang(){
        ArrayList<BarangDagang> semuaBarang =  new ArrayList<BarangDagang>();

        Cursor cursor = database.query(DBHelper.NAMA_TABLE,semuakolom,
                null,null,null,null,
                DBHelper.KOLOM_NAMA_BARANG + "ASC");

        cursor.moveToFirst();
            while (! cursor.isAfterLast()){
                Log.i("Info", cursor.getString(1));
                BarangDagang barang = cursorToBarangDagang(cursor);

            semuaBarang.add(barang);
            cursor.moveToNext();
        }

        return semuaBarang;
    }

    public BarangDagang cursorToBarangDagang(Cursor cursor) {
        BarangDagang barang =  new BarangDagang();

        barang.setIdBarang(Integer.parseInt(cursor.getString(0)));
        barang.setNamaBarang(cursor.getString(1));
        barang.setHargaBarang(Double.parseDouble(cursor.getString(2)));
        barang.setStokBarang(Integer.parseInt(cursor.getString(3)));
        barang.setPersenDioskon(Double.parseDouble(cursor.getString(4)));
        return barang;
    }
    }
