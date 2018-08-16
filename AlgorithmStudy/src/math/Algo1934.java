package math;

import java.util.Scanner;

/**
 * @author changheelee
 * @최소 공배수 구하는 문제
 * @a,b를 곱해서 최대공약수로 나누는 방법으로 해결
 * @ 최대 공약수는 유클리드 호제법 - 재귀로 해결.
 */
public class Algo1934 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int i = 0; i < testCase; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			// 최소공배수 = a*b/최대공약수  
			System.out.println(gcd(A,B));
		}
	}
	public static int gcd(int a, int b) {
		return a*b/lcm(a,b);
	}
	public static int lcm(int a, int b) {
		if (a<b) {
			int temp = a;
			a = b;
			b = temp;
		}
		if (b==0) {
			return a;
		}
		return lcm(b, a%b);
	}
}
/*
유클리드 알고리즘" 원리.

임의의 두 자연수 a, b가 주어졌을때. 둘중 큰 값이 a라고 가정해보겠습니다.

a를 b로 나눈 나머지를 n 이라고 하면 (a%b = n)

n이 0일때, b가 최대 공약수(GCD)입니다.

만약 n이 0이 아니라면, a에 b값을 다시 넣고 b를 n에 대입 한 후 다시 위에 step2부터 반복하면 됩니다.

*/

/*
1934번
최소공배수
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	10087	5647	4870	58.675%
문제
두 자연수 A와 B에 대해서, A의 배수이면서 B의 배수인 자연수를 A와 B의 공배수라고 한다. 이런 공배수 중에서 가장 작은 수를 최소공배수라고 한다. 예를 들어, 6과 15의 공배수는 30, 60, 90등이 있으며, 최소 공배수는 30이다.

두 자연수 A와 B가 주어졌을 때, A와 B의 최소공배수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수 T(1 ≤ T ≤ 1,000)가 주어진다. 둘째 줄부터 T개의 줄에 걸쳐서 A와 B가 주어진다. (1 ≤ A, B ≤ 45,000)

출력
첫째 줄부터 T개의 줄에 A와 B의 최소공배수를 입력받은 순서대로 한 줄에 하나씩 출력한다.

예제 입력 1 
3
1 45000
6 10
13 17
예제 출력 1 
45000
30
221
출처
*/