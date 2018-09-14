package kakao;

import java.util.HashSet;

public class RectangleSize {
	public static void main(String[] args) {
		int rectangles[][] = {{1, 1, 6, 5}, {2, 0, 4, 2}, {2, 4, 5, 7}, {4, 3, 8, 6}, {7, 5, 9, 7}};
		System.out.println(solution(rectangles));
	}

	public static long solution(int[][] rectangles) {
		HashSet<String> set = new HashSet<>();
		// x1, y1, x2, y2
		for (int i = 0; i < rectangles.length; i++) {
			for (int k = rectangles[i][0]; k < rectangles[i][2]; k++) {
				for (int l = rectangles[i][1]; l < rectangles[i][3]; l++) {
					if (!set.contains(String.valueOf(k)+String.valueOf(l))) {
						set.add(String.valueOf(k)+String.valueOf(l));
					}
				}
			}
		}
		return set.size();
	}

}









