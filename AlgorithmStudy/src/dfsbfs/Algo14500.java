package dfsbfs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Algo14500 {
	public static Scanner sc = new Scanner(System.in);
	public static int[] dx = { 0, 1, 0, -1 };
	public static int[] dy = { 1, 0, -1, 0 };
	public static int[][] map;
	public static boolean[][] visit;
	public static int N, M;
	public static int max = 0;

	public static void dfs(int x, int y, int size, int sum) {
		if (size == 4) {
			if (max < sum) {
				max = sum;
			}
			return;
		}
		visit[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < N && 0 <= ny && ny < M && !visit[nx][ny]) {
				dfs(nx, ny, size + 1, sum + map[nx][ny]);
			}
		}
		visit[x][y] = false;
	}

	public static void ex(int x, int y) {
		ArrayList<Integer> tmp = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < N && 0 <= ny && ny < M) {
				tmp.add(map[nx][ny]);
			}
		}
		tmp.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});

		int sum = map[x][y];
		if (tmp.size() >= 3) {
			for (int i = 0; i < 3; i++) {
				sum += tmp.get(i);
			}
		}
		if (max < sum) {
			max = sum;
		}
	}

	public static void main(String[] args) {
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dfs(i, j, 1, map[i][j]);
				ex(i, j);
			}
		}
		System.out.println(max);
	}
}
