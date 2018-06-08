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
 * This class represents a user of &lt;nom de l&#39;application&gt;.
 */
@ApiModel(description = "This class represents a user of <nom de l'application>.")
@Validated

public class User  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("idUser")
  private String idUser = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("firstname")
  private String firstname = null;

  @JsonProperty("email")
  private String email = null;

  public User idUser(String idUser) {
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

  public User name(String name) {
    this.name = name;
    return this;
  }

  /**
   * User name.
   * @return name
  **/
  @ApiModelProperty(required = true, value = "User name.")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public User firstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  /**
   * User firstname.
   * @return firstname
  **/
  @ApiModelProperty(required = true, value = "User firstname.")
  @NotNull


  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public User email(String email) {
    this.email = email;
    return this;
  }

  /**
   * User email.
   * @return email
  **/
  @ApiModelProperty(required = true, value = "User email.")
  @NotNull


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(this.idUser, user.idUser) &&
        Objects.equals(this.name, user.name) &&
        Objects.equals(this.firstname, user.firstname) &&
        Objects.equals(this.email, user.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idUser, name, firstname, email);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("    idUser: ").append(toIndentedString(idUser)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    firstname: ").append(toIndentedString(firstname)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
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

