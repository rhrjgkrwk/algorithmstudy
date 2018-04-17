package hanhwa;

import java.math.BigDecimal;
import java.util.Scanner;

public class Hanhwa1026 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigDecimal n = new BigDecimal(sc.nextLine());
		String operator = sc.nextLine();
		BigDecimal m = new BigDecimal(sc.nextLine());
		
		BigDecimal res = null;
		if (operator.equals("+")) {
			res = n.add(m);
		} else if (operator.equals("-")) {
			res = n.subtract(m);
		} else if (operator.equals("*")) {
			res = n.multiply(m);
		} else if (operator.equals("/")) {
			res = n.divide(m);
		}
		System.out.println(res);
	}
}
