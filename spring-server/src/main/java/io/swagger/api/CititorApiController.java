package io.swagger.api;

import io.swagger.model.AUTORITEM;
import io.swagger.model.CITITORITEM;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.repositories.CititorRepository;
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

    public ResponseEntity<String> cititorBatchloadPost(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Object payload) {
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

    public ResponseEntity<Object> cititorGet() {
        String accept = request.getHeader("Accept");
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

    public ResponseEntity<CITITORITEM> cititorIdDelete(@Pattern(regexp="^[^/]+$") @ApiParam(value = "implicit",required=true) @PathVariable("id") String id) {
        String accept = request.getHeader("Accept");
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

    public ResponseEntity<CITITORITEM> cititorIdGet(@Pattern(regexp="^[^/]+$") @ApiParam(value = "implicit",required=true) @PathVariable("id") String id) {
        String accept = request.getHeader("Accept");
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

    public ResponseEntity<CITITORITEM> cititorIdPut(@Pattern(regexp="^[^/]+$") @ApiParam(value = "implicit",required=true) @PathVariable("id") String id,@ApiParam(value = "" ,required=true )  @Valid @RequestBody CITITORITEM payload) {
        String accept = request.getHeader("Accept");
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

    public ResponseEntity<CITITORITEM> cititorPost(@ApiParam(value = "" ,required=true )  @Valid @RequestBody CITITORITEM payload) {
        String accept = request.getHeader("Accept");
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
