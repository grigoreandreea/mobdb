package io.swagger.repositories;


import java.util.List;
import io.swagger.configuration.LocalDateConverter;
import io.swagger.model.LEGITIMATIEITEM;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.threeten.bp.LocalDate;
import org.threeten.bp.format.DateTimeFormatter;

@Repository
public class LegitimatieRepository {

    //@Autowired
    private JdbcTemplate jdbcTemplate = new Config().getJdbcTemplate();

    public List<LEGITIMATIEITEM> getLegitimatie(){
        String sql = "SELECT * FROM legitimatie";

        List<LEGITIMATIEITEM> legitimatiei = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(LEGITIMATIEITEM.class));

        return legitimatiei;
    }

    public LEGITIMATIEITEM getLegitimatie(String id){
        String sql = "SELECT * FROM legitimatie where serie_legitimatie = ?";

        LEGITIMATIEITEM legitimatie= jdbcTemplate.queryForObject(sql, new Object[]{id},BeanPropertyRowMapper.newInstance(LEGITIMATIEITEM.class));

        return legitimatie;
    }

    public LEGITIMATIEITEM addLegitimatie(LEGITIMATIEITEM legitimatie) {

        String sql = "insert into legitimatie(serie_legitimatie, data_expirare) values('" +
                legitimatie.getSerieLegitimatie() + "','" + legitimatie.getDataExpirare()  +  "')";

        jdbcTemplate.execute(sql);

        return legitimatie;
    }

    public LEGITIMATIEITEM updateLegitimatie(String id, LEGITIMATIEITEM legitimatie) {

        String SQL = "update legitimatie set data_expirare = ? where serie_legitimatie = ?";
        jdbcTemplate.update(SQL, legitimatie.getDataExpirare(), id);

        return legitimatie;
    }

    public boolean deleteLegitimatie(String id){
        String sql = "DELETE FROM legitimatie WHERE serie_legitimatie = ?";
        Object[] args = new Object[] {id};

        return jdbcTemplate.update(sql, args) == 1;
    }
}



