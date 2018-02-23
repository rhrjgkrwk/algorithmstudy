package dp;

import java.util.Scanner;

public class GoingDown2096 {
	public static int direction[] = { -1, 0, 1 };
	public static int a[][];
	public static int dmin[][];
	public static int dmax[][];
	public static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		a = new int[N][3];
		dmin = new int[N][3];	
		dmax = new int[N][3];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				a[i][j] = sc.nextInt();
			}
		}
	}
	public static void dp(){
		dmax[0][1] = Math.max(Math.max(a[0][0], a[0][1]), a[0][2]);
		dmin[0][1] = Math.min(Math.min(a[0][0], a[0][1]), a[0][2]);
		int lastMaxIndex=1;
		int lastMinIndex=1;
		for (int i = 0; i < N; i++) {
			if (lastMaxIndex==1) {
				dmax[i+1][getMaxIndex(a[i+1])] += a[i+1][getMaxIndex(a[i+1])];
				lastMaxIndex = getMaxIndex(a[i+1]);
			}
			else {// lastIndex�� 0,2�� ���.
				if (dmax[i][0]>dmax[i][2]) {
					//
				}
			}
			if (lastMinIndex==1) {
				dmax[i+1][getMinIndex(a[i+1])] += a[i+1][getMinIndex(a[i+1])];
				lastMinIndex = getMinIndex(a[i+1]);
			}
			else {
				
			}
		}
	}
	public static int getMaxIndex(int arr[]){
		int max = 0;
		int maxIndex = 0;
		for (int i = 0; i < 3; i++) {
			if (arr[i]>max) {
				max = arr[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}
	public static int getMinIndex(int arr[]){
		int min = 0;
		int minIndex = 100;
		for (int i = 0; i < 3; i++) {
			if (arr[i]<=min) {
				min = arr[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
}

/*
 * �������� Ǯ�� �ð� ���� �޸� ���� ���� ���� ���� ��� ���� ���� 1 �� 4 MB 6535 2320 1812 34.846% ���� N�ٿ�
 * 0 �̻� 9 ������ ���ڰ� �� ���� ���� �ִ�. �������� ������ �ϰ� �ִµ�, �� ������ ù �ٿ��� �����ؼ� ������ �ٿ��� ������ �Ǵ�
 * �����̴�.
 * 
 * ���� ó���� ���� �ִ� �� ���� ���� �߿��� �ϳ��� ��� �����ϰ� �ȴ�. �׸��� ���� �ٷ� �������µ�, ���� �ٷ� ������ ������ ������
 * ���� ���� ������ �ִ�. �ٷ� �Ʒ��� ���� �Ѿ�ų�, �ƴϸ� �ٷ� �Ʒ��� ���� �پ� �ִ� ���θ� �̵��� �� �ִٴ� ���̴�. �� ����
 * ������ �׸����� ��Ÿ���� ���� ������ ����.
 * 
 * 
 * 
 * ��ǥ�� ���� ��ġ�̰�, �� �Ʒ� ���� �Ķ� ���׶�̴� �����̰� ���� �ٷ� ������ �� �ִ� ��ġ�̸�, ���� ����ǥ�� �����̰� ������ �� ����
 * ��ġ�� �ȴ�. ����ǥ�� �־��� ���� ��, ���� �� �ִ� �ִ� ����, �ּ� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�. ������ �����̰� ��ġ�� ����
 * ���� ���̴�.
 * 
 * �Է� ù° �ٿ� N(1 �� N �� 100,000)�� �־�����. ���� N���� �ٿ��� ���ڰ� �� ���� �־�����. ���ڴ� 0, 1, 2, 3,
 * 4, 5, 6, 7, 8, 9 ���� �ϳ��� �ȴ�.
 * 
 * ��� ù° �ٿ� ���� �� �ִ� �ִ� ������ �ּ� ������ �� ����Ѵ�.
 * 
 * ���� �Է� 3 1 2 3 4 5 6 4 9 0 ���� ��� 18 6
 */