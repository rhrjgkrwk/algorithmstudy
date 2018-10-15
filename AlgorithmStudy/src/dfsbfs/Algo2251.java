package dfsbfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

class Water {
	int a, b, c;
	int depth;

	public Water(int a, int b, int c, int depth) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		this.depth = depth;
	}
}

public class Algo2251 {
	public static Scanner sc = new Scanner(System.in);
	public static int A, B, C;

	public static void main(String[] args) {
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		Water s = new Water(0, 0, C, 0);
		Set<Integer> cset = new HashSet<>();
		Queue<Water> q = new LinkedList<>();
		
		cset.add(s.c);
		q.add(s);
		
		while (!q.isEmpty()) {
			Water now = q.poll();
			if (now.depth > 3) {
				break;
			}
			
		}
	}
}
