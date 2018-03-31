package samsung2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWE1949 {
	public static int dx[] = { 0, 0, 1, -1 };
	public static int dy[] = { 1, -1, 0, 0 };
	public static int map[][];
	public static int memo[][];
	public static int N;
	public static int K;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int testCase = 0; testCase < tc; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			memo = new int[N][N];
			int mountainTop = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (mountainTop < map[i][j]) {
						mountainTop = map[i][j];
					}
				}
			}
			int longestPath = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (mountainTop == map[i][j]) {
						dfs(i, j, 0, false);
					}
				}
			}
			System.out.print("#" + testCase + " ");
			System.out.println(longestPath);
		}

		br.close();
	}

	public static void dfs(int i, int j, int depth, boolean construction) { // cons =공사여부
		
		boolean flag = false; // 더이상 갈 곳이 없으면 false / true;
		for (int k = 0; k < 4; k++) {
			int nx = i + dx[k];
			int ny = j + dy[k];
			if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] < map[i][j]) {
				flag = true;
				dfs(nx, ny, depth + 1, false);
			} else if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] - K < map[i][j] && !construction) { 
				// 공사를 한다. - 공사여부 true;
				
				// 안한다. 안하는 경우 continue;
			}
		}
		if (flag) {
			return;
		}
	}
}
