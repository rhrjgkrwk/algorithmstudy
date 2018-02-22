package dp;
import java.util.Scanner;

public class MakeOne1463 {
	public static int []d;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		d = new int[n+1];
		for (int i = 0; i < n+1; i++) {
			d[i] = 999999;
		}
		System.out.println(dp(2,n));
		sc.close();
	}
	public static int dp(int now, int n){
		d[0] = 0;
		d[1] = 0;
		while(now!=n+1){
			//d[now] = Math.min(d[now*3],Math.min(d[now*2],d[now+1]))+1;
			if (now%3==0) {
				int minIndex = getMinIndex(now/3, now-1);
				d[now] = d[minIndex]+1;
			}
			else if (now%2==0) {
				int minIndex = getMinIndex(now/2, now-1);
				d[now] = d[minIndex]+1;
			}
			else if (now%2==0 && now%3==0) {
				int minIndex = getMinIndex(now/3,getMinIndex(now/2, now-1));
				d[now] = d[minIndex]+1;
			}
			else {
				d[now] = d[now-1]+1;
			}
			now++;
		}
		return d[n];
	}
	public static int getMinIndex(int a, int b){
		return d[a]>d[b]?b:a;
	}
}

/*
1로 만들기 풀이
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	36407	11731	7819	32.825%
문제
정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.

X가 3으로 나누어 떨어지면, 3으로 나눈다.
X가 2로 나누어 떨어지면, 2로 나눈다.
1을 뺀다.
정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 
연산을 사용하는 횟수의 최소값을 출력하시오.

입력
첫째 줄에 1보다 크거나 같고, 106보다 작거나 같은 자연수 N이 주어진다.

출력
첫째 줄에 연산을 하는 횟수의 최소값을 출력한다.

예제 입력 
2
예제 출력 
1
예제 입력 2 
10
예제 출력 2 
3
*/