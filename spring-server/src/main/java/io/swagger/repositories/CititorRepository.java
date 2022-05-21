package io.swagger.repositories;

import io.swagger.model.CITITORITEM;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.threeten.bp.LocalDate;
import org.threeten.bp.format.DateTimeFormatter;

import java.util.List;

@Repository
public class CititorRepository {

    //@Autowired
    private JdbcTemplate jdbcTemplate;

    @org.springframework.beans.factory.annotation.Autowired
    public CititorRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


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
        LocalDate formatedDate = LocalDate.parse(cititor.getDataN());

        String formattedDate = formatedDate.format(DateTimeFormatter.ofPattern("dd-MMM-yy"));

        String sql = "INSERT INTO cititor(cod_cititor, nume, prenume, gen, data_n, str_nr, localitate, serie_legitimatie, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Object[] params = new Object[] {  cititor.getCodCititor(),  cititor.getNume(),  cititor.getPrenume()
                ,cititor.getGen() ,formattedDate, cititor.getStrNr(),
                 cititor.getLocalitate(), cititor.getSerieLegitimatie(), cititor.getEmail() };

        jdbcTemplate.update(sql, params);

        return cititor;
    }

    public CITITORITEM updateCititor(String id, CITITORITEM cititor) {
        LocalDate formatedDate = LocalDate.parse(cititor.getDataN());

        String formattedDate = formatedDate.format(DateTimeFormatter.ofPattern("dd-MMM-yy"));

        String SQL = "update cititor set nume = ?, prenume = ?, gen = ?, data_n = ?, str_nr = ?, localitate = ?, serie_legitimatie = ?, email = ?  where cod_cititor = ?";
        jdbcTemplate.update(SQL, cititor.getNume(), cititor.getPrenume(), cititor.getGen(), formattedDate, cititor.getStrNr(), cititor.getLocalitate(), cititor.getSerieLegitimatie(), cititor.getEmail(), id);

        return cititor;
    }

    public boolean deleteCititor(String id){
        String sql = "DELETE FROM cititor WHERE cod_cititor = ?";
        Object[] args = new Object[] {id};

        return jdbcTemplate.update(sql, args) == 1;
    }
}



