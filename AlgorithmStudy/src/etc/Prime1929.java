package etc;

import java.util.Scanner;

public class Prime1929 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		// prime number�� ã�ƺ���
		for (int i = M; i <= N; i++) {
			boolean flag = true;
			
			if (i != 1 && i%2!=0) {
				for (int j = 2; j <= i / 2; j++) {
					if (i % j == 0) {
						flag = false;
						break;
					}
				}
				if (flag) {
					System.out.println(i);
				}
				i++;
			}
		}
		sc.close();
	}
}
/*
�����佺�׳׽��� ü�� N���� �۰ų� ���� ��� �Ҽ��� ã�� ������ �˰����̴�.

�� �˰����� ������ ����.

2���� N���� ��� ������ ���´�.
���� ������ ���� ���� �� ���� ���� ���� ã�´�. �̰��� P��� �ϰ�, �� ���� �Ҽ��̴�.
P�� �����, ���� ������ ���� P�� ����� ũ�� ������� �����.
���� ��� ���ڸ� ������ �ʾҴٸ�, �ٽ� 2�� �ܰ�� ����.
*/