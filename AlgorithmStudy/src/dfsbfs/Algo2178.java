package dfsbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

class Position2178 {
	int x;
	int y;
	public Position2178(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Algo2178 {
	public static int map [][];
	public static boolean visit [][];
	public static int N;
	public static int M;
	
	public static int dx[] = {0,1,-1,0};
	public static int dy[] = {-1,0,0,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
		Queue<Position2178> q = new LinkedList<>();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int [N][M];
		visit = new boolean [N][M];
		
		for (int i = 0; i < N ; i++) {
			String row = sc.nextLine();
			for (int j = 0; j < row.length(); j++) {
				map[i][j] = row.charAt(j) - '0';
			}
		}
		
		
		q.add(new Position2178(0, 0)); // start Pos
		visit[0][0] = true;
		
		while (!q.isEmpty()) {
			Position2178 now = q.poll();
			boolean flag = false;
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 1 && !visit[nx][ny]) {
					if (now.x == N-1 && now.y == M-1) {
						flag = true;
						break;
					}
					visit[nx][ny] = true;
					map[nx][ny] = map[now.x][now.y] + 1;
					q.add(new Position2178(nx, ny));
				}
			}
			if (flag) {
				break;
			}
		}
		System.out.println(map[N-1][M-1]);
	}
}

/*
2178번
미로 탐색 성공
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	37016	12026	7408	30.796%
문제
N×M크기의 배열로 표현되는 미로가 있다.

1	0	1	1	1	1
1	0	1	0	1	0
1	0	1	0	1	1
1	1	1	0	1	1
미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오.

위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.

입력
첫째 줄에 두 정수 N, M(2≤N, M≤100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.

출력
첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.

예제 입력 1 
4 6
101111
101010
101011
111011
예제 출력 1 
15
예제 입력 2 
4 6
110110
110110
111111
111101
예제 출력 2 
9
*/