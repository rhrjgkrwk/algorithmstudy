package lg_cns;
import java.util.*;

public class DemoTestQ1 {

	public boolean solution(int[] arr) {
	        boolean answer = true;
	        boolean []check = new boolean[arr.length+1];
	        for (int i = 0; i < arr.length; i++) {
				check[arr[i]] = true;
			}
	        
	        for (int i = 1; i < check.length; i++) {
				if (!check[i]) {
					answer = false;
				}
			}
	        
	        return answer;
	    }

	public static void main(String[] args) {
			
		}
}
