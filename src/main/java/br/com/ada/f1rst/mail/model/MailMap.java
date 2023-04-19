package br.com.ada.f1rst.mail.model;

import java.util.HashMap;
import java.util.List;

/**
 * Chave do mapa é o endereço de envio (remetente)
 * Valor do mapa é a lista dos emails
 */
public class MailMap extends HashMap<String, List<Email>> {}
