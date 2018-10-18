package bruteforce;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

class P3184 {
	int x;
	int y;

	public P3184(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}

class Area {
	int sheep = 0;
	int wolf = 0;
}

public class Algo3184 {
	public static Scanner sc = new Scanner(System.in);
	public static ArrayList<Area> areaList = new ArrayList<>();

	public static int[] dx = { 0, 1, 0, -1 };
	public static int[] dy = { 1, 0, -1, 0 };

	public static int R, C;
	public static char[][] map;
	public static boolean[][] visit;

	public static Area bfs(P3184 start) {
		Queue<P3184> q = new LinkedList<>();
		q.add(start);
		visit[start.x][start.y] = true;
		
		Area area = new Area();
		
		while (!q.isEmpty()) {
			P3184 now = q.poll();
			if (map[now.x][now.y] == 'o') {
				area.sheep++;
			} else if (map[now.x][now.y] == 'v') {
				area.wolf++;
			}
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < R && ny < C && map[nx][ny] != '#' && !visit[nx][ny]) {
					visit[nx][ny] = true;
					q.add(new P3184(nx, ny));
				}
			}
		}
		return area;
	}

	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visit = new boolean[R][C];

		for (int i = 0; i < map.length; i++) {
			String line = sc.nextLine();
			for (int j = 0; j < line.length(); j++) {
				map[i][j] = line.charAt(j);
			}
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] != '#' && !visit[i][j]) {
					areaList.add(bfs(new P3184(i, j)));
				}
			}
		}

		int wolves = 0;
		int sheeps = 0;
		for (Area area : areaList) {
			if (area.sheep > area.wolf) {
				sheeps += area.sheep;
			} else {
				wolves += area.wolf;
			}
		}

		System.out.println(sheeps + " " + wolves);
	}
}
