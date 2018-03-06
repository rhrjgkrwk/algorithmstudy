package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Wine2156 {
	public static int a[];
	public static int d[];
	public static int n;	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		d = new int[n];
		a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(br.readLine()); 
		}
		
		//dp table init
		if (n<=3) {
			if (n==0) {
				System.out.println(0);
			}
			else if (n==1) {
				System.out.println(a[0]);
			}
			else if (n==2) {
				System.out.println(a[0]+a[1]);
			}
			else if(n==3){
				System.out.println(Math.max(a[1] + a[2], Math.max(a[0]+a[2], a[0]+a[1])));
			}
		}
		else System.out.println(dp());
		br.close();
	}
	public static int dp(){
		for (int i = 0; i < 3; i++) {
			if (i==0) {
				d[i] = a[i];
			}
			else if (i==1) {
				d[i] = a[i]+a[i - 1];
			}
			else if(i==2){
				d[i] = Math.max(a[i] + a[i - 1], Math.max(a[i] + a[i - 2], a[i-1]+a[i-2]));
			}
		}
		for (int i = 3; i < d.length; i++) {
			d[i] = Math.max(d[i - 2] + a[i], Math.max(d[i - 3] + a[i] + a[i - 1], d[i-1]));
		}
		int max = 0;
		for (int i = 0; i < d.length; i++) {
			if (max<=d[i]) max = d[i];
		}
		return max;
	}
}
/*
2156번

if (d[i-1]-d[i-2]==a[i-1]) {d[i] = Math.max(d[i-2] + a[i], d[i-1]);} //전전, 전 먹은 경우
			else {d[i] = Math.max(d[i-1]+a[i],d[i-2]+a[i]);}
10
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	19605	6946	5022	34.317%
문제
효주는 포도주 시식회에 갔다. 그 곳에 갔더니, 테이블 위에 다양한 포도주가 들어있는 포도주 잔이 일렬로 놓여 있었다. 효주는 포도주 시식을 하려고 하는데, 여기에는 다음과 같은 두 가지 규칙이 있다.

포도주 잔을 선택하면 그 잔에 들어있는 포도주는 모두 마셔야 하고, 마신 후에는 원래 위치에 다시 놓아야 한다.
연속으로 놓여 있는 3잔을 모두 마실 수는 없다.
효주는 될 수 있는 대로 많은 양의 포도주를 맛보기 위해서 어떤 포도주 잔을 선택해야 할지 고민하고 있다. 1부터 n까지의 번호가 붙어 있는 n개의 포도주 잔이 순서대로 테이블 위에 놓여 있고, 각 포도주 잔에 들어있는 포도주의 양이 주어졌을 때, 효주를 도와 가장 많은 양의 포도주를 마실 수 있도록 하는 프로그램을 작성하시오. 

예를 들어 6개의 포도주 잔이 있고, 각각의 잔에 순서대로 6, 10, 13, 9, 8, 1 만큼의 포도주가 들어 있을 때, 첫 번째, 두 번째, 네 번째, 다섯 번째 포도주 잔을 선택하면 총 포도주 양이 33으로 최대로 마실 수 있다.

입력
첫째 줄에 포도주 잔의 개수 n이 주어진다. (1≤n≤10,000) 둘째 줄부터 n+1번째 줄까지 포도주 잔에 들어있는 포도주의 양이 순서대로 주어진다. 포도주의 양은 1,000 이하의 음이 아닌 정수이다.

출력
첫째 줄에 최대로 마실 수 있는 포도주의 양을 출력한다.

예제 입력 
6
6
10
13
9
8
1
예제 출력 
33
*/

