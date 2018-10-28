package br.com.caelum.comportamentais.strategy;

//Recebe um orcamento e aplica um calculo de imposto usando polimorfismo
public class CalculadorDeImpostos {

	//M�todo que recebe um tipo Imposto, cuja implementa��o ser� identificada em tempo de execu��o 
    public void realizaCalculo(Orcamento orcamento, Imposto imposto) {

      double valor = imposto.calcula(orcamento); 

      System.out.println(valor);

    }

}




//IMPLEMENTA��O RUIM USANDO CONDICIONAIS
/*
public class CalculadorDeImpostos {

    public void realizaCalculo(Orcamento orcamento, String imposto) {

    if( "ICMS".equals(imposto) ) {

      double icms = orcamento.getValor() * 0.1;
      System.out.println(icms); // imprimir� 50.0

    } else if( "ISS".equals(imposto) ) {

      double iss = orcamento.getValor() * 0.06;
      System.out.println(iss); // imprimir� 30.0

      }
    }
}
*/