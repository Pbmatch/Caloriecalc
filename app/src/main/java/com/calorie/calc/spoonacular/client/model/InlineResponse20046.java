package com.calorie.calc.spoonacular.client.model;


import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description = "")
public class InlineResponse20046  {
  
  @SerializedName("wineDescription")
  private String wineDescription = null;

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public String getWineDescription() {
    return wineDescription;
  }
  public void setWineDescription(String wineDescription) {
    this.wineDescription = wineDescription;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse20046 inlineResponse20046 = (InlineResponse20046) o;
    return (this.wineDescription == null ? inlineResponse20046.wineDescription == null : this.wineDescription.equals(inlineResponse20046.wineDescription));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.wineDescription == null ? 0: this.wineDescription.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse20046 {\n");
    
    sb.append("  wineDescription: ").append(wineDescription).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
