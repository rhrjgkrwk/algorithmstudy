package dfsbfs;
import java.util.Scanner;
/*
NxM ÇÊµå°¡ ÀÖ´Ù. 
¸¶¸¥ ¶¥Àº .
Á¥Àº ¶¥Àº W
Á¥Àº ¶¥ µ¢¾î¸®ÀÇ °³¼ö¸¦ ±¸ÇØº¸ÀÚ.
*/
public class WoongDungi {
	static char[][] lake;
	static int N,M;
	static int count = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*N = sc.nextInt();
		M = sc.nextInt();*/
		N = 6;
		M = 5;
		lake = new char[N][M];
		lake[0] = ".....".toCharArray();
		lake[1] = ".WWW.".toCharArray();
		lake[2] = ".....".toCharArray();
		lake[3] = ".W...".toCharArray();
		lake[4] = ".....".toCharArray();
		lake[5] = "WW...".toCharArray();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(lake[i][j]+"\t");
			}System.out.println();
		}
		System.out.println("\n");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(lake[i][j]+"\t");
				if (lake[i][j]=='W') {
					dfs(i,j);
					count++;
				}
			}System.out.println();
		}
		System.out.println(count);
	}
	
	
	static void dfs(int i, int j){
		lake[i][j] = '.';
		for (int k = -1; k <= 1; k++) {
			for (int k2 = -1; k2 <= 1; k2++) {
				if (0<=i+k&&0<=j+k2&&i+k<N&&j+k2<M&&lake[i+k][j+k2] == 'W') {
					dfs(i+k,j+k2);
				}
			}
		}
	}
}
