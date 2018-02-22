package dfsbfs;

import java.util.Scanner;

public class Z1074 {
	public static int N;
	public static int r;
	public static int c;
	public static int[][] table = { { 0, 1 }, { 2, 3 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		
		System.out.println(dfs(r, c, 0, N));
		sc.close();
	}

	public static int dfs(int i, int j, int order, int d) { // i,j는 r,c , order는 순서. d는 2^N --> 1까지
		int no = (int) (Math.pow(2, d-1)*Math.pow(2, (d - 1))); //2^d 사각형에서의 다음 순서
		int nd = (int) Math.pow(2, (d - 1)); // 다음 사각형의 크기
		// 1사분면
		if (0 <= i && i < nd && 0 <= j && j < nd && d > 1) {
			return dfs(i, j, order, d -1);
		}
		// 2사분면
		else if (0 <= i && i < nd && Math.pow(2, d) > j && j >= nd && d > 1) {
			return dfs(i, j - nd, order + 1 * no, d -1);
		}
		// 3사분면
		else if (Math.pow(2, d) > i && i >= nd && 0 <= j && j < nd && d > 1) {
			return dfs(i - nd, j, order + 2 * no, d -1);
		}
		// 4사분면
		else if (Math.pow(2, d) > i && i >= nd && Math.pow(2, d) > j && j >= nd
				&& d > 1) {
			return dfs(i - nd, j - nd, order + 3 * no,	d -1);
		}
		else {
			return order+table[i][j];
		}
	}
}
/*
 * return order+table[i][j]; 시간 제한 메모리 제한 제출 정답 맞은 사람 정답 비율 2 초 128 MB 5210 2346
 * 1363 42.620% 문제 한수는 2차원 배열 (항상 2^N * 2^N 크기이다)을 Z모양으로 탐색하려고 한다. 예를 들어, 2*2배열을
 * 왼쪽 위칸, 오른쪽 위칸, 왼쪽 아래칸, 오른쪽 아래칸 순서대로 방문하면 Z모양이다.
 * 
 * 
 * 
 * 만약, 2차원 배열의 크기가 2^N * 2^N라서 왼쪽 위에 있는 칸이 하나가 아니라면, 배열을 4등분 한 후에 (크기가 같은
 * 2^(N-1)로) 재귀적으로 순서대로 방문한다.
 * 
 * 다음 예는 2^2 * 2^2 크기의 배열을 방문한 순서이다.
 * 
 * 
 * 
 * N이 주어졌을 때, (r, c)를 몇 번째로 방문하는지 출력하는 프로그램을 작성하시오.
 * 
 * 다음 그림은 N=3일 때의 예이다.
 * 
 * 
 * 
 * 입력 첫째 줄에 N r c가 주어진다. N은 15보다 작거나 같은 자연수이고, r과 c는 0보다 크거나 같고, 2^N-1보다 작거나 같은
 * 정수이다
 * 
 * 출력 첫째 줄에 문제의 정답을 출력한다.
 * 
 * 예제 입력 2 3 1 예제 출력 11 
 * 예제 입력 3 7 7 예제 출력 63
 */