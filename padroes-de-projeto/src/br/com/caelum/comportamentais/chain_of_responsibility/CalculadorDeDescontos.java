package br.com.caelum.comportamentais.chain_of_responsibility;

public class CalculadorDeDescontos {
    public double calcula(Orcamento orcamento) {
    	Desconto d1 = new DescontoPorMaisDeCincoItens();
        Desconto d2 = new DescontoPorMaisDeQuinhentosReais();
        Desconto d3 = new DescontoPorVendaCasada();
        Desconto d4 = new SemDesconto();


        d1.setProximo(d2);
        d2.setProximo(d3);
        d3.setProximo(d4);

        return d1.desconta(orcamento);
    }
  }


//IMPLEMENTA��O RUIM USANDO CONDICIONAIS
/*
public class CalculadorDeDescontos {
    public double calcula(Orcamento orcamento) {
      // verifica primeira regra de poss�vel desconto
      if(orcamento.getItens().size() > 5) {
        return orcamento.getValor() * 0.1;
      }

      // verifica segunda regra de poss�vel desconto
      else if(orcamento.getValor() > 500.0) {
        return orcamento.getValor() * 0.07;
      }

      // verifica terceira, quarta, quinta regra de poss�vel desconto ...
      // um monte de ifs daqui pra baixo
    }
 }
 */