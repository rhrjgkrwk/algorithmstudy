package bruteforce;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

class Node1991 {
	String left;
	String right;
	boolean visit;
	public Node1991(String left, String right) {
		this.left = left;
		this.right = right;
	}
}
public class Algo1991 {
	public static HashMap<String, Node1991> map = new HashMap<>();
	public static void main(String[] args) {
		InputStream s = System.in;
		Scanner sc = new Scanner(s);
		int N = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
			while (st.hasMoreTokens()) {
				String center = st.nextToken();
				map.put(center, new Node1991(st.nextToken(), st.nextToken()));
			}
		}
		//1 : 전 / 2 : 중 / 3 : 후 
		dfs(1, "A"); 
		System.out.println();
		dfs(2, "A");
		System.out.println();
		dfs(3, "A");
		
	}
	public static void dfs(int method, String now) {
		switch (method) {
		case 1:
			System.out.print(now);
			if (!map.get(now).left.equals(".")) dfs(method, map.get(now).left);
			if (!map.get(now).right.equals(".")) dfs(method, map.get(now).right);
			break;
		case 2:
			if (!map.get(now).left.equals(".")) dfs(method, map.get(now).left);
			System.out.print(now);
			if (!map.get(now).right.equals(".")) dfs(method, map.get(now).right);
			break;
		case 3:
			if (!map.get(now).left.equals(".")) dfs(method, map.get(now).left);
			if (!map.get(now).right.equals(".")) dfs(method, map.get(now).right);
			System.out.print(now);
			break;
		}
	}
}
/*
1991번
트리 순회
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	7256	4241	3306	61.120%
문제
이진 트리를 입력받아 전위 순회(preorder traversal), 중위 순회(inorder traversal), 후위 순회(postorder traversal)한 결과를 출력하는 프로그램을 작성하시오.



예를 들어 위와 같은 이진 트리가 입력되면,

전위 순회한 결과 : ABDCEFG // (루트) (왼쪽 자식) (오른쪽 자식)
중위 순회한 결과 : DBAECFG // (왼쪽 자식) (루트) (오른쪽 자식)
후위 순회한 결과 : DBEGFCA // (왼쪽 자식) (오른쪽 자식) (루트)
가 된다.

입력
첫째 줄에는 이진 트리의 노드의 개수 N(1≤N≤26)이 주어진다. 둘째 줄부터 N개의 줄에 걸쳐 각 노드와 그의 왼쪽 자식 노드, 오른쪽 자식 노드가 주어진다. 노드의 이름은 A부터 차례대로 영문자 대문자로 매겨지며, 항상 A가 루트 노드가 된다. 자식 노드가 없는 경우에는 .으로 표현된다.

출력
첫째 줄에 전위 순회, 둘째 줄에 중위 순회, 셋째 줄에 후위 순회한 결과를 출력한다. 각 줄에 N개의 알파벳을 공백 없이 출력하면 된다.

예제 입력 1 
7
A B C
B D .
C E F
E . .
F . G
D . .
G . .
예제 출력 1 
ABDCEFG
DBAECFG
DBEGFCA
*/