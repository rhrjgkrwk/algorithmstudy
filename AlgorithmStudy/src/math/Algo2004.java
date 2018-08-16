package math;

import java.math.BigDecimal;
import java.util.Scanner;

public class Algo2004 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		String ncm = combination(n, m).toPlainString();
		int res = 0;
		for (int i = ncm.length()-1; i >= 0; i--) {
			if (ncm.charAt(i) == '0') {
				res++;
			}
			else break;
		}
		System.out.println(res);
		sc.close();
	}
	public static BigDecimal factorial(int n) {
		BigDecimal res = new BigDecimal(1);
		for (int i = 1; i <= n; i++) {
			res = res.multiply(new BigDecimal(i));
		}
		return res;
	}
	public static BigDecimal combination(int n, int m) {
		BigDecimal res = factorial(n).divide(factorial(m).multiply(factorial(n-m)));
		return res;
	}
}	

/*
2004번
조합 0의 개수
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	6723	1749	1462	29.037%
문제
nCm의 끝자리 0의 개수를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 정수 n, m(0≤m≤n≤2,000,000,000, n!=0)이 들어온다.

출력
첫째 줄에 0의 개수를 출력한다.

예제 입력 1 
25 12
예제 출력 1 
2
*/