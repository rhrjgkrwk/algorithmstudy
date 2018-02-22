package dfsbfs;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Tomato7569 {
	public static int[] dx = { 0, 0, -1, 1, 0, 0 };
	public static int[] dy = { -1, 1, 0, 0, 0, 0 };
	public static int[] dz = { 0, 0, 0, 0, -1, 1 };
	public static int H;
	public static int M;
	public static int N;
	public static int[][][] box;
	public static int[][][] dayCheck;
	public static int[][][] visit;
	public static int left;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<P> q = new LinkedList<>();
		
		M = sc.nextInt();
		N = sc.nextInt();
		H = sc.nextInt();
		
		box = new int[H][N][M];
		dayCheck = new int[H][N][M];
		visit = new int[H][N][M];
		left = H * M * N;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					box[i][j][k] = sc.nextInt();
					if (box[i][j][k] == 1) {
						q.add(new P(i, j, k));
						left--;
					}
					if (box[i][j][k] == -1) {
						left--;
					}
				}
			}
		}
		
		int day=0;
		if (left==0) {
			System.out.println(day);		
		}

		else {
			while (!q.isEmpty()) {
				P p = q.poll();
				box[p.x][p.y][p.z] = 1;
				System.out.println("------------");
				for (int i = 0; i < H; i++) {
					for (int j = 0; j < N; j++) {
						for (int k = 0; k < M; k++) {
							System.out.print(dayCheck[i][j][k]+" ");
						}System.out.println();
					}
				}
				for (int i = 0; i < 6; i++) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];
					int nz = p.z + dz[i];
					if (nx >= 0 && nx < H && ny >= 0 && ny < N &&
						nz >= 0 && nz < M && box[nx][ny][nz] == 0
						&&visit[nx][ny][nz] == 0) {
						dayCheck[nx][ny][nz] = dayCheck[p.x][p.y][p.z] + 1;
						q.add(new P(nx, ny, nz));
						day = Math.max(day, dayCheck[nx][ny][nz]);
						visit[nx][ny][nz] = 1;
						left--;
					}
				}
			}
			System.out.println(left == 0 ? day : -1);
		}
		sc.close();
	}
}

class P {
	int x;
	int y;
	int z;

	public P() {
	}

	public P(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
/*
4 4 1
0 0 0 0
0 0 0 0
0 0 0 0
0 0 0 1
0 0 0 0
0 0 0 0
0 0 0 0
0 0 0 0
*/





