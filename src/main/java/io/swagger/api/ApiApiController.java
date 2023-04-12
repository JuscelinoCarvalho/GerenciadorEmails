package io.swagger.api;

import java.math.BigDecimal;
import io.swagger.model.Count;
import io.swagger.model.Created;
import io.swagger.model.Email;
import io.swagger.model.Emails;
import io.swagger.model.Error;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-04-12T22:46:14.551837857Z[GMT]")
@RestController
public class ApiApiController implements ApiApi {

    private static final Logger log = LoggerFactory.getLogger(ApiApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ApiApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Count> apiEmailCountGet(@Parameter(in = ParameterIn.QUERY, description = "Sender Address to fetch" ,schema=@Schema()) @Valid @RequestParam(value = "sender_address", required = false) String senderAddress,@Parameter(in = ParameterIn.QUERY, description = "Receiver Address to fetch" ,schema=@Schema()) @Valid @RequestParam(value = "receiver_address", required = false) String receiverAddress,@Parameter(in = ParameterIn.QUERY, description = "Subject contains to fetch" ,schema=@Schema()) @Valid @RequestParam(value = "subject_contains", required = false) String subjectContains,@Parameter(in = ParameterIn.QUERY, description = "Received on the date" ,schema=@Schema()) @Valid @RequestParam(value = "received_date", required = false) BigDecimal receivedDate) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Count>(objectMapper.readValue("{\n  \"quantity\" : 0.8008281904610115\n}", Count.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Count>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Count>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Error> apiEmailDelete(@Parameter(in = ParameterIn.QUERY, description = "Sender Address to fetch" ,schema=@Schema()) @Valid @RequestParam(value = "sender_address", required = false) String senderAddress,@Parameter(in = ParameterIn.QUERY, description = "Receiver Address to fetch" ,schema=@Schema()) @Valid @RequestParam(value = "receiver_address", required = false) String receiverAddress,@Parameter(in = ParameterIn.QUERY, description = "Subject contains to fetch" ,schema=@Schema()) @Valid @RequestParam(value = "subject_contains", required = false) String subjectContains,@Parameter(in = ParameterIn.QUERY, description = "Received on the date" ,schema=@Schema()) @Valid @RequestParam(value = "received_date", required = false) BigDecimal receivedDate) {
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

    public ResponseEntity<Emails> apiEmailGet(@Parameter(in = ParameterIn.QUERY, description = "Sender Address to fetch" ,schema=@Schema()) @Valid @RequestParam(value = "sender_address", required = false) String senderAddress,@Parameter(in = ParameterIn.QUERY, description = "Receiver Address to fetch" ,schema=@Schema()) @Valid @RequestParam(value = "receiver_address", required = false) String receiverAddress,@Parameter(in = ParameterIn.QUERY, description = "Subject contains to fetch" ,schema=@Schema()) @Valid @RequestParam(value = "subject_contains", required = false) String subjectContains,@Parameter(in = ParameterIn.QUERY, description = "Received on the date" ,schema=@Schema()) @Valid @RequestParam(value = "received_date", required = false) BigDecimal receivedDate) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Emails>(objectMapper.readValue("[ {\n  \"assunto\" : \"assunto\",\n  \"remetente\" : \"remetente\",\n  \"id_email\" : 0.8008281904610115,\n  \"conteudo\" : \"conteudo\",\n  \"lista_destinatarios\" : [ {\n    \"telefone\" : \"telefone\",\n    \"endereco\" : \"endereco\",\n    \"id_anexo\" : 6.027456183070403,\n    \"nome\" : \"nome\",\n    \"sexo\" : \"sexo\",\n    \"email\" : \"email\"\n  }, {\n    \"telefone\" : \"telefone\",\n    \"endereco\" : \"endereco\",\n    \"id_anexo\" : 6.027456183070403,\n    \"nome\" : \"nome\",\n    \"sexo\" : \"sexo\",\n    \"email\" : \"email\"\n  } ],\n  \"lista_anexos\" : [ {\n    \"tipo\" : \"tipo\",\n    \"conteudo\" : \"conteudo\",\n    \"tamanho\" : \"tamanho\",\n    \"id_anexo\" : 1.4658129805029452,\n    \"nome\" : \"nome\",\n    \"descricao\" : \"descricao\"\n  }, {\n    \"tipo\" : \"tipo\",\n    \"conteudo\" : \"conteudo\",\n    \"tamanho\" : \"tamanho\",\n    \"id_anexo\" : 1.4658129805029452,\n    \"nome\" : \"nome\",\n    \"descricao\" : \"descricao\"\n  } ],\n  \"data_hora\" : \"data_hora\"\n}, {\n  \"assunto\" : \"assunto\",\n  \"remetente\" : \"remetente\",\n  \"id_email\" : 0.8008281904610115,\n  \"conteudo\" : \"conteudo\",\n  \"lista_destinatarios\" : [ {\n    \"telefone\" : \"telefone\",\n    \"endereco\" : \"endereco\",\n    \"id_anexo\" : 6.027456183070403,\n    \"nome\" : \"nome\",\n    \"sexo\" : \"sexo\",\n    \"email\" : \"email\"\n  }, {\n    \"telefone\" : \"telefone\",\n    \"endereco\" : \"endereco\",\n    \"id_anexo\" : 6.027456183070403,\n    \"nome\" : \"nome\",\n    \"sexo\" : \"sexo\",\n    \"email\" : \"email\"\n  } ],\n  \"lista_anexos\" : [ {\n    \"tipo\" : \"tipo\",\n    \"conteudo\" : \"conteudo\",\n    \"tamanho\" : \"tamanho\",\n    \"id_anexo\" : 1.4658129805029452,\n    \"nome\" : \"nome\",\n    \"descricao\" : \"descricao\"\n  }, {\n    \"tipo\" : \"tipo\",\n    \"conteudo\" : \"conteudo\",\n    \"tamanho\" : \"tamanho\",\n    \"id_anexo\" : 1.4658129805029452,\n    \"nome\" : \"nome\",\n    \"descricao\" : \"descricao\"\n  } ],\n  \"data_hora\" : \"data_hora\"\n} ]", Emails.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Emails>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Emails>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Email> apiEmailIdEmailGet(@Parameter(in = ParameterIn.PATH, description = "Email identifier", required=true, schema=@Schema()) @PathVariable("id_email") BigDecimal idEmail) {
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

    public ResponseEntity<Created> apiEmailPost(@Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody Email body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Created>(objectMapper.readValue("{\n  \"new_id\" : 0.8008281904610115\n}", Created.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Created>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Created>(HttpStatus.NOT_IMPLEMENTED);
    }

}
