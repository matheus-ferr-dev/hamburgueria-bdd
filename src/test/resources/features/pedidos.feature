# language: pt
@hamburgueria
Funcionalidade: Pedidos na hamburgueria Peppa Lanches
  Para realizar pedidos corretos
  Como cliente
  Eu quero saber se o item pode ser pedido, o valor total e o tempo estimado

  Contexto:
    Dado que o cardápio contém os itens:
      | item         | preco |
      | x-bacon      | 25.00 |
      | x-salada     | 22.00 |
      | batata frita | 12.00 |

  @feliz
  Cenário: Pedido simples de item existente
    Quando o cliente pedir 2 unidades de "x-bacon"
    Então o valor total do pedido deve ser 50.0

  @inexistente
  Cenário: Pedido de item inexistente
    Quando o cliente pedir 1 unidade de "x-frango"
    Então deve ser exibida a mensagem de erro "Item indisponível no cardápio"

  @quantidade
  Cenário: Pedido com quantidade inválida
    Quando o cliente pedir 0 unidades de "x-salada"
    Então deve ser exibida a mensagem de erro "Quantidade inválida"

  @desconto
  Cenário: Pedido com desconto de 10 por cento
    Quando o cliente pedir 2 unidades de "batata frita" com 10 porcento de desconto
    Então o valor total do pedido deve ser 21.6

  @sla
  Cenário: Calcular tempo estimado de preparo
    Quando o cliente pedir 3 unidades de "x-salada"
    Então o tempo estimado de preparo deve ser 14 minutos
