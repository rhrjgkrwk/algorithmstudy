package dfsbfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

class Status {
	String str;
	int count;
	public Status(String str, int count) {
		super();
		this.str = str;
		this.count = count;
	}
}

public class Algo1525 {
	public static Scanner sc = new Scanner(System.in);
	public static Set<String> set = new HashSet<>();
	public static void main(String[] args) {
		Queue<Status> q = new LinkedList<>();
		String initialStatus = "";
		for (int i = 0; i < 9; i++) {
			initialStatus += sc.nextInt();
		}
		int res = -1;
		
		set.add(initialStatus);
		q.add(new Status(initialStatus, 0));
		while (!q.isEmpty()) {
			Status now = q.poll();
			int zeroIndex = now.str.indexOf('0');
			
			if (now.str.equals("123456780")) {
				res = now.count;
				break;
			}
			
			if (zeroIndex + 3 < 9) { // 상.
				String next = swap(now.str, zeroIndex, zeroIndex + 3);
				if (!set.contains(next)) {
					Status temp = new Status(next, now.count+1);
					set.add(next);
					q.add(temp);
				}
			}
			if (zeroIndex - 3 > 0) { // 하.
				String next = swap(now.str, zeroIndex, zeroIndex - 3);
				if (!set.contains(next)) {
					Status temp = new Status(next, now.count+1);
					set.add(next);
					q.add(temp);
				}
			} 
			if (zeroIndex % 3 - 1 >= 0) { // 좌. 
				String next = swap(now.str, zeroIndex, zeroIndex - 1);
				if (!set.contains(next)) {
					Status temp = new Status(next, now.count+1);
					set.add(next);
					q.add(temp);
				}
			}
			if (zeroIndex % 3 + 1 < 3) { // 우.
				String next = swap(now.str, zeroIndex, zeroIndex + 1);
				if (!set.contains(next)) {
					Status temp = new Status(next, now.count+1);
					set.add(next);
					q.add(temp);
				}
			}
		}
		
		System.out.println(res);
	}
	public static String swap(String str, int i, int j) {
		StringBuilder sb= new StringBuilder(str);
		char temp = sb.charAt(i);
		sb.setCharAt(i, sb.charAt(j));
		sb.setCharAt(j, temp);
		return sb.toString();
	}
}
/*



+3 +1 -1 

012
345
678
*/