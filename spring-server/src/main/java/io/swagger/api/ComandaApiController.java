package io.swagger.api;

import io.swagger.model.AUTORITEM;
import io.swagger.model.COMANDAITEM;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.repositories.ComandaRepository;
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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-05-16T16:00:11.731Z")

@Controller
public class ComandaApiController implements ComandaApi {

    private static final Logger log = LoggerFactory.getLogger(ComandaApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ComandaApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @org.springframework.beans.factory.annotation.Autowired
    io.swagger.repositories.ComandaRepository comandaRepository;

    public ResponseEntity<String> comandaBatchloadPost(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Object payload) {
        String accept = request.getHeader("Accept");
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

    public ResponseEntity<Object> comandaGet() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity(comandaRepository.getComanda(), HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Object>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<COMANDAITEM> comandaIdDelete(@Pattern(regexp="^[^/]+$") @ApiParam(value = "implicit",required=true) @PathVariable("id") String id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity(comandaRepository.deleteComanda(id), HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<COMANDAITEM>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<COMANDAITEM>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<COMANDAITEM> comandaIdGet(@Pattern(regexp="^[^/]+$") @ApiParam(value = "implicit",required=true) @PathVariable("id") String id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity(comandaRepository.getComanda(id), HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<COMANDAITEM>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<COMANDAITEM>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<COMANDAITEM> comandaIdPut(@Pattern(regexp="^[^/]+$") @ApiParam(value = "implicit",required=true) @PathVariable("id") String id,@ApiParam(value = "" ,required=true )  @Valid @RequestBody COMANDAITEM payload) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<COMANDAITEM>(comandaRepository.updateComanda(id, payload), HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<COMANDAITEM>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<COMANDAITEM>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<COMANDAITEM> comandaPost(@ApiParam(value = "" ,required=true )  @Valid @RequestBody COMANDAITEM payload) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<COMANDAITEM>(comandaRepository.addComanda(payload), HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<COMANDAITEM>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<COMANDAITEM>(HttpStatus.NOT_IMPLEMENTED);
    }

}
