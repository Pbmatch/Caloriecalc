package com.calorie.calc.spoonacular.client.model;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description = "")
public class InlineResponse20053Results  {
  
  @SerializedName("id")
  private String id = null;
  @SerializedName("name")
  private String name = null;
  @SerializedName("image")
  private String image = null;
  @SerializedName("link")
  private String link = null;
  @SerializedName("type")
  private String type = null;
  @SerializedName("relevance")
  private BigDecimal relevance = null;
  @SerializedName("content")
  private String content = null;

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
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
  @ApiModelProperty(required = true, value = "")
  public String getImage() {
    return image;
  }
  public void setImage(String image) {
    this.image = image;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public String getLink() {
    return link;
  }
  public void setLink(String link) {
    this.link = link;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public BigDecimal getRelevance() {
    return relevance;
  }
  public void setRelevance(BigDecimal relevance) {
    this.relevance = relevance;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse20053Results inlineResponse20053Results = (InlineResponse20053Results) o;
    return (this.id == null ? inlineResponse20053Results.id == null : this.id.equals(inlineResponse20053Results.id)) &&
        (this.name == null ? inlineResponse20053Results.name == null : this.name.equals(inlineResponse20053Results.name)) &&
        (this.image == null ? inlineResponse20053Results.image == null : this.image.equals(inlineResponse20053Results.image)) &&
        (this.link == null ? inlineResponse20053Results.link == null : this.link.equals(inlineResponse20053Results.link)) &&
        (this.type == null ? inlineResponse20053Results.type == null : this.type.equals(inlineResponse20053Results.type)) &&
        (this.relevance == null ? inlineResponse20053Results.relevance == null : this.relevance.equals(inlineResponse20053Results.relevance)) &&
        (this.content == null ? inlineResponse20053Results.content == null : this.content.equals(inlineResponse20053Results.content));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.name == null ? 0: this.name.hashCode());
    result = 31 * result + (this.image == null ? 0: this.image.hashCode());
    result = 31 * result + (this.link == null ? 0: this.link.hashCode());
    result = 31 * result + (this.type == null ? 0: this.type.hashCode());
    result = 31 * result + (this.relevance == null ? 0: this.relevance.hashCode());
    result = 31 * result + (this.content == null ? 0: this.content.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse20053Results {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  image: ").append(image).append("\n");
    sb.append("  link: ").append(link).append("\n");
    sb.append("  type: ").append(type).append("\n");
    sb.append("  relevance: ").append(relevance).append("\n");
    sb.append("  content: ").append(content).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
