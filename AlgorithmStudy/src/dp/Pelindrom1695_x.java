package dp;

import java.util.Scanner;

public class Pelindrom1695_x {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int []arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int count = arr.length-2;
		int temp = arr.length-1;
		for (int front = 0; front < arr.length-count; front++) {
			for (int rear = temp; rear > front ; rear--) {
				//System.out.println("arr["+front+"] = "+arr[front]+" arr["+rear+"] = "+arr[rear]);
				if (arr[front]==arr[rear]) {
					count--;
					System.out.println("일치! "+count);
					temp = rear -1;
				}
			}
		}
		System.out.println(arr.length%2==0 && count == arr.length/2?0:count);
		sc.close();
	}
}
/*
1695번
제출
맞은 사람
숏코딩
풀이
풀이 작성
풀이 요청
재채점/수정
채점 현황
내 소스
강의
질문 검색
팰린드롬 만들기
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	1577	604	438	39.495%
문제
앞에서 뒤로 보나, 뒤에서 앞으로 보나 같은 수열을 팰린드롬 이라고 한다. 예를 들어 {1}, {1, 2, 1}, {1, 2, 2, 1}과 같은 수열은 팰린드롬 이지만, {1, 2, 3}, {1, 2, 3, 2} 등은 팰린드롬이 아니다.

한 수열이 주어졌을 때, 이 수열에 최소 개수의 수를 끼워 넣어 팰린드롬을 만들려고 한다. 최소 몇 개의 수를 끼워 넣으면 되는지를 알아내는 프로그램을 작성하시오.

입력
첫째 줄에 수열의 길이 N(1≤N≤5,000)이 주어진다. 다음 줄에는 N개의 수열을 이루는 수들이 주어진다. 각 수들은 int 범위이다.

출력
첫째 줄에 끼워 넣을 수들의 최소 개수를 출력한다.

예제 입력 
5
1 2 3 4 2
예제 출력 
2
*/

