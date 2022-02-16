package com.calorie.calc.spoonacular.client.model;


import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class InlineResponse20030Ingredients  {
  
  @SerializedName("description")
  private Object description = null;
  @SerializedName("name")
  private String name = null;
  @SerializedName("safety_level")
  private Object safetyLevel = null;

  /**
   **/
  @ApiModelProperty(value = "")
  public Object getDescription() {
    return description;
  }
  public void setDescription(Object description) {
    this.description = description;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public Object getSafetyLevel() {
    return safetyLevel;
  }
  public void setSafetyLevel(Object safetyLevel) {
    this.safetyLevel = safetyLevel;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse20030Ingredients inlineResponse20030Ingredients = (InlineResponse20030Ingredients) o;
    return (this.description == null ? inlineResponse20030Ingredients.description == null : this.description.equals(inlineResponse20030Ingredients.description)) &&
        (this.name == null ? inlineResponse20030Ingredients.name == null : this.name.equals(inlineResponse20030Ingredients.name)) &&
        (this.safetyLevel == null ? inlineResponse20030Ingredients.safetyLevel == null : this.safetyLevel.equals(inlineResponse20030Ingredients.safetyLevel));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.description == null ? 0: this.description.hashCode());
    result = 31 * result + (this.name == null ? 0: this.name.hashCode());
    result = 31 * result + (this.safetyLevel == null ? 0: this.safetyLevel.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse20030Ingredients {\n");
    
    sb.append("  description: ").append(description).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  safetyLevel: ").append(safetyLevel).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
