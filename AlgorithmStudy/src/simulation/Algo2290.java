package simulation;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Algo2290 {
	public static Scanner sc = new Scanner(System.in);
	public static int S;
	public static String N;
	public static char[][][] display;
	public static char[][] blank;

	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
		S = Integer.parseInt(st.nextToken());
		N = st.nextToken();
		display = new char[N.length()][2 * S + 3][S + 2];
		blank = new char[2 * S + 3][1];

		int horizental = S + 2;
		int vertical = 2 * S + 3;

		for (int i = 0; i < blank.length; i++) {
			Arrays.fill(blank[i], ' ');
		}

		for (int i = 0; i < display.length; i++) {
			for (int j = 0; j < display[i].length; j++) {
				Arrays.fill(display[i][j], ' ');
			}
		}

		for (int idx = 0; idx < N.length(); idx++) {
			char now = N.charAt(idx);
			switch (now) {
			case '0':
				for (int i = 0; i < display[idx].length; i++) {
					if (i == 0 || i == vertical - 1) {
						// --
						for (int j = 1; j < display[idx][i].length - 1; j++) {
							display[idx][i][j] = '-';
						}
					}
					if ((0 < i && i < (vertical - 1) / 2) || (vertical - 1 > i && i > (vertical - 1) / 2)) {
						display[idx][i][0] = '|';
						display[idx][i][horizental - 1] = '|';
					}
					// if (i == (vertical - 1) / 2) {
					//
					// }
				}
				break;
			case '1':
				for (int i = 0; i < display[idx].length; i++) {
					if ((0 < i && i < (vertical - 1) / 2) || (vertical - 1 > i && i > (vertical - 1) / 2)) {
						display[idx][i][horizental - 1] = '|';
					}
				}
				break;
			case '2':
				for (int i = 0; i < display[idx].length; i++) {
					if (i == 0 || i == vertical - 1) {
						for (int j = 1; j < display[idx][i].length - 1; j++) {
							display[idx][i][j] = '-';
						}
					}
					if (0 < i && i < (vertical - 1) / 2) {
						display[idx][i][horizental - 1] = '|';
					}
					if (vertical - 1 > i && i > (vertical - 1) / 2) {
						display[idx][i][0] = '|';
					}
					if (i == (vertical - 1) / 2) {
						for (int j = 1; j < display[idx][i].length - 1; j++) {
							display[idx][i][j] = '-';
						}
					}
				}
				break;
			case '3':
				for (int i = 0; i < display[idx].length; i++) {
					if (i == 0 || i == vertical - 1) {
						for (int j = 1; j < display[idx][i].length - 1; j++) {
							display[idx][i][j] = '-';
						}
					}
					if ((0 < i && i < (vertical - 1) / 2) || (vertical - 1 > i && i > (vertical - 1) / 2)) {
						display[idx][i][horizental - 1] = '|';
					}
					if (i == (vertical - 1) / 2) {
						for (int j = 1; j < display[idx][i].length - 1; j++) {
							display[idx][i][j] = '-';
						}
					}
				}
				break;
			case '4':
				for (int i = 0; i < display[idx].length; i++) {
					if (0 < i && i < (vertical - 1) / 2) {
						display[idx][i][0] = '|';
						display[idx][i][horizental - 1] = '|';
					}
					if (vertical - 1 > i && i > (vertical - 1) / 2) {
						display[idx][i][horizental - 1] = '|';
					}
					if (i == (vertical - 1) / 2) {
						for (int j = 1; j < display[idx][i].length - 1; j++) {
							display[idx][i][j] = '-';
						}
					}
				}
				break;
			case '5':
				for (int i = 0; i < display[idx].length; i++) {
					if (i == 0 || i == vertical - 1) {
						for (int j = 1; j < display[idx][i].length - 1; j++) {
							display[idx][i][j] = '-';
						}
					}
					if (0 < i && i < (vertical - 1) / 2) {
						display[idx][i][0] = '|';
					}
					if (vertical - 1 > i && i > (vertical - 1) / 2) {
						display[idx][i][horizental - 1] = '|';
					}
					if (i == (vertical - 1) / 2) {
						for (int j = 1; j < display[idx][i].length - 1; j++) {
							display[idx][i][j] = '-';
						}
					}
				}
				break;
			case '6':
				for (int i = 0; i < display[idx].length; i++) {
					if (i == 0 || i == vertical - 1) {
						for (int j = 1; j < display[idx][i].length - 1; j++) {
							display[idx][i][j] = '-';
						}
					}
					if (0 < i && i < (vertical - 1) / 2) {
						display[idx][i][0] = '|';
					}
					if (vertical - 1 > i && i > (vertical - 1) / 2) {
						display[idx][i][0] = '|';
						display[idx][i][horizental - 1] = '|';
					}
					if (i == (vertical - 1) / 2) {
						for (int j = 1; j < display[idx][i].length - 1; j++) {
							display[idx][i][j] = '-';
						}
					}
				}
				break;
			case '7':
				for (int i = 0; i < display[idx].length; i++) {
					if (i == 0) {
						// --
						for (int j = 1; j < display[idx][i].length - 1; j++) {
							display[idx][i][j] = '-';
						}
					}
					if ((0 < i && i < (vertical - 1) / 2) || (vertical - 1 > i && i > (vertical - 1) / 2)) {
						display[idx][i][horizental - 1] = '|';
					}
				}
				break;
			case '8':
				for (int i = 0; i < display[idx].length; i++) {
					if (i == 0 || i == vertical - 1) {
						for (int j = 1; j < display[idx][i].length - 1; j++) {
							display[idx][i][j] = '-';
						}
					}
					if (0 < i && i < (vertical - 1) / 2) {
						display[idx][i][0] = '|';
						display[idx][i][horizental - 1] = '|';
					}
					if (vertical - 1 > i && i > (vertical - 1) / 2) {
						display[idx][i][0] = '|';
						display[idx][i][horizental - 1] = '|';
					}
					if (i == (vertical - 1) / 2) {
						for (int j = 1; j < display[idx][i].length - 1; j++) {
							display[idx][i][j] = '-';
						}
					}
				}
				break;
			case '9':
				for (int i = 0; i < display[idx].length; i++) {
					if (i == 0 || i == vertical - 1) {
						for (int j = 1; j < display[idx][i].length - 1; j++) {
							display[idx][i][j] = '-';
						}
					}
					if (0 < i && i < (vertical - 1) / 2) {
						display[idx][i][0] = '|';
						display[idx][i][horizental - 1] = '|';
					}
					if (vertical - 1 > i && i > (vertical - 1) / 2) {
						display[idx][i][horizental - 1] = '|';
					}
					if (i == (vertical - 1) / 2) {
						for (int j = 1; j < display[idx][i].length - 1; j++) {
							display[idx][i][j] = '-';
						}
					}
				}
				break;

			default:
				break;
			}
		}

		for (int i = 0; i < vertical; i++) {
			for (int j = 0; j < display.length; j++) {
				for (int k = 0; k < horizental; k++) {
					System.out.print(display[j][i][k]);
				}
				System.out.print(" ");
			}
			System.out.println();
		}

	}
}

/*
 * -- -- -- -- -- -- -- -- | | | | | | | | | | | | | | | | | | | | | | | | | | |
 * | -- -- -- -- -- -- -- | | | | | | | | | | | | | | | | | | | | | | | | | | --
 * -- -- -- -- -- --
 */