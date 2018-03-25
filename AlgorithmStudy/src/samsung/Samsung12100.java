package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Samsung12100 {
	public static int map[][];
	public static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			int j = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			while (st.hasMoreElements()) {
				map[i][j++] = Integer.parseInt(st.nextToken());
			}
		}
		// 결과 출력
		System.out.println(move(-1, 0));
		br.close();
	}

	public static int move(int dir, int depth) { // depth 1~5
		

		// 현재 맵 백업...
		int[][] backup = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				backup[i][j] = map[i][j];
			}
		}
		// 참조가 아닌 데이터를 복사해서백업해둔다..
		
		
		
		
		
		// 여기서 이동
		
		//위//////////////////////
		if (dir == 0) { // 위
			for (int i = 0; i < N; i++) {
				int pos = 0; // 현재 채울 공간.
				int last = -1;
				int now = 0;
				for (; now < N;) { // j는 새로 채울 공간이므로. 이동 반대방향부터 시작한다.
					if (map[now][i] == 0) {
						now++;
					}
					else {
						if (last==-1) {
							last = now;
							now++;
						}
						else if (map[now][i] == map[last][i]) {
							map[pos][i] = map[now][i] * 2;
							pos++;
							now++;
							last = -1; // 0 4 2 2인 경우 두번 변환되지 않도록 -1 설정.
						} else { // 0이 아니고 다 를때 ..
							map[pos][i] = map[last][i];
							last = now;
							now++;
							pos++;
						}
					} 
				}
				if(last!=-1)map[pos++][i] = map[last][i];
				for (; pos < N; pos++) {
					map[pos][i] = 0;
				}
			}
			
			
		//오른쪽////////////////////
		} else if (dir == 1) { // 오른쪽
			for (int i = 0; i < N; i++) {
				int pos = N-1; // 현재 채울 공간.
				int last = -1;
				int now = N-1;
				for (; now >= 0;) { // j는 새로 채울 공간이므로. 이동 반대방향부터 시작한다.
					if (map[i][now] == 0) {
						now--;
					}
					else {
						if (last==-1) {
							last = now;
							now--;
						}
						else if (map[i][now] == map[i][last]) {
							map[i][pos] = map[i][now] * 2;
							pos--;
							now--;
							last = -1; // 0 4 2 2인 경우 두번 변환되지 않도록 -1 설정.
						} else { // 0이 아니고 다 를때 ..
							map[i][pos] = map[i][last];
							last = now;
							now--;
							pos--;
						}
					} 
				}
				if(last!=-1)map[i][pos--] = map[i][last];
				for (; pos >= 0; pos--) {
					map[i][pos] = 0;
				}
			}

			
		//아래쪽 ////////////////////
		} else if (dir == 2) { // 아래
			for (int i = 0; i < N; i++) {
				int pos = N-1; // 현재 채울 공간.
				int last = -1;
				int now = N-1;
				for (; now >= 0;) { // j는 새로 채울 공간이므로. 이동 반대방향부터 시작한다.
					if (map[now][i] == 0) {
						now--;
					}
					else {
						if (last==-1) {
							last = now;
							now--;
						}
						else if (map[now][i] == map[last][i]) {
							map[pos][i] = map[now][i] * 2;
							pos--;
							now--;
							last = -1; // 0 4 2 2인 경우 두번 변환되지 않도록 -1 설정.
						} else { // 0이 아니고 다 를때 ..
							map[pos][i] = map[last][i];
							last = now;
							now--;
							pos--;
						}
					} 
				}
				if(last!=-1)map[pos--][i] = map[last][i];
				for (; pos >= 0; pos--) {
					map[pos][i] = 0;
				}
			}

			
		//왼////////////////////	
		} else if (dir == 3) { // 왼
			for (int i = 0; i < N; i++) {
				int pos = 0; // 현재 채울 공간.
				int last = -1;
				int now = 0;
				for (; now < N;) { // j는 새로 채울 공간이므로. 이동 반대방향부터 시작한다.
					if (map[i][now] == 0) {
						now++;
					}
					else {
						if (last==-1) {
							last = now;
							now++;
						}
						else if (map[i][now] == map[i][last]) {
							map[i][pos] = map[i][now] * 2;
							pos++;
							now++;
							last = -1; // 0 4 2 2인 경우 두번 변환되지 않도록 -1 설정.
						} else { // 0이 아니고 다 를때 ..
							map[i][pos] = map[i][last];
							last = now;
							now++;
							pos++;
						}
					} 
				}
				if(last!=-1)map[i][pos++] = map[i][last];
				for (; pos < N; pos++) {
					map[i][pos] = 0;
				}
			}
		}
		
		
		
// 이동 결과를 출력해보자! 
		
		
		
		if (depth == 5) {
			int max = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (max < map[i][j]) {
						max = map[i][j];
					}
				}
			}
			for (int j = 0; j < backup.length; j++) {
				for (int j2 = 0; j2 < backup.length; j2++) {
					map[j][j2] = backup[j][j2];
				}
			}
			return max;
		}
		
//		System.out.println("===="+dir+" : "+depth+"====");
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < map[i].length; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		
		//dfs   
		int max = 0;
		for (int i = 0; i < 4; i++) {
			int tmp = move(i, depth+1);
			if (max < tmp) {
				max = tmp;
			}
			
		}
		
		for (int j = 0; j < backup.length; j++) {
				for (int j2 = 0; j2 < backup.length; j2++) {
					map[j][j2] = backup[j][j2];
				}
			}
		// 백업된 map으로 원상복귀..

		

		return max; // 4이동 방향 중 최대값을리턴..
	}
}
