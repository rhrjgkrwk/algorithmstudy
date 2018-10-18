package bruteforce;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class P14502_2 {
	int x;
	int y;
	public P14502_2(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

public class Algo14502_2 {
	public static final int VIRUS = 2;
	public static final int WALL = 1;
	public static final int BLANK = 0;
	
	public static final int[] dx = { 0, 1, 0, -1 };
	public static final int[] dy = { 1, 0, -1, 0 };
	
	public static Scanner sc = new Scanner(System.in);
	
	public static ArrayList<P14502_2> blanks = new ArrayList<>();
	public static ArrayList<P14502_2> viruses = new ArrayList<>();
	
	public static int N, M;
	public static int[][] map;
	
	public static int safeArea() {
		int result = 0;
		boolean[][] visit = new boolean[N][M];
		Queue<P14502_2> q = new LinkedList<>();
		//복사.
		for (P14502_2 virus : viruses) {
			q.add(new P14502_2(virus.x, virus.y));
			visit[virus.x][virus.y] = true;
		}
		
		while (!q.isEmpty()) {
			P14502_2 now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < M && !visit[nx][ny] && map[nx][ny] == BLANK) {
					visit[nx][ny] = true;
					q.add(new P14502_2(nx, ny));
				}
			}
		}
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (!visit[i][j] && map[i][j] == 0) {
					result++;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int res = 0;
		
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int type = sc.nextInt();
				if (type == 0) {
					blanks.add(new P14502_2(i, j));
				} 
				else if (type == 2) {
					viruses.add(new P14502_2(i, j));
				} 
				map[i][j] = type;
			}
		}
		
		for (int i = 0; i < blanks.size() - 2; i++) {
			for (int j = i + 1; j < blanks.size() - 1; j++) {
				for (int k = j + 1; k < blanks.size(); k++) {
					P14502_2 a = blanks.get(i);
					P14502_2 b = blanks.get(j);
					P14502_2 c = blanks.get(k);
					map[a.x][a.y] = WALL;
					map[b.x][b.y] = WALL;
					map[c.x][c.y] = WALL;
					int temp = safeArea();
					res = temp > res ? temp : res;
					map[a.x][a.y] = BLANK;
					map[b.x][b.y] = BLANK;
					map[c.x][c.y] = BLANK;
				}
			}
		}
		System.out.println(res);
	}
}
