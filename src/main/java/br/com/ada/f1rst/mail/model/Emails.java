package br.com.ada.f1rst.mail.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;

@Validated
@Getter
@Setter
@ToString
@Builder
public class Emails extends ArrayList<Email>  {}
