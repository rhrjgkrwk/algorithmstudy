package kakao;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;


public class ShuttleBus {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int temp = Integer.parseInt(sc.nextLine());
		int n = Integer.parseInt(sc.nextLine()); // 회.
		int t = Integer.parseInt(sc.nextLine()); // 분 간격.
		int m = Integer.parseInt(sc.nextLine()); // 최대 m명.
		ArrayList<LocalTime> timetable = new ArrayList<>();
		for (int i = 0; i < temp; i++) {
			LocalTime time = LocalTime.parse(sc.nextLine(), DateTimeFormatter.ofPattern("HH:mm"));
			timetable.add(time);
		}
		
		Collections.sort(timetable); //빨리온 순서대로 정렬.
		LocalTime nextBus = LocalTime.of(9, 0);
		boolean passengerCheck[] = new boolean[timetable.size()];
		ArrayList<ArrayList<LocalTime>> bus = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			ArrayList<LocalTime> passenger = new ArrayList<>();
			for (int j = 0 ; j < timetable.size() ; j++) {
				if (timetable.get(j).compareTo(nextBus) <= 0 && passenger.size() < m && !passengerCheck[j]) {
					passenger.add(timetable.get(j));
					passengerCheck[j] = true;
				}
			}
			bus.add(passenger);
			nextBus = nextBus.plusMinutes(t);
		}
		
		
		nextBus = LocalTime.of(9, 0);
		for (int i=0; i<n; i++) {
			ArrayList<LocalTime> busNow = bus.get(i);
			if (busNow.size() < m) {
				System.out.println(LocalTime.of(9, i*t));
				return;
			}
			if (i == n-1 && busNow.size() >= m) {
				System.out.println();
			}
		}
		
		
	}
}





/*
4
2
10
2
08:02
08:00
08:01
08:03

 * 
 * 카카오에서는 무료 셔틀버스를 운행하기 때문에 판교역에서 편하게 사무실로 올 수 있다. 카카오의 직원은 서로를 ‘크루’라고 부르는데,
 * 아침마다 많은 크루들이 이 셔틀을 이용하여 출근한다.
 * 
 * 이 문제에서는 편의를 위해 셔틀은 다음과 같은 규칙으로 운행한다고 가정하자.
 * 
 * 셔틀은 09:00부터 총 n회 t분 간격으로 역에 도착하며, 하나의 셔틀에는 최대 m명의 승객이 탈 수 있다. 셔틀은 도착했을 때 도착한
 * 순간에 대기열에 선 크루까지 포함해서 대기 순서대로 태우고 바로 출발한다. 예를 들어 09:00에 도착한 셔틀은 자리가 있다면 09:00에
 * 줄을 선 크루도 탈 수 있다. 일찍 나와서 셔틀을 기다리는 것이 귀찮았던 콘은, 일주일간의 집요한 관찰 끝에 어떤 크루가 몇 시에 셔틀
 * 대기열에 도착하는지 알아냈다. 콘이 셔틀을 타고 사무실로 갈 수 있는 도착 시각 중 제일 늦은 시각을 구하여라.
 * 
 * 단, 콘은 게으르기 때문에 같은 시각에 도착한 크루 중 대기열에서 제일 뒤에 선다. 또한, 모든 크루는 잠을 자야 하므로 23:59에 집에
 * 돌아간다. 따라서 어떤 크루도 다음날 셔틀을 타는 일은 없다.
 * 
 * 입력 형식 셔틀 운행 횟수 n, 셔틀 운행 간격 t, 한 셔틀에 탈 수 있는 최대 크루 수 m, 크루가 대기열에 도착하는 시각을 모은 배열
 * timetable이 입력으로 주어진다.
 * 
 * 0 ＜ n ≦ 10 0 ＜ t ≦ 60 0 ＜ m ≦ 45 timetable은 최소 길이 1이고 최대 길이 2000인 배열로, 하루 동안
 * 크루가 대기열에 도착하는 시각이 HH:MM 형식으로 이루어져 있다. 크루의 도착 시각 HH:MM은 00:01에서 23:59 사이이다. 출력
 * 형식 콘이 무사히 셔틀을 타고 사무실로 갈 수 있는 제일 늦은 도착 시각을 출력한다. 도착 시각은 HH:MM 형식이며, 00:00에서
 * 23:59 사이의 값이 될 수 있다.
 */