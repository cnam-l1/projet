package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * This class represents a shopping list for a user.
 */
@ApiModel(description = "This class represents a shopping list for a user.")
@Validated

public class Shopping  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("idShopping")
  private String idShopping = null;

  @JsonProperty("date")
  private LocalDate date = null;

  @JsonProperty("idUser")
  private String idUser = null;

  public Shopping idShopping(String idShopping) {
    this.idShopping = idShopping;
    return this;
  }

  /**
   * Shopping identifier.
   * @return idShopping
  **/
  @ApiModelProperty(required = true, value = "Shopping identifier.")
  @NotNull


  public String getIdShopping() {
    return idShopping;
  }

  public void setIdShopping(String idShopping) {
    this.idShopping = idShopping;
  }

  public Shopping date(LocalDate date) {
    this.date = date;
    return this;
  }

  /**
   * Date the user generated the shopping list.
   * @return date
  **/
  @ApiModelProperty(required = true, value = "Date the user generated the shopping list.")
  @NotNull

  @Valid

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public Shopping idUser(String idUser) {
    this.idUser = idUser;
    return this;
  }

  /**
   * User identifier.
   * @return idUser
  **/
  @ApiModelProperty(required = true, value = "User identifier.")
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
    Shopping shopping = (Shopping) o;
    return Objects.equals(this.idShopping, shopping.idShopping) &&
        Objects.equals(this.date, shopping.date) &&
        Objects.equals(this.idUser, shopping.idUser);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idShopping, date, idUser);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Shopping {\n");
    
    sb.append("    idShopping: ").append(toIndentedString(idShopping)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
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

