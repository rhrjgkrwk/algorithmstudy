package dp;

import java.util.Scanner;

public class GreedyPanda1937 {
	public static int dp[][] = new int[501][501];
	public static int map[][] = new int[501][501];
	public static int N;
	public static int M;
	public static int tmp = 0;
	public static int di[] = { 0, -1, 0, 1 };
	public static int dj[] = { -1, 0, 1, 0 };
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt(); // 세로
		//N = sc.nextInt(); // 가로
		// 입력
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				dp[i][j] = -1;
			}
		}
		//dfs를 돌리좌
		int max = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				if (dp[i][j]==-1) {
					int tmp = dfs(i, j);
					if (max < tmp) {
						max = tmp;
					} 
				}
			}
		}
		System.out.println(max);
		sc.close();
	}
	public static int dfs(int i, int j){
		//if (i==M-1 && j== N-1) return 1; //도착
		if (dp[i][j]!=-1) return dp[i][j]; //방문한곳이면
		int max = 0; //방문 가능한 곳 중 최대값 기록
		int way = 0; //방문가능한 곳이 있는지 체크.
		for (int k = 0; k < 4; k++) {
			int li = i + di[k];
			int lj = j + dj[k];
			if (li >= 0 && lj >= 0 && li < M && lj < M && map[li][lj] > map[i][j]) { //큰곳으로 이덩
				way++;
				int tmp = dfs(li, lj); 
				max = tmp>max?tmp:max; //방문 가능한 곳 중 일수가 큰 곳을 가져와라
			}
		}
		if (way==0)  return dp[i][j] = 1; //더 이상 갈 곳이 없으면 그곳이 1
		return dp[i][j] = max+1;
	}
}

/*
1937번

예제 입력 
4
14 9 12 10
1 11 5 4
7 15 2 13
6 3 16 8
예제 출력 
4


욕심쟁이 판다 풀이
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	10104	3143	1971	28.964%
문제
n*n의 크기의 대나무 숲이 있다. 욕심쟁이 판다는 어떤 지역에서 대나무를 먹기 시작한다. 
그리고 그 곳의 대나무를 다 먹어 치우면 상, 하, 좌, 우 중 한 곳으로 이동을 한다. 
그리고 또 그곳에서 대나무를 먹는다. 그런데 단 조건이 있다. 이 판다는 매우 욕심이 많아서 대나
무를 먹고 자리를 옮기면 그 옮긴 지역에 그 전 지역보다 대나무가 많이 있어야 한다. 만약에 그런 지
점이 없으면 이 판다는 불만을 가지고 단식 투쟁을 하다가 죽게 된다(-_-)


이 판다의 사육사는 이런 판다를 대나무 숲에 풀어 놓아야 하는데, 어떤 지점에 처음에 풀어 놓아
야 하고, 어떤 곳으로 이동을 시켜야 둘 다 소중한 생명이지만 판다가 최대한 오래 살 수 있는지 고민
에 빠져 있다. 우리의 임무는 이 사육사를 도와주는 것이다. n*n 크기의 대나무 숲이 주어져 있을 때, 
이 판다가 최대한 오래 살려면 어떤 경로를 통하여 움직여야 하는지 구하여라.

입력
첫째 줄에 대나무 숲의 크기 n(1<=n<=500)이 주어진다. 그리고 둘째 줄부터 1+n번
째 줄 까지 대나무 숲의 정보가 주어진다. 대나무 숲의 정보는 공백을 사이로 두고 각 지역의
 대나무의 양이 정수 값으로 주어진다. 대나무의 양은 1,000,000보다 작거나 같은 자연수이다.

출력
첫째 줄에는 판다가 최대한 살 수 있는 일수(K)를 출력한다.


*/