package br.com.ada.f1rst.mail.service.impl;

import br.com.ada.f1rst.mail.model.Created;
import br.com.ada.f1rst.mail.model.Email;
import br.com.ada.f1rst.mail.model.Emails;
import br.com.ada.f1rst.mail.service.MailService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MailServiceImpl implements MailService {

    private final List<Email> mailTable = new ArrayList<>(0);

    @Override
    public Emails listarEmails(String senderAddress, String receiverAddress, String subjectContains, String receivedDate) {
        Emails emails = Emails.builder().build();

        try (Jedis jedis = new Jedis(HostAndPort.from("localhost:6379"))) {
            String key = "emails_com_palavras_no_assunto";

            if (Boolean.FALSE.equals(jedis.exists(key))) {
                for (Email e : filterTable(senderAddress, receiverAddress, subjectContains, receivedDate)) {
                    jedis.sadd(key, e.toString());
                    jedis.expire(key, (long) 60 * 60 * 1000);
                }
            }

            Set<String> emailStrings = jedis.smembers(key);

            for (String emailString : emailStrings) {
                emails.add(Email.fromString(emailString));
            }
        } catch (Exception e) {
            // Whenever there is NO cache (being it absence of the Redis or even when an error occurs)
            emails.addAll(filterTable(senderAddress, receiverAddress, subjectContains, receivedDate));
        }

        return emails;
    }

    private List<Email> filterTable(String senderAddress, String receiverAddress, String subjectContains, String receivedDate) {
        return mailTable.stream()
                .filter(m -> senderAddress == null || (senderAddress != null && m.getRemetente().equalsIgnoreCase(senderAddress)))
                .filter(m -> receiverAddress == null || (receiverAddress != null && m.getListaDestinatarios().stream().anyMatch(c -> c.getEmail().equalsIgnoreCase(receiverAddress))))
                .filter(m -> subjectContains == null || (subjectContains != null && m.getAssunto().contains(subjectContains)))
                .filter(m -> receivedDate == null || (receivedDate != null && m.getDataHoraRecebimento().toLocalDate().isEqual(LocalDate.parse(receivedDate))))
                .collect(Collectors.toList());
    }

    @Override
    public Created salvarEmails(Email email) {
        if (!mailTable.contains(email)) {
            mailTable.add(email);

            return Created.builder().newId((long) mailTable.indexOf(email)).build();
        } else {
            throw new HttpClientErrorException(HttpStatus.UNPROCESSABLE_ENTITY, "Email already exists!");
        }
    }

//    @Override
//    public int contarRemetentes() {
//        return mailMap.size();
//    }
//
//    public void salvar(String remetente, Email email) {
//        if (!mailMap.containsKey(remetente)) {
//            mailMap.put(remetente, new ArrayList<>(List.of(email)));
//        } else {
//            mailMap.get(remetente).add(email);
//        }
//    }
//
//    @Override
//    public int contarRecebidosDe(String remetente) {
//        for (Map.Entry<String, List<Email>> pair : mailMap.entrySet()) {
//            if (pair.getKey().equals(remetente)) {
//                return (pair.getValue()).size();
//            }
//        }
//        return 0;
//    }
//
//    @Override
//    public List<String> listarEnderecosComPalavrasNoAssunto(String... argumentos) {
//        List<String> result = new ArrayList<>();
//        for (Map.Entry<String, List<Email>> pair : mailMap.entrySet()) {
//            for (Email email : pair.getValue()) {
//                boolean include = true;
//
//                for (String s : argumentos) {
//                    if (!email.getAssunto().toLowerCase().contains(s.toLowerCase())) {
//                        include = false;
//                        break;
//                    }
//                }
//
//                if (include) {
//                    result.add(pair.getKey()); //Se for para retornar dos itens da lista de email, seria email.remetente;
//                }
//            }
//        }
//        return result;
//    }
//
//    @Override
//    public List<Email> obterEmailsComPalavrasNoAssunto(String... argumentos) {
//        List<Email> emails = new ArrayList<>();
//
//        for (Map.Entry<String, List<Email>> email : mailMap.entrySet()) {
//            for (Email e : email.getValue()) {
//                boolean include = true;
//
//                for (String s : argumentos) {
//                    if (!e.getAssunto().toLowerCase().contains(s.toLowerCase())) {
//                        include = false;
//                        break;
//                    }
//                }
//
//                if (include) {
//                    emails.add(e);
//                }
//            }
//        }
//
//        return emails;
//    }
//
//    @Override
//    public int removerEmailsAntesDe(LocalDateTime dataHora) {
//        List<Email> emailsRemovidos = new ArrayList<>();
//
//        for (Map.Entry<String, List<Email>> remetente : mailMap.entrySet()) {
//            for (Email e : remetente.getValue()) {
//                if (e.getDataHoraRecebimento().isBefore(dataHora)) {
//                    emailsRemovidos.add(e);
//                }
//            }
//
//            remetente.getValue().removeAll(emailsRemovidos);
//        }
//
//        return emailsRemovidos.size();
//    }
//
//    @Override
//    public List<String> listarRemetentesComEnviosHoje() {
//        /*Jeff*/
//        List<String> remetentes = new ArrayList<>();
//        LocalDate today = LocalDate.now();
//
//        for (Map.Entry<String, List<Email>> remetente : mailMap.entrySet()) {
//            for (Email email : remetente.getValue()) {
//                if (email.getDataHoraEnvio().toLocalDate().isEqual(today)) {
//                    remetentes.add(remetente.getKey());
//                }
//            }
//        }
//
//        return remetentes;
//    }
//
//    @Override
//    public int removerEmailsDeContendoPalavras(String remetente, String... assunto) {
//        /*Jeff*/
//        if (!mailMap.containsKey(remetente)) {
//            return 0;
//        }
//
//        List<Email> emailsRemovidos = new ArrayList<>();
//
//        for (Email email : mailMap.get(remetente)) {
//            for (String palavra : assunto) {
//                if (email.getAssunto().toLowerCase().contains(palavra.toLowerCase())) {
//                    emailsRemovidos.add(email);
//                }
//            }
//        }
//
//        mailMap.get(remetente).removeAll(emailsRemovidos);
//        return emailsRemovidos.size();
//    }
//
//    @Override
//    public int removerEmailsDeAntesDe(String remetente, LocalDateTime dataHora) {
//        // TODO Auto-generated method stub
//        return 0;
//    }
//
//    @Override
//    public List<String> listarRemetentesDePais(String pais) {
//        List<String> listaRemetentes = new ArrayList<>();
//        for (Map.Entry<String, List<Email>> emailList : mailMap.entrySet()) {
//            if (emailList.getKey().endsWith(pais)) {
//                listaRemetentes.add(emailList.getKey());
//            }
//        }
//        return listaRemetentes;
//    }
}
