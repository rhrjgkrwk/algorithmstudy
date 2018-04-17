package samsung2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

class PointT {
	int x, y, Time;

	public PointT(int x, int y, int Time) {
		super();
		this.x = x;
		this.y = y;
		this.Time = Time;
	}

}

public class Tomato {
	static final int RIPEN = 1, UNRIPEN = 0, WALL = -1;
	static int M, N; // M:Column, N: Row
	static int[][] map;
	static int DAYS[][];
	static ArrayList<PointT> ripenList;
	static LinkedList<PointT> tomaQue;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 }; // U D L R

	static void bfs(ArrayList<PointT> list) { // 처음Time 0
		tomaQue.addAll(list); //시작위치를 전부 큐에 넣고 시작한다. 그래야 여러지점에서 동시에 익으니깐
		while (!tomaQue.isEmpty()) {
			int r = tomaQue.peek().x;
			int c = tomaQue.poll().y;
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if  (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) { //ripenChk 메서드를 삭제했다.
					tomaQue.add(new PointT(nr, nc, 1)); //여기서 time은 의미가 없다.
					DAYS[nr][nc] = DAYS[r][c] + 1; //날짜 체크
					map[nr][nc]=1; //방문한 곳을 1(익음)로 표시한다.
				}
			}
		} // while end
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M]; //방문한 곳은 visit 대신 map에 체크한다. (방문한 곳을 익었다고 표시(1))
		DAYS = new int[N][M];
		ripenList = new ArrayList<>();
		tomaQue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == RIPEN)
					ripenList.add(new PointT(i, j, 0));
			}
		}
		bfs(ripenList); //시작 당시 익어있는걸 다 큐에 넣어준다.
		
		int result = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j]==0) { //안익은 곳이 있으면 -1 출력하고 종료
					System.out.println(-1);
					return;
				}
				result = Math.max(result, DAYS[i][j]);
			}
		}
		System.out.println(result);
	}

}



























/*static boolean ripenCheck(int nr, int nc) {
	
	 * if(nr<0 || nr >=N || nc <0 || nc >=M) return false; else
	 * if(map[nr][nc] == WALL || map[nr][nc] == RIPEN || visited[nr][nc] ==
	 * true) return false;
	 * 
	 * return true;
	 
//	if (nr >= 0 && nr < N && nc >= 0 && nc < M && DAYS[nr][nc] > DAYS[r][c]+1 && map[nr][nc] == 0) {
//		return true;
//	}
//	else 
	return false;
}*/