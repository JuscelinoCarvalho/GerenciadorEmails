package br.com.ada.f1rst.mail.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Validated
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class Email {

  @JsonProperty("id_email")
  private Long idEmail;
  private String assunto;
  @JsonProperty("data_hora_recebimento")
  private LocalDateTime dataHoraRecebimento;
  @JsonProperty("data_hora_envio")
  private LocalDateTime dataHoraEnvio;
  private String conteudo;
  private String remetente;
  @JsonProperty("lista_destinatarios") @Valid
  private List<Contact> listaDestinatarios = new ArrayList<>(0);
  @JsonProperty("lista_anexos") @Valid
  private List<Attachment> listaAnexos = new ArrayList<>(0);

  @Override
  public String toString() {
    return new Gson().toJson(this);
  }

  public static Email fromString(String data) {
    return new Gson().fromJson(data, Email.class);
  }
}
