/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.27).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.DONATORITEM;
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
@Api(value = "donator", description = "the donator API")
@RequestMapping(value = "/ords/{db}")
public interface DonatorApi {

    @ApiOperation(value = "", nickname = "donatorBatchloadPost", notes = "Create new records on DONATOR", response = String.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The status of the processed records.", response = String.class) })
    @RequestMapping(value = "/donator/batchload",
        produces = { "text/plain" }, 
        consumes = { "text/csv" },
        method = RequestMethod.POST)
    ResponseEntity<String> donatorBatchloadPost(@PathVariable("db") String db, @ApiParam(value = "" ,required=true )  @Valid @RequestBody Object payload);


    @ApiOperation(value = "", nickname = "donatorGet", notes = "Retrieve records from DONATOR", response = Object.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The queried record.", response = Object.class) })
    @RequestMapping(value = "/donator",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Object> donatorGet(@PathVariable("db") String db);


    @ApiOperation(value = "", nickname = "donatorIdDelete", notes = "Remove a record from DONATOR", response = DONATORITEM.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Deleted result.", response = DONATORITEM.class) })
    @RequestMapping(value = "/donator/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<DONATORITEM> donatorIdDelete(@PathVariable("db") String db, @Pattern(regexp="^[^/]+$") @ApiParam(value = "implicit",required=true) @PathVariable("id") String id);


    @ApiOperation(value = "", nickname = "donatorIdGet", notes = "Retrieve a record from DONATOR", response = DONATORITEM.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The queried record.", response = DONATORITEM.class) })
    @RequestMapping(value = "/donator/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<DONATORITEM> donatorIdGet(@PathVariable("db") String db, @Pattern(regexp="^[^/]+$") @ApiParam(value = "implicit",required=true) @PathVariable("id") String id);


    @ApiOperation(value = "", nickname = "donatorIdPut", notes = "Create or update a record on DONATOR", response = DONATORITEM.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The successfully updated record.", response = DONATORITEM.class),
        @ApiResponse(code = 201, message = "The successfully created record.", response = DONATORITEM.class) })
    @RequestMapping(value = "/donator/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<DONATORITEM> donatorIdPut(@PathVariable("db") String db, @Pattern(regexp="^[^/]+$") @ApiParam(value = "implicit",required=true) @PathVariable("id") String id,@ApiParam(value = "" ,required=true )  @Valid @RequestBody DONATORITEM payload);


    @ApiOperation(value = "", nickname = "donatorPost", notes = "Create a new record on DONATOR", response = DONATORITEM.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "The successfully created record.", response = DONATORITEM.class) })
    @RequestMapping(value = "/donator",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<DONATORITEM> donatorPost(@PathVariable("db") String db, @ApiParam(value = "" ,required=true )  @Valid @RequestBody DONATORITEM payload);

}
