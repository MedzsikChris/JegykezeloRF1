package application.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import application.dao.JegyDAO;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Jegy {

    DateTimeFormatter myDateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    LocalDateTime currentDate = LocalDateTime.now();
    int jegy_id;
    String civ;
    String kezdo_megallo;
    String vegallomas;
    int kocsiosztaly;
    Boolean oda_vissza;
    int ar;
    String ervenyes_ettol;
    String ervenyes_eddig;
    String datum;

    String kedvezmeny;

    public Jegy(String civ, String kezdo_megallo, String vegallomas, int kocsiosztaly, Boolean oda_vissza, int ar, String ervenyes_ettol, String ervenyes_eddig, String datum, String kedvezmeny) {
        this.civ = civ;
        this.kezdo_megallo = kezdo_megallo;
        this.vegallomas = vegallomas;
        this.kocsiosztaly = kocsiosztaly;
        this.oda_vissza = oda_vissza;
        this.ar = ar;
        this.ervenyes_ettol = ervenyes_ettol;
        this.ervenyes_eddig = ervenyes_eddig;
        this.datum = currentDate.format(myDateFormat);
        this.kedvezmeny = kedvezmeny;
    }

    public Jegy(String civ, String kezdo_megallo, String vegallomas, int kocsiosztaly, int ar, String ervenyes_ettol, String ervenyes_eddig, String datum, String kedvezmeny) {
        this.civ = civ;
        this.kezdo_megallo = kezdo_megallo;
        this.vegallomas = vegallomas;
        this.kocsiosztaly = kocsiosztaly;
        this.oda_vissza = false;
        this.ar = ar;
        this.ervenyes_ettol = ervenyes_ettol;
        this.ervenyes_eddig = ervenyes_eddig;
        this.datum = currentDate.format(myDateFormat);
        this.kedvezmeny = kedvezmeny;
    }

    public Jegy() {}

    public Jegy(String civ, String kezdo_megallo, String vegallomas, int kocsiosztaly, boolean b, String kedvezmeny, int ar) {
        this.civ = civ;
        this.kezdo_megallo = kezdo_megallo;
        this.vegallomas = vegallomas;
        this.kocsiosztaly = kocsiosztaly;
        this.oda_vissza = false;
        this.ar = ar;
        this.ervenyes_ettol = String.valueOf(LocalDate.now());
        this.ervenyes_eddig = String.valueOf(LocalDate.now().plusMonths(1));
        this.datum = currentDate.format(myDateFormat);
        this.kedvezmeny = kedvezmeny;
    }

    public int getJegy_id() {
        return jegy_id;
    }

    public void setJegy_id(int jegy_id) {
        this.jegy_id = jegy_id;
    }

    public String getCiv() {
        return civ;
    }

    public void setCiv(String civ) {
        this.civ = civ;
    }



    public String getKezdo_megallo() {
        return kezdo_megallo;
    }

    public void setKezdo_megallo(String kezdo_megallo) {
        this.kezdo_megallo = kezdo_megallo;
    }

    public String getVegallomas() {
        return vegallomas;
    }

    public void setVegallomas(String vegallomas) {
        this.vegallomas = vegallomas;
    }

    public int getKocsiosztaly() {
        return kocsiosztaly;
    }

    public void setKocsiosztaly(int kocsiosztaly) {
        this.kocsiosztaly = kocsiosztaly;
    }

    public Boolean isOda_vissza() {
        return oda_vissza;
    }

    public void setOda_vissza(Boolean oda_vissza) {
        this.oda_vissza = oda_vissza;
    }

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }

    public String getErvenyes_ettol() {
        return ervenyes_ettol;
    }

    public void setErvenyes_ettol(String ervenyes_ettol) {
        this.ervenyes_ettol = ervenyes_ettol;
    }

    public String getErvenyes_eddig() {
        return ervenyes_eddig;
    }

    public void setErvenyes_eddig(String ervenyes_eddig) {
        this.ervenyes_eddig = ervenyes_eddig;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getKedvezmeny() {
        return kedvezmeny;
    }

    public void setKedvezmeny(String kedvezmeny) {
        this.kedvezmeny = kedvezmeny;
    }

    @Override
    public String toString() {
        return "Jegy{" +
                "jegy_id=" + jegy_id +
                ", civ='" + civ + '\'' +
                ", kezdo_megallo='" + kezdo_megallo + '\'' +
                ", vegallomas='" + vegallomas + '\'' +
                ", kocsiosztaly=" + kocsiosztaly +
                ", oda_vissza=" + oda_vissza +
                ", ar=" + ar +
                ", ervenyes_ettol=" + ervenyes_ettol +
                ", ervenyes_eddig=" + ervenyes_eddig +
                ", datum=" + datum +
                '}';


    }


}
