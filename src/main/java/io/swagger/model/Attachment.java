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
 * Attachment
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-04-12T22:46:14.551837857Z[GMT]")


public class Attachment   {
  @JsonProperty("id_anexo")
  private BigDecimal idAnexo = null;

  @JsonProperty("tipo")
  private String tipo = null;

  @JsonProperty("nome")
  private String nome = null;

  @JsonProperty("conteudo")
  private String conteudo = null;

  @JsonProperty("tamanho")
  private String tamanho = null;

  @JsonProperty("descricao")
  private String descricao = null;

  public Attachment idAnexo(BigDecimal idAnexo) {
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

  public Attachment tipo(String tipo) {
    this.tipo = tipo;
    return this;
  }

  /**
   * Get tipo
   * @return tipo
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public Attachment nome(String nome) {
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

  public Attachment conteudo(String conteudo) {
    this.conteudo = conteudo;
    return this;
  }

  /**
   * Get conteudo
   * @return conteudo
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getConteudo() {
    return conteudo;
  }

  public void setConteudo(String conteudo) {
    this.conteudo = conteudo;
  }

  public Attachment tamanho(String tamanho) {
    this.tamanho = tamanho;
    return this;
  }

  /**
   * Get tamanho
   * @return tamanho
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getTamanho() {
    return tamanho;
  }

  public void setTamanho(String tamanho) {
    this.tamanho = tamanho;
  }

  public Attachment descricao(String descricao) {
    this.descricao = descricao;
    return this;
  }

  /**
   * Get descricao
   * @return descricao
   **/
  @Schema(description = "")
  
    public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Attachment attachment = (Attachment) o;
    return Objects.equals(this.idAnexo, attachment.idAnexo) &&
        Objects.equals(this.tipo, attachment.tipo) &&
        Objects.equals(this.nome, attachment.nome) &&
        Objects.equals(this.conteudo, attachment.conteudo) &&
        Objects.equals(this.tamanho, attachment.tamanho) &&
        Objects.equals(this.descricao, attachment.descricao);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idAnexo, tipo, nome, conteudo, tamanho, descricao);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Attachment {\n");
    
    sb.append("    idAnexo: ").append(toIndentedString(idAnexo)).append("\n");
    sb.append("    tipo: ").append(toIndentedString(tipo)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    conteudo: ").append(toIndentedString(conteudo)).append("\n");
    sb.append("    tamanho: ").append(toIndentedString(tamanho)).append("\n");
    sb.append("    descricao: ").append(toIndentedString(descricao)).append("\n");
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
