package io.swagger.repositories;


import java.util.List;
import io.swagger.configuration.LocalDateConverter;
import io.swagger.model.CITITORITEM;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.threeten.bp.LocalDate;
import org.threeten.bp.format.DateTimeFormatter;

@Repository
public class CititorRepository {

    //@Autowired
    private JdbcTemplate jdbcTemplate = new Config().getJdbcTemplate();

    public List<CITITORITEM> getCititor(){
        String sql = "SELECT * FROM cititor";

        List<CITITORITEM> cititori = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(CITITORITEM.class));

        return cititori;
    }

    public CITITORITEM getCititor(String id){
        String sql = "SELECT * FROM cititor where cod_cititor = ?";

        CITITORITEM cititor= jdbcTemplate.queryForObject(sql, new Object[]{id},BeanPropertyRowMapper.newInstance(CITITORITEM.class));

        return cititor;
    }

    public CITITORITEM addCititor(CITITORITEM cititor) {

        String sql = "insert into cititor(cod_cititor, nume, prenume, gen, data_n, str_nr, localitate, serie_legitimatie, email) values(" +
                cititor.getCodCititor() + ",'" +  cititor.getNume() + "','" +  cititor.getPrenume()
                + "','"+ cititor.getGen() + "','" + cititor.getDataN() + "','" + cititor.getStrNr() + "','"
                + cititor.getLocalitate() + "','" + cititor.getSerieLegitimatie()+ "','" + cititor.getEmail() +  "')";

        jdbcTemplate.execute(sql);

        return cititor;
    }

    public CITITORITEM updateCititor(String id, CITITORITEM cititor) {

        String SQL = "update cititor set nume = ?, prenume = ?, gen = ?, data_n = ?, str_nr = ?, localitate = ?, serie_legitimatie = ?, email = ?  where cod_cititor = ?";
        jdbcTemplate.update(SQL, cititor.getNume(), cititor.getPrenume(), cititor.getGen(), cititor.getDataN(), cititor.getStrNr(), cititor.getLocalitate(), cititor.getSerieLegitimatie(), cititor.getEmail(), id);

        return cititor;
    }

    public boolean deleteCititor(String id){
        String sql = "DELETE FROM cititor WHERE cod_cititor = ?";
        Object[] args = new Object[] {id};

        return jdbcTemplate.update(sql, args) == 1;
    }
}



