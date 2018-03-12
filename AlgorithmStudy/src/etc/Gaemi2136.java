package etc;

import java.util.Scanner;

public class Gaemi2136 {
	public static int N; //개미 마릿수
	public static int L; //막대기 길이
	public static int []arr;
	public static boolean []dp;
	public static boolean boohoChk(int a, int b){ //다르면 false
		if (a>0) {
			if (b<0) return false;
			else return true;
		}
		else {
			if (b<0) return true;
			else return false;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		arr = new int[N+1];
		for (int i = 1; i <= N; i++) { //개미명단을 받는다.
			arr[i] = sc.nextInt();
		}
		int max = 0; 
		int maxIdx = 0;
		for (int i = 1; i <= N; i++) {
			if (arr[i]>=0){//오른쪽으로 가는 개미친구들
				maxIdx = max<L-arr[i]?i:0;
				max = L-arr[i];
			}
			else {//왼쪽으로 가는 개미친구들
				maxIdx = max<0-arr[i]?i:0;
				max = 0-arr[i];
			}
		}
		System.out.println(maxIdx+" "+max);
	}
}

/*
2136번

개미
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	400	117	98	33.108%
문제
길이가 L(1≤L≤1,000,000,000)인 막대기 위에 N(1≤N≤100,000)마리의 개미들이 
서로 다른 위치에 살고 있다. 개미들은 크기가 매우 작기 때문에 이 문제에서는 
개미가 크기가 없는 점이라고 생각하자. 각각의 개미의 위치는 x좌표로 표시되며,
 좌표값은 0보다 크고 L보다 작은 값으로 표현된다.

각각의 개미는 왼쪽, 혹은 오른쪽으로 움직이고 있다. 모든 개미들은 똑같은 속도로, 
1초에 한 칸씩 움직인다. 개미들이 움직이는 도중에 서로 부딪히는 경우가 생길 수도 있다. 
두 마리의 개미가 서로 부딪혔을 때, 두 마리의 개미는 모두 즉시 방향을 바꾸어 다시 움직이게 된다.

개미들이 이동하다가 0인 위치나 L인 위치에 도달하게 되면, 그 개미는 막대기 아래로 떨어지게 된다.
 개미들의 초기상태가 주어졌을 때, 가장 마지막에 떨어지는 개미와 그
  개미가 떨어지는 시각을 알아내는 프로그램을 작성하시오.

입력
첫째 줄에 두 정수 N, L이 주어진다. 다음 N개의 줄에는 각 개미의 초기 위치가 주어진다.
 초기 위치가 양수로 주어지는 경우는 그 값이 그 개미의 위치가 되며, 그 개미는 오른쪽으로 움직이고 있다.
  초기 위치가 음수로 주어지는 경우에는 그 절대값이 그 개미의 위치가 되며, 
  그 개미는 왼쪽으로 움직이고 있다. 
  예를 들어 3이 주어지는 경우에는 3인 위치에서 오른쪽으로 움직이고 있고,
   -7인 경우에는 7인 위치에서 왼쪽으로 움직이고 있다.

출력
첫째 줄에 두 정수 i, t가 주어진다. i는 가장 마지막에 떨어지는 
개미의 번호이다. 개미의 번호는 입력에서 주어지는 순서대로 1, 2, …, N이
다. t는 가장 마지막에 떨어지는 개미가 바닥에 떨어지는 시간이다. 가장 마지
막에 떨어지는 개미가 여러 마리인 경우는 없다고 가정한다.

예제 입력 
2 5
4
-3
예제 출력 
2 3
*/


//아래와 같이 풀면 간단하지만 전체 개미 중 최대 시간만을 구할 수 있다.
		//어떤 개미가 가장 마지막에 떨어졋는지 알려면 탐색이 필요할 듯.
		/*int max = 0; 
		int maxIdx = 0;
		for (int i = 1; i <= N; i++) {
			if (arr[i]>=0){//오른쪽으로 가는 개미친구들
				maxIdx = max<L-arr[i]?i:0;
				max = L-arr[i];
			}
			else {//왼쪽으로 가는 개미친구들
				maxIdx = max<0-arr[i]?i:0;
				max = 0-arr[i];
			}
		}
		System.out.println(maxIdx+" "+max);*/




/*
 * boolean flag = true;
while(flag){ //다떨어질때까지.
	seconds++;
	for (int i = 1; i <= N; i++) { //이동
		if(arr[i]!=0 && arr[i]!=L) arr[i]++;
		else chk[i] = true;
	}
	for (int i = 1; i <=N; i++) {
		for (int j = 1; j <=N; j++) {
			if ((chk[i]==false && chk[j]==false) //둘다 떨어진 친구가 아니고
					&& (Math.abs(arr[i]) - Math.abs(arr[j]) ==-1 || Math.abs(arr[i]) - Math.abs(arr[j]) ==1 || Math.abs(arr[i]) - Math.abs(arr[j]) ==0) //절대값 차이가 1또는 0이고
					&& !boohoChk(arr[i],arr[j])) { //부호가 서로 다른 경우에 스왑
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
	}
	int c = 0;
	for (int i = 1; i <= N; i++) {
		if(chk[i]) c++;
		else last = i;
	}
	if(c==N) flag = false;
}
*/


