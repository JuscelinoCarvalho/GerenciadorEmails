package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.Attachment;
import io.swagger.model.Contact;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Email
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-04-12T22:46:14.551837857Z[GMT]")


public class Email   {
  @JsonProperty("id_email")
  private BigDecimal idEmail = null;

  @JsonProperty("assunto")
  private String assunto = null;

  @JsonProperty("data_hora")
  private String dataHora = null;

  @JsonProperty("conteudo")
  private String conteudo = null;

  @JsonProperty("remetente")
  private String remetente = null;

  @JsonProperty("lista_destinatarios")
  @Valid
  private List<Contact> listaDestinatarios = new ArrayList<Contact>();

  @JsonProperty("lista_anexos")
  @Valid
  private List<Attachment> listaAnexos = null;

  public Email idEmail(BigDecimal idEmail) {
    this.idEmail = idEmail;
    return this;
  }

  /**
   * Get idEmail
   * @return idEmail
   **/
  @Schema(description = "")
  
    @Valid
    public BigDecimal getIdEmail() {
    return idEmail;
  }

  public void setIdEmail(BigDecimal idEmail) {
    this.idEmail = idEmail;
  }

  public Email assunto(String assunto) {
    this.assunto = assunto;
    return this;
  }

  /**
   * Get assunto
   * @return assunto
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getAssunto() {
    return assunto;
  }

  public void setAssunto(String assunto) {
    this.assunto = assunto;
  }

  public Email dataHora(String dataHora) {
    this.dataHora = dataHora;
    return this;
  }

  /**
   * Get dataHora
   * @return dataHora
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getDataHora() {
    return dataHora;
  }

  public void setDataHora(String dataHora) {
    this.dataHora = dataHora;
  }

  public Email conteudo(String conteudo) {
    this.conteudo = conteudo;
    return this;
  }

  /**
   * Get conteudo
   * @return conteudo
   **/
  @Schema(description = "")
  
    public String getConteudo() {
    return conteudo;
  }

  public void setConteudo(String conteudo) {
    this.conteudo = conteudo;
  }

  public Email remetente(String remetente) {
    this.remetente = remetente;
    return this;
  }

  /**
   * Get remetente
   * @return remetente
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getRemetente() {
    return remetente;
  }

  public void setRemetente(String remetente) {
    this.remetente = remetente;
  }

  public Email listaDestinatarios(List<Contact> listaDestinatarios) {
    this.listaDestinatarios = listaDestinatarios;
    return this;
  }

  public Email addListaDestinatariosItem(Contact listaDestinatariosItem) {
    this.listaDestinatarios.add(listaDestinatariosItem);
    return this;
  }

  /**
   * Get listaDestinatarios
   * @return listaDestinatarios
   **/
  @Schema(required = true, description = "")
      @NotNull
    @Valid
    public List<Contact> getListaDestinatarios() {
    return listaDestinatarios;
  }

  public void setListaDestinatarios(List<Contact> listaDestinatarios) {
    this.listaDestinatarios = listaDestinatarios;
  }

  public Email listaAnexos(List<Attachment> listaAnexos) {
    this.listaAnexos = listaAnexos;
    return this;
  }

  public Email addListaAnexosItem(Attachment listaAnexosItem) {
    if (this.listaAnexos == null) {
      this.listaAnexos = new ArrayList<Attachment>();
    }
    this.listaAnexos.add(listaAnexosItem);
    return this;
  }

  /**
   * Get listaAnexos
   * @return listaAnexos
   **/
  @Schema(description = "")
      @Valid
    public List<Attachment> getListaAnexos() {
    return listaAnexos;
  }

  public void setListaAnexos(List<Attachment> listaAnexos) {
    this.listaAnexos = listaAnexos;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Email email = (Email) o;
    return Objects.equals(this.idEmail, email.idEmail) &&
        Objects.equals(this.assunto, email.assunto) &&
        Objects.equals(this.dataHora, email.dataHora) &&
        Objects.equals(this.conteudo, email.conteudo) &&
        Objects.equals(this.remetente, email.remetente) &&
        Objects.equals(this.listaDestinatarios, email.listaDestinatarios) &&
        Objects.equals(this.listaAnexos, email.listaAnexos);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idEmail, assunto, dataHora, conteudo, remetente, listaDestinatarios, listaAnexos);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Email {\n");
    
    sb.append("    idEmail: ").append(toIndentedString(idEmail)).append("\n");
    sb.append("    assunto: ").append(toIndentedString(assunto)).append("\n");
    sb.append("    dataHora: ").append(toIndentedString(dataHora)).append("\n");
    sb.append("    conteudo: ").append(toIndentedString(conteudo)).append("\n");
    sb.append("    remetente: ").append(toIndentedString(remetente)).append("\n");
    sb.append("    listaDestinatarios: ").append(toIndentedString(listaDestinatarios)).append("\n");
    sb.append("    listaAnexos: ").append(toIndentedString(listaAnexos)).append("\n");
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
