package kakao;

import java.util.ArrayList;

public class HateSameNum {
	public static void main(String[] args) {
		int arr[] = {1,1,3,3,0,1,1};
		int res[] = new HateSameNum().solution(arr);
		for (int i : res) {
			System.out.println(i);
		}
	}
	public int[] solution(int []arr) {
		ArrayList<Integer> res = new ArrayList<>();
		res.add(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			if (arr[i-1] != arr[i]) {
				res.add(arr[i]);
			}
		}
		int answer[] = new int[res.size()];
		for (int i = 0; i<res.size(); i++) {
			answer[i] = res.get(i);
		}
		return answer;
	}
}
