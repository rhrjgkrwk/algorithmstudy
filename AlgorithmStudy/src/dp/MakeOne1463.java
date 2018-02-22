package dp;
import java.util.Scanner;

public class MakeOne1463 {
	public static int []d;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		d = new int[n+1];
		for (int i = 0; i < n+1; i++) {
			d[i] = 999999;
		}
		System.out.println(dp(2,n));
		sc.close();
	}
	public static int dp(int now, int n){
		d[0] = 0;
		d[1] = 0;
		while(now!=n+1){
			//d[now] = Math.min(d[now*3],Math.min(d[now*2],d[now+1]))+1;
			if (now%3==0) {
				int minIndex = getMinIndex(now/3, now-1);
				d[now] = d[minIndex]+1;
			}
			else if (now%2==0) {
				int minIndex = getMinIndex(now/2, now-1);
				d[now] = d[minIndex]+1;
			}
			else if (now%2==0 && now%3==0) {
				int minIndex = getMinIndex(now/3,getMinIndex(now/2, now-1));
				d[now] = d[minIndex]+1;
			}
			else {
				d[now] = d[now-1]+1;
			}
			now++;
		}
		return d[n];
	}
	public static int getMinIndex(int a, int b){
		return d[a]>d[b]?b:a;
	}
}

/*
1�� ����� Ǯ��
�ð� ����	�޸� ����	����	����	���� ���	���� ����
2 ��	128 MB	36407	11731	7819	32.825%
����
���� X�� ����� �� �ִ� ������ ������ ���� �� ���� �̴�.

X�� 3���� ������ ��������, 3���� ������.
X�� 2�� ������ ��������, 2�� ������.
1�� ����.
���� N�� �־����� ��, ���� ���� ���� �� ���� ������ ����ؼ� 1�� ������� �Ѵ�. 
������ ����ϴ� Ƚ���� �ּҰ��� ����Ͻÿ�.

�Է�
ù° �ٿ� 1���� ũ�ų� ����, 106���� �۰ų� ���� �ڿ��� N�� �־�����.

���
ù° �ٿ� ������ �ϴ� Ƚ���� �ּҰ��� ����Ѵ�.

���� �Է� 
2
���� ��� 
1
���� �Է� 2 
10
���� ��� 2 
3
*/