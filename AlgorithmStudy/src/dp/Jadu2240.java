package dp;

import java.util.Scanner;

public class Jadu2240 {
	public static int d[][];
	public static int W; //이동 횟수
	public static int T; //전체 시간
	public static int []a; //떨어지는 장소 기록
	public static int count=0; //이동 횟수
	public static void main(String[] args) {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		W = sc.nextInt();
		d = new int[T+1][W+1];
		a = new int[T+1];
		for (int i = 1; i <= T; i++) {
			a[i] = sc.nextInt();
		}
		dp();
		int max=0;
		for (int t : d[T]) {
			if (max<=t) max = t;
		}
		System.out.println(max);
		sc.close();
	}
	public static void dp(){
		for (int i = 1; i < d.length; i++) {
			for (int j = 0; j < d[i].length; j++) {
				if (j-1 >= 0) d[i][j] = Math.max(d[i-1][j-1], d[i-1][j]);
				else d[i][j] = d[i-1][j];
				int pos = j==0?1:(j%2==0?1:2); //안움직, 홀수 이동 = 2  나머지(짝수이동) = 2
				if (pos==a[i]) {
					d[i][j]++;
				}
			}
		}
	}
}
/*
2240번s

시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	3742	1590	1091	41.546%
문제
자두는 자두를 좋아한다. 그래서 집에 자두나무를 심어두고, 여기서 열리는 자두를 먹고는 한다.
 하지만 자두는 키가 작아서 자두를 따먹지는 못하고, 자두가 떨어질 때까지 기다린 다음에 떨어지는 자두를 받아서 먹고는 한다. 
 자두를 잡을 때에는 자두가 허공에 있을 때 잡아야 하는데, 이는 자두가 말랑말랑하여 바닥에 떨어지면 못 먹을 정도로 뭉개지기 때문이다.

매 초마다, 두 개의 나무 중 하나의 나무에서 열매가 떨어지게 된다. 만약 열매가 떨어지는 순간, 
자두가 그 나무의 아래에 서 있으면 자두는 그 열매를 받아먹을 수 있다. 두 개의 나무는 그다지 멀리 떨어져 있지 않기 때문에, 
자두는 하나의 나무 아래에 서 있다가 다른 나무 아래로 빠르게(1초보다 훨씬 짧은 시간에) 움직일 수 있다. 
하지만 자두는 체력이 그다지 좋지 못해서 많이 움직일 수는 없다.

자두는 T(1≤T≤1,000)초 동안 떨어지게 된다. 자두는 최대 W(1≤W≤30)번만 움직이고 싶어 한다. 
매 초마다 어느 나무에서 자두가 떨어질지에 대한 정보가 주어졌을 때, 자두가 받을 수 있는 자
두의 개수를 구해내는 프로그램을 작성하시오. 자두는 1번 자두나무 아래에 위치해 있다고 한다.

입력
첫째 줄에 두 정수 T, W가 주어진다. 다음 T개의 줄에는 각 순간에 자두가 떨어지는 나무의 번호가 1 또는 2로 주어진다.

출력
첫째 줄에 자두가 받을 수 있는 자두의 최대 개수를 출력한다.

예제 입력 
7 2
2
1
1
2
2
1
1
예제 출력 
6
*/


//////////////////////////////////////////////////////////////DFS(시간초과)/.////////////////////////////////////////////////////////////////////////////////////
/*
import java.util.Scanner;

public class Jadu2240 {
	public static int dp[][];
	public static int W; //이동 횟수
	public static int T; //전체 시간
	public static int []a; //떨어지는 장소 기록
	public static int count=0; //이동 횟수
	public static void main(String[] args) {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		W = sc.nextInt();
		dp = new int[T+1][3];
		a = new int[T+1];
		for (int i = 1; i <= T; i++) {
			a[i] = sc.nextInt();
		}
		
		dfs(W, 1, 1, 1);
		System.out.println(Math.max(dp[T][1], dp[T][2]));
		sc.close();
	}
	
	
	public static void dfs(int left, int lastPos, int pos, int now){ //시간초과 뜸.
		//now == T이면 종료, pos는 현재 1에 있는지 2에 있는지., left는 남은 이동횟수.
		
		if (now==T+1) {
			return;
		}
		if (pos==a[now]) {
			dp[now][pos] = dp[now-1][lastPos] + 1 > dp[now][pos]?dp[now-1][lastPos] + 1:dp[now][pos];
		}
		else {
			dp[now][pos] = dp[now-1][lastPos];
		}
		if (left>=1) {
			int np = pos==2?1:2;
			dfs(left-1, pos, np, now+1);//이동
			
			
			dfs(left, pos, pos, now+1);//안이동
		}
		else {
			dfs(left, pos, pos, now+1);//안이동
		}
	}
}
*/










