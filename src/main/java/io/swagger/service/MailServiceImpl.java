package io.swagger.service;

import io.swagger.model.Email;
import io.swagger.model.MailMap;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;


public abstract class MailServiceImpl implements MailService {

    private final MailMap mailMap = new MailMap();

    @Override
	public int contarRemetentes() {
	    return mailMap.size();
	}

	public void salvar(String remetente, Email email) {
		if (!mailMap.containsKey(remetente)) {
            List<Email> emailList = new ArrayList<>();
            emailList.add(email);
            mailMap.put(remetente, emailList);
        } else {
            mailMap.get(remetente).add(email);
        }
	}

	@Override
	public int contarRecebidosDe(String remetente) {
		for (Map.Entry<String, List<Email>> pair : mailMap.entrySet()) {
			if(pair.getKey().equals(remetente) ){
				return (pair.getValue()).size();
			}
		}
		return 0;
	}

	@Override
	public List<String> listarEnderecosComPalavrasNoAssunto(String... argumentos) {
		List<String> result = new ArrayList<>();
		for (Map.Entry<String, List<Email>> pair : mailMap.entrySet()) {
			for(Email email : pair.getValue()){
				boolean include = true;

				for (String s : argumentos) {
					if (!email.getAssunto().toLowerCase().contains(s.toLowerCase())) {
						include = false;
						break;
					}
				}

				if (include) {
					result.add(pair.getKey()); //Se for para retornar dos itens da lista de email, seria email.remetente;
				}
			}
		}
		return result;
	}

	@Override
	public List<Email> obterEmailsComPalavrasNoAssunto(String... argumentos) {
		List<Email> emails = new ArrayList<>();

		for (Map.Entry<String, List<Email>> email : mailMap.entrySet()) {
			for (Email e : email.getValue()) {
				boolean include = true;

				for (String s : argumentos) {
					if (!e.getAssunto().toLowerCase().contains(s.toLowerCase())) {
						include = false;
						break;
					}
				}

				if (include) {
					emails.add(e);
				}
			}
		}

		return emails;
	}

	@Override
	public int removerEmailsAntesDe(LocalDateTime dataHora) {
		List<Email> emailsRemovidos = new ArrayList<>();

		for (Map.Entry<String, List<Email>> remetente : mailMap.entrySet()) {
			for (Email e : remetente.getValue()) {
				if (e.getDataRecebimento().isBefore(dataHora)) {
					emailsRemovidos.add(e);
				}
			}

			remetente.getValue().removeAll(emailsRemovidos);
		}

		return emailsRemovidos.size();
	}

	@Override
	public List<String> listarRemetentesComEnviosHoje() {
		/*Jeff*/
		List<String> remetentes = new ArrayList<>();
		LocalDate today = LocalDate.now();

		for (Map.Entry<String, List<Email>> remetente : mailMap.entrySet()) {
			for (Email email : remetente.getValue()) {
				if (email.getDataEnvio().toLocalDate().isEqual(today)) {
					remetentes.add(remetente.getKey());
				}
			}
		}

		return remetentes;
	}

	@Override
	public int removerEmailsDeContendoPalavras(String remetente, String... assunto) {
		/*Jeff*/
		if (!mailMap.containsKey(remetente)) {
			return 0;
		}

		List<Email> emailsRemovidos = new ArrayList<>();

		for (Email email : mailMap.get(remetente)) {
			for (String palavra : assunto) {
				if (email.getAssunto().toLowerCase().contains(palavra.toLowerCase())) {
					emailsRemovidos.add(email);
				}
			}
		}

		mailMap.get(remetente).removeAll(emailsRemovidos);
		return emailsRemovidos.size();
	}

	@Override
	public int removerEmailsDeAntesDe(String remetente, LocalDateTime dataHora) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<String> listarRemetentesDePais(String pais) {
		List<String> listaRemetentes = new ArrayList<>();
        for (Map.Entry<String, List<Email>> emailList : mailMap.entrySet()) {
            if(emailList.getKey().endsWith(pais)){
                listaRemetentes.add(emailList.getKey());
            }
        }
		return listaRemetentes;
	}
}
