package target;

import java.util.Scanner;

public class Exercicio5 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Digite a string a ser invertida: ");
		String stringOriginal = scanner.nextLine();

		
		String StringInvertida = "";

		
		for (int i = stringOriginal.length() - 1; i >= 0; i--) {
			StringInvertida += stringOriginal.charAt(i); 
		}

		System.out.println("String invertida: " + StringInvertida);

		scanner.close();
	}
}
