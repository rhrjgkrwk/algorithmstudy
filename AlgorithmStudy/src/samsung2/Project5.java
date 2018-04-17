package samsung2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

   
   class Point1{
      int r; int c;

      public Point1(int r, int c) {
         super();
         this.r = r;
         this.c = c;
      }
      
   }
   public class Project5 {
   static int N, M, R, C, L; // row, col of Map // row, col of start // Time
   static int map[][];
   static boolean[][] visited;
   static int time[][];
   static int answer;
   static int[] Row = { -1, 1, 0, 0 };   // U D L R    
   static int[] Col = { 0, 0, -1, 1 };
   static ArrayList<Tunnel> tunnels = new ArrayList<Tunnel>();
   static Queue<Point1> pQueue;
   
   public static void main(String[] args) throws IOException {
      solution();
   }

   static void solution() throws IOException {
      Scanner sc = new Scanner(System.in);
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      // UDLR
      Tunnel tu0 = new Tunnel(0, false, false, false, false);   tunnels.add(tu0);
      Tunnel tu1 = new Tunnel(1, true, true, true, true);      tunnels.add(tu1);
      Tunnel tu2 = new Tunnel(2, true, true, false, false);   tunnels.add(tu2);
      Tunnel tu3 = new Tunnel(3, false, false, true, true);   tunnels.add(tu3);
      Tunnel tu4 = new Tunnel(4, true, false, false, true);   tunnels.add(tu4);
      Tunnel tu5 = new Tunnel(5, false, true, false, true);   tunnels.add(tu5);
      Tunnel tu6 = new Tunnel(6, false, true, true, false);   tunnels.add(tu6);
      Tunnel tu7 = new Tunnel(7, true, false, true, false);   tunnels.add(tu7);

      int test_case = Integer.parseInt(br.readLine());

      
      for (int tc = 1; tc <= test_case; tc++) {
         StringTokenizer stk = new StringTokenizer(br.readLine()," ");

         N = Integer.parseInt(stk.nextToken());   
         M = Integer.parseInt(stk.nextToken());
         R = Integer.parseInt(stk.nextToken());
         C = Integer.parseInt(stk.nextToken());
         L = Integer.parseInt(stk.nextToken());
         

         map = new int[N][M];
         visited = new boolean[N][M];
         time = new int[N][M];
         /*
         for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
               System.out.print(map[i][j] +"\t");
            }
            System.out.println();
         }
         */
         for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < M; j++) {
               map[i][j] = Integer.parseInt(stk.nextToken());
               visited[i][j] = false;
            }
         }
//         findDFS(R,C,1);
         pQueue = new LinkedList<>();
         //countCase() countCase쓰지 않고 bfs 돌면서 세는게 좋을 것 같음
         
         System.out.println("#" + tc+" "+findBFS(R,C,1));

      } // TC end

   }

   
   static int findBFS(int R, int C, int Time){ //return 타입을 int로 주고 답을 리턴하기로 햇다
      //visited[R][C] = true; //time[][]을 쓸거면 visit을 굳이 안써도 된다.
      pQueue.add(new Point1(R,C)); //시작점을 넣어준다.
      time[R][C]=1; //시작점을 1로 초기화한다.
      
      int res = 0; //범죄자 수를 담는다.
      
      while (!pQueue.isEmpty()) {
         Point1 temp = pQueue.poll();      
         int r = temp.r; 
         int c = temp.c;
         
         //visited[r][c] = true; 
         //time[r][c] = Time; //여기가 문제인거같다
         
         /*
         System.out.println("-------------------");
         for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
            	System.out.print(time[i][j] + " ");
            }
            System.out.println();
         }
         
         */

         
         res++;
         
         for (int i = 0; i < 4; i++) {
            int nr = r + Row[i];
            int nc = c + Col[i];

            // U
            if (nr >= 0 && nr < N && nc >= 0 && nc < M && i == 0 && tunnels.get(map[r][c]).Up == true
                  && tunnels.get(map[nr][nc]).Down == true && time[nr][nc] == 0 && time[r][c]+1<=L) { //time과 visit이 중복되니 visit을 지우자
               pQueue.add(new Point1(nr, nc));
               time[nr][nc]=time[r][c]+1;
            } // D
            else if (nr >= 0 && nr < N && nc >= 0 && nc < M && i == 1 && tunnels.get(map[r][c]).Down == true
                  && tunnels.get(map[nr][nc]).Up == true  && time[nr][nc] == 0 && time[r][c]+1<=L) {
               pQueue.add(new Point1(nr, nc));
               time[nr][nc]=time[r][c]+1;
            } // L
            else if (nr >= 0 && nr < N && nc >= 0 && nc < M && i == 2 && tunnels.get(map[r][c]).Left == true
                  && tunnels.get(map[nr][nc]).Right == true  && time[nr][nc] == 0 && time[r][c]+1<=L) {
               pQueue.add(new Point1(nr, nc));
               time[nr][nc]=time[r][c]+1;
            } // R
            else if (nr >= 0 && nr < N && nc >= 0 && nc < M && i == 3 && tunnels.get(map[r][c]).Right == true
                  && tunnels.get(map[nr][nc]).Left == true  && time[nr][nc] == 0 && time[r][c]+1<=L) {
               pQueue.add(new Point1(nr, nc));
               time[nr][nc]=time[r][c]+1;
            }
         }   
      }
      return res;
   }
   
   static void findDFS(int R, int C, int Time) {   // time 1로 시작
      visited[R][C] = true;
/*
      System.out.println("Time : " + Time);
      for (int i = 0; i < N; i++) {
         for (int j = 0; j < M; j++) {
            if (visited[i][j]== true)
            System.out.print("범죄자"+ "\t");
            else {
               System.out.print(visited[i][j] + "\t");
            }
         }
         System.out.println();
      }
*/
      
      for (int i = 0; i < 4; i++) {   // U D L R
         int nr = R + Row[i];
         int nc = C + Col[i];
         
         //U
         if(nr >= 0 && nr < N && nc >= 0 && nc < M && i == 0 && tunnels.get(map[R][C]).Up == true && tunnels.get(map[nr][nc]).Down == true && visited[nr][nc] == false && Time+1 <= L){
            findDFS(nr,nc,Time+1);
         }//D
         else if(nr >= 0 && nr < N && nc >= 0 && nc < M && i ==1 && tunnels.get(map[R][C]).Down == true && tunnels.get(map[nr][nc]).Up == true && visited[nr][nc] == false && Time < L){
            findDFS(nr,nc,Time+1);
         }//L
         else if(nr >= 0 && nr < N && nc >= 0 && nc < M && i ==2 && tunnels.get(map[R][C]).Left == true && tunnels.get(map[nr][nc]).Right == true && visited[nr][nc] == false && Time < L){
            findDFS(nr,nc,Time+1);
         }//R
         else if(nr >= 0 && nr < N && nc >= 0 && nc < M && i ==3 && tunnels.get(map[R][C]).Right == true && tunnels.get(map[nr][nc]).Left == true && visited[nr][nc] == false && Time < L){
            findDFS(nr,nc,Time+1);
         }

      }

   }
   
   static int countCase() {
      int result = 0;
      for (int i = 0; i < N; i++)
         for (int j = 0; j < M; j++)
            if (time[i][j] > 0)
               result++;
      return result;
   }

   static class Tunnel {
      int type;
      boolean Up;
      boolean Down;
      boolean Left;
      boolean Right;

      public Tunnel(int type, boolean up, boolean down, boolean left, boolean right) {
         super();
         this.type = type;
         Up = up;
         Down = down;
         Left = left;
         Right = right;
      }

   }
}