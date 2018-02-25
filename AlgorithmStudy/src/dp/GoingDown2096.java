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
				if (i==0) {
					dmax[i][j] = a[i][j];
					dmin[i][j] = a[i][j];
				}
			}
		}
		dp();
	}
	public static void dp(){
		for (int i = 0; i < N-1; i++) {
			for (int j = 0; j < 3; j++) { //가운데일때랑 양 옆일때를 나누어서 생각해보자..
				if (j == 1) {
					dmax[i+1][j] = Math.max(dmax[i][0]+a[i+1][j], Math.max(dmax[i][1]+a[i+1][j], dmax[i][2]+a[i+1][j]));
					dmin[i+1][j] = Math.min(dmin[i][0]+a[i+1][j], Math.min(dmin[i][1]+a[i+1][j], dmin[i][2]+a[i+1][j]));
				}
				else if(j == 0) { 
					dmax[i+1][j] = Math.max(dmax[i][0]+a[i+1][j], dmax[i][1]+a[i+1][j]);
					dmin[i+1][j] = Math.min(dmin[i][0]+a[i+1][j], dmin[i][1]+a[i+1][j]);
				}
				else {
					dmax[i+1][j] = Math.max(dmax[i][1]+a[i+1][j], dmax[i][2]+a[i+1][j]);
					dmin[i+1][j] = Math.min(dmin[i][1]+a[i+1][j], dmin[i][2]+a[i+1][j]);
				}
			}
		}
		System.out.println(getMaxInLine(dmax[N-1]));
		System.out.println(getMinInLine(dmin[N-1]));
	}
	public static int getMaxInLine(int arr[]) {
		return Math.max(arr[0], Math.max(arr[1], arr[2]));
	}
	public static int getMinInLine(int arr[]) {
		return Math.min(arr[0], Math.min(arr[1], arr[2]));
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
 * ���� �Է�  ���� ��� 18 6
 */

/*
3 
1 2 3 
4 5 6 
4 9 0

3



*/


/*




if (lastMaxIndex==1) {
	dmax[i+1][getMaxIndex(a[i+1])] += a[i+1][getMaxIndex(a[i+1])];
	lastMaxIndex = getMaxIndex(a[i+1]);
}
else {// lastIndex가 0,2 인 경우.
	if (lastMaxIndex==0) {
		
	}
		Math.max(a[i+1][lastMaxIndex+d], a[i+1][])
	
}

if (lastMinIndex==1) {
	dmax[i + 1][getMinIndex(a[i + 1])] += a[i + 1][getMinIndex(a[i + 1])];
	lastMinIndex = getMinIndex(a[i + 1]);
} else {
	if (dmin[i][0] < dmax[i][2]) {// 두번째로 작 값이 0인 경우

	} else {// 두번째로 작은 값이 2인 경우

	}
}*/

