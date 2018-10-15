package kakao_blind_2018;

import java.util.Arrays;

public class Kakao2018Q2 {

	public static void main(String[] args) {
		// int[] stages = { 2, 1, 2, 6, 2, 4, 3, 3 };
		// int N = 5;
		int[] stages = { 4, 4, 4, 4, 4 };
		int N = 4;
		int[] ans = new Kakao2018Q2().solution(N, stages);
		for (int i : ans) {
			System.out.println(i);
		}
	}

	public int[] solution(int N, int[] stages) {
		double[] ratios = new double[N + 1]; // 스테이지 별 실패융..
		for (int i = 1; i <= N; i++) {
			int unfinished = 0;
			int finished = 0;

			for (int j = 0; j < stages.length; j++) {
				if (stages[j] > i) {
					finished++;
				}
				if (stages[j] == i) {
					unfinished++;
				}
			}
			ratios[i] = (double) unfinished / (double) (finished + unfinished);
		}

		int[] answer = new int[N];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = i + 1;
		}

		for (int i = 0; i < answer.length - 1; i++) {
			for (int j = i + 1; j < answer.length; j++) {
				if (ratios[answer[i]] < ratios[answer[j]]) {
					int temp = answer[i];
					answer[i] = answer[j];
					answer[j] = temp;
				} else if (ratios[answer[i]] == ratios[answer[j]] && answer[j] < answer[i]) {
					int temp = answer[i];
					answer[i] = answer[j];
					answer[j] = temp;
				}
			}
		}

		return answer;
	}
}
