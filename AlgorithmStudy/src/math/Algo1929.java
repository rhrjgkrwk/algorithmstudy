package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author changheelee
 * @소수 구하기 
 * @에라토스테네스의 체 문제 -> 아니면 시간초과..  .
 * @소수란 1보다 큰!!
 * @
 */
public class Algo1929 {
	public static void main(String[] args) throws IOException {
		boolean che[] = new boolean[10000001];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		che[1] = true;
		for (int i = 2; i < N/2; i++) {
			for (int j = i*2; j <= N; j+=i) {
				che[j] = true;
			}
		}
		
		for (int i = M; i <= N; i++) {
			if (!che[i]) {
				System.out.println(i);
			}
		}
	}
}
/*
1929번
소수 구하기
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	23882	7042	4972	29.611%
문제
M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1≤M≤N≤1,000,000)

출력
한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.

예제 입력 1 
3 16
예제 출력 1 
3
5
7
11
13
*/