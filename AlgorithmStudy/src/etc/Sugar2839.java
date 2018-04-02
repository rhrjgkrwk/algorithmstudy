package etc;

import java.util.Scanner;

public class Sugar2839 {
	public static int d[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		d = new int[N+6];
		for (int i = 1; i < 6; i++) {
			if (i%3==0) {
				d[i]=i/3;
			}
			if (i%5==0) {
				d[i]=i/5;
			}
		}
		for (int i = 6; i <= N; i++) {
			d[i] =  Math.min(d[i-3]==0?5000:d[i-3]+1, d[i-5]==0?5000:d[i-5]+1);
		}
		System.out.println((d[N]==5000||d[N]==0)?-1:d[N]);
	}
}
