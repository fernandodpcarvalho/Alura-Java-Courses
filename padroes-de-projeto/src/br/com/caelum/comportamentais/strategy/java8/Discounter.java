package br.com.caelum.comportamentais.strategy.java8;

import java.math.BigDecimal;

public interface Discounter {
	
    BigDecimal applyDiscount(BigDecimal amount);
 
    static Discounter christmasDiscounter() {
        return amount -> amount.multiply(BigDecimal.valueOf(0.9));
    }
 
    static Discounter newYearDiscounter() {
        return amount -> amount.multiply(BigDecimal.valueOf(0.8));
    }
 
    static Discounter easterDiscounter() {
        return amount -> amount.multiply(BigDecimal.valueOf(0.5));
    }
}
