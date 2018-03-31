package samsung2;

import java.util.Scanner;

public class Samsung3085 {
	public static char[][] map;
	public static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = Integer.parseInt(sc.nextLine());
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = sc.nextLine().toCharArray();
		}
		int longest = 0;
		
		//가로로 바꾸어보자.
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < N; j++) { //하나 선택해서 바꾸어보
				swap(i, j, i, j-1);
				int tmp = longestCandy();
				longest = tmp>longest?tmp:longest;
				swap(i, j, i, j-1); //원상복귀.
			}
		}
		//세로로 바꾸어보자. 세로할때는저장된longestq보다 긴지 확인 후 저장.
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < N; j++) { //인접한 둘 선택해서 바꾸어보
				swap(j, i, j-1, i);
				int tmp = longestCandy();
				longest = tmp>longest?tmp:longest;
				swap(j, i, j-1, i); //원상복귀.
			}
		}
		System.out.println(longest);
		sc.close();
	}
	public static int longestCandy() {
		int longest = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			int count = 1;
			int tmp = -1;
			for (int j = 1; j < N; j++) {
				if (map[i][j]==map[i][j-1]) {
					count++;
					tmp = tmp<count?count:tmp;
				}
				else count = 1;
			}
			if (longest<tmp) {
				longest = tmp;
			}
		}
		
		for (int i = 0; i < N; i++) {
			int count = 1;
			int tmp = -1;
			for (int j = 1; j < N; j++) {
				if (map[j][i]==map[j-1][i]) {
					count++;
					tmp = tmp<count?count:tmp;
				}
				else count = 1;
			}
			if (longest<tmp) {
				longest = tmp;
			}
		}		
		return longest;
	}
	public static void swap(int i, int j, int i2, int j2) {
		char tmp = map[i][j];
		map[i][j] = map[i2][j2];
		map[i2][j2] = tmp;
	}
}
/*
입력
첫째 줄에 보드의 크기 N이 주어진다. (3 ≤ N ≤ 50)

다음 N개 줄에는 보드에 채워져 있는 사탕의 색상이 주어진다. 빨간색은 C, 파란색은 P, 초록색은 Z, 노란색은 Y로 주어진다.

출력
첫째 줄에 상근이가 먹을 수 있는 사탕의 최대 개수를 출력한다.

예제 입력 1 
5
YCPZY
CYZZP
CCPPP
YCYZC
CPPZZ
예제 출력 1 
4
*/