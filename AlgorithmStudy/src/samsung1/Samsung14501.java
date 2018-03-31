package samsung1;

import java.util.Scanner;

public class Samsung14501 {
	public static int schedule[][];
	public static int d[];
	public static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		schedule = new int[N+1][2]; //0 : 일수 1 : 페이 
		//startDate = i
		//endDate = startDate(i) + [i][0] -1
		
		d = new int[N+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < 2; j++) {
				schedule[i][j] = sc.nextInt();
			}
		}
		dp();
		System.out.println(d[N]);
		sc.close();
	}
	public static void dp() {
		if (schedule[1][0]==1) {
			d[1]=schedule[1][1];
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				int endDate = j + schedule[j][0] -1;
				if (endDate <= i && d[i] < d[j-1]+schedule[j][1]) {
					d[i] = d[j-1]+schedule[j][1];
				}
			}
		}
	}
}
