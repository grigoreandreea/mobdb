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
 * FORMATADINITEM
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-05-16T16:00:11.731Z")


public class FORMATADINITEM   {
  @JsonProperty("cod_comanda")
  private BigDecimal codComanda = null;

  @JsonProperty("cod_carte")
  private BigDecimal codCarte = null;

  @JsonProperty("nr_exemplare")
  private BigDecimal nrExemplare = null;

  @JsonProperty("pret_unitar")
  private BigDecimal pretUnitar = null;

  public FORMATADINITEM codComanda(BigDecimal codComanda) {
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

  public FORMATADINITEM codCarte(BigDecimal codCarte) {
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

  public FORMATADINITEM nrExemplare(BigDecimal nrExemplare) {
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

  public FORMATADINITEM pretUnitar(BigDecimal pretUnitar) {
    this.pretUnitar = pretUnitar;
    return this;
  }

  /**
   * Get pretUnitar
   * @return pretUnitar
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getPretUnitar() {
    return pretUnitar;
  }

  public void setPretUnitar(BigDecimal pretUnitar) {
    this.pretUnitar = pretUnitar;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FORMATADINITEM FORMATA_DIN_ITEM = (FORMATADINITEM) o;
    return Objects.equals(this.codComanda, FORMATA_DIN_ITEM.codComanda) &&
        Objects.equals(this.codCarte, FORMATA_DIN_ITEM.codCarte) &&
        Objects.equals(this.nrExemplare, FORMATA_DIN_ITEM.nrExemplare) &&
        Objects.equals(this.pretUnitar, FORMATA_DIN_ITEM.pretUnitar);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codComanda, codCarte, nrExemplare, pretUnitar);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FORMATADINITEM {\n");
    
    sb.append("    codComanda: ").append(toIndentedString(codComanda)).append("\n");
    sb.append("    codCarte: ").append(toIndentedString(codCarte)).append("\n");
    sb.append("    nrExemplare: ").append(toIndentedString(nrExemplare)).append("\n");
    sb.append("    pretUnitar: ").append(toIndentedString(pretUnitar)).append("\n");
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

