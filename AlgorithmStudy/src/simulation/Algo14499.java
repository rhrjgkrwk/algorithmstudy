package simulation;

import java.util.Scanner;

public class Algo14499 {
	public static final int H = 0, V = 1;
	public static Scanner sc = new Scanner(System.in);

	public static int[] dx = { 0, 0, -1, 1 };
	public static int[] dy = { 1, -1, 0, 0 };
	public static int[][] dice = { 
			{ 0, 0, 0, 0 }, // horizental
			{ 0, 0, 0, 0 } // vertical
	};
	public static int posH = 0, posV = 0;
	public static int x, y;
	public static int R, C;
	public static int[][] map;
	public static int commands;

	public static void moveDice(int dir, int nx, int ny) {

		if (dir == 0) { // 오른쪽으로 이동.
			posH = (4 + posH - 1) % 4;
			dice[V][posV] = dice[H][posH]; // 위.
			dice[V][(posV + 2) % 4] = dice[H][(posH + 2) % 4]; // 아래.
		} else if (dir == 1) { // 왼쪽 이동.
			posH = (posH + 1) % 4;
			dice[V][posV] = dice[H][posH]; // 위.
			dice[V][(posV + 2) % 4] = dice[H][(posH + 2) % 4]; // 아래.
		} else if (dir == 2) {
			posV = (posV + 1) % 4;
			dice[H][posH] = dice[V][posV]; // 위.
			dice[H][(posH + 2) % 4] = dice[V][(posV + 2) % 4]; // 아래.
		} else if (dir == 3) {
			posV = (4 + posV - 1) % 4;
			dice[H][posH] = dice[V][posV]; // 위.
			dice[H][(posH + 2) % 4] = dice[V][(posV + 2) % 4]; // 아래.
		}

		x = nx;
		y = ny;

		if (map[x][y] == 0) {
			map[x][y] = dice[H][(posH + 2) % 4];
		} else {
			dice[H][(posH + 2) % 4] = map[x][y];
			dice[V][(posV + 2) % 4] = map[x][y];
			map[x][y] = 0;
		}

	}

	public static void main(String[] args) {
		R = sc.nextInt();
		C = sc.nextInt();
		map = new int[R][C];
		x = sc.nextInt();
		y = sc.nextInt();
		commands = sc.nextInt();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int comm;
		for (int i = 0; i < commands; i++) {
			comm = sc.nextInt() - 1;
			int nx = x + dx[comm];
			int ny = y + dy[comm];
			if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
				moveDice(comm, nx, ny);
				System.out.println(dice[H][posH]);
			}
		}
	}
}
