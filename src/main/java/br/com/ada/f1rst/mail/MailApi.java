package br.com.ada.f1rst.mail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
public class MailApi {

    public static void main(String[] args) {
        new SpringApplication(MailApi.class).run(args);
    }
}
