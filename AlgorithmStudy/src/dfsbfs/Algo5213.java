package dfsbfs;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Algo5213 {
	public static Scanner sc = new Scanner(System.in);
	public static ArrayList<Integer> minimumWay = new ArrayList<>();
	public static int minimumDistance = Integer.MAX_VALUE;
	public static int N;
	
	public static int[] dist;
	public static int[][] tiles;
	public static boolean[][] visit;
	
	public static int[] dx = { 0, 0, 1};
	public static int[] dy = { 1, -1, 0 };

	public static int getTileNumber(int x, int y) {
		int tileNumber = 0;
		if (x > 0) {
			for (int i = 0; i < x; i++) {
				if (i % 2 == 0) {
					tileNumber += N;
				} else {
					tileNumber += N - 1;
				}
			}
		}

		if (x % 2 == 0) {
			tileNumber += (y + 2) / 2;
		} else {
			tileNumber += (y + 1) / 2;
		}

		return tileNumber;
	}

	public static void dfs(Deque<Integer> way, int x, int y) {
		if (getTileNumber(x, y) == getTileNumber(tiles.length-1, 2 * N - 2)) {
			if (minimumDistance > way.size()) {
				minimumWay = new ArrayList<>(way);
				minimumDistance = way.size();
			}
			return;
		}

		if (minimumDistance <= way.size()) {
			return;
		}

		for (int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < N && ny >= 0 && ny < N * 2 && !visit[nx][ny]) {
				int t1 = getTileNumber(x, y);
				int t2 = getTileNumber(nx, ny);
				if (t1 == t2) { // 타일번호가 같은 것끼리는 걍 움직인다.
					visit[nx][ny] = true;
					dfs(way, nx, ny);
					visit[nx][ny] = false;
				} else {
					if (dist[t2] <= way.size()+1) {
						return;
					}
					if (tiles[x][y] == tiles[nx][ny]) {
						dist[t2] = way.size() + 1;
						visit[nx][ny] = true;
						way.addLast(t2);
						dfs(way, nx, ny);
						way.removeLast();
						visit[nx][ny] = false;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		N = sc.nextInt();
		tiles = new int[N][N * 2];
		visit = new boolean[N][N * 2];
		dist = new int[getTileNumber(tiles.length-1, N * 2 - 2) + 1];
		
		for (int i = 1; i < dist.length; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		for (int i = 0; i < N; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < N * 2; j++) {
					tiles[i][j] = sc.nextInt();
				}
			} else {
				for (int j = 1; j < N * 2 - 1; j++) {
					tiles[i][j] = sc.nextInt();
				}
			}
		}

		Deque<Integer> temp = new LinkedList<>();
		temp.addLast(getTileNumber(0, 0));
		dfs(temp, 0, 0);

		System.out.println(minimumDistance == Integer.MAX_VALUE ? -1 : minimumDistance);
		for (Integer integer : minimumWay) {
			System.out.print(integer + " ");
		}
	}
}
