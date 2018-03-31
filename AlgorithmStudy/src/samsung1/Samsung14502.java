package samsung1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point14502 {
	int x;
	int y;

	public Point14502(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Samsung14502 {
	public static int N;
	public static int M;
	public static int map[][];
	public static int dx[] = { 0, 0, 1, -1 };
	public static int dy[] = { -1, 1, 0, 0 };
	public static ArrayList<Point14502> blank = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		// �Է�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		Queue<Point14502> tmpQ = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int j = 0;
			while (st.hasMoreTokens()) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) tmpQ.add(new Point14502(i, j)); // ���̷����� ��ġ�� ������ �ִ´�.
				if (map[i][j] == 0) blank.add(new Point14502(i, j)); // ������ ��ġ�� ��¢����.
				j++;
			}
		}
		int max = 0;
		for (int i = 0; i < blank.size()-2; i++) {
			for (int j = i+1; j < blank.size()-1; j++) {
				for (int k = j+1; k < blank.size(); k++) {
					Queue<Point14502> q = new LinkedList<>(tmpQ); //ť�ʱ�ȭ. ���̷����� ��ġ�� ����.
					int [][]tmp = new int[N][M];
					boolean visit[][] = new boolean[N][M];
					for (int l = 0; l < N; l++) {
						for (int l2 = 0; l2 < M; l2++) {
							tmp[l][l2] = map[l][l2];
							visit[l][l2] = false;
						}
					}
					
					tmp[blank.get(i).x][blank.get(i).y] = 1;
					tmp[blank.get(j).x][blank.get(j).y] = 1;
					tmp[blank.get(k).x][blank.get(k).y] = 1;
					
					
					int count = 0; // 2�� ����.
					///////////BFS///////////
					while (!q.isEmpty()) {
						Point14502 p = q.peek();
						q.poll();
						 //���̷����� ���� ����.
						for (int direction = 0; direction < 4; direction++) {
							int nx = p.x + dx[direction];
							int ny = p.y + dy[direction];
							if (nx >= 0 && ny >= 0 && nx < N && ny < M && tmp[nx][ny] == 0 && visit[nx][ny]==false) {
								tmp[nx][ny] = 2;
								visit[nx][ny] = true;
								q.add(new Point14502(nx, ny));
							}
						}
					}
					for (int l = 0; l < N; l++) {
						for (int l2 = 0; l2 < M; l2++) {
							if (tmp[l][l2]==0) {
								count++;
							}
						}
					}
					//max chk
					if (count>max) { 
						max = count;
					}
				}
			}
		}
		System.out.println(max);
		br.close();
	}
}


/*
14502��

���� �Է� 
7 7
2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0
���� ��� 
27
���� �Է� 2 
4 6
0 0 0 0 0 0
1 0 0 0 0 2
1 1 1 0 0 2
0 0 0 0 0 2
���� ��� 2 
9
���� �Է� 3 
8 8
2 0 0 0 0 0 0 2
2 0 0 0 0 0 0 2
2 0 0 0 0 0 0 2
2 0 0 0 0 0 0 2
2 0 0 0 0 0 0 2
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
���� ��� 3 
3

for (int l = 0; l < N; l++) {
						for (int l2 = 0; l2 < M; l2++) {
							System.out.print(tmp[l][l2]+" ");
						}System.out.println();
					}

������ Ǯ��
�ð� ����	�޸� ����	����	����	���� ���	���� ����
2 ��	512 MB	3659	1997	1333	55.472%
����
��ü�� ġ������ ���̷����� �����ϴ� �����ҿ��� ���̷����� ����Ǿ���. ������ ���̷����� ���� ������ �ʾҰ�, ���̷����� Ȯ���� ���� ���ؼ� �����ҿ� ���� ������� �Ѵ�.

�����Ҵ� ũ�Ⱑ N��M�� ���簢������ ��Ÿ�� �� ������, ���簢���� 1��1 ũ���� ���簢������ �������� �ִ�. �����Ҵ� �� ĭ, ������ �̷���� ������, ���� ĭ �ϳ��� ���� �����Ѵ�. 

�Ϻ� ĭ�� ���̷����� �����ϸ�, �� ���̷����� ������ �� ĭ���� ��� �������� �� �ִ�. ���� ���� �� �ִ� ���� ������ 3���̸�, �� 3���� ������ �Ѵ�.

���� ���, �Ʒ��� ���� �����Ұ� ���� ��츦 ���캸��.

2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0
�� ��, 0�� �� ĭ, 1�� ��, 2�� ���̷����� �ִ� ���̴�. �ƹ��� ���� ������ �ʴ´ٸ�, ���̷����� ��� �� ĭ���� �������� �� �ִ�.

2�� 1��, 1�� 2��, 4�� 6���� ���� ����ٸ� ������ ����� �Ʒ��� �������� �ȴ�.

2 1 0 0 1 1 0
1 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 1 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0
���̷����� ���� ���� ����� �Ʒ��� ��������.

2 1 0 0 1 1 2
1 0 1 0 1 2 2
0 1 1 0 1 2 2
0 1 0 0 0 1 2
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0
���� 3�� ���� ��, ���̷����� ���� �� ���� ���� ���� �����̶�� �Ѵ�. ���� �������� ���� ������ ũ��� 27�̴�.

�������� ������ �־����� �� ���� �� �ִ� ���� ���� ũ���� �ִ밪�� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ������ ���� ũ�� N�� ���� ũ�� M�� �־�����. (3 �� N, M �� 8)

��° �ٺ��� N���� �ٿ� ������ ����� �־�����. 0�� �� ĭ, 1�� ��, 2�� ���̷����� �ִ� ��ġ�̴�. 2�� ������ 2���� ũ�ų� ����, 10���� �۰ų� ���� �ڿ����̴�.

�� ĭ�� ������ 3�� �̻��̴�.

���
ù° �ٿ� ���� �� �ִ� ���� ������ �ִ� ũ�⸦ ����Ѵ�.


*/