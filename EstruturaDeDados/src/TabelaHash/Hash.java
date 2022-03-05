package TabelaHash;

import java.util.HashMap;

import java.util.Map;
import java.util.TreeSet;
import java.util.Scanner;
import java.util.Set;

public class Hash {

	public static void main(String[] args) {

		Map<String, Integer> myMap = new HashMap<String, Integer>();

		createMap(myMap);
		displayMap(myMap);
	}

	private static void createMap(Map<String, Integer> map) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Digite uma string:");

		String input = scanner.nextLine();

		String[] tokens = input.split(" ");

		for (String token : tokens) {

			String word = token; // Retirei toLowerCase(), para assim tratar de maneira diferente letras
								// minúsculas e maiúsculas.
			word = word.replaceAll("\\P{L}", "");
			// Utilizei o método replaceAll para ignorar qualquer tipo de pontuação
			if (map.containsKey(word)) {

				int count = map.get(word);

				map.put(word, count + 1);
			} else
				map.put(word, 1);
		}
		scanner.close();
	}

	private static void displayMap(Map<String, Integer> map) {
		Set<String> keys = map.keySet();

		TreeSet<String> sortedKeys = new TreeSet<String>(keys);

		System.out.println("\nMapa contém:\nChaves\t\tValor");

		for (String key : sortedKeys)
			if (map.get(key) > 1) // Criei esse metodo para imprimir as palavras duplicadas

				System.out.printf("%-10s%10s\n", key, map.get(key));

		
	}
}

