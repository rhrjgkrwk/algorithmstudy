package bruteforce;
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
 * N��Mũ���� �迭�� ǥ���Ǵ� �̷ΰ� �ִ�.
 * 
 * 1 0 1 1 1 1 1 0 1 0 1 0 1 0 1 0 1 1 1 1 1 0 1 1 �̷ο��� 1�� �̵��� �� �ִ� ĭ�� ��Ÿ����, 0��
 * �̵��� �� ���� ĭ�� ��Ÿ����. �̷��� �̷ΰ� �־����� ��, (1, 1)���� ����Ͽ� (N, M)�� ��ġ�� �̵��� �� ������ �ϴ� �ּ���
 * ĭ ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * ���� �������� 15ĭ�� ������ (N, M)�� ��ġ�� �̵��� �� �ִ�. ĭ�� �� ������ ���� ��ġ�� ���� ��ġ�� �����Ѵ�.
 * 
 * �Է� ù° �ٿ� �� ���� N, M(2��N, M��100)�� �־�����. ���� N���� �ٿ��� M���� ������ �̷ΰ� �־�����. ������ ������
 * �پ �Է����� �־�����.
 * 
 * ��� ù° �ٿ� ������ �ϴ� �ּ��� ĭ ���� ����Ѵ�. �׻� ������ġ�� �̵��� �� �ִ� ��츸 �Է����� �־�����.
 * 
 * ���� �Է� 4 6 101111 101010 101011 111011 ���� ��� 15 ���� �Է� 2 4 6 110110 110110
 * 111111 111101 ���� ��� 2 9
 */