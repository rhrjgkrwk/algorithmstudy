package kakao;

import java.util.Scanner;

public class SecretMap {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String arr1[] = new String[n];
		String arr2[] = new String[n];
		
		for (int i = 0; i < n*2; i++) {
			if (i < n) {
				String temp = Integer.toBinaryString(sc.nextInt());
				while (temp.length() != n) {
					temp = '0' + temp;
				}
				arr1[i] = temp;
			}
			else {
				String temp = Integer.toBinaryString(sc.nextInt());
				while (temp.length() != n) {
					temp = '0' + temp;
				}
				arr2[i-n] = temp;
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr1[i].charAt(j) == '0' && arr2[i].charAt(j) =='0') {
					System.out.print(" ");
					continue;
				}
				else {
					System.out.print("#");
				}
			}System.out.println();
		}
	}
}
