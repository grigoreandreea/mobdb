package io.swagger.repositories;


import io.swagger.model.CARTEITEM;
import io.swagger.model.IMPRUMUTAITEM;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.threeten.bp.LocalDate;
import org.threeten.bp.format.DateTimeFormatter;

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

    public List<IMPRUMUTAITEM> getCartiImprumtateDe(String cod_cititor){
        String sql = "SELECT * FROM imprumuta where cod_cititor = " + cod_cititor;

        List<IMPRUMUTAITEM> carti = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(IMPRUMUTAITEM.class));

        return carti;
    }
    

    public List<IMPRUMUTAITEM> getImprumuta(String id){
        String sql = "SELECT * FROM imprumuta where cod_cititor = " + id;

        List<IMPRUMUTAITEM> imprumuturi = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(IMPRUMUTAITEM.class));

        return imprumuturi;
    }

    public IMPRUMUTAITEM addImprumuta(IMPRUMUTAITEM imprumuta) {
        LocalDate formatedDate = LocalDate.parse(imprumuta.getDataImprumut());
        String getDataImprumut = formatedDate.format(DateTimeFormatter.ofPattern("dd-MMM-yy"));
        formatedDate = LocalDate.parse(imprumuta.getDataRestituire());
        String getDataRestituire = formatedDate.format(DateTimeFormatter.ofPattern("dd-MMM-yy"));
        formatedDate = LocalDate.parse(imprumuta.getTermenLimita());
        String getTermenLimita = formatedDate.format(DateTimeFormatter.ofPattern("dd-MMM-yy"));

        String sql = "insert into imprumuta(cod_cititor, cod_carte, data_imprumut, data_restituire, termen_limita) values(" +
                imprumuta.getCodCititor() + ",'" +  imprumuta.getCodCarte()+ ",'" + getDataImprumut
                + ",'" +  getDataRestituire + ",'" +  getTermenLimita + "')";

        jdbcTemplate.execute(sql);

        return imprumuta;
    }

    public IMPRUMUTAITEM updateImprumuta(String id, IMPRUMUTAITEM imprumuta) {
        LocalDate formatedDate = LocalDate.parse(imprumuta.getDataImprumut());
        String getDataImprumut = formatedDate.format(DateTimeFormatter.ofPattern("dd-MMM-yy"));
        formatedDate = LocalDate.parse(imprumuta.getDataRestituire());
        String getDataRestituire = formatedDate.format(DateTimeFormatter.ofPattern("dd-MMM-yy"));
        formatedDate = LocalDate.parse(imprumuta.getTermenLimita());
        String getTermenLimita = formatedDate.format(DateTimeFormatter.ofPattern("dd-MMM-yy"));

        String SQL = "update imprumuta set data_imprumut = ?, data_restituire = ?, termen_limita  = ? where cod_cititor = ? and cod_carte = ?";
        jdbcTemplate.update(SQL, getDataImprumut, getDataRestituire, getTermenLimita, id, imprumuta.getCodCarte());

        return imprumuta;
    }

    public boolean deleteImprumuta(String id){
        String sql = "DELETE FROM imprumuta WHERE cod_cititor = ?";
        Object[] args = new Object[] {id};

        return jdbcTemplate.update(sql, args) == 1;
    }
}



