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
public class Attachment   {

  @JsonProperty("id_anexo")
  private Long idAnexo;
  private String tipo;
  private String nome;
  private String conteudo;
  private String tamanho;
  private String descricao;
}
