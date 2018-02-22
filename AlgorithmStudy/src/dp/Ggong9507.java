package dp;
import java.math.BigDecimal;
import java.util.Scanner;

public class Ggong9507 {
	public static BigDecimal[] d = new BigDecimal[70]; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int i = 0; i < tc; i++) {
			int n = sc.nextInt();
			System.out.println(dp(n));
		}
		sc.close();
	}
	public static BigDecimal dp(int n){
		d[0] = BigDecimal.valueOf(1);
		d[1] = BigDecimal.valueOf(1);
		d[2] = BigDecimal.valueOf(2);
		d[3] = BigDecimal.valueOf(4);
		if (n>3) {
			for (int i = 4; i <= n; i++) {
				d[i] = d[i-1].add(d[i-2].add(d[i-3].add(d[i-4])));
			}
		}
		return d[n];
	}
}
/*
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	2440	1692	1524	71.148%
문제
꿍은 군대에서 진짜 할짓이 없다. 그래서 꿍만의 피보나치를 만들어보려고 한다. 기존의 피보나치는 너무 단순해서 꿍은 좀더 복잡한 피보나치를 만들어보고자 한다. 그래서 다음과 같은 피보나치를 만들었다. 꿍만의 피보나치 함수가 koong(n)이라고 할 때,

n < 2 :                         1
n = 2 :                         2
n = 3 :                         4
n > 3 : koong(n − 1) + koong(n − 2) + koong(n − 3) + koong(n − 4)
이다.

여러분도 꿍 피보나치를 구해보아라.

 

입력
입력의 첫번째 줄을 테스트케이스의 개수 t (0 < t < 69)가 주어진다. 다음 t줄에는 몇번째 피보나치를 구해야하는지를 나타내는 n(0 ≤ n ≤ 67)이 주어진다.

출력
각 테스트케이스에 대해, 각 줄에 꿍 피보나치값을 출력하라.

예제 입력 
8
0
1
2
3
4
5
30
67
예제 출력 
1
1
2
4
8
15
201061985
7057305768232953720*/