package nhn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

class Point {
	char nation;
	int x;
	int y;

	public Point() {
		// TODO Auto-generated constructor stub
	}

	public Point(char nation, int x, int y) {
		super();
		this.nation = nation;
		this.x = x;
		this.y = y;
	}

}

public class Q4 {
	public static Scanner sc = new Scanner(System.in);
	public static int[][] map;
	public static int[][] result;
	public static int[][] count;
	public static int[][] visit;
	public static int N;
	public static final int dx[] = { 0, 1, 0, -1 }; // 0 : 우, 1: 상, 2: 좌, 3 : 하..
	public static final int dy[] = { 1, 0, -1, 0 };

	public static final int canGo[][] = {
			// 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
			{ 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0 }, // 0 우.
			{ 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0 }, // 1 상.
			{ 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, // 2 좌.
			{ 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0 } // 3 하.
	};

	public static void main(String[] args) {
		Queue<Point> q = new LinkedList<>();
		N = Integer.parseInt(sc.nextLine());
		map = new int[N][N];
		result = new int[N][N];
		count = new int[N][N];
		visit = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
			for (int j = 0; j < N; j++) {
				String temp = st.nextToken();

				if (temp.charAt(0) >= 'A' && temp.charAt(0) <= 'Z') {
					q.add(new Point(temp.charAt(0), i, j));
					visit[i][j] = (int) temp.charAt(0);
					count[i][j] = 1;
					map[i][j] = (int) temp.charAt(0);
				} else {
					map[i][j] = Integer.parseInt(temp);
				}
			}
		}

		//
		// for (int i = 0; i < map.length; i++) {
		// for (int j = 0; j < map[i].length; j++) {
		// if (map[i][j] >= 'A' && map[i][j] <= 'Z') {
		// System.out.print((char) map[i][j] + " ");
		// }
		// else
		// System.out.print(map[i][j] + " ");
		// }
		// System.out.println();
		// }

		
		while (!q.isEmpty()) {
			boolean flag = false;
			Point now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] >= 0 && map[nx][ny] < 16
						&& canGo[i][map[nx][ny]] == 1) {
					if (count[nx][ny] == 0 && visit[nx][ny] == 0) {
						visit[nx][ny] = (int) now.nation;
						count[nx][ny] = count[now.x][now.y] + 1;
						q.add(new Point(now.nation, nx, ny));
					} else if (visit[nx][ny] != visit[now.x][now.y] && count[nx][ny] == count[now.x][now.y] + 1) {
						visit[nx][ny] = 0;
						count[nx][ny] = -1;
					}
				}
			}
		}

		
//		
//		for (int i = 0; i < visit.length; i++) {
//			for (int j = 0; j < visit[i].length; j++) {
//				if (visit[i][j] == 0) {
//					HashMap<Character, Integer> adjacentCount = new HashMap<>();
//					for (int k = 0; k < 4; k++) {
//						
//					}
//				}
//			}
//		}
		
		
		
		
		
		
		
		
		for (int i = 0; i < count.length; i++) {
			for (int j = 0; j < count[i].length; j++) {
				System.out.print(count[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();

		for (int i = 0; i < visit.length; i++) {
			for (int j = 0; j < visit[i].length; j++) {
				System.out.print(visit[i][j] + " ");
			}
			System.out.println();
		}
	}
}
