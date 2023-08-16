package application.dao;
import application.model.Berlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class BerletDAO extends JdbcDaoSupport{

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }
    public List<Berlet> listBerlet(){
        String sql = "SELECT * FROM berletek ORDER BY berlet_id";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Berlet> result = new ArrayList<Berlet>();
        for(Map<String, Object> row:rows){
            Berlet berlet = new Berlet();
            berlet.setBerlet_id((String)row.get("berlet_id"));
            berlet.setFelhasznalo_id((String)row.get("felhasznalo_id"));
            berlet.setTulaj((String) row.get("tulaj"));
            berlet.setErvenyesseg_kezdet((String)row.get("ervenyesseg_kezdet"));
            berlet.setErvenyesseg_veg((String)row.get("ervenyesseg_veg"));
            berlet.setHonnan((String) row.get("honnan"));
            berlet.setHova((String) row.get("hova"));
            berlet.setTipus((String) row.get("tipus"));
            berlet.setKedvezmeny((String) row.get("kedvezmeny"));
        }
        return result;
    }
    public void insertBerlet(Berlet berlet){
        String sql = "INSERT INTO berletek(berlet_id, felhasznalo_id, tulaj, ervenyesseg_kezdet, ervenyesseg_veg, honnan, hova, tipus, kedvezmeny) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        getJdbcTemplate().update(sql, new Object[]{
                berlet.getBerlet_id(), berlet.getFelhasznalo_id(), berlet.getTulaj(), berlet.getErvenyesseg_kezdet(), berlet.getErvenyesseg_veg(), berlet.getHonnan(), berlet.getHova(), berlet.getTipus(), berlet.getKedvezmeny()});
    }
    public void deleteBerlet(String berlet_id){
        String sql = "DELETE FROM berletek WHERE felhasznalo="+berlet_id;
        getJdbcTemplate().update(sql);
    }
}
