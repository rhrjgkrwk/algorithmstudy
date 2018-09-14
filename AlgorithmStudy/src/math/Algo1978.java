package math;

import java.util.Scanner;

public class Algo1978 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[N];
		boolean che[] = new boolean[1001]; //false 이면 소수.
		
		che[0] = true;
		che[1] = true;
		
		int max = 0; // 입력 값 중 제일 큰값을 기준으로 체에 거른다...
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		
		for (int i = 2; i*i <= max ; i++) { //i = 배수.
			if (che[i]) { // 전에 이미 지워진 배 수이면 패스.
				continue;
			}
			for (int j = i*2; j <= max; j+=i) { // j = 실제 che에 거르느 수.
				che[j] = true;
			}
		}
		int res = 0;
		for (int i = 0; i < arr.length; i++) {
			if (!che[arr[i]]) {
				res++;
			}
		}
		System.out.println(res);
	}
}
