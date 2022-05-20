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
 * CATEGORIEITEM
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-05-16T16:00:11.731Z")


public class CATEGORIEITEM   {
  @JsonProperty("cod_categorie")
  private BigDecimal codCategorie = null;

  @JsonProperty("denumire")
  private String denumire = null;

  public CATEGORIEITEM codCategorie(BigDecimal codCategorie) {
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

  public CATEGORIEITEM denumire(String denumire) {
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
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CATEGORIEITEM CATEGORIE_ITEM = (CATEGORIEITEM) o;
    return Objects.equals(this.codCategorie, CATEGORIE_ITEM.codCategorie) &&
        Objects.equals(this.denumire, CATEGORIE_ITEM.denumire);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codCategorie, denumire);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CATEGORIEITEM {\n");
    
    sb.append("    codCategorie: ").append(toIndentedString(codCategorie)).append("\n");
    sb.append("    denumire: ").append(toIndentedString(denumire)).append("\n");
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

