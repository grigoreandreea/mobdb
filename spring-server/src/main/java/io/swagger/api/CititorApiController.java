package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.model.CITITORITEM;
import io.swagger.repositories.CititorRepository;
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
public class CititorApiController implements CititorApi {

    private static final Logger log = LoggerFactory.getLogger(CititorApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public CititorApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @org.springframework.beans.factory.annotation.Autowired
    io.swagger.repositories.CititorRepository cititorRepository;

    public ResponseEntity<String> cititorBatchloadPost(@PathVariable("db") String db, @ApiParam(value = "" ,required=true )  @Valid @RequestBody Object payload) {
       String accept = request.getHeader("Accept");

        Config config = new Config();
        config.setRepository( request.getRequestURL().toString() );
        cititorRepository = new CititorRepository(config.getJdbcTemplate());
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

    public ResponseEntity<Object> cititorGet(@PathVariable("db") String db) {
       String accept = request.getHeader("Accept");

        Config config = new Config();
        config.setRepository( request.getRequestURL().toString() );
        cititorRepository = new CititorRepository(config.getJdbcTemplate());
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity(cititorRepository.getCititor(), HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Object>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<CITITORITEM> cititorIdDelete(@PathVariable("db") String db, @Pattern(regexp="^[^/]+$") @ApiParam(value = "implicit",required=true) @PathVariable("id") String id) {
       String accept = request.getHeader("Accept");

        Config config = new Config();
        config.setRepository( request.getRequestURL().toString() );
        cititorRepository = new CititorRepository(config.getJdbcTemplate());
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity(cititorRepository.deleteCititor(id), HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<CITITORITEM>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<CITITORITEM>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<CITITORITEM> cititorIdGet(@PathVariable("db") String db, @Pattern(regexp="^[^/]+$") @ApiParam(value = "implicit",required=true) @PathVariable("id") String id) {
       String accept = request.getHeader("Accept");

        Config config = new Config();
        config.setRepository( request.getRequestURL().toString() );
        cititorRepository = new CititorRepository(config.getJdbcTemplate());
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity(cititorRepository.getCititor(id), HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<CITITORITEM>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<CITITORITEM>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<CITITORITEM> cititorIdPut(@PathVariable("db") String db, @Pattern(regexp="^[^/]+$") @ApiParam(value = "implicit",required=true) @PathVariable("id") String id,@ApiParam(value = "" ,required=true )  @Valid @RequestBody CITITORITEM payload) {
       String accept = request.getHeader("Accept");

        Config config = new Config();
        config.setRepository( request.getRequestURL().toString() );
        cititorRepository = new CititorRepository(config.getJdbcTemplate());
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<CITITORITEM>(cititorRepository.updateCititor(id, payload), HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<CITITORITEM>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<CITITORITEM>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<CITITORITEM> cititorPost(@PathVariable("db") String db, @ApiParam(value = "" ,required=true )  @Valid @RequestBody CITITORITEM payload) {
       String accept = request.getHeader("Accept");

        Config config = new Config();
        config.setRepository( request.getRequestURL().toString() );
        cititorRepository = new CititorRepository(config.getJdbcTemplate());
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<CITITORITEM>(cititorRepository.addCititor(payload), HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<CITITORITEM>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<CITITORITEM>(HttpStatus.NOT_IMPLEMENTED);
    }

}
