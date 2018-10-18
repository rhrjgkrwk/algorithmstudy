package simulation;
//int& a*[]&, b, c*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

class Variable {
	Stack<String> st = new Stack<>();
	String type = "";
	String name = "";
	int ref = 0; // &의 개수.
	int star = 0; // * 개수.
	int parentheses = 0; // [] 개수.

	@Override
	public String toString() {
		String str = type;
		while (!st.isEmpty()) {
			str+=st.pop();
		}

		str += " " + name + ";";
		return str;
	}
}

public class Algo3568 {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer(sc.nextLine(), ", ");
		String type = st.nextToken();
		ArrayList<Variable> vars = new ArrayList<>();
		while (st.hasMoreTokens()) {
			String temp = st.nextToken();

			Variable var = new Variable();
			var.type = type;

			for (int i = 0; i < temp.length(); i++) {
				if (temp.charAt(i) == '&') {
					var.st.push("&");
				} else if (temp.charAt(i) == '*') {
					var.st.push("*");
				} else if (temp.charAt(i) == '[') {
					var.st.push("[]");
				} else if (('A' <= temp.charAt(i) && temp.charAt(i) <= 'Z') 
						|| ('a' <= temp.charAt(i) && temp.charAt(i) <= 'z')) {
					while (i < temp.length() 
							&& (('A' <= temp.charAt(i) && temp.charAt(i) <= 'Z') 
							|| ('a' <= temp.charAt(i) && temp.charAt(i) <= 'z'))) {
						var.name += temp.charAt(i++);
					}
					i--;
				}
			}
			vars.add(var);
		}

		for (Variable v : vars) {
			System.out.println(v);
		}
	}
}








