/**
 * ORDS generated API for AUTOR
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */
import { DATE } from './dATE';
import { NUMBER } from './nUMBER';
import { VARCHAR2 } from './vARCHAR2';


export interface PERSONALACHIZITIIITEM { 
    codPAc?: NUMBER;
    nume?: VARCHAR2;
    prenume?: VARCHAR2;
    gen?: VARCHAR2;
    data_n?: DATE;
    str_nr?: VARCHAR2;
    localitate?: VARCHAR2;
}
