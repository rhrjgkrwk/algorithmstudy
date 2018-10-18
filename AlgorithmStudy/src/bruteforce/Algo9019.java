package bruteforce;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Comm {
	int num;
	StringBuilder comm;

	public Comm(int num, String comm) {
		super();
		this.num = num;
		this.comm = new StringBuilder(comm);
	}

}

public class Algo9019 {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int testCase = sc.nextInt();
		for (int tc = 0; tc < testCase; tc++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			boolean visit[] = new boolean[10000];
			Queue<Comm> q = new LinkedList<>();
			Comm res = null;
			q.add(new Comm(A, ""));
			visit[A] = true;
			while (!q.isEmpty()) {
				Comm now = q.poll();
				if (now.num == B) {
					res = now;
					break;
				}

				int d = D(now.num);
				int s = S(now.num);
				int r = R(now.num);
				int l = L(now.num);

				if (!visit[d]) {
					visit[d] = true;
					q.add(new Comm(d, now.comm + "D"));
				}
				if (!visit[s]) {
					visit[s] = true;
					q.add(new Comm(s, now.comm + "S"));
				}
				if (!visit[l]) {
					visit[l] = true;
					q.add(new Comm(l, now.comm + "L"));
				}
				if (!visit[r]) {
					visit[r] = true;
					q.add(new Comm(r, now.comm + "R"));
				}
			}

			System.out.println(res.comm);
		}
	}

	public static int D(int n) {
		return (n * 2) % 10000;
	}

	public static int S(int n) {
		return (10000 + n - 1) % 10000;
	}

	public static int R(int n) {
		StringBuilder str = new StringBuilder(String.valueOf(n));
		while (str.length() < 4) {
			str.insert(0, "0");
		}

		char temp = str.charAt(3);
		str.deleteCharAt(3);
		str.insert(0, temp);

		return Integer.parseInt(str.toString());
	}

	public static int L(int n) {
		StringBuilder str = new StringBuilder(String.valueOf(n));
		while (str.length() < 4) {
			str.insert(0, "0");
		}

		char temp = str.charAt(0);
		str.deleteCharAt(0);
		str.append(temp);

		return Integer.parseInt(str.toString());
	}
}
