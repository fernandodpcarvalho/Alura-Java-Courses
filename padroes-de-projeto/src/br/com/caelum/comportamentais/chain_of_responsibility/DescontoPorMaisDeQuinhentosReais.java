package br.com.caelum.comportamentais.chain_of_responsibility;

//Implementa o tipo desconto por mais de 500 reais e qual o pr�ximo da sequ�ncia.
public class DescontoPorMaisDeQuinhentosReais implements Desconto {
    private Desconto proximo;

    public void setProximo(Desconto proximo) {
      this.proximo = proximo;
    }

    public double desconta(Orcamento orcamento) {
      if(orcamento.getValor() > 500) {
        return orcamento.getValor() * 0.07;
      }
      else {
        return proximo.desconta(orcamento);
      }
    }
  }
