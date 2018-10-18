package simulation;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class P3190 {
	int x;
	int y;

	public P3190(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

class Command {
	int X;
	int C;
	public Command(int x, int c) {
		super();
		X = x;
		C = c;
	}
	
}

public class Algo3190 {
	public static int[] dx = { 0, 1, 0, -1 };
	public static int[] dy = { 1, 0, -1, 0 }; // 오른 아래 왼쪽 위.
	public static Scanner sc = new Scanner(System.in);

	public static Deque<P3190> dq = new LinkedList<>();
	public static int dir;
	public static int time = 0;
	public static int N, K, L;
	public static int[][] map;

	public static boolean check(int x, int y) {
		for (P3190 p : dq) {
			if (p.x == x && p.y == y) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		N = sc.nextInt();
		map = new int[N][N];
		K = sc.nextInt();
		for (int i = 0; i < K; i++) {
			int r = sc.nextInt() - 1;
			int c = sc.nextInt() - 1;
			map[r][c] = 2;
		}

		dir = 0;
		dq.add(new P3190(0, 0));
		L = sc.nextInt();

		Queue<Command> q = new LinkedList<>();
		for (int i = 0; i < L; i++) {
			int X = sc.nextInt();
			char C = sc.next().charAt(0);
			q.add(new Command(X, C));
		}
		
		while(!q.isEmpty()) {
			Command comm = q.poll();
			int X = comm.X;
			int C = comm.C;
			while (time < X) { // 전진.
				P3190 now = dq.peekFirst();
				int nx = now.x + dx[dir];
				int ny = now.y + dy[dir];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || check(nx, ny)) {
					System.out.println(time + 1);
					return;
				} else {
					if (map[nx][ny] == 2) {
						map[nx][ny] = 0;
						dq.addFirst(new P3190(nx, ny));
					} else {
						dq.addFirst(new P3190(nx, ny));
						dq.removeLast();
					}
				}
				time++;
			}
			
			// X초 후. 방향 전환.
			switch (C) {
			case 'D': // right
				dir = (dir + 1) % 4;
				break;
			case 'L': // left
				dir = (dir + 3) % 4;
				break;
			}
		}
		

		// 뱀이 아직 살아있으면 벽에다 갖다 박도록 한다.
		while (true) {
			P3190 now = dq.peekFirst();
			int nx = now.x + dx[dir];
			int ny = now.y + dy[dir];
			if (nx < 0 || nx >= N || ny < 0 || ny >= N || check(nx, ny)) {
				System.out.println(time + 1);
				return;
			} else {
				if (map[nx][ny] == 2) {
					map[nx][ny] = 0;
					dq.addFirst(new P3190(nx, ny));
				} else {
					dq.addFirst(new P3190(nx, ny));
					dq.removeLast();
				}
			}
			time++;
		}
	}
}
