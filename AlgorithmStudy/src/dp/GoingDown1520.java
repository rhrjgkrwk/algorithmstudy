package dp;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class P{
	int i;
	int j;
	public P(int i, int j) {
		this.i = i;
		this.j = j;
	}
}

public class GoingDown1520 {
	public static int dp[][] = new int[501][501];
	public static int map[][] = new int[501][501];
	public static int N;
	public static int M;
	public static int tmp = 0;
	public static int di[] = { 0, -1, 0, 1 };
	public static int dj[] = { -1, 0, 1, 0 };

	public static void main(String[] args) {
		// bfs + memo
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt(); // 세로
		N = sc.nextInt(); // 가로
		// 입력
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				dp[i][j] = -1;
			}
		}
		System.out.println(dfs(0,0));
		System.out.println(tmp);
		sc.close();
	}
	public static void bfs(){ //시간초과
		Queue<P> q = new LinkedList<P>();
		q.add(new P(0,0));
		while (!q.isEmpty()) {
			P p = q.poll();
			dp[p.i][p.j]++;
			for (int k = 0; k < 4; k++) {
				int li = p.i + di[k];
				int lj = p.j + dj[k];
				if (li >= 0 && lj >= 0 && li < M && lj < N && map[li][lj] < map[p.i][p.j]) {
					q.add(new P(li, lj));
				}
			}
		}
	}
	
	public static int dfs(int i, int j){ //dfs+memoization
		tmp++;
		if (i==M-1 && j== N-1) return 1; //도착
		if (dp[i][j]!=-1) return dp[i][j]; //이미 방문한 곳은 그냥 그대로 리턴해준다.
		int count = 0;
		for (int k = 0; k < 4; k++) {
			int li = i + di[k];
			int lj = j + dj[k];
			if (li >= 0 && lj >= 0 && li < M && lj < N && map[li][lj] < map[i][j]) {
					count += dfs(li, lj); //자신이 호출할 수 있는 모든 곳의 경우의 수를 카운트에 담고
			}
		}
		return dp[i][j] = count; //카운트 결과를 자신에게 담는다.
	}
}
/*
1520번
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	13396	2763	2059	25.847%
문제
여행을 떠난 세준이는 지도를 하나 구하였다.
 이 지도는 아래 그림과 같이 직사각형 모양이며 여러 칸으로 나뉘어져 있다. 
 한 칸은 한 지점을 나타내는데 각 칸에는 그 지점의 높이가 쓰여 있으며, 
 각 지점 사이의 이동은 지도에서 상하좌우 이웃한 곳끼리만 가능하다.

현재 제일 왼쪽 위 칸이 나타내는 지점에 있는 세준이는 제일 오른쪽 아래 칸이 나타내는 지점으로 가려고 한다. 
그런데 가능한 힘을 적게 들이고 싶어 항상 높이가 더 낮은 지점으로만 이동하여 목표 지점까지 가고자 한다. 
위와 같은 지도에서는 다음과 같은 세 가지 경로가 가능하다.

지도가 주어질 때 이와 같이 제일 왼쪽 위 지점에서 출발하여 제일 오른쪽 아래 지점까지 
항상 내리막길로만 이동하는 경로의 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에는 지도의 세로의 크기 M과 가로의 크기 N이 빈칸을 사이에 두고 주어진다. 
이어 다음 M개 줄에 걸쳐 한 줄에 N개씩 위에서부터 차례로 각 지점의 높이가 빈 칸을 사이에 두고 주어진다. 
M과 N은 각각 500이하의 자연수이고, 각 지점의 높이는 10000이하의 자연수이다.

출력
첫째 줄에 이동 가능한 경로의 수 H를 출력한다. 모든 입력에 대하여 H는 10억 이하의 음이 아닌 정수이다.

for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}

예제 입력 
4 5
50 45 37 32 30
35 50 40 20 25
30 30 25 17 28
27 24 22 15 10

5 5
18 17 16 15 14
2 2 2 2 13
8 9 10 11 12
7 2 2 2 2 
6 5 4 3 2

예제 출력 
3
*/





/////////dp



/*
public static void dp(){ //실패.. 진행방향이 "<--" 인 경우가 안잡힌다.
	for (int i = 0; i < M; i++) {
		for (int j = 0; j < N; j++) {
			if (i == 0 && j == 0)
				dp[i][j] = 1;
			else
				for (int k = 0; k < 4; k++) {
					int li = i + di[k];
					int lj = j + dj[k];
					if (li >= 0 && lj >= 0 && li < M && lj < N && map[li][lj] > map[i][j] && dp[li][lj] != 0) {
						dp[i][j] = 1;
					}
				}
		}
	}

	// dp
	for (int i = 0; i < M; i++) {
		for (int j = 0; j < N; j++) {
			if (i == 0 && j == 0) {
				continue;
			} else {
				int tot = 0;
				for (int k = 0; k < 4; k++) {
					int li = i + di[k];
					int lj = j + dj[k];
					if (li >= 0 && lj >= 0 && li < M && lj < N && map[li][lj] > map[i][j] && dp[li][lj] > 0) {
						tot += dp[li][lj];
					}
				}
				dp[i][j] = tot;
			}
		}
	}
}
*/







