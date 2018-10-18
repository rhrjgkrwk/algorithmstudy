package bruteforce;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Algo2210 {
	public static final int[] dx = { 0, 1, 0, -1 };
	public static final int[] dy = { 1, 0, -1, 0 };

	public static Scanner sc = new Scanner(System.in);
	public static Set<String> set = new HashSet<>();
	public static int[][] board = new int[5][5];

	public static void dfs(int jump, int x, int y, String str) {
		if (jump == 5) {
			set.add(str);
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5) {
				dfs(jump + 1, nx, ny, str+board[nx][ny]);
			}
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				board[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				dfs(0, i, j, ""+board[i][j]);
			}
		}

		System.out.println(set.size());
	}
}
