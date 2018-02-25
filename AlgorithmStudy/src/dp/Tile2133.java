package dp;

import java.util.Scanner;

public class Tile2133 {
	public static int d[] = new int[31]; // 패턴별 case를 기록.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		dp(N);
		sc.close();
	}

	public static void dp(int N) {
		if (N % 2 == 1) {
			System.out.println(0);
		} 
		else {
			d[0] = 1;
			for(int i = 2 ; i<=N ; i=i+2) {
				d[i] += d[i-2]*3;	
				for(int j =4 ; i>=j ; j+=2) {
					d[i] +=d[i-j]*2;
				}
			}
			System.out.println(d[N]);
		}
	}
}

//
// 타일 채우기 풀이
// 시간 제한 메모리 제한 제출 정답 맞은 사람 정답 비율
// 2 초 128 MB 9524 3300 2561 34.796%
// 문제
// 3×N 크기의 벽을 2×1, 1×2 크기의 타일로 채우는 경우의 수를 구해보자. -
// N과 관련하여 경우의 수 특정 단위 수 마다 반복되는지 확인해보자.
//
// 입력
// 첫째 줄에 N(1 ≤ N ≤ 30)이 주어진다.
//
// 출력
// 첫째 줄에 경우의 수를 출력한다.
//
// 예제 입력
// 2
// 예제 출력
// 3
//
// 면적 3 6 9 12 15 18 21 24 27
// N 1 2 3 4 5 6 7 8 9
// n 0 3^1 0 3^2+2^1 0 3^3+2^2
// 3^N/2