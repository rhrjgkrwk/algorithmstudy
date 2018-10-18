package simulation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

class P2933 {
	int x;
	int y;

	public P2933(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

public class Algo2933 {
	public static final int[] dx = { 0, 1, 0, -1 };
	public static final int[] dy = { 1, 0, -1, 0 };

	public static int N, M, C;
	public static char[][] cave;

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cave = new char[N][M];
		for (int i = 0; i < N; i++) {
			char[] ch = sc.nextLine().toCharArray();
			for (int j = 0; j < M; j++) {
				cave[i][j] = ch[j];
			}
		}
		C = Integer.parseInt(sc.nextLine());
		st = new StringTokenizer(sc.nextLine(), " ");
		for (int i = 0; i < C; i++) {
			int row = N - Integer.parseInt(st.nextToken());
			if (i % 2 == 0) {
				throwStick(0, row);
			} else {
				throwStick(1, row);
			}
		}
		
		for (int i = 0; i < cave.length; i++) {
			for (int j = 0; j < cave[i].length; j++) {
				System.out.print(cave[i][j]);
			}System.out.println();
		}
	}

	public static void throwStick(int dir, int row) { // 0 : --> & 1 : <--
		int col = -1;
		if (dir == 0) {
			for (int i = 0; i < cave[row].length; i++) {
				if (cave[row][i] == 'x') {
					cave[row][i] = '.';
					col = i;
					break;
				}
			}

			if (row > 0 && col != -1 && cave[row - 1][col] == 'x' && !isItOnTheFloor(row - 1, col)) {
				goDown(row - 1, col);
			}

		} else {
			for (int i = cave[row].length - 1; i >= 0; i--) {
				if (cave[row][i] == 'x') {
					cave[row][i] = '.';
					col = i;
					break;
				}
			}

			if (row > 0 && col != -1 && cave[row - 1][col] == 'x' && !isItOnTheFloor(row - 1, col)) {
				goDown(row - 1, col);
			}
		}
	}

	public static void goDown(int x, int y) {
		boolean[][] visit = new boolean[N][M];
		Queue<P2933> q = new LinkedList<>();
		ArrayList<P2933> list = new ArrayList<>();
		list.add(new P2933(x, y));
		q.add(new P2933(x, y));
		visit[x][y] = true;
		while (!q.isEmpty()) {
			P2933 now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < M && !visit[nx][ny] && cave[nx][ny] == 'x') {
					visit[nx][ny] = true;
					q.add(new P2933(nx, ny));
					list.add(new P2933(nx, ny));
				}
			}
		}

		for (P2933 p : list) {
			cave[p.x][p.y] = '.';
			cave[p.x + 1][p.y] = 'x';
		}
	}

	public static boolean isItOnTheFloor(int x, int y) {
		boolean[][] visit = new boolean[N][M];
		Queue<P2933> q = new LinkedList<>();
		q.add(new P2933(x, y));
		visit[x][y] = true;
		while (!q.isEmpty()) {
			P2933 now = q.poll();
			if (now.x == 0) {
				return true;
			}

			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < M && !visit[nx][ny] && cave[nx][ny] == 'x') {
					visit[nx][ny] = true;
					q.add(new P2933(nx, ny));
				}
			}
		}
		return false;
	}
}
