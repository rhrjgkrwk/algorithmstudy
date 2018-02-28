package dp;

import java.util.Scanner;

public class LCS9252 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String si = " "+sc.nextLine();
		String sj = " "+sc.nextLine();
		int [][] d = new int[si.length()][sj.length()];
		for (int i = 1; i < si.length(); i++) {
			for (int j = 1; j < sj.length(); j++) {
				if (si.charAt(i)==sj.charAt(j)) {
					d[i][j]=d[i-1][j-1]+1;
				}
				else {
					d[i][j]=Math.max(d[i][j-1],d[i-1][j]);	
				}
				System.out.printf("d[%d][%d] = %d " ,i, j, d[i][j]);
			}System.out.println();
		}
		System.out.println(d[si.length()-1][sj.length()-1]);
		sc.close();
	}
}

/*
문제
LCS(Longest Common Subsequence, 최장 공통 부분 수열)문제는 두 수열이 주어졌을 때, 
모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제이다.

예를 들어, ACAYKP와 CAPCAK의 LCS는 ACAK가 된다.

입력
첫째 줄과 둘째 줄에 두 문자열이 주어진다. 문자열은 알파벳 대문자로만 이루어져 있으며, 최대 1000글자로 이루어져 있다.

출력
첫째 줄에 입력으로 주어진 두 문자열의 LCS의 길이를, 둘째 줄에 LCS를 출력한다.

LCS가 여러가지인 경우에는 아무거나 출력한다.

예제 입력 
ACAYKP
CAPCAK
예제 출력 
4
ACAK
*/