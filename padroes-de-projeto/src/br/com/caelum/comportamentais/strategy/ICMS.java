package br.com.caelum.comportamentais.strategy;

//Implementa o tipo imposto ICMS com valor espec�fico de calculo
public class ICMS implements Imposto {

    public double calcula(Orcamento orcamento) {
        return orcamento.getValor() * 0.1;
    }

}
