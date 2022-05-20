package io.swagger.api;

import io.swagger.model.AUTORITEM;
import io.swagger.model.FURNIZORITEM;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.repositories.FurnizorRepository;
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
public class FurnizorApiController implements FurnizorApi {

    private static final Logger log = LoggerFactory.getLogger(FurnizorApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public FurnizorApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @org.springframework.beans.factory.annotation.Autowired
    io.swagger.repositories.FurnizorRepository furnizorRepository;

    public ResponseEntity<String> furnizorBatchloadPost(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Object payload) {
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

    public ResponseEntity<Object> furnizorGet() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity(furnizorRepository.getFurnizor(), HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Object>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<FURNIZORITEM> furnizorIdDelete(@Pattern(regexp="^[^/]+$") @ApiParam(value = "implicit",required=true) @PathVariable("id") String id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity(furnizorRepository.deleteFurnizor(id), HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<FURNIZORITEM>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<FURNIZORITEM>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<FURNIZORITEM> furnizorIdGet(@Pattern(regexp="^[^/]+$") @ApiParam(value = "implicit",required=true) @PathVariable("id") String id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity(furnizorRepository.getFurnizor(id), HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<FURNIZORITEM>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<FURNIZORITEM>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<FURNIZORITEM> furnizorIdPut(@Pattern(regexp="^[^/]+$") @ApiParam(value = "implicit",required=true) @PathVariable("id") String id,@ApiParam(value = "" ,required=true )  @Valid @RequestBody FURNIZORITEM payload) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<FURNIZORITEM>(furnizorRepository.updateFurnizor(id, payload), HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<FURNIZORITEM>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<FURNIZORITEM>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<FURNIZORITEM> furnizorPost(@ApiParam(value = "" ,required=true )  @Valid @RequestBody FURNIZORITEM payload) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<FURNIZORITEM>(furnizorRepository.addFurnizor(payload), HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<FURNIZORITEM>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<FURNIZORITEM>(HttpStatus.NOT_IMPLEMENTED);
    }

}
