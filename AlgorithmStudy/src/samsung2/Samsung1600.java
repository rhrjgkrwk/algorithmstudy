package samsung2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class P1600 {
	int x;
	int y;
	int left;
	int count;
	public P1600(int x, int y, int left, int count) {
		super();
		this.x = x;
		this.y = y;
		this.left = left;
		this.count = count;
	}
}

public class Samsung1600 {
	public static int knightMoveX[] = { -2, -2, 2, 2, -1, -1, 1, 1 };
	public static int knightMoveY[] = { -1, 1, -1, 1, -2, 2, -2, 2 };
	public static int normalMoveX[] = { 0, 1, 0, -1 };
	public static int normalMoveY[] = { 1, 0, -1, 0 };
	public static int map[][];
	public static int visit[][][];
	public static int H;
	public static int W;
	public static int K;
	public static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		W = sc.nextInt();
		H = sc.nextInt();
		map = new int[H][W];
		visit = new int[K+1][H][W];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		System.out.println(bfs());
		sc.close();
	}
	public static int bfs(){
		Queue<P1600> q = new LinkedList<>();
		q.add(new P1600(0, 0, K, 0));
		while (!q.isEmpty()) {
			P1600 now = q.poll();
			if (now.x == H-1 && now.y == W-1) {
				return now.count;
			}
			for (int i = 0; i < 8; i++) {
				if (now.left>0) {
					int nx = now.x + knightMoveX[i];
					int ny = now.y + knightMoveY[i];
					if (nx>=0 && nx<H && ny>=0 && ny<W && map[nx][ny]==0 && visit[now.left-1][nx][ny]==0) {
						visit[now.left-1][nx][ny] = now.count+1;
						q.add(new P1600(nx, ny, now.left-1, now.count+1));
					}
				}
				if (i<4) {
					int nx = now.x + normalMoveX[i];
					int ny = now.y + normalMoveY[i];
					if (nx>=0 && nx<H && ny>=0 && ny<W && map[nx][ny]==0 && visit[now.left][nx][ny]==0) {
						visit[now.left][nx][ny] = now.count+1;
						q.add(new P1600(nx, ny, now.left, now.count+1));
					}
				}
			}
		}
		return -1;
	}
}
	/*public static void dfs(int x, int y, int count) {
		visit[x][y] = true;
		// System.out.println("------------");
		// System.out.println(count+" "+min+" "+K);
		// for (int i = 0; i < H; i++) {
		// for (int j = 0; j < W; j++) {
		// if (i==x && j==y) System.out.print("n ");
		// else System.out.print(map[i][j]+" ");
		// }System.out.println();
		// }
		//
		//
		//
		if (x == H - 1 && y == W - 1) {
			min = min > count ? count : min;
			visit[x][y] = false;
			return;
		}

		if (min <= count) { // ?çî?ù¥?ÉÅ Î≥? ?ïÑ?öî?óÜ?äî Í≤ΩÎ°ú?ùºÎ©?
			visit[x][y] = false;
			return;
		}

		if (K > 0) {
			// ?Çò?ù¥?ä∏?†ê?îÑ
			for (int i = 0; i < knightMoveX.length; i++) {
				int nx = x + knightMoveX[i];
				int ny = y + knightMoveY[i];
				if (nx >= 0 && nx < H && ny >= 0 && ny < W && !visit[nx][ny] && map[nx][ny] == 0) {
					K--;
					dfs(nx, ny, count + 1);
					K++;
				}
			}

			// ?ùºÎ∞òÏ†ê?îÑ
			for (int i = 0; i < normalMoveX.length; i++) {
				int nx = x + normalMoveX[i];
				int ny = y + normalMoveY[i];
				if (nx >= 0 && nx < H && ny >= 0 && ny < W && !visit[nx][ny] && map[nx][ny] == 0) {
					dfs(nx, ny, count + 1);
				}
			}

		} else {// ?ùºÎ∞? ?†ê?îÑ
			for (int i = 0; i < normalMoveX.length; i++) {
				int nx = x + normalMoveX[i];
				int ny = y + normalMoveY[i];
				if (nx >= 0 && nx < H && ny >= 0 && ny < W && !visit[nx][ny] && map[nx][ny] == 0) {
					dfs(nx, ny, count + 1);
				}
			}
		}
		visit[x][y] = false;
		return;
	}*/








/*
package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Monkey{
   int i;
   int j;
   int count;
   int hsize;
   
   public Monkey(int i, int j, int count, int hsize) {
      this.i = i;
      this.j = j;
      this.count = count;
      this.hsize = hsize;
   }
   
}

public class p1600 {
   
   static int K, W, H;
   static int answer = -1;
   static int[][] map;
   static int[][][] visited;
   static int[] horsei = {-1, -2, -2, -1, 1, 2, 2, 1};
   static int[] horsej = {-2, -1, 1, 2, 2, 1, -1, -2};
   static int[] posi = {-1, 0, 1, 0};
   static int[] posj = {0, -1, 0, 1};

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      K = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      W = Integer.parseInt(st.nextToken());
      H = Integer.parseInt(st.nextToken());
      map = new int[H][W];
      visited = new int[K+1][H][W];
      for (int i = 0; i < H; i++) {
         st = new StringTokenizer(br.readLine());
         for (int j = 0; j < W; j++)
            map[i][j] = Integer.parseInt(st.nextToken());
      }
      BFS();
      System.out.println(answer);
   }

   public static void BFS(){
      Queue<Monkey> queue = new LinkedList<>();
      queue.add(new Monkey(0, 0, 0, K));
      visited[K][0][0] = 1;
      while(!queue.isEmpty()){
         Monkey m = queue.poll();
         if(m.i == H - 1 && m.j == W - 1){
            answer = m.count;
            return;
         }
         if(m.hsize > 0){
            for (int t = 0; t < 8; t++) {
               int ni = m.i + horsei[t];
               int nj = m.j + horsej[t];
               if(ni < 0 || nj < 0 || ni >= H || nj >= W || map[ni][nj] == 1)
                  continue;
               if(visited[m.hsize - 1][ni][nj] == 0){
                  visited[m.hsize - 1][ni][nj] = m.count + 1;
                  queue.offer(new Monkey(ni, nj, m.count + 1, m.hsize - 1));
               }
            }
         }
         for (int k = 0; k < 4; k++) {
            int ni = m.i + posi[k];
            int nj = m.j + posj[k];
            if(ni < 0 || nj < 0 || ni >= H || nj >= W || map[ni][nj] == 1)
               continue;
            if(visited[m.hsize][ni][nj] == 0){
               visited[m.hsize][ni][nj] = m.count + 1;
               queue.offer(new Monkey(ni, nj, m.count + 1, m.hsize));
            }
         }
      }
   }
*/






































