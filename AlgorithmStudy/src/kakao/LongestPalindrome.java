package kakao;

import java.util.Scanner;

public class LongestPalindrome {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(new LongestPalindrome().solution(sc.nextLine()));
	}

	public int solution(String s) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < s.length(); i++) {
			for (int j = s.length()-1; j >= i; ) {
				if (s.charAt(i) == s.charAt(j)) {
					String str = s.substring(i, j+1);
//					System.out.println(str);
					String reversedStr = new StringBuffer(str).reverse().toString();
					if (str.equals(reversedStr) && str.length() > max) {
						max = str.length();
					}
				}
				j--;
			}
		}
		return max;
//		재귀.. 시간초과..
//		if (s.equals(rs)) {
//			return s.length();
//		} else {
//			int a = solution(s.substring(0, s.length() - 1));
//			int b = solution(s.substring(1, s.length()));
//			return Math.max(a, b);
//		}
	}
}
