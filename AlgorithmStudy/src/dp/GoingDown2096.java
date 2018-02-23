package dp;

import java.util.Scanner;

public class GoingDown2096 {
	public static int direction[] = { -1, 0, 1 };
	public static int a[][];
	public static int dmin[][];
	public static int dmax[][];
	public static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		a = new int[N][3];
		dmin = new int[N][3];	
		dmax = new int[N][3];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				a[i][j] = sc.nextInt();
			}
		}
	}
	public static void dp(){
		dmax[0][1] = Math.max(Math.max(a[0][0], a[0][1]), a[0][2]);
		dmin[0][1] = Math.min(Math.min(a[0][0], a[0][1]), a[0][2]);
		int lastMaxIndex=1;
		int lastMinIndex=1;
		for (int i = 0; i < N; i++) {
			if (lastMaxIndex==1) {
				dmax[i+1][getMaxIndex(a[i+1])] += a[i+1][getMaxIndex(a[i+1])];
				lastMaxIndex = getMaxIndex(a[i+1]);
			}
			else {// lastIndex가 0,2인 경우.
				if (dmax[i][0]>dmax[i][2]) {
					//
				}
			}
			if (lastMinIndex==1) {
				dmax[i+1][getMinIndex(a[i+1])] += a[i+1][getMinIndex(a[i+1])];
				lastMinIndex = getMinIndex(a[i+1]);
			}
			else {
				
			}
		}
	}
	public static int getMaxIndex(int arr[]){
		int max = 0;
		int maxIndex = 0;
		for (int i = 0; i < 3; i++) {
			if (arr[i]>max) {
				max = arr[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}
	public static int getMinIndex(int arr[]){
		int min = 0;
		int minIndex = 100;
		for (int i = 0; i < 3; i++) {
			if (arr[i]<=min) {
				min = arr[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
}

/*
 * 내려가기 풀이 시간 제한 메모리 제한 제출 정답 맞은 사람 정답 비율 1 초 4 MB 6535 2320 1812 34.846% 문제 N줄에
 * 0 이상 9 이하의 숫자가 세 개씩 적혀 있다. 내려가기 게임을 하고 있는데, 이 게임은 첫 줄에서 시작해서 마지막 줄에서 끝나게 되는
 * 놀이이다.
 * 
 * 먼저 처음에 적혀 있는 세 개의 숫자 중에서 하나를 골라서 시작하게 된다. 그리고 다음 줄로 내려가는데, 다음 줄로 내려갈 때에는 다음과
 * 같은 제약 조건이 있다. 바로 아래의 수로 넘어가거나, 아니면 바로 아래의 수와 붙어 있는 수로만 이동할 수 있다는 것이다. 이 제약
 * 조건을 그림으로 나타내어 보면 다음과 같다.
 * 
 * 
 * 
 * 별표는 현재 위치이고, 그 아랫 줄의 파란 동그라미는 원룡이가 다음 줄로 내려갈 수 있는 위치이며, 빨간 가위표는 원룡이가 내려갈 수 없는
 * 위치가 된다. 숫자표가 주어져 있을 때, 얻을 수 있는 최대 점수, 최소 점수를 구하는 프로그램을 작성하시오. 점수는 원룡이가 위치한 곳의
 * 수의 합이다.
 * 
 * 입력 첫째 줄에 N(1 ≤ N ≤ 100,000)이 주어진다. 다음 N개의 줄에는 숫자가 세 개씩 주어진다. 숫자는 0, 1, 2, 3,
 * 4, 5, 6, 7, 8, 9 중의 하나가 된다.
 * 
 * 출력 첫째 줄에 얻을 수 있는 최대 점수와 최소 점수를 띄어서 출력한다.
 * 
 * 예제 입력 3 1 2 3 4 5 6 4 9 0 예제 출력 18 6
 */