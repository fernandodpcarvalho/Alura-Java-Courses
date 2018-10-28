import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStrings {

	public static void main(String[] args) {
		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("casa do c�digo");
		palavras.add("caelum");

		// List<String> palavras = Arrays.asList("alura online", "casa do
		// c�digo", "caelum");

		// Ordena��o em Java 7
		Collections.sort(palavras);
		System.out.println(palavras);

		// Ordena��o com java7 com outro crit�rio de ordena��o:
		Comparator<String> comparador = new ComparadorDeStringPorTamanho();
		Collections.sort(palavras, comparador);
		System.out.println(palavras);

		// Ordena��o com Java8
		palavras.sort(comparador);
		System.out.println(palavras);

		// foreach com java 7
		for (String palavra : palavras) {
			System.out.println(palavra);
		}

		// foreach com java 8
		Consumer<String> consumidor = new ConsumidorDeString();
		palavras.forEach(consumidor);

	}

}

// Para mudar o crit�rio de ordena��o
class ComparadorDeStringPorTamanho implements Comparator<String> {
	public int compare(String s1, String s2) {
		if (s1.length() < s2.length())
			return -1;
		if (s1.length() > s2.length())
			return 1;
		return 0;
	}
}

class ConsumidorDeString implements Consumer<String> {
	public void accept(String s) {
		System.out.println(s);
	}
}