package etc;

import java.util.Scanner;

public class Yutnori2490 {		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = "EABCD";
		for (int i = 0; i < 3; i++) {
			int count = 0;
			for (int j = 0; j < 4; j++) {
				if (sc.nextInt()==0) { //¹èÀÇ °¹¼ö
					count++;
				}
			}
			System.out.println(str.charAt(count));
		}
		sc.close();
	}
}
