package br.com.caelum.comportamentais.visitor;

//Representa uma express�o, que pode ser uma opera��o ou apenas um n�mero 
public interface Expressao {
    int avalia();
    void aceita(Visitor visitor);
}
