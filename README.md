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

# Contrato

```yaml
openapi: 3.0.3
info:
  version: 1.0.0
  title: ADA Mail Management
servers:
  - url: "https://f1rst.ada.com/mail_project"
paths:
  /api/email:
    get:
      tags:
        - Email Management
      parameters:
        - $ref: "#/components/parameters/SenderAddress"
        - $ref: "#/components/parameters/ReceiverAddress"
        - $ref: "#/components/parameters/SubjectContains"
        - $ref: "#/components/parameters/ReceivedDate"
      responses:
        '200':
          $ref: '#/components/responses/GetListOk'
        '500':
          $ref: '#/components/responses/InternalServerError'
    delete:
      tags:
        - Email Management
      parameters:
        - $ref: "#/components/parameters/SenderAddress"
        - $ref: "#/components/parameters/ReceiverAddress"
        - $ref: "#/components/parameters/SubjectContains"
        - $ref: "#/components/parameters/ReceivedDate"
      responses:
        '204':
          $ref: '#/components/responses/NoContent'
        '500':
          $ref: '#/components/responses/InternalServerError'
    post:
      tags:
        - Email Management
      requestBody:
        $ref: "#/components/requestBodies/PostEmail"
      responses:
        '200':
          $ref: '#/components/responses/PostEmailOk'
        '400':
          $ref: '#/components/responses/BadRequest'
        '500':
          $ref: '#/components/responses/InternalServerError'
  /api/email/{id_email}:
    get:
      tags:
        - Email Management
      parameters:
        - $ref: "#/components/parameters/IdEmail"
      responses:
        '200':
          $ref: '#/components/responses/GetEmailOk'
        '404':
          $ref: '#/components/responses/NotFound'
        '500':
          $ref: '#/components/responses/InternalServerError'
  /api/email/count:
    get:
      tags:
        - Email Management
      parameters:
        - $ref: "#/components/parameters/SenderAddress"
        - $ref: "#/components/parameters/ReceiverAddress"
        - $ref: "#/components/parameters/SubjectContains"
        - $ref: "#/components/parameters/ReceivedDate"
      responses:
        '200':
          $ref: '#/components/responses/GetCountOk'
        '500':
          $ref: '#/components/responses/InternalServerError'
components:
  schemas:
    Created:
      type: object
      properties:
        new_id:
          description: Newly created Internal Identification
          example: 1
          type: number
    Contact:
      type: object
      required:
        - nome
        - email
      properties:
        id_anexo:
          description: Internal Identification
          example: 1
          type: number
        nome:
          description: Contact's name
          example: John Doe
          type: string
        email:
          description: Email address
          example: user@domain.com
          type: string
        telefone:
          description: Contact's phone number
          example: +5511988776655
          type: string
        endereco:
          description: Contact's physical address
          example: 512, 5th Avenue
          type: string
    Attachment:
      type: object
      required:
        - tipo
        - nome
        - conteudo
        - tamanho
      properties:
        id_anexo:
          description: Internal Identification
          example: 1
          type: number
        tipo:
          description: File type
          example: pdf
          type: string
        nome:
          description: Friendly name of the file
          example: hello.pdf
          type: string
        conteudo:
          description: Content of the file
          example: iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAMAAADXqc3KAAAB+FBMVEUAAAA/mUPidDHiLi5Cn0XkNTPmeUrkdUg/m0Q0pEfcpSbwaVdKskg+lUP4zA/iLi3msSHkOjVAmETdJSjtYFE/lkPnRj3sWUs8kkLeqCVIq0fxvhXqUkbVmSjwa1n1yBLepyX1xxP0xRXqUkboST9KukpHpUbuvRrzrhF/ljbwaljuZFM4jELaoSdLtElJrUj1xxP6zwzfqSU4i0HYnydMtUlIqUfywxb60AxZqEXaoifgMCXptR9MtklHpEY2iUHWnSjvvRr70QujkC+pUC/90glMuEnlOjVMt0j70QriLS1LtEnnRj3qUUXfIidOjsxAhcZFo0bjNDH0xxNLr0dIrUdmntVTkMoyfL8jcLBRuErhJyrgKyb4zA/5zg3tYFBBmUTmQTnhMinruBzvvhnxwxZ/st+Ktt5zp9hqota2vtK6y9FemNBblc9HiMiTtMbFtsM6gcPV2r6dwroseLrMrbQrdLGdyKoobKbo3Zh+ynrgVllZulTsXE3rV0pIqUf42UVUo0JyjEHoS0HmsiHRGR/lmRz/1hjqnxjvpRWfwtOhusaz0LRGf7FEfbDVmqHXlJeW0pbXq5bec3fX0nTnzmuJuWvhoFFhm0FtrziBsjaAaDCYWC+uSi6jQS3FsSfLJiTirCOkuCG1KiG+wSC+GBvgyhTszQ64Z77KAAAARXRSTlMAIQRDLyUgCwsE6ebm5ubg2dLR0byXl4FDQzU1NDEuLSUgC+vr6urq6ubb29vb2tra2tG8vLu7u7uXl5eXgYGBgYGBLiUALabIAAABsElEQVQoz12S9VPjQBxHt8VaOA6HE+AOzv1wd7pJk5I2adpCC7RUcHd3d3fXf5PvLkxheD++z+yb7GSRlwD/+Hj/APQCZWxM5M+goF+RMbHK594v+tPoiN1uHxkt+xzt9+R9wnRTZZQpXQ0T5uP1IQxToyOAZiQu5HEpjeA4SWIoksRxNiGC1tRZJ4LNxgHgnU5nJZBDvuDdl8lzQRBsQ+s9PZt7s7Pz8wsL39/DkIfZ4xlB2Gqsq62ta9oxVlVrNZpihFRpGO9fzQw1ms0NDWZz07iGkJmIFH8xxkc3a/WWlubmFkv9AB2SEpDvKxbjidN2faseaNV3zoHXvv7wMODJdkOHAegweAfFPx4G67KluxzottCU9n8CUqXzcIQdXOytAHqXxomvykhEKN9EFutG22p//0rbNvHVxiJywa8yS2KDfV1dfbu31H8jF1RHiTKtWYeHxUvq3bn0pyjCRaiRU6aDO+gb3aEfEeVNsDgm8zzLy9egPa7Qt8TSJdwhjplk06HH43ZNJ3s91KKCHQ5x4sw1fRGYDZ0n1L4FKb9/BP5JLYxToheoFCVxz57PPS8UhhEpLBVeAAAAAElFTkSuQmCC
          type: string
        tamanho:
          description: Byte size of the file
          example: 512
          type: string
        descricao:
          description: Description of the file
          example: Test PDF
          type: string
    Email:
      type: object
      required:
        - assunto
        - data_hora
        - remetente
        - lista_destinatarios
      properties:
        id_email:
          description: Internal Identification
          example: 1
          type: number
        assunto:
          description: Subject of the email
          example: Hello World!
          type: string
        data_hora:
          description: Date and time of the arrival
          example: 2023-04-14T20:04:16.123Z
          type: string
        conteudo:
          description: Content of the email
          example: <body><h1>hello</h1></body>
          type: string
        remetente:
          description: Sender of the email
          example: user@domain.com
          type: string
        lista_destinatarios:
          type: array
          items:
            $ref: "#/components/schemas/Contact"
        lista_anexos:
          type: array
          items:
            $ref: "#/components/schemas/Attachment"
    Count:
      type: object
      properties:
        quantity:
          description: Quantity counted
          example: 32
          type: number
    Emails:
      type: array
      items:
        $ref: "#/components/schemas/Email"
    Error:
      type: object
      properties:
        errorCode:
          description: Code of the error
          example:  500
          type: number
        errorMessage:
          description: Main message of the error
          example: Failed to persist data onto database
          type: string
        errorDetail:
          description: Detail of the error
          example: The foreign key was null where it should be not
          type: string
  requestBodies:
    PostEmail:
      content:
        application/json:
          schema:
            $ref: "#/components/schemas/Email"
  responses:
    PostEmailOk:
      description: OK
      content:
        application/json:
          schema:
            $ref: "#/components/schemas/Created"
    GetEmailOk:
      description: OK
      content:
        application/json:
          schema:
            $ref: "#/components/schemas/Email"
    GetCountOk:
      description: OK
      content:
        application/json:
          schema:
            $ref: "#/components/schemas/Count"
    GetListOk:
      description: OK
      content:
        application/json:
          schema:
            $ref: "#/components/schemas/Emails"
    NoContent:
      description: No Content
      content:
        application/json:
          schema:
            $ref: "#/components/schemas/Error"
    NotFound:
      description: Not found
      content:
        application/json:
          schema:
            $ref: "#/components/schemas/Error"
    BadRequest:
      description: Bad Request
      content:
        application/json:
          schema:
            $ref: "#/components/schemas/Error"
    InternalServerError:
      description: Internal Server Error
      content:
        application/json:
          schema:
            $ref: "#/components/schemas/Error"
  parameters:
    SenderAddress:
      description: Sender Address to fetch
      name: sender_address
      in: query
      schema:
        type: string
    ReceiverAddress:
      description: Receiver Address to fetch
      name: receiver_address
      in: query
      schema:
        type: string
    SubjectContains:
      description: Subject contains to fetch
      name: subject_contains
      in: query
      schema:
        type: string
    ReceivedDate:
      description: Received on the date
      name: received_date
      in: query
      schema:
        type: number
    IdEmail:
      description: Email identifier
      name: id_email
      in: path
      required: true
      schema:
        type: number
```
