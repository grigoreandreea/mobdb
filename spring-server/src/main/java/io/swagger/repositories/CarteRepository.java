package io.swagger.repositories;


import java.util.List;

import io.swagger.configuration.LocalDateConverter;
import io.swagger.model.CARTEITEM;
import io.swagger.model.CARTEITEM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.threeten.bp.LocalDate;
import org.threeten.bp.format.DateTimeFormatter;

import javax.sql.DataSource;



@Repository
public class CarteRepository {

    //    @Autowired
    private JdbcTemplate jdbcTemplate = new Config().getJdbcTemplate();

    public List<CARTEITEM> getCarti(){
        String sql = "SELECT * FROM carte";

        List<CARTEITEM> carti = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(CARTEITEM.class));

        return carti;
    }

    public CARTEITEM getCarte(String id){
        String sql = "SELECT * FROM carte where cod_carte = ?";

        CARTEITEM carte = jdbcTemplate.queryForObject(sql, new Object[]{id},BeanPropertyRowMapper.newInstance(CARTEITEM.class));

        return carte;
    }

    public CARTEITEM addCarte(CARTEITEM carte) {

        String sql = "insert into carte(cod_carte,titlu,cod_subcategorie, nr_exemplare) values(" +
                carte.getCodCarte() + ",'" +  carte.getTitlu() + "','" +  carte.getCodSubcategorie() + "'," +  carte.getNrExemplare() + ")";

        jdbcTemplate.execute(sql);

        return carte;
    }

    public CARTEITEM updateCarte(String id, CARTEITEM carte) {

        String SQL = "update carte set titlu = ?, cod_subcategorie = ?, nr_exemplare = ? where cod_carte = ?";
        jdbcTemplate.update(SQL, carte.getTitlu(), carte.getCodSubcategorie(), carte.getNrExemplare(), id);

        return carte;
    }

    public boolean deleteCarte(String id){
        String sql = "DELETE FROM carte WHERE cod_carte = ?";
        Object[] args = new Object[] {id};

        return jdbcTemplate.update(sql, args) == 1;
    }
}

