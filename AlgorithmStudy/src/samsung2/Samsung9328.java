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
			//?…
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			
			char [][] map = new char[h][w];
			boolean [][] visit;
			
			
			for (int i = 0; i < h; i++) {
				map[i] = br.readLine().toCharArray();
			}
			String myKeys = br.readLine(); //ë³´ìœ ?•œ ?‚¤ë¥? ?…? ¥ë°›ëŠ”?‹¤.
			
			
			boolean flag = true; //bfs ?ƒ?ƒ‰ ì¤‘ê°„?— ?—´?‡ ë¥? ë¨¹ìœ¼ë©? true; 
			int documents = 0; //?›”ì¹? ë¬¸ì„œë¥? ?‹´?Š”?‹¤. res
			
			
			while (flag) {
				flag = false;
				visit = new boolean[h][w];
				Queue<Point9328> q = new LinkedList<>();
				//ì´ˆê¸°? ?„ ì°¾ì.
				for (int i = 0; i < h; i++) {
					for (int j = 0; j < w; j++) {
						if (i==0 || i == h-1 || j ==0 || j == w-1) { //?™¸ê³½ì— ?ˆ?Š” ? ?“¤?„ ì°¾ëŠ”?‹¤.
							//ë¬¸ì¼?•Œ
							if (map[i][j] >= 'A' && map[i][j] <= 'Z') {
								//?‚¤ë¥? ê°?ì§?ê³? ?ˆ?œ¼ë©? ë¬¸ì´ ?—´ë¦¬ë?ë¡? ì¶œë°œ? ?´ ?  ?ˆ˜ ?ˆ?‹¤. 
								if (myKeys.contains(String.valueOf(map[i][j]).toLowerCase())) {
									q.add(new Point9328(i, j));
								}
								//?•„?‹ˆë©? ê±? ?ƒ…?‘”?‹¤.
							}
							//?†µë¡œì¼?•Œ  
							else if (map[i][j]=='.') {
								q.add(new Point9328(i, j));
							}
							//?—´?‡ ?¼?•Œ 
							else if (map[i][j] >= 'a' && map[i][j] <= 'z') {
								if (!myKeys.contains(String.valueOf(map[i][j]))) {
									myKeys+=map[i][j]; //ë³´ìœ ?•˜ì§? ?•Š?? ?‚¤?´ë©? ?‚¤ë¥? ì¶”ê??•œ?‹¤.
								}
								map[i][j] = '.';
								flag = true;
								q.add(new Point9328(i, j));
							}
							else if (map[i][j] == '$') { //ë¬¸ì„œ?¼?•Œ.
								map[i][j] = '.';
								documents++;
								q.add(new Point9328(i, j));
							}
						}
					}
				}
				
				
				
				//ì¤‘ê°„?— ?—´?‡ ë¥? ë¨¹ìœ¼ë©? ?‹¤?‹œ ?ƒ?ƒ‰?•´?•¼?¨....... ?… ?… 
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
							//?ƒ?ƒ‰?•˜ë©´ì„œ ê°ˆìˆ˜ ?ˆ?Š”ê³³ì´?‚˜ ?—´?‡ ?Š” ?†µë¡œë¡œ ë°”ê¾¸?–´ì¤??‹¤.
							if (map[nx][ny] >= 'a' && map[nx][ny] <= 'z') { //?—´?‡ ë©? ? „ì²? ë£¨í”„ë¥? ?•œë²? ?” ?Œë¦´ê±°?‹¤.. 
								if (!myKeys.contains(String.valueOf(map[nx][ny]))) {
									myKeys+=map[nx][ny]; //ë³´ìœ ?•˜ì§? ?•Š?? ?‚¤?´ë©? ?‚¤ë¥? ì¶”ê??•œ?‹¤.
								}
								flag = true;
								map[nx][ny] = '.';
								q.add(new Point9328(nx, ny));
								visit[nx][ny] = true;
							}
							else if (map[nx][ny] >= 'A' && map[nx][ny] <= 'Z') { //ë¬¸ì´ê³?  
								if (myKeys.contains(String.valueOf(map[nx][ny]).toLowerCase())) { //?—´?ˆ˜ ?…‡?ˆ?œ¼ë©?..
									map[nx][ny] = '.';
									q.add(new Point9328(nx, ny));
									visit[nx][ny] = true;
								}
								//ëª»ì—´ë©? ê±? ?ƒ…?‘”?‹¤..
							}
							else if (map[nx][ny]=='$') { //ë¬¸ì„œ?´ë©? ë¨¹ê³  ?†µë¡œë¡œ ë°”ê¾¼?‹¤..
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
?—´?‡  ???´
?‹œê°? ? œ?•œ	ë©”ëª¨ë¦? ? œ?•œ	? œì¶?	? •?‹µ	ë§ì? ?‚¬?Œ	? •?‹µ ë¹„ìœ¨
1 ì´?	128 MB	3395	689	419	18.589%
ë¬¸ì œ
?ƒê·¼ì´?Š” 1ì¸? ë¹Œë”©?— ì¹¨ì…?•´ ë§¤ìš° ì¤‘ìš”?•œ ë¬¸ì„œë¥? ?›”ì³ì˜¤? ¤ê³? ?•œ?‹¤. ?ƒê·¼ì´ê°? ê°?ì§?ê³? ?ˆ?Š” ?‰ë©´ë„?—?Š” ë¬¸ì„œ?˜ ?œ„ì¹˜ê? ëª¨ë‘ ?‚˜???‚˜ ?ˆ?‹¤. ë¹Œë”©?˜ ë¬¸ì? ëª¨ë‘ ? ê²¨ìˆê¸? ?•Œë¬¸ì—, ë¬¸ì„ ?—´? ¤ë©? ?—´?‡ ê°? ?•„?š”?•˜?‹¤. ?ƒê·¼ì´?Š” ?¼ë¶? ?—´?‡ ë¥? ?´ë¯? ê°?ì§?ê³? ?ˆê³?, ?¼ë¶? ?—´?‡ ?Š” ë¹Œë”©?˜ ë°”ë‹¥?— ?†“?—¬? ¸ ?ˆ?‹¤.

?ƒê·¼ì´ê°? ?›”ì¹? ?ˆ˜ ?ˆ?Š” ë¬¸ì„œ?˜ ìµœë? ê°œìˆ˜ë¥? êµ¬í•˜?Š” ?”„ë¡œê·¸?¨?„ ?‘?„±?•˜?‹œ?˜¤.

?…? ¥
ì²«ì§¸ ì¤„ì— ?…Œ?Š¤?Š¸ ì¼??´?Š¤?˜ ê°œìˆ˜ê°? ì£¼ì–´ì§„ë‹¤. ?…Œ?Š¤?Š¸ ì¼??´?Š¤?˜ ?ˆ˜?Š” 100ê°œë?? ?„˜ì§? ?•Š?Š”?‹¤.

ê°? ?…Œ?Š¤?Š¸ ì¼??´?Š¤?˜ ì²«ì§¸ ì¤„ì—?Š” ì§??„?˜ ?†’?´?? ?„ˆë¹? h?? w (2 ?‰¤ h, w ?‰¤ 100)ê°? ì£¼ì–´ì§„ë‹¤. ?‹¤?Œ hê°? ì¤„ì—?Š” ë¹Œë”©?„ ?‚˜???‚´?Š” wê°œì˜ ë¬¸ìê°? ì£¼ì–´ì§?ë©?, ê°? ë¬¸ì?Š” ?‹¤?Œ ì¤? ?•˜?‚˜?´?‹¤.

'.'?Š” ë¹? ê³µê°„?„ ?‚˜???‚¸?‹¤.
'*'?Š” ë²½ì„ ?‚˜???‚´ë©?, ?ƒê·¼ì´?Š” ë²½ì„ ?†µê³¼í•  ?ˆ˜ ?—†?‹¤.
'$'?Š” ?ƒê·¼ì´ê°? ?›”ì³ì•¼?•˜?Š” ë¬¸ì„œ?´?‹¤.
?•Œ?ŒŒë²? ??ë¬¸ì?Š” ë¬¸ì„ ?‚˜???‚¸?‹¤.
?•Œ?ŒŒë²? ?†Œë¬¸ì?Š” ?—´?‡ ë¥? ?‚˜???‚´ë©?, ê·? ë¬¸ì?˜ ??ë¬¸ì?¸ ëª¨ë“  ë¬¸ì„ ?—´ ?ˆ˜ ?ˆ?‹¤.
ë§ˆì?ë§? ì¤„ì—?Š” ?ƒê·¼ì´ê°? ?´ë¯? ê°?ì§?ê³? ?ˆ?Š” ?—´?‡ ê°? ê³µë°±?—†?´ ì£¼ì–´ì§„ë‹¤. ë§Œì•½, ?—´?‡ ë¥? ?•˜?‚˜?„ ê°?ì§?ê³? ?ˆì§? ?•Š?Š” ê²½ìš°?—?Š” "0"?´ ì£¼ì–´ì§„ë‹¤.

?ƒê·¼ì´?Š” ë¹Œë”© ë°–ìœ¼ë¡? ?‚˜ê°? ?ˆ˜ ?ˆ?‹¤. ê°ê°?˜ ë¬¸ì— ???•´?„œ, ê·? ë¬¸ì„ ?—´ ?ˆ˜ ?‡?Š” ?—´?‡ ?˜ ê°œìˆ˜?Š” 0ê°?, 1ê°?, ?˜?Š” ê·? ?´?ƒ?´ê³?, ê°ê°?˜ ?—´?‡ ?— ???•´?„œ, ê·? ?—´?‡ ë¡? ?—´ ?ˆ˜ ?ˆ?Š” ë¬¸ì˜ ê°œìˆ˜?„ 0ê°?, 1ê°?, ?˜?Š” ê·? ?´?ƒ?´?‹¤. ?—´?‡ ?Š” ?—¬?Ÿ¬ ë²? ?‚¬?š©?•  ?ˆ˜ ?ˆ?‹¤.

ì¶œë ¥
ê°? ?…Œ?Š¤?Š¸ ì¼??´?Š¤ ë§ˆë‹¤, ?ƒê·¼ì´ê°? ?›”ì¹? ?ˆ˜ ?ˆ?Š” ë¬¸ì„œ?˜ ìµœë? ê°œìˆ˜ë¥? ì¶œë ¥?•œ?‹¤.

?˜ˆ? œ ?…? ¥ 1 
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
?˜ˆ? œ ì¶œë ¥ 1 
3
1
0
*/