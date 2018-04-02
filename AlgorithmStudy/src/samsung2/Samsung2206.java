package samsung2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;


class P2206{
	int x;
	int y;
	int count;
	int left;
	public P2206(int x, int y, int count, int left) {
		super();
		this.x = x;
		this.y = y;
		this.count = count;
		this.left = left;
	}
}

public class Samsung2206 {
	public static int N;
	public static int M;
	public static int map[][];
	public static int visit[][][];
	public static int dx[] = {0,0,1,-1};
	public static int dy[] = {1,-1,0,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new int[2][N][M];
		for (int i = 0; i < N; i++) {
			String tmp = sc.nextLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = (int)(tmp.charAt(j)-'0');
			}
		}
		System.out.println(BFS());
		
		sc.close();
	}
	public static int BFS(){
		Queue<P2206> q = new LinkedList<>();
		q.add(new P2206(0, 0, 1, 1));
		while (!q.isEmpty()) {
			P2206 now = q.poll();
			if (now.x == N-1 && now.y == M-1) {
				return now.count;
			}
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (nx>=0 && nx<N && ny>=0 && ny<M && visit[now.left][nx][ny]==0) {
					if (map[nx][ny]==1 && now.left>0) { //Î≤ΩÏù¥Í≥? Í∏∞ÌöåÍ∞? ?Ç®?ïó Í≤ΩÏö∞
						visit[now.left-1][nx][ny] = now.count+1;
						q.add(new P2206(nx, ny, now.count+1, now.left-1));
					}
					else if(map[nx][ny]==0 && visit[now.left][nx][ny]==0){
						visit[now.left][nx][ny] = now.count+1;
						q.add(new P2206(nx, ny, now.count+1, now.left));
					}
				}
			}
		}
		return -1;
	}
}
