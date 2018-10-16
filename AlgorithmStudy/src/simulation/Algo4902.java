package simulation;

public class Algo4902 {
	//규칙.
	//
	public static int N;
	
	public static void main(String[] args) {
		
	}
}
/*

4902번
삼각형의 값
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	55	6	5	17.241%
문제
오른쪽 삼각형은 9개의 단위 삼각형이 총 3줄(N=3)로 이루어져 있다. 단위 삼각형은 N=1인 삼각형이다.

이때, 그림에서 서로 다른 부분 삼각형은 총 13개가 있다. (N=2인 삼각형이 2개, N=3인 삼각형이 1개)

N = 1인 경우 부분 삼각형은 1개, 2인 경우에는 5개, 3인 경우는 13개, 4인 경우는 27개가 있다.

이때, 단위 삼각형의 값을 삼각형 내부에 쓰여 있는 숫자의 값이라고 하자. 삼각형의 값은 삼각형 안에 있는 단위 삼각형의 값의 합이다.

오른쪽 그림은 가장 큰 값을 갖는 부분 삼각형이다.

삼각형이 주어졌을 때, 가장 큰 값을 갖는 부분 삼각형을 구하는 프로그램을 작성하시오.

입력
입력은 여러 개의 테스트 케이스로 이루어져 있고, 각 테스트 케이스는 한 줄로 이루어져 있다. 첫 번째 숫자는 줄의 수를 나타내고, 다음 숫자는 단위 삼각형에 적혀있는 값이 위에서 아래, 왼쪽에서 오른쪽 순서대로 주어진다. 마지막 줄에는 0이 주어진다.

줄의 개수는 400을 넘지 않으며, 단위 삼각형에 적혀있는 값의 절대값은 1000을 넘지 않는다.

출력
각 테스트 케이스에 대해서, 테스트 케이스의 번호와 가장 큰 부분 삼각형의 값을 출력한다.

예제 입력 1 
3 6 -24 0 12 -10 12 40 -4 6
4 1 1 -1 1 1 -1 1 -1 1 1 -1 1 -1 1 -1 1
0
예제 출력 1 
1. 54
2. 4
*/