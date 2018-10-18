package bruteforce;

import java.util.Scanner;

public class Algo6064 {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int testCase = sc.nextInt();
		for (int i = 0; i < testCase; i++) {
			int M = sc.nextInt();
			int N = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();

			boolean flag = false;
			for (int day = x; day < M * N; day += M) {
				int temp = day % N == 0 ? N : day % N;
				if (temp == y) {
					flag = true;
					System.out.println(day);
					break;
				}
			}

			if (!flag)
				System.out.println(-1);
		}

	}
}
