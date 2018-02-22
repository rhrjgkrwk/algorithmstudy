package dfsbfs;
import java.util.Arrays;
import java.util.Scanner;

public class Sugorgi {
	static int []sub;
	static int []A;
	static int N ;
	static int M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		A = new int[N];
		sub = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		Arrays.sort(A);
		int min = 2000000000;
		boolean flag = true;
		for (int i = 0; i < A.length-1 && flag; i++) {
			for (int j = i+1; j < A.length && flag; j++) {
				int tmp = A[j]-A[i];
				if (tmp == M) {
					min = tmp;
					flag = false;
				}
				else if (tmp>=min) {
					break;
				}
				else if(tmp < min && tmp > M){
					min = tmp;
				}
			}
		}
		System.out.println(min);
		sc.close();
	}
}
//public static int solve1(int N, int M, int[] A){
//int min = 1000000001;
//boolean flag = true;
//for (int i = 0; i < A.length-1 && flag == true; i++) {
//	for (int j = i+1; j < A.length && flag == true; j++) {
//		if (M==min) {
//			flag = false;
//		}
//		if ((M <= Math.abs(A[i] - A[j]))&& (min >= Math.abs(A[i] - A[j]))) {
//			min = Math.abs(A[i] - A[j]);
//		}
//	}
//}
//return min;
//}



/*
문제
N(1≤N≤100,000)개의 수로 이루어진 수열 A[1], A[2], …, A[N]이 있다. 
이 수열에서 두 수를 골랐을 때(같은 수일 수도 있다), 
그 차이가 M 이상이면서 제일 작은 경우를 구하는 프로그램을 작성하시오.

예를 들어 수열이 {1, 2, 3, 4, 5}라고 하자. 만약 M=3일 경우,
 1 4, 1 5, 2 5를 골랐을 때 그 차이가 M 이상이 된다.
  이 중에서 차이가 가장 작은 경우는 1 4나 2 5를 골랐을 때의 3이 된다.

입력
첫째 줄에 두 정수 N, M(0≤M≤2,000,000,000)이 주어진다. 
다음 N개의 줄에는 차례로 A[1], A[2], …, A[N]이 주어진다. 
각각의 A[i]는 0 ≤ |A[i]| ≤ 1,000,000,000을 만족한다.

출력
첫째 줄에 M 이상이면서 가장 작은 차이를 출력한다. 항상 차이가 M이상인 두 수를 고를 수 있다.

예제 입력 
3 3
1
5
3


6 7
1
5
3
11
10
9

10 48
12
11
1
5
15
50
20
8
7
2




예제 출력 
4


Math.abs때문에 시간초과???
*/