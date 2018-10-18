package bruteforce;

import java.util.ArrayList;
import java.util.Scanner;

public class Algo15685 {
	public static final int[] dx = { 0, -1, 0, 1 };
	public static final int[] dy = { 1, 0, -1, 0 };
	public static Scanner sc = new Scanner(System.in);
	public static boolean[][] map = new boolean[102][102];
	public static int N;

	public static void makeDragonCurve(int y, int x, int dir, int generation) {
		ArrayList<Integer> st = new ArrayList<>();
		st.add(dir);
		//0세대.
		map[x][y] = true;
		x = x + dx[dir];
		y = y + dy[dir];
		map[x][y] = true;
		for (int i = 1; i <= generation; i++) {
			int pos = st.size()-1;
			while (pos >= 0) {
				dir = (st.get(pos--) + 1) % 4;
				x = x + dx[dir];
				y = y + dy[dir];
				map[x][y] = true;
				st.add(dir);
			}
		}
	}

	public static void main(String[] args) {
		N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			makeDragonCurve(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		int result = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1]) {
					result++;
				}
			}
		}
		System.out.println(result);
//		for (int i = 0; i < map.length; i++) {
//			for (int j = 0; j < map[i].length; j++) {
//				System.out.print(map[i][j] ? "T" : "F");
//			}System.out.println();
//		}
	}
}
