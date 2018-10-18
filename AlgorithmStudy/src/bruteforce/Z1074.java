package bruteforce;

import java.util.Scanner;

public class Z1074 {
	public static int N;
	public static int r;
	public static int c;
	public static int[][] table = { { 0, 1 }, { 2, 3 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		
		System.out.println(dfs(r, c, 0, N));
		sc.close();
	}

	public static int dfs(int i, int j, int order, int d) { // i,j�� r,c , order�� ����. d�� 2^N --> 1����
		int no = (int) (Math.pow(2, d-1)*Math.pow(2, (d - 1))); //2^d �簢�������� ���� ����
		int nd = (int) Math.pow(2, (d - 1)); // ���� �簢���� ũ��
		// 1��и�
		if (0 <= i && i < nd && 0 <= j && j < nd && d > 1) {
			return dfs(i, j, order, d -1);
		}
		// 2��и�
		else if (0 <= i && i < nd && Math.pow(2, d) > j && j >= nd && d > 1) {
			return dfs(i, j - nd, order + 1 * no, d -1);
		}
		// 3��и�
		else if (Math.pow(2, d) > i && i >= nd && 0 <= j && j < nd && d > 1) {
			return dfs(i - nd, j, order + 2 * no, d -1);
		}
		// 4��и�
		else if (Math.pow(2, d) > i && i >= nd && Math.pow(2, d) > j && j >= nd
				&& d > 1) {
			return dfs(i - nd, j - nd, order + 3 * no,	d -1);
		}
		else {
			return order+table[i][j];
		}
	}
}
/*
 * return order+table[i][j]; �ð� ���� �޸� ���� ���� ���� ���� ��� ���� ���� 2 �� 128 MB 5210 2346
 * 1363 42.620% ���� �Ѽ��� 2���� �迭 (�׻� 2^N * 2^N ũ���̴�)�� Z������� Ž���Ϸ��� �Ѵ�. ���� ���, 2*2�迭��
 * ���� ��ĭ, ������ ��ĭ, ���� �Ʒ�ĭ, ������ �Ʒ�ĭ ������� �湮�ϸ� Z����̴�.
 * 
 * 
 * 
 * ����, 2���� �迭�� ũ�Ⱑ 2^N * 2^N�� ���� ���� �ִ� ĭ�� �ϳ��� �ƴ϶��, �迭�� 4��� �� �Ŀ� (ũ�Ⱑ ����
 * 2^(N-1)��) ��������� ������� �湮�Ѵ�.
 * 
 * ���� ���� 2^2 * 2^2 ũ���� �迭�� �湮�� �����̴�.
 * 
 * 
 * 
 * N�� �־����� ��, (r, c)�� �� ��°�� �湮�ϴ��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * ���� �׸��� N=3�� ���� ���̴�.
 * 
 * 
 * 
 * �Է� ù° �ٿ� N r c�� �־�����. N�� 15���� �۰ų� ���� �ڿ����̰�, r�� c�� 0���� ũ�ų� ����, 2^N-1���� �۰ų� ����
 * �����̴�
 * 
 * ��� ù° �ٿ� ������ ������ ����Ѵ�.
 * 
 * ���� �Է� 2 3 1 ���� ��� 11 
 * ���� �Է� 3 7 7 ���� ��� 63
 */