package etc;

import java.util.Scanner;

public class Algo10820 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			int res[] = new int[4]; //순서대로 소 대 숫자 공백이다.
			String s = sc.nextLine();
			for (int i = 0; i < s.length(); i++) {
				char now = s.charAt(i);
				if (now - 'a' >= 0) res[0]++;
				else if (now - 'A' >= 0) res[1]++;
				else if (now - '0' >= 0) res[2]++;
				else res[3]++;
			}
			for (int i : res) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
		sc.close();
	}
}

/*
10820번
문자열 분석
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	256 MB	5876	2435	2047	44.221%
문제
문자열 N개가 주어진다. 이 때, 문자열에 포함되어 있는 소문자, 대문자, 숫자, 공백의 개수를 구하는 프로그램을 작성하시오.

각 문자열은 알파벳 소문자, 대문자, 숫자, 공백으로만 이루어져 있다.

입력
첫째 줄부터 N번째 줄까지 문자열이 주어진다. (1 ≤ N ≤ 100) 문자열의 길이는 100을 넘지 않는다.

출력
첫째 줄부터 N번째 줄까지 각각의 문자열에 대해서 소문자, 대문자, 숫자, 공백의 개수를 공백으로 구분해 출력한다.

예제 입력 1 
This is String
SPACE    1    SPACE
 S a M p L e I n P u T     
0L1A2S3T4L5I6N7E8
예제 출력 1 
10 2 0 2
0 10 1 8
5 6 0 16
0 8 9 0
*/