# GerenciadorEmails
Sistema Gerenciador de Emails

Cada e-mail recebido numa dada conta de e-mail é guardado contendo o endereço de quem o enviou, a data de envio, a data de recebimento, o assunto e o texto do e-mail (não se consideram anexos, etc.).

Crie uma classe MailMap que associe a cada endereço de envio todos os mails recebidos (classe EMail) e implemente as seguintes operações:
Determinar o total de endereços a partir dos quais se recebeu mail;

Guardar um novo mail recebido;

Determinar quantos mails têm por origem um dado endereço;

Criar uma lista com todos os endereços que enviaram mails contendo no seu assunto uma lista de palavras dada como parâmetro;

O mesmo que a questão anterior, mas criando um conjunto contendo os mails;

Eliminar todos os e-mails recebidos antes de uma data que é dada como parâmetro;

Criar uma lista dos endereços que hoje enviaram mails;

Dada uma lista de palavras, eliminar todos os mails de um dado endereço que no seu assunto contenham uma qualquer destas (anti-spam);

Eliminar todos os mails de um dado endereço anteriores a uma data dada;

Criar uma listagem com todos os endereços de e-mail oriundos um país dado como parâmetro;


# Linguagem Ubíqua

Email - objeto que caracteriza um email contendo endereço de email da origem, endereço de e-mail do destinatário, neste caso sempre o mesmo, título do e-mail, mensagem no corpo do email.

Contato - objeto que caracteriza o cadastro dos contatos contendo endereço de e-mail, nome, telefone, endereço e descrição.

Lista Emails - Um objeto que mantém uma lista dos objetos Email's.

# ADA Mail Management
## Version: 1.0.0

### /api/email

#### GET
##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
|  |  |  | No | [SenderAddress](#SenderAddress) |
|  |  |  | No | [ReceiverAddress](#ReceiverAddress) |
|  |  |  | No | [SubjectContains](#SubjectContains) |
|  |  |  | No | [ReceivedDate](#ReceivedDate) |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 |  |
| 204 |  |
| 500 |  |

#### DELETE
##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
|  |  |  | No | [SenderAddress](#SenderAddress) |
|  |  |  | No | [ReceiverAddress](#ReceiverAddress) |
|  |  |  | No | [SubjectContains](#SubjectContains) |
|  |  |  | No | [ReceivedDate](#ReceivedDate) |

##### Responses

| Code | Description |
| ---- | ----------- |
| 204 |  |
| 404 |  |
| 500 |  |

#### POST
##### Responses

| Code | Description |
| ---- | ----------- |
| 200 |  |
| 400 |  |
| 500 |  |

### /api/email/{id_email}

#### GET
##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
|  |  |  | No | [IdEmail](#IdEmail) |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 |  |
| 404 |  |
| 500 |  |

### /api/email/count

#### GET
##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
|  |  |  | No | [SenderAddress](#SenderAddress) |
|  |  |  | No | [ReceiverAddress](#ReceiverAddress) |
|  |  |  | No | [SubjectContains](#SubjectContains) |
|  |  |  | No | [ReceivedDate](#ReceivedDate) |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 |  |
| 204 |  |
| 500 |  |

