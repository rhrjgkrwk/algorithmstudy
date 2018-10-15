package lg_cns;

public class Q1 {
	public static void main(String[] args) {
		
	}
	
	 public int solution(int[] people, int[] tshirts) {
	        int answer = 0;
	        
	        for (int i = 0; i < people.length; i++) {
				for (int j = 0; j < tshirts.length; j++) {
					if (people[i] <= tshirts[j]) {
						answer++;
					}
				}
			}
	        
	        return answer;
	    }
}
