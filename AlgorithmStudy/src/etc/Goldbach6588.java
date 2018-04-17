package etc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Goldbach6588 {
	public static boolean chk[] = new boolean[1000001];
	public static int n = -1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = 0;
		
		int max = -1;
		
		while (k < 100) {
			n = sc.nextInt();
			if (max > n) {
				// 기존에 입력되어있는 값을 가져오자.
			}
			
			for (int i = 2; i <= n; i++) {
				for (int j = 2; i * j <= n; j++) {
					if (chk[i * j] == false) chk[i * j] = true; //T : 지운 수
					else continue;
				}
			}
			
			int left = 3;
			int right = n-1;
			boolean flag = false;
			
			while (left<=right) {
				left = nextPrime(left, 1);
				right = nextPrime(right, -1);
				//여기서 비교
				if (left + right == n) {
					System.out.println(n + " = " + left + " + " + right);
					flag = true; //만들 수 있따.
					break;
				} else if (left + right > n) {
					right -= 2;
				} else if (left + right < n) {
					left += 2;
				}
			} 
			
			k++;
			if(!flag) System.out.println("Goldbach's conjecture is wrong.");
		}
		sc.close();
	}
	public static int nextPrime(int now, int dir){
		if (dir==-1) {
			for (int i = now; i >= 2; i-=2) {
				if (!chk[i]) {
					return i;
				}
			}
		}
		else if (dir==1) {
			for (int i = now; i <= n; i+=2) {
				if (!chk[i]) {
					return i;
				}
			}
		}
		return -1;
	}
}

/*
 * sieve = list(range(n)) sieve[1] = 0 for p in range(2, int(n**0.5)+1): if
 * sieve[p] != 0: for q in range(2*p, n, p): sieve[q] = 0
 */
