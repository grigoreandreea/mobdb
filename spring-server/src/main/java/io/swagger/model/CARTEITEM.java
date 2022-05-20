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
 * CARTEITEM
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-05-16T16:00:11.731Z")


public class CARTEITEM   {
  @JsonProperty("cod_carte")
  private BigDecimal codCarte = null;

  @JsonProperty("cod_subcategorie")
  private BigDecimal codSubcategorie = null;

  @JsonProperty("titlu")
  private String titlu = null;

  @JsonProperty("nr_exemplare")
  private BigDecimal nrExemplare = null;

  public CARTEITEM codCarte(BigDecimal codCarte) {
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

  public CARTEITEM codSubcategorie(BigDecimal codSubcategorie) {
    this.codSubcategorie = codSubcategorie;
    return this;
  }

  /**
   * Get codSubcategorie
   * @return codSubcategorie
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getCodSubcategorie() {
    return codSubcategorie;
  }

  public void setCodSubcategorie(BigDecimal codSubcategorie) {
    this.codSubcategorie = codSubcategorie;
  }

  public CARTEITEM titlu(String titlu) {
    this.titlu = titlu;
    return this;
  }

  /**
   * Get titlu
   * @return titlu
  **/
  @ApiModelProperty(value = "")


  public String getTitlu() {
    return titlu;
  }

  public void setTitlu(String titlu) {
    this.titlu = titlu;
  }

  public CARTEITEM nrExemplare(BigDecimal nrExemplare) {
    this.nrExemplare = nrExemplare;
    return this;
  }

  /**
   * Get nrExemplare
   * @return nrExemplare
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getNrExemplare() {
    return nrExemplare;
  }

  public void setNrExemplare(BigDecimal nrExemplare) {
    this.nrExemplare = nrExemplare;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CARTEITEM CARTE_ITEM = (CARTEITEM) o;
    return Objects.equals(this.codCarte, CARTE_ITEM.codCarte) &&
        Objects.equals(this.codSubcategorie, CARTE_ITEM.codSubcategorie) &&
        Objects.equals(this.titlu, CARTE_ITEM.titlu) &&
        Objects.equals(this.nrExemplare, CARTE_ITEM.nrExemplare);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codCarte, codSubcategorie, titlu, nrExemplare);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CARTEITEM {\n");
    
    sb.append("    codCarte: ").append(toIndentedString(codCarte)).append("\n");
    sb.append("    codSubcategorie: ").append(toIndentedString(codSubcategorie)).append("\n");
    sb.append("    titlu: ").append(toIndentedString(titlu)).append("\n");
    sb.append("    nrExemplare: ").append(toIndentedString(nrExemplare)).append("\n");
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

