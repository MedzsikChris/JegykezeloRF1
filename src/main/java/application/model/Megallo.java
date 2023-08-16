package application.model;

import java.io.Serializable;

public class Megallo implements Serializable {

    private static final long serialVersonUID = 1L;

    int megallo_id;

    String nev;

    String cim;

    public Megallo(){}

    public Megallo(int megallo_id, String nev, String cim) {
        this.megallo_id = megallo_id;
        this.nev = nev;
        this.cim = cim;
    }

    public Megallo( String nev, String cim) {
        this.nev = nev;
        this.cim = cim;
    }

    public int getMegallo_id() {
        return megallo_id;
    }

    public void setMegallo_id(int megallo_id) {
        this.megallo_id = megallo_id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    @Override
    public String toString() {
        return "Megallo{" +
                "megallo_id=" + megallo_id +
                ", nev='" + nev + '\'' +
                ", cim='" + cim + '\'' +
                '}';
    }
}
