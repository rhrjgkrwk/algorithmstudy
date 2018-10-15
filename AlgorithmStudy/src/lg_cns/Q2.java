package lg_cns;

import java.util.ArrayList;
import java.util.Collections;

public class Q2 {
	public int solution(int N, int[][] house) {
		int[][] map = new int[202][202];
		for (int i = 0; i < house.length; i++) {
			house[i][0] += 100;
			house[i][1] += 100;
		}
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				int temp = 0;
				for (int k = 0; k < house.length; k++) {
					temp += Math.pow((house[k][0] - i), 2) + Math.pow((house[k][1] - j), 2);
				}
				map[i][j] = temp;
			}
		}
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j] + " ");
			}System.out.println();
		}

		int count = 0;
		ArrayList<Integer> distList = new ArrayList<>();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				distList.add(map[i][j]);
			}
		}
		
		
		
		
		
		
		Collections.sort(distList);
		int result = distList.get(distList.size() - N);
		System.out.println(result);
		return result;
	}

	public static void main(String[] args) {
//		int[][] house = { { 0, 0 } };
//		new Q2().solution(1, house);
		
		int[][] house = { { 0, 0 }, { 1, 0 } };
		new Q2().solution(3, house);
	}
}

//
// 문제 설명
// A 케미컬은 어떤 도시에 공장 N개를 새로 지으려 합니다. 도시 지형은 이차원 평면으로 나타냅니다.
//
// 공장을 지을 때는 건축법을 따라야 합니다. 건축법은 다음과 같습니다.
//
// 이미 집이 있는 위치에는 공장을 지을 수 없습니다.
// 공장과 집은 거리가 멀수록 좋습니다.
// 한 위치에는 공장 하나만 지을 수 있습니다.
// 두 지점 사이의 거리는 직선거리로 정의합니다.
// 공장의 x, y 좌표 값은 각각 -100 이상 100 이하인 정수여야 합니다.
// 공장 N개를 지었을 때 집과 공장 사이의 거리 중 가장 작은 값을 구하려 합니다. 단, 숫자가 딱 떨어지지 않을 수 있으니 편의상 거리의
// 제곱을 구하겠습니다.
//
// 지어야 하는 공장 수 N, 모든 집의 좌표를 담은 2차원 배열 house가 solution 함수의 매개변수로 주어집니다. 공장 N개를
// 지었을 때, 집과 공장 사이의 거리 중 가장 작은 값의 제곱을 return 하도록 solution 함수를 완성해주세요. 단, 공장을 지을
// 수 없다면 -1을 return 해주세요.
//
// 제한사항
// N은 1 이상 100 이하인 자연수입니다.
// house는 가로 길이가 2, 세로 길이는 1 이상 100 이하인 2차원 배열입니다.
// house 원소는 [집의 x 좌표, 집의 y 좌표] 형식을 따릅니다.
// 집의 x, y 좌표는 -100 이상 100 이하인 정수입니다.
// 입출력 예
// N house result
// 1 [[0,0]] 20000
// 3 [[0,0],[1,0]] 19801
// 입출력 예 설명
// 입출력 예 #1
//
// (0, 0) 위치에 집이 있고, 공장 한 채를 지어야 합니다. (100, 100) 에 공장을 지으면 집과 공장의 거리가 가장 멉니다.1
// 따라서 집과 공장 사이의 거리 중 가장 작은 값의 제곱은 1002 + 1002 = 20,000이 됩니다.
//
// 입출력 예 #2
//
// image
//
// 그림에서 초록색 선은 공장을 지을 수 있는 범위를, 파란 점은 집의 위치를 나타냅니다. (0,0)과 (1,0)에 집이 있으므로 우선 3개의
// 공장 중 2개는 (-100,100)과 (-100,-100)에2 짓습니다. 세 번째 공장은 빨간 점선으로 된 점 중 아무 데나 짓습니다.
// 이때, 집과 공장 사이의 거리 중 가장 작은 값의 제곱은 1002 + 992 = 19801입니다3.
//
// 물론 (-100, -100), (-100, 100), (100, -100) 에 공장을 지어도 됩니다. ↩
//
// 그림에서 빨간색으로 칠해진 점입니다. ↩
//
// 거리의 제곱이 19801보다 커지도록 공장 3개를 짓는 방법은 없습니다. ↩
