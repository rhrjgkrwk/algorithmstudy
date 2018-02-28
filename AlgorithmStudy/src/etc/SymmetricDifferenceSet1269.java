package etc;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SymmetricDifferenceSet1269 {
	public static void main(String[] args) {
		Set<Integer> a = new HashSet<>();
		Set<Integer> b = new HashSet<>();
		Set<Integer> aub = new HashSet<>();
		Set<Integer> anb = new HashSet<>();
		Scanner sc = new Scanner(System.in);

		int sizeA = sc.nextInt();
		int sizeB = sc.nextInt();

		for (int i = 0; i < sizeA; i++) {
			a.add(sc.nextInt());
		}
		for (int i = 0; i < sizeB; i++) {
			b.add(sc.nextInt());
		}
		//합집합
		aub.addAll(a);
		aub.addAll(b);
		
		//교집합
		for (Integer i : a) {
			if (b.contains(i)) {
				anb.add(i);
			}
		}
		//aub-anb
		for (Integer i : anb) {
			if (aub.contains(i)) {
				aub.remove(i);
			}
		}
		System.out.println(aub.size());
	}
}

/*
1269번

대칭 차집합 풀이
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	1624	735	557	45.285%
문제
자연수를 원소로 갖는 공집합이 아닌 두 집합 A와 B가 있다. 이 때, 두 집합의 대칭 차집합의 원소의 개수를 출력하는 프로그램을 작성하시오. 두 집합 A와 B가 있을 때, (A-B)와 (B-A)의 합집합을 A와 B의 대칭 차집합이라고 한다.

예를 들어, A = { 1, 2, 4 } 이고, B = { 2, 3, 4, 5, 6 } 라고 할 때,  A-B = { 1 } 이고, B-A = { 3, 5, 6 } 이므로, 대칭 차집합의 원소의 개수는 1 + 3 = 4개이다.

입력
첫째 줄에 집합 A의 원소의 개수와 집합 B의 원소의 개수가 빈 칸을 사이에 두고 주어진다. 둘째 줄에는 집합 A의 모든 원소가, 셋째 줄에는 집합 B의 모든 원소가 빈 칸을 사이에 두고 각각 주어진다. 각 집합의 원소의 개수는 200,000을 넘지 않으며, 모든 원소의 값은 100,000,000을 넘지 않는다.

출력
첫째 줄에 대칭 차집합의 원소의 개수를 출력한다.

예제 입력 
3 5
1 2 4
2 3 4 5 6
예제 출력 
4
*/