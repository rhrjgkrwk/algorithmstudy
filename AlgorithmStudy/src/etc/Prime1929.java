package etc;

import java.util.Scanner;

public class Prime1929 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		// prime number를 찾아보자
		for (int i = M; i <= N; i++) {
			boolean flag = true;
			
			if (i != 1 && i%2!=0) {
				for (int j = 2; j <= i / 2; j++) {
					if (i % j == 0) {
						flag = false;
						break;
					}
				}
				if (flag) {
					System.out.println(i);
				}
				i++;
			}
		}
		sc.close();
	}
}
/*
에라토스테네스의 체는 N보다 작거나 같은 모든 소수를 찾는 유명한 알고리즘이다.

이 알고리즘은 다음과 같다.

2부터 N까지 모든 정수를 적는다.
아직 지우지 않은 숫자 중 가장 작은 수를 찾는다. 이것을 P라고 하고, 이 수는 소수이다.
P를 지우고, 아직 지우지 않은 P의 배수를 크기 순서대로 지운다.
아직 모든 숫자를 지우지 않았다면, 다시 2번 단계로 간다.
*/