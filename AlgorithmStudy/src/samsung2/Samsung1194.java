package samsung2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class P1194{
	int x;
	int y;
	int dist;
	String key = "";
	public P1194(int x, int y, String key, int dist) {
		super();
		this.x = x;
		this.y = y;
		this.key = key;
		this.dist = dist;
	}
}

public class Samsung1194 {
	public static char[][] map; // 방문한 곳을 벽으로 바꾸어버리자.
	public static int[][] visit; // 방문한 곳을 벽으로 바꾸어버리자.
	
	public static int N, M; // 가로세로
	public static P1194 startingPos;
	public static P1194 destination;
	// dx/dy
	public static int dy[] = {0,1,0,-1}; 
	public static int dx[] = {-1,0,1,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visit = new int[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (map[i][j] == '0') { //시작점이면
					startingPos = new P1194(i, j, "", 0);
				}
				if (map[i][j] == '1') { //도착점이면
					destination = new P1194(i, j, "", 0);
				}
			}
		}
		System.out.println(BFS());
	}
	public static int BFS(){
		Queue<P1194> q = new LinkedList<>();
		q.add(startingPos);
		while (!q.isEmpty()) {
			P1194 now = q.poll();
			//지나온 길은 벽으로 만든다. -X- 
			//열쇠를 먹고 문을 다시 열수도 있으므로 방문한 곳을 다시 방문할 수 있도록해야된다. 
			//고로 같은 통로를 최대 2번까지 방문할 수 있도록한다.
			System.out.println("----------");
			System.out.println(now.x + " " + now.y + " " + now.dist);
			System.out.println(now.key);
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (now.x == i && now.y == j) System.out.print("N");
					else System.out.print(map[i][j]);
				}System.out.println(); 
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					System.out.print(visit[i][j]+" ");
				}System.out.println(); 
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] != '#') {
					if (map[nx][ny] == '.' || map[nx][ny] == '0') {
						if (now.key.length()==0 && visit[nx][ny]>0) {
							continue;
						}
						visit[nx][ny]+=1;
						q.add(new P1194(nx, ny, now.key, now.dist+1));
					} 
					else if (map[nx][ny]>='A' && map[nx][ny] <='Z') { //문짝
						if (now.key.contains(String.valueOf(map[nx][ny]).toLowerCase())) { //키 있니
							visit[nx][ny]+=1;
							q.add(new P1194(nx, ny, now.key, now.dist+1));
						} 
						else { //없니
							continue;
						}
					} 
					else if (map[nx][ny]>='a' && map[nx][ny] <='z') { //열쇠
						visit[nx][ny]+=1;
						String tmp = now.key;
						if (!now.key.contains(String.valueOf(map[nx][ny]).toLowerCase()))
							tmp = now.key+map[nx][ny];
						q.add(new P1194(nx, ny, tmp, now.dist+1));
					}
					else if (map[nx][ny] == '1') {
						return now.dist+1;
					}
				}
			}
		}
		return -1;
	}
}

/*
2 7
1F.f..0
A.....a

4 7
1F....f
A.....a
#....##
....0..

4 7
1FD...f
AC....a
#.....#
cd....0

2 7
1F.f#.0
A...#.a
*/