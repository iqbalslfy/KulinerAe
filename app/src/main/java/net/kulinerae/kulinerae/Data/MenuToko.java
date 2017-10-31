package net.kulinerae.kulinerae.Data;

/**
 * Created by SONY on 30/10/2017.
 */

public class MenuToko {
    private int Gambar;
    private String Nama_toko;

    public MenuToko() {
    }

    public MenuToko(int gambar, String nama_toko) {
        Gambar = gambar;
        Nama_toko = nama_toko;
    }

    public int getGambar() {
        return Gambar;
    }

    public void setGambar(int gambar) {
        Gambar = gambar;
    }

    public String getNama_toko() {
        return Nama_toko;
    }

    public void setNama_toko(String nama_toko) {
        Nama_toko = nama_toko;
    }
}
