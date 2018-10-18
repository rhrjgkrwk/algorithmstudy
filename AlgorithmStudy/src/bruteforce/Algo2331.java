package bruteforce;

import java.util.Scanner;

public class Algo2331 {
	public static int pos[] = new int [300001];
	public static int A;
	public static int P;
	public static int nextNumber(int a) {
		String temp = String.valueOf(a);
		int res = 0;
		for (char c : temp.toCharArray()) {
			res += (int)Math.pow(c-'0', P); 
		}
		return res;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		P = sc.nextInt();
		
		int startPos = 0;
		int count = 1;
		pos[A] = count;
		
		while(true) {
			A = nextNumber(A);//다음 D[a] 
			if (pos[A]>0) {
				startPos = pos[A];
				break;
			}
			pos[A] = ++count;
		}
		
		//여기서 반복이시작되는 지점 -1을 출력.. 
		System.out.println(startPos-1);
	}
}
/*
2331번
반복수열
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	3993	1679	1254	41.800%
문제
다음과 같이 정의된 수열이 있다.

D[1] = A
D[n] = D[n-1]의 각 자리의 숫자를 P번 곱한 수들의 합
예를 들어 A=57, P=2일 때, 수열 D는 {57, 74(=5^2+7^2=25+49), 65, 61, 37, 58, 89, 145, 42, 20, 4, 16, 37, …}이 된다. 그 뒤에는 앞서 나온 수들(57부터가 아니라 58부터)이 반복된다.

이와 같은 수열을 계속 구하다 보면 언젠가 이와 같은 반복수열이 된다. 이 때, 
반복되는 부분을 제외했을 때, 수열에 남게 되는 수들의 개수를 구하는 프로그램을 작성하시오. 위의 예에서는 {57, 74, 65, 61}의 네 개의 수가 남게 된다.

입력
첫째 줄에 A(1≤A≤9999), P(1≤P≤5)가 주어진다.

출력
첫째 줄에 반복되는 부분을 제외했을 때, 수열에 남게 되는 수들의 개수를 출력한다.

예제 입력 1 
57 2
예제 출력 1 
4
*/