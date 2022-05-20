package io.swagger.repositories;


import java.util.List;
import io.swagger.configuration.LocalDateConverter;
import io.swagger.model.EMITEITEM;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.threeten.bp.LocalDate;
import org.threeten.bp.format.DateTimeFormatter;

@Repository
public class EmiteRepository {

    //@Autowired
    private JdbcTemplate jdbcTemplate = new Config().getJdbcTemplate();

    public List<EMITEITEM> getEmite(){
        String sql = "SELECT * FROM emite";

        List<EMITEITEM> emitei = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(EMITEITEM.class));

        return emitei;
    }

    public EMITEITEM getEmite(String id){
        String sql = "SELECT * FROM emite where serie_legitimatie = ?";

        EMITEITEM emite= jdbcTemplate.queryForObject(sql, new Object[]{id},BeanPropertyRowMapper.newInstance(EMITEITEM.class));

        return emite;
    }

    public EMITEITEM addEmite(EMITEITEM emite) {

        String sql = "insert into emite(serie_legitimatie, cod_bibliotecar) values('" +
                emite.getSerieLegitimatie() + "'," +  emite.getCodBibliotecar() + ")";

        jdbcTemplate.execute(sql);

        return emite;
    }

    public EMITEITEM updateEmite(String id, EMITEITEM emite) {

        String SQL = "update emite set cod_bibliotecar = ? where serie_legitimatie = ?";
        jdbcTemplate.update(SQL, emite.getCodBibliotecar(), id);

        return emite;
    }

    public boolean deleteEmite(String id){
        String sql = "DELETE FROM emite WHERE serie_legitimatie = ?";
        Object[] args = new Object[] {id};

        return jdbcTemplate.update(sql, args) == 1;
    }
}



