package samsung;

import java.util.Scanner;

public class Samsung13458 {
	public static long N;
	public static long A[];
	public static long B;
	public static long C;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		A = new long[(int)N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		B = sc.nextInt();
		C = sc.nextInt();
		long res = 0;
		for (int i = 0; i < A.length; i++) {
			res+=1;
			A[i]-=B;
			res+=A[i]>0?(long)Math.ceil((double)A[i]/(double)C):0;
		}
		System.out.println(res);
		sc.close();
	}
}

/*
예제 입력 
1
1
1 1
예제 출력 
1
예제 입력 2 
3
3 4 5
2 2
예제 출력 2 
7
예제 입력 3 
5
1000000 1000000 1000000 1000000 1000000
5 7
예제 출력 3 
714290
예제 입력 4 
5
10 9 10 9 10
7 20
예제 출력 4 
10
*/