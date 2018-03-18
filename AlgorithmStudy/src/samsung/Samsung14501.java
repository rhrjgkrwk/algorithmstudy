package samsung;

import java.util.Scanner;

public class Samsung14501 {
	public static int schedule[][];
	public static int d[];
	public static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		schedule = new int[N][2]; //0 : 일수 1 : 페이 
		d = new int[N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2; j++) {
				schedule[i][j] = sc.nextInt();
			}
		}
		sc.close();
	}
	public static void dp() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= i; j++) {
			}
		}
	}
}
