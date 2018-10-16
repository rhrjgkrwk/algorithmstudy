package dfsbfs;

import java.util.Scanner;

public class Algo3019 {
	public static int[][][] block = { 
			{ // 1번 도형.
					{ 0 }, { 0, 0, 0, 0 } },
			{ // 2번 도형.
					{ 0, 0 } },
			{ // 3번 도형.
					{ 0, 0, 1 }, { 1, 0 } },
			{ // 4번 도
					{ 1, 0, 0 }, { 0, 1 } },
			{ // 5
					{ 0, 0, 0 }, { 1, 0 }, { 0, 1 }, { 1, 0, 1 } },
			{ // 6
					{ 0, 0, 0 }, { 0, 0 }, { 0, 1, 1 }, { 2, 0 } },
			{ // 7
					{ 0, 0, 0 }, { 0, 0 }, { 1, 1, 0 }, { 0, 2 } } };
	public static int C, P;
	public static Scanner sc = new Scanner(System.in);
	public static int[] board;

	public static void main(String[] args) {
		int res = 0;
		C = sc.nextInt();
		P = sc.nextInt() - 1;
		board = new int[C];
		
		for (int i = 0; i < board.length; i++) {
			board[i] = sc.nextInt();
		}
		
		for (int i = 0; i < C; i++) {
			for (int dir = 0; dir < block[P].length; dir++) {
				boolean flag = true;
				
				if (block[P][dir].length > 0) {
					int prev = board[i] - block[P][dir][0];
					for (int check = 1; check < block[P][dir].length; check++) {
						if (i + check >= C) {
							flag = false;
							break;
						}
						int now = board[i + check] - block[P][dir][check];
						if (now != prev) {
							flag = false;
							break;
						}
						prev = now;
					}
				}

				if (flag) {
					res++;
				}
			}
		}
		
		System.out.println(res);
		if(sc != null) sc.close();
	}
}
