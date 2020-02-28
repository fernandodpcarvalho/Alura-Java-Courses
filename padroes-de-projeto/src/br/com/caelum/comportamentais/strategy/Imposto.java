package br.com.caelum.comportamentais.strategy;

//Define que toda classe de tipo imposto deve implementar um m�todo calculo espec�fico
public interface Imposto {
    double calcula(Orcamento orcamento);
}
