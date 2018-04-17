package hanhwa;

import java.util.Scanner;

public class Hanhwa14915 {
	public static int m; //십진수
	public static int n; //n진수 <=16
	public static String strTable = "0123456789ABCDEFGH";
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		
		String res = "";
		while(true){
			if (m<n) {
				//마지막 수 
				res = strTable.charAt(m) + res;
				break;
			}
			res = strTable.charAt(m%n)+res;
			m = m/n;
		}
		System.out.println(res);
	}
}
