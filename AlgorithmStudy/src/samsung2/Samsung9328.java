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
			//?��
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			
			char [][] map = new char[h][w];
			boolean [][] visit;
			
			
			for (int i = 0; i < h; i++) {
				map[i] = br.readLine().toCharArray();
			}
			String myKeys = br.readLine(); //보유?�� ?���? ?��?��받는?��.
			
			
			boolean flag = true; //bfs ?��?�� 중간?�� ?��?���? 먹으�? true; 
			int documents = 0; //?���? 문서�? ?��?��?��. res
			
			
			while (flag) {
				flag = false;
				visit = new boolean[h][w];
				Queue<Point9328> q = new LinkedList<>();
				//초기?��?�� 찾자.
				for (int i = 0; i < h; i++) {
					for (int j = 0; j < w; j++) {
						if (i==0 || i == h-1 || j ==0 || j == w-1) { //?��곽에 ?��?�� ?��?��?�� 찾는?��.
							//문일?��
							if (map[i][j] >= 'A' && map[i][j] <= 'Z') {
								//?���? �?�?�? ?��?���? 문이 ?��리�?�? 출발?��?�� ?�� ?�� ?��?��. 
								if (myKeys.contains(String.valueOf(map[i][j]).toLowerCase())) {
									q.add(new Point9328(i, j));
								}
								//?��?���? �? ?��?��?��.
							}
							//?��로일?��  
							else if (map[i][j]=='.') {
								q.add(new Point9328(i, j));
							}
							//?��?��?��?�� 
							else if (map[i][j] >= 'a' && map[i][j] <= 'z') {
								if (!myKeys.contains(String.valueOf(map[i][j]))) {
									myKeys+=map[i][j]; //보유?���? ?��?? ?��?���? ?���? 추�??��?��.
								}
								map[i][j] = '.';
								flag = true;
								q.add(new Point9328(i, j));
							}
							else if (map[i][j] == '$') { //문서?��?��.
								map[i][j] = '.';
								documents++;
								q.add(new Point9328(i, j));
							}
						}
					}
				}
				
				
				
				//중간?�� ?��?���? 먹으�? ?��?�� ?��?��?��?��?��....... ?��?��
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
							//?��?��?��면서 갈수 ?��?��곳이?�� ?��?��?�� ?��로로 바꾸?���??��.
							if (map[nx][ny] >= 'a' && map[nx][ny] <= 'z') { //?��?���? ?���? 루프�? ?���? ?�� ?��릴거?��.. 
								if (!myKeys.contains(String.valueOf(map[nx][ny]))) {
									myKeys+=map[nx][ny]; //보유?���? ?��?? ?��?���? ?���? 추�??��?��.
								}
								flag = true;
								map[nx][ny] = '.';
								q.add(new Point9328(nx, ny));
								visit[nx][ny] = true;
							}
							else if (map[nx][ny] >= 'A' && map[nx][ny] <= 'Z') { //문이�?  
								if (myKeys.contains(String.valueOf(map[nx][ny]).toLowerCase())) { //?��?�� ?��?��?���?..
									map[nx][ny] = '.';
									q.add(new Point9328(nx, ny));
									visit[nx][ny] = true;
								}
								//못열�? �? ?��?��?��..
							}
							else if (map[nx][ny]=='$') { //문서?���? 먹고 ?��로로 바꾼?��..
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
?��?�� ???��
?���? ?��?��	메모�? ?��?��	?���?	?��?��	맞�? ?��?��	?��?�� 비율
1 �?	128 MB	3395	689	419	18.589%
문제
?��근이?�� 1�? 빌딩?�� 침입?�� 매우 중요?�� 문서�? ?��쳐오?���? ?��?��. ?��근이�? �?�?�? ?��?�� ?��면도?��?�� 문서?�� ?��치�? 모두 ?��???�� ?��?��. 빌딩?�� 문�? 모두 ?��겨있�? ?��문에, 문을 ?��?���? ?��?���? ?��?��?��?��. ?��근이?�� ?���? ?��?���? ?���? �?�?�? ?���?, ?���? ?��?��?�� 빌딩?�� 바닥?�� ?��?��?�� ?��?��.

?��근이�? ?���? ?�� ?��?�� 문서?�� 최�? 개수�? 구하?�� ?��로그?��?�� ?��?��?��?��?��.

?��?��
첫째 줄에 ?��?��?�� �??��?��?�� 개수�? 주어진다. ?��?��?�� �??��?��?�� ?��?�� 100개�?? ?���? ?��?��?��.

�? ?��?��?�� �??��?��?�� 첫째 줄에?�� �??��?�� ?��?��?? ?���? h?? w (2 ?�� h, w ?�� 100)�? 주어진다. ?��?�� h�? 줄에?�� 빌딩?�� ?��???��?�� w개의 문자�? 주어�?�?, �? 문자?�� ?��?�� �? ?��?��?��?��.

'.'?�� �? 공간?�� ?��???��?��.
'*'?�� 벽을 ?��???���?, ?��근이?�� 벽을 ?��과할 ?�� ?��?��.
'$'?�� ?��근이�? ?��쳐야?��?�� 문서?��?��.
?��?���? ??문자?�� 문을 ?��???��?��.
?��?���? ?��문자?�� ?��?���? ?��???���?, �? 문자?�� ??문자?�� 모든 문을 ?�� ?�� ?��?��.
마�?�? 줄에?�� ?��근이�? ?���? �?�?�? ?��?�� ?��?���? 공백?��?�� 주어진다. 만약, ?��?���? ?��?��?�� �?�?�? ?���? ?��?�� 경우?��?�� "0"?�� 주어진다.

?��근이?�� 빌딩 밖으�? ?���? ?�� ?��?��. 각각?�� 문에 ???��?��, �? 문을 ?�� ?�� ?��?�� ?��?��?�� 개수?�� 0�?, 1�?, ?��?�� �? ?��?��?���?, 각각?�� ?��?��?�� ???��?��, �? ?��?���? ?�� ?�� ?��?�� 문의 개수?�� 0�?, 1�?, ?��?�� �? ?��?��?��?��. ?��?��?�� ?��?�� �? ?��?��?�� ?�� ?��?��.

출력
�? ?��?��?�� �??��?�� 마다, ?��근이�? ?���? ?�� ?��?�� 문서?�� 최�? 개수�? 출력?��?��.

?��?�� ?��?�� 1 
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
?��?�� 출력 1 
3
1
0
*/