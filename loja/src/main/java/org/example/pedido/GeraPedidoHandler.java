package org.example.pedido;

import org.example.Pedido;
import org.example.orcamento.Orcamento;
import org.example.pedido.GeraPedido;
import org.example.pedido.acao.AcaoAposGerarPedido;
import org.example.pedido.acao.EnviarEmailPedido;
import org.example.pedido.acao.SalvarPedidoNoBancoDados;

import java.time.LocalDateTime;
import java.util.List;

public class GeraPedidoHandler {
        private List<AcaoAposGerarPedido> acoes;

    public GeraPedidoHandler(List<AcaoAposGerarPedido> acoes) {
        this.acoes = acoes;
    }

    public void executa(GeraPedido dados){
        Orcamento orcamento = new Orcamento(dados.getValorOrcamento(), dados.getQuantidades());
        Pedido pedido = new Pedido(dados.getCliente(),LocalDateTime.now(), orcamento );

        acoes.forEach(a -> a.executar(pedido));

    }

}
