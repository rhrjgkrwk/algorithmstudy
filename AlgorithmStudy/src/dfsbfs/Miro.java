package dfsbfs;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Miro {
	static int N;
	static int M;
	static int[][] miro;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int [][]dist;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		miro = new int[N][M];
		dist = new int[N][M];
		for (int i = 0; i < N; i++) {
			char[] tmp = sc.next().toCharArray();
			for (int j = 0; j < tmp.length; j++) {
				miro[i][j] = (int) (tmp[j] - '0');
			}
		}
		System.out.println(bfs(0,0));
	}

	public static int bfs(int sx, int sy) {
		Queue<Point> tmp = new LinkedList<Point>();
		//int count = 0;
		tmp.add(new Point(sx, sy));
		miro[sx][sy] = 0;
		while (true) {
			if (tmp.isEmpty()) {
				return -1;
			}
			Point p = tmp.poll();
			
			
			if (p.x==N-1&&p.y==M-1) {
				return dist[N-1][M-1]+1;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (nx >= 0 && nx < N && ny < M && ny >= 0 && miro[nx][ny] == 1) {
					tmp.add(new Point(nx, ny));
					dist[nx][ny] = dist[p.x][p.y]+1;
				}
			}
		}
	}
}
/*
4 6
110110
110110
111111
111101

*/
/*
 * N×M크기의 배열로 표현되는 미로가 있다.
 * 
 * 1 0 1 1 1 1 1 0 1 0 1 0 1 0 1 0 1 1 1 1 1 0 1 1 미로에서 1은 이동할 수 있는 칸을 나타내고, 0은
 * 이동할 수 없는 칸을 나타낸다. 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의
 * 칸 수를 구하는 프로그램을 작성하시오.
 * 
 * 위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.
 * 
 * 입력 첫째 줄에 두 정수 N, M(2≤N, M≤100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은
 * 붙어서 입력으로 주어진다.
 * 
 * 출력 첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.
 * 
 * 예제 입력 4 6 101111 101010 101011 111011 예제 출력 15 예제 입력 2 4 6 110110 110110
 * 111111 111101 예제 출력 2 9
 */