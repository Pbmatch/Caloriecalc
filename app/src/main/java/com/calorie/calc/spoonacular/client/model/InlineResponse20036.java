package com.calorie.calc.spoonacular.client.model;

import com.spoonacular.client.model.InlineResponse20028Nutrition;
import com.spoonacular.client.model.InlineResponse20028Servings;
import java.math.BigDecimal;
import java.util.*;

import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class InlineResponse20036  {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("title")
  private String title = null;
  @SerializedName("restaurantChain")
  private String restaurantChain = null;
  @SerializedName("nutrition")
  private InlineResponse20028Nutrition nutrition = null;
  @SerializedName("badges")
  private List<String> badges = null;
  @SerializedName("breadcrumbs")
  private List<String> breadcrumbs = null;
  @SerializedName("generatedText")
  private String generatedText = null;
  @SerializedName("imageType")
  private String imageType = null;
  @SerializedName("likes")
  private BigDecimal likes = null;
  @SerializedName("servings")
  private InlineResponse20028Servings servings = null;
  @SerializedName("price")
  private BigDecimal price = null;
  @SerializedName("spoonacularScore")
  private BigDecimal spoonacularScore = null;

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
  public String getRestaurantChain() {
    return restaurantChain;
  }
  public void setRestaurantChain(String restaurantChain) {
    this.restaurantChain = restaurantChain;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public InlineResponse20028Nutrition getNutrition() {
    return nutrition;
  }
  public void setNutrition(InlineResponse20028Nutrition nutrition) {
    this.nutrition = nutrition;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public List<String> getBadges() {
    return badges;
  }
  public void setBadges(List<String> badges) {
    this.badges = badges;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public List<String> getBreadcrumbs() {
    return breadcrumbs;
  }
  public void setBreadcrumbs(List<String> breadcrumbs) {
    this.breadcrumbs = breadcrumbs;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getGeneratedText() {
    return generatedText;
  }
  public void setGeneratedText(String generatedText) {
    this.generatedText = generatedText;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public String getImageType() {
    return imageType;
  }
  public void setImageType(String imageType) {
    this.imageType = imageType;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public BigDecimal getLikes() {
    return likes;
  }
  public void setLikes(BigDecimal likes) {
    this.likes = likes;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public InlineResponse20028Servings getServings() {
    return servings;
  }
  public void setServings(InlineResponse20028Servings servings) {
    this.servings = servings;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public BigDecimal getPrice() {
    return price;
  }
  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public BigDecimal getSpoonacularScore() {
    return spoonacularScore;
  }
  public void setSpoonacularScore(BigDecimal spoonacularScore) {
    this.spoonacularScore = spoonacularScore;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse20036 inlineResponse20036 = (InlineResponse20036) o;
    return (this.id == null ? inlineResponse20036.id == null : this.id.equals(inlineResponse20036.id)) &&
        (this.title == null ? inlineResponse20036.title == null : this.title.equals(inlineResponse20036.title)) &&
        (this.restaurantChain == null ? inlineResponse20036.restaurantChain == null : this.restaurantChain.equals(inlineResponse20036.restaurantChain)) &&
        (this.nutrition == null ? inlineResponse20036.nutrition == null : this.nutrition.equals(inlineResponse20036.nutrition)) &&
        (this.badges == null ? inlineResponse20036.badges == null : this.badges.equals(inlineResponse20036.badges)) &&
        (this.breadcrumbs == null ? inlineResponse20036.breadcrumbs == null : this.breadcrumbs.equals(inlineResponse20036.breadcrumbs)) &&
        (this.generatedText == null ? inlineResponse20036.generatedText == null : this.generatedText.equals(inlineResponse20036.generatedText)) &&
        (this.imageType == null ? inlineResponse20036.imageType == null : this.imageType.equals(inlineResponse20036.imageType)) &&
        (this.likes == null ? inlineResponse20036.likes == null : this.likes.equals(inlineResponse20036.likes)) &&
        (this.servings == null ? inlineResponse20036.servings == null : this.servings.equals(inlineResponse20036.servings)) &&
        (this.price == null ? inlineResponse20036.price == null : this.price.equals(inlineResponse20036.price)) &&
        (this.spoonacularScore == null ? inlineResponse20036.spoonacularScore == null : this.spoonacularScore.equals(inlineResponse20036.spoonacularScore));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.title == null ? 0: this.title.hashCode());
    result = 31 * result + (this.restaurantChain == null ? 0: this.restaurantChain.hashCode());
    result = 31 * result + (this.nutrition == null ? 0: this.nutrition.hashCode());
    result = 31 * result + (this.badges == null ? 0: this.badges.hashCode());
    result = 31 * result + (this.breadcrumbs == null ? 0: this.breadcrumbs.hashCode());
    result = 31 * result + (this.generatedText == null ? 0: this.generatedText.hashCode());
    result = 31 * result + (this.imageType == null ? 0: this.imageType.hashCode());
    result = 31 * result + (this.likes == null ? 0: this.likes.hashCode());
    result = 31 * result + (this.servings == null ? 0: this.servings.hashCode());
    result = 31 * result + (this.price == null ? 0: this.price.hashCode());
    result = 31 * result + (this.spoonacularScore == null ? 0: this.spoonacularScore.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse20036 {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  title: ").append(title).append("\n");
    sb.append("  restaurantChain: ").append(restaurantChain).append("\n");
    sb.append("  nutrition: ").append(nutrition).append("\n");
    sb.append("  badges: ").append(badges).append("\n");
    sb.append("  breadcrumbs: ").append(breadcrumbs).append("\n");
    sb.append("  generatedText: ").append(generatedText).append("\n");
    sb.append("  imageType: ").append(imageType).append("\n");
    sb.append("  likes: ").append(likes).append("\n");
    sb.append("  servings: ").append(servings).append("\n");
    sb.append("  price: ").append(price).append("\n");
    sb.append("  spoonacularScore: ").append(spoonacularScore).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
