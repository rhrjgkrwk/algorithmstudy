package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Password2780 {
	public static int count;
	public static int N;
	public static int[][] keypad1 = {
			{1,2,3},
			{4,5,6},
			{7,8,9},
			{0}
	};
	public static int d[][][] = new int [1001][4][3];
	
	public static int dx[] = {0, 0, -1, 1};
	public static int dy[] = {-1, 1, 0, 0};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		//�ʱ�ȭ ��
		for (int i = 0; i < keypad1.length; i++) {
			for (int j = 0; j < keypad1[i].length; j++) {
				d[1][i][j] = 1;
			}
		}
		int depth = 2;
		
		//tc
		for (int t = 0; t < tc; t++) {
			N = Integer.parseInt(br.readLine());
			if (d[N][0][0]==0) { //N�� �� tc���� Ž���� ���� ���� ���. 
				dp(depth);
				depth = N+1; // depth�� �� tc���� Ž���� �ִ� ���̸� ���.
			}
			//��� ��� �� print
			int res = 0;
			for (int i = 0; i < keypad1.length; i++) {
				for (int j = 0; j < keypad1[i].length; j++) {
					res=(d[N][i][j] + res) % 1234567;
				}
			}
			System.out.println(res);
		}
		
		
		br.close();
	}
	
	public static void dp(int depth) {
		for (int i = depth; i <= N; i++) {
			for (int x = 0; x < keypad1.length; x++) {
				for (int y = 0; y < keypad1[x].length; y++) {
					int sum = 0;
					for (int k = 0; k < 4; k++) {
						int nx = x + dx[k];
						int ny = y + dy[k];
						if (nx >= 0 && nx < keypad1.length && ny >= 0 && ny < keypad1[nx].length) {
							 sum = (d[i - 1][nx][ny]+sum)% 1234567;
						}
					}
					d[i][x][y] = sum;
				}
			}
		}
	}
}