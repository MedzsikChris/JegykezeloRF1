package application.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import application.model.Felhasznalo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Repository
public class FelhasznaloDAO extends JdbcDaoSupport {
    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    @Autowired
    DataSource dataSource;

    private int felhasznalo_id;
    private String nev;
    private Date szul_datum;
    private String email;
    private String jelszo;
    private ArrayList<String> kedvezmenyek;
    // private ArrayList<Jegy> jegyek;
    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }
    public void beszurFelhasznalot(Felhasznalo felhasznalo) {
        String sql = "INSERT INTO users(nev, email, jelszo) VALUES (?, ?, ?)";
        getJdbcTemplate().update(sql, new Object[] {
                felhasznalo.getNev(), felhasznalo.getEmail(), passwordEncoder.encode(felhasznalo.getPassword())
        });
    }

    public Felhasznalo getFelhasznaloById(int id) {
        String sql = "SELECT * FROM users WHERE id=?";
        List<Map< String, Object >> rows = getJdbcTemplate().queryForList(sql, id);

        List < Felhasznalo > result = new ArrayList < Felhasznalo > ();
        for (Map < String, Object > row: rows) {
            Felhasznalo felhasznalo = new Felhasznalo();
            felhasznalo.setFelhasznalo_id((Integer) row.get("felhasznalo_id"));
            felhasznalo.setNev((String) row.get("nev"));
            felhasznalo.setSzul_datum((Date) row.get("szul_datum"));
            felhasznalo.setEmail((String) row.get("email"));
            felhasznalo.setPassword((String) row.get("jelszo"));
            felhasznalo.setKedvezmenyek((ArrayList<String>) row.get("kedvezmenyek"));
            result.add(felhasznalo);
        }

        return result.get(0);
    }

    public Felhasznalo getFelhasznaloByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email=?";
        List < Map < String, Object >> rows = getJdbcTemplate().queryForList(sql, email);

        List < Felhasznalo > result = new ArrayList < Felhasznalo > ();
        for (Map < String, Object > row: rows) {
            Felhasznalo felhasznalo = new Felhasznalo();
            felhasznalo.setFelhasznalo_id((Integer) row.get("felhasznalo_id"));
            felhasznalo.setNev((String) row.get("nev"));
            felhasznalo.setSzul_datum((Date) row.get("szul_datum"));
            felhasznalo.setEmail((String) row.get("email"));
            felhasznalo.setPassword((String) row.get("jelszo"));
            felhasznalo.setKedvezmenyek((ArrayList<String>) row.get("kedvezmenyek"));
            result.add(felhasznalo);
        }
        return result.get(0);
    }

}
