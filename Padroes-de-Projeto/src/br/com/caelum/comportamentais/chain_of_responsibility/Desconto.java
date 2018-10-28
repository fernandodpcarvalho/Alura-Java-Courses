package br.com.caelum.comportamentais.chain_of_responsibility;

//Define que toda classe de tipo desconto deve implementar um m�todo calculo espec�fico
public interface Desconto {
    double desconta(Orcamento orcamento);
    void setProximo(Desconto proximo);
  }