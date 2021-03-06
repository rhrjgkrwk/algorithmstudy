package etc;
import java.util.Scanner;

/*문제
평소 반상회에 참석하는 것을 좋아하는 주희는 이번 기회에 부녀회장이 되고 싶어 각 층의 사람들을 불러 모아 반상회를 주최하려고 한다.

이 아파트에 거주를 하려면 조건이 있는데, “a 층의 b 호에 살려면 자신의 아래(a-1)층에 1호부터 b 호까지 사람들의 수의 합만큼 사람들을 데려와 살아야한다” 는 계약 조항을 꼭 지키고 들어와야 한다.

아파트에 비어있는 집은 없고 모든 거주민들이 이 계약 조건을 지키고 왔다고 가정 했을 때, 주어지는 양의 정수 k와 n에 대해 k층에 n호에는 몇 명이 살고 있나를 출력하라. 단, 아파트에는 0층부터 있고 각층에는 1호부터 있으며, 0층에 i호에는 i명이 산다.

입력
첫 번째 줄에 Test case의 수 T가 주어진다. 그리고 각각의 케이스마다 입력으로 첫 번째 줄에 정수 k, 두 번째 줄에 정수 n이 주어진다. (1 <= k <= 14, 1 <= n <= 14)

출력
각각의 Test case에 대해서 해당 집에 거주민 수를 출력하라.*/

/*예제입력
2
1
3
2
3

예제 출력 
6
10
*/



//N(k) = N-1(k) N(k-1)

public class AlgoBunyeo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		int K;
		int N;
		int resultTable[][] = new int[15][15];
		int lastK=1;
		for (int i = 1; i <= 14; i++) {
			resultTable[0][i] = i;
			resultTable[i][0] = 0;			
		}
		for (int t = 0; t < T; t++) {//test case
			K=sc.nextInt();
			N=sc.nextInt();
			if (resultTable[N][K]==0) { // 찾으려는 값이 테이블에 등록이 되어있지 않다면.
				for (int i = 1; i <= K; i++) {
					for (int j = 1; j <= N; j++) {
						resultTable[i][j] = resultTable[i-1][j] + resultTable[i][j-1];
					}
				}
				lastK = K; //지난 test에서 작성했던 인덱스.
			}
			System.out.println(resultTable[K][N]);
		}
		sc.close();	
	}
}
