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


export interface IMPRUMUTAITEM { 
    codCititor?: NUMBER;
    codCarte?: NUMBER;
    dataImprumut?: DATE;
    termenLimita?: DATE;
    dataRestituire?: DATE;
}