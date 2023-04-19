package br.com.ada.f1rst.mail.controller;

import br.com.ada.f1rst.mail.api.ApiApi;
import br.com.ada.f1rst.mail.model.Count;
import br.com.ada.f1rst.mail.model.Created;
import br.com.ada.f1rst.mail.model.Email;
import br.com.ada.f1rst.mail.model.Error;
import br.com.ada.f1rst.mail.service.MailService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-04-12T22:46:14.551837857Z[GMT]")
@RestController
public class EmailController implements ApiApi {

    private static final Logger log = LoggerFactory.getLogger(EmailController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    //private final Email email;
    private final MailService mailService;

    public EmailController(ObjectMapper objectMapper, HttpServletRequest request, MailService mailService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.mailService = mailService;
    }

    public ResponseEntity<?> apiEmailCountGet(@Parameter(in = ParameterIn.QUERY, description = "Sender Address to fetch" ,schema=@Schema()) @Valid @RequestParam(value = "sender_address", required = false) String senderAddress,@Parameter(in = ParameterIn.QUERY, description = "Receiver Address to fetch" ,schema=@Schema()) @Valid @RequestParam(value = "receiver_address", required = false) String receiverAddress,@Parameter(in = ParameterIn.QUERY, description = "Subject contains to fetch" ,schema=@Schema()) @Valid @RequestParam(value = "subject_contains", required = false) String subjectContains,@Parameter(in = ParameterIn.QUERY, description = "Received on the date" ,schema=@Schema()) @Valid @RequestParam(value = "received_date", required = false) String receivedDate) {
//        String accept = request.getHeader("Accept");
//        if (accept != null && accept.contains("application/json")) {
//            try {
//                return new ResponseEntity<Integer>(mailService.contarRemetentes(), HttpStatus.OK);
//            } catch (IOException e) {
//                log.error("Couldn't serialize response for content type application/json", e);
//                return new ResponseEntity<Count>(HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//        }

        return new ResponseEntity<Count>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<?> apiEmailDelete(
            @RequestParam(value = "sender_address", required = false) String senderAddress,
            @RequestParam(value = "receiver_address", required = false) String receiverAddress,
            @RequestParam(value = "subject_contains", required = false) String subjectContains,
            @RequestParam(value = "received_date", required = false) String receivedDate) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Error>(objectMapper.readValue("{\n  \"errorMessage\" : \"errorMessage\",\n  \"errorCode\" : \"errorCode\",\n  \"errorDetail\" : \"errorDetail\"\n}", Error.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Error>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Error>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<?> apiEmailGet(
            @RequestParam(value = "sender_address", required = false) String senderAddress,
            @RequestParam(value = "receiver_address", required = false) String receiverAddress,
            @RequestParam(value = "subject_contains", required = false) String subjectContains,
            @RequestParam(value = "received_date", required = false) String receivedDate) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            return ResponseEntity.ok(mailService.listarEmails(senderAddress, receiverAddress, subjectContains, receivedDate));
        }

        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(Error.builder().errorCode(HttpStatus.NOT_IMPLEMENTED.name()).errorMessage(HttpStatus.NOT_IMPLEMENTED.getReasonPhrase()).build());
    }

    public ResponseEntity<Email> apiEmailIdEmailGet(@Parameter(in = ParameterIn.PATH, description = "Email identifier", required=true, schema=@Schema()) @PathVariable("id_email") Long idEmail) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Email>(objectMapper.readValue("{\n  \"assunto\" : \"assunto\",\n  \"remetente\" : \"remetente\",\n  \"id_email\" : 0.8008281904610115,\n  \"conteudo\" : \"conteudo\",\n  \"lista_destinatarios\" : [ {\n    \"telefone\" : \"telefone\",\n    \"endereco\" : \"endereco\",\n    \"id_anexo\" : 6.027456183070403,\n    \"nome\" : \"nome\",\n    \"sexo\" : \"sexo\",\n    \"email\" : \"email\"\n  }, {\n    \"telefone\" : \"telefone\",\n    \"endereco\" : \"endereco\",\n    \"id_anexo\" : 6.027456183070403,\n    \"nome\" : \"nome\",\n    \"sexo\" : \"sexo\",\n    \"email\" : \"email\"\n  } ],\n  \"lista_anexos\" : [ {\n    \"tipo\" : \"tipo\",\n    \"conteudo\" : \"conteudo\",\n    \"tamanho\" : \"tamanho\",\n    \"id_anexo\" : 1.4658129805029452,\n    \"nome\" : \"nome\",\n    \"descricao\" : \"descricao\"\n  }, {\n    \"tipo\" : \"tipo\",\n    \"conteudo\" : \"conteudo\",\n    \"tamanho\" : \"tamanho\",\n    \"id_anexo\" : 1.4658129805029452,\n    \"nome\" : \"nome\",\n    \"descricao\" : \"descricao\"\n  } ],\n  \"data_hora\" : \"data_hora\"\n}", Email.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Email>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Email>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Created> apiEmailPost(@RequestBody Email email) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<Created>(mailService.salvarEmails(email), HttpStatus.NOT_IMPLEMENTED);
        }

        return new ResponseEntity<Created>(HttpStatus.NOT_IMPLEMENTED);
    }
}
