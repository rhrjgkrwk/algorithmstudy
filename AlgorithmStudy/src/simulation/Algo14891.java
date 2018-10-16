package simulation;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Algo14891 {
	public static Scanner sc = new Scanner(System.in);
	public static int[][] gears = new int[4][8];
	public static int[] cur = new int[4];
	public static boolean[] visit;

	public static void main(String[] args) {
		int score = 0;
		for (int i = 0; i < 4; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < str.length(); j++) {
				gears[i][j] = str.charAt(j) - '0';
			}
		}

		int K = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
			int num = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken());
			visit = new boolean[4];
			rotateGear(num, dir);
		}
		System.out.println(calculateScore());
	}

	public static int calculateScore() {
		int res = 0;
		for (int i = 0; i < 4; i++) {
			if (gears[i][cur[i]] == 1) {
				res += Math.pow(2, i);
			}
		}
		return res;
	}

	public static void rotateGear(int num, int dir) {
		visit[num] = true;
		if (num > 0 && gears[num][(cur[num] + 6) % 8] != gears[num - 1][(cur[num - 1] + 2) % 8] && !visit[num - 1]) {
			rotateGear(num - 1, dir * -1);
		}
		if (num < 3 && gears[num][(cur[num] + 2) % 8] != gears[num + 1][(cur[num + 1] + 6) % 8] && !visit[num + 1]) {
			rotateGear(num + 1, dir * -1);
		}
		cur[num] = (8 + cur[num] + dir * -1) % 8;
		return;
	}
}
