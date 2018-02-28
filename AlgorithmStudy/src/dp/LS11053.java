package dp;

import java.util.Scanner;

public class LS11053 {
	public static int []d=new int[1002];
	public static int a[] = new int[1002];
	public static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N  = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
			d[i] = 1;
		}
		dp();
		int max = 0;
		for (int i = 0; i < N; i++) {
			if (max<d[i]) {
				max = d[i];
			}
		}System.out.println(max);
		sc.close();
	}
	public static void dp(){
		for (int i = 0; i < N; i++) {
			int max = 0; //d[0~i-1] �� �ִ밪�� ����.
			for (int j = 0; j < i; j++) {
				if (a[i]>a[j] && max<=d[j]) {
					max = d[j];
				}
			}
			d[i] = max==0?1:max+1;
		}
	}
}
/*
11053��
���� �� �����ϴ� �κ� ���� Ǯ��
�ð� ����	�޸� ����	����	����	���� ���	���� ����
1 ��	256 MB	15805	6164	4279	38.967%
����
���� A�� �־����� ��, ���� �� �����ϴ� �κ� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

���� ���, ���� A = {10, 20, 10, 30, 20, 50} �� ��쿡 
���� �� �����ϴ� �κ� ������ A = {10, 20, 10, 30, 20, 50} �̰�, ���̴� 4�̴�.

�Է�
ù° �ٿ� ���� A�� ũ�� N (1 �� N �� 1,000)�� �־�����.

��° �ٿ��� ���� A�� �̷�� �ִ� Ai�� �־�����. (1 �� Ai �� 1,000)

���
ù° �ٿ� ���� A�� ���� �� �����ϴ� �κ� ������ ���̸� ����Ѵ�.

���� �Է� 
6
10 20 10 30 20 50
���� ��� 
4
*/