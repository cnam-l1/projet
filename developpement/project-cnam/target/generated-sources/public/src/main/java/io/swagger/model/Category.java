package io.swagger.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import com.fasterxml.jackson.annotation.JsonValue;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * This enumeration represents the different categories of an ingredient.
 */
public enum Category {
  
  BUTCHERY("butchery"),
  
  POULTRY("poultry"),
  
  GAME("game"),
  
  FISH("fish"),
  
  DAIRY("dairy"),
  
  VEGETABLE("vegetable"),
  
  FRESH_FROZEN("fresh_frozen"),
  
  GROCERY("grocery"),
  
  CELLAR("cellar");

  private String value;

  Category(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static Category fromValue(String text) {
    for (Category b : Category.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}

