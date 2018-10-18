package bruteforce;
//감시 - cctv

import java.util.ArrayList;
import java.util.Scanner;

class CCTV {
	int no;
	int x;
	int y;
	int dir;

	public CCTV() {
	}

	public CCTV(int num, int x, int y, int dir) {
		super();
		this.no = num;
		this.x = x;
		this.y = y;
		this.dir = dir;
	}

}

public class Algo15683 {
	public static final int[] dx = {1,0,-1,0}; // 0123 상우하좌(시계방향).
	public static final int[] dy = {0,1,0,-1};

	public static final int[][][] directionManager = {
			//
			{ // 1번 CCTV가.
					{ // 0 방향으로 회전이 되었을때.
						// 0 1 2 3 방향을 감시할 수 있니???
							1, 0, 0, 0 },
					{ // 1 방향으로 회전이 되었을때.
							0, 1, 0, 0 },
					{ // 2 방향으로 회전이 되었을때.
							0, 0, 1, 0 },
					{ // 3 방향으로 회전이 되었을때.
							0, 0, 0, 1 } },
			{ // 2번 CCTV가.
					{ // 0 방향으로 회전이 되었을때.
						// 0 1 2 3 방향을 감시할 수 있니???
							1, 0, 1, 0 },
					{ // 1 방향으로 회전이 되었을때.
							0, 1, 0, 1 },
					{ // 2 방향으로 회전이 되었을때.
							1, 0, 1, 0 },
					{ // 3 방향으로 회전이 되었을때.
							0, 1, 0, 1 } },
			{ // 3번 CCTV가.
					{ // 0 방향으로 회전이 되었을때.
						// 0 1 2 3 방향을 감시할 수 있니???
							1, 1, 0, 0 },
					{ // 1 방향으로 회전이 되었을때.
							0, 1, 1, 0 },
					{ // 2 방향으로 회전이 되었을때.
							0, 0, 1, 1 },
					{ // 3 방향으로 회전이 되었을때.
							1, 0, 0, 1 } },
			{ // 4번 CCTV가.
					{ // 0 방향으로 회전이 되었을때.
						// 0 1 2 3 방향을 감시할 수 있니???
							1, 1, 0, 1 },
					{ // 1 방향으로 회전이 되었을때.
							1, 1, 1, 0 },
					{ // 2 방향으로 회전이 되었을때.
							0, 1, 1, 1 },
					{ // 3 방향으로 회전이 되었을때.
							1, 0, 1, 1 } },
			{ // 5번 CCTV가.
					{ // 0 방향으로 회전이 되었을때.
						// 0 1 2 3 방향을 감시할 수 있니???
							1, 1, 1, 1 },
					{ // 1 방향으로 회전이 되었을때.
							1, 1, 1, 1 },
					{ // 2 방향으로 회전이 되었을때.
							1, 1, 1, 1 },
					{ // 3 방향으로 회전이 되었을때.
							1, 1, 1, 1 } } };

	public static Scanner sc = new Scanner(System.in);
	public static int N;
	public static int M;
	public static int[][] originalMap;
	public static ArrayList<CCTV> cctvs = new ArrayList<>(); // cctv 번호 저장
	public static int minimumBlindSpot = Integer.MAX_VALUE;

	public static void main(String[] args) {
		N = sc.nextInt();
		M = sc.nextInt();
		originalMap = new int[N][M];
		for (int i = 0; i < originalMap.length; i++) {
			for (int j = 0; j < originalMap[i].length; j++) {
				originalMap[i][j] = sc.nextInt();
				if (originalMap[i][j] >=1 && originalMap[i][j] < 6) {
					cctvs.add(new CCTV(originalMap[i][j]-1, i, j, 0));
				}
			}
		}
		
		
		dfs(0);
		
		System.out.println(minimumBlindSpot);
		
	}

	public static void dfs(int depth) {
		if (depth == cctvs.size()) {
			int map[][] = new int[N][M];
			for (int i = 0; i < originalMap.length; i++) {
				System.arraycopy(originalMap[i], 0, map[i], 0, originalMap[i].length);
			}
			int blindSpot = getBlindSpot(map);
			minimumBlindSpot = minimumBlindSpot > blindSpot ? blindSpot : minimumBlindSpot;
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int temp = cctvs.get(depth).dir;
			cctvs.get(depth).dir = i;
			dfs(depth+1);
			cctvs.get(depth).dir = temp;
		}		
		
	}

	public static int getBlindSpot(int[][] map) {
		int blindSpot = 0;
		
		for (CCTV cctv : cctvs) {
			for (int i = 0; i < 4; i++) {
				if (directionManager[cctv.no][cctv.dir][i] == 1) {
					int nx = cctv.x + dx[i];
					int ny = cctv.y + dy[i];
					while (nx >= 0 && nx < N && ny >=0 && ny < M && map[nx][ny] != 6) {
						map[nx][ny] = -1;
						nx += dx[i];
						ny += dy[i];
					}
				}
			}
		}
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 0) {
					blindSpot++;
				}
			}
		}
		
		
		
		
		return blindSpot;
		
	}
}
