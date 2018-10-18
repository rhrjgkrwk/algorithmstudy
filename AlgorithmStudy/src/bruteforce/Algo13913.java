package bruteforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class P13913 {
	int p;
	int cost;

	public P13913(int p, int cost) {
		super();
		this.p = p;
		this.cost = cost;
	}

}

public class Algo13913 {
	public static int N, K;
	public static Scanner sc = new Scanner(System.in);

	public static int[] visit = new int[200001];
	public static int[] memo = new int[200001];

	public static void main(String[] args) {
		N = sc.nextInt();
		K = sc.nextInt();
		Arrays.fill(visit, Integer.MAX_VALUE);
		Queue<P13913> q = new LinkedList<>();
		q.add(new P13913(N, 0));
		visit[N] = 0;
		memo[N] = -1;
		while (!q.isEmpty()) {
			P13913 X = q.poll();

			if (X.p > 0) {
				if (visit[X.p - 1] > X.cost + 1) {
					visit[X.p - 1] = X.cost + 1;
					memo[X.p - 1] = X.p;
					q.add(new P13913(X.p - 1, X.cost + 1));
				}
			}

			if (X.p < K) {
				if (visit[X.p + 1] > X.cost + 1) {
					visit[X.p + 1] = X.cost + 1;
					memo[X.p + 1] = X.p;
					q.add(new P13913(X.p + 1, X.cost + 1));
				}
			}
			if (Math.abs(X.p - K) > Math.abs(X.p * 2 - K)) {
				if (visit[X.p * 2] > X.cost + 1) {
					visit[X.p * 2] = X.cost + 1;
					memo[X.p * 2] = X.p;
					q.add(new P13913(2 * X.p, X.cost + 1));
				}
			}
		}

		System.out.println(visit[K] == -1 ? 0 : visit[K]);
		ArrayList<Integer> temp = new ArrayList<>();
		for (int i = K; i != -1; i = memo[i]) {
			temp.add(0, i);
		}
		for (Integer i : temp) {
			System.out.print(i + " ");
		}
	}
}
