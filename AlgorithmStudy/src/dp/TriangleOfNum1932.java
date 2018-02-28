package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TriangleOfNum1932 {
	public static int [][]d = new int[501][501];
	public static int [][]a = new int[501][501];
	public static int n;
	//public static int []direction = {-1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		for (int i = 1; i <= n ; i++) {
			int j = 1;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			while (st.hasMoreTokens()) {
				a[i][j] = Integer.parseInt(st.nextToken());
				
				j++;
			}
		}
		dp();
		int max = 0;
		for (int tmp : d[n]) {
			if (max < tmp) {
				max = tmp;
			}
		}
		System.out.println(max);
	}
	public static void dp(){
		for (int i = 1; i <= n ; i++) {
			for (int j = 1; j <= i; j++) { //d[i][j] i�� j�������� �ִ밪
				d[i][j] = (j-1<0)? (d[i-1][j]+a[i][j]) : (j>i)? (d[i-1][j]+a[i][j]) : Math.max(d[i-1][j]+a[i][j], d[i-1][j-1]+a[i][j]);	
			}
		}
		/*for (int i = 1; i <= n ; i++) {
			for (int j = 1; j <= i; j++) { //d[i][j] i�� j�������� �ִ밪
				System.out.print(d[i][j]+" ");
			}System.out.println();
		}*/
	}
}

/*
���ڻﰢ�� ���� Ǯ��
�ð� ����	�޸� ����	����	����	���� ���	���� ����
2 ��	128 MB	13297	7538	5449	58.036%
����
        7
      3   8
    8   1   0
  2   7   4   4
4   5   2   6   5
�� �׸��� ũ�Ⱑ 5�� ���� �ﰢ���� �� ����̴�.

�� ���� 7���� �����ؼ� �Ʒ��� �ִ� �� �� �ϳ��� �����Ͽ� �Ʒ������� ������ ��, 
�������� ���õ� ���� ���� �ִ밡 �Ǵ� ��θ� ���ϴ� ���α׷��� �ۼ��϶�. 
�Ʒ����� �ִ� ���� ���� ������ ���õ� ���� �밢�� ���� �Ǵ� �밢�� �����ʿ� �ִ� �� �߿����� ������ �� �ִ�.

�ﰢ���� ũ��� 1 �̻� 500 �����̴�. 
�ﰢ���� �̷�� �ִ� �� ���ڴ� ��� �����̸�, ������ 0 �̻� 9999 �����̴�.

�Է�
ù° �ٿ� �ﰢ���� ũ�� n(1 �� n �� 500)�� �־�����, 
��° �ٺ��� n+1�ٱ��� ���� �ﰢ���� �־�����.

���
ù° �ٿ��� �ִ밡 �Ǵ� ���� ����Ѵ�.

���� �Է� 
5
7
3 8
8 1 0
2 7 4 4
4 5 2 6 5
���� ��� 
30
*/