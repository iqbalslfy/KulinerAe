package net.kulinerae.kulinerae.Data;

/**
 * Created by SONY on 10/11/2017.
 */

public class MenuMinuman {
    private int gambarID;
    private String namaMinuman;

    public MenuMinuman(int gambarID, String namaMinuman) {
        this.gambarID = gambarID;
        this.namaMinuman = namaMinuman;
    }

    public MenuMinuman() {
    }

    public int getGambarID() {
        return gambarID;
    }

    public void setGambarID(int gambarID) {
        this.gambarID = gambarID;
    }

    public String getNamaMinuman() {
        return namaMinuman;
    }

    public void setNamaMinuman(String namaMinuman) {
        this.namaMinuman = namaMinuman;
    }
}
