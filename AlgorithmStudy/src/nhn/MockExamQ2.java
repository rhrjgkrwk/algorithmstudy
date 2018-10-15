package nhn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

class P {
	int x;
	int y;

	public P(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

public class MockExamQ2 {
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {1,0,-1,0};
	public static int[][] map;
	public static boolean[][] visit;
	public static int n;
	
	public static void main(String[] args) {
		ArrayList<Integer> areas = new ArrayList<>();
		Scanner sc = new Scanner(System.in);

		n = Integer.parseInt(sc.nextLine());
		map = new int[n][n];
		visit = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// BFS
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1 && !visit[i][j]) {
					areas.add(bfs(new P(i, j)));
				}
			}
		}
		
		System.out.println(areas.size());
		Collections.sort(areas);
		for (Integer area : areas) {
			System.out.print(area + " ");
		}
		
		sc.close();
	}
	public static int bfs(P p) {
		visit[p.x][p.y] = true;
		int area = 0;
		
		Queue<P> q = new LinkedList<>();
		q.add(p);
		while (!q.isEmpty()) {
			P now = q.poll();
			area++;
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == 1 && !visit[nx][ny]) {
					visit[nx][ny] = true;
					q.add(new P(nx, ny));
				}
			}
		}
		
		return area;
	}
}

