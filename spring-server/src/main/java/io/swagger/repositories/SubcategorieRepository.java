package io.swagger.repositories;

import io.swagger.model.SUBCATEGORIEITEM;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubcategorieRepository {

    private JdbcTemplate jdbcTemplate;

    @org.springframework.beans.factory.annotation.Autowired
    public SubcategorieRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<SUBCATEGORIEITEM> getSubcategorie(){
        String sql = "SELECT * FROM subcategorie";

        List<SUBCATEGORIEITEM> subcategoriei = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(SUBCATEGORIEITEM.class));

        return subcategoriei;
    }

    public SUBCATEGORIEITEM getSubcategorie(String id){
        String sql = "SELECT * FROM subcategorie where cod_subcategorie = ?";

        SUBCATEGORIEITEM subcategorie= jdbcTemplate.queryForObject(sql, new Object[]{id},BeanPropertyRowMapper.newInstance(SUBCATEGORIEITEM.class));

        return subcategorie;
    }

    public SUBCATEGORIEITEM addSubcategorie(SUBCATEGORIEITEM subcategorie) {

        String sql = "insert into subcategorie(cod_subcategorie, cod_categorie, denumire) values(" +
                subcategorie.getCodSubcategorie() + "," + subcategorie.getCodCategorie() + ",'" + subcategorie.getDenumire() +  "')";

        jdbcTemplate.execute(sql);

        return subcategorie;
    }

    public SUBCATEGORIEITEM updateSubcategorie(String id, SUBCATEGORIEITEM subcategorie) {

        String SQL = "update subcategorie set denumire = ?, cod_categorie = ? where cod_subcategorie = ?";
        jdbcTemplate.update(SQL, subcategorie.getDenumire(),  subcategorie.getCodCategorie(), id);

        return subcategorie;
    }

    public boolean deleteSubcategorie(String id){
        String sql = "DELETE FROM subcategorie WHERE cod_subcategorie = ?";
        Object[] args = new Object[] {id};

        return jdbcTemplate.update(sql, args) == 1;
    }
}



