package hanhwa;

import java.util.Arrays;
import java.util.Scanner;

public class Hanhwa2577 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int []a = new int[n];
		int []b = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			b[i] = sc.nextInt();
		}
		Arrays.sort(a);
		Arrays.sort(b);
		int res = 0;
		for (int i = 0; i < n; i++) {
			res+=a[i]*b[n-i-1];
		}
		System.out.println(res);
	}
}
