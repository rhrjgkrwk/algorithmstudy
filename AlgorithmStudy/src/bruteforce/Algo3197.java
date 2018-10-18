package bruteforce;

import java.util.Scanner;
import java.util.StringTokenizer;

class P3197 {
	int x;
	int y;

	public P3197() {

	}

	public P3197(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public boolean equals(P3197 p) {
		if (p.x == this.x && p.y == this.y) {
			return true;
		}
		return false;
	}
}

public class Algo3197 {
	public static int[] dx = { 0, 1, 0, -1 };
	public static int[] dy = { 1, 0, -1, 0 };
	public static Scanner sc = new Scanner(System.in);

	public static int[][] map;
	public static boolean[][] visit;
	public static int R, C;

	public static boolean isConnected(int x, int y, P3197 swan2) { // 1 --> 2
		visit[x][y] = true;

		if (x == swan2.x && y == swan2.y) {
			return true;
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && ny >= 0 && nx < R && ny < C && map[nx][ny] != -2 && !visit[nx][ny]) {
				if(isConnected(nx, ny, swan2)) return true;
			}
		}
		return false;
	}

	public static void meltingIce(int day) {
		boolean[][] check = new boolean[R][C];

		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[x].length; y++) {
				if (map[x][y] == -2) {
					for (int i = 0; i < 4; i++) {
						int nx = x + dx[i];
						int ny = y + dy[i];
						if (nx >= 0 && ny >= 0 && nx < R && ny < C && (map[nx][ny] == 0 || map[nx][ny] == -1)) {
							check[x][y] = true;
							break;
						}
					}
				}
			}
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (check[i][j]) {
					map[i][j] = 0;
				}
			}
		}

		
	}

	public static void main(String[] args) {
		P3197 swan1 = null;
		P3197 swan2 = null;
		StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R][C];

		for (int i = 0; i < map.length; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < str.length(); j++) {
				char c = str.charAt(j);
				if (c == '.') { // water
					map[i][j] = 0;
				} else if (c == 'L') { // swan
					map[i][j] = -1;
					if (swan1 == null) {
						swan1 = new P3197(i, j);
					} else {
						swan2 = new P3197(i, j);
					}
				} else {
					map[i][j] = -2;
				}
			}
		}

		visit = new boolean[R][C];
		if (isConnected(swan1.x, swan1.y, swan2)) {
			System.out.println(0);
			return;
		}

		for (int day = 1;; day++) {
			meltingIce(day);
			visit = new boolean[R][C];
			if (isConnected(swan1.x, swan1.y, swan2)) {
				System.out.println(day);
				return;
			}
		}
	}
}
