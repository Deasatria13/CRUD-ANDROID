package com.example.barang_dagang;

import android.database.Cursor;

import java.util.ResourceBundle;

public class BarangDagang {
    private int idBarang;
    private String namaBarang;
    private double hargaBarang;
    private int stokBarang;
    private double persenDioskon;

    public BarangDagang(){

    }

    public BarangDagang(Cursor cursor) {

    }

    public int getIdBarang(){
        return idBarang;
    }
    public double getHargaBarang(){
        return hargaBarang;
    }
    public String getNamaBarang(){
        return namaBarang;
    }
    public int getStokBarang(){
        return stokBarang;
    }
    public double getPersenDioskon(){
        return persenDioskon;
    }
    public void setIdBarang(int idBarang){
        this.idBarang = idBarang;
    }
    public void setHargaBarang(double hargaBarang){
        this.hargaBarang = hargaBarang;
    }
    public void setNamaBarang(String namaBarang){
        this.namaBarang = namaBarang;
    }
    public void setStokBarang(int stokBarang){
        this.stokBarang = stokBarang;
    }
    public void setPersenDioskon(double persenDioskon){
        this.persenDioskon = persenDioskon;
    }
    @Override
    public String toString(){
        return "[Nama = "+ namaBarang+" | Harga = "+hargaBarang+"]";
    }

}

