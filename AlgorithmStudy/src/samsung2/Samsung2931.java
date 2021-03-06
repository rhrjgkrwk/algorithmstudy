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
	public static int dy[] = {0,1,0,-1}; //0 ? ?€ ? ?Ό.?
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
	public static boolean curdir[][] = new boolean[4][7]; //????λ‘? -|+1234
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
					zq.add(new Pos(i, j)); // μ΄κΈ° λ°©ν₯?? ? ? ??Όλ―?λ‘? -1λ‘? μ£Όμ.
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

	public static void bfs(Queue<Pos> q, ArrayList<Pos> zm) { // z? z? m?? m?

		while (!q.isEmpty()) {
			Pos p = q.poll();
			if (p.dir < 0) { // ?? ? ?΄κ±°λ κ°? ? ?? κ³³μ΄ ??Όλ©?.
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
				if (p.dir<0) { //?Έ? ? ?΅λ‘κ? ??? ??Όλ©? Z?? M?΄ ?΅λ‘ν?λ₯? ?κ³? ?¨?΄? Έ?? κ²½μ°?΄λ―?λ‘?.
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
			if (nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] != '.') { // ???
													// ?΅λ‘μ΄λ©?.
				Pos np = new Pos(nx, ny);
				if (map[nx][ny] == '-') {
					np.dir = direction;
				} else if (map[nx][ny] == '|') {
					np.dir = direction;
				} // ? ?κ°?μ§? κ²½μ°? κΈ°μ‘΄ λ°©ν₯ ? μ§?.

				else if (map[nx][ny] == '+') {
					np.dir = direction;
					// np.dir.add((4+direction+1)%4); //κΈ°μ‘΄ μ§ν λ°©ν₯ + ?Όμͺ? ?€λ₯Έμͺ½
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
			} else if (nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] == '.') { // ?΅λ‘κ?
																						// ?κ²¨μ?
																						// κ²½μ°
				Pos destoyed = new Pos(nx, ny);
				destoyed.dir = direction;
				zm.add(destoyed); // ?κΈ? λ°©ν₯? μ€μ??€.
			}
		}
	}
	public static Pos whatIsErased(){
		//?¬κΈ°μ arr z,m? λΉκ΅?΄? ?ΌμΉν? κ³³μ μΆλ ₯??€.
		//
		Pos res = new Pos();
		for (Pos zp : z) {
			for (Pos mp : m) {
				
				if (zp.x == mp.x && zp.y == mp.y) {
					//System.out.println(zp.dir+" "+mp.dir);
					res.x = zp.x;
					res.y = zp.y;
					if ((zp.dir == 2 && mp.dir == 0) || (zp.dir == 0 && mp.dir == 2)) {
						//???
						res.pipe = '|';
					}
					else if ((zp.dir == 1 && mp.dir == 3) || (zp.dir == 3 && mp.dir == 1)) {
						//?Ό?€λ₯?
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
μ§λ¬Έ κ²??
κ°??€κ΄? ???΄
?κ°? ? ?	λ©λͺ¨λ¦? ? ?	? μΆ?	? ?΅	λ§μ? ?¬?	? ?΅ λΉμ¨
1 μ΄?	128 MB	805	98	76	22.287%
λ¬Έμ 
?¬?? κ°??€λ₯? ?¬λ‘μ?°?λ‘? ?΄λ°νκΈ? ??΄ ?κ·Έλ λΈμ? λͺ¨μ€μ½λ°? ??΄??Ό?Έ? ???Έ?κ³? ??€. ? ?¬??? ?€?  ???Έ? ?κΈ? ? ? ??΄? λ§€λ? κ²μ? ?΄?©?΄? ?€κ³λ?? ?΄λ³΄λ €κ³? ??€.

?΄ κ²μ?? ? ?½?? R? C?΄λ‘? ???΄? Έ ??€. κ°? μΉΈμ? λΉμ΄?κ±°λ, ?? κ·Έλ¦Όκ³? κ°μ? ?Όκ³±κ?μ§? κΈ°λ³Έ λΈλ­?Όλ‘? ?΄λ£¨μ΄? Έ ??€.

3 4
14Z.
2+3.
.2.M



κ°??€? λͺ¨μ€?¬λ°μ? ?κ·Έλ λΈλ‘ ?λ₯Έλ€. κ°??€? λΉλ© λΈλ­? ?΅?΄ ?λ°©ν₯?Όλ‘? ?λ₯? ? ??€. '+'? ?Ήλ³ν λΈλ­?Όλ‘?, ? λ°©ν₯ (?μ§?, ??)?Όλ‘? ?λ₯? ? ??€. ?? ?? λ₯? μ°Έκ³ ??€.



??΄? ?Ό?Έ? ?€κ³λ?? λ§μΉ ? ? ?¬??? ? ? ???? λ¨ΉμΌ?¬ κ°λ€. κ·? ?¬?΄ ?΄μ»€κ? μΉ¨μ?΄ λΈλ­ ??λ₯? μ§?? ?€. μ§??΄ λΈλ­?? λΉ? μΉΈμ΄ ??΄??€.

?΄μ»€κ? ?΄?€ μΉΈμ μ§??κ³?, κ·? μΉΈμ? ?? ?΄?€ λΈλ­?΄ ???μ§? κ΅¬ν? ?λ‘κ·Έ?¨? ??±???€.

?? ₯
μ²«μ§Έ μ€μ ? ?½? ?¬κΈ? Rκ³? Cκ°? μ£Όμ΄μ§λ€. (1 ?€ R, C ?€ 25)

?€? Rκ°? μ€μ? Cκ°? κΈ??κ°? μ£Όμ΄μ§?λ©?, ?€?κ³? κ°μ? κΈ??λ‘? ?΄λ£¨μ΄? Έ ??€.

λΉμΉΈ? ????΄? '.'
λΈλ­? ????΄? '|'(??€?€ 124), '-','+','1','2','3','4'
λͺ¨μ€?¬λ°μ ?μΉλ?? ????΄? 'M'κ³? ?κ·Έλ λΈλ?? ????΄? 'Z'. ? κΈ??? ? λ²λ§ μ£Όμ΄μ§λ€.
?­? ?΅?΄ μ‘΄μ¬?κ³?, κ°??€? ?λ¦μ΄ ? ?Ό? κ²½μ°λ§? ?? ₯?Όλ‘? μ£Όμ΄μ§?λ©?, λͺ¨μ€?¬λ°μ? ?κ·Έλ λΈμ? ?Έ? ? λΈλ­? ?? ???΄?€. ?, λΆν?? λΈλ­?΄ μ‘΄μ¬?μ§? ???€. μ¦?, ??΄μ§? λΈλ­? μΆκ??λ©?, λͺ¨λ  λΈλ­? κ°??€κ°? ?λ₯΄κ² ??€.

μΆλ ₯
μ§??μ§? λΈλ­? ?κ³? ?΄ ?μΉλ?? μΆλ ₯?κ³?, ?΄?€ λΈλ­?΄??μ§?λ₯? μΆλ ₯??€.

??  ?? ₯ 1 
3 7
.......
.M-.-Z.
.......
??  μΆλ ₯ 1 
2 4 -
??  ?? ₯ 2 
3 5
..1-M
1-+..
Z.23.
??  μΆλ ₯ 2 
2 4 4
??  ?? ₯ 3 
6 10
Z.1----4..
|.|....|..
|..14..M..
2-+++4....
..2323....
..........
??  μΆλ ₯ 3 
3 3 |
*/