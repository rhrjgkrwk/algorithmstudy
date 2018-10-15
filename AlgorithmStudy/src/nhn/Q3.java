package nhn;

import java.util.Scanner;

public class Q3 {
	public static int coins[];
	public static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		coins = new int[N];
		for (int i = 0; i < N; i++) {
			coins[i] = sc.nextInt();
		}
		int ans = dfs(0, 0, 0);
		System.out.println(ans);
	}

	public static int dfs(int coin, int benefit, int day) {
		if (day == coins.length) {
			return benefit;
		}

		return Math.max(dfs(coin + 1, benefit - coins[day], day + 1),
				Math.max(dfs(coin, benefit, day + 1), 
						dfs(0, coin * coins[day] - 1 + benefit, day + 1)));
	}
}
