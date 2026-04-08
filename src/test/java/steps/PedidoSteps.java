package steps;

import io.cucumber.java.pt.*;
import io.cucumber.datatable.DataTable;
import peppa.hamburgueria.CardapioService;
import peppa.hamburgueria.PedidoService;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoSteps {

    private CardapioService cardapio;
    private PedidoService pedidoService;

    private double totalCalculado;
    private int tempoCalculado;
    private String mensagemErro;

    @Dado("que o cardápio contém os itens:")
    public void que_o_cardapio_contem_os_itens(DataTable tabela) {
        cardapio = new CardapioService();
        pedidoService = new PedidoService(cardapio);

        List<Map<String, String>> linhas = tabela.asMaps();
        for (Map<String, String> linha : linhas) {
            String item = linha.get("item");
            double preco = Double.parseDouble(linha.get("preco"));
            cardapio.cadastrarItem(item, preco);
        }
    }

    @Quando("o cliente pedir {int} unidade de {string}")
    public void o_cliente_pedir_unidade(int quantidade, String item) {
        o_cliente_pedir_unidades(quantidade, item);
    }

    @Quando("o cliente pedir {int} unidades de {string}")
    public void o_cliente_pedir_unidades(int quantidade, String item) {
        try {
            totalCalculado = pedidoService.calcularTotal(item, quantidade);
            tempoCalculado = pedidoService.calcularTempoEstimado(quantidade);
            mensagemErro = null;
        } catch (IllegalArgumentException e) {
            mensagemErro = e.getMessage();
        }
    }

    @Quando("o cliente pedir {int} unidades de {string} com {int} porcento de desconto")
    public void o_cliente_pedir_com_desconto(int quantidade, String item, int desconto) {
        try {
            totalCalculado = pedidoService.calcularTotalComDesconto(item, quantidade, desconto);
            mensagemErro = null;
        } catch (IllegalArgumentException e) {
            mensagemErro = e.getMessage();
        }
    }

    @Então("o valor total do pedido deve ser {double}")
    public void o_valor_total_do_pedido_deve_ser(double esperado) {
        assertNull(mensagemErro, "Não era esperado erro, mas ocorreu: " + mensagemErro);
        assertEquals(esperado, totalCalculado, 0.001);
    }

    @Então("deve ser exibida a mensagem de erro {string}")
    public void deve_ser_exibida_a_mensagem_de_erro(String mensagemEsperada) {
        assertNotNull(mensagemErro, "Era esperado um erro, mas nenhum foi lançado.");
        assertEquals(mensagemEsperada, mensagemErro);
    }

    @Então("o tempo estimado de preparo deve ser {int} minutos")
    public void o_tempo_estimado_de_preparo_deve_ser(int esperado) {
        assertNull(mensagemErro, "Não era esperado erro, mas ocorreu: " + mensagemErro);
        assertEquals(esperado, tempoCalculado);
    }
}
