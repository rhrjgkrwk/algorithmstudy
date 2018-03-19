package hanhwa;

import java.util.Scanner;

public class Reseto2960 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		
		
		System.out.println(reseto(N, K));
	}
	public static int reseto(int N, int K){
		boolean tmp[] = new boolean[N+1];
		int count = 0;
		int p = 2;
		while(true) {
			//지우기
			for (int i = 1; p*i < tmp.length; i++) {
				
				if(!tmp[p*i]){
					tmp[p*i]= true;
					count++;
				}
				if (count==K) {
					return p*i;
				}
			}
			//new p구하기.
			for (int i = p; i < tmp.length; i++) {
				if (!tmp[i]) {
					p = i;
					break;
				}
			}
		}
	}
}
/*에라토스테네스의 체
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	3527	1797	1584	52.625%
문제
에라토스테네스의 체는 N보다 작거나 같은 모든 소수를 찾는 유명한 알고리즘이다.

이 알고리즘은 다음과 같다.

2부터 N까지 모든 정수를 적는다.
아직 지우지 않은 숫자 중 가장 작은 수를 찾는다. 이것을 P라고 하고, 이 수는 소수이다.
P를 지우고, 아직 지우지 않은 P의 배수를 크기 순서대로 지운다.
아직 모든 숫자를 지우지 않았다면, 다시 2번 단계로 간다.
N, K가 주어졌을 때, K번째 지우는 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N과 K가 주어진다. (1 ≤ K < N, max(2, K) < N ≤ 1000)

출력
첫째 줄에 K번째 지워진 수를 출력한다.

예제 입력 
10 7
예제 출력 
9*/