package bruteforce;
import java.util.Arrays;
import java.util.Scanner;

public class Sugorgi {
	static int []sub;
	static int []A;
	static int N ;
	static int M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		A = new int[N];
		sub = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		Arrays.sort(A);
		int min = 2000000000;
		boolean flag = true;
		for (int i = 0; i < A.length-1 && flag; i++) {
			for (int j = i+1; j < A.length && flag; j++) {
				int tmp = A[j]-A[i];
				if (tmp == M) {
					min = tmp;
					flag = false;
				}
				else if (tmp>=min) {
					break;
				}
				else if(tmp < min && tmp > M){
					min = tmp;
				}
			}
		}
		System.out.println(min);
		sc.close();
	}
}
//public static int solve1(int N, int M, int[] A){
//int min = 1000000001;
//boolean flag = true;
//for (int i = 0; i < A.length-1 && flag == true; i++) {
//	for (int j = i+1; j < A.length && flag == true; j++) {
//		if (M==min) {
//			flag = false;
//		}
//		if ((M <= Math.abs(A[i] - A[j]))&& (min >= Math.abs(A[i] - A[j]))) {
//			min = Math.abs(A[i] - A[j]);
//		}
//	}
//}
//return min;
//}



/*
����
N(1��N��100,000)���� ���� �̷���� ���� A[1], A[2], ��, A[N]�� �ִ�. 
�� �������� �� ���� ����� ��(���� ���� ���� �ִ�), 
�� ���̰� M �̻��̸鼭 ���� ���� ��츦 ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

���� ��� ������ {1, 2, 3, 4, 5}��� ����. ���� M=3�� ���,
 1 4, 1 5, 2 5�� ����� �� �� ���̰� M �̻��� �ȴ�.
  �� �߿��� ���̰� ���� ���� ���� 1 4�� 2 5�� ����� ���� 3�� �ȴ�.

�Է�
ù° �ٿ� �� ���� N, M(0��M��2,000,000,000)�� �־�����. 
���� N���� �ٿ��� ���ʷ� A[1], A[2], ��, A[N]�� �־�����. 
������ A[i]�� 0 �� |A[i]| �� 1,000,000,000�� �����Ѵ�.

���
ù° �ٿ� M �̻��̸鼭 ���� ���� ���̸� ����Ѵ�. �׻� ���̰� M�̻��� �� ���� �� �� �ִ�.

���� �Է� 
3 3
1
5
3


6 7
1
5
3
11
10
9

10 48
12
11
1
5
15
50
20
8
7
2




���� ��� 
4


Math.abs������ �ð��ʰ�???
*/