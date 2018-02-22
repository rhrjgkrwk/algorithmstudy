package dp;
import java.util.Scanner;

public class Fibonaci2747 {
	public static int[] d = new int[50]; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp(n);
		System.out.println(d[n]);
		//System.out.println(solve1(n));
		sc.close();
	}
	public static void dp(int n){
		d[0] = 0;
		d[1] = 1;
		for (int i = 2; i <= n; i++) {
			d[i] = d[i-1]+d[i-2];
		}
	}
	
	public static int solve1(int n){ //iter 
		int res=0;
		int n1=0;
		int n2=0;
		for (int i = 0; i <= n; i++) {
			if (i==0) {
				res = 0;
			}
			else if (i==1) {
				n1 = res;
				res = 1;
			}
			else{
				n2 = n1;
				n1 = res;
				res = n1+n2;
			}
		}
		return res;
	}
}


/*
�Է�
ù° �ٿ� n�� �־�����. n�� 45���� �۰ų� ���� �ڿ����̴�.

���
ù° �ٿ� n��° �Ǻ���ġ ���� ����Ѵ�.

���� �Է� 
10
���� ��� 
55*/