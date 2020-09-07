package baekjoonPjt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Baekjoon2667 {

   static int n;
   static int[][] map;
   static int[][] visit;
   static int totalCnt =0;
   static int danjiCnt= 0;
   static ArrayList<Integer> result = new ArrayList<Integer>();
   
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      
      Scanner sc = new Scanner(System.in);
      n = sc.nextInt();
      map = new int[n][n];
      visit = new int[n][n];
      
      for(int i=0;i<n;i++) {
         String str = sc.next();
         for(int j=0;j<str.length();j++) {
            map[i][j] = str.charAt(j) - '0';
         }
      }
      
      for(int i=0;i<n;i++) {
         for(int j=0;j<n;j++) {
            if(map[i][j] == 1 && visit[i][j]==0) {
               danjiCnt= 1;
               visit[i][j] = 1;
               getDfs(i, j);
               totalCnt++;
               result.add(danjiCnt);
            }
         }
      }

      System.out.println(totalCnt);
      Collections.sort(result);
      
      int resultSize = result.size();
      if( resultSize == 0 ) {
         System.out.println(0);
         return;
      } 
      
      for(int i=0;i<result.size();i++) {
         System.out.println(result.get(i));
      }
   }

   public static void getDfs(int x, int y) {
      int[] xx = {-1,0,1,0};
      int[] yy = {0,1,0,-1};
      
      for(int i=0;i<4;i++) {
         int ax = x+xx[i];
         int ay = y+yy[i];
         
         if(ax >=0 && ax < n && ay >= 0 && ay < n && visit[ax][ay] == 0 && map[ax][ay] == 1) {
            danjiCnt++;
            visit[ax][ay] = 1;
            getDfs(ax, ay);
         }
      }
   }
}