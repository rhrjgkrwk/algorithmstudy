package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Amho14584 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String pwd = br.readLine();
		int n = Integer.parseInt(br.readLine());
		String[] words = new String[n];
		for (int i = 0; i < n; i++) {
			words[i] = br.readLine();
		}
		boolean flag = true;
		do {
			for (int i = 0; i < words.length; i++) {
				if (pwd.contains(words[i])) {
					System.out.println(pwd);
					flag = false;
					break;
				}
			}
			pwd  = new String(nextCharArray(pwd.toCharArray()));
		}while (flag);
		br.close();
	}
	public static char[] nextCharArray(char[] c){
		for (int i = 0; i < c.length; i++) {
			c[i] = (char)(((int)(c[i]+1)>122?(int)(c[i]+1)%122+96:(int)(c[i]+1)));
		}
		return c;
	}
}
/*
��ȣ �ص� Ǯ��
�ð� ����	�޸� ����	����	����	���� ���	���� ����
1 ��	64 MB	765	251	231	42.077%
����
�θ��� �屺 ī�̻縣�� �θ����� ������ ���� �𸣰� �ϱ� ���Ͽ� ��ȣ�� ����ߴ�. 
ī�̻縣�� ������ ���� ���忡 �ִ� ��� ���ĺ� ���ڸ� �� ĭ ���� ���ĺ����� �ٲٴ� ������� ��ȣ�� �������.
�Ʒ� ǥ�� ��� ���ڸ� 17ĭ ���� ���ĺ����� �ٲ��� �� �� ���ڰ� � ���ĺ����� �ٲ���� ��Ÿ�� ǥ�̴�.



�� ����� ���� ��Baekjoon Online Judge���� ��ȣȭ�ϸ� ��Srvbaffe Feczev Aluxv���� �ȴ�.

����� �丣�þ� ������ �屺���μ� ī�̻縣�� ��ȣ�� �ص��ؾ� �Ѵ�.
 ����� ī�̻縣�� � ������� ������ ��ȣȭ�ϴ����� �˰� ������
  ī�̻縣�� �� ĭ ���� ���ĺ����� �ٲٴ����� �𸥴�. ������,
   ����� ���ϰ� �θ��� ������ �����ͼ� �̸� ���� ī�̻縣�� ��ȣ��
    �ص��� �� ���� ������ ���δ�. ���� ���ɿ��� �������� �ܾ ������ 
    ������ ������ ������ �ܾ �ݵ�� ���� ���̴�. 
    ���� ��ȣ�� �ص��� ��, �ص��� ���忡�� ������ ������ �ܾ �ݵ�� �ϳ� �̻� �����ؾ� �Ѵ�.

ī�̻縣�� ��ȣ�� ������ ������ �־����� ��, ��ȣ�� �ص��ϴ� ���α׷��� �ۼ��Ͽ���.

�Է�
ù ��° �ٿ� ��ȣ���� �־�����. ��ȣ���� �ҹ��ڷθ� �̷���� ���� 100 ������ ���ڿ��̴�.

�� ��° �ٿ��� ������ �ִ� �ܾ��� �� N�� �־�����. (1 �� N �� 20)

�� ��° �ٺ��� N���� �ٿ��� ������ �ִ� �ܾ �־�����. ��� �ܾ�� �ҹ��ڷθ� �̷���� ���� 20 ������ ���ڿ��̴�.

���
��ȣ���� �ص��Ͽ� ���� ������ ����Ѵ�. ��� �����Ϳ� ���ؼ� ���� �� ������ ��츸 ���´ٰ� �����Ѵ�.

���� �Է� 
srbvaffefeczevaluxv
3
bake
bread
cookie
���� ��� 
bakejoononlinejudge
*/