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
	public static int dy[] = {0,1,0,-1}; //0 ?úÑ ?ò§ ?ïÑ ?ôº.?àú
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
	public static boolean curdir[][] = new boolean[4][7]; //?àú?Ñú??Î°? -|+1234
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
					zq.add(new Pos(i, j)); // Ï¥àÍ∏∞ Î∞©Ìñ•?? ?ïå ?àò ?óÜ?úºÎØ?Î°? -1Î°? Ï£ºÏûê.
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

	public static void bfs(Queue<Pos> q, ArrayList<Pos> zm) { // z?äî z?óê m?? m?óê

		while (!q.isEmpty()) {
			Pos p = q.poll();
			if (p.dir < 0) { // ?ãú?ûë ?†ê?ù¥Í±∞ÎÇò Í∞? ?àò ?ûà?äî Í≥≥Ïù¥ ?óÜ?úºÎ©?.
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
				if (p.dir<0) { //?ù∏?†ë?ïú ?ÜµÎ°úÍ? ?ïò?Çò?èÑ ?óÜ?úºÎ©? Z?? M?ù¥ ?ÜµÎ°úÌïò?ÇòÎ•? ?ëêÍ≥? ?ñ®?ñ¥?†∏?ûà?äî Í≤ΩÏö∞?ù¥ÎØ?Î°?.
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
			if (nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] != '.') { // ?ïû?óê?èÑ
													// ?ÜµÎ°úÏù¥Î©?.
				Pos np = new Pos(nx, ny);
				if (map[nx][ny] == '-') {
					np.dir = direction;
				} else if (map[nx][ny] == '|') {
					np.dir = direction;
				} // ?úÑ ?ëêÍ∞?Ïß? Í≤ΩÏö∞?äî Í∏∞Ï°¥ Î∞©Ìñ• ?ú†Ïß?.

				else if (map[nx][ny] == '+') {
					np.dir = direction;
					// np.dir.add((4+direction+1)%4); //Í∏∞Ï°¥ ÏßÑÌñâ Î∞©Ìñ• + ?ôºÏ™? ?ò§Î•∏Ï™Ω
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
			} else if (nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] == '.') { // ?ÜµÎ°úÍ?
																						// ?ÅäÍ≤®Ïûà?äî
																						// Í≤ΩÏö∞
				Pos destoyed = new Pos(nx, ny);
				destoyed.dir = direction;
				zm.add(destoyed); // ?ÅäÍ∏? Î∞©Ìñ•?èÑ Ï§ëÏöî?ïò?ã§.
			}
		}
	}
	public static Pos whatIsErased(){
		//?ó¨Í∏∞ÏÑú arr z,m?ùÑ ÎπÑÍµê?ï¥?Ñú ?ùºÏπòÌïò?äî Í≥≥ÏùÑ Ï∂úÎ†•?ïú?ã§.
		//
		Pos res = new Pos();
		for (Pos zp : z) {
			for (Pos mp : m) {
				
				if (zp.x == mp.x && zp.y == mp.y) {
					//System.out.println(zp.dir+" "+mp.dir);
					res.x = zp.x;
					res.y = zp.y;
					if ((zp.dir == 2 && mp.dir == 0) || (zp.dir == 0 && mp.dir == 2)) {
						//?úÑ?ïÑ?ûò
						res.pipe = '|';
					}
					else if ((zp.dir == 1 && mp.dir == 3) || (zp.dir == 3 && mp.dir == 1)) {
						//?ôº?ò§Î•?
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
ÏßàÎ¨∏ Í≤??Éâ
Í∞??ä§Í¥? ???ù¥
?ãúÍ∞? ?†ú?ïú	Î©îÎ™®Î¶? ?†ú?ïú	?†úÏ∂?	?†ï?ãµ	ÎßûÏ? ?Ç¨?ûå	?†ï?ãµ ÎπÑÏú®
1 Ï¥?	128 MB	805	98	76	22.287%
Î¨∏Ï†ú
?ü¨?ãú?ïÑ Í∞??ä§Î•? ?Å¨Î°úÏïÑ?ã∞?ïÑÎ°? ?ö¥Î∞òÌïòÍ∏? ?úÑ?ï¥ ?ûêÍ∑∏Î†àÎ∏åÏ? Î™®Ïä§ÏΩîÎ∞î?äî ?åå?ù¥?îÑ?ùº?ù∏?ùÑ ?îî?ûê?ù∏?ïòÍ≥? ?ûà?ã§. ?ëê ?Ç¨?ûå?? ?ã§?†ú ?îî?ûê?ù∏?ùÑ ?ïòÍ∏? ?†Ñ?óê ?åå?ù¥?îÑ Îß§Îãà?ïÑ Í≤åÏûÑ?ùÑ ?ù¥?ö©?ï¥?Ñú ?Ñ§Í≥ÑÎ?? ?ï¥Î≥¥Î†§Í≥? ?ïú?ã§.

?ù¥ Í≤åÏûÑ?óê?Ñú ?ú†?üΩ?? R?ñâ C?ó¥Î°? ?Çò?àÑ?ñ¥?†∏ ?ûà?ã§. Í∞? Ïπ∏Ï? ÎπÑÏñ¥?ûàÍ±∞ÎÇò, ?ïÑ?ûò Í∑∏Î¶ºÍ≥? Í∞ôÏ? ?ùºÍ≥±Í?Ïß? Í∏∞Î≥∏ Î∏îÎü≠?úºÎ°? ?ù¥Î£®Ïñ¥?†∏ ?ûà?ã§.

3 4
14Z.
2+3.
.2.M



Í∞??ä§?äî Î™®Ïä§?Å¨Î∞îÏóê?Ñú ?ûêÍ∑∏Î†àÎ∏åÎ°ú ?ùêÎ•∏Îã§. Í∞??ä§?äî ÎπåÎî© Î∏îÎü≠?ùÑ ?Üµ?ï¥ ?ñëÎ∞©Ìñ•?úºÎ°? ?ùêÎ•? ?àò ?ûà?ã§. '+'?äî ?äπÎ≥ÑÌïú Î∏îÎü≠?úºÎ°?, ?ëê Î∞©Ìñ• (?àòÏß?, ?àò?èâ)?úºÎ°? ?ùêÎ•? ?àò ?ûà?ã§. ?ïÑ?ûò ?òà?†úÎ•? Ï∞∏Í≥†?ïú?ã§.



?åå?ù¥?îÑ ?ùº?ù∏?ùò ?Ñ§Í≥ÑÎ?? ÎßàÏπú ?õÑ ?ëê ?Ç¨?ûå?? ?û†?ãú ???ÖÅ?ùÑ Î®πÏúº?ü¨ Í∞îÎã§. Í∑? ?Ç¨?ù¥ ?ï¥Ïª§Í? Ïπ®ÏûÑ?ï¥ Î∏îÎü≠ ?ïò?ÇòÎ•? Ïß??õ†?ã§. Ïß??ö¥ Î∏îÎü≠?? Îπ? Ïπ∏Ïù¥ ?êò?ñ¥?ûà?ã§.

?ï¥Ïª§Í? ?ñ¥?ñ§ Ïπ∏ÏùÑ Ïß??õüÍ≥?, Í∑? Ïπ∏Ïóê?äî ?õê?ûò ?ñ¥?ñ§ Î∏îÎü≠?ù¥ ?ûà?óà?äîÏß? Íµ¨Ìïò?äî ?îÑÎ°úÍ∑∏?û®?ùÑ ?ûë?Ñ±?ïò?ãú?ò§.

?ûÖ?†•
Ï≤´Ïß∏ Ï§ÑÏóê ?ú†?üΩ?ùò ?Å¨Í∏? RÍ≥? CÍ∞? Ï£ºÏñ¥ÏßÑÎã§. (1 ?â§ R, C ?â§ 25)

?ã§?ùå RÍ∞? Ï§ÑÏóê?äî CÍ∞? Í∏??ûêÍ∞? Ï£ºÏñ¥Ïß?Î©?, ?ã§?ùåÍ≥? Í∞ôÏ? Í∏??ûêÎ°? ?ù¥Î£®Ïñ¥?†∏ ?ûà?ã§.

ÎπàÏπ∏?ùÑ ?Çò???Ç¥?äî '.'
Î∏îÎü≠?ùÑ ?Çò???Ç¥?äî '|'(?ïÑ?ä§?Ç§ 124), '-','+','1','2','3','4'
Î™®Ïä§?Å¨Î∞îÏùò ?úÑÏπòÎ?? ?Çò???Ç¥?äî 'M'Í≥? ?ûêÍ∑∏Î†àÎ∏åÎ?? ?Çò???Ç¥?äî 'Z'. ?ëê Í∏??ûê?äî ?ïú Î≤àÎßå Ï£ºÏñ¥ÏßÑÎã§.
?ï≠?ÉÅ ?ãµ?ù¥ Ï°¥Ïû¨?ïòÍ≥?, Í∞??ä§?ùò ?ùêÎ¶ÑÏù¥ ?ú†?ùº?ïú Í≤ΩÏö∞Îß? ?ûÖ?†•?úºÎ°? Ï£ºÏñ¥Ïß?Î©?, Î™®Ïä§?Å¨Î∞îÏ? ?ûêÍ∑∏Î†àÎ∏åÏ? ?ù∏?†ë?ïú Î∏îÎü≠?ùò ?àò?äî ?ïò?Çò?ù¥?ã§. ?òê, Î∂àÌïÑ?öî?ïú Î∏îÎü≠?ù¥ Ï°¥Ïû¨?ïòÏß? ?ïä?äî?ã§. Ï¶?, ?óÜ?ñ¥Ïß? Î∏îÎü≠?ùÑ Ï∂îÍ??ïòÎ©?, Î™®Îì† Î∏îÎü≠?óê Í∞??ä§Í∞? ?ùêÎ•¥Í≤å ?êú?ã§.

Ï∂úÎ†•
Ïß??õåÏß? Î∏îÎü≠?ùò ?ñâÍ≥? ?ó¥ ?úÑÏπòÎ?? Ï∂úÎ†•?ïòÍ≥?, ?ñ¥?ñ§ Î∏îÎü≠?ù¥?óà?äîÏß?Î•? Ï∂úÎ†•?ïú?ã§.

?òà?†ú ?ûÖ?†• 1 
3 7
.......
.M-.-Z.
.......
?òà?†ú Ï∂úÎ†• 1 
2 4 -
?òà?†ú ?ûÖ?†• 2 
3 5
..1-M
1-+..
Z.23.
?òà?†ú Ï∂úÎ†• 2 
2 4 4
?òà?†ú ?ûÖ?†• 3 
6 10
Z.1----4..
|.|....|..
|..14..M..
2-+++4....
..2323....
..........
?òà?†ú Ï∂úÎ†• 3 
3 3 |
*/