package br.com.caelum.comportamentais.template_method;

//Define que toda classe de tipo imposto deve implementar um m�todo calculo espec�fico
public interface Imposto {
    double calcula(Orcamento orcamento);
}
