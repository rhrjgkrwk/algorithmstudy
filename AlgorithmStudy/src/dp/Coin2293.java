package dp;
import java.util.Scanner;
//못품..
public class Coin2293 {
	public static int d[][];
	public static int coin[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		d = new int[n+1][k+1];
		coin = new int[n+1];
		for (int i = 1; i <= n; i++) {
			coin[i] = sc.nextInt();
		}
		sc.close();
		//System.out.println(dp(k));
	}
	/*public static int dp(int k){
		//C[c,m] = 
	}*/
}

/*
동전 1 풀이
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	4 MB	13169	5329	3936	39.899%
문제
n가지 종류의 동전이 있다. 각각의 동전이 나타내는 가치는 다르다. 
이 동전들을 적당히 사용해서, 그 가치의 합이 k원이 되도록 하고 싶다. 
그 경우의 수를 구하시오. (각각의 동전은 몇 개라도 사용할 수 있다.)

입력
첫째줄에 n, k가 주어진다. (1 ≤ n ≤ 100, 1 ≤ k ≤ 10,000) 다음 n개의 줄에는 각각의 동전의 가치가 주어진다.

출력
첫째 줄에 경우의 수를 출력한다. 경우의 수는 2^31보다 작다.

예제 입력 
3 10
1
2
5
예제 출력 
10

*/