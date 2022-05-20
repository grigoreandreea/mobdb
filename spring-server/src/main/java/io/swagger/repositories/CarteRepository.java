package io.swagger.repositories;


import io.swagger.model.CARTEITEM;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarteRepository {

    private JdbcTemplate jdbcTemplate;

    @org.springframework.beans.factory.annotation.Autowired
    public CarteRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

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

