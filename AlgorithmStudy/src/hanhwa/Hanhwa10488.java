package hanhwa;

import java.util.ArrayList;
import java.util.Scanner;

public class Hanhwa10488 {
	public static ArrayList<Integer> sgs = new ArrayList<>();
	public static int res = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int testCase = 0; testCase < tc; testCase++) {
			int n = sc.nextInt();
			// n이하의 삼각수를 구한다.
			getSamgak(n);
			
			for (Integer i : sgs) {
				System.out.println(i);
			}
			
			for (int i = 0; i < sgs.size(); i++) {
				for (int j = i; j < sgs.size(); j++) {
					for (int k = j; k < sgs.size(); k++) {
						int tmp = sgs.get(i)+sgs.get(j)+sgs.get(k);
						if (tmp==n) {
							res = 1;
							break;
						}
					}
					if (res==1) {
						break;
					}
				}
				if (res==1) {
					break;
				}
			}
			System.out.println(res);
			res = 0;
		}
		sc.close();
		
	}

	public static void getSamgak(int num) {
		if (!sgs.isEmpty() && sgs.get(sgs.size()-1)>=num) { //필요한 삼각수가 이미 구해진 상태이면
			return;
		}
		
		int snum = 1;
		int lastfloor = 1;
		while (snum <= num) {
			lastfloor += 1;
			snum += lastfloor;
			if (!sgs.contains(num)) { // 이미 들어와있으면 pass
				sgs.add(snum);
			}
		}
	}
	
}
