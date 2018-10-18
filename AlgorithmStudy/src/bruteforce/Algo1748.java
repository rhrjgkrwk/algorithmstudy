package bruteforce;

import java.util.Scanner;

public class Algo1748 {
	public static int N;
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		N = sc.nextInt();
		int d = String.valueOf(N).length() - 1;
		int result = 0;

		for (int i = 0; i < d; i++) {
			int temp = (int)(Math.pow(10, i + 1) - Math.pow(10, i)) * (i + 1);
			result += temp;
		}
		int temp = (int)(N - Math.pow(10, d) + 1) * (d + 1);
		result += temp;

		System.out.println(result);
	}
}
