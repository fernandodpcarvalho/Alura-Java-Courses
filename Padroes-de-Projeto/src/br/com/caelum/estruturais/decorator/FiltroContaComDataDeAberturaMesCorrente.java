package br.com.caelum.estruturais.decorator;

import java.util.Calendar;

public class FiltroContaComDataDeAberturaMesCorrente extends Filtro {	

	public FiltroContaComDataDeAberturaMesCorrente() {
		super();
	}

	public FiltroContaComDataDeAberturaMesCorrente(Filtro outroFiltro) {
		super(outroFiltro);
	}

	@Override
	protected boolean aplicaFiltro(Conta conta) {
		if(conta.getDataAbertura().get(Calendar.MONTH) == Calendar.getInstance().get(Calendar.MONTH) &&
		   conta.getDataAbertura().get(Calendar.YEAR)  == Calendar.getInstance().get(Calendar.YEAR)) {
			System.out.println("M�s de abertura de conta � igual ao m�s corrente");
			return true;
		}
		else return AplicaFiltroComposto(conta);
	}

}
