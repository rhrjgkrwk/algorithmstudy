package dp;
import java.util.Scanner;
//��ǰ..
public class Coin2293 {
	public static int d[][];
	public static int coin[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		d = new int[n+1][k+1];
		coin = new int[n+1];
		for (int i = 1; i <= n; i++) {
			coin[i] = sc.nextInt();
		}
		sc.close();
		//System.out.println(dp(k));
	}
	/*public static int dp(int k){
		//C[c,m] = 
	}*/
}

/*
���� 1 Ǯ��
�ð� ����	�޸� ����	����	����	���� ���	���� ����
2 ��	4 MB	13169	5329	3936	39.899%
����
n���� ������ ������ �ִ�. ������ ������ ��Ÿ���� ��ġ�� �ٸ���. 
�� �������� ������ ����ؼ�, �� ��ġ�� ���� k���� �ǵ��� �ϰ� �ʹ�. 
�� ����� ���� ���Ͻÿ�. (������ ������ �� ���� ����� �� �ִ�.)

�Է�
ù°�ٿ� n, k�� �־�����. (1 �� n �� 100, 1 �� k �� 10,000) ���� n���� �ٿ��� ������ ������ ��ġ�� �־�����.

���
ù° �ٿ� ����� ���� ����Ѵ�. ����� ���� 2^31���� �۴�.

���� �Է� 
3 10
1
2
5
���� ��� 
10

*/