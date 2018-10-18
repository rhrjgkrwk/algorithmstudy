package etc;

import java.util.Scanner;

public class Algo12904 {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		StringBuilder S = new StringBuilder(sc.nextLine());
		StringBuilder T = new StringBuilder(sc.nextLine());
		System.out.println(isItPossible(S, T));
	}

	public static int isItPossible(StringBuilder S, StringBuilder T) {
		while (T.length() >= S.length()) {
			if (T.toString().equals(S.toString())) {
				return 1;
			}

			if (T.charAt(T.length() - 1) == 'A') {
				T.deleteCharAt(T.length() - 1);
			} else {
				T.deleteCharAt(T.length() - 1);
				T = T.reverse();
			}
		}
		return 0;
	}
}
