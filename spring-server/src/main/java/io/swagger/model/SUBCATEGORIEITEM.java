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
 * SUBCATEGORIEITEM
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-05-21T14:27:53.479Z")


public class SUBCATEGORIEITEM   {
  @JsonProperty("cod_subcategorie")
  private BigDecimal codSubcategorie = null;

  @JsonProperty("cod_categorie")
  private BigDecimal codCategorie = null;

  @JsonProperty("denumire")
  private String denumire = null;

  public SUBCATEGORIEITEM codSubcategorie(BigDecimal codSubcategorie) {
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

  public SUBCATEGORIEITEM codCategorie(BigDecimal codCategorie) {
    this.codCategorie = codCategorie;
    return this;
  }

  /**
   * Get codCategorie
   * @return codCategorie
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getCodCategorie() {
    return codCategorie;
  }

  public void setCodCategorie(BigDecimal codCategorie) {
    this.codCategorie = codCategorie;
  }

  public SUBCATEGORIEITEM denumire(String denumire) {
    this.denumire = denumire;
    return this;
  }

  /**
   * Get denumire
   * @return denumire
  **/
  @ApiModelProperty(value = "")


  public String getDenumire() {
    return denumire;
  }

  public void setDenumire(String denumire) {
    this.denumire = denumire;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SUBCATEGORIEITEM SUBCATEGORIE_ITEM = (SUBCATEGORIEITEM) o;
    return Objects.equals(this.codSubcategorie, SUBCATEGORIE_ITEM.codSubcategorie) &&
        Objects.equals(this.codCategorie, SUBCATEGORIE_ITEM.codCategorie) &&
        Objects.equals(this.denumire, SUBCATEGORIE_ITEM.denumire);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codSubcategorie, codCategorie, denumire);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SUBCATEGORIEITEM {\n");
    
    sb.append("    codSubcategorie: ").append(toIndentedString(codSubcategorie)).append("\n");
    sb.append("    codCategorie: ").append(toIndentedString(codCategorie)).append("\n");
    sb.append("    denumire: ").append(toIndentedString(denumire)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

