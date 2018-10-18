package bruteforce;
import java.util.Scanner;

public class AlgoDFS {
	static int N, K;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int a[] = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
		}
		K = sc.nextInt();
		System.out.println(dfs(a,0,0));
		sc.close();
	}
	public static boolean dfs(int[] a, int i, int sum){
		if (i==a.length) {
			return sum == K;
		}
		if (dfs(a,i+1,sum+a[i])) {
			return true;
		}
		if (dfs(a,i+1,sum)) {
			return true;
		}
		return false;
	}
}
