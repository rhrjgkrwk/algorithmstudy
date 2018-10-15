package kakao_blind_2018;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Kakao2018Q6 {
	public static void main(String[] args) {
		String pages[] = {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"};
		new Kakao2018Q6().solution("blind", pages);
	}

	public int solution(String word, String[] pages) {
		double[] matchingPoint = new double[pages.length];
		//word 매칭 수
		int[] wordPoint = new int[pages.length];
		//외부 링크 수;
		int[] aTagNum = new int[pages.length];
		
		
		
		
		HashMap<String, Page> map = new HashMap<>();
		
		for (int i = 0; i < pages.length; i++) {
			
			Pattern pattern = Pattern.compile("[a-zA-z]+(.com){1}");
			Matcher matcher = pattern.matcher(pages[i].toLowerCase());
			matcher.find();
			String url = matcher.group();
			map.put(url, new Page());
			map.get(url).index = i;
			while(matcher.find()) {
				map.get(url).links.add(matcher.group());
			}
			
			pattern = Pattern.compile("[^A-Za-z]{0}"+word.toLowerCase()+"[^A-Za-z]{0}");
			matcher = pattern.matcher(pages[i].toLowerCase());
			while(matcher.find()) map.get(url).wordPoint++;
			
		}
		
		for (String url : map.keySet()) {
			double linkPoint = 0;
			for (String other : map.get(url).links) {
				linkPoint += ((double)map.get(other).wordPoint / map.get(other).links.size());
			}
			
			matchingPoint[map.get(url).index] = map.get(url).wordPoint + linkPoint;
		}
		
		for (double i : matchingPoint) {
			System.out.println(i);
		}
		return 1;
	}
}
class Page {
	int index =0;
	int wordPoint =0;
	ArrayList<String> links = new ArrayList<>();
}