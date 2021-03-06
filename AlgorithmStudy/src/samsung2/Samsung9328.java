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
			//?
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			
			char [][] map = new char[h][w];
			boolean [][] visit;
			
			
			for (int i = 0; i < h; i++) {
				map[i] = br.readLine().toCharArray();
			}
			String myKeys = br.readLine(); //λ³΄μ ? ?€λ₯? ?? ₯λ°λ?€.
			
			
			boolean flag = true; //bfs ?? μ€κ°? ?΄? λ₯? λ¨ΉμΌλ©? true; 
			int documents = 0; //?μΉ? λ¬Έμλ₯? ?΄??€. res
			
			
			while (flag) {
				flag = false;
				visit = new boolean[h][w];
				Queue<Point9328> q = new LinkedList<>();
				//μ΄κΈ°? ? μ°Ύμ.
				for (int i = 0; i < h; i++) {
					for (int j = 0; j < w; j++) {
						if (i==0 || i == h-1 || j ==0 || j == w-1) { //?Έκ³½μ ?? ? ?€? μ°Ύλ?€.
							//λ¬ΈμΌ?
							if (map[i][j] >= 'A' && map[i][j] <= 'Z') {
								//?€λ₯? κ°?μ§?κ³? ??Όλ©? λ¬Έμ΄ ?΄λ¦¬λ?λ‘? μΆλ°? ?΄ ?  ? ??€. 
								if (myKeys.contains(String.valueOf(map[i][j]).toLowerCase())) {
									q.add(new Point9328(i, j));
								}
								//??λ©? κ±? ???€.
							}
							//?΅λ‘μΌ?  
							else if (map[i][j]=='.') {
								q.add(new Point9328(i, j));
							}
							//?΄? ?Ό? 
							else if (map[i][j] >= 'a' && map[i][j] <= 'z') {
								if (!myKeys.contains(String.valueOf(map[i][j]))) {
									myKeys+=map[i][j]; //λ³΄μ ?μ§? ??? ?€?΄λ©? ?€λ₯? μΆκ???€.
								}
								map[i][j] = '.';
								flag = true;
								q.add(new Point9328(i, j));
							}
							else if (map[i][j] == '$') { //λ¬Έμ?Ό?.
								map[i][j] = '.';
								documents++;
								q.add(new Point9328(i, j));
							}
						}
					}
				}
				
				
				
				//μ€κ°? ?΄? λ₯? λ¨ΉμΌλ©? ?€? ???΄?Ό?¨....... ? ? 
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
							//???λ©΄μ κ°μ ??κ³³μ΄? ?΄? ? ?΅λ‘λ‘ λ°κΎΈ?΄μ€??€.
							if (map[nx][ny] >= 'a' && map[nx][ny] <= 'z') { //?΄? λ©? ? μ²? λ£¨νλ₯? ?λ²? ? ?λ¦΄κ±°?€.. 
								if (!myKeys.contains(String.valueOf(map[nx][ny]))) {
									myKeys+=map[nx][ny]; //λ³΄μ ?μ§? ??? ?€?΄λ©? ?€λ₯? μΆκ???€.
								}
								flag = true;
								map[nx][ny] = '.';
								q.add(new Point9328(nx, ny));
								visit[nx][ny] = true;
							}
							else if (map[nx][ny] >= 'A' && map[nx][ny] <= 'Z') { //λ¬Έμ΄κ³?  
								if (myKeys.contains(String.valueOf(map[nx][ny]).toLowerCase())) { //?΄? ???Όλ©?..
									map[nx][ny] = '.';
									q.add(new Point9328(nx, ny));
									visit[nx][ny] = true;
								}
								//λͺ»μ΄λ©? κ±? ???€..
							}
							else if (map[nx][ny]=='$') { //λ¬Έμ?΄λ©? λ¨Ήκ³  ?΅λ‘λ‘ λ°κΎΌ?€..
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
?΄?  ???΄
?κ°? ? ?	λ©λͺ¨λ¦? ? ?	? μΆ?	? ?΅	λ§μ? ?¬?	? ?΅ λΉμ¨
1 μ΄?	128 MB	3395	689	419	18.589%
λ¬Έμ 
?κ·Όμ΄? 1μΈ? λΉλ©? μΉ¨μ?΄ λ§€μ° μ€μ? λ¬Έμλ₯? ?μ³μ€? €κ³? ??€. ?κ·Όμ΄κ°? κ°?μ§?κ³? ?? ?λ©΄λ?? λ¬Έμ? ?μΉκ? λͺ¨λ ???? ??€. λΉλ©? λ¬Έμ? λͺ¨λ ? κ²¨μκΈ? ?λ¬Έμ, λ¬Έμ ?΄? €λ©? ?΄? κ°? ????€. ?κ·Όμ΄? ?ΌλΆ? ?΄? λ₯? ?΄λ―? κ°?μ§?κ³? ?κ³?, ?ΌλΆ? ?΄? ? λΉλ©? λ°λ₯? ??¬? Έ ??€.

?κ·Όμ΄κ°? ?μΉ? ? ?? λ¬Έμ? μ΅λ? κ°μλ₯? κ΅¬ν? ?λ‘κ·Έ?¨? ??±???€.

?? ₯
μ²«μ§Έ μ€μ ??€?Έ μΌ??΄?€? κ°μκ°? μ£Όμ΄μ§λ€. ??€?Έ μΌ??΄?€? ?? 100κ°λ?? ?μ§? ???€.

κ°? ??€?Έ μΌ??΄?€? μ²«μ§Έ μ€μ? μ§??? ??΄?? ?λΉ? h?? w (2 ?€ h, w ?€ 100)κ°? μ£Όμ΄μ§λ€. ?€? hκ°? μ€μ? λΉλ©? ????΄? wκ°μ λ¬Έμκ°? μ£Όμ΄μ§?λ©?, κ°? λ¬Έμ? ?€? μ€? ???΄?€.

'.'? λΉ? κ³΅κ°? ????Έ?€.
'*'? λ²½μ ????΄λ©?, ?κ·Όμ΄? λ²½μ ?΅κ³Όν  ? ??€.
'$'? ?κ·Όμ΄κ°? ?μ³μΌ?? λ¬Έμ?΄?€.
??λ²? ??λ¬Έμ? λ¬Έμ ????Έ?€.
??λ²? ?λ¬Έμ? ?΄? λ₯? ????΄λ©?, κ·? λ¬Έμ? ??λ¬Έμ?Έ λͺ¨λ  λ¬Έμ ?΄ ? ??€.
λ§μ?λ§? μ€μ? ?κ·Όμ΄κ°? ?΄λ―? κ°?μ§?κ³? ?? ?΄? κ°? κ³΅λ°±??΄ μ£Όμ΄μ§λ€. λ§μ½, ?΄? λ₯? ??? κ°?μ§?κ³? ?μ§? ?? κ²½μ°?? "0"?΄ μ£Όμ΄μ§λ€.

?κ·Όμ΄? λΉλ© λ°μΌλ‘? ?κ°? ? ??€. κ°κ°? λ¬Έμ ???΄?, κ·? λ¬Έμ ?΄ ? ?? ?΄? ? κ°μ? 0κ°?, 1κ°?, ?? κ·? ?΄??΄κ³?, κ°κ°? ?΄? ? ???΄?, κ·? ?΄? λ‘? ?΄ ? ?? λ¬Έμ κ°μ? 0κ°?, 1κ°?, ?? κ·? ?΄??΄?€. ?΄? ? ?¬?¬ λ²? ?¬?©?  ? ??€.

μΆλ ₯
κ°? ??€?Έ μΌ??΄?€ λ§λ€, ?κ·Όμ΄κ°? ?μΉ? ? ?? λ¬Έμ? μ΅λ? κ°μλ₯? μΆλ ₯??€.

??  ?? ₯ 1 
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
??  μΆλ ₯ 1 
3
1
0
*/