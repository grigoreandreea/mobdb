/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.27).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.PERSONALACHIZITIIITEM;
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
@Api(value = "personal_achizitii", description = "the personal_achizitii API")
@RequestMapping(value = "/ords/{db}")
public interface PersonalAchizitiiApi {

    @ApiOperation(value = "", nickname = "personalAchizitiiBatchloadPost", notes = "Create new records on PERSONAL_ACHIZITII", response = String.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The status of the processed records.", response = String.class) })
    @RequestMapping(value = "/personal_achizitii/batchload",
        produces = { "text/plain" }, 
        consumes = { "text/csv" },
        method = RequestMethod.POST)
    ResponseEntity<String> personalAchizitiiBatchloadPost(@PathVariable("db") String db, @ApiParam(value = "" ,required=true )  @Valid @RequestBody Object payload);


    @ApiOperation(value = "", nickname = "personalAchizitiiGet", notes = "Retrieve records from PERSONAL_ACHIZITII", response = Object.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The queried record.", response = Object.class) })
    @RequestMapping(value = "/personal_achizitii",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Object> personalAchizitiiGet(@PathVariable("db") String db);


    @ApiOperation(value = "", nickname = "personalAchizitiiIdDelete", notes = "Remove a record from PERSONAL_ACHIZITII", response = PERSONALACHIZITIIITEM.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Deleted result.", response = PERSONALACHIZITIIITEM.class) })
    @RequestMapping(value = "/personal_achizitii/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<PERSONALACHIZITIIITEM> personalAchizitiiIdDelete(@PathVariable("db") String db, @Pattern(regexp="^[^/]+$") @ApiParam(value = "implicit",required=true) @PathVariable("id") String id);


    @ApiOperation(value = "", nickname = "personalAchizitiiIdGet", notes = "Retrieve a record from PERSONAL_ACHIZITII", response = PERSONALACHIZITIIITEM.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The queried record.", response = PERSONALACHIZITIIITEM.class) })
    @RequestMapping(value = "/personal_achizitii/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<PERSONALACHIZITIIITEM> personalAchizitiiIdGet(@PathVariable("db") String db, @Pattern(regexp="^[^/]+$") @ApiParam(value = "implicit",required=true) @PathVariable("id") String id);


    @ApiOperation(value = "", nickname = "personalAchizitiiIdPut", notes = "Create or update a record on PERSONAL_ACHIZITII", response = PERSONALACHIZITIIITEM.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The successfully updated record.", response = PERSONALACHIZITIIITEM.class),
        @ApiResponse(code = 201, message = "The successfully created record.", response = PERSONALACHIZITIIITEM.class) })
    @RequestMapping(value = "/personal_achizitii/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<PERSONALACHIZITIIITEM> personalAchizitiiIdPut(@PathVariable("db") String db, @Pattern(regexp="^[^/]+$") @ApiParam(value = "implicit",required=true) @PathVariable("id") String id,@ApiParam(value = "" ,required=true )  @Valid @RequestBody PERSONALACHIZITIIITEM payload);


    @ApiOperation(value = "", nickname = "personalAchizitiiPost", notes = "Create a new record on PERSONAL_ACHIZITII", response = PERSONALACHIZITIIITEM.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "The successfully created record.", response = PERSONALACHIZITIIITEM.class) })
    @RequestMapping(value = "/personal_achizitii",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<PERSONALACHIZITIIITEM> personalAchizitiiPost(@PathVariable("db") String db, @ApiParam(value = "" ,required=true )  @Valid @RequestBody PERSONALACHIZITIIITEM payload);

}
