package lg_cns;

import java.util.Scanner;

public class Algo13458 {
	public static void main(String[] args) {
		int N; // 시험장 수.
		int A[];
		int B, C;
		long result = 0;

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		A = new int[N];
		for (int i = 0; i < A.length; i++) {
			A[i] = sc.nextInt();
		}
		B = sc.nextInt();
		C = sc.nextInt();

		result += N; // 반마다 한명씩 총감독이 필요?
		for (int i = 0; i < A.length; i++) {
			if (A[i] - B > 0) result += (A[i] - B) % C == 0 ?  (A[i] - B) / C : (A[i] - B) / C + 1;
		}
		System.out.println(result);
		sc.close();
	}

}
