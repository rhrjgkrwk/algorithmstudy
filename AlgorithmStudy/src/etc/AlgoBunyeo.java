package etc;
import java.util.Scanner;

/*����
��� �ݻ�ȸ�� �����ϴ� ���� �����ϴ� ����� �̹� ��ȸ�� �γ�ȸ���� �ǰ� �;� �� ���� ������� �ҷ� ��� �ݻ�ȸ�� �����Ϸ��� �Ѵ�.

�� ����Ʈ�� ���ָ� �Ϸ��� ������ �ִµ�, ��a ���� b ȣ�� ����� �ڽ��� �Ʒ�(a-1)���� 1ȣ���� b ȣ���� ������� ���� �ո�ŭ ������� ������ ��ƾ��Ѵ١� �� ��� ������ �� ��Ű�� ���;� �Ѵ�.

����Ʈ�� ����ִ� ���� ���� ��� ���ֹε��� �� ��� ������ ��Ű�� �Դٰ� ���� ���� ��, �־����� ���� ���� k�� n�� ���� k���� nȣ���� �� ���� ��� �ֳ��� ����϶�. ��, ����Ʈ���� 0������ �ְ� �������� 1ȣ���� ������, 0���� iȣ���� i���� ���.

�Է�
ù ��° �ٿ� Test case�� �� T�� �־�����. �׸��� ������ ���̽����� �Է����� ù ��° �ٿ� ���� k, �� ��° �ٿ� ���� n�� �־�����. (1 <= k <= 14, 1 <= n <= 14)

���
������ Test case�� ���ؼ� �ش� ���� ���ֹ� ���� ����϶�.*/

/*�����Է�
2
1
3
2
3

���� ��� 
6
10
*/



//N(k) = N-1(k) N(k-1)

public class AlgoBunyeo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		int K;
		int N;
		int resultTable[][] = new int[15][15];
		int lastK=1;
		for (int i = 1; i <= 14; i++) {
			resultTable[0][i] = i;
			resultTable[i][0] = 0;			
		}
		for (int t = 0; t < T; t++) {//test case
			K=sc.nextInt();
			N=sc.nextInt();
			if (resultTable[N][K]==0) { // ã������ ���� ���̺� ����� �Ǿ����� �ʴٸ�.
				for (int i = 1; i <= K; i++) {
					for (int j = 1; j <= N; j++) {
						resultTable[i][j] = resultTable[i-1][j] + resultTable[i][j-1];
					}
				}
				lastK = K; //���� test���� �ۼ��ߴ� �ε���.
			}
			System.out.println(resultTable[K][N]);
		}
		sc.close();	
	}
}
