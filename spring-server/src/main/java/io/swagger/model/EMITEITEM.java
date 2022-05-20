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
 * EMITEITEM
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-05-16T16:00:11.731Z")


public class EMITEITEM   {
  @JsonProperty("serie_legitimatie")
  private String serieLegitimatie = null;

  @JsonProperty("cod_bibliotecar")
  private BigDecimal codBibliotecar = null;

  public EMITEITEM serieLegitimatie(String serieLegitimatie) {
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

  public EMITEITEM codBibliotecar(BigDecimal codBibliotecar) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EMITEITEM EMITE_ITEM = (EMITEITEM) o;
    return Objects.equals(this.serieLegitimatie, EMITE_ITEM.serieLegitimatie) &&
        Objects.equals(this.codBibliotecar, EMITE_ITEM.codBibliotecar);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serieLegitimatie, codBibliotecar);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EMITEITEM {\n");
    
    sb.append("    serieLegitimatie: ").append(toIndentedString(serieLegitimatie)).append("\n");
    sb.append("    codBibliotecar: ").append(toIndentedString(codBibliotecar)).append("\n");
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

