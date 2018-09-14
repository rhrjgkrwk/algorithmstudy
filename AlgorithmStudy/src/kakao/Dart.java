package kakao;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dart {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String dartResult = sc.nextLine();
		Pattern pattern = Pattern.compile("[0-9]{1,2}[A-Z]{1}[*,#]{0,1}");
		Matcher matcher = pattern.matcher(dartResult);
		int totalScore = 0;
		int lastScore = 0;
		while (matcher.find()) {
			String temp = matcher.group();
			int scoreThisTime = 0;
			int scoreBoard = 0;
			String area = "";
			String prize = "";
			
			Matcher tempMatcher = Pattern.compile("[0-9]{1,2}").matcher(temp);
			if(tempMatcher.find()) scoreBoard = Integer.parseInt(tempMatcher.group());
			
			tempMatcher = Pattern.compile("[A-Z]{1}").matcher(temp);
			if(tempMatcher.find()) area = tempMatcher.group();
			
			tempMatcher = Pattern.compile("[*,#]{1}").matcher(temp);
			if(tempMatcher.find()) prize = tempMatcher.group();
			
			
			if (area.equals("S")) {
				scoreThisTime = scoreBoard;
			} else if(area.equals("D")) {
				scoreThisTime = (int)Math.pow(scoreBoard, 2);
			} else {
				scoreThisTime = (int)Math.pow(scoreBoard, 3);
			}

			
			if (prize.equals("*")) {
				totalScore += (lastScore + scoreThisTime * 2);
			} else if(prize.equals("#")){
				totalScore -= scoreThisTime;  
			} else {
				totalScore += scoreThisTime;
			}
			
			lastScore = scoreThisTime;
		}
		System.out.println(totalScore);
	}
}
