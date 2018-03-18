package samsung;

import java.util.Scanner;

public class Samsung14888 {
	public static int[] operator = new int[4];
	public static int[] operand = new int[12];
	public static int N;
	public static int max = Integer.MIN_VALUE;
	public static int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			operand[i] = sc.nextInt();
		}
		for (int i = 0; i < 4; i++) { //0 덧셈, 1뺄셈, 2곱셈, 3나눗셈.
			operator[i] = sc.nextInt(); 
		}
		
		dfs(0,operand[0], operator.clone());
		
		System.out.println(max);
		System.out.println(min);
		
		sc.close();
	}

	public static void dfs(int cnt, int res, int arr[]) {
		if (cnt==N-1) {// 연산자를 다먹엇으면 계산 ..
			if (res<min) {
				min = res;
			} 
			if (res>max) {
				max = res;
			}
			return ;
		}
		for (int i = 0; i < 4; i++) { //operator
			if (arr[i]>0) { //연산자가 남아있는 것 중에..
				int tmp[] = arr.clone();
				tmp[i]--; //연산자를 먹는다.
				dfs(cnt+1, calculate(cnt, res, i), tmp);
			}
		}
		
	}
	public static int calculate(int cnt, int res, int op) { //cnt는 인덱스 계산 용ㅇ.
		int now = cnt+1; //계산해야할 피연산자 인덱스 
		if (op==0) { //더하기
			res+=operand[now];
		} else if (op==1) {//빼기 
			res-=operand[now];
		} else if (op==2) {//곱하기 
			res*=operand[now];
		} else if (op==3) {//나누기 
			if (res<0) {
				res = -(Math.abs(res)/operand[now]);
			}
			else
				res /= operand[now];
		}
		return res;
	}
}
