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
 * COMANDAITEM
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-05-16T16:00:11.731Z")


public class COMANDAITEM   {
  @JsonProperty("cod_comanda")
  private BigDecimal codComanda = null;

  @JsonProperty("cod_fz")
  private BigDecimal codFz = null;

  @JsonProperty("cod_p_ac")
  private BigDecimal codPAc = null;

  @JsonProperty("data_plasare")
  private String dataPlasare = null;

  @JsonProperty("anulata")
  private String anulata = null;

  @JsonProperty("total")
  private BigDecimal total = null;

  public COMANDAITEM codComanda(BigDecimal codComanda) {
    this.codComanda = codComanda;
    return this;
  }

  /**
   * Get codComanda
   * @return codComanda
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getCodComanda() {
    return codComanda;
  }

  public void setCodComanda(BigDecimal codComanda) {
    this.codComanda = codComanda;
  }

  public COMANDAITEM codFz(BigDecimal codFz) {
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

  public COMANDAITEM codPAc(BigDecimal codPAc) {
    this.codPAc = codPAc;
    return this;
  }

  /**
   * Get codPAc
   * @return codPAc
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getCodPAc() {
    return codPAc;
  }

  public void setCodPAc(BigDecimal codPAc) {
    this.codPAc = codPAc;
  }

  public COMANDAITEM dataPlasare(String dataPlasare) {
    this.dataPlasare = dataPlasare;
    return this;
  }

  /**
   * Get dataPlasare
   * @return dataPlasare
  **/
  @ApiModelProperty(value = "")

@Pattern(regexp="^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$")
  public String getDataPlasare() {
    return dataPlasare;
  }

  public void setDataPlasare(String dataPlasare) {
    this.dataPlasare = dataPlasare;
  }

  public COMANDAITEM anulata(String anulata) {
    this.anulata = anulata;
    return this;
  }

  /**
   * Get anulata
   * @return anulata
  **/
  @ApiModelProperty(value = "")


  public String getAnulata() {
    return anulata;
  }

  public void setAnulata(String anulata) {
    this.anulata = anulata;
  }

  public COMANDAITEM total(BigDecimal total) {
    this.total = total;
    return this;
  }

  /**
   * Get total
   * @return total
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getTotal() {
    return total;
  }

  public void setTotal(BigDecimal total) {
    this.total = total;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    COMANDAITEM COMANDA_ITEM = (COMANDAITEM) o;
    return Objects.equals(this.codComanda, COMANDA_ITEM.codComanda) &&
        Objects.equals(this.codFz, COMANDA_ITEM.codFz) &&
        Objects.equals(this.codPAc, COMANDA_ITEM.codPAc) &&
        Objects.equals(this.dataPlasare, COMANDA_ITEM.dataPlasare) &&
        Objects.equals(this.anulata, COMANDA_ITEM.anulata) &&
        Objects.equals(this.total, COMANDA_ITEM.total);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codComanda, codFz, codPAc, dataPlasare, anulata, total);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class COMANDAITEM {\n");
    
    sb.append("    codComanda: ").append(toIndentedString(codComanda)).append("\n");
    sb.append("    codFz: ").append(toIndentedString(codFz)).append("\n");
    sb.append("    codPAc: ").append(toIndentedString(codPAc)).append("\n");
    sb.append("    dataPlasare: ").append(toIndentedString(dataPlasare)).append("\n");
    sb.append("    anulata: ").append(toIndentedString(anulata)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
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

