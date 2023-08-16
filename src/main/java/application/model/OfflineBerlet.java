package application.model;


public class OfflineBerlet {
    String berlet_id;
    String tulaj;
    String ervenyesseg_kezdet;
    String ervenyesseg_veget;
    String honnan;
    String hova;
    String tipus;
    String kedvezmeny;

    public OfflineBerlet() {}

    public OfflineBerlet(String tulaj, String ervenyesseg_kezdet, String ervenyesseg_veget, String honnan, String hova, String tipus, String kedvezmeny) {
        this.tulaj = tulaj;
        this.ervenyesseg_kezdet = ervenyesseg_kezdet;
        this.ervenyesseg_veget = ervenyesseg_veget;
        this.honnan = honnan;
        this.hova = hova;
        this.tipus = tipus;
        this.kedvezmeny = kedvezmeny;
    }

    public String getBerlet_id() {
        return berlet_id;
    }

    public String getTulaj() {
        return tulaj;
    }

    public String getErvenyesseg_kezdet() {
        return ervenyesseg_kezdet;
    }

    public String getErvenyesseg_veget() {
        return ervenyesseg_veget;
    }

    public String getHonnan() {
        return honnan;
    }

    public String getHova() {
        return hova;
    }

    public String getTipus() {
        return tipus;
    }

    public String getKedvezmeny() {
        return kedvezmeny;
    }

    public void setBerlet_id(String berlet_id) {
        this.berlet_id = berlet_id;
    }

    public void setTulaj(String tulaj) {
        this.tulaj = tulaj;
    }

    public void setErvenyesseg_kezdet(String ervenyesseg_kezdet) {
        this.ervenyesseg_kezdet = ervenyesseg_kezdet;
    }

    public void setErvenyesseg_veget(String ervenyesseg_veget) {
        this.ervenyesseg_veget = ervenyesseg_veget;
    }

    public void setHonnan(String honnan) {
        this.honnan = honnan;
    }

    public void setHova(String hova) {
        this.hova = hova;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public void setKedvezmeny(String kedvezmeny) {
        this.kedvezmeny = kedvezmeny;
    }

    @Override
    public String toString() {
        return "OfflineBerlet{" +
                "id=" + berlet_id +
                ", tulaj='" + tulaj + '\'' +
                ", ervenyesseg_kezdet='" + ervenyesseg_kezdet + '\'' +
                ", ervenyesseg_veget='" + ervenyesseg_veget + '\'' +
                ", honnan='" + honnan + '\'' +
                ", hova='" + hova + '\'' +
                ", tipus='" + tipus + '\'' +
                ", kedvezmeny='" + kedvezmeny + '\'' +
                '}';
    }
}
