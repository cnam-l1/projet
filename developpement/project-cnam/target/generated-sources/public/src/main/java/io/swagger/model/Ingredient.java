package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Category;
import io.swagger.model.UnitOfMeasure;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * This class represents a food ingredient.
 */
@ApiModel(description = "This class represents a food ingredient.")
@Validated

public class Ingredient  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("idIngredient")
  private String idIngredient = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("unitOfMeasure")
  private UnitOfMeasure unitOfMeasure = null;

  @JsonProperty("category")
  private Category category = null;

  public Ingredient idIngredient(String idIngredient) {
    this.idIngredient = idIngredient;
    return this;
  }

  /**
   * Ingredient identifier.
   * @return idIngredient
  **/
  @ApiModelProperty(required = true, value = "Ingredient identifier.")
  @NotNull


  public String getIdIngredient() {
    return idIngredient;
  }

  public void setIdIngredient(String idIngredient) {
    this.idIngredient = idIngredient;
  }

  public Ingredient name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Ingredient name.
   * @return name
  **/
  @ApiModelProperty(required = true, value = "Ingredient name.")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Ingredient unitOfMeasure(UnitOfMeasure unitOfMeasure) {
    this.unitOfMeasure = unitOfMeasure;
    return this;
  }

  /**
   * Get unitOfMeasure
   * @return unitOfMeasure
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public UnitOfMeasure getUnitOfMeasure() {
    return unitOfMeasure;
  }

  public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
    this.unitOfMeasure = unitOfMeasure;
  }

  public Ingredient category(Category category) {
    this.category = category;
    return this;
  }

  /**
   * Get category
   * @return category
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Ingredient ingredient = (Ingredient) o;
    return Objects.equals(this.idIngredient, ingredient.idIngredient) &&
        Objects.equals(this.name, ingredient.name) &&
        Objects.equals(this.unitOfMeasure, ingredient.unitOfMeasure) &&
        Objects.equals(this.category, ingredient.category);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idIngredient, name, unitOfMeasure, category);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Ingredient {\n");
    
    sb.append("    idIngredient: ").append(toIndentedString(idIngredient)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    unitOfMeasure: ").append(toIndentedString(unitOfMeasure)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
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

