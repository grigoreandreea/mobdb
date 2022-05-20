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
 * AUTORITEM
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-05-16T16:00:11.731Z")


public class AUTORITEM   {
  @JsonProperty("cod_autor")
  private BigDecimal codAutor = null;

  @JsonProperty("nume")
  private String nume = null;

  @JsonProperty("prenume")
  private String prenume = null;

  @JsonProperty("data_n")
  private String dataN = null;

  public AUTORITEM codAutor(BigDecimal codAutor) {
    this.codAutor = codAutor;
    return this;
  }

  /**
   * Get codAutor
   * @return codAutor
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getCodAutor() {
    return codAutor;
  }

  public void setCodAutor(BigDecimal codAutor) {
    this.codAutor = codAutor;
  }

  public AUTORITEM nume(String nume) {
    this.nume = nume;
    return this;
  }

  /**
   * Get nume
   * @return nume
  **/
  @ApiModelProperty(value = "")


  public String getNume() {
    return nume;
  }

  public void setNume(String nume) {
    this.nume = nume;
  }

  public AUTORITEM prenume(String prenume) {
    this.prenume = prenume;
    return this;
  }

  /**
   * Get prenume
   * @return prenume
  **/
  @ApiModelProperty(value = "")


  public String getPrenume() {
    return prenume;
  }

  public void setPrenume(String prenume) {
    this.prenume = prenume;
  }

  public AUTORITEM dataN(String dataN) {
    this.dataN = dataN;
    return this;
  }

  /**
   * Get dataN
   * @return dataN
  **/
  @ApiModelProperty(value = "")

@Pattern(regexp="^(([0-9])|([0-2][0-9])|([3][0-1]))\\-(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)\\-\\d{2}$")
  public String getDataN() {
    return dataN;
  }

  public void setDataN(String dataN) {
    this.dataN = dataN;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AUTORITEM AUTOR_ITEM = (AUTORITEM) o;
    return Objects.equals(this.codAutor, AUTOR_ITEM.codAutor) &&
        Objects.equals(this.nume, AUTOR_ITEM.nume) &&
        Objects.equals(this.prenume, AUTOR_ITEM.prenume) &&
        Objects.equals(this.dataN, AUTOR_ITEM.dataN);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codAutor, nume, prenume, dataN);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AUTORITEM {\n");
    
    sb.append("    codAutor: ").append(toIndentedString(codAutor)).append("\n");
    sb.append("    nume: ").append(toIndentedString(nume)).append("\n");
    sb.append("    prenume: ").append(toIndentedString(prenume)).append("\n");
    sb.append("    dataN: ").append(toIndentedString(dataN)).append("\n");
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

