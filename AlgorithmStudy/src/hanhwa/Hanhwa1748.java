package hanhwa;

import java.util.Scanner;

public class Hanhwa1748 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int res = 0;
		for (int i = 1; i <= n; i++) {
			res+=String.valueOf(i).length();
		}
		System.out.println(res);
	}
	
}
