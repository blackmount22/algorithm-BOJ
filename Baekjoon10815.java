package baekjoonPjt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Baekjoon10815 {

   static ArrayList<Integer> arr = new ArrayList<Integer>();
   static ArrayList<Integer> result = new ArrayList<Integer>();
   
   public static void main(String[] args) {
      // TODO Auto-generated method stub

      Scanner sc = new Scanner(System.in);
      
      int n = sc.nextInt();
      for(int i=0;i<n;i++) {
         int number = sc.nextInt();
         arr.add(number);
      }
      
      Collections.sort(arr);
      int m = sc.nextInt();
      ArrayList<Integer> numbers = new ArrayList<Integer>();
      for(int i=0;i<m;i++) {
         int number = sc.nextInt();
         numbers.add(number);
      }
      
      for(int i=0;i<numbers.size();i++) {
         BinarySearch(numbers.get(i), 0, arr.size());
         System.out.print(result.get(i)+ " ");
      }
   }
   
   public static void BinarySearch(int target, int left, int right) {
      if(left > right) {
         result.add(0);
         return;
      }
      
      int mid = (left+right) / 2;
      
      if(mid >= arr.size()) {
         result.add(0);
         return;
      }
      
      if(arr.get(mid) == target) {
         result.add(1);
         return;
      }
      else if(arr.get(mid) > target) {
         BinarySearch(target, left, mid-1);
      } 
      else {
         BinarySearch(target, mid+1, right);
      }
   }

}