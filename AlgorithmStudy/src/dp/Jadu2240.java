package dp;

import java.util.Scanner;

public class Jadu2240 {
	public static int d[][];
	public static int W; //�̵� Ƚ��
	public static int T; //��ü �ð�
	public static int []a; //�������� ��� ���
	public static int count=0; //�̵� Ƚ��
	public static void main(String[] args) {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		W = sc.nextInt();
		d = new int[T+1][W+1];
		a = new int[T+1];
		for (int i = 1; i <= T; i++) {
			a[i] = sc.nextInt();
		}
		dp();
		int max=0;
		for (int t : d[T]) {
			if (max<=t) max = t;
		}
		System.out.println(max);
		sc.close();
	}
	public static void dp(){
		for (int i = 1; i < d.length; i++) {
			for (int j = 0; j < d[i].length; j++) {
				if (j-1 >= 0) d[i][j] = Math.max(d[i-1][j-1], d[i-1][j]);
				else d[i][j] = d[i-1][j];
				int pos = j==0?1:(j%2==0?1:2); //�ȿ���, Ȧ�� �̵� = 2  ������(¦���̵�) = 2
				if (pos==a[i]) {
					d[i][j]++;
				}
			}
		}
	}
}
/*
2240��s

�ð� ����	�޸� ����	����	����	���� ���	���� ����
2 ��	128 MB	3742	1590	1091	41.546%
����
�ڵδ� �ڵθ� �����Ѵ�. �׷��� ���� �ڵγ����� �ɾ�ΰ�, ���⼭ ������ �ڵθ� �԰�� �Ѵ�.
 ������ �ڵδ� Ű�� �۾Ƽ� �ڵθ� �������� ���ϰ�, �ڵΰ� ������ ������ ��ٸ� ������ �������� �ڵθ� �޾Ƽ� �԰�� �Ѵ�. 
 �ڵθ� ���� ������ �ڵΰ� ����� ���� �� ��ƾ� �ϴµ�, �̴� �ڵΰ� ���������Ͽ� �ٴڿ� �������� �� ���� ������ �������� �����̴�.

�� �ʸ���, �� ���� ���� �� �ϳ��� �������� ���Ű� �������� �ȴ�. ���� ���Ű� �������� ����, 
�ڵΰ� �� ������ �Ʒ��� �� ������ �ڵδ� �� ���Ÿ� �޾Ƹ��� �� �ִ�. �� ���� ������ �״��� �ָ� ������ ���� �ʱ� ������, 
�ڵδ� �ϳ��� ���� �Ʒ��� �� �ִٰ� �ٸ� ���� �Ʒ��� ������(1�ʺ��� �ξ� ª�� �ð���) ������ �� �ִ�. 
������ �ڵδ� ü���� �״��� ���� ���ؼ� ���� ������ ���� ����.

�ڵδ� T(1��T��1,000)�� ���� �������� �ȴ�. �ڵδ� �ִ� W(1��W��30)���� �����̰� �;� �Ѵ�. 
�� �ʸ��� ��� �������� �ڵΰ� ���������� ���� ������ �־����� ��, �ڵΰ� ���� �� �ִ� ��
���� ������ ���س��� ���α׷��� �ۼ��Ͻÿ�. �ڵδ� 1�� �ڵγ��� �Ʒ��� ��ġ�� �ִٰ� �Ѵ�.

�Է�
ù° �ٿ� �� ���� T, W�� �־�����. ���� T���� �ٿ��� �� ������ �ڵΰ� �������� ������ ��ȣ�� 1 �Ǵ� 2�� �־�����.

���
ù° �ٿ� �ڵΰ� ���� �� �ִ� �ڵ��� �ִ� ������ ����Ѵ�.

���� �Է� 
7 2
2
1
1
2
2
1
1
���� ��� 
6
*/


//////////////////////////////////////////////////////////////DFS(�ð��ʰ�)/.////////////////////////////////////////////////////////////////////////////////////
/*
import java.util.Scanner;

public class Jadu2240 {
	public static int dp[][];
	public static int W; //�̵� Ƚ��
	public static int T; //��ü �ð�
	public static int []a; //�������� ��� ���
	public static int count=0; //�̵� Ƚ��
	public static void main(String[] args) {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		W = sc.nextInt();
		dp = new int[T+1][3];
		a = new int[T+1];
		for (int i = 1; i <= T; i++) {
			a[i] = sc.nextInt();
		}
		
		dfs(W, 1, 1, 1);
		System.out.println(Math.max(dp[T][1], dp[T][2]));
		sc.close();
	}
	
	
	public static void dfs(int left, int lastPos, int pos, int now){ //�ð��ʰ� ��.
		//now == T�̸� ����, pos�� ���� 1�� �ִ��� 2�� �ִ���., left�� ���� �̵�Ƚ��.
		
		if (now==T+1) {
			return;
		}
		if (pos==a[now]) {
			dp[now][pos] = dp[now-1][lastPos] + 1 > dp[now][pos]?dp[now-1][lastPos] + 1:dp[now][pos];
		}
		else {
			dp[now][pos] = dp[now-1][lastPos];
		}
		if (left>=1) {
			int np = pos==2?1:2;
			dfs(left-1, pos, np, now+1);//�̵�
			
			
			dfs(left, pos, pos, now+1);//���̵�
		}
		else {
			dfs(left, pos, pos, now+1);//���̵�
		}
	}
}
*/










