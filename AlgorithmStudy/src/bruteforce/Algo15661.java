package bruteforce;

import java.util.ArrayList;
import java.util.Scanner;

public class Algo15661 {
	public static Scanner sc = new Scanner(System.in);

	public static int N;
	public static int[][] S;
	public static boolean[] selected;
	public static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		N = sc.nextInt();
		S = new int[N][N];
		selected = new boolean[N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				S[i][j] = sc.nextInt();
			}
		}

		selected[0] = true;
		dfs(1, 1);

		System.out.println(min);
	}

	public static void dfs(int now, int numOfSelected) {
		// 계산

		int team1 = calculateScore(true);
		int team2 = calculateScore(false);
		int difference = Math.abs(team1 - team2);
		min = difference < min ? difference : min;
		
		if (numOfSelected >= N || now >= N) {
			return;
		}
		
		selected[now] = true;
		dfs(now+1, numOfSelected + 1);
		selected[now] = false;
		dfs(now+1, numOfSelected);
		
	}

	public static int calculateScore(boolean team) { // O(n^2)
		int score = 0;
		ArrayList<Integer> memberOfTeam = new ArrayList<>();
		for (int i = 0; i < selected.length; i++) {
			if (selected[i] == team) {
				memberOfTeam.add(i);
			}
		}

		for (int i = 0; i < memberOfTeam.size() - 1; i++) {
			for (int j = i + 1; j < memberOfTeam.size(); j++) {
				score += (S[memberOfTeam.get(i)][memberOfTeam.get(j)] + S[memberOfTeam.get(j)][memberOfTeam.get(i)]);
			}
		}

		return score;
	}
}
