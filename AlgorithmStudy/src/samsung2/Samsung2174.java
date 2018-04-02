package samsung2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Robot {
	int i;
	int j;
	int dir;

	public Robot(int i, int j, char dir) {
		this.i = i;
		this.j = j;
		// dir?…? ¥.
		if (dir == 'N') {
			this.dir = 0;
		} else if (dir == 'E') {
			this.dir = 1;
		} else if (dir == 'S') {
			this.dir = 2;
		} else if (dir == 'W') {
			this.dir = 3;
		}
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return i+", "+j+" : "+dir;
	}
}

public class Samsung2174 {
	public static int A;// ê°?ë¡?
	public static int B;// ?„¸ë¡?
	public static int N;// ë¡œë´‡?ˆ˜
	public static int M;// ëª…ë ¹?ˆ˜
	public static int di[] = { 1, 0, -1, 0 }; // ë§µì„ ?’¤ì§‘ì–´?„œ ?ƒê°í•  ê±°ë¼?„œ N/Së¥? ? „ë³µì‹œ?‚¨?‹¤.
	public static int dj[] = { 0, 1, 0, -1 };
	public static Robot[] robots; // robotë²ˆí˜¸?Š” 1ë¶??„° ?‹œ?‘.

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		robots = new Robot[N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			char d = st.nextToken().charAt(0);
			robots[i] = new Robot(y, x, d);
		}
		for (int i = 0; i < M; i++) {
			//?—¬ê¸°ì„œ command ?‹¤?–‰
			st = new StringTokenizer(br.readLine(), " ");
			if(!command(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0), Integer.parseInt(st.nextToken()))){
				return; // ?ˆ„êµ°ê? ë¶??”ª?ˆë©? ??‚¸?‹¤.
			}
			
		}
		System.out.println("OK");
	}
	public static boolean command(int robotId, char comm, int num){
		if (comm == 'F') {
			for (int k = 0; k < num; k++) {
//				for (int i = 1; i < robots.length; i++) {
//					System.out.println(i+ "ë²? ë¡œë´‡ " + robots[i]);
//				}
				//?˜„?¬ ë°©í–¥?œ¼ë¡? ? „ì§„í•œ?‹¤.
				int ni = robots[robotId].i + di[robots[robotId].dir];
				int nj = robots[robotId].j + dj[robots[robotId].dir];
				if (ni>=1 && ni <= B && nj>=1 && nj <= A) { //ê°? ?ˆ˜ ?ˆ?œ¼ë©?
					for (int i = 1; i < robots.length; i++) {//?‹¤ë¥? ì¹œêµ¬?‘ ë¶??”ª?ˆë©?.
						if (ni==robots[i].i && nj == robots[i].j) {
							System.out.println("Robot "+robotId+" crashes into robot "+i); 
							return false;
						}
					}
					robots[robotId].i = ni;
					robots[robotId].j = nj;
				}else { //ë²½ì— ë¶??”ª?ˆë©?..
					System.out.println("Robot "+robotId+" crashes into the wall");
					return false;
				}
			}
		} else if (comm == 'L') { //L - R?—­? „ && ë°©í–¥ë§? ë°”ê¾¼?‹¤.
			for (int i = 0; i < num; i++) {
				robots[robotId].dir = (4 + robots[robotId].dir - 1)%4;
			}
		} else if (comm == 'R') {
			for (int i = 0; i < num; i++) {
				robots[robotId].dir = (4 + robots[robotId].dir + 1)%4;
			}
		}
		return true;
	}
}

/*
 * ?˜ˆ? œ ?…? ¥ 1 
5 4 
2 2 
1 1 E 
5 4 W 
1 F 7 
2 F 7 
?˜ˆ? œ ì¶œë ¥ 1 
Robot 1 crashes into the wall
 */