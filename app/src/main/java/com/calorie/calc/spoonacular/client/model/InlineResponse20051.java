package com.calorie.calc.spoonacular.client.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description = "")
public class InlineResponse20051  {
  
  @SerializedName("annotations")
  private List<Object> annotations = null;

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public List<Object> getAnnotations() {
    return annotations;
  }
  public void setAnnotations(List<Object> annotations) {
    this.annotations = annotations;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse20051 inlineResponse20051 = (InlineResponse20051) o;
    return (this.annotations == null ? inlineResponse20051.annotations == null : this.annotations.equals(inlineResponse20051.annotations));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.annotations == null ? 0: this.annotations.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse20051 {\n");
    
    sb.append("  annotations: ").append(annotations).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
