package io.swagger.repositories;


import io.swagger.model.LEGITIMATIEITEM;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.threeten.bp.LocalDate;
import org.threeten.bp.format.DateTimeFormatter;

import java.util.List;
import java.util.Random;

@Repository
public class LegitimatieRepository {

    private JdbcTemplate jdbcTemplate;

    @org.springframework.beans.factory.annotation.Autowired
    public LegitimatieRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


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

        LocalDate formatedDate = LocalDate.parse(legitimatie.getDataExpirare());
        String formattedDate = formatedDate.format(DateTimeFormatter.ofPattern("dd-MMM-yy"));

        String sql = "INSERT INTO legitimatie(serie_legitimatie, data_expirare) VALUES (?, ?)";
        Object[] params = new Object[] {legitimatie.getSerieLegitimatie(), formattedDate};

        jdbcTemplate.update(sql, params);

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

    public String generateSerieLegitimatie() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }
}



