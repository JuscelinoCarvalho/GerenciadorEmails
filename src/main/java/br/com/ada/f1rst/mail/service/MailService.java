package br.com.ada.f1rst.mail.service;

import br.com.ada.f1rst.mail.model.Created;
import br.com.ada.f1rst.mail.model.Email;
import br.com.ada.f1rst.mail.model.Emails;

/**
 * Cada e-mail recebido numa dada conta de e-mail é guardado contendo o endereço de quem o enviou, a data de envio, a data de recebimento, o assunto e o texto do e-mail (não se consideram anexos, etc.).
 * Crie uma classe MailMap que associe a cada endereço de envio todos os mails recebidos (classe EMail) e implemente as seguintes operações:
 */
public interface MailService {

    Emails listarEmails(String senderAddress, String receiverAddress, String subjectContains, String receivedDate);
    Created salvarEmails(Email email);

//    /**
//     * a) Determinar o total de endereços a partir dos quais se recebeu mail;
//     */
//	int contarRemetentes();
//
//    /**
//     * b) Guardar um novo mail recebido;
//     */
//	void salvar(String remetente, Email email);
//
//    /**
//     *  c) Determinar quantos mails têm por origem um dado endereço;
//     */
//    int contarRecebidosDe(String remetente);
//
//    /**
//     * d) Criar uma lista com todos os endereços que enviaram mails contendo no seu assunto uma lista de palavras dada como parâmetro;
//     */
//    List<String> listarEnderecosComPalavrasNoAssunto(String... argumentos);
//
//    /**
//     * e) O mesmo que a questão anterior, mas criando um conjunto contendo os mails;
//     */
//    List<Email> obterEmailsComPalavrasNoAssunto(String... argumentos);
//
//    /**
//     * f) Eliminar todos os e-mails recebidos antes de uma data que é dada como parâmetro;
//     */
//    int removerEmailsAntesDe(LocalDateTime dataHora);
//
//    /**
//     * g) Criar uma lista dos endereços que hoje enviaram mails;
//     */
//    List<String> listarRemetentesComEnviosHoje();
//
//    /**
//     * h) Dada uma lista de palavras, eliminar todos os mails de um dado endereço que no seu assunto contenham uma qualquer destas (anti-spam);
//     */
//    int removerEmailsDeContendoPalavras(String remetente, String... assunto);
//
//    /**
//     * i) Eliminar todos os mails de um dado endereço anteriores a uma data dada;
//     */
//    int removerEmailsDeAntesDe(String remetente, LocalDateTime dataHora);
//
//    /**
//     * j) Criar uma listagem com todos os endereços de e-mail oriundos um país dado como parâmetro;
//     * País deve ser inferido do TLD .com.br, .com, .co.uk, etc...
//     */
//    List<String> listarRemetentesDePais(String pais);
}
