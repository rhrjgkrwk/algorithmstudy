package etc;

import java.util.Scanner;

public class Algo12871 {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		String s = sc.nextLine();
		String t = sc.nextLine();
		int maxLen = s.length() > t.length() ? s.length() : t.length();
		for (int i = 0; i < maxLen * 2; i++) {
			if(s.charAt(i % s.length()) != t.charAt(i % t.length())) {
				System.out.println(0);
				return;
			}
		}
		System.out.println(1);
	}
}
