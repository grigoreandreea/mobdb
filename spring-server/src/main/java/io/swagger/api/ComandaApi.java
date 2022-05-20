/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.27).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.COMANDAITEM;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-05-16T16:00:11.731Z")

@Validated
@Api(value = "comanda", description = "the comanda API")
@RequestMapping(value = "/ords/testuser2")
public interface ComandaApi {

    @ApiOperation(value = "", nickname = "comandaBatchloadPost", notes = "Create new records on COMANDA", response = String.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The status of the processed records.", response = String.class) })
    @RequestMapping(value = "/comanda/batchload",
        produces = { "text/plain" }, 
        consumes = { "text/csv" },
        method = RequestMethod.POST)
    ResponseEntity<String> comandaBatchloadPost(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Object payload);


    @ApiOperation(value = "", nickname = "comandaGet", notes = "Retrieve records from COMANDA", response = Object.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The queried record.", response = Object.class) })
    @RequestMapping(value = "/comanda",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Object> comandaGet();


    @ApiOperation(value = "", nickname = "comandaIdDelete", notes = "Remove a record from COMANDA", response = COMANDAITEM.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Deleted result.", response = COMANDAITEM.class) })
    @RequestMapping(value = "/comanda/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<COMANDAITEM> comandaIdDelete(@Pattern(regexp="^[^/]+$") @ApiParam(value = "implicit",required=true) @PathVariable("id") String id);


    @ApiOperation(value = "", nickname = "comandaIdGet", notes = "Retrieve a record from COMANDA", response = COMANDAITEM.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The queried record.", response = COMANDAITEM.class) })
    @RequestMapping(value = "/comanda/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<COMANDAITEM> comandaIdGet(@Pattern(regexp="^[^/]+$") @ApiParam(value = "implicit",required=true) @PathVariable("id") String id);


    @ApiOperation(value = "", nickname = "comandaIdPut", notes = "Create or update a record on COMANDA", response = COMANDAITEM.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The successfully updated record.", response = COMANDAITEM.class),
        @ApiResponse(code = 201, message = "The successfully created record.", response = COMANDAITEM.class) })
    @RequestMapping(value = "/comanda/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<COMANDAITEM> comandaIdPut(@Pattern(regexp="^[^/]+$") @ApiParam(value = "implicit",required=true) @PathVariable("id") String id,@ApiParam(value = "" ,required=true )  @Valid @RequestBody COMANDAITEM payload);


    @ApiOperation(value = "", nickname = "comandaPost", notes = "Create a new record on COMANDA", response = COMANDAITEM.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "The successfully created record.", response = COMANDAITEM.class) })
    @RequestMapping(value = "/comanda",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<COMANDAITEM> comandaPost(@ApiParam(value = "" ,required=true )  @Valid @RequestBody COMANDAITEM payload);

}