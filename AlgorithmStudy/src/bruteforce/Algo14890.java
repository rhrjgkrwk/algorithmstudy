package bruteforce;

import java.util.Scanner;

public class Algo14890 {
	public static Scanner sc;
	public static int N;
	public static int L;
	public static int[][] map;

	static {
		sc = new Scanner(System.in);
	}

	public static void main(String[] args) {
		N = sc.nextInt();
		L = sc.nextInt();
		map = new int[N][N];
		int result = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < map.length; i++) {
			if (dfs(0, i, 0, 1)) {
				result++;
			}
			if (dfs(1, i, 0, 1)) {
				result++;
			}
		}
		System.out.println(result);
	}

	public static boolean dfs(int dir, int fixed, int now, int count) { // 가로 0 - 세로 1.
		if (now == N-1) {
			return true;
		}
		int next = now + 1;

		if (dir == 0) { // 가로 탐색 start
			if (map[fixed][now] == map[fixed][next]) { // next == now
				count++;
				return dfs(dir, fixed, next, count);
			} else if (map[fixed][now] > map[fixed][next]) { // when the next is lower than now.
				if (map[fixed][now] - map[fixed][next] != 1) {
					return false;
				}
				count = 1;
				while (count != L) {
					if (next + 1 >= N || map[fixed][next] != map[fixed][next + 1]) {
						return false;
					}
					else {
						next++;
						count++;
					}
				}
				return dfs(dir, fixed, next, 0);
			} else { // when the next is higher than now.
				if (map[fixed][now] - map[fixed][next] != -1) {
					return false;
				}
				if (count >= L) {
					count = 1;
					return dfs(dir, fixed, next, count);
				} else {
					return false;
				}
			}
		} // 가로탐색 end.

		else { // 세로 탐색 start
			if (map[now][fixed] == map[next][fixed]) {
				count++;
				return dfs(dir, fixed, next, count);
			} else if (map[now][fixed] > map[next][fixed]) {
				if (map[now][fixed] - map[next][fixed] != 1) {
					return false;
				}
				count = 1;
				while (count != L) {
					if (next + 1 >= N || map[next][fixed] != map[next + 1][fixed]) {
						return false;
					}
					else{
						next++;
						count++;
					}
				}
				return dfs(dir, fixed, next, 0);
			} else {
				if (map[now][fixed] - map[next][fixed] != -1) {
					return false;
				}
				if (count >= L) {
					count = 1;
					return dfs(dir, fixed, next, count);
				} else {
					return false;
				}
			}
		} // 세로 탐색 end
	}
}
