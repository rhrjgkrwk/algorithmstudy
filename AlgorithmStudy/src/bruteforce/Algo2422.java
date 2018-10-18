package bruteforce;

import java.util.Scanner;

public class Algo2422 {
	public static Scanner sc = new Scanner(System.in);
	public static int N, M;
	public static boolean[][] map = new boolean[201][201];
	public static void main(String[] args) {
		N = sc.nextInt();
		M = sc.nextInt();
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b] = true;
			map[b][a] = true;
		}
		
		int result = 0;
		
		for (int i = 1; i <= N-2; i++) {
			for (int j = i+1; j <= N-1; j++) {
				for (int k = j+1; k <= N; k++) {
					if (!map[i][j] && !map[i][k] && !map[j][k]) {
						result++;
					}
				}
			}
		}
		System.out.println(result);
	}
}
