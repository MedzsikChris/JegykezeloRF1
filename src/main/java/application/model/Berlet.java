package application.model;

public class Berlet {
    String berlet_id;

    String felhasznalo_id;

    String tulaj;

    String ervenyesseg_kezdet;

    String ervenyesseg_veg;

    String honnan;

    String hova;

    String tipus;

    String kedvezmeny;

    public Berlet(){};

    public Berlet(String berlet_id, String felhasznalo_id, String tulaj, String ervenyesseg_kezdet, String ervenyesseg_veg, String honna, String hova, String tipus, String kedvezmeny) {
        this.berlet_id = berlet_id;
        this.felhasznalo_id = felhasznalo_id;
        this.tulaj = tulaj;
        this.ervenyesseg_kezdet = ervenyesseg_kezdet;
        this.ervenyesseg_veg = ervenyesseg_veg;
        this.honnan = honnan;
        this.hova = hova;
        this.tipus = tipus;
        this.kedvezmeny = kedvezmeny;
    }

    public String getBerlet_id() {
        return berlet_id;
    }

    public void setBerlet_id(String berlet_id) {
        this.berlet_id = berlet_id;
    }

    public String getFelhasznalo_id() {
        return felhasznalo_id;
    }

    public void setFelhasznalo_id(String felhasznalo_id) {
        this.felhasznalo_id = felhasznalo_id;
    }

    public String getTulaj() {
        return tulaj;
    }

    public void setTulaj(String tulaj) {
        this.tulaj = tulaj;
    }

    public String getErvenyesseg_kezdet() {
        return ervenyesseg_kezdet;
    }

    public void setErvenyesseg_kezdet(String ervenyesseg_kezdet) {
        this.ervenyesseg_kezdet = ervenyesseg_kezdet;
    }

    public String getErvenyesseg_veg() {
        return ervenyesseg_veg;
    }

    public void setErvenyesseg_veg(String ervenyesseg_veg) {
        this.ervenyesseg_veg = ervenyesseg_veg;
    }

    public String getHonnan() {
        return honnan;
    }

    public void setHonnan(String honna) {
        this.honnan = honnan;
    }

    public String getHova() {
        return hova;
    }

    public void setHova(String hova) {
        this.hova = hova;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public String getKedvezmeny() {
        return kedvezmeny;
    }

    public void setKedvezmeny(String kedvezmeny) {
        this.kedvezmeny = kedvezmeny;
    }

    @Override
    public String toString() {
        return "Berlet{" +
                "berlet_id='" + berlet_id + '\'' +
                ", felhasznalo_id='" + felhasznalo_id + '\'' +
                ", tulaj='" + tulaj + '\'' +
                ", ervenyesseg_kezdet='" + ervenyesseg_kezdet + '\'' +
                ", ervenyesseg_veg='" + ervenyesseg_veg + '\'' +
                ", honna='" + honnan + '\'' +
                ", hova='" + hova + '\'' +
                ", tipus='" + tipus + '\'' +
                ", kedvezmeny='" + kedvezmeny + '\'' +
                '}';
    }
}
