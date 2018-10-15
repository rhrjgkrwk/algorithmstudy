package dp;

public class AlgoSubString {
	public static String str ="hellocruelworld";
	public static void main(String[] args) {
		int [][] dp = new int [str.length()][str.length()];
		int max = 0;
		
		//dp[i][j] = i번부터 시작해서 j까지 부분문자열의 최대 길이.
		for (int i = 0; i < dp.length; i++) {
			dp[i][i] = 1;
			for (int j = i + 1; j < dp[i].length; j++) {
				if (!str.substring(i, j).contains(String.valueOf(str.charAt(j)))) {
					dp[i][j] = dp[i][j-1] + 1;
				}
				else {
					if(max < dp[i][j-1]) max = dp[i][j-1];
					break;
				}
			}
		}
		
		System.out.println(max);
	}
}
