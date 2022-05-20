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
 * BIBLIOTECARITEM
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-05-16T16:00:11.731Z")


public class BIBLIOTECARITEM   {
  @JsonProperty("cod_bibliotecar")
  private BigDecimal codBibliotecar = null;

  @JsonProperty("nume")
  private String nume = null;

  @JsonProperty("prenume")
  private String prenume = null;

  @JsonProperty("gen")
  private String gen = null;

  @JsonProperty("data_n")
  private String dataN = null;

  @JsonProperty("str_nr")
  private String strNr = null;

  @JsonProperty("localitate")
  private String localitate = null;

  public BIBLIOTECARITEM codBibliotecar(BigDecimal codBibliotecar) {
    this.codBibliotecar = codBibliotecar;
    return this;
  }

  /**
   * Get codBibliotecar
   * @return codBibliotecar
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getCodBibliotecar() {
    return codBibliotecar;
  }

  public void setCodBibliotecar(BigDecimal codBibliotecar) {
    this.codBibliotecar = codBibliotecar;
  }

  public BIBLIOTECARITEM nume(String nume) {
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

  public BIBLIOTECARITEM prenume(String prenume) {
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

  public BIBLIOTECARITEM gen(String gen) {
    this.gen = gen;
    return this;
  }

  /**
   * Get gen
   * @return gen
  **/
  @ApiModelProperty(value = "")


  public String getGen() {
    return gen;
  }

  public void setGen(String gen) {
    this.gen = gen;
  }

  public BIBLIOTECARITEM dataN(String dataN) {
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

  public BIBLIOTECARITEM strNr(String strNr) {
    this.strNr = strNr;
    return this;
  }

  /**
   * Get strNr
   * @return strNr
  **/
  @ApiModelProperty(value = "")


  public String getStrNr() {
    return strNr;
  }

  public void setStrNr(String strNr) {
    this.strNr = strNr;
  }

  public BIBLIOTECARITEM localitate(String localitate) {
    this.localitate = localitate;
    return this;
  }

  /**
   * Get localitate
   * @return localitate
  **/
  @ApiModelProperty(value = "")


  public String getLocalitate() {
    return localitate;
  }

  public void setLocalitate(String localitate) {
    this.localitate = localitate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BIBLIOTECARITEM BIBLIOTECAR_ITEM = (BIBLIOTECARITEM) o;
    return Objects.equals(this.codBibliotecar, BIBLIOTECAR_ITEM.codBibliotecar) &&
        Objects.equals(this.nume, BIBLIOTECAR_ITEM.nume) &&
        Objects.equals(this.prenume, BIBLIOTECAR_ITEM.prenume) &&
        Objects.equals(this.gen, BIBLIOTECAR_ITEM.gen) &&
        Objects.equals(this.dataN, BIBLIOTECAR_ITEM.dataN) &&
        Objects.equals(this.strNr, BIBLIOTECAR_ITEM.strNr) &&
        Objects.equals(this.localitate, BIBLIOTECAR_ITEM.localitate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codBibliotecar, nume, prenume, gen, dataN, strNr, localitate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BIBLIOTECARITEM {\n");
    
    sb.append("    codBibliotecar: ").append(toIndentedString(codBibliotecar)).append("\n");
    sb.append("    nume: ").append(toIndentedString(nume)).append("\n");
    sb.append("    prenume: ").append(toIndentedString(prenume)).append("\n");
    sb.append("    gen: ").append(toIndentedString(gen)).append("\n");
    sb.append("    dataN: ").append(toIndentedString(dataN)).append("\n");
    sb.append("    strNr: ").append(toIndentedString(strNr)).append("\n");
    sb.append("    localitate: ").append(toIndentedString(localitate)).append("\n");
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

