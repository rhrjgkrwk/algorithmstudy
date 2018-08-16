package greedy;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Greedy1541 {
	
	public static void main(String[] args) {
		//-를 만나면 다음 -가 나올때 까지 묶어준다.
		ArrayList<Integer> operand = new ArrayList<>();
		ArrayList<Character> operator = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		StringTokenizer st = new StringTokenizer(str, "+|-");
		while(st.hasMoreTokens()) {
			operand.add(Integer.parseInt(st.nextToken()));
		}
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i)=='+' || str.charAt(i)=='-') {
				operator.add(str.charAt(i));
			}
		}
		
	}
}
/*
잃어버린 괄호
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	2405	1243	1017	52.423%
문제
세준이는 양수와 +, -, 그리고 괄호를 가지고 길이가 최대 50인 식을 만들었다. 그리고 나서 세준이는 괄호를 모두 지웠다.

그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만드려고 한다.

괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.

입력
첫째 줄에 식이 주어진다. 
식은 ‘0’~‘9’, ‘+’, 그리고 ‘-’만으로 이루어져 있고, 
가장 처음과 마지막 문자는 숫자이다. 
그리고 연속해서 두 개 이상의 연산자가 나타나지 않고, 
5자리 이상 연속되는 숫자는 없다. 수는 0으로 시작할 수 있다.

출력
첫째 줄에 정답을 출력한다.

예제 입력 1 
55-50+40
예제 출력 1 
-35
출처
*/