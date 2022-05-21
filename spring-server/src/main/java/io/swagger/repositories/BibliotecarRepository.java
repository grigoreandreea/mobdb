package io.swagger.repositories;


import io.swagger.model.BIBLIOTECARITEM;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.threeten.bp.LocalDate;
import org.threeten.bp.format.DateTimeFormatter;

import java.util.List;

@Repository
public class BibliotecarRepository {

    private JdbcTemplate jdbcTemplate;

    @org.springframework.beans.factory.annotation.Autowired
    public BibliotecarRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<BIBLIOTECARITEM> getBibliotecar(){
        String sql = "SELECT * FROM bibliotecar";

        List<BIBLIOTECARITEM> bibliotecari = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(BIBLIOTECARITEM.class));

        return bibliotecari;
    }

    public BIBLIOTECARITEM getBibliotecar(String id){
        String sql = "SELECT * FROM bibliotecar where cod_bibliotecar = ?";

        BIBLIOTECARITEM bibliotecar= jdbcTemplate.queryForObject(sql, new Object[]{id},BeanPropertyRowMapper.newInstance(BIBLIOTECARITEM.class));

        return bibliotecar;
    }

    public BIBLIOTECARITEM addBibliotecar(BIBLIOTECARITEM bibliotecar) {

        LocalDate formatedDate = LocalDate.parse(bibliotecar.getDataN());
        String formattedDate = formatedDate.format(DateTimeFormatter.ofPattern("dd-MMM-yy"));

        String sql = "insert into bibliotecar(cod_bibliotecar, nume, prenume, gen, data_n, str_nr, localitate) values(" +
                bibliotecar.getCodBibliotecar() + ",'" +  bibliotecar.getNume() + "','" +  bibliotecar.getPrenume() + "','"
                + bibliotecar.getGen() + "','" + formattedDate + "','" + bibliotecar.getStrNr() + "','" + bibliotecar.getLocalitate() +  "')";

        jdbcTemplate.execute(sql);

        return bibliotecar;
    }

    public BIBLIOTECARITEM updateBibliotecar(String id, BIBLIOTECARITEM bibliotecar) {

        String SQL = "update bibliotecar set nume = ?, prenume = ?, gen = ?, data_n = ?, str_nr = ?, localitate = ?  where cod_bibliotecar = ?";
        jdbcTemplate.update(SQL, bibliotecar.getNume(), bibliotecar.getPrenume(), bibliotecar.getGen(), bibliotecar.getDataN(), bibliotecar.getStrNr(), bibliotecar.getLocalitate(), id);

        return bibliotecar;
    }

    public boolean deleteBibliotecar(String id){
        String sql = "DELETE FROM bibliotecar WHERE cod_bibliotecar = ?";
        Object[] args = new Object[] {id};

        return jdbcTemplate.update(sql, args) == 1;
    }
}



