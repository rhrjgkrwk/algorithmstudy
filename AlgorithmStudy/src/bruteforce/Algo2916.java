package bruteforce;

import java.util.ArrayList;
import java.util.Scanner;

public class Algo2916 {
	public static Scanner sc = new Scanner(System.in);
	public static int N, K;
	public static boolean[][] visit;
	public static ArrayList<Integer> changyoung = new ArrayList<>();
	public static ArrayList<Integer> hyunwoo = new ArrayList<>();

	public static void main(String[] args) {
		N = sc.nextInt();
		K = sc.nextInt();

		visit = new boolean[N][2]; // 0 - 더하기, 1 - 빼기 여부.

		for (int i = 0; i < N; i++) {
			changyoung.add(sc.nextInt());
		}
		for (int i = 0; i < K; i++) {
			hyunwoo.add(sc.nextInt());
		}
		for (int k : hyunwoo) {
			if (!dfs(k, 0, 0)) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}

	public static boolean dfs(int dest, int sum, int depth) {
		if (sum == dest) {
			return true;
		}

		if (depth > 360) {
			return false;
		}

		for (int i = 0; i < changyoung.size(); i++) {
			if (!visit[i][0]) {
				visit[i][1] = true;
				if (dfs(dest, Math.abs(sum - i), depth + 1)) {
					visit[i][1] = false;
					return true;
				}
				visit[i][1] = false;
			}

			if (!visit[i][1]) {
				visit[i][0] = true;
				if (dfs(dest, Math.abs(sum + i), depth + 1)) {
					visit[i][0] = false;
					return true;
				}
				visit[i][0] = false;
			}
		}

		return false;
	}

}
