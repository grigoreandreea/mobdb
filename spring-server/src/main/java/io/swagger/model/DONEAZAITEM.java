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
 * DONEAZAITEM
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-05-16T16:00:11.731Z")


public class DONEAZAITEM   {
  @JsonProperty("cod_donator")
  private BigDecimal codDonator = null;

  @JsonProperty("cod_carte")
  private BigDecimal codCarte = null;

  @JsonProperty("data_donarii")
  private String dataDonarii = null;

  @JsonProperty("nr_exemplare")
  private BigDecimal nrExemplare = null;

  public DONEAZAITEM codDonator(BigDecimal codDonator) {
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

  public DONEAZAITEM codCarte(BigDecimal codCarte) {
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

  public DONEAZAITEM dataDonarii(String dataDonarii) {
    this.dataDonarii = dataDonarii;
    return this;
  }

  /**
   * Get dataDonarii
   * @return dataDonarii
  **/
  @ApiModelProperty(value = "")

@Pattern(regexp="^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$")
  public String getDataDonarii() {
    return dataDonarii;
  }

  public void setDataDonarii(String dataDonarii) {
    this.dataDonarii = dataDonarii;
  }

  public DONEAZAITEM nrExemplare(BigDecimal nrExemplare) {
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
    DONEAZAITEM DONEAZA_ITEM = (DONEAZAITEM) o;
    return Objects.equals(this.codDonator, DONEAZA_ITEM.codDonator) &&
        Objects.equals(this.codCarte, DONEAZA_ITEM.codCarte) &&
        Objects.equals(this.dataDonarii, DONEAZA_ITEM.dataDonarii) &&
        Objects.equals(this.nrExemplare, DONEAZA_ITEM.nrExemplare);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codDonator, codCarte, dataDonarii, nrExemplare);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DONEAZAITEM {\n");
    
    sb.append("    codDonator: ").append(toIndentedString(codDonator)).append("\n");
    sb.append("    codCarte: ").append(toIndentedString(codCarte)).append("\n");
    sb.append("    dataDonarii: ").append(toIndentedString(dataDonarii)).append("\n");
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

