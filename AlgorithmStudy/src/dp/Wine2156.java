package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Wine2156 {
	public static int a[];
	public static int d[];
	public static int n;	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		d = new int[n];
		a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(br.readLine()); 
		}
		
		//dp table init
		if (n<=3) {
			if (n==0) {
				System.out.println(0);
			}
			else if (n==1) {
				System.out.println(a[0]);
			}
			else if (n==2) {
				System.out.println(a[0]+a[1]);
			}
			else if(n==3){
				System.out.println(Math.max(a[1] + a[2], Math.max(a[0]+a[2], a[0]+a[1])));
			}
		}
		else System.out.println(dp());
		br.close();
	}
	public static int dp(){
		for (int i = 0; i < 3; i++) {
			if (i==0) {
				d[i] = a[i];
			}
			else if (i==1) {
				d[i] = a[i]+a[i - 1];
			}
			else if(i==2){
				d[i] = Math.max(a[i] + a[i - 1], Math.max(a[i] + a[i - 2], a[i-1]+a[i-2]));
			}
		}
		for (int i = 3; i < d.length; i++) {
			d[i] = Math.max(d[i - 2] + a[i], Math.max(d[i - 3] + a[i] + a[i - 1], d[i-1]));
		}
		int max = 0;
		for (int i = 0; i < d.length; i++) {
			if (max<=d[i]) max = d[i];
		}
		return max;
	}
}
/*
2156��

if (d[i-1]-d[i-2]==a[i-1]) {d[i] = Math.max(d[i-2] + a[i], d[i-1]);} //����, �� ���� ���
			else {d[i] = Math.max(d[i-1]+a[i],d[i-2]+a[i]);}
10
�ð� ����	�޸� ����	����	����	���� ���	���� ����
2 ��	128 MB	19605	6946	5022	34.317%
����
ȿ�ִ� ������ �ý�ȸ�� ����. �� ���� ������, ���̺� ���� �پ��� �����ְ� ����ִ� ������ ���� �Ϸķ� ���� �־���. ȿ�ִ� ������ �ý��� �Ϸ��� �ϴµ�, ���⿡�� ������ ���� �� ���� ��Ģ�� �ִ�.

������ ���� �����ϸ� �� �ܿ� ����ִ� �����ִ� ��� ���ž� �ϰ�, ���� �Ŀ��� ���� ��ġ�� �ٽ� ���ƾ� �Ѵ�.
�������� ���� �ִ� 3���� ��� ���� ���� ����.
ȿ�ִ� �� �� �ִ� ��� ���� ���� �����ָ� ������ ���ؼ� � ������ ���� �����ؾ� ���� ����ϰ� �ִ�. 1���� n������ ��ȣ�� �پ� �ִ� n���� ������ ���� ������� ���̺� ���� ���� �ְ�, �� ������ �ܿ� ����ִ� �������� ���� �־����� ��, ȿ�ָ� ���� ���� ���� ���� �����ָ� ���� �� �ֵ��� �ϴ� ���α׷��� �ۼ��Ͻÿ�. 

���� ��� 6���� ������ ���� �ְ�, ������ �ܿ� ������� 6, 10, 13, 9, 8, 1 ��ŭ�� �����ְ� ��� ���� ��, ù ��°, �� ��°, �� ��°, �ټ� ��° ������ ���� �����ϸ� �� ������ ���� 33���� �ִ�� ���� �� �ִ�.

�Է�
ù° �ٿ� ������ ���� ���� n�� �־�����. (1��n��10,000) ��° �ٺ��� n+1��° �ٱ��� ������ �ܿ� ����ִ� �������� ���� ������� �־�����. �������� ���� 1,000 ������ ���� �ƴ� �����̴�.

���
ù° �ٿ� �ִ�� ���� �� �ִ� �������� ���� ����Ѵ�.

���� �Է� 
6
6
10
13
9
8
1
���� ��� 
33
*/

