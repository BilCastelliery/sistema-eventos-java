# Sistema de Eventos em Java

Este é um sistema de cadastro e notificação de eventos desenvolvido em **Java**, para rodar no console.
O projeto segue o paradigma de Programação Orientada a Objetos e salva os eventos em um arquivo `events.data`.

## Estrutura do Projeto

```
sistema-eventos/
├── src/
│   └── sistema/
│       ├── Main.java
│       ├── manager/
│       ├── models/
│       ├── storage/
│       └── utils/
├── events.data
├── README.md
└── .gitignore
```

## Funcionalidades

- Cadastro de usuários
- Cadastro de eventos (com nome, endereço, categoria, horário e descrição)
- Confirmação e cancelamento de participação em eventos
- Listagem de eventos por categoria e ordenados por data/hora
- Identificação de eventos passados, futuros e em andamento
- Persistência dos eventos no arquivo `events.data`

## Como rodar

### No Eclipse

1. Abra o **Eclipse**.
2. Vá em `File > Import > Existing Projects into Workspace`.
3. Selecione a pasta `sistema-eventos`.
4. Compile e rode a classe `Main.java`.

### No terminal (Linux/Mac/Windows com Java instalado)

```bash
cd sistema-eventos
javac -d bin $(find src -name "*.java")
java -cp bin sistema.Main
```

> Obs: no Windows, troque `$(find src -name "*.java")` por `dir /s /b src\*.java`.

## Arquivo de dados

- O arquivo `events.data` é usado para armazenar os eventos cadastrados.
- Na primeira execução, ele estará vazio, e será populado conforme eventos forem criados.

---

### Autor

Projeto acadêmico desenvolvido em Java - Sistema de Eventos (console).
