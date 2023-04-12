package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Created
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-04-12T22:46:14.551837857Z[GMT]")


public class Created   {
  @JsonProperty("new_id")
  private BigDecimal newId = null;

  public Created newId(BigDecimal newId) {
    this.newId = newId;
    return this;
  }

  /**
   * Get newId
   * @return newId
   **/
  @Schema(description = "")
  
    @Valid
    public BigDecimal getNewId() {
    return newId;
  }

  public void setNewId(BigDecimal newId) {
    this.newId = newId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Created created = (Created) o;
    return Objects.equals(this.newId, created.newId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(newId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Created {\n");
    
    sb.append("    newId: ").append(toIndentedString(newId)).append("\n");
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
