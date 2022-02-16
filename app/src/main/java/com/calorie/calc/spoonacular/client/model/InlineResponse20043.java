package com.calorie.calc.spoonacular.client.model;


import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class InlineResponse20043  {
  
  @SerializedName("username")
  private String username = null;
  @SerializedName("hash")
  private String hash = null;

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
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
    InlineResponse20043 inlineResponse20043 = (InlineResponse20043) o;
    return (this.username == null ? inlineResponse20043.username == null : this.username.equals(inlineResponse20043.username)) &&
        (this.hash == null ? inlineResponse20043.hash == null : this.hash.equals(inlineResponse20043.hash));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.username == null ? 0: this.username.hashCode());
    result = 31 * result + (this.hash == null ? 0: this.hash.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse20043 {\n");
    
    sb.append("  username: ").append(username).append("\n");
    sb.append("  hash: ").append(hash).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
