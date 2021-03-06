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
		// dir?? ₯.
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
	public static int A;// κ°?λ‘?
	public static int B;// ?Έλ‘?
	public static int N;// λ‘λ΄?
	public static int M;// λͺλ Ή?
	public static int di[] = { 1, 0, -1, 0 }; // λ§΅μ ?€μ§μ΄? ?κ°ν  κ±°λΌ? N/Sλ₯? ? λ³΅μ?¨?€.
	public static int dj[] = { 0, 1, 0, -1 };
	public static Robot[] robots; // robotλ²νΈ? 1λΆ??° ??.

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
			//?¬κΈ°μ command ?€?
			st = new StringTokenizer(br.readLine(), " ");
			if(!command(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0), Integer.parseInt(st.nextToken()))){
				return; // ?κ΅°κ? λΆ??ͺ?λ©? ??Έ?€.
			}
			
		}
		System.out.println("OK");
	}
	public static boolean command(int robotId, char comm, int num){
		if (comm == 'F') {
			for (int k = 0; k < num; k++) {
//				for (int i = 1; i < robots.length; i++) {
//					System.out.println(i+ "λ²? λ‘λ΄ " + robots[i]);
//				}
				//??¬ λ°©ν₯?Όλ‘? ? μ§ν?€.
				int ni = robots[robotId].i + di[robots[robotId].dir];
				int nj = robots[robotId].j + dj[robots[robotId].dir];
				if (ni>=1 && ni <= B && nj>=1 && nj <= A) { //κ°? ? ??Όλ©?
					for (int i = 1; i < robots.length; i++) {//?€λ₯? μΉκ΅¬? λΆ??ͺ?λ©?.
						if (ni==robots[i].i && nj == robots[i].j) {
							System.out.println("Robot "+robotId+" crashes into robot "+i); 
							return false;
						}
					}
					robots[robotId].i = ni;
					robots[robotId].j = nj;
				}else { //λ²½μ λΆ??ͺ?λ©?..
					System.out.println("Robot "+robotId+" crashes into the wall");
					return false;
				}
			}
		} else if (comm == 'L') { //L - R?­?  && λ°©ν₯λ§? λ°κΎΌ?€.
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
 * ??  ?? ₯ 1 
5 4 
2 2 
1 1 E 
5 4 W 
1 F 7 
2 F 7 
??  μΆλ ₯ 1 
Robot 1 crashes into the wall
 */