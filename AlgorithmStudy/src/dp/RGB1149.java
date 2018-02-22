package dp;
import java.util.Scanner;

public class RGB1149 {
	public static int N; //집의 수
	public static int a[][]; //비용 배열
	public static int d[][]; // dp table
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		a = new int[N][N]; //index i : 집 & j : 3색
		d = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) { // j 색은 0빨 1초 2파 순
				a[i][j] = sc.nextInt();
				if (i==0) {
					d[i][j] = a[i][j];
				}
			}
		}
		System.out.println(dp());
		sc.close();
	}
	public static int dp(){
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				d[i][j] = Math.min(d[i-1][(j+1)%3], d[i-1][(j+2)%3]) + a[i][j];
			}
		}
		return Math.min(d[N-1][0], Math.min(d[N-1][1], d[N-1][2]));
	}
}


/*
RGB거리 성공 풀이
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	19057	9159	6750	48.321%
문제
RGB거리에 사는 사람들은 집을 빨강, 초록, 파랑중에 하나로 칠하려고 한다. 또한, 그들은 모든 이웃은 같은 색으로 칠할 수 없다는 규칙도 정했다. 집 i의 이웃은 집 i-1과 집 i+1이다. 처음 집과 마지막 집은 이웃이 아니다.

각 집을 빨강으로 칠할 때 드는 비용, 초록으로 칠할 때 드는 비용, 파랑으로 드는 비용이 주어질 때, 모든 집을 칠할 때 드는 비용의 최솟값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 집의 수 N이 주어진다. N은 1,000보다 작거나 같다. 둘째 줄부터 N개의 줄에 각 집을 빨강으로 칠할 때, 초록으로 칠할 때, 파랑으로 칠할 때 드는 비용이 주어진다.

출력
첫째 줄에 모든 집을 칠할 때 드는 비용의 최솟값을 출력한다.

예제 입력 
3
26 40 83
49 60 57
13 89 99
예제 출력 
96*/