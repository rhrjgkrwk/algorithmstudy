package dp;

import java.util.Scanner;

public class Algo11048 {
	public static Scanner sc = new Scanner(System.in);
	public static int[][] map;
	public static int[][] memo;
	public static int N, M;

	public static void main(String[] args) {
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		memo = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		memo[0][0] = map[0][0];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int t1 = i > 0 && j > 0 ? memo[i - 1][j - 1] : 0;
				int t2 = i > 0 ? memo[i - 1][j] : 0;
				int t3 = j > 0 ? memo[i][j - 1] : 0;
				memo[i][j] = Math.max(t1, Math.max(t2, t3)) + map[i][j];
			}
		}
		System.out.println(memo[N-1][M-1]);
	}
}
