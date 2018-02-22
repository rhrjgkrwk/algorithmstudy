package dfsbfs;
import java.util.Scanner;

public class Bubunhap {
	public static int N;
	public static int S;
	public static int []A;
	public static int count=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		solve(0,0,0);
		System.out.println(count);
		sc.close();
	}
	public static void solve(int i, int sum, int chk){ 
		//chk은 아무것도 안먹은 경우를 제외하기 위해서 먹은 개수를 체크
		
		if (i==N&&sum==S && chk > 0) {
			count++;
		}
		if (i<=N-1) {
			solve(i+1, sum, chk);
			solve(i+1, sum+A[i], chk+1);
		}
	}
}


/*
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	8799	4032	2570	44.090%
문제
N개의 정수로 이루어진 집합이 있을 때, 이 집합의 공집합이 아닌 부분집합 중에서 그 집합의 원소를 다 더한 값이 S가 되는 경우의 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 정수의 개수를 나타내는 N과 정수 S가 주어진다. (1≤N≤20, |S|≤1,000,000) 둘째 줄에 N개의 정수가 빈 칸을 사이에 두고 주어진다. 주어지는 정수의 절대값은 100,000을 넘지 않는다. 같은 수가 여러번 주어질 수도 있다.

출력
첫째 줄에 합이 S가 되는 부분집합의 개수를 출력한다.

예제 입력 
5 0
-7 -3 -2 5 8
5 12
1 3 5 7 9
예제 출력 
1
*/