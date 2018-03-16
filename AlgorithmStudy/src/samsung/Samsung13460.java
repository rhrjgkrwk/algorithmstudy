package samsung;

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
				if (rnx>=0 && rny >= 0 && rnx<N && rny<N && miro[rnx][rny]=='.' && redVisit[rnx][rny] == 0) { //빨간구슬
					 { // 방문한 적이 없으면
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
								else { // 방문한 적이 있으면 최소값을 넣는다.
									if ((redVisit[rnx][rny] > redVisit[red.x][red.y] + 1)) { //
										redVisit[rnx][rny] = redVisit[red.x][red.y] + 1;
									}
								}
							} else
								break;
						}
					}

					if (bnx >= 0 && bny >= 0 && bnx < N && bny < N && miro[bnx][bny] == '.'
							&& blueVisit[bnx][bny] == 0) { // 파란구슬
						// 방문한 적이 없으면
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
								else { // 방문한 적이 있으면 최소값을 넣는다.
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
째로탈출 2 풀이
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	512 MB	7265	1580	963	21.971%
문제
요즘 한창 잘 나가고 있는 XH 주식회사에서는 어린이용 장난감을 주력 사업으로 밀고 있다. 
그 중 인기가 많은 제품은 역시 미로 탈출 게임인 째로탈출이다. 째로탈출은 다음 그림처럼, 미로 형태의 보드를 이용한 게임이다. 



째로탈출의 보드는 세로 N, 가로 M의 크기로 이뤄진 격자 형식으로 되어있다. 
가장 바깥의 행과 열은 모두 막혀 있다. 그림에는 없지만 째로탈출에는 빨간 구슬과 파란 구슬이 하나씩 들어있고, 
구멍이 하나 있다. 게임의 목적은 빨간 구슬을 구멍을 통해 빼내는 것이다. 이 때, 파란 구슬이 구멍에 들어가면 안된다.

물론 째로탈출 보드에는 투명한 아크릴판이 덮여있어서 직접 빼내는 것은 불가능하고, 
중력을 이용해 이리저리 굴리면서 빼내게 된다. 플레이어가 할 수 있는 동작은 다음과 같이 네 종류가 있다. 
왼쪽으로 기울이기, 오른쪽으로 기울이기, 위쪽으로 기울이기, 아래쪽으로 기울이기.

각각의 동작에서 공은 동시에 움직이게 되며, 빨간 구슬이 구멍에 빠지면 성공이지만, 파란 구슬이 구멍에 빠지면 실패이다. 
빨간 구슬과 파란 구슬이 동시에 구멍에 빠져도 실패이다. 빨간 구슬과 파란 구슬은 동시에 같은 칸에 있을 수 없다. 
또, 빨간 구슬과 파란 구슬의 크기는 격자의 한 칸을 모두 차지한다. 

기울이는 동작을 그만하는 것은 더 이상 구슬이 움직이지 않을 때 까지이다.

보드의 상태가 주어졌을 때, 최소 몇 번 만에 빨간 구슬을 구멍을 통해 빼낼 수 있는지 구하는 프로그램을 작성하시오.

입력
첫 번째 줄에는 보드의 세로/가로 크기를 의미하는 두 정수 N, M (3 ≤ N, M ≤ 10)이 주어진다. 다음 N개의 줄에 보드의 모양을 나타내는 길이 M의 문자열이 주어진다. 이 문자열은 '.', '#', 'O', 'R', 'B' 로만으로 이루어져 있다. '.'은 빈 칸을 의미하고, '#'은 공이 이동할 수 없는 장애물 또는 벽을 의미하며, 'O'는 구멍의 위치를 의미한다. 'R'은 빨간 구슬의 위치, 'B'는 파란 구슬의 위치이다.

입력되는 모든 보드의 가장자리에는 모두 '#'이 있다. 구멍의 개수는 한 개 이며, 빨간 구슬과 파란 구슬은 항상 1개가 주어진다.

출력
최소 몇 번 만에 빨간 구슬을 구멍을 통해 빼낼 수 있는지 출력한다. 만약, 10번 이하로 움직여서 빨간 구슬을 구멍을 통해 빼낼 수 없으면 -1을 출력한다.

예제 입력 
5 5
#####
#..B#
#.#.#
#RO.#
#####
예제 출력 
1
예제 입력 2 
7 7
#######
#...RB#
#.#####
#.....#
#####.#
#O....#
#######
예제 출력 2 
5
예제 입력 3 
7 7
#######
#..R#B#
#.#####
#.....#
#####.#
#O....#
#######
예제 출력 3 
5
예제 입력 4 
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
예제 출력 4 
-1
예제 입력 5 
3 7
#######
#R.O.B#
#######
예제 출력 5 
1
예제 입력 6 
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
예제 출력 6 
7
예제 입력 7 
3 10
##########
#.O....RB#
##########
예제 출력 7 
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

최대 10번 까지 보드를 조작할 수 있으므로, BFS 탐색을 이용하면 각 상태 공간에서 상하좌우 4방향으로 전이 가능 하고, 한 상태 공간에서 해당 방향으로 최대 max(N,M) 만큼 이동할 수 있으므로 O(410max(N,M)) 임을 알 수 있다. 따라서 각 상태 공간 내에서 한 방향으로 이동 할 때

1. 빨간 구슬과 파란 구슬이 일직선 상에 없음

1.1) 빨간 구슬이 가는 길에 구멍이 있는 경우 --> 탈출 성공

1.2) 파란 구슬이 가는 길에 구멍이 있는 경우 --> 탈출 실패

1.3) 구멍이 없는 경우 --> 구슬들을 최대한 이동한 후 큐에 push

2. 빨간 구슬이 가는 길에 파란 구슬이 있는 경우

2.1) 파란 구슬 앞에 구멍이 있는 경우 --> 탈출 성공

2.2) 파란 구슬 뒤에 구멍이 있는 경우 --> 탈출 실패

2.3) 구멍이 없는 경우 --> 파란 구슬은 최대한 이동, 빨간 구슬은 한 칸 덜 이동한 후에 큐에 push

3. 파란 구슬이 가는 길에 빨간 구슬이 있는 경우

3.1) 구멍이 있는 경우 --> 탈출 실패

3.2) 구멍이 없는 경우 --> 빨간 구슬은 최대한 이동, 파란 구슬은 한 칸 덜 이동한 후에 큐에 push

위의 과정을 bfs 각 상태 공간마다 시행하고 깊이가 10이 되면 종료하게 구현하면 된다.*/
