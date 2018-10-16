package simulation;

import java.util.Scanner;

public class Algo14890 {
	public static Scanner sc = new Scanner(System.in);
	public static int N, L;// 순서대로 row col 경사로길이.
	public static int[][] map;

	public static boolean check(int dir, int num) {
		int count = 1;
		if (dir == 0) { // 가로 탐색인 경우.
			for (int cur = 0; cur < N - 1;) {

				if (Math.abs(map[num][cur] - map[num][cur + 1]) > 1) { // 높이가 2이상 차이나면 false 리턴.
					return false;
				}

				if (map[num][cur] - map[num][cur + 1] == 0) { // 높이가 같을 떄.
					count++;
					cur++;
				} else if (map[num][cur] - map[num][cur + 1] == 1) { // 높이가 더 낮아질 때.
					count = 1;
					cur++;

					while (cur < N - 1 && map[num][cur] - map[num][cur + 1] == 0 && count < L) {
						count++;
						cur++;
					}

					if (count == L) {
						count = 0;
					} else {
						return false;
					}

				} else if (map[num][cur] - map[num][cur + 1] == -1) { // 높이가 더 높아질 때.
					if (count >= L) {// 경사로를 놓을 수 있으면.
						count = 1;
						cur++;
					} else {
						return false;
					}
				}
			}
		} else if (dir == 1) { // 세로 탐색인 경우.
			for (int cur = 0; cur < N - 1;) {
				if (Math.abs(map[cur][num] - map[cur + 1][num]) > 1) { // 높이가 2이상 차이나면 false 리턴.
					return false;
				}

				if (map[cur][num] - map[cur + 1][num] == 0) { // 높이가 같을 떄.
					count++;
					cur++;
				} else if (map[cur][num] - map[cur + 1][num] == 1) { // 높이가 더 낮아질 때.
					count = 1;
					cur++;

					while (cur < N - 1 && map[cur][num] - map[cur + 1][num] == 0 && count < L) {
						count++;
						cur++;
					}

					if (count == L) {
						count = 0;
					} else {
						return false;
					}

				} else if (map[cur][num] - map[cur + 1][num] == -1) { // 높이가 더 높아질 때.
					if (count >= L) {// 경사로를 놓을 수 있으면.
						count = 1;
						cur++;
					} else {
						return false;
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		N = sc.nextInt();
		L = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int result = 0;
		for (int i = 0; i < N; i++) {
			result += check(0, i) ? 1 : 0;
			result += check(1, i) ? 1 : 0;
		}
		System.out.println(result);
	}
}
