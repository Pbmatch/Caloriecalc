package com.calorie.calc.spoonacular.client.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description = "")
public class InlineResponse20045  {
  
  @SerializedName("pairedWines")
  private List<String> pairedWines = null;
  @SerializedName("pairingText")
  private String pairingText = null;
  @SerializedName("productMatches")
  private List<InlineResponse20045ProductMatches> productMatches = null;

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public List<String> getPairedWines() {
    return pairedWines;
  }
  public void setPairedWines(List<String> pairedWines) {
    this.pairedWines = pairedWines;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public String getPairingText() {
    return pairingText;
  }
  public void setPairingText(String pairingText) {
    this.pairingText = pairingText;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public List<InlineResponse20045ProductMatches> getProductMatches() {
    return productMatches;
  }
  public void setProductMatches(List<InlineResponse20045ProductMatches> productMatches) {
    this.productMatches = productMatches;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse20045 inlineResponse20045 = (InlineResponse20045) o;
    return (this.pairedWines == null ? inlineResponse20045.pairedWines == null : this.pairedWines.equals(inlineResponse20045.pairedWines)) &&
        (this.pairingText == null ? inlineResponse20045.pairingText == null : this.pairingText.equals(inlineResponse20045.pairingText)) &&
        (this.productMatches == null ? inlineResponse20045.productMatches == null : this.productMatches.equals(inlineResponse20045.productMatches));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.pairedWines == null ? 0: this.pairedWines.hashCode());
    result = 31 * result + (this.pairingText == null ? 0: this.pairingText.hashCode());
    result = 31 * result + (this.productMatches == null ? 0: this.productMatches.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse20045 {\n");
    
    sb.append("  pairedWines: ").append(pairedWines).append("\n");
    sb.append("  pairingText: ").append(pairingText).append("\n");
    sb.append("  productMatches: ").append(productMatches).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
