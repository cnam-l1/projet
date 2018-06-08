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
 * This enumeration list any unit of measure for an ingredient.
 */
public enum UnitOfMeasure {
  
  GRAMS("grams"),
  
  LITERS("liters"),
  
  PIECE("piece");

  private String value;

  UnitOfMeasure(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static UnitOfMeasure fromValue(String text) {
    for (UnitOfMeasure b : UnitOfMeasure.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}

