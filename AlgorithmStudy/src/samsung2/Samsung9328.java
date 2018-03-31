package samsung2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point9328{
	int x;
	int y;
	public Point9328(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}
public class Samsung9328 {
	public static int dx[] = {0,0,-1,1};
	public static int dy[] = {1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int testCase = 0; testCase < tc; testCase++) {
			//입
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			
			char [][] map = new char[h][w];
			boolean [][] visit;
			
			
			for (int i = 0; i < h; i++) {
				map[i] = br.readLine().toCharArray();
			}
			String myKeys = br.readLine(); //보유한 키를 입력받는다.
			
			
			boolean flag = true; //bfs 탐색 중간에 열쇠를 먹으면 true; 
			int documents = 0; //훔친 문서를 담는다. res
			
			
			while (flag) {
				flag = false;
				visit = new boolean[h][w];
				Queue<Point9328> q = new LinkedList<>();
				//초기점을 찾자.
				for (int i = 0; i < h; i++) {
					for (int j = 0; j < w; j++) {
						if (i==0 || i == h-1 || j ==0 || j == w-1) { //외곽에 있는 점들을 찾는다.
							//문일때
							if (map[i][j] >= 'A' && map[i][j] <= 'Z') {
								//키를 가지고 있으면 문이 열리므로 출발점이 될 수 있다. 
								if (myKeys.contains(String.valueOf(map[i][j]).toLowerCase())) {
									q.add(new Point9328(i, j));
								}
								//아니면 걍 냅둔다.
							}
							//통로일때  
							else if (map[i][j]=='.') {
								q.add(new Point9328(i, j));
							}
							//열쇠일때 
							else if (map[i][j] >= 'a' && map[i][j] <= 'z') {
								if (!myKeys.contains(String.valueOf(map[i][j]))) {
									myKeys+=map[i][j]; //보유하지 않은 키이면 키를 추가한다.
								}
								map[i][j] = '.';
								flag = true;
								q.add(new Point9328(i, j));
							}
							else if (map[i][j] == '$') { //문서일때.
								map[i][j] = '.';
								documents++;
								q.add(new Point9328(i, j));
							}
						}
					}
				}
				
				
				
				//중간에 열쇠를 먹으면 다시 탐색해야됨....... ㅠㅠ
				while (!q.isEmpty()) {
					Point9328 now = q.poll();
					visit[now.x][now.y] = true;
//					System.out.println("================");
//					for (int i = 0; i < h; i++) {
//						for (int j = 0; j < w; j++) {
//							if (i==now.x && j == now.y) System.out.print("^"); 
//							else System.out.print(map[i][j]);
//						}System.out.println();
//					}
					
					
					
					
					for (int i = 0; i < 4; i++) {
						int nx = now.x + dx[i];
						int ny = now.y + dy[i];
						if (nx>=0 && nx<h && ny>=0 && ny<w && !visit[nx][ny] && map[nx][ny]!='*') {
							//탐색하면서 갈수 있는곳이나 열쇠는 통로로 바꾸어준다.
							if (map[nx][ny] >= 'a' && map[nx][ny] <= 'z') { //열쇠면 전체 루프를 한번 더 돌릴거다.. 
								if (!myKeys.contains(String.valueOf(map[nx][ny]))) {
									myKeys+=map[nx][ny]; //보유하지 않은 키이면 키를 추가한다.
								}
								flag = true;
								map[nx][ny] = '.';
								q.add(new Point9328(nx, ny));
								visit[nx][ny] = true;
							}
							else if (map[nx][ny] >= 'A' && map[nx][ny] <= 'Z') { //문이고  
								if (myKeys.contains(String.valueOf(map[nx][ny]).toLowerCase())) { //열수 ㅇ있으면..
									map[nx][ny] = '.';
									q.add(new Point9328(nx, ny));
									visit[nx][ny] = true;
								}
								//못열면 걍 냅둔다..
							}
							else if (map[nx][ny]=='$') { //문서이면 먹고 통로로 바꾼다..
								map[nx][ny] = '.';
								documents++;
								q.add(new Point9328(nx, ny));
								visit[nx][ny] = true;
							}
							else {
								q.add(new Point9328(nx, ny));
								visit[nx][ny] = true;
							}
							
						}
					}
				}
			}
			System.out.println(documents);
		}
		br.close();
	}
}


/*
열쇠 풀이
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	3395	689	419	18.589%
문제
상근이는 1층 빌딩에 침입해 매우 중요한 문서를 훔쳐오려고 한다. 상근이가 가지고 있는 평면도에는 문서의 위치가 모두 나타나 있다. 빌딩의 문은 모두 잠겨있기 때문에, 문을 열려면 열쇠가 필요하다. 상근이는 일부 열쇠를 이미 가지고 있고, 일부 열쇠는 빌딩의 바닥에 놓여져 있다.

상근이가 훔칠 수 있는 문서의 최대 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수가 주어진다. 테스트 케이스의 수는 100개를 넘지 않는다.

각 테스트 케이스의 첫째 줄에는 지도의 높이와 너비 h와 w (2 ≤ h, w ≤ 100)가 주어진다. 다음 h개 줄에는 빌딩을 나타내는 w개의 문자가 주어지며, 각 문자는 다음 중 하나이다.

'.'는 빈 공간을 나타낸다.
'*'는 벽을 나타내며, 상근이는 벽을 통과할 수 없다.
'$'는 상근이가 훔쳐야하는 문서이다.
알파벳 대문자는 문을 나타낸다.
알파벳 소문자는 열쇠를 나타내며, 그 문자의 대문자인 모든 문을 열 수 있다.
마지막 줄에는 상근이가 이미 가지고 있는 열쇠가 공백없이 주어진다. 만약, 열쇠를 하나도 가지고 있지 않는 경우에는 "0"이 주어진다.

상근이는 빌딩 밖으로 나갈 수 있다. 각각의 문에 대해서, 그 문을 열 수 잇는 열쇠의 개수는 0개, 1개, 또는 그 이상이고, 각각의 열쇠에 대해서, 그 열쇠로 열 수 있는 문의 개수도 0개, 1개, 또는 그 이상이다. 열쇠는 여러 번 사용할 수 있다.

출력
각 테스트 케이스 마다, 상근이가 훔칠 수 있는 문서의 최대 개수를 출력한다.

예제 입력 1 
3
5 17
*****************
.............**$*
*B*A*P*C**X*Y*.X.
*y*x*a*p**$*$**$*
*****************
cz
5 11
*.*********
*...*...*x*
*X*.*.*.*.*
*$*...*...*
***********
0
7 7
*ABCDE*
X.....F
W.$$$.G
V.$$$.H
U.$$$.J
T.....K
*SQPML*
irony
예제 출력 1 
3
1
0
*/