/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.27).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.IMPRUMUTAITEM;
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
@Api(value = "imprumuta", description = "the imprumuta API")
@RequestMapping(value = "/ords/{db}")
public interface ImprumutaApi {

    @ApiOperation(value = "", nickname = "imprumutaBatchloadPost", notes = "Create new records on IMPRUMUTA", response = String.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The status of the processed records.", response = String.class) })
    @RequestMapping(value = "/imprumuta/batchload",
        produces = { "text/plain" }, 
        consumes = { "text/csv" },
        method = RequestMethod.POST)
    ResponseEntity<String> imprumutaBatchloadPost(@PathVariable("db") String db, @ApiParam(value = "" ,required=true )  @Valid @RequestBody Object payload);


    @ApiOperation(value = "", nickname = "imprumutaGet", notes = "Retrieve records from IMPRUMUTA", response = Object.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The queried record.", response = Object.class) })
    @RequestMapping(value = "/imprumuta",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Object> imprumutaGet(@PathVariable("db") String db);


    @ApiOperation(value = "", nickname = "imprumutaIdDelete", notes = "Remove a record from IMPRUMUTA", response = IMPRUMUTAITEM.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Deleted result.", response = IMPRUMUTAITEM.class) })
    @RequestMapping(value = "/imprumuta/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<IMPRUMUTAITEM> imprumutaIdDelete(@PathVariable("db") String db, @Pattern(regexp="^[^/]+$") @ApiParam(value = "implicit",required=true) @PathVariable("id") String id);


    @ApiOperation(value = "", nickname = "imprumutaIdGet", notes = "Retrieve a record from IMPRUMUTA", response = IMPRUMUTAITEM.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The queried record.", response = IMPRUMUTAITEM.class) })
    @RequestMapping(value = "/imprumuta/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<IMPRUMUTAITEM> imprumutaIdGet(@PathVariable("db") String db, @Pattern(regexp="^[^/]+$") @ApiParam(value = "implicit",required=true) @PathVariable("id") String id);


    @ApiOperation(value = "", nickname = "imprumutaIdPut", notes = "Create or update a record on IMPRUMUTA", response = IMPRUMUTAITEM.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The successfully updated record.", response = IMPRUMUTAITEM.class),
        @ApiResponse(code = 201, message = "The successfully created record.", response = IMPRUMUTAITEM.class) })
    @RequestMapping(value = "/imprumuta/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<IMPRUMUTAITEM> imprumutaIdPut(@PathVariable("db") String db, @Pattern(regexp="^[^/]+$") @ApiParam(value = "implicit",required=true) @PathVariable("id") String id,@ApiParam(value = "" ,required=true )  @Valid @RequestBody IMPRUMUTAITEM payload);


    @ApiOperation(value = "", nickname = "imprumutaPost", notes = "Create a new record on IMPRUMUTA", response = IMPRUMUTAITEM.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "The successfully created record.", response = IMPRUMUTAITEM.class) })
    @RequestMapping(value = "/imprumuta",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<IMPRUMUTAITEM> imprumutaPost(@PathVariable("db") String db, @ApiParam(value = "" ,required=true )  @Valid @RequestBody IMPRUMUTAITEM payload);

}
