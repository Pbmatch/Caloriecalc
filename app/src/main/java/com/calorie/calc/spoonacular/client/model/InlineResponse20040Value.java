package com.calorie.calc.spoonacular.client.model;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description = "")
public class InlineResponse20040Value  {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("servings")
  private BigDecimal servings = null;
  @SerializedName("title")
  private String title = null;
  @SerializedName("imageType")
  private String imageType = null;

  /**
   **/
  @ApiModelProperty(value = "")
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public BigDecimal getServings() {
    return servings;
  }
  public void setServings(BigDecimal servings) {
    this.servings = servings;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getImageType() {
    return imageType;
  }
  public void setImageType(String imageType) {
    this.imageType = imageType;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse20040Value inlineResponse20040Value = (InlineResponse20040Value) o;
    return (this.id == null ? inlineResponse20040Value.id == null : this.id.equals(inlineResponse20040Value.id)) &&
        (this.servings == null ? inlineResponse20040Value.servings == null : this.servings.equals(inlineResponse20040Value.servings)) &&
        (this.title == null ? inlineResponse20040Value.title == null : this.title.equals(inlineResponse20040Value.title)) &&
        (this.imageType == null ? inlineResponse20040Value.imageType == null : this.imageType.equals(inlineResponse20040Value.imageType));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.servings == null ? 0: this.servings.hashCode());
    result = 31 * result + (this.title == null ? 0: this.title.hashCode());
    result = 31 * result + (this.imageType == null ? 0: this.imageType.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse20040Value {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  servings: ").append(servings).append("\n");
    sb.append("  title: ").append(title).append("\n");
    sb.append("  imageType: ").append(imageType).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
