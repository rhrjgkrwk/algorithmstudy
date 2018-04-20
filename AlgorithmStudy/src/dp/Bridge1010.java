package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bridge1010 {
	public static int d[][];
	public static int N, M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			d = new int[31][31];
			for (int j = 0; j < d[0].length; j++) {
				d[0][j] = 1;
			}
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			dp();
			System.out.println(d[N][M]);
		}
	}

	public static void dp() {
		if (N == 0)
			d[N][M] = 0;
		else
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					for (int k = 0; k < j; k++) {
						d[i][j] += d[i - 1][k];
					}
				}
			}
	}
}

