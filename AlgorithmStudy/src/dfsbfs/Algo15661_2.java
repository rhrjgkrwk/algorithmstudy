package dfsbfs;

import java.util.Scanner;

public class Algo15661_2 {
	public static Scanner sc = new Scanner(System.in);

	public static int minimunDiff = Integer.MAX_VALUE;
	public static int N;
	public static int[][] S;

	public static void main(String[] args) {
		N = sc.nextInt();
		S = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				S[i][j] = sc.nextInt();
			}
		}

		boolean[] status = new boolean[N];
		status[0] = true; // 0번은 첫번째팀에 고정.
		organizeTeam(1, status, 1);
		System.out.println(minimunDiff);
	}

	public static void organizeTeam(int now, boolean[] status, int count) {
		// 점수 계산.
		int startTeam = 0;
		int linkTeam = 0;
		for (int i = 0; i < status.length - 1; i++) {
			if (status[i]) { // startTeam
				for (int j = i + 1; j < status.length; j++) {
					if (status[j]) {
						startTeam += (S[i][j] + S[j][i]);
					}
				}
			} else { // linkTeam
				for (int j = i + 1; j < status.length; j++) {
					if (!status[j]) {
						linkTeam += (S[i][j] + S[j][i]);
					}
				}
			}
		}
		int diff = Math.abs(startTeam - linkTeam);
		if (diff < minimunDiff) {
			minimunDiff = diff;
		}

		if (now >= N || count == N) {
			return;
		}

		status[now] = true;
		organizeTeam(now + 1, status, count + 1);
		status[now] = false;
		organizeTeam(now + 1, status, count);
	}
}
