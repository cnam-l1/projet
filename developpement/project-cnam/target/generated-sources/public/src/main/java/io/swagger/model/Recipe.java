package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * This class represents a recipe from a user.
 */
@ApiModel(description = "This class represents a recipe from a user.")
@Validated

public class Recipe  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("idRecipe")
  private String idRecipe = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("nbPeople")
  private String nbPeople = null;

  @JsonProperty("idUser")
  private String idUser = null;

  public Recipe idRecipe(String idRecipe) {
    this.idRecipe = idRecipe;
    return this;
  }

  /**
   * Recipient identifier.
   * @return idRecipe
  **/
  @ApiModelProperty(required = true, value = "Recipient identifier.")
  @NotNull


  public String getIdRecipe() {
    return idRecipe;
  }

  public void setIdRecipe(String idRecipe) {
    this.idRecipe = idRecipe;
  }

  public Recipe name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Recipient name.
   * @return name
  **/
  @ApiModelProperty(required = true, value = "Recipient name.")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Recipe nbPeople(String nbPeople) {
    this.nbPeople = nbPeople;
    return this;
  }

  /**
   * Number of people expected for the recipe.
   * @return nbPeople
  **/
  @ApiModelProperty(required = true, value = "Number of people expected for the recipe.")
  @NotNull


  public String getNbPeople() {
    return nbPeople;
  }

  public void setNbPeople(String nbPeople) {
    this.nbPeople = nbPeople;
  }

  public Recipe idUser(String idUser) {
    this.idUser = idUser;
    return this;
  }

  /**
   * Identifier of the user who owns the recipe.
   * @return idUser
  **/
  @ApiModelProperty(required = true, value = "Identifier of the user who owns the recipe.")
  @NotNull


  public String getIdUser() {
    return idUser;
  }

  public void setIdUser(String idUser) {
    this.idUser = idUser;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Recipe recipe = (Recipe) o;
    return Objects.equals(this.idRecipe, recipe.idRecipe) &&
        Objects.equals(this.name, recipe.name) &&
        Objects.equals(this.nbPeople, recipe.nbPeople) &&
        Objects.equals(this.idUser, recipe.idUser);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idRecipe, name, nbPeople, idUser);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Recipe {\n");
    
    sb.append("    idRecipe: ").append(toIndentedString(idRecipe)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    nbPeople: ").append(toIndentedString(nbPeople)).append("\n");
    sb.append("    idUser: ").append(toIndentedString(idUser)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

