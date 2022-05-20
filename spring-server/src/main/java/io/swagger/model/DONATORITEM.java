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
 * DONATORITEM
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-05-16T16:00:11.731Z")


public class DONATORITEM   {
  @JsonProperty("cod_donator")
  private BigDecimal codDonator = null;

  @JsonProperty("cod_tip")
  private BigDecimal codTip = null;

  @JsonProperty("denumire")
  private String denumire = null;

  public DONATORITEM codDonator(BigDecimal codDonator) {
    this.codDonator = codDonator;
    return this;
  }

  /**
   * Get codDonator
   * @return codDonator
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getCodDonator() {
    return codDonator;
  }

  public void setCodDonator(BigDecimal codDonator) {
    this.codDonator = codDonator;
  }

  public DONATORITEM codTip(BigDecimal codTip) {
    this.codTip = codTip;
    return this;
  }

  /**
   * Get codTip
   * @return codTip
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getCodTip() {
    return codTip;
  }

  public void setCodTip(BigDecimal codTip) {
    this.codTip = codTip;
  }

  public DONATORITEM denumire(String denumire) {
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
    DONATORITEM DONATOR_ITEM = (DONATORITEM) o;
    return Objects.equals(this.codDonator, DONATOR_ITEM.codDonator) &&
        Objects.equals(this.codTip, DONATOR_ITEM.codTip) &&
        Objects.equals(this.denumire, DONATOR_ITEM.denumire);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codDonator, codTip, denumire);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DONATORITEM {\n");
    
    sb.append("    codDonator: ").append(toIndentedString(codDonator)).append("\n");
    sb.append("    codTip: ").append(toIndentedString(codTip)).append("\n");
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

