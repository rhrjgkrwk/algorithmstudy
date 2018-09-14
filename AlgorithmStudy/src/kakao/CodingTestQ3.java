package kakao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodingTestQ3 {
	private static final Scanner scan = new Scanner(System.in);

	public static void main(String args[]) throws Exception {
		// read the string filename
		
		
//		String log = "bureger.letters.com - - [01/Jul/1995:00:00:12-0400] \"GET /shuttle/cond/vide/live.gif HTTP/1.0\" 200 0";
		String filename;
		filename = scan.nextLine();
		BufferedReader br = new BufferedReader(new FileReader(filename));
		BufferedWriter bw = new BufferedWriter(new FileWriter("gifs_"+filename));
		
		Set<String> res = new HashSet<>();
		
		String log;
		while ((log = br.readLine()) != null) {
			String request = null;
			String statusCode = null;
			String method = null;
			String protocol = null;
			String file = null;
			String extension = null;
			
			//get request info
			Pattern pt = Pattern.compile("\".+\"");
			Matcher mc = pt.matcher(log); 
			if(mc.find()) {
				request = mc.group();
			}
			
			//get status code
			pt = Pattern.compile("\" [0-9]{3}");
			mc = pt.matcher(log);
			if(mc.find()) {
				statusCode = mc.group().substring(2);
			}
			
			
			String temp[] = request.split(" ");
			
			method = temp[0].substring(1);
			protocol = temp[2].split("/")[0];
			file = temp[1].substring(temp[1].lastIndexOf('/')+1);
			extension = file.substring(file.lastIndexOf('.')+1);
			
			if (method.equals("GET") && protocol.equals("HTTP") && statusCode.equals("200") && extension.toLowerCase().equals("gif")) {
				res.add(file);
			}
		}
		
		for (String f : res) {
			bw.write(f);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
