package samsung2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Criminal {
   int r;
   int c;
   int time;
   public Criminal(int r, int c, int time) {
      super();
      this.r = r;
      this.c = c;
      this.time = time;
   }
}

public class Project4 {
   static int N,M;
   static int R,C,L;
   static int result;
   static int[][] map;
   static int[][] visit;
   static int[] Rows = {1,-1,0,0};
   static int[] Cols = {0,0,1,-1}; // D U R L
   static Queue<Criminal> que = new LinkedList<Criminal>();
   
   public static void bfs(){
      while(!que.isEmpty()){
         for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
               System.out.print(visit[i][j] + " ");
            }
            System.out.println();
         }
         System.out.println();
         Criminal criminal = que.poll();
         int r = criminal.r;
         int c = criminal.c;
         int time = criminal.time;
         
         int temp = map[r][c];
         result++;
         
         for(int i = 0 ; i<4; i ++){
            int nr = r + Rows[i];
            int nc = c + Cols[i];
            if(nr>= 0 && nr < N && nc >=0 && nc < M && visit[nr][nc] == 0 && time+1 <=L){
               if(pipe(temp,i)){
                  double sig =Math.pow(-1,i);
                  if(pipe(map[nr][nc], i+sig)){
                     visit[nr][nc] = visit[r][c]+1;
                     que.offer(new Criminal(nr,nc,time+1));
                  }
               }
            }
         }
         
      }
   }
   
   
   public static boolean pipe(int pipe, double dir){
      if(dir == 0) {
            if (pipe == 1 || pipe == 2 || pipe == 5 || pipe == 6)
                return true;
        }
        if(dir == 1){
            if(pipe == 1 || pipe == 2 || pipe == 4 || pipe == 7)
                return true;
        }
        if(dir == 2){
            if(pipe == 1 || pipe == 3 || pipe == 4 || pipe == 5)
                return true;
        }
        if(dir == 3){
            if(pipe == 1 || pipe == 3 || pipe == 6 || pipe == 7)
                return true;
        }
        return false;
    }
   
   
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      
      int T = Integer.parseInt(br.readLine());
      
      for (int tc = 1; tc <= T; tc++) {
         st = new StringTokenizer(br.readLine());
         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());
         R = Integer.parseInt(st.nextToken());
         C = Integer.parseInt(st.nextToken());
         L = Integer.parseInt(st.nextToken());
         
         map = new int[N][M];
            visit = new int[N][M];
         
            result = 0;
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            visit[R][C] = 1;
            que.offer(new Criminal(R, C, 1));
            bfs();
            System.out.println("#"+tc+" "+result);
            
      } // TC End
      
   }

}