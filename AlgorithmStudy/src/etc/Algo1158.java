package etc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Algo1158 {
	/*public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		boolean arr[] = new boolean[N+1];
		ArrayList<Integer> res = new ArrayList<>();
		int trueCount = 0;
		int i = M;
		
		while (trueCount != N) {
			arr[i] = true;
			trueCount++;
			res.add(i);
			int temp = 1;
			while (trueCount!=N) {
				if (!arr[i]) {
					i = (i+1)%N ==0 ? i+1 : (i+1)%N;
					temp++;
				}
				else i = (i+1)%N ==0 ? i+1 : (i+1)%N;
				
				if (temp==M && !arr[i]) {
					break;
				}
			}
		}
		System.out.print("<");
		for (int j = 0; j < res.size(); j++) {
			if (j < res.size()-1) {
				System.out.print(res.get(j)+", ");
			}
			else {
				System.out.print(res.get(j));
			}
		}
		System.out.print(">");
	}*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		LinkedList<Integer> list = new LinkedList<>();
		LinkedList<Integer> res = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}
		int pos = 0;
		while (!list.isEmpty()) {
			pos = (pos + M -1)%(list.size()); //다음 pos를 지정한다. 
			res.add(list.get(pos)); //제거될 다음 값을 ㄱes에 넣는다. 
			list.remove(pos);//제거한다.
		}
		
		
		System.out.print("<");
		while (!res.isEmpty()) {
			System.out.print(res.size()==1 ? res.poll() : res.poll() + ", " );
		}
		System.out.println(">");
		sc.close();
	}
}

/*
1158번
조세퍼스 문제
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	11190	5576	4312	51.921%
문제
조세퍼스 문제는 다음과 같다.

1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 M(≤ N)이 주어진다. 
이제 순서대로 M번째 사람을 제거한다. 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다. 
이 과정은 N명의 사람이 모두 제거될 때까지 계속된다. 원에서 사람들이 제거되는 순서를 (N, M)-조세퍼스 순열이라고 한다. 
예를 들어 (7, 3)-조세퍼스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.

N과 M이 주어지면 (N,M)-조세퍼스 순열을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N과 M이 빈 칸을 사이에 두고 순서대로 주어진다. (1 ≤ M ≤ N ≤ 5,000)

출력
예제와 같이 조세퍼스 순열을 출력한다.

예제 입력 1 
7 3
예제 출력 1 
<3, 6, 2, 7, 5, 1, 4>
출처
*/