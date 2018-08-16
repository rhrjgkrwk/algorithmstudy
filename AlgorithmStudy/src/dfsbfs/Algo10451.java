package dfsbfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node10451 {
	int now;
	int next;
	boolean visit;
	public Node10451() {
		// TODO Auto-generated constructor stub
	}
	public Node10451(int now, int next, boolean visit) {
		super();
		this.now = now;
		this.next = next;
		this.visit = visit;
	}
}
public class Algo10451 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int tc = 0; tc < testCase; tc++) {
			ArrayList<Node10451> arr = new ArrayList<>();
			int N = sc.nextInt();
			int res = 0;
			for (int start = 1; start <= N; start++) {
				int end = sc.nextInt();
				arr.add(new Node10451(start, end, false));
			}
			
			for (Node10451 start : arr) {
				if (!start.visit) {
					Queue<Node10451> q = new LinkedList<>();
					q.add(start);
					while (!q.isEmpty()) {
						Node10451 now = q.poll();
						now.visit = true;
						if (now.next == start.now) {
							res++;
							break;
						}
						q.add(arr.get(now.next-1));
					}
				}
			}
			System.out.println(res);
		}
		sc.close();
	}
}
/*
질문 검색
순열 사이클
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	256 MB	5179	3272	2399	63.332%
문제


1부터 N까지 정수 N개로 이루어진 순열을 나타내는 방법은 여러가지가 있다. 
예를 들어, 8개의 수로 이루어진 순열 (3, 2, 7, 8, 1, 4, 5, 6)을 배열을 이용해 표현하면  
와 같다. 또는, Figure 1과 같이 방향 그래프로 나타낼 수도 있다.

순열을 배열을 이용해  로 나타냈다면, i에서 πi로 간선을 이어 그래프로 만들 수 있다.

Figure 1에 나와있는 것 처럼, 순열 그래프 (3, 2, 7, 8, 1, 4, 5, 6) 에는 총 3개의 사이클이 있다. 
이러한 사이클을 "순열 사이클" 이라고 한다.

N개의 정수로 이루어진 순열이 주어졌을 때, 순열 사이클의 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스의 첫째 줄에는 순열의 크기 N (2 ≤ N ≤ 1,000)이 주어진다. 둘째 줄에는 순열이 주어지며, 각 정수는 공백으로 구분되어 있다.

출력
각 테스트 케이스마다, 입력으로 주어진 순열에 존재하는 순열 사이클의 개수를 출력한다.

예제 입력 1 
2
8
3 2 7 8 1 4 5 6
10
2 1 3 4 5 6 7 9 10 8
예제 출력 1 
3
7
*/