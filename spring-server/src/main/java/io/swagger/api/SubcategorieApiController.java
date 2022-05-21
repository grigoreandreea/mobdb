package io.swagger.api;

import io.swagger.model.CATEGORIEITEM;
import io.swagger.model.SUBCATEGORIEITEM;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.repositories.SubcategorieRepository;
import io.swagger.repositories.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-05-21T14:27:53.479Z")

@Controller
public class SubcategorieApiController implements SubcategorieApi {

    private static final Logger log = LoggerFactory.getLogger(SubcategorieApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public SubcategorieApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @org.springframework.beans.factory.annotation.Autowired
    io.swagger.repositories.SubcategorieRepository subcategorieRepository;

    public ResponseEntity<Object> subcategorieGet(@PathVariable("db") String db) {
        String accept = request.getHeader("Accept");
        Config config = new Config();
        config.setRepository( request.getRequestURL().toString() );
        subcategorieRepository = new SubcategorieRepository(config.getJdbcTemplate());
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity(subcategorieRepository.getSubcategorie(), HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Object>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<SUBCATEGORIEITEM> subcategorieIdDelete(@PathVariable("db") String db, @Pattern(regexp="^[^/]+$") @ApiParam(value = "implicit",required=true) @PathVariable("id") String id) {
        String accept = request.getHeader("Accept");
        Config config = new Config();
        config.setRepository( request.getRequestURL().toString() );
        subcategorieRepository = new SubcategorieRepository(config.getJdbcTemplate());
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity(subcategorieRepository.deleteSubcategorie(id), HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<SUBCATEGORIEITEM>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<SUBCATEGORIEITEM>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<SUBCATEGORIEITEM> subcategorieIdGet(@PathVariable("db") String db, @Pattern(regexp="^[^/]+$") @ApiParam(value = "implicit",required=true) @PathVariable("id") String id) {
        String accept = request.getHeader("Accept");
        Config config = new Config();
        config.setRepository( request.getRequestURL().toString() );
        subcategorieRepository = new SubcategorieRepository(config.getJdbcTemplate());
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity(subcategorieRepository.getSubcategorie(id), HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<SUBCATEGORIEITEM>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<SUBCATEGORIEITEM>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<SUBCATEGORIEITEM> subcategorieIdPut(@PathVariable("db") String db, @Pattern(regexp="^[^/]+$") @ApiParam(value = "implicit",required=true) @PathVariable("id") String id,@ApiParam(value = "" ,required=true )  @Valid @RequestBody SUBCATEGORIEITEM payload) {
        String accept = request.getHeader("Accept");
        Config config = new Config();
        config.setRepository( request.getRequestURL().toString() );
        subcategorieRepository = new SubcategorieRepository(config.getJdbcTemplate());
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<SUBCATEGORIEITEM>(subcategorieRepository.updateSubcategorie(id, payload), HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<SUBCATEGORIEITEM>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<SUBCATEGORIEITEM>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<SUBCATEGORIEITEM> subcategoriePost(@PathVariable("db") String db, @ApiParam(value = "" ,required=true )  @Valid @RequestBody SUBCATEGORIEITEM payload) {
        String accept = request.getHeader("Accept");
        Config config = new Config();
        config.setRepository( request.getRequestURL().toString() );
        subcategorieRepository = new SubcategorieRepository(config.getJdbcTemplate());
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<SUBCATEGORIEITEM>(subcategorieRepository.addSubcategorie(payload), HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<SUBCATEGORIEITEM>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<SUBCATEGORIEITEM>(HttpStatus.NOT_IMPLEMENTED);
    }

}
