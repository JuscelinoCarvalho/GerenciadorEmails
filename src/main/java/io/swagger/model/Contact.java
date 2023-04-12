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
 * Contact
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-04-12T22:46:14.551837857Z[GMT]")


public class Contact   {
  @JsonProperty("id_anexo")
  private BigDecimal idAnexo = null;

  @JsonProperty("nome")
  private String nome = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("sexo")
  private String sexo = null;

  @JsonProperty("telefone")
  private String telefone = null;

  @JsonProperty("endereco")
  private String endereco = null;

  public Contact idAnexo(BigDecimal idAnexo) {
    this.idAnexo = idAnexo;
    return this;
  }

  /**
   * Get idAnexo
   * @return idAnexo
   **/
  @Schema(description = "")
  
    @Valid
    public BigDecimal getIdAnexo() {
    return idAnexo;
  }

  public void setIdAnexo(BigDecimal idAnexo) {
    this.idAnexo = idAnexo;
  }

  public Contact nome(String nome) {
    this.nome = nome;
    return this;
  }

  /**
   * Get nome
   * @return nome
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Contact email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Contact sexo(String sexo) {
    this.sexo = sexo;
    return this;
  }

  /**
   * Get sexo
   * @return sexo
   **/
  @Schema(description = "")
  
    public String getSexo() {
    return sexo;
  }

  public void setSexo(String sexo) {
    this.sexo = sexo;
  }

  public Contact telefone(String telefone) {
    this.telefone = telefone;
    return this;
  }

  /**
   * Get telefone
   * @return telefone
   **/
  @Schema(description = "")
  
    public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public Contact endereco(String endereco) {
    this.endereco = endereco;
    return this;
  }

  /**
   * Get endereco
   * @return endereco
   **/
  @Schema(description = "")
  
    public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Contact contact = (Contact) o;
    return Objects.equals(this.idAnexo, contact.idAnexo) &&
        Objects.equals(this.nome, contact.nome) &&
        Objects.equals(this.email, contact.email) &&
        Objects.equals(this.sexo, contact.sexo) &&
        Objects.equals(this.telefone, contact.telefone) &&
        Objects.equals(this.endereco, contact.endereco);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idAnexo, nome, email, sexo, telefone, endereco);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Contact {\n");
    
    sb.append("    idAnexo: ").append(toIndentedString(idAnexo)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    sexo: ").append(toIndentedString(sexo)).append("\n");
    sb.append("    telefone: ").append(toIndentedString(telefone)).append("\n");
    sb.append("    endereco: ").append(toIndentedString(endereco)).append("\n");
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
