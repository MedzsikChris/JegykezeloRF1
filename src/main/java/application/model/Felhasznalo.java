package application.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.persistence.ElementCollection;

public class Felhasznalo implements UserDetails {

    private static final long serialVersionUID = 1L;
    private int felhasznalo_id;
    private String nev;
    private Date szul_datum;
    private String email;
    private String jelszo;
    @ElementCollection
    private ArrayList<String> kedvezmenyek;
    private String role;

    // private ArrayList<Jegy> jegyek;
    public Felhasznalo() {}
    public Felhasznalo(int felhasznalo_id, String nev, Date szul_datum, String email, String jelszo, ArrayList<String> kedvezmenyek, String role) {
        this.felhasznalo_id = felhasznalo_id;
        this.nev = nev;
        this.szul_datum = szul_datum;
        this.email = email;
        this.jelszo = jelszo;
        this.kedvezmenyek = kedvezmenyek;
        this.role = role;
    }
    public Felhasznalo(String nev, Date szul_datum, String email, String jelszo, ArrayList<String> kedvezmenyek, String role) {
        this.nev = nev;
        this.szul_datum = szul_datum;
        this.email = email;
        this.jelszo = jelszo;
        this.kedvezmenyek = kedvezmenyek;
        this.role = role;
    }

    public Felhasznalo(String nev, String email, String jelszo, ArrayList<String> kedvezmenyek, String role) {
        this.nev = nev;
        this.email = email;
        this.jelszo = jelszo;
        this.kedvezmenyek = kedvezmenyek;
        this.role = role;
    }

    public Felhasznalo(String nev, String email, String jelszo) {
        this.nev = nev;
        this.email = email;
        this.jelszo = jelszo;
    }

    public int getFelhasznalo_id() {
        return felhasznalo_id;
    }
    public void setFelhasznalo_id(int felhasznalo_id) {
        this.felhasznalo_id = felhasznalo_id;
    }

    public String getNev() {
        return nev;
    }
    public void setNev(String nev) {
        this.nev = nev;
    }

    public Date getSzul_datum() {
        return szul_datum;
    }
    public void setSzul_datum(Date szul_datum) {
        this.szul_datum = szul_datum;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return jelszo;
    }
    public void setPassword(String jelszo) {
        this.jelszo = jelszo;
    }

    public ArrayList<String> getKedvezmenyek() {
        return kedvezmenyek;
    }
    public void setKedvezmenyek(ArrayList<String> kedvezmenyek) {
        this.kedvezmenyek = kedvezmenyek;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Felhasznalo{" +
                "felhasznalo_id=" + felhasznalo_id +
                ", nev='" + nev + '\'' +
                ", szul_datum=" + szul_datum +
                ", email='" + email + '\'' +
                ", jelszo='" + jelszo + '\'' +
                ", kedvezmenyek=" + kedvezmenyek +
                '}';
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection < ? extends GrantedAuthority > getAuthorities() {
        Set < GrantedAuthority > authorities = new HashSet < GrantedAuthority > ();
        authorities.add(new SimpleGrantedAuthority(this.role));
        return authorities;
    }

    @Override
    public String getUsername() {
        return this.email;
    }
}
