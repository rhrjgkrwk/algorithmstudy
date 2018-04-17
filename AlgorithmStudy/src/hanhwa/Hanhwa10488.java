package hanhwa;

import java.util.ArrayList;
import java.util.Scanner;

public class Hanhwa10488 {
	public static ArrayList<Integer> sgs = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int testCase = 0; testCase < tc; testCase++) {
			int n = sc.nextInt();
			// n이하의 삼각수를 구한다.
			getSamgak(n);
			System.out.println(isEureka(n, 0, 0));
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
			lastfloor += 2;
			snum += lastfloor;
			if (!sgs.contains(num)) { // 이미 들어와있으면 pass
				sgs.add(snum);
			}
		}
	}
	
	public static int isEureka(int num, int depth, int sum){
		if (depth==3) {
			if (sum==num) {
				return 1;
			}
			else return 0;
		}
		//return 1; //possible
		for (Integer i : sgs) {
			if (i <= num/3) {
				isEureka(num, depth+1, sum+i);
			}
			else break;
		}
		return 0;
	}
}
