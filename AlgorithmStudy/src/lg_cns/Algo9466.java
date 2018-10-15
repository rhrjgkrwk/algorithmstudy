package lg_cns;

import java.util.Scanner;
import java.util.Stack;

public class Algo9466 {
	public static int choice[];
	public static boolean isVisited[];
	public static boolean isCycle[];
	public static int n;
	public static Stack<Integer> st;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 0; testCase < T; testCase++) {
			n = sc.nextInt();
			st = new Stack<>();
			choice = new int[n + 1];
			isVisited = new boolean[n + 1];
			isCycle = new boolean[n + 1];
			for (int i = 1; i < choice.length; i++) {
				choice[i] = sc.nextInt();
			}
			for (int i = 1; i < choice.length; i++) {
				if (!isVisited[i]) {
					dfs(i);
					st.removeAllElements();
				}
			}

			
			int result = 0;
			for (int i = 1; i < isCycle.length; i++) {
				if (!isCycle[i]) {
					result++;
				}
			}
			System.out.println(result);
		}

	}

	public static void dfs(int now) {
		isVisited[now] = true;
		st.push(now);
		int next = choice[now];
		if (isCycle[next]) {
			return;
		}
		if (st.contains(next) && isVisited[next]) {
			isCycle[next] = true;
			int temp;
			do {
				temp = st.pop();
				isCycle[temp] = true;
			} while (temp != next);
			return;
		}
		dfs(next);
	}
}
