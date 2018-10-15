package dfsbfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Line {
	int a;
	int b;
	boolean visit = false;
	public Line(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

}

public class Algo15684 {
	public static Scanner sc = new Scanner(System.in);
	public static ArrayList<Line> possibleLines = new ArrayList<>();
	public static int N, M, H;
	public static int numOfTraverse = 0;
	public static int min = Integer.MAX_VALUE;
	public static int[][] sadari;

	public static boolean check() { // 불가능 = -1, 가능 = 라인수 리턴;
		boolean flag = true;
		for (int i = 1; i <= N; i++) {
			int posN = i;
			int posH = 1;
			while (posH <= H) {
				posN += sadari[posH][posN];
				posH++;
			}
			if (i != posN) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	public static boolean isItPossible(int a, int b) {
		if (sadari[a][b] != 0) {
			return false;
		} else if (sadari[a][b + 1] != 0) {
			return false;
		}
		return true;
	}

	public static void printSadari() {
		for (int i = 1; i < sadari.length; i++) {
			for (int j = 1; j < sadari[i].length; j++) {
				System.out.print(sadari[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static void solve(int lineIndex, int numOfLine) {
		numOfTraverse++;
		if (check()) {
			if (min > numOfLine) {
				min = numOfLine;
			}
			return;
		}

		if (lineIndex == possibleLines.size() || numOfLine > 3 || numOfLine >= min - 1) {
			return;
		}

		Line now = possibleLines.get(lineIndex);
		if (isItPossible(now.a, now.b)) {
			sadari[now.a][now.b] = 1;
			sadari[now.a][now.b + 1] = -1;
			solve(lineIndex + 1, numOfLine + 1);
			sadari[now.a][now.b] = 0;
			sadari[now.a][now.b + 1] = 0;
		}
		
		if (numOfLine < min - 1)
			solve(lineIndex + 1, numOfLine);
	}

	public static void main(String[] args) {
		N = sc.nextInt();
		M = sc.nextInt();
		H = sc.nextInt();
		sadari = new int[H + 1][N + 1];

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			sadari[a][b] = 1;
			sadari[a][b + 1] = -1;
		}
		for (int a = 1; a <= H; a++) {
			for (int b = 1; b < N; b++) {
				if (isItPossible(a, b)) {
					possibleLines.add(new Line(a, b));
				}
			}
		}

		
		int[] arr = {1,6,3,4,5};
		Arrays.sort(arr);
		
//		Arrays.sort(arr, new Comparator<Integer>() {
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				return o2 - o1;
//			}
//			
//		});
		for (int i : arr) {
			System.out.println(i);
		}
		
		solve(0, 0);
		System.out.println(min > 3 ? -1 : min);
		System.out.println(numOfTraverse);
	}
}
