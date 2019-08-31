package com.example.barang_dagang;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

    private static final String NAMA_DATABASE ="dbtoko.db";
    private static final int DATABASE_VERSION = 1;

    public static final String NAMA_TABLE = "tblBarangDagang";
    public static final String KOLOM_ID_BARANG = "idBarangDagang";
    public static final String KOLOM_NAMA_BARANG ="namaBarang";
    public static final String KOLOM_HARGA_BARANG = "hargaBarang";
    public static final String KOLOM_STOK_BARANG = "stokBarang";
    public static final String KOLOM_PERSEN_DISKON = "persenDiskon";

    public DBHelper(Context context){
        super(context, NAMA_DATABASE, null , DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String buat_tabel = "create table "+ NAMA_TABLE + "("
                +KOLOM_ID_BARANG +" integer primary key autoincrement, "
                +KOLOM_NAMA_BARANG +" varchar(100) NOT NULL, "
                +KOLOM_HARGA_BARANG +"double, "
                +KOLOM_STOK_BARANG +"integer, "
                +KOLOM_PERSEN_DISKON +"double );";
        db.execSQL(buat_tabel);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    Log.w("DataSource", "Upgrade database dari versi"+ oldVersion
    +"ke"+ newVersion +", akan menghapus semua data lama?");
    db.execSQL("DROP TABLE IF EXISTS "+ NAMA_TABLE);
    onCreate(db);
    }
}
