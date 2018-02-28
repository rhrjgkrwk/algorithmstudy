package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TriangleOfNum1932 {
	public static int [][]d = new int[501][501];
	public static int [][]a = new int[501][501];
	public static int n;
	//public static int []direction = {-1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		for (int i = 1; i <= n ; i++) {
			int j = 1;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			while (st.hasMoreTokens()) {
				a[i][j] = Integer.parseInt(st.nextToken());
				
				j++;
			}
		}
		dp();
		int max = 0;
		for (int tmp : d[n]) {
			if (max < tmp) {
				max = tmp;
			}
		}
		System.out.println(max);
	}
	public static void dp(){
		for (int i = 1; i <= n ; i++) {
			for (int j = 1; j <= i; j++) { //d[i][j] i행 j열에서의 최대값
				d[i][j] = (j-1<0)? (d[i-1][j]+a[i][j]) : (j>i)? (d[i-1][j]+a[i][j]) : Math.max(d[i-1][j]+a[i][j], d[i-1][j-1]+a[i][j]);	
			}
		}
		/*for (int i = 1; i <= n ; i++) {
			for (int j = 1; j <= i; j++) { //d[i][j] i행 j열에서의 최대값
				System.out.print(d[i][j]+" ");
			}System.out.println();
		}*/
	}
}

/*
숫자삼각형 실패 풀이
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	13297	7538	5449	58.036%
문제
        7
      3   8
    8   1   0
  2   7   4   4
4   5   2   6   5
위 그림은 크기가 5인 숫자 삼각형의 한 모습이다.

맨 위층 7부터 시작해서 아래에 있는 수 중 하나를 선택하여 아래층으로 내려올 때, 
이제까지 선택된 수의 합이 최대가 되는 경로를 구하는 프로그램을 작성하라. 
아래층에 있는 수는 현재 층에서 선택된 수의 대각선 왼쪽 또는 대각선 오른쪽에 있는 것 중에서만 선택할 수 있다.

삼각형의 크기는 1 이상 500 이하이다. 
삼각형을 이루고 있는 각 숫자는 모두 정수이며, 범위는 0 이상 9999 이하이다.

입력
첫째 줄에 삼각형의 크기 n(1 ≤ n ≤ 500)이 주어지고, 
둘째 줄부터 n+1줄까지 숫자 삼각형이 주어진다.

출력
첫째 줄에는 최대가 되는 합을 출력한다.

예제 입력 
5
7
3 8
8 1 0
2 7 4 4
4 5 2 6 5
예제 출력 
30
*/