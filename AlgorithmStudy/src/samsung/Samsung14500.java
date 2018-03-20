package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Samsung14500 {

   private static int n;
   private static int m;
   private static int[][] map;
   private static boolean[][] visited;
   private static int[] row = { 0, -1, 0, 1 };
   private static int[] col = { -1, 0, 1, 0 };
   private static int dfsans;
   private static int ans;

   public static void main(String[] args) throws Exception {
      // TODO Auto-generated method stub
      solution();
   }

   private static void solution() throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());
      map = new int[n][m];
      visited = new boolean[n][m];

      for (int i = 0; i < n; ++i) {
         st = new StringTokenizer(br.readLine());
         for (int j = 0; j < m; ++j) {
            map[i][j] = Integer.parseInt(st.nextToken());
         }
      }

      for (int i = 0; i < n; ++i) {
         for (int j = 0; j < m; ++j) {
            dfs(i, j, 1);
         }
      }

      for (int i = 0; i < n; ++i) {
         for (int j = 0; j < m; ++j) {
            exception(i, j);
         }
      }
      
      System.out.println(ans);
   }

   private static void dfs(int r, int c, int count) {
      visited[r][c] = true;
      dfsans += map[r][c];

      if (count == 4) {
         ans = Math.max(ans, dfsans);
         visited[r][c] = false;
         dfsans -= map[r][c];
         return;
      }

      for (int i = 0; i < 4; ++i) {
         int nr = r + row[i];
         int nc = c + col[i];

         if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc]) {
            dfs(nr, nc, count + 1);
         }
      }
      visited[r][c] = false;
      dfsans -= map[r][c];
   }

   private static void exception(int r, int c) {
      int tmpsum = map[r][c];
      int tmpcount = 0;
      int min = Integer.MAX_VALUE;
      
      for (int i = 0; i < 4; ++i) {
         int nr = r + row[i];
         int nc = c + col[i];

         if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
            ++tmpcount;
            tmpsum += map[nr][nc];
            min = Math.min(min, map[nr][nc]);
         }
      }
      
      if(tmpcount == 3) {
         ans = Math.max(ans, tmpsum);
      }else if(tmpcount == 4) {
         tmpsum -= min;
         ans = Math.max(ans, tmpsum);
      }
   }
}
/*
import java.util.Scanner;
import java.util.StringTokenizer;

//테트로미노
public class Samsung14500 {
	public static int dx[] = { 0, -1, 0, 1 };
	public static int dy[] = { -1, 0, 1, 0 };
	public static int map[][];
	public static boolean visit[][];
	public static int N;
	public static int M;
	public static int sum;
	public static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(sc.nextLine(), " ");
			int j = 0;
			while (st.hasMoreTokens()) {
				map[i][j++] = Integer.parseInt(st.nextToken());
			}
		}
		max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.println(i+", "+j);
				System.out.println("-------------------");
				//dfs(i, j, 0);
				//sum = 0;
				dfs2(i, j, 1);
				sum = 0;
			}
		}
		System.out.println(max);
		sc.close();
	}

	public static void dfs(int x, int y, int depth) { //T자를 제외한 나머지 테트로미노.
		
		if (depth == 4) {
			if (sum > max) {
				max = sum;
			}
			return;
		}
		visit[x][y] = true;
		sum += map[x][y];
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visit[nx][ny]) {
				dfs(nx, ny, depth + 1);
			}
		}

		visit[x][y] = false;
		sum -= map[x][y];
	}

	public static void dfs2(int x, int y, int depth) { //T자를 만들어보자.
		
		if (depth == 2) {
			visit[x][y] = true;
			sum += map[x][y];
			int max1 = Integer.MIN_VALUE;
			int max2 = Integer.MIN_VALUE;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visit[nx][ny]) {
					if (max2 < map[nx][ny]) {
						if (max1 < map[nx][ny]) {
							int tmp = max1;
							max1 = map[nx][ny];
							max2 = tmp;
						} else {
							max2 = map[nx][ny];
						}
					}
				}
			}
			System.out.println(x+" "+y+" : "+max1+" "+max2+" "+sum);
			sum += (max1 + max2);
			if (sum > max) {
				max = sum;
			}
			
			
			
			
			sum -= (max1 + max2 + map[x][y]);
			visit[x][y] = false;
			return;
		}

		visit[x][y] = true;
		sum += map[x][y];

		if (depth < 2) {
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visit[nx][ny]) {
					dfs2(nx, ny, depth + 1);
				}
			}
		}
		visit[x][y] = false;
		sum -= map[x][y];
	}
}
*/
/*
테트로미노 풀이
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	512 MB	5389	1680	1170	30.405%
문제
폴리오미노란 크기가 1×1인 정사각형을 여러 개 이어서 붙인 도형이며, 다음과 같은 조건을 만족해야 한다.

정사각형은 서로 겹치면 안된다.
도형은 모두 연결되어 있어야 한다.
정사각형의 꼭지점끼리 연결되어 있어야 한다. 즉, 변과 꼭지점이 맞닿아있으면 안된다.
정사각형 4개를 이어 붙인 폴리오미노는 테트로미노라고 하며, 다음과 같은 5가지가 있다.



아름이는 크기가 N×M인 종이 위에 테트로미노 하나를 놓으려고 한다. 종이는 1×1 크기의 칸으로 나누어져 있으며, 각각의 칸에는 정수가 하나 써 있다.

테트로미노 하나를 적절히 놓아서 테트로미노가 놓인 칸에 쓰여 있는 수들의 합을 최대로 하는 프로그램을 작성하시오.

테트로미노는 반드시 한 정사각형이 정확히 하나의 칸을 포함하도록 놓아야 하며, 회전이나 대칭을 시켜도 된다.

입력
첫째 줄에 종이의 세로 크기 N과 가로 크기 M이 주어진다. (4 ≤ N, M ≤ 500)

둘째 줄부터 N개의 줄에 종이에 써 있는 수가 주어진다. i번째 줄의 j번째 수는 위에서부터 i번째 칸, 왼쪽에서부터 j번째 칸에 써 있는 수이다. 입력으로 주어지는 수는 1,000을 넘지 않는 자연수이다.

출력
첫째 줄에 테트로미노가 놓인 칸에 쓰인 수들의 합의 최댓값을 출력한다.

예제 입력 
5 5
1 2 3 4 5
5 4 3 2 1
2 3 4 5 6
6 5 4 3 2
1 2 1 2 1
예제 출력 
19
예제 입력 2 
4 5
1 2 3 4 5
1 2 3 4 5
1 2 3 4 5
1 2 3 4 5
예제 출력 2 
20
예제 입력 3 
4 10
1 2 1 2 1 2 1 2 1 2
2 1 2 1 2 1 2 1 2 1
1 2 1 2 1 2 1 2 1 2
2 1 2 1 2 1 2 1 2 1
예제 출력 3 
7
*/




/*
public class Samsung14500 {
	public static int dx[] = {0,-1,0,1}; 
	public static int dy[] = {-1,0,1,0};
	public static int map[][];
	public static boolean visit[][];
	public static int N;
	public static int M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(sc.nextLine(), " ");
			int j = 0;
			while (st.hasMoreTokens()) {
				map[i][j++] = Integer.parseInt(st.nextToken());
			}
		}
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visit = new boolean[N][M];
				int tmp = dfs(i, j, map[i][j], 1);
				max = max<tmp?tmp:max;
			}
		}
		System.out.println(max);
		sc.close();
	}
	public static int dfs(int x, int y, int sum, int count){
		visit[x][y] = true;
		if (count==2) {
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visit[nx][ny]) {
					//System.out.println(" "+nx+", "+ny+" 방문/ 현재 점수 :"+sum+", 방문할 곳 점수 :"+map[nx][ny]+" 현재 개수 : "+(count+1));
					int tmp = dfs(nx, ny, map[nx][ny], count+2);
				}
			}
			
		}
		if (count==4) {
			return sum;
		}
		int res = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
				//System.out.println(" "+nx+", "+ny+" 방문/ 현재 점수 :"+sum+", 방문할 곳 점수 :"+map[nx][ny]+" 현재 개수 : "+(count+1));
				
				int tmp = dfs(nx, ny, sum+map[nx][ny], count+1);
				
				if (tmp > res) {
					res = tmp;
				}
			}
		}
		return res;
	}
}
*/