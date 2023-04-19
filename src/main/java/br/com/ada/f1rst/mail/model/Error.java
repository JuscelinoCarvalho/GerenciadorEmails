package br.com.ada.f1rst.mail.model;

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
public class Error   {
  
  private String errorCode;
  private String errorMessage;
  private String errorDetail;
}
