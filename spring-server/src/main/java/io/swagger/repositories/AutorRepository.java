package io.swagger.repositories;

import java.util.List;

import io.swagger.configuration.LocalDateConverter;
import io.swagger.model.AUTORITEM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.threeten.bp.LocalDate;
import org.threeten.bp.format.DateTimeFormatter;


@Repository
public class AutorRepository {

    private JdbcTemplate jdbcTemplate;

    @org.springframework.beans.factory.annotation.Autowired
    public AutorRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<AUTORITEM> getAuthors(){
        String sql = "SELECT * FROM autor";

        List<AUTORITEM> students = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(AUTORITEM.class));

        return students;
    }

    public AUTORITEM getAuthor(String id){
        String sql = "SELECT * FROM autor where cod_autor = ?";

        AUTORITEM autor = jdbcTemplate.queryForObject(sql, new Object[]{id},BeanPropertyRowMapper.newInstance(AUTORITEM.class));

        return autor;
    }

    public AUTORITEM addAuthor(AUTORITEM autor) {

        String sql = "insert into autor(cod_autor,nume,prenume, data_n) values(" +
                autor.getCodAutor() + ",'" +  autor.getNume() + "','" +  autor.getPrenume() + "','" +  autor.getDataN() + "')";

        jdbcTemplate.execute(sql);

        return autor;
    }


    public AUTORITEM updateAuthor(String id, AUTORITEM autor) {

        String SQL = "update autor set nume = ?, prenume = ?, data_n = ? where cod_autor = ?";
        jdbcTemplate.update(SQL, autor.getNume(), autor.getPrenume(), autor.getDataN(), id);

        return autor;
    }

    public boolean deleteAutor(String id){
        String sql = "DELETE FROM autor WHERE cod_autor = ?";
        Object[] args = new Object[] {id};

        return jdbcTemplate.update(sql, args) == 1;
    }
}

