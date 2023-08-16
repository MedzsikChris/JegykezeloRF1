package application.dao;



import application.model.Jegy;
import application.model.Megallo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public class JegyDAO extends JdbcDaoSupport {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

   public void insertJegy(Jegy jegy){
        String sql = "INSERT INTO jegy(civ, kezdo_megallo, vegallomas, kocsiosztaly, oda_vissza, ar, ervenyes_ettol, ervenyes_eddig, datum, kedvezmeny) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        getJdbcTemplate().update(sql, new Object[]{
                jegy.getCiv(), jegy.getKezdo_megallo(), jegy.getVegallomas(), jegy.getKocsiosztaly(), jegy.isOda_vissza(), jegy.getAr(), jegy.getErvenyes_ettol(), jegy.getErvenyes_eddig(), jegy.getDatum(), jegy.getKedvezmeny()
        });
    }
    public List<Jegy> listJegy(){
        String sql = "SELECT * FROM jegy ORDER BY jegy_id";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Jegy> result = new ArrayList<Jegy>();
        for(Map<String, Object> row:rows){
            Jegy jegy = new Jegy();
            jegy.setJegy_id((Integer)row.get("jegy_id"));
            jegy.setCiv((String)row.get("civ"));
            jegy.setKezdo_megallo((String)row.get("kezdo_megallo"));
            jegy.setVegallomas((String)row.get("vegallomas"));
            jegy.setKocsiosztaly((Integer) row.get("kocsiosztaly"));
            jegy.setOda_vissza((Boolean) row.get("oda_vissza"));
            jegy.setAr((Integer) row.get("ar"));
            jegy.setErvenyes_ettol((String) row.get("ervenyes_ettol"));
            jegy.setErvenyes_eddig((String) row.get("ervenyes_eddig"));
            jegy.setDatum((String) row.get("datum"));
            jegy.setKedvezmeny((String) row.get("kedvezmeny"));
            result.add(jegy);
        }
        return result;
    }

    public List<Jegy> listJegy(String user){
        String sql = "SELECT * FROM jegy ORDER BY jegy_id";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Jegy> result = new ArrayList<Jegy>();

        for(Map<String, Object> row:rows){
            if (Objects.equals(user, (String) row.get("civ"))) {
                Jegy jegy = new Jegy();
                jegy.setJegy_id((Integer) row.get("jegy_id"));
                jegy.setCiv((String) row.get("civ"));
                jegy.setKezdo_megallo((String) row.get("kezdo_megallo"));
                jegy.setVegallomas((String) row.get("vegallomas"));
                jegy.setKocsiosztaly((Integer) row.get("kocsiosztaly"));
                jegy.setOda_vissza((Boolean) row.get("oda_vissza"));
                jegy.setAr((Integer) row.get("ar"));
                jegy.setErvenyes_ettol((String) row.get("ervenyes_ettol"));
                jegy.setErvenyes_eddig((String) row.get("ervenyes_eddig"));
                jegy.setDatum((String) row.get("datum"));
                jegy.setKedvezmeny((String) row.get("kedvezmeny"));
                result.add(jegy);
            }
        }
        return result;
    }

    public void updateJegy(int id, Jegy jegy){
        String sql =  "UPDATE jegy SET civ='"+jegy.getCiv()+"', kezdo_megallo='"+jegy.getKezdo_megallo()+"', vegallomas='"+jegy.getVegallomas()+"', kocsiosztaly='"+jegy.getKocsiosztaly()+"', oda_vissza='"+jegy.isOda_vissza()+"', ar='"+jegy.getAr()+"', ervenyes_ettol='"+jegy.getErvenyes_ettol()+"', ervenyes_eddig='"+jegy.getErvenyes_eddig()+"', datum='"+jegy.getDatum()+"', kedvezmeny='"+jegy.getKedvezmeny()+"' WHERE jegy_id="+id;
        getJdbcTemplate().update(sql);
    }
    public void deleteJegy(int id){
        String sql = "DELETE FROM jegy WHERE jegy_id="+id;
        getJdbcTemplate().update(sql);
    }
}





