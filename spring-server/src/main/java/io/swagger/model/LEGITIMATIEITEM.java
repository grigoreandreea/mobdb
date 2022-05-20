package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * LEGITIMATIEITEM
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-05-16T16:00:11.731Z")


public class LEGITIMATIEITEM   {
  @JsonProperty("serie_legitimatie")
  private String serieLegitimatie = null;

  @JsonProperty("data_expirare")
  private String dataExpirare = null;

  public LEGITIMATIEITEM serieLegitimatie(String serieLegitimatie) {
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

  public LEGITIMATIEITEM dataExpirare(String dataExpirare) {
    this.dataExpirare = dataExpirare;
    return this;
  }

  /**
   * Get dataExpirare
   * @return dataExpirare
  **/
  @ApiModelProperty(value = "")

@Pattern(regexp="^(([0-9])|([0-2][0-9])|([3][0-1]))\\-(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)\\-\\d{2}$")
  public String getDataExpirare() {
    return dataExpirare;
  }

  public void setDataExpirare(String dataExpirare) {
    this.dataExpirare = dataExpirare;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LEGITIMATIEITEM LEGITIMATIE_ITEM = (LEGITIMATIEITEM) o;
    return Objects.equals(this.serieLegitimatie, LEGITIMATIE_ITEM.serieLegitimatie) &&
        Objects.equals(this.dataExpirare, LEGITIMATIE_ITEM.dataExpirare);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serieLegitimatie, dataExpirare);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LEGITIMATIEITEM {\n");
    
    sb.append("    serieLegitimatie: ").append(toIndentedString(serieLegitimatie)).append("\n");
    sb.append("    dataExpirare: ").append(toIndentedString(dataExpirare)).append("\n");
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

