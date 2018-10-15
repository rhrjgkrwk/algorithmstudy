package dfsbfs;

import java.util.Scanner;

public class Algo1107 {
	public static boolean[] buttons = { true, true, true, true, true, true, true, true, true, true };
	public static Scanner sc = new Scanner(System.in);
	public static int N, M;

	public static boolean make(int num) {
		String str = String.valueOf(num);
		for (int i = 0; i < str.length(); i++) {
			if (!buttons[str.charAt(i) - '0']) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		N = sc.nextInt();
		M = sc.nextInt();

		for (int i = 0; i < M; i++) {
			int num = sc.nextInt();
			buttons[num] = false;
		}

		int closestNumber = 100;
		int prev = N;
		int next = N;
		int res = Integer.MAX_VALUE;
		if (M < 10) {
			while (true) {
				if (make(prev)) {
					closestNumber = prev;
					break;
				}
				if (make(next)) {
					closestNumber = next;
					break;
				}
				if (prev <= 0 && next >= 10000000) {
					closestNumber = 100;
					break;
				}

				if (prev > 0)
					prev--;
				if (next <= 9999999)
					next++;
			}
			res = String.valueOf(closestNumber).length() + Math.abs(N - closestNumber);
		}
		if (Math.abs(N - 100) < res) {
			res = Math.abs(N - 100);
		}
		System.out.println(res);
	}
}
