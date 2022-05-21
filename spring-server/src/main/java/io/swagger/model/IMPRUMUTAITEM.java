package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * IMPRUMUTAITEM
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-05-16T16:00:11.731Z")


public class IMPRUMUTAITEM   {
  @JsonProperty("cod_cititor")
  private BigDecimal codCititor = null;

  @JsonProperty("cod_carte")
  private BigDecimal codCarte = null;

  @JsonProperty("data_imprumut")
  private String dataImprumut = null;

  @JsonProperty("termen_limita")
  private String termenLimita = null;

  @JsonProperty("data_restituire")
  private String dataRestituire = null;

  public IMPRUMUTAITEM codCititor(BigDecimal codCititor) {
    this.codCititor = codCititor;
    return this;
  }

  /**
   * Get codCititor
   * @return codCititor
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getCodCititor() {
    return codCititor;
  }

  public void setCodCititor(BigDecimal codCititor) {
    this.codCititor = codCititor;
  }

  public IMPRUMUTAITEM codCarte(BigDecimal codCarte) {
    this.codCarte = codCarte;
    return this;
  }

  /**
   * Get codCarte
   * @return codCarte
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getCodCarte() {
    return codCarte;
  }

  public void setCodCarte(BigDecimal codCarte) {
    this.codCarte = codCarte;
  }

  public IMPRUMUTAITEM dataImprumut(String dataImprumut) {
    this.dataImprumut = dataImprumut;
    return this;
  }

  /**
   * Get dataImprumut
   * @return dataImprumut
  **/
  @ApiModelProperty(value = "")

@Pattern(regexp="^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$")
  public String getDataImprumut() {
    return dataImprumut;
  }

  public void setDataImprumut(String dataImprumut) {
    this.dataImprumut = dataImprumut;
  }

  public IMPRUMUTAITEM termenLimita(String termenLimita) {
    this.termenLimita = termenLimita;
    return this;
  }

  /**
   * Get termenLimita
   * @return termenLimita
  **/
  @ApiModelProperty(value = "")

@Pattern(regexp="^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$")
  public String getTermenLimita() {
    return termenLimita;
  }

  public void setTermenLimita(String termenLimita) {
    this.termenLimita = termenLimita;
  }

  public IMPRUMUTAITEM dataRestituire(String dataRestituire) {
    this.dataRestituire = dataRestituire;
    return this;
  }

  /**
   * Get dataRestituire
   * @return dataRestituire
  **/
  @ApiModelProperty(value = "")

@Pattern(regexp="^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$")
  public String getDataRestituire() {
    return dataRestituire;
  }

  public void setDataRestituire(String dataRestituire) {
    this.dataRestituire = dataRestituire;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IMPRUMUTAITEM IMPRUMUTA_ITEM = (IMPRUMUTAITEM) o;
    return Objects.equals(this.codCititor, IMPRUMUTA_ITEM.codCititor) &&
        Objects.equals(this.codCarte, IMPRUMUTA_ITEM.codCarte) &&
        Objects.equals(this.dataImprumut, IMPRUMUTA_ITEM.dataImprumut) &&
        Objects.equals(this.termenLimita, IMPRUMUTA_ITEM.termenLimita) &&
        Objects.equals(this.dataRestituire, IMPRUMUTA_ITEM.dataRestituire);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codCititor, codCarte, dataImprumut, termenLimita, dataRestituire);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IMPRUMUTAITEM {\n");
    
    sb.append("    codCititor: ").append(toIndentedString(codCititor)).append("\n");
    sb.append("    codCarte: ").append(toIndentedString(codCarte)).append("\n");
    sb.append("    dataImprumut: ").append(toIndentedString(dataImprumut)).append("\n");
    sb.append("    termenLimita: ").append(toIndentedString(termenLimita)).append("\n");
    sb.append("    dataRestituire: ").append(toIndentedString(dataRestituire)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

