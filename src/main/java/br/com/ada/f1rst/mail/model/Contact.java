package br.com.ada.f1rst.mail.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.validation.annotation.Validated;

@Validated
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Contact   {

  @JsonProperty("id_contato")
  private Long idContato;
  private String nome;
  private String email;
  private String sexo;
  private String telefone;
  private String endereco;
}
