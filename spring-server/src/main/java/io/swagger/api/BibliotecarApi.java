/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.27).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.BIBLIOTECARITEM;
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
@Api(value = "bibliotecar", description = "the bibliotecar API")
@RequestMapping(value = "/ords/{db}")
public interface BibliotecarApi {

    @ApiOperation(value = "", nickname = "bibliotecarGet", notes = "Retrieve records from BIBLIOTECAR", response = Object.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The queried record.", response = Object.class) })
    @RequestMapping(value = "/bibliotecar",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Object> bibliotecarGet(@PathVariable("db") String db);


    @ApiOperation(value = "", nickname = "bibliotecarIdDelete", notes = "Remove a record from BIBLIOTECAR", response = BIBLIOTECARITEM.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Deleted result.", response = BIBLIOTECARITEM.class) })
    @RequestMapping(value = "/bibliotecar/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<BIBLIOTECARITEM> bibliotecarIdDelete(@PathVariable("db") String db, @Pattern(regexp="^[^/]+$") @ApiParam(value = "implicit",required=true) @PathVariable("id") String id);


    @ApiOperation(value = "", nickname = "bibliotecarIdGet", notes = "Retrieve a record from BIBLIOTECAR", response = BIBLIOTECARITEM.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The queried record.", response = BIBLIOTECARITEM.class) })
    @RequestMapping(value = "/bibliotecar/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<BIBLIOTECARITEM> bibliotecarIdGet(@PathVariable("db") String db, @Pattern(regexp="^[^/]+$") @ApiParam(value = "implicit",required=true) @PathVariable("id") String id);


    @ApiOperation(value = "", nickname = "bibliotecarIdPut", notes = "Create or update a record on BIBLIOTECAR", response = BIBLIOTECARITEM.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The successfully updated record.", response = BIBLIOTECARITEM.class),
        @ApiResponse(code = 201, message = "The successfully created record.", response = BIBLIOTECARITEM.class) })
    @RequestMapping(value = "/bibliotecar/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<BIBLIOTECARITEM> bibliotecarIdPut(@PathVariable("db") String db, @Pattern(regexp="^[^/]+$") @ApiParam(value = "implicit",required=true) @PathVariable("id") String id,@ApiParam(value = "" ,required=true )  @Valid @RequestBody BIBLIOTECARITEM payload);


    @ApiOperation(value = "", nickname = "bibliotecarPost", notes = "Create a new record on BIBLIOTECAR", response = BIBLIOTECARITEM.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "The successfully created record.", response = BIBLIOTECARITEM.class) })
    @RequestMapping(value = "/bibliotecar",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<BIBLIOTECARITEM> bibliotecarPost(@PathVariable("db") String db, @ApiParam(value = "" ,required=true )  @Valid @RequestBody BIBLIOTECARITEM payload);

}
