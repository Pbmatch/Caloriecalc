package com.calorie.calc.spoonacular.client.model;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description = "")
public class InlineResponse20045ProductMatches  {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("title")
  private String title = null;
  @SerializedName("averageRating")
  private BigDecimal averageRating = null;
  @SerializedName("description")
  private Object description = null;
  @SerializedName("imageUrl")
  private String imageUrl = null;
  @SerializedName("link")
  private String link = null;
  @SerializedName("price")
  private String price = null;
  @SerializedName("ratingCount")
  private Integer ratingCount = null;
  @SerializedName("score")
  private BigDecimal score = null;

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public BigDecimal getAverageRating() {
    return averageRating;
  }
  public void setAverageRating(BigDecimal averageRating) {
    this.averageRating = averageRating;
  }

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
  public String getImageUrl() {
    return imageUrl;
  }
  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
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
  public String getPrice() {
    return price;
  }
  public void setPrice(String price) {
    this.price = price;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public Integer getRatingCount() {
    return ratingCount;
  }
  public void setRatingCount(Integer ratingCount) {
    this.ratingCount = ratingCount;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public BigDecimal getScore() {
    return score;
  }
  public void setScore(BigDecimal score) {
    this.score = score;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse20045ProductMatches inlineResponse20045ProductMatches = (InlineResponse20045ProductMatches) o;
    return (this.id == null ? inlineResponse20045ProductMatches.id == null : this.id.equals(inlineResponse20045ProductMatches.id)) &&
        (this.title == null ? inlineResponse20045ProductMatches.title == null : this.title.equals(inlineResponse20045ProductMatches.title)) &&
        (this.averageRating == null ? inlineResponse20045ProductMatches.averageRating == null : this.averageRating.equals(inlineResponse20045ProductMatches.averageRating)) &&
        (this.description == null ? inlineResponse20045ProductMatches.description == null : this.description.equals(inlineResponse20045ProductMatches.description)) &&
        (this.imageUrl == null ? inlineResponse20045ProductMatches.imageUrl == null : this.imageUrl.equals(inlineResponse20045ProductMatches.imageUrl)) &&
        (this.link == null ? inlineResponse20045ProductMatches.link == null : this.link.equals(inlineResponse20045ProductMatches.link)) &&
        (this.price == null ? inlineResponse20045ProductMatches.price == null : this.price.equals(inlineResponse20045ProductMatches.price)) &&
        (this.ratingCount == null ? inlineResponse20045ProductMatches.ratingCount == null : this.ratingCount.equals(inlineResponse20045ProductMatches.ratingCount)) &&
        (this.score == null ? inlineResponse20045ProductMatches.score == null : this.score.equals(inlineResponse20045ProductMatches.score));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.title == null ? 0: this.title.hashCode());
    result = 31 * result + (this.averageRating == null ? 0: this.averageRating.hashCode());
    result = 31 * result + (this.description == null ? 0: this.description.hashCode());
    result = 31 * result + (this.imageUrl == null ? 0: this.imageUrl.hashCode());
    result = 31 * result + (this.link == null ? 0: this.link.hashCode());
    result = 31 * result + (this.price == null ? 0: this.price.hashCode());
    result = 31 * result + (this.ratingCount == null ? 0: this.ratingCount.hashCode());
    result = 31 * result + (this.score == null ? 0: this.score.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse20045ProductMatches {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  title: ").append(title).append("\n");
    sb.append("  averageRating: ").append(averageRating).append("\n");
    sb.append("  description: ").append(description).append("\n");
    sb.append("  imageUrl: ").append(imageUrl).append("\n");
    sb.append("  link: ").append(link).append("\n");
    sb.append("  price: ").append(price).append("\n");
    sb.append("  ratingCount: ").append(ratingCount).append("\n");
    sb.append("  score: ").append(score).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
