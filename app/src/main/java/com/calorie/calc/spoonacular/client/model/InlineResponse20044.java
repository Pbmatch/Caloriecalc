package com.calorie.calc.spoonacular.client.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description = "")
public class InlineResponse20044  {
  
  @SerializedName("pairings")
  private List<String> pairings = null;
  @SerializedName("text")
  private String text = null;

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public List<String> getPairings() {
    return pairings;
  }
  public void setPairings(List<String> pairings) {
    this.pairings = pairings;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public String getText() {
    return text;
  }
  public void setText(String text) {
    this.text = text;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse20044 inlineResponse20044 = (InlineResponse20044) o;
    return (this.pairings == null ? inlineResponse20044.pairings == null : this.pairings.equals(inlineResponse20044.pairings)) &&
        (this.text == null ? inlineResponse20044.text == null : this.text.equals(inlineResponse20044.text));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.pairings == null ? 0: this.pairings.hashCode());
    result = 31 * result + (this.text == null ? 0: this.text.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse20044 {\n");
    
    sb.append("  pairings: ").append(pairings).append("\n");
    sb.append("  text: ").append(text).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
