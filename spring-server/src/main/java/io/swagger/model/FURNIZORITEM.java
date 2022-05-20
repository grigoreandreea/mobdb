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
 * FURNIZORITEM
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-05-16T16:00:11.731Z")


public class FURNIZORITEM   {
  @JsonProperty("cod_fz")
  private BigDecimal codFz = null;

  @JsonProperty("den_fz")
  private String denFz = null;

  @JsonProperty("email_fz")
  private String emailFz = null;

  @JsonProperty("cui")
  private String cui = null;

  public FURNIZORITEM codFz(BigDecimal codFz) {
    this.codFz = codFz;
    return this;
  }

  /**
   * Get codFz
   * @return codFz
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getCodFz() {
    return codFz;
  }

  public void setCodFz(BigDecimal codFz) {
    this.codFz = codFz;
  }

  public FURNIZORITEM denFz(String denFz) {
    this.denFz = denFz;
    return this;
  }

  /**
   * Get denFz
   * @return denFz
  **/
  @ApiModelProperty(value = "")


  public String getDenFz() {
    return denFz;
  }

  public void setDenFz(String denFz) {
    this.denFz = denFz;
  }

  public FURNIZORITEM emailFz(String emailFz) {
    this.emailFz = emailFz;
    return this;
  }

  /**
   * Get emailFz
   * @return emailFz
  **/
  @ApiModelProperty(value = "")


  public String getEmailFz() {
    return emailFz;
  }

  public void setEmailFz(String emailFz) {
    this.emailFz = emailFz;
  }

  public FURNIZORITEM cui(String cui) {
    this.cui = cui;
    return this;
  }

  /**
   * Get cui
   * @return cui
  **/
  @ApiModelProperty(value = "")


  public String getCui() {
    return cui;
  }

  public void setCui(String cui) {
    this.cui = cui;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FURNIZORITEM FURNIZOR_ITEM = (FURNIZORITEM) o;
    return Objects.equals(this.codFz, FURNIZOR_ITEM.codFz) &&
        Objects.equals(this.denFz, FURNIZOR_ITEM.denFz) &&
        Objects.equals(this.emailFz, FURNIZOR_ITEM.emailFz) &&
        Objects.equals(this.cui, FURNIZOR_ITEM.cui);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codFz, denFz, emailFz, cui);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FURNIZORITEM {\n");
    
    sb.append("    codFz: ").append(toIndentedString(codFz)).append("\n");
    sb.append("    denFz: ").append(toIndentedString(denFz)).append("\n");
    sb.append("    emailFz: ").append(toIndentedString(emailFz)).append("\n");
    sb.append("    cui: ").append(toIndentedString(cui)).append("\n");
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

