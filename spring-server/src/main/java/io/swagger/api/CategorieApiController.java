package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.model.CATEGORIEITEM;
import io.swagger.repositories.CategorieRepository;
import io.swagger.repositories.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.io.IOException;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-05-16T16:00:11.731Z")

@Controller
public class CategorieApiController implements CategorieApi {

    private static final Logger log = LoggerFactory.getLogger(CategorieApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public CategorieApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @org.springframework.beans.factory.annotation.Autowired
    io.swagger.repositories.CategorieRepository categorieRepository;

    public ResponseEntity<String> categorieBatchloadPost(@PathVariable("db") String db, @ApiParam(value = "" ,required=true )  @Valid @RequestBody Object payload) {
       String accept = request.getHeader("Accept");

        Config config = new Config();
        config.setRepository( request.getRequestURL().toString() );
        categorieRepository = new CategorieRepository(config.getJdbcTemplate());
        if (accept != null && accept.contains("")) {
            try {
                return new ResponseEntity<String>(objectMapper.readValue("", String.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type ", e);
                return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<String>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Object> categorieGet(@PathVariable("db") String db) {
       String accept = request.getHeader("Accept");

        Config config = new Config();
        config.setRepository( request.getRequestURL().toString() );
        categorieRepository = new CategorieRepository(config.getJdbcTemplate());
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity(categorieRepository.getCategorie(), HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Object>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<CATEGORIEITEM> categorieIdDelete(@PathVariable("db") String db, @Pattern(regexp="^[^/]+$") @ApiParam(value = "implicit",required=true) @PathVariable("id") String id) {
       String accept = request.getHeader("Accept");

        Config config = new Config();
        config.setRepository( request.getRequestURL().toString() );
        categorieRepository = new CategorieRepository(config.getJdbcTemplate());
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity(categorieRepository.deleteCategorie(id), HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<CATEGORIEITEM>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<CATEGORIEITEM>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<CATEGORIEITEM> categorieIdGet(@PathVariable("db") String db, @Pattern(regexp="^[^/]+$") @ApiParam(value = "implicit",required=true) @PathVariable("id") String id) {
       String accept = request.getHeader("Accept");

        Config config = new Config();
        config.setRepository( request.getRequestURL().toString() );
        categorieRepository = new CategorieRepository(config.getJdbcTemplate());
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity(categorieRepository.getCategorie(id), HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<CATEGORIEITEM>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<CATEGORIEITEM>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<CATEGORIEITEM> categorieIdPut(@PathVariable("db") String db, @Pattern(regexp="^[^/]+$") @ApiParam(value = "implicit",required=true) @PathVariable("id") String id,@ApiParam(value = "" ,required=true )  @Valid @RequestBody CATEGORIEITEM payload) {
       String accept = request.getHeader("Accept");

        Config config = new Config();
        config.setRepository( request.getRequestURL().toString() );
        categorieRepository = new CategorieRepository(config.getJdbcTemplate());
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<CATEGORIEITEM>(categorieRepository.updateCategorie(id, payload), HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<CATEGORIEITEM>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<CATEGORIEITEM>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<CATEGORIEITEM> categoriePost(@PathVariable("db") String db, @ApiParam(value = "" ,required=true )  @Valid @RequestBody CATEGORIEITEM payload) {
       String accept = request.getHeader("Accept");

        Config config = new Config();
        config.setRepository( request.getRequestURL().toString() );
        categorieRepository = new CategorieRepository(config.getJdbcTemplate());
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<CATEGORIEITEM>(categorieRepository.addCategorie(payload), HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<CATEGORIEITEM>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<CATEGORIEITEM>(HttpStatus.NOT_IMPLEMENTED);
    }

}
