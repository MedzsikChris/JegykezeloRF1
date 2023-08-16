package application.dao;


import application.model.Megallo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class MegalloDAO extends JdbcDaoSupport {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initalize(){setDataSource(dataSource);}


    public void insertMegallo(Megallo megallo){
        String sql = "INSERT INTO megallo(nev, cim) VALUES (?, ?)";
        getJdbcTemplate().update(sql, new Object[]{
                megallo.getNev(), megallo.getCim()
        });
    }

    public List<Megallo> listMegallo(){
        String sql = "SELECT * FROM megallo ORDER BY nev";
        assert getJdbcTemplate() != null;
        List <Map< String, Object >> rows = getJdbcTemplate().queryForList(sql);

        List<Megallo> result = new ArrayList<Megallo>();
        for (Map < String, Object > row: rows){
            Megallo megallo = new Megallo();
            megallo.setMegallo_id((Integer)row.get("megallo_id"));
            megallo.setNev((String)row.get("nev"));
            megallo.setCim((String)row.get("cim"));

            result.add(megallo);
        }
        return result;
    }

    public void deleteMegallo(int megallo_id){
        String sql = "DELETE FROM megallo WHERE megallo_id=" + megallo_id;
        getJdbcTemplate().update(sql);
    }

    public void updateMegallo(int megallo_id, String nev, String cim){
        String sql = "UPDATE megallo SET nev='" + nev + "', cim='" + cim + "' WHERE megallo_id=" + megallo_id;
        getJdbcTemplate().update(sql);
    }
}
