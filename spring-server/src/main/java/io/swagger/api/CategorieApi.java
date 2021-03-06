/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.27).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.CATEGORIEITEM;
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
@Api(value = "categorie", description = "the categorie API")
@RequestMapping(value = "/ords/{db}")
public interface CategorieApi {

    @ApiOperation(value = "", nickname = "categorieBatchloadPost", notes = "Create new records on CATEGORIE", response = String.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The status of the processed records.", response = String.class) })
    @RequestMapping(value = "/categorie/batchload",
        produces = { "text/plain" }, 
        consumes = { "text/csv" },
        method = RequestMethod.POST)
    ResponseEntity<String> categorieBatchloadPost(@PathVariable("db") String db, @ApiParam(value = "" ,required=true )  @Valid @RequestBody Object payload);


    @ApiOperation(value = "", nickname = "categorieGet", notes = "Retrieve records from CATEGORIE", response = Object.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The queried record.", response = Object.class) })
    @RequestMapping(value = "/categorie",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Object> categorieGet(@PathVariable("db") String db);


    @ApiOperation(value = "", nickname = "categorieIdDelete", notes = "Remove a record from CATEGORIE", response = CATEGORIEITEM.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Deleted result.", response = CATEGORIEITEM.class) })
    @RequestMapping(value = "/categorie/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<CATEGORIEITEM> categorieIdDelete(@PathVariable("db") String db, @Pattern(regexp="^[^/]+$") @ApiParam(value = "implicit",required=true) @PathVariable("id") String id);


    @ApiOperation(value = "", nickname = "categorieIdGet", notes = "Retrieve a record from CATEGORIE", response = CATEGORIEITEM.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The queried record.", response = CATEGORIEITEM.class) })
    @RequestMapping(value = "/categorie/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<CATEGORIEITEM> categorieIdGet(@PathVariable("db") String db, @Pattern(regexp="^[^/]+$") @ApiParam(value = "implicit",required=true) @PathVariable("id") String id);


    @ApiOperation(value = "", nickname = "categorieIdPut", notes = "Create or update a record on CATEGORIE", response = CATEGORIEITEM.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The successfully updated record.", response = CATEGORIEITEM.class),
        @ApiResponse(code = 201, message = "The successfully created record.", response = CATEGORIEITEM.class) })
    @RequestMapping(value = "/categorie/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<CATEGORIEITEM> categorieIdPut(@PathVariable("db") String db, @Pattern(regexp="^[^/]+$") @ApiParam(value = "implicit",required=true) @PathVariable("id") String id,@ApiParam(value = "" ,required=true )  @Valid @RequestBody CATEGORIEITEM payload);


    @ApiOperation(value = "", nickname = "categoriePost", notes = "Create a new record on CATEGORIE", response = CATEGORIEITEM.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "The successfully created record.", response = CATEGORIEITEM.class) })
    @RequestMapping(value = "/categorie",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<CATEGORIEITEM> categoriePost(@PathVariable("db") String db, @ApiParam(value = "" ,required=true )  @Valid @RequestBody CATEGORIEITEM payload);

}
