package application.dao;



import application.model.Jegy;
import application.model.OfflineBerlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.*;

@Repository
public class OfflineBerletDAO extends JdbcDaoSupport {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }


    public List<OfflineBerlet> listBerlet(String user){
        String sql = "SELECT * FROM berletek ORDER BY berlet_id";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<OfflineBerlet> result = new ArrayList<>();
        for(Map<String, Object> row:rows){
            if (Objects.equals(user, (String) row.get("felhasznalo_id"))) {
                OfflineBerlet berlet = new OfflineBerlet();
                berlet.setBerlet_id((String) row.get("berlet_id"));
                berlet.setTulaj((String) row.get("tulaj"));
                berlet.setErvenyesseg_kezdet((String) row.get("ervenyesseg_kezdet"));
                berlet.setErvenyesseg_veget((String) row.get("ervenyesseg_veg"));
                berlet.setHonnan((String) row.get("honnan"));
                berlet.setHova((String) row.get("hova"));
                berlet.setTipus((String) row.get("tipus"));
                berlet.setKedvezmeny((String) row.get("kedvezmeny"));
                result.add(berlet);
            }
        }
        return result;
    }
}