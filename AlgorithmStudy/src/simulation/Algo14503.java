package simulation;

import java.util.Scanner;

public class Algo14503 {
	public static Scanner sc = new Scanner(System.in);
	public static int[] dx = { -1, 0, 1, 0 };
	public static int[] dy = { 0, -1, 0, 1 };
	public static int N, M;
	public static int[][] map;
	public static int count = 0;

	public static void main(String[] args) {
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		int r = sc.nextInt();
		int c = sc.nextInt();
		int dir = sc.nextInt();

		dir = (dir == 1 || dir == 3) ? (dir + 2) % 4 : dir;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		dfs(r, c, dir);
		System.out.println(count);
	}

	public static void dfs(int x, int y, int dir) {
		if (map[x][y] == 0) {
			count++;
			map[x][y] = 2;
		}
		boolean flag = false;
		for (int i = 1; i <= 4; i++) {
			int nx = x + dx[(dir + i) % 4];
			int ny = y + dy[(dir + i) % 4];
			if (0 <= nx && nx < N && 0 <= ny && ny < M && map[nx][ny] == 0) {
				flag = true;
				dir = (dir + i) % 4;
				dfs(nx, ny, dir);
				break;
			}
		}
		if (!flag) {
			int nx = x + dx[(dir + 2) % 4];
			int ny = y + dy[(dir + 2) % 4];
			if (0 <= nx && nx < N && 0 <= ny && ny < M && map[nx][ny] != 1) {
				dfs(nx, ny, dir);
			}
		}
	}
}
