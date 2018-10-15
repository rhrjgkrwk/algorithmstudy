package dfsbfs;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Algo15658 {
	public static Scanner sc = new Scanner(System.in);
	public static int N;
	public static int[] operands;
	public static int[] operaters = new int[4]; // 0: +, 1: -, 2: *, 3: /
	public static final String operaterIndex = "+-*/";
	public static int[] resultArray = {Integer.MAX_VALUE, Integer.MIN_VALUE}; // 0 : min , 1 : max

	public static void main(String[] args) {
		N = sc.nextInt();
		operands = new int[N];
		for (int i = 0; i < N; i++) {
			operands[i] = sc.nextInt();
		}
		for (int i = 0; i < 4; i++) {
			operaters[i] = sc.nextInt();
		}
		
		dfs(new LinkedList<>());
		
		System.out.println(resultArray[1]);
		System.out.println(resultArray[0]);
	}
	public static void dfs(Deque<Character> selectedOperaters) {
		if (selectedOperaters.size() == N-1) {
			int result = operands[0];
			Iterator<Character> li = selectedOperaters.iterator();
			for (int i = 1; i < operands.length; i++) {
				char op = li.next();
				if (op == '+') {
					result += operands[i];
				} else if (op == '-') {
					result -= operands[i];
				} else if (op == '*') {
					result *= operands[i];
				} else {
					result /= operands[i];
				}
			}
			
			if (resultArray[0] > result) {
				resultArray[0] = result;
			} 
			if (resultArray[1] < result) {
				resultArray[1] = result;
			}
			
			return ;
		}
		
		for (int i = 0; i < 4; i++) {
			if (operaters[i] > 0) {
				operaters[i]--;
				selectedOperaters.addLast(operaterIndex.charAt(i));
				dfs(selectedOperaters);
				selectedOperaters.removeLast();
				operaters[i]++;
			}
		}
	}
}
