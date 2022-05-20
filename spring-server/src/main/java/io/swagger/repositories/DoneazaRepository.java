package io.swagger.repositories;

import io.swagger.model.DONEAZAITEM;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DoneazaRepository {

    private JdbcTemplate jdbcTemplate;

    @org.springframework.beans.factory.annotation.Autowired
    public DoneazaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<DONEAZAITEM> getDoneaza(){
        String sql = "SELECT * FROM doneaza";

        List<DONEAZAITEM> doneazai = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(DONEAZAITEM.class));

        return doneazai;
    }

    public DONEAZAITEM getDoneaza(String id){
        String sql = "SELECT * FROM doneaza where cod_donator = ?";

        DONEAZAITEM doneaza= jdbcTemplate.queryForObject(sql, new Object[]{id},BeanPropertyRowMapper.newInstance(DONEAZAITEM.class));

        return doneaza;
    }

    public DONEAZAITEM addDoneaza(DONEAZAITEM doneaza) {

        String sql = "insert into doneaza(cod_donator, cod_carte, nr_exemplare, data_donarii) values(" +
                doneaza.getCodDonator() + ",'" +  doneaza.getCodCarte() + "," +  doneaza.getNrExemplare() + ",'"
                +  doneaza.getDataDonarii() + "')";

        jdbcTemplate.execute(sql);

        return doneaza;
    }

    public DONEAZAITEM updateDoneaza(String id, DONEAZAITEM doneaza) {

        String SQL = "update doneaza set cod_carte = ?, nr_exemplare = ?, data_donarii = ? where cod_donator = ?";
        jdbcTemplate.update(SQL, doneaza.getCodCarte(), doneaza.getNrExemplare(), doneaza.getDataDonarii(), id);

        return doneaza;
    }

    public boolean deleteDoneaza(String id){
        String sql = "DELETE FROM doneaza WHERE cod_donator = ?";
        Object[] args = new Object[] {id};

        return jdbcTemplate.update(sql, args) == 1;
    }
}



