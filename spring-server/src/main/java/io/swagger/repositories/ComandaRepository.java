package io.swagger.repositories;


import io.swagger.model.COMANDAITEM;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ComandaRepository {

    private JdbcTemplate jdbcTemplate;

    @org.springframework.beans.factory.annotation.Autowired
    public ComandaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<COMANDAITEM> getComanda(){
        String sql = "SELECT * FROM comanda";

        List<COMANDAITEM> comenzi = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(COMANDAITEM.class));

        return comenzi;
    }

    public COMANDAITEM getComanda(String id){
        String sql = "SELECT * FROM comanda where cod_comanda = ?";

        COMANDAITEM comanda = jdbcTemplate.queryForObject(sql, new Object[]{id},BeanPropertyRowMapper.newInstance(COMANDAITEM.class));

        return comanda;
    }

    public COMANDAITEM addComanda(COMANDAITEM comanda) {

        String sql = "insert into comanda(cod_comanda, anulata, cod_fz, cod_p_ac, data_plasare, total) values(" +
                comanda.getCodComanda() + ",'" +  comanda.getAnulata() + "'," +  comanda.getCodFz() + ","
                + comanda.getCodPAc() + ",'" + comanda.getDataPlasare() + "'," + comanda.getTotal() + ")";

        jdbcTemplate.execute(sql);

        return comanda;
    }

    public COMANDAITEM updateComanda(String id, COMANDAITEM comanda) {

        String SQL = "update comanda set anulata = ?, cod_fz = ?, cod_p_ac = ?, data_plasare = ?, total = ? where cod_comanda = ?";
        jdbcTemplate.update(SQL, comanda.getAnulata(), comanda.getCodFz(), comanda.getCodPAc(), comanda.getDataPlasare(), comanda.getTotal(), id);

        return comanda;
    }

    public boolean deleteComanda(String id){
        String sql = "DELETE FROM comanda WHERE cod_comanda = ?";
        Object[] args = new Object[] {id};

        return jdbcTemplate.update(sql, args) == 1;
    }
}



