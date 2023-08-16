package application.dao;



import application.model.OfflineBerlet;
import application.model.Vonatkeses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class VonatkesesDAO extends JdbcDaoSupport {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }


    public List<Vonatkeses> vonatkesesList(){
        String sql = "SELECT * FROM kesesek ORDER BY vonat_id";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Vonatkeses> result = new ArrayList<>();
        for(Map<String, Object> row:rows){
            Vonatkeses kesesek = new Vonatkeses();
            kesesek.setVonat_id((Integer)row.get("vonat_id"));
            kesesek.setMennyit((Integer)row.get("mennyit"));
            kesesek.setHonnan((String)row.get("honnan"));
            kesesek.setHova((String)row.get("hova"));
            result.add(kesesek);
        }
        return result;
    }
}





