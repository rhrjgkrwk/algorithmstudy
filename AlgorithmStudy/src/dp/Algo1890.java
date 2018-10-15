package dp;

import java.util.Scanner;

public class Algo1890 {
	public static final int[] dx = { 0, 1 };
	public static final int[] dy = { 1, 0 };

	public static Scanner sc = new Scanner(System.in);
	public static int N;
	public static int[][] map;
	public static long[][] memo;
	public static int count = 0;

	public static void main(String[] args) {
		N = sc.nextInt();
		map = new int[N][N];
		memo = new long[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		// dp
		memo[0][0] = 1;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0)
					continue;
				if (map[i][j] + i < N)
					memo[map[i][j] + i][j] += memo[i][j];

				if (map[i][j] + j < N)
					memo[i][map[i][j] + j] += memo[i][j];

			}
		}
		System.out.println(memo[N - 1][N - 1]);
	}

	public static void dfs(int x, int y) {
		if (x == N - 1 && y == N - 1) {
			count++;
			return;
		}

		if (map[x][y] == 0) {
			return;
		}

		for (int i = 0; i < 2; i++) {
			int nx = x + dx[i] * map[x][y];
			int ny = y + dy[i] * map[x][y];
			if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
				dfs(nx, ny);
			}
		}

	}
}

/*
 * N×N 게임판에 수가 적혀져 있다. 이 게임의 목표는 가장 왼쪽 위 칸에서 가장 오른쪽 아래 칸으로 규칙에 맞게 점프를 해서 가는 것이다.
 * 
 * 각 칸에 적혀있는 수는 현재 칸에서 갈 수 있는 거리를 의미한다. 반드시 오른쪽이나 아래쪽으로만 이동해야 한다. 0은 더 이상 진행을 막는
 * 종착점이며, 항상 현재 칸에 적혀있는 수만큼 오른쪽이나 아래로 가야 한다. 한 번 점프를 할 때, 방향을 바꾸면 안된다. 즉, 한 칸에서
 * 오른쪽으로 점프를 하거나, 아래로 점프를 하는 두 경우만 존재한다.
 * 
 * 가장 왼쪽 위 칸에서 가장 오른쪽 아래 칸으로 규칙에 맞게 이동할 수 있는 경로의 개수를 구하는 프로그램을 작성하시오.
 * 
 * 입력 첫째 줄에 게임 판의 크기 N (4 ≤ N ≤ 100)이 주어진다. 그 다음 N개 줄에는 각 칸에 적혀져 있는 수가 N개씩 주어진다.
 * 칸에 적혀있는 수는 0보다 크거나 같고, 9보다 작거나 같은 정수이며, 가장 오른쪽 아래 칸에는 항상 0이 주어진다.
 * 
 * 출력 가장 왼쪽 위 칸에서 가장 오른쪽 아래 칸으로 문제의 규칙에 맞게 갈 수 있는 경로의 개수를 출력한다. 경로의 개수는 263-1보다
 * 작거나 같다.
 * 
 * 예제 입력 1 4 2 3 3 1 1 2 1 3 1 2 3 1 3 1 1 0 예제 출력 1 3
 */
