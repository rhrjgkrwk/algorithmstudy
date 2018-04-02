package samsung2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos{
	int x;
	int y;
	int dir = -1;
	char pipe;
	public Pos() {
		// TODO Auto-generated constructor stub
	}
	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}

public class Samsung2931 {
	public static int dy[] = {0,1,0,-1}; //0 ?�� ?�� ?�� ?��.?��
	public static int dx[] = {-1,0,1,0};
	public static int R;
	public static int C;
	public static int dirZ = -1;
	public static int dirM = -1;
	public static char[][] map;
	public static ArrayList<Pos> z = new ArrayList<>();
	public static ArrayList<Pos> m = new ArrayList<>();
	public static Queue<Pos> zq = new LinkedList<>();
	public static Queue<Pos> mq = new LinkedList<>();
	public static boolean curdir[][] = new boolean[4][7]; //?��?��??�? -|+1234
	public static String d = "-|+1234";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Queue<Pos> zq = new LinkedList<>();
		Queue<Pos> mq = new LinkedList<>();
		curdir[0][1] = true; curdir[0][2] = true; curdir[0][3] = true; curdir[0][6] = true;
		curdir[1][0] = true; curdir[1][2] = true; curdir[1][5] = true; curdir[1][6] = true;
		curdir[2][1] = true; curdir[2][2] = true; curdir[2][4] = true; curdir[2][5] = true;
		curdir[3][0] = true; curdir[3][2] = true; curdir[3][3] = true; curdir[3][4] = true;
		
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'Z') {
					zq.add(new Pos(i, j)); // 초기 방향?? ?�� ?�� ?��?���?�? -1�? 주자.
				} else if (map[i][j] == 'M') {
					mq.add(new Pos(i, j));
				}
			}
		}
		bfs(zq, z);
		bfs(mq, m);
		Pos result = whatIsErased();
		System.out.println((result.x+1)+" "+(result.y+1)+" "+result.pipe);
	}

	public static void bfs(Queue<Pos> q, ArrayList<Pos> zm) { // z?�� z?�� m?? m?��

		while (!q.isEmpty()) {
			Pos p = q.poll();
			if (p.dir < 0) { // ?��?�� ?��?��거나 �? ?�� ?��?�� 곳이 ?��?���?.
				for (int i = 0; i < 4; i++) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];
					if (nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] != '.' && map[nx][ny] != 'Z' && map[nx][ny] != 'M') {
						int tmp = d.indexOf(map[nx][ny]);
						if (curdir[i][tmp]) {
							p.dir = i;
						}
					}
				}
				if (p.dir<0) { //?��?��?�� ?��로�? ?��?��?�� ?��?���? Z?? M?�� ?��로하?���? ?���? ?��?��?��?��?�� 경우?���?�?.
					for (int i = 0; i < 4; i++) {
						int nx = p.x + dx[i];
						int ny = p.y + dy[i];
						if (nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] == '.') {
							Pos destoyed = new Pos(nx, ny);
							destoyed.dir = i;
							zm.add(destoyed);
						}
					}
					break;
				}
			}
			int direction = p.dir;
			int nx = p.x + dx[direction];
			int ny = p.y + dy[direction];
			if (nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] != '.') { // ?��?��?��
													// ?��로이�?.
				Pos np = new Pos(nx, ny);
				if (map[nx][ny] == '-') {
					np.dir = direction;
				} else if (map[nx][ny] == '|') {
					np.dir = direction;
				} // ?�� ?���?�? 경우?�� 기존 방향 ?���?.

				else if (map[nx][ny] == '+') {
					np.dir = direction;
					// np.dir.add((4+direction+1)%4); //기존 진행 방향 + ?���? ?��른쪽
					// np.dir.add((4+direction-1)%4);
				} else if (map[nx][ny] == '1') {
					if (direction == 3) {
						np.dir = (4 + direction - 1) % 4;
					} else if (direction == 0) {
						np.dir = (4 + direction + 1) % 4;
					}
				} else if (map[nx][ny] == '2') {
					if (direction == 2) {
						np.dir = (4 + direction - 1) % 4;
					} else if (direction == 3) {
						np.dir = (4 + direction + 1) % 4;
					}
				} else if (map[nx][ny] == '3') {
					if (direction == 2) {
						np.dir = (4 + direction + 1) % 4;
					} else if (direction == 1) {
						np.dir = (4 + direction - 1) % 4;
					}
				} else if (map[nx][ny] == '4') {
					if (direction == 1) {
						np.dir = (4 + direction + 1) % 4;
					} else if (direction == 0) {
						np.dir = (4 + direction - 1) % 4;
					}
				}
				q.add(np);
			} else if (nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] == '.') { // ?��로�?
																						// ?��겨있?��
																						// 경우
				Pos destoyed = new Pos(nx, ny);
				destoyed.dir = direction;
				zm.add(destoyed); // ?���? 방향?�� 중요?��?��.
			}
		}
	}
	public static Pos whatIsErased(){
		//?��기서 arr z,m?�� 비교?��?�� ?��치하?�� 곳을 출력?��?��.
		//
		Pos res = new Pos();
		for (Pos zp : z) {
			for (Pos mp : m) {
				
				if (zp.x == mp.x && zp.y == mp.y) {
					//System.out.println(zp.dir+" "+mp.dir);
					res.x = zp.x;
					res.y = zp.y;
					if ((zp.dir == 2 && mp.dir == 0) || (zp.dir == 0 && mp.dir == 2)) {
						//?��?��?��
						res.pipe = '|';
					}
					else if ((zp.dir == 1 && mp.dir == 3) || (zp.dir == 3 && mp.dir == 1)) {
						//?��?���?
						res.pipe = '-';
					}
					else if ((zp.dir == 0 && mp.dir == 3) || (zp.dir == 3 && mp.dir == 0)) {
						res.pipe = '1';
					}
					else if ((zp.dir == 2 && mp.dir == 3) || (zp.dir == 3 && mp.dir == 2)) {
						res.pipe = '2';
					}
					else if ((zp.dir == 2 && mp.dir == 1) || (zp.dir == 1 && mp.dir == 2)) {
						res.pipe = '3';
					}
					else if ((zp.dir == 1 && mp.dir == 0) || (zp.dir == 0 && mp.dir == 1)) {
						res.pipe = '4';
					}
				}
			}
		}
		return res;
	}
}	

/*
질문 �??��
�??���? ???��
?���? ?��?��	메모�? ?��?��	?���?	?��?��	맞�? ?��?��	?��?�� 비율
1 �?	128 MB	805	98	76	22.287%
문제
?��?��?�� �??���? ?��로아?��?���? ?��반하�? ?��?�� ?��그레브�? 모스코바?�� ?��?��?��?��?��?�� ?��?��?��?���? ?��?��. ?�� ?��?��?? ?��?�� ?��?��?��?�� ?���? ?��?�� ?��?��?�� 매니?�� 게임?�� ?��?��?��?�� ?��계�?? ?��보려�? ?��?��.

?�� 게임?��?�� ?��?��?? R?�� C?���? ?��?��?��?�� ?��?��. �? 칸�? 비어?��거나, ?��?�� 그림�? 같�? ?��곱�?�? 기본 블럭?���? ?��루어?�� ?��?��.

3 4
14Z.
2+3.
.2.M



�??��?�� 모스?��바에?�� ?��그레브로 ?��른다. �??��?�� 빌딩 블럭?�� ?��?�� ?��방향?���? ?���? ?�� ?��?��. '+'?�� ?��별한 블럭?���?, ?�� 방향 (?���?, ?��?��)?���? ?���? ?�� ?��?��. ?��?�� ?��?���? 참고?��?��.



?��?��?�� ?��?��?�� ?��계�?? 마친 ?�� ?�� ?��?��?? ?��?�� ???��?�� 먹으?�� 갔다. �? ?��?�� ?��커�? 침임?�� 블럭 ?��?���? �??��?��. �??�� 블럭?? �? 칸이 ?��?��?��?��.

?��커�? ?��?�� 칸을 �??���?, �? 칸에?�� ?��?�� ?��?�� 블럭?�� ?��?��?���? 구하?�� ?��로그?��?�� ?��?��?��?��?��.

?��?��
첫째 줄에 ?��?��?�� ?���? R�? C�? 주어진다. (1 ?�� R, C ?�� 25)

?��?�� R�? 줄에?�� C�? �??���? 주어�?�?, ?��?���? 같�? �??���? ?��루어?�� ?��?��.

빈칸?�� ?��???��?�� '.'
블럭?�� ?��???��?�� '|'(?��?��?�� 124), '-','+','1','2','3','4'
모스?��바의 ?��치�?? ?��???��?�� 'M'�? ?��그레브�?? ?��???��?�� 'Z'. ?�� �??��?�� ?�� 번만 주어진다.
?��?�� ?��?�� 존재?���?, �??��?�� ?��름이 ?��?��?�� 경우�? ?��?��?���? 주어�?�?, 모스?��바�? ?��그레브�? ?��?��?�� 블럭?�� ?��?�� ?��?��?��?��. ?��, 불필?��?�� 블럭?�� 존재?���? ?��?��?��. �?, ?��?���? 블럭?�� 추�??���?, 모든 블럭?�� �??���? ?��르게 ?��?��.

출력
�??���? 블럭?�� ?���? ?�� ?��치�?? 출력?���?, ?��?�� 블럭?��?��?���?�? 출력?��?��.

?��?�� ?��?�� 1 
3 7
.......
.M-.-Z.
.......
?��?�� 출력 1 
2 4 -
?��?�� ?��?�� 2 
3 5
..1-M
1-+..
Z.23.
?��?�� 출력 2 
2 4 4
?��?�� ?��?�� 3 
6 10
Z.1----4..
|.|....|..
|..14..M..
2-+++4....
..2323....
..........
?��?�� 출력 3 
3 3 |
*/