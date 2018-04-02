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
		
		//�?로로 바꾸?��보자.
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < N; j++) { //?��?�� ?��?��?��?�� 바꾸?���?
				swap(i, j, i, j-1);
				int tmp = longestCandy();
				longest = tmp>longest?tmp:longest;
				swap(i, j, i, j-1); //?��?��복�?.
			}
		}
		//?��로로 바꾸?��보자. ?��로할?��?��???��?��longestq보다 긴�? ?��?�� ?�� ???��.
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < N; j++) { //?��?��?�� ?�� ?��?��?��?�� 바꾸?���?
				swap(j, i, j-1, i);
				int tmp = longestCandy();
				longest = tmp>longest?tmp:longest;
				swap(j, i, j-1, i); //?��?��복�?.
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
?��?��
첫째 줄에 보드?�� ?���? N?�� 주어진다. (3 ?�� N ?�� 50)

?��?�� N�? 줄에?�� 보드?�� 채워?�� ?��?�� ?��?��?�� ?��?��?�� 주어진다. 빨간?��?? C, ?��???��?? P, 초록?��?? Z, ?��???��?? Y�? 주어진다.

출력
첫째 줄에 ?��근이�? 먹을 ?�� ?��?�� ?��?��?�� 최�? 개수�? 출력?��?��.

?��?�� ?��?�� 1 
5
YCPZY
CYZZP
CCPPP
YCYZC
CPPZZ
?��?�� 출력 1 
4
*/