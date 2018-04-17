package greedy;

import java.util.Scanner;

public class Change5585 {
	public static int[] coin = {500,100,50,10,5,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int change = 1000 - sc.nextInt();
		int count = 0;
		for (int i = 0; i < coin.length; i++) {
			if (change%coin[i]==0) {
				count += change/coin[i];
				break;
			}
			else {
				count += change/coin[i];
				change %= coin[i];
			}
		}
		System.out.println(count);
	}
}
