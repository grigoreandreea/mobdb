package io.swagger.repositories;

import java.util.List;
import io.swagger.model.CATEGORIEITEM;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CategorieRepository {

    //@Autowired
    private JdbcTemplate jdbcTemplate = new Config().getJdbcTemplate();

    public List<CATEGORIEITEM> getCategorie(){
        String sql = "SELECT * FROM categorie";

        List<CATEGORIEITEM> categoriei = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(CATEGORIEITEM.class));

        return categoriei;
    }

    public CATEGORIEITEM getCategorie(String id){
        String sql = "SELECT * FROM categorie where cod_categorie = ?";

        CATEGORIEITEM categorie= jdbcTemplate.queryForObject(sql, new Object[]{id},BeanPropertyRowMapper.newInstance(CATEGORIEITEM.class));

        return categorie;
    }

    public CATEGORIEITEM addCategorie(CATEGORIEITEM categorie) {

        String sql = "insert into categorie(cod_categorie, denumire) values(" +
                categorie.getCodCategorie() + ",'" +  categorie.getDenumire() +  "')";

        jdbcTemplate.execute(sql);

        return categorie;
    }

    public CATEGORIEITEM updateCategorie(String id, CATEGORIEITEM categorie) {


        String SQL = "update categorie set denumire = ? where cod_categorie = ?";
        jdbcTemplate.update(SQL, categorie.getDenumire(), id);

        return categorie;
    }

    public boolean deleteCategorie(String id){
        String sql = "DELETE FROM categorie WHERE cod_categorie = ?";
        Object[] args = new Object[] {id};

        return jdbcTemplate.update(sql, args) == 1;
    }
}



