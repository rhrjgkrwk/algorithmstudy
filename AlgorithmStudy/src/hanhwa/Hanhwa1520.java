package hanhwa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

4 5
50 45 37 32 30
35 50 40 20 25
30 30 25 17 28
27 24 22 15 10

3

 */


public class Hanhwa1520{
   static int result = 0;
   static int[][] map;
   static boolean[][] visit;
   static int[] dx = {1,-1,0,0};
   static int[] dy = {0,0,-1,1};
   
   
   public static void main(String[] args) throws IOException {
      // TODO Auto-generated method stub

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int row = Integer.parseInt(st.nextToken());
      int col = Integer.parseInt(st.nextToken());
      
      map = new int[row][col];
      visit = new boolean[row][col];
      
      for (int i = 0; i < row; i++) {
         st = new StringTokenizer(br.readLine());
         for (int j = 0; j < col; j++) {
            map[i][j] = Integer.parseInt(st.nextToken());
         }
      }
      
      countRoad(row,col,0,0,0);
      
      System.out.println(result);
      
   }

   static void countRoad(int s_row, int s_col, int r, int c, int length) {
      if (r == s_row-1 && c == s_col-1) {
   //      System.out.println("결과?");
         result++;
         return;
      }

      int nr, nc;
      visit[r][c] = true;

      for (int i = 0; i < 4; i++) {
         nr = r + dx[i];
         nc = c + dy[i];
//   //      System.out.println("nrnc : " + nr + " " +nc + "    r c " + r + " " +c );
//         if (nr < 0 || nr >= s_row || nc < 0 || nc >= s_col) {
//   //         System.out.println("1");
//            continue;
//         } else if (visit[nr][nc] == true) {
//   //         System.out.println("2");
//            continue;
//         }
         if(nr>=0&&nc>=0&&nr<s_row&&nc<s_col&&!visit[nr][nc]&&   map[nr][nc] < map[r][c]) {
         countRoad(s_row, s_col, nr, nc, length + 1);
         }
         
         
         
         
      }

      visit[r][c] = false;
   }

}