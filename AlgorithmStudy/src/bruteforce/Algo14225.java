package bruteforce;

import java.util.Scanner;

public class Algo14225 {
	public static Scanner sc = new Scanner(System.in);
	public static int N;
	public static int[] list;
	public static boolean[] check;

	public static void main(String[] args) {
		N = sc.nextInt();
		list = new int[N];

		for (int i = 0; i < list.length; i++) {
			list[i] = sc.nextInt();
		}
		
		int sum = 0;
		for (int i = 0; i < list.length; i++) {
			sum+=list[i];
		}
		
		check = new boolean[sum+2];
		dfs(0, 0);
		
		for (int i = 1; i < check.length; i++) {
			if (!check[i]) {
				System.out.println(i);
				return;
			}
		}
		
	}
	public static void dfs(int depth, int sum) {
		check[sum] = true;
		if (depth == N) {
			return;
		}
		dfs(depth + 1, sum + list[depth]);
		dfs(depth + 1, sum);
	}
	
	
}
