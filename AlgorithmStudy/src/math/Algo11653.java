package math;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author changheelee @소인수분해.
 */
public class Algo11653 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean che[] = new boolean[N + 1];
		che[1] = true;
		ArrayList<Integer> ched = new ArrayList<>();
		for (int i = 2; i < N / 2; i++) {
			for (int j = i * 2; j <= N; j += i) {
				che[j] = true;
			}
		}
		for (int i = 2; i < che.length; i++) {
			if (!che[i]) {
				ched.add(i);
			}
		}
		
		for (Integer integer : ched) {
			System.out.print(integer + " ");
		}
		System.out.println();
		System.out.println(ched.size());
		
		
		while (che[N]) {
			for (Integer i : ched) {
				if (N % i == 0) {
					N /= i;
					System.out.println(i);
					break;
				}
			}
		}
		System.out.println(N);
		sc.close();
	}
}

/*
 * 소수로 계속나눈값들을 출력..
 * 
 * 
 * 11653번 소인수분해 시간 제한 메모리 제한 제출 정답 맞은 사람 정답 비율 1 초 256 MB 5720 3130 2521 55.455%
 * 문제 정수 N이 주어졌을 때, 소인수분해하는 프로그램을 작성하시오.
 * 
 * 입력 첫째 줄에 정수 N (1 ≤ N ≤ 10,000,000)이 주어진다.
 * 
 * 출력 N의 인수를 한 줄에 하나씩 증가하는 순서대로 출력한다.
 * 
 * 예제 입력 1 72 예제 출력 1 2 2 2 3 3 예제 입력 2 3 예제 출력 2 3 예제 입력 3 6 예제 출력 3 2 3 예제 입력
 * 4 2 예제 출력 4 2 예제 입력 5 9991 예제 출력 5 97 103
 */