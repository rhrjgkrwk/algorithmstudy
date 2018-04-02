package samsung2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Log {
	int x;
	int y;
	int dir;
	int count;

	public Log(int x, int y, int dir, int count) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.count = count;
	}
}

public class Samsung1938_2 {
	public static int N;
	public static int dx[] = { -1, 0, 1, 0 };
	public static int dy[] = { 0, 1, 0, -1 }; // ?��?��??�? ?��?��?��?��

	public static Log startingPoint = null;
	public static Log destination = null;
	public static int visit[][][]; // 0 = ?��?��무�? 0방향?��?��
	public static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visit = new int[2][N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		//?��?��?�� ?��착점?�� 찾아보자. 처음 발견?�� ?�� 기�? ?��른쪽?���? ?��?���? - ?��?���? ?��?���? |
		for (int i = 0; i <N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j]=='B') { //출발 
					for (int k = 1; k <= 2; k++) {
						int ni = i + dx[k];
						int nj = j + dy[k];
						if (ni<N && nj<N && map[ni][nj]=='B' && startingPoint==null) {
							startingPoint = new Log(ni, nj, k==1?1:0, 0);
						}
					}
				}
				if (map[i][j]=='E') { //?���? 
					for (int k = 1; k <= 2; k++) {
						int ni = i + dx[k];
						int nj = j + dy[k];
						if (ni<N && nj<N && map[ni][nj]=='E' && destination==null) {
							destination = new Log(ni, nj, k==1?1:0, 0);
						}
					}
				}
			}
		}
		
		
		
		System.out.println(BFS());
	}

	public static int BFS() {
		Queue<Log> q = new LinkedList<>();
		q.add(startingPoint);
		while (!q.isEmpty()) {
			Log now = q.poll();
			
//			System.out.println("=============");
//			System.out.println(now.dir==1?'-':'|'+" "+now.count);
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					if (i==now.x && j==now.y) System.out.print("N");
//					else System.out.print(map[i][j]);
//				}System.out.println();
//			}
			
			//목적�? ?���? ?��?���? 
			if (now.x == destination.x && now.y == destination.y ) {
				if (now.dir == destination.dir) return now.count;
				else {
					if (canIRotateTheLog(now)) {
						return now.count+1;
					}
				}
			}

			// ?��?�� ?���? ?��?�� ?���? �?�?
			if (canIRotateTheLog(now)) {
				int ndir = (now.dir + 1) % 2;
				if (visit[ndir][now.x][now.y] == 0) {
					visit[ndir][now.x][now.y] = now.count+1;
					q.add(new Log(now.x, now.y, ndir, now.count + 1));
				}
			}

			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (canIMoveTheLog(now, i) && visit[now.dir][nx][ny] == 0) {
					visit[now.dir][nx][ny] = now.count+1;
					q.add(new Log(nx, ny, now.dir, now.count + 1));
				}
			}
		}
		return 0;
	}

	public static boolean canIRotateTheLog(Log now) {
		for (int i = now.x - 1; i <= now.x + 1; i++) {
			for (int j = now.y - 1; j <= now.y + 1; j++) {
				if (i < 0 || i >= N || j < 0 || j >= N || map[i][j] == '1') {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean canIMoveTheLog(Log now, int direction) { // ?��기ㅣ?�� direction?? ?��?��?��?�� ?��?�� ?��?��.
		// status of the log
		if (now.dir == 0) { // log dir : |
			if (direction == 0) {
				if (now.x - 2 < 0 || map[now.x - 2][now.y] == '1') {
					return false;
				}
			} else if (direction == 1) {
				if (now.y + 1 < N) {
					for (int i = now.x - 1; i <= now.x + 1; i++) {
						if (map[i][now.y + 1] == '1') {
							return false;
						}
					}
				} else
					return false;
			} else if (direction == 2) {
				if (now.x + 2 >= N || map[now.x + 2][now.y] == '1') {
					return false;
				}
			} else if (direction == 3) {
				if (now.y - 1 >= 0) {
					for (int i = now.x - 1; i <= now.x + 1; i++) {
						if (map[i][now.y - 1] == '1') {
							return false;
						}
					}
				} else
					return false;
			}
		}

		else { // log dir : -
			if (direction == 0) {
				if (now.x - 1 >= 0) {
					for (int i = now.y - 1; i <= now.y + 1; i++) {
						if (map[now.x - 1][i] == '1') {
							return false;
						}
					}
				} else
					return false;
			} else if (direction == 1) {
				if (now.y + 2 >= N || map[now.x][now.y + 2] == '1') {
					return false;
				}
			} else if (direction == 2) {
				if (now.x + 1 < N) {
					for (int i = now.y - 1; i <= now.y + 1; i++) {
						if (map[now.x + 1][i] == '1') {
							return false;
						}
					}
				} else
					return false;
			} else if (direction == 3) {
				if (now.y - 2 < 0 || map[now.x][now.y - 2] == '1') {
					return false;
				}
			}
		}
		return true;
	}
}


