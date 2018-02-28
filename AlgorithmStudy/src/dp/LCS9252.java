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
����
LCS(Longest Common Subsequence, ���� ���� �κ� ����)������ �� ������ �־����� ��, 
����� �κ� ������ �Ǵ� ���� �� ���� �� ���� ã�� �����̴�.

���� ���, ACAYKP�� CAPCAK�� LCS�� ACAK�� �ȴ�.

�Է�
ù° �ٰ� ��° �ٿ� �� ���ڿ��� �־�����. ���ڿ��� ���ĺ� �빮�ڷθ� �̷���� ������, �ִ� 1000���ڷ� �̷���� �ִ�.

���
ù° �ٿ� �Է����� �־��� �� ���ڿ��� LCS�� ���̸�, ��° �ٿ� LCS�� ����Ѵ�.

LCS�� ���������� ��쿡�� �ƹ��ų� ����Ѵ�.

���� �Է� 
ACAYKP
CAPCAK
���� ��� 
4
ACAK
*/