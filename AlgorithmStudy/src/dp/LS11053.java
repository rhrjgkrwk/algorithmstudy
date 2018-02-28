package dp;

import java.util.Scanner;

public class LS11053 {
	public static int []d=new int[1002];
	public static int a[] = new int[1002];
	public static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N  = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
			d[i] = 1;
		}
		dp();
		int max = 0;
		for (int i = 0; i < N; i++) {
			if (max<d[i]) {
				max = d[i];
			}
		}System.out.println(max);
		sc.close();
	}
	public static void dp(){
		for (int i = 0; i < N; i++) {
			int max = 0; //d[0~i-1] 중 최대값을 저장.
			for (int j = 0; j < i; j++) {
				if (a[i]>a[j] && max<=d[j]) {
					max = d[j];
				}
			}
			d[i] = max==0?1:max+1;
		}
	}
}
/*
11053번
가장 긴 증가하는 부분 수열 풀이
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	256 MB	15805	6164	4279	38.967%
문제
수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.

예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 
가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.

입력
첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)이 주어진다.

둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000)

출력
첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.

예제 입력 
6
10 20 10 30 20 50
예제 출력 
4
*/