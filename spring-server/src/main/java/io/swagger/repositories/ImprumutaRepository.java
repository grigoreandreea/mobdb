package io.swagger.repositories;


import io.swagger.model.IMPRUMUTAITEM;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ImprumutaRepository {

    private JdbcTemplate jdbcTemplate;

    @org.springframework.beans.factory.annotation.Autowired
    public ImprumutaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<IMPRUMUTAITEM> getImprumuta(){
        String sql = "SELECT * FROM imprumuta";

        List<IMPRUMUTAITEM> imprumuturi = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(IMPRUMUTAITEM.class));

        return imprumuturi;
    }

    public List<IMPRUMUTAITEM> getImprumuta(String id){
        String sql = "SELECT * FROM imprumuta where cod_cititor = " + id;

        List<IMPRUMUTAITEM> imprumuturi = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(IMPRUMUTAITEM.class));

        return imprumuturi;
    }

    public IMPRUMUTAITEM addImprumuta(IMPRUMUTAITEM imprumuta) {

        String sql = "insert into imprumuta(cod_cititor, cod_carte, data_imprumut, data_restituire, termen_limita) values(" +
                imprumuta.getCodCititor() + ",'" +  imprumuta.getCodCarte()+ ",'" +  imprumuta.getDataImprumut()
                + ",'" +  imprumuta.getDataRestituire() + ",'" +  imprumuta.getTermenLimita() + "')";

        jdbcTemplate.execute(sql);

        return imprumuta;
    }

    public IMPRUMUTAITEM updateImprumuta(String id, IMPRUMUTAITEM imprumuta) {

        String SQL = "update imprumuta set data_imprumut = ?, data_restituire = ?, termen_limita  = ? where cod_cititor = ?";
        jdbcTemplate.update(SQL, imprumuta.getCodCititor(),imprumuta.getDataImprumut(), imprumuta.getDataRestituire(), imprumuta.getTermenLimita(), id);

        return imprumuta;
    }

    public boolean deleteImprumuta(String id){
        String sql = "DELETE FROM imprumuta WHERE cod_cititor = ?";
        Object[] args = new Object[] {id};

        return jdbcTemplate.update(sql, args) == 1;
    }
}



