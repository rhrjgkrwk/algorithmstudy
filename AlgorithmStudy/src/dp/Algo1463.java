package dp;

import java.util.Scanner;

public class Algo1463 {
	public static int X;
	public static int d[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		X = sc.nextInt();
		d = new int[X+1];
		
		System.out.println(dynamicProgramming());
		
//		for (int i = 1; i < d.length; i++) {
//			System.out.print(d[i] + " ");
//		}
		
	}
	public static int dynamicProgramming() { 
		d[0] = 0;
		d[1] = 0;

		if (X < 2) {
			return d[X];
		}
		
		int n = 2;
		while (true) {
			int temp = Math.min(d[n%2==0 ? n/2 : n-1], Math.min(d[n%3==0 ? n/3 : n-1], d[n-1]));
			d[n++] = temp + 1;
			if (n > X) {
				return d[X];
			}
		}
	}
}

//1로만들기.