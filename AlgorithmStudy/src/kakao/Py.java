package kakao;

public class Py {
	public static void main(String[] args) {
		System.out.println(new Py().solution(""));
	}
	boolean solution(String s) {
        boolean answer = true;
        int p=0;
        int y=0;
        String temp = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
			if (temp.charAt(i) == 'p') {
				p++;
				continue;
			}
			if (temp.charAt(i)=='y') {
				y++;
			}
		}
        return (p==y);
    }
}
