package dp;

import java.util.Scanner;

public class GreedyPig3060 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		for (int i = 0; i < K; i++) {
			int N = sc.nextInt();
			int sum = 0;
			int day = 1;
			for (int j = 0; j < 6; j++) {
				sum+=sc.nextInt();
			}
			while (N>=Math.pow(4, day-1)*sum) {
				day++;
			}
			System.out.println(day);
		}
	}
}
