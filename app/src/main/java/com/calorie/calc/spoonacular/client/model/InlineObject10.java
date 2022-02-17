package com.calorie.calc.spoonacular.client.model;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description = "")
public class InlineObject10  {
  
  @SerializedName("username")
  private String username = null;
  @SerializedName("id")
  private BigDecimal id = null;
  @SerializedName("hash")
  private String hash = null;

  /**
   * The username.
   **/
  @ApiModelProperty(required = true, value = "The username.")
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * The shopping list item id.
   **/
  @ApiModelProperty(required = true, value = "The shopping list item id.")
  public BigDecimal getId() {
    return id;
  }
  public void setId(BigDecimal id) {
    this.id = id;
  }

  /**
   * The private hash for the username.
   **/
  @ApiModelProperty(required = true, value = "The private hash for the username.")
  public String getHash() {
    return hash;
  }
  public void setHash(String hash) {
    this.hash = hash;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineObject10 inlineObject10 = (InlineObject10) o;
    return (this.username == null ? inlineObject10.username == null : this.username.equals(inlineObject10.username)) &&
        (this.id == null ? inlineObject10.id == null : this.id.equals(inlineObject10.id)) &&
        (this.hash == null ? inlineObject10.hash == null : this.hash.equals(inlineObject10.hash));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.username == null ? 0: this.username.hashCode());
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.hash == null ? 0: this.hash.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineObject10 {\n");
    
    sb.append("  username: ").append(username).append("\n");
    sb.append("  id: ").append(id).append("\n");
    sb.append("  hash: ").append(hash).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
