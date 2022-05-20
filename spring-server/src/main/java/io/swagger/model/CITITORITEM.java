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
 * CITITORITEM
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-05-16T16:00:11.731Z")


public class CITITORITEM   {
  @JsonProperty("cod_cititor")
  private BigDecimal codCititor = null;

  @JsonProperty("serie_legitimatie")
  private String serieLegitimatie = null;

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

  @JsonProperty("email")
  private String email = null;

  public CITITORITEM codCititor(BigDecimal codCititor) {
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

  public CITITORITEM serieLegitimatie(String serieLegitimatie) {
    this.serieLegitimatie = serieLegitimatie;
    return this;
  }

  /**
   * Get serieLegitimatie
   * @return serieLegitimatie
  **/
  @ApiModelProperty(value = "")


  public String getSerieLegitimatie() {
    return serieLegitimatie;
  }

  public void setSerieLegitimatie(String serieLegitimatie) {
    this.serieLegitimatie = serieLegitimatie;
  }

  public CITITORITEM nume(String nume) {
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

  public CITITORITEM prenume(String prenume) {
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

  public CITITORITEM gen(String gen) {
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

  public CITITORITEM dataN(String dataN) {
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

  public CITITORITEM strNr(String strNr) {
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

  public CITITORITEM localitate(String localitate) {
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

  public CITITORITEM email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  **/
  @ApiModelProperty(value = "")


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CITITORITEM CITITOR_ITEM = (CITITORITEM) o;
    return Objects.equals(this.codCititor, CITITOR_ITEM.codCititor) &&
        Objects.equals(this.serieLegitimatie, CITITOR_ITEM.serieLegitimatie) &&
        Objects.equals(this.nume, CITITOR_ITEM.nume) &&
        Objects.equals(this.prenume, CITITOR_ITEM.prenume) &&
        Objects.equals(this.gen, CITITOR_ITEM.gen) &&
        Objects.equals(this.dataN, CITITOR_ITEM.dataN) &&
        Objects.equals(this.strNr, CITITOR_ITEM.strNr) &&
        Objects.equals(this.localitate, CITITOR_ITEM.localitate) &&
        Objects.equals(this.email, CITITOR_ITEM.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codCititor, serieLegitimatie, nume, prenume, gen, dataN, strNr, localitate, email);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CITITORITEM {\n");
    
    sb.append("    codCititor: ").append(toIndentedString(codCititor)).append("\n");
    sb.append("    serieLegitimatie: ").append(toIndentedString(serieLegitimatie)).append("\n");
    sb.append("    nume: ").append(toIndentedString(nume)).append("\n");
    sb.append("    prenume: ").append(toIndentedString(prenume)).append("\n");
    sb.append("    gen: ").append(toIndentedString(gen)).append("\n");
    sb.append("    dataN: ").append(toIndentedString(dataN)).append("\n");
    sb.append("    strNr: ").append(toIndentedString(strNr)).append("\n");
    sb.append("    localitate: ").append(toIndentedString(localitate)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
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

