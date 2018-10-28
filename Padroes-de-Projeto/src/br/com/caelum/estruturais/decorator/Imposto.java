package br.com.caelum.estruturais.decorator;

public abstract class Imposto {
	
	protected final Imposto outroImposto;
	
	// construtor default para casos em que a composi��o n�o seja necess�ria.
    public Imposto() {
      this.outroImposto = null;
    }
	
    public Imposto(Imposto outroImposto) {
        this.outroImposto = outroImposto;
    }

    public abstract double calcula(Orcamento orcamento);
    
    protected double calculoDoOutroImposto(Orcamento orcamento) {
    	return (outroImposto == null? 0 : outroImposto.calcula(orcamento));
      }

}
