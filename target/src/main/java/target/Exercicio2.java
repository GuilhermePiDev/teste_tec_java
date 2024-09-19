package target;

import java.util.Scanner;

public class Exercicio2 {

	public static void main(String[] args) {
		int entrada = 0;
		Scanner sca = new Scanner(System.in);

		System.out.println("Qual o valor que quer saber se está na sequencia de Fibonacci?");
		entrada = sca.nextInt();

		if (isFibonacci(entrada)) {
			System.out.println("O número " + entrada + " pertence à sequência de Fibonacci.");
		} else {
			System.out.println("O número " + entrada + " NÃO pertence à sequência de Fibonacci.");
		}

		sca.close();
	}

	public static boolean isFibonacci(int num) {
		if (num == 0 || num == 1) {
			return true;
		}

		int primeiro = 0;
		int segundo = 1;
		int proximo = 1;

		while (proximo < num) {
			proximo = primeiro + segundo;
			primeiro = segundo;
			segundo = proximo;
		}

		return proximo == num;
	}
}
