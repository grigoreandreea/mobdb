package io.swagger.repositories;


import io.swagger.model.DONATORITEM;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DonatorRepository {

    //@Autowired
    private JdbcTemplate jdbcTemplate = new Config().getJdbcTemplate();

    public List<DONATORITEM> getDonator(){
        String sql = "SELECT * FROM donator";

        List<DONATORITEM> donatori = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(DONATORITEM.class));

        return donatori;
    }

    public DONATORITEM getDonator(String id){
        String sql = "SELECT * FROM donator where cod_donator = ?";

        DONATORITEM donator= jdbcTemplate.queryForObject(sql, new Object[]{id},BeanPropertyRowMapper.newInstance(DONATORITEM.class));

        return donator;
    }

    public DONATORITEM addDonator(DONATORITEM donator) {

        String sql = "insert into donator(cod_donator, cod_tip, denumire) values('" +
                donator.getCodDonator() + "','" +  donator.getCodTip()+ "','" +  donator.getDenumire() + "')";

        jdbcTemplate.execute(sql);

        return donator;
    }

    public DONATORITEM updateDonator(String id, DONATORITEM donator) {

        String SQL = "update donator set cod_tip = ?, denumire = ? where cod_donator = ?";
        jdbcTemplate.update(SQL, donator.getCodTip(), donator.getDenumire(), id);

        return donator;
    }

    public boolean deleteDonator(String id){
        String sql = "DELETE FROM donator WHERE cod_donator = ?";
        Object[] args = new Object[] {id};

        return jdbcTemplate.update(sql, args) == 1;
    }
}



