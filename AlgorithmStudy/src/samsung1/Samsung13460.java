package samsung1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
	int x;
	int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Samsung13460 {
	public static char[][] miro;
	public static int[][] redVisit;
	public static int[][] blueVisit;
	
	public static int N;
	public static int M;
	
	public static int []dx = {-1,1,0,0};
	public static int []dy = {0,0,1,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		miro = new char[N][M];
		redVisit = new int[N][M];
		blueVisit = new int[N][M];
		Point red = null;
		Point blue = null;
		Point hole = null;
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				miro[i][j] = str.charAt(j);
				if (miro[i][j]=='R') {
					red = new Point(i,j);
				} else if (miro[i][j]=='B') {
					blue = new Point(i,j);
				} else if (miro[i][j]=='O') {
					hole = new Point(i,j);
				}
			}
		}
		System.out.println(bfs(red, blue, hole));
	}
	
	public static int bfs(Point red, Point blue, Point hole){
		int min = Integer.MAX_VALUE;
		Queue<Point> rq = new LinkedList<>(); rq.add(red);
		Queue<Point> bq = new LinkedList<>(); bq.add(blue);
		while (!rq.isEmpty()) {
			
			red = rq.peek(); rq.poll();
			blue = bq.peek(); bq.poll();
			
			if (redVisit[hole.x][hole.y]>0) {
				
			}
			for (int i = 0; i < dx.length; i++) {
				int rnx = red.x + dx[i];
				int rny = red.y + dy[i];
				int bnx = blue.x + dx[i];
				int bny = blue.y + dy[i];
				boolean redHole = false;
				boolean blueHole = false;
				if (rnx>=0 && rny >= 0 && rnx<N && rny<N && miro[rnx][rny]=='.' && redVisit[rnx][rny] == 0) { //��������
					 { // �湮�� ���� ������
						redVisit[rnx][rny] = redVisit[red.x][red.y] + 1;
						while (true){
							if (hole.x == rnx && hole.y == rny) {
								redHole = true;
							}
							if (rnx + dx[i] >= 0 && rny + dy[i] >= 0 && rnx + dx[i] < N && rny + dy[i] < N
									&& miro[rnx + dx[i]][rny + dy[i]] == '.') {
								rnx = rnx + dx[i];
								rny = rny + dy[i];
								if (redVisit[rnx][rny] == 0)
									redVisit[rnx][rny] = redVisit[red.x][red.y];
								else { // �湮�� ���� ������ �ּҰ��� �ִ´�.
									if ((redVisit[rnx][rny] > redVisit[red.x][red.y] + 1)) { //
										redVisit[rnx][rny] = redVisit[red.x][red.y] + 1;
									}
								}
							} else
								break;
						}
					}

					if (bnx >= 0 && bny >= 0 && bnx < N && bny < N && miro[bnx][bny] == '.'
							&& blueVisit[bnx][bny] == 0) { // �Ķ�����
						// �湮�� ���� ������
						blueVisit[bnx][bny] = blueVisit[blue.x][blue.y] + 1;
						while (true) {
							if (hole.x == bnx && hole.y == bny) {
								blueHole = true;
								break;
							}
							if (bnx + dx[i] >= 0 && bny + dy[i] >= 0 && bnx + dx[i] < N && bny + dy[i] < N
									&& miro[bnx + dx[i]][bny + dy[i]] == '.') {
								bnx = bnx + dx[i];
								bny = bny + dy[i];
								if (blueVisit[bnx][bny] == 0)
									blueVisit[bnx][bny] = blueVisit[blue.x][blue.y];
								else { // �湮�� ���� ������ �ּҰ��� �ִ´�.
									if ((blueVisit[bnx][bny] > blueVisit[blue.x][blue.y] + 1)) { //
										blueVisit[bnx][bny] = blueVisit[blue.x][blue.y] + 1;
									}
								}
							} else
								break;
						}
					} else {
						bnx -= dx[i];
						bny -= dy[i];
					}
				}
				if (redHole) {
					if (!blueHole) {
						min = min > redVisit[rnx][rny] ? redVisit[rnx][rny] : min;
					}
				}
				bq.add(new Point(bnx, bny));
				rq.add(new Point(rnx, rny));
			}
			System.out.println("min : "+min);
			/*
			System.out.println("red");
			for (int j = 0; j < blueVisit.length; j++) {
				for (int j2 = 0; j2 < blueVisit[j].length; j2++) {
					System.out.print(redVisit[j][j2]+" ");
				}System.out.println();
			}
			
			System.out.println("blue");
			for (int j = 0; j < blueVisit.length; j++) {
				for (int j2 = 0; j2 < blueVisit[j].length; j2++) {
					System.out.print(blueVisit[j][j2]+" ");
				}System.out.println();
			}
			*/
			
			
		}
		return min;
	}
}

/*
°��Ż�� 2 Ǯ��
�ð� ����	�޸� ����	����	����	���� ���	���� ����
2 ��	512 MB	7265	1580	963	21.971%
����
���� ��â �� ������ �ִ� XH �ֽ�ȸ�翡���� ��̿� �峭���� �ַ� ������� �а� �ִ�. 
�� �� �αⰡ ���� ��ǰ�� ���� �̷� Ż�� ������ °��Ż���̴�. °��Ż���� ���� �׸�ó��, �̷� ������ ���带 �̿��� �����̴�. 



°��Ż���� ����� ���� N, ���� M�� ũ��� �̷��� ���� �������� �Ǿ��ִ�. 
���� �ٱ��� ��� ���� ��� ���� �ִ�. �׸����� ������ °��Ż�⿡�� ���� ������ �Ķ� ������ �ϳ��� ����ְ�, 
������ �ϳ� �ִ�. ������ ������ ���� ������ ������ ���� ������ ���̴�. �� ��, �Ķ� ������ ���ۿ� ���� �ȵȴ�.

���� °��Ż�� ���忡�� ������ ��ũ������ �����־ ���� ������ ���� �Ұ����ϰ�, 
�߷��� �̿��� �̸����� �����鼭 ������ �ȴ�. �÷��̾ �� �� �ִ� ������ ������ ���� �� ������ �ִ�. 
�������� ����̱�, ���������� ����̱�, �������� ����̱�, �Ʒ������� ����̱�.

������ ���ۿ��� ���� ���ÿ� �����̰� �Ǹ�, ���� ������ ���ۿ� ������ ����������, �Ķ� ������ ���ۿ� ������ �����̴�. 
���� ������ �Ķ� ������ ���ÿ� ���ۿ� ������ �����̴�. ���� ������ �Ķ� ������ ���ÿ� ���� ĭ�� ���� �� ����. 
��, ���� ������ �Ķ� ������ ũ��� ������ �� ĭ�� ��� �����Ѵ�. 

����̴� ������ �׸��ϴ� ���� �� �̻� ������ �������� ���� �� �����̴�.

������ ���°� �־����� ��, �ּ� �� �� ���� ���� ������ ������ ���� ���� �� �ִ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù ��° �ٿ��� ������ ����/���� ũ�⸦ �ǹ��ϴ� �� ���� N, M (3 �� N, M �� 10)�� �־�����. ���� N���� �ٿ� ������ ����� ��Ÿ���� ���� M�� ���ڿ��� �־�����. �� ���ڿ��� '.', '#', 'O', 'R', 'B' �θ����� �̷���� �ִ�. '.'�� �� ĭ�� �ǹ��ϰ�, '#'�� ���� �̵��� �� ���� ��ֹ� �Ǵ� ���� �ǹ��ϸ�, 'O'�� ������ ��ġ�� �ǹ��Ѵ�. 'R'�� ���� ������ ��ġ, 'B'�� �Ķ� ������ ��ġ�̴�.

�ԷµǴ� ��� ������ �����ڸ����� ��� '#'�� �ִ�. ������ ������ �� �� �̸�, ���� ������ �Ķ� ������ �׻� 1���� �־�����.

���
�ּ� �� �� ���� ���� ������ ������ ���� ���� �� �ִ��� ����Ѵ�. ����, 10�� ���Ϸ� �������� ���� ������ ������ ���� ���� �� ������ -1�� ����Ѵ�.

���� �Է� 
5 5
#####
#..B#
#.#.#
#RO.#
#####
���� ��� 
1
���� �Է� 2 
7 7
#######
#...RB#
#.#####
#.....#
#####.#
#O....#
#######
���� ��� 2 
5
���� �Է� 3 
7 7
#######
#..R#B#
#.#####
#.....#
#####.#
#O....#
#######
���� ��� 3 
5
���� �Է� 4 
10 10
##########
#R#...##B#
#...#.##.#
#####.##.#
#......#.#
#.######.#
#.#....#.#
#.#.#.#..#
#...#.O#.#
##########
���� ��� 4 
-1
���� �Է� 5 
3 7
#######
#R.O.B#
#######
���� ��� 5 
1
���� �Է� 6 
10 10
##########
#R#...##B#
#...#.##.#
#####.##.#
#......#.#
#.######.#
#.#....#.#
#.#.##...#
#O..#....#
##########
���� ��� 6 
7
���� �Է� 7 
3 10
##########
#.O....RB#
##########
���� ��� 7 
-1
*/


/*
#include <stdio.h>
#include <queue>
using namespace std;

const int dx[] = { -1,0,1,0 };
const int dy[] = { 0,-1,0,1 };

struct ABC { int cnt, rx, ry, bx, by; };
queue<ABC> que;

int n, m, rx, ry, bx, by;
bool chk[11][11][11][11];
char toy[12][12];

int main() {
	scanf("%d %d\n", &n, &m);
	for (int i = 0; i < n; i++) {
		scanf("%s", toy[i]);
		for (int j = 0; j < m; j++) {
			if (toy[i][j] == 'R') rx = i, ry = j;
			if (toy[i][j] == 'B') bx = i, by = j;
		}
	}

	chk[rx][ry][bx][by] = 1;
	que.push({ 0,rx,ry,bx,by });
	while (!que.empty()) {
		ABC now = que.front();
		que.pop();

		for (int i = 0; i < 4; i++) {
			int nrx = now.rx, nry = now.ry;
			int nbx = now.bx, nby = now.by;
			int cr = 0, cb = 0;

			while (toy[nrx + dx[i]][nry + dy[i]] != '#' && toy[nrx][nry] != 'O')
				nrx += dx[i], nry += dy[i], cr++;
			while (toy[nbx + dx[i]][nby + dy[i]] != '#' && toy[nbx][nby] != 'O')
				nbx += dx[i], nby += dy[i], cb++;

			if (nrx == nbx && nry == nby) {
				if (toy[nrx][nry] == 'O') continue;
				cr < cb ? (nbx-=dx[i],nby-=dy[i]) : (nrx-=dx[i],nry-=dy[i]);
			}

			if (toy[nbx][nby] == 'O') continue;
			if (toy[nrx][nry] == 'O') return ~printf("%d\n", now.cnt + 1);

			if (chk[nrx][nry][nbx][nby]) continue;
			if (now.cnt < 9) {
				chk[nrx][nry][nbx][nby] = 1;
				que.push({ now.cnt+1,nrx,nry,nbx,nby });
			}
		}
	}

	printf("-1\n");

	return 0;
}*/
/*

�ִ� 10�� ���� ���带 ������ �� �����Ƿ�, BFS Ž���� �̿��ϸ� �� ���� �������� �����¿� 4�������� ���� ���� �ϰ�, �� ���� �������� �ش� �������� �ִ� max(N,M) ��ŭ �̵��� �� �����Ƿ� O(410max(N,M)) ���� �� �� �ִ�. ���� �� ���� ���� ������ �� �������� �̵� �� ��

1. ���� ������ �Ķ� ������ ������ �� ����

1.1) ���� ������ ���� �濡 ������ �ִ� ��� --> Ż�� ����

1.2) �Ķ� ������ ���� �濡 ������ �ִ� ��� --> Ż�� ����

1.3) ������ ���� ��� --> �������� �ִ��� �̵��� �� ť�� push

2. ���� ������ ���� �濡 �Ķ� ������ �ִ� ���

2.1) �Ķ� ���� �տ� ������ �ִ� ��� --> Ż�� ����

2.2) �Ķ� ���� �ڿ� ������ �ִ� ��� --> Ż�� ����

2.3) ������ ���� ��� --> �Ķ� ������ �ִ��� �̵�, ���� ������ �� ĭ �� �̵��� �Ŀ� ť�� push

3. �Ķ� ������ ���� �濡 ���� ������ �ִ� ���

3.1) ������ �ִ� ��� --> Ż�� ����

3.2) ������ ���� ��� --> ���� ������ �ִ��� �̵�, �Ķ� ������ �� ĭ �� �̵��� �Ŀ� ť�� push

���� ������ bfs �� ���� �������� �����ϰ� ���̰� 10�� �Ǹ� �����ϰ� �����ϸ� �ȴ�.*/
