package bruteforce;
import java.util.Scanner;

public class Bubunhap {
	public static int N;
	public static int S;
	public static int []A;
	public static int count=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		solve(0,0,0);
		System.out.println(count);
		sc.close();
	}
	public static void solve(int i, int sum, int chk){ 
		//chk�� �ƹ��͵� �ȸ��� ��츦 �����ϱ� ���ؼ� ���� ������ üũ
		
		if (i==N&&sum==S && chk > 0) {
			count++;
		}
		if (i<=N-1) {
			solve(i+1, sum, chk);
			solve(i+1, sum+A[i], chk+1);
		}
	}
}


/*
�ð� ����	�޸� ����	����	����	���� ���	���� ����
2 ��	128 MB	8799	4032	2570	44.090%
����
N���� ������ �̷���� ������ ���� ��, �� ������ �������� �ƴ� �κ����� �߿��� �� ������ ���Ҹ� �� ���� ���� S�� �Ǵ� ����� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ������ ������ ��Ÿ���� N�� ���� S�� �־�����. (1��N��20, |S|��1,000,000) ��° �ٿ� N���� ������ �� ĭ�� ���̿� �ΰ� �־�����. �־����� ������ ���밪�� 100,000�� ���� �ʴ´�. ���� ���� ������ �־��� ���� �ִ�.

���
ù° �ٿ� ���� S�� �Ǵ� �κ������� ������ ����Ѵ�.

���� �Է� 
5 0
-7 -3 -2 5 8
5 12
1 3 5 7 9
���� ��� 
1
*/