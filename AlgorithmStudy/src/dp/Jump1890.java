package dp;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//bfs + memo
public class Jump1890 {
	public static int N;
	public static long [][] d;
	public static int [][] a;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = sc.nextInt();
		a = new int[N][N];
		d = new long[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		d[0][0]=1;
		dp();
		//bfs();
		//dfs();
		sc.close();
	}
	
	public static void dp() {
		
		for (int i = 0; i < N; i++){
			for (int j = 0; j < N; j++) {
				if (a[i][j]!=0) {
					if (i+a[i][j]<N) {
						d[i+a[i][j]][j] += d[i][j];
					}
					if (j+a[i][j]<N) {
						d[i][j+a[i][j]] += d[i][j];
					}
				}
				else {
					continue;
				}
			}
		}
		System.out.println(d[N-1][N-1]);
	}
	
	public static void bfs(){
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0));
		d[0][0] = 1;
		while (!q.isEmpty()) {
			Point p = q.poll();
			if (a[p.x][p.y] != 0) {
				int nx = p.x + a[p.x][p.y]; // �Ʒ���
				int ny = p.y + a[p.x][p.y]; // ����
				if (nx >= 0 && nx < N) { // �Ʒ��� �� �� ������
					q.add(new Point(nx, p.y));
					d[nx][p.y] += 1;
				}
				if (ny >= 0 && ny < N) { // ���������� �� �� ������
					q.add(new Point(p.x, ny));
					d[p.x][ny] += 1;
				}
			}
		}
		System.out.println(d[N-1][N-1]);
	}
}
class Point{
	int x;
	int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
/*

���� Ǯ��
�ð� ����	�޸� ����	����	����	���� ���	���� ����
1 ��	128 MB	8667	2508	1903	28.089%
����
N��N �����ǿ� ���� ������ �ִ�. �� ������ ��ǥ�� ���� ���� �� ĭ���� 
���� ������ �Ʒ� ĭ���� ��Ģ�� �°� ������ �ؼ� ���� ���̴�.

�� ĭ�� �����ִ� ���� ���� ĭ���� �� �� �ִ� �Ÿ��� �ǹ��Ѵ�. 
�ݵ�� �������̳� �Ʒ������θ� �̵��ؾ� �Ѵ�. 0�� �� �̻� ������ ���� �������̸�, 
�׻� ���� ĭ�� �����ִ� ����ŭ �������̳� �Ʒ��� ���� �Ѵ�.

���� ���� �� ĭ���� ���� ������ �Ʒ� ĭ���� ��Ģ�� �°� 
�̵��� �� �ִ� ����� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ���� ���� ũ�� N (4 �� N �� 100)�� �־�����. �� ���� N�� �ٿ��� 
�� ĭ�� ������ �ִ� ���� N���� �־�����. ĭ�� �����ִ� ����
 0���� ũ�ų� ����, 9���� �۰ų� ���� �����̸�,
  ���� ������ �Ʒ� ĭ���� �׻� 0�� �־�����.

���
���� ���� �� ĭ���� ���� ������ �Ʒ� ĭ���� ������ ��Ģ�� �°� �� �� �ִ� 
����� ������ ����Ѵ�. ����� ������ 263-1���� �۰ų� ����.


4
1 1 1 1
1 1 1 1
1 1 1 1
1 1 1 0

���� �Է� 
4
2 3 3 1
1 2 1 3
1 2 3 1
3 1 1 0
���� ��� 
3

*/