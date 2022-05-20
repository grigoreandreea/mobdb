package io.swagger.repositories;

import java.util.List;
import io.swagger.configuration.LocalDateConverter;
import io.swagger.model.FURNIZORITEM;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.threeten.bp.LocalDate;
import org.threeten.bp.format.DateTimeFormatter;

@Repository
public class FurnizorRepository {

    //@Autowired
    private JdbcTemplate jdbcTemplate = new Config().getJdbcTemplate();

    public List<FURNIZORITEM> getFurnizor(){
        String sql = "SELECT * FROM furnizor";

        List<FURNIZORITEM> furnizori = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(FURNIZORITEM.class));

        return furnizori;
    }

    public FURNIZORITEM getFurnizor(String id){
        String sql = "SELECT * FROM furnizor where cod_fz = ?";

        FURNIZORITEM furnizor= jdbcTemplate.queryForObject(sql, new Object[]{id},BeanPropertyRowMapper.newInstance(FURNIZORITEM.class));

        return furnizor;
    }

    public FURNIZORITEM addFurnizor(FURNIZORITEM furnizor) {
        
        String sql = "insert into furnizor(cod_fz, cui, den_fz, email_fz) values(" +
                furnizor.getCodFz() + ",'" +  furnizor.getCui() + "','" +  furnizor.getDenFz() + "','"+ furnizor.getEmailFz() + "')";

        jdbcTemplate.execute(sql);

        return furnizor;
    }

    public FURNIZORITEM updateFurnizor(String id, FURNIZORITEM furnizor) {

        String SQL = "update furnizor set cui = ?, den_fz = ?, email_fz = ?  where cod_fz = ?";
        jdbcTemplate.update(SQL, furnizor.getCui(), furnizor.getDenFz(), furnizor.getEmailFz(), id);

        return furnizor;
    }

    public boolean deleteFurnizor(String id){
        String sql = "DELETE FROM furnizor WHERE cod_fz = ?";
        Object[] args = new Object[] {id};

        return jdbcTemplate.update(sql, args) == 1;
    }
}

