package kakao_blind_2018;

public class Kakao2018Q4 {
	public static void main(String[] args) {
		int[] food_times = { 3,1,2 };
		int k = 5;
		System.out.println(new Kakao2018Q4().solution(food_times, k));
	}

	public int solution(int[] food_times, long k) {
	        int now = 0;
	        for (int i = 0; i < k; i++) {
	        	while (food_times[now] == 0) {
	        		now = (now + 1) % food_times.length;
				}
                food_times[now]--;
                now = (now + 1) % food_times.length;
	        }
	        int cnt = 0;
	        while (cnt < food_times.length && food_times[now] == 0) {
	            now = (now + 1) % food_times.length;
	            cnt++;
	        }
	        int answer = food_times[now] == 0 ? -1 : now + 1;
	        return answer;
		
		
		
		
		
		
		
		
//		int unchecked = 0;
//		for (int i = 0; i < food_times.length; i++) {
//			if (k % food_times.length > i) {
//				unchecked -= food_times[i] - (int) (k / food_times.length + 1) < 0 ? food_times[i] - (int) (k / food_times.length + 1) : 0;
//
//			} else {
//				unchecked -= food_times[i] - (int) (k / food_times.length) < 0 ? food_times[i] - (int) (k / food_times.length) : 0;
//			}
//		}
//
//		for (int i = 0; i < food_times.length; i++) {
//			if ((k + unchecked) % food_times.length > i) {
//				food_times[i] = food_times[i] - (int) ((k + unchecked) / food_times.length + 1);
//			} else {
//				food_times[i] = food_times[i] - (int) ((k + unchecked) / food_times.length);
//			}
//		}
//
//		int now = (int) ((k + unchecked) % food_times.length) % food_times.length;
//		int cnt = 0;
//		while (cnt < food_times.length && food_times[now] <= 0) {
//			now = (now + 1) % food_times.length;
//			cnt++;
//		}
//		int answer = food_times[now] <= 0 ? -1 : now + 1;
//		return answer;
	}
}
