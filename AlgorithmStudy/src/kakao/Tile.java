package kakao;

import java.util.Scanner;

public class Tile {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(new Tile().solution(sc.nextInt()));
	}

	public int solution(int n) {
		int dp[] = new int[600001];
		dp[0] = 1;
		dp[1] = 1;
		if (n > 1) {
			for (int i = 2; i <= n; i++) {
				dp[i] = dp[i - 1] + dp[i - 2];
			}
		}
		int answer = dp[n];
		return answer % 1000000007;
	}
}
