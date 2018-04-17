package samsung1;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Samsung14891 {
	public static int wheel[][] = new int[4][8]; // �넲�땲諛뷀�� �젙蹂�
	public static int pos[] = new int[4]; // 0~3 �넲�땲諛뷀�� 12�떆諛⑺뼢 idx�쓣 ���옣.. 珥덇린媛믪� 0
	// 3�떆 9�떆 諛⑺뼢�� pos[i]+-2 % 8
	public static int K; // �쉶�쟾�닔 
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
		for (int i = 0; i < K; i++) { // K踰� ��吏곸씤�떎.
			visit = new boolean[4];//�룎由대븣留덈떎 珥덇린�솕�빐以��떎.
			StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
			int now = Integer.parseInt(st.nextToken())-1; //�넲�땲諛뷀�� 0-3踰� 
			int dir = Integer.parseInt(st.nextToken());
			turnTheWheel(now, dir); //諛섎�諛⑺뼢�쑝猷�..
		}
		//�젏�닔怨꾩궛
		System.out.println(calculateScore());
	}

	public static void turnTheWheel(int now, int dir) {
		visit[now] = true;
		int lastPos = pos[now]; //�룎由ш린 吏곸쟾 pos
		pos[now] = (8+pos[now]-dir)%8;
		
		int left = now - 1;
		int right = now + 1;
		
		if (left>=0 && left < 4 && wheel[now][(8+lastPos-2)%8]!=wheel[left][(8+pos[left]+2)%8] && !visit[left]) { //�쇊議깆뿉 �넲�땲諛뷀�닿� �엳怨� 洹뱀씠 �떎瑜대㈃..
			turnTheWheel(left, -dir); //諛섎�諛⑺뼢�쑝猷�..
		}
		if (right>=0 && right < 4 && wheel[now][(8+lastPos+2)%8]!=wheel[right][(8+pos[right]-2)%8] && !visit[right]) {//�삤瑜� 議깆뿉 �넲�땲諛뷀�닿� �엳怨� 洹뱀씠 �떎瑜대㈃..
			turnTheWheel(right, -dir); //諛섎�諛⑺뼢�쑝猷�..
		}
		
	}
	/*
	1踰� �넲�땲諛뷀�댁쓽 12�떆諛⑺뼢�씠 N洹뱀씠硫� 0�젏, S洹뱀씠硫� 1�젏 2^0
	2踰� �넲�땲諛뷀�댁쓽 12�떆諛⑺뼢�씠 N洹뱀씠硫� 0�젏, S洹뱀씠硫� 2�젏 2^1
	3踰� �넲�땲諛뷀�댁쓽 12�떆諛⑺뼢�씠 N洹뱀씠硫� 0�젏, S洹뱀씠硫� 4�젏 ..
	4踰� �넲�땲諛뷀�댁쓽 12�떆諛⑺뼢�씠 N洹뱀씠硫� 0�젏, S洹뱀씠硫� 8�젏
	*/
	public static int calculateScore() {
		int sum = 0;
		for (int i = 0; i < pos.length; i++) {
			if (wheel[i][pos[i]]==1) { //S洹뱀씠硫� �젏�닔瑜� �뜑�빐以��떎.
				sum += Math.pow(2, i);
			}
		}
		return sum;
	}
}
/*
 * 10101111 01111101 11001110 00000010 2 3 -1 1 1
 */