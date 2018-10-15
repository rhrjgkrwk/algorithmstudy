package kakao_blind_2018;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Kakao2018Q1 {
	public static void main(String[] args) {
		String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" };
		String[] ans = new Kakao2018Q1().solution(record);
	}

	public String[] solution(String[] record) {
		ArrayList<String> ans = new ArrayList<>();
		HashMap<String, String> userIds = new HashMap<>();

		for (String log : record) {
			StringTokenizer st = new StringTokenizer(log, " ");
			String comm = st.nextToken();
			String userId = st.nextToken();
			String nickName = st.hasMoreTokens() ? st.nextToken() : null;

			if (comm.equals("Enter")) {
				userIds.put(userId, nickName);
			} else if (comm.equals("Change")) {
				userIds.put(userId, nickName);
			}
		}
		
		for (String log : record) {
			StringTokenizer st = new StringTokenizer(log, " ");
			String comm = st.nextToken();
			String userId = st.nextToken();
			if (comm.equals("Enter")) {
				ans.add(userIds.get(userId)+"님이 들어왔습니다.");
				System.out.println(userIds.get(userId)+"님이 들어왔습니다.");
			} else if (comm.equals("Leave")) {
				ans.add(userIds.get(userId)+"님이 나갔습니다.");
				System.out.println(userIds.get(userId)+"님이 나갔습니다.");
			}
		}
		
		String[] answer = new String[ans.size()];
		for (int i = 0; i < ans.size(); i++) {
			answer[i] = ans.get(i);
		}
		return answer;
	}
}

// ["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234
// Prodo","Change uid4567 Ryan"] [Prodo님이 들어왔습니다., Ryan님이 들어왔습니다., Prodo님이
// 나갔습니다.,
// Prodo님이 들어왔습니다.]
