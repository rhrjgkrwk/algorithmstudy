package samsung1;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Samsung14891 {
	public static int wheel[][] = new int[4][8]; // 톱니바퀴 정보
	public static int pos[] = new int[4]; // 0~3 톱니바퀴 12시방향 idx을 저장.. 초기값은 0
	// 3시 9시 방향은 pos[i]+-2 % 8
	public static int K; // 회전수
	public static boolean visit[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < wheel.length; i++) {
			char[] temp = sc.nextLine().toCharArray();
			for (int j = 0; j < temp.length; j++) {
				wheel[i][j] = (int) (temp[j] - '0');
			}
		}
		K = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < K; i++) { // K번 움직인다.
			visit = new boolean[4];//돌릴때마다 초기화해준다.
			StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
			int now = Integer.parseInt(st.nextToken())-1; //톱니바퀴 0-3번 
			int dir = Integer.parseInt(st.nextToken());
			turnTheWheel(now, dir); //반대방향으루..
		}
		//점수계산
		System.out.println(calculateScore());
	}

	public static void turnTheWheel(int now, int dir) {
		visit[now] = true;
		int lastPos = pos[now]; //돌리기 직전 pos
		pos[now] = (8+pos[now]-dir)%8;
		
		int left = now - 1;
		int right = now + 1;
		
		if (left>=0 && left < 4 && wheel[now][(8+lastPos-2)%8]!=wheel[left][(8+pos[left]+2)%8] && !visit[left]) { //왼족에 톱니바퀴가 있고 극이 다르면..
			turnTheWheel(left, -dir); //반대방향으루..
		}
		if (right>=0 && right < 4 && wheel[now][(8+lastPos+2)%8]!=wheel[right][(8+pos[right]-2)%8] && !visit[right]) {//오른 족에 톱니바퀴가 있고 극이 다르면..
			turnTheWheel(right, -dir); //반대방향으루..
		}
		
	}
	/*
	1번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 1점 2^0
	2번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 2점 2^1
	3번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 4점 ..
	4번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 8점
	*/
	public static int calculateScore() {
		int sum = 0;
		for (int i = 0; i < pos.length; i++) {
			if (wheel[i][pos[i]]==1) { //S극이면 점수를 더해준다.
				sum += Math.pow(2, i);
			}
		}
		return sum;
	}
}
/*
 * 10101111 01111101 11001110 00000010 2 3 -1 1 1
 */