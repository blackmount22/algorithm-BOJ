package baekjoonPjt;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Location2178 {
   
   int x;
   int y;
   
   public Location2178(int x, int y) {
      // TODO Auto-generated constructor stub
      this.x = x;
      this.y = y;
   }
}

public class Baekjoon2178 {

   static int n;
   static int m;
   static int[][] map;
   static int[][] visit;
   static int result =0;
   static Queue<Location2178> q = new LinkedList<Location2178>();
   
   public static void main(String[] args) {
      // TODO Auto-generated method stub

      Scanner sc = new Scanner(System.in);
      n = sc.nextInt();
      m = sc.nextInt();
      map = new int[n][m];
      visit = new int[n][m];
      
      for(int i=0;i<n;i++) {
         String row = sc.next();
         
         for(int j=0;j<m;j++) {
            map[i][j] = row.charAt(j) - '0';
         }
      }
      
      q.add(new Location2178(0, 0));
      visit[0][0] = 1;
      getBfs();
      
      System.out.println(result+1);
   }
   
   public static void getBfs() {
      int[] xx = {-1,0,1,0};
      int[] yy = {0,1,0,-1};
      
      while(!q.isEmpty()) {
         
         int qSize = q.size();
         
         for(int k=0;k<qSize;k++) {
            int x = q.peek().x;
            int y = q.poll().y;
            
            if(x == n-1 && y == m-1) {
               return;
            }
            
            for(int i=0;i<4;i++) {
               int ax = x + xx[i];
               int ay = y + yy[i];
               
               if(ax >=0 && ax < n && ay>=0 && ay<m && map[ax][ay] == 1 && visit[ax][ay] == 0) {
                  visit[ax][ay] = 1;
                  q.add(new Location2178(ax, ay));
               }
            }
         }
         result++;
      }
   }
}