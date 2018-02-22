package etc;
import java.util.Scanner;

/*입력
T : 테스트케이스 수
N : 돌의 개수 (0번 제외)
a(n) : 돌의 좌표
K : 개구리 최대이동 거리


출력
각 TC마다 Case #T를 출력
개구리가 마지막 돌로 이동할 수 있는 최소점프횟수
불가능한 경우 -1


입력 예제
1
8
1 2 5 7 9 10 12 15
4
*/


public class AlgoFrog {
	static int Answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 입력
		int T = sc.nextInt();
		for (int test_case = 0; test_case < T; test_case++) {
			int N = sc.nextInt();
			int[] a = new int[N + 1];
			for (int j = 1; j < N + 1; j++) {
				a[j] = sc.nextInt();
			}
			int K = sc.nextInt();

			System.out.println("Case #"+(test_case+1));
			
			
			
			// 계산
			int pos = 0; // 현재 위치(실제 돌의 위치). not an index,
			Answer = 0; // 돌 밟은 횟수
			while (a[pos] < a[a.length - 1]) { 
				if (K<a[pos+1]-a[pos]) { //다음 돌다리가 넘 멀면 못가는 것. count = -1
					Answer = -1;
					break;
				}
				else {
					int temp = pos;
					for (int j = pos + 1; j < a.length; j++) { 
						// a[j(pos+1~a.length-1)]-a[pos] 중 K보다 같거나 작으면서 가장 큰값
						if (K>=a[j] - a[pos]) {
							temp = j;
						}
						else{
							break;
						}
					}
					pos = temp;
					Answer++;
				}
			}

			System.out.println(Answer);
		}
	}
}
