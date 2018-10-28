package br.com.caelum.comportamentais.state;

public class EmAprovacao implements EstadoDeUmOrcamento {  
    private boolean descontoAplicado = false;
    public void aplicaDescontoExtra(Orcamento orcamento) {
      if(!descontoAplicado) {
        orcamento.valor -= orcamento.valor * 0.05;
        descontoAplicado = true;
      }
      else {
        throw new RuntimeException("Desconto j� aplicado!");
      }
    }

    public void aprova(Orcamento orcamento) {
      // desse estado posso ir para o estado de aprovado
      orcamento.estadoAtual = new Aprovado();
    }

    public void reprova(Orcamento orcamento) {
      // desse estado posso ir para o estado de reprovado tambem
      orcamento.estadoAtual = new Reprovado();
    }

    public void finaliza(Orcamento orcamento) {
      // daqui n�o posso ir direto para finalizado
      throw new RuntimeException("Orcamento em aprova��o n�o podem ir para finalizado diretamente");
    }
}