package samsung2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Samsung1018 {
	public static int M, N;
	public static String[] board;
	public static int[][] chk;
	public static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new String[N];
		chk = new int[N][M]; //0,0에 W로 시작하는 것을 기준으로 카운트한다.
		for (int i = 0; i < N; i++) {
			board[i] = br.readLine();

			for (int j = 0; j < M; j++) {
				// 수정해야할 부분 chk 0,0 w 시작을 기준으로 한다.
				if (i % 2 == 0) { // 짝 j에 W 홀 j에 B (0부터 시작하니깐.)
					if (j % 2 == 0) {
						chk[i][j] = board[i].charAt(j)=='W'?0:1;
					} else {
						chk[i][j] = board[i].charAt(j)=='B'?0:1;
					}
				} else { // 홀 j에 W 짝 j에 B
					if (j % 2 == 0) {
						chk[i][j] = board[i].charAt(j)=='B'?0:1;
					} else {
						chk[i][j] = board[i].charAt(j)=='W'?0:1;
					}
				}
			}
		}
		for (int i = 0; i < N-7; i++) {
			for (int j = 0; j < M-7; j++) {
				int wCount = 0;
				int bCount = 0;
				for (int k = i; k < i + 8; k++) {
					for (int l = j; l < j + 8; l++) {
						if (chk[k][l]==1) wCount++;
						else bCount++;
					}
				}
				min = Math.min(min, Math.min(wCount, bCount));
			}
		}
		System.out.println(min);
	}
}

/*
 * 8 8 WBWBWBWB BWBWBWBW WBWBWBWB BWBBBWBW WBWBWBWB BWBWBWBW WBWBWBWB BWBWBWBW
 */