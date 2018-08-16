package math;

import java.math.BigDecimal;
import java.util.Scanner;

public class Algo1676 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		BigDecimal NF = new BigDecimal(1);
		for (int i = 1; i <= N; i++) {
			NF = NF.multiply(new BigDecimal(i));
		}
		String str = String.valueOf(NF);
		int res = 0;
		for (int i = str.length()-1; i >= 0; i--) {
			if (str.charAt(i) == '0') {
				res++;
			}
			else {
				break;
			}
		}
		System.out.println(res);
		sc.close();
	}
}

/*
1676번
팩토리얼 0의 개수
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	7855	3410	2898	46.509%
문제
N!에서 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다. (0 ≤ N ≤ 500)

출력
첫째 줄에 구한 0의 개수를 출력한다.

예제 입력 1 
10
예제 출력 1 
2
*/