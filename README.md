# 🍔 hamburgueria-bdd

Exercício da UC Gestão e Qualidade de Software. BDD com Java, Cucumber e JUnit 5. Cenários de pedidos da hamburgueria Peppa Lanches cobrindo fluxo feliz, item inexistente, quantidade inválida, desconto e tempo estimado de preparo.

## 🛠️ Tecnologias

| Ferramenta | Versão |
|---|---|
| Java | 21 |
| Maven | 3.9+ |
| Cucumber | 7.20.1 |
| JUnit Jupiter | 5.11.3 |
| JUnit Platform | 1.11.3 |

## 📁 Estrutura

```
hamburgueria-bdd
├── pom.xml
└── src
    ├── main
    │   └── java
    │       └── peppa/hamburgueria
    │           ├── CardapioService.java
    │           └── PedidoService.java
    └── test
        ├── java
        │   ├── steps
        │   │   └── PedidoSteps.java
        │   └── runner
        │       └── RunnerTest.java
        └── resources
            └── features
                └── pedidos.feature
```

## 📚 Regras de Negócio

- Os nomes dos itens devem bater exatamente com o cardápio
- Item inexistente → lança `"Item indisponível no cardápio"`
- Quantidade inválida (≤ 0) → lança `"Quantidade inválida"`
- Tempo estimado = `8 + 2 × quantidadeTotal` minutos

## 🧪 Cenários

| Tag | Cenário |
|---|---|
| `@feliz` | Pedido simples de item existente |
| `@inexistente` | Pedido de item inexistente |
| `@quantidade` | Pedido com quantidade inválida |
| `@desconto` | Pedido com desconto de 10% |
| `@sla` | Calcular tempo estimado de preparo |

## ▶️ Como executar

```bash
mvn test
```

## 📄 Licença

MIT — veja o arquivo [LICENSE](LICENSE) para detalhes.

## 13. Integrantes do Projeto


| Nome              | RA            |
| ----------------- | ------------- |
| Matheus Ferreira  | 4231924502    |
| Victor Hugo       | 42421886      |
| Vinicius Paiva    | 4231923132    |