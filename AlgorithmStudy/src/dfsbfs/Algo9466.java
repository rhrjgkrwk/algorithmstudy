package dfsbfs;

import java.util.Scanner;

public class Algo9466 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int tc = 0; tc < testCase; tc++) {
			int n = sc.nextInt();
			int map[] = new int [n+1];
			int visit[] = new int [n+1];
			boolean team [] = new boolean[n+1];
			
			for (int i = 1; i <= n; i++) {
				map[i] = sc.nextInt();
			}
			
			for (int i = 1; i <= n; i++) {
				if (visit[i] == 0) {
					dfs(i, i, map, visit, team);
				}
			}
			
			int res = 0;
			for (int i = 1; i < team.length; i++) {
				if (!team[i]) {
					res++;
				}
			}
			System.out.println(res);
		}
		sc.close();
	}
	public static int dfs(int startNum, int now, int map[], int visit[], boolean team[]) {
		visit[now] = startNum;
		
		if (visit[map[now]] !=0 && visit[map[now]] != startNum) {
			return -1;
		}
		
		if (now == map[now]) {
			team[now] = true;
			return -1;
		}
		
		if (visit[now] == visit[map[now]]) {
			team[now] = true;
			return map[now];
		}
		
		int temp = dfs(startNum, map[now], map, visit, team);
		
		if (temp == now) {
			team[now] = true;
			return -1;
		}
		else if (temp > 0) {
			team[now] = true;
			return temp;
		}
		
		return -1;
	}
}
/*

9466번
텀 프로젝트
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
3 초	128 MB	9492	2351	1451	23.901%
문제
이번 가을학기에 '문제 해결' 강의를 신청한 학생들은 텀 프로젝트를 수행해야 한다. 
프로젝트 팀원 수에는 제한이 없다. 심지어 모든 학생들이 동일한 팀의 팀원인 경우와 같이 한 팀만 있을 수도 있다. 
프로젝트 팀을 구성하기 위해, 모든 학생들은 프로젝트를 함께하고 싶은 학생을 선택해야 한다. (단, 단 한명만 선택할 수 있다.) 
혼자 하고 싶어하는 학생은 자기 자신을 선택하는 것도 가능하다.

학생들이(s1, s2, ..., sr)이라 할 때, r=1이고 s1이 s1을 선택하는 경우나, 
s1이 s2를 선택하고, s2가 s3를 선택하고,..., sr-1이 sr을 선택하고, sr이 s1을 선택하는 경우에만 한 팀이 될 수 있다.

예를 들어, 한 반에 7명의 학생이 있다고 하자. 학생들을 1번부터 7번으로 표현할 때, 선택의 결과는 다음과 같다.

1	2	3	4	5	6	7
3	1	3	7	3	4	6
위의 결과를 통해 (3)과 (4, 7, 6)이 팀을 이룰 수 있다. 1, 2, 5는 어느 팀에도 속하지 않는다.

주어진 선택의 결과를 보고 어느 프로젝트 팀에도 속하지 않는 학생들의 수를 계산하는 프로그램을 작성하라.

입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다. 
각 테스트 케이스의 첫 줄에는 학생의 수가 정수 n (2 ≤ n ≤ 100,000)으로 주어진다. 
각 테스트 케이스의 둘째 줄에는 선택된 학생들의 번호가 주어진다. (모든 학생들은 1부터 n까지 번호가 부여된다.)

출력
각 테스트 케이스마다 한 줄에 출력하고, 각 줄에는 프로젝트 팀에 속하지 못한 학생들의 수를 나타내면 된다.

예제 입력 1 
2
7
3 1 3 7 3 4 6
8
1 2 3 4 5 6 7 8
예제 출력 1 
3
0
*/
//			
//			//팀 구성판별.
//			for (int start = 1; start <= n; start++) {
//				if (isBelonged[start]) { //이미 속한 팀이 있으면 pass.
//					continue;
//				}
//				
//				//q에 현재 학생간 연결 상태를 ㅔush 하고 peek과 현재 학생과 같으면 cycle이 형성되므로 한 팀이다. 
//				ArrayList<Integer> q = new ArrayList<>();
//				q.add(start);
//				int next = pick[start];
//				int count = 1;
//				
//				while (count < n) {
//					if (q.contains(next)) {
//						for (int i = q.indexOf(next); i < q.size(); i++) {
//							isBelonged[q.get(i)] = true;
//						}
//						break;
//					}
//					
//					if (isBelonged[next]) {
//						break;
//					}
//					
//					
//					q.add(next);
//					
//					next = pick[next];
//					count++;
//				}
//				
//			}
//			//결과 출력
//			int result = 0;
//			for (int i = 1; i < isBelonged.length; i++) {
//				if (!isBelonged[i]) {
//					result++;
//				}
//			}
//			System.out.println(result);