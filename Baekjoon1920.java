package baekjoonPjt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Baekjoon1920 {

   static ArrayList<Integer> numbers = new ArrayList<Integer>();
   static ArrayList<Integer> result = new ArrayList<Integer>();
   
   public static void main(String[] args) {
      // TODO Auto-generated method stub

      Scanner sc = new Scanner(System.in);
      ArrayList<Integer> checkNumbers = new ArrayList<Integer>();
      
      int n = sc.nextInt();
            
      for(int i=0;i<n;i++) {
         int number = sc.nextInt();
         numbers.add(number);
      }
      
      Collections.sort(numbers);
      
      int m = sc.nextInt();
      for(int i=0;i<m;i++) {
         int checkNumber = sc.nextInt();
         checkNumbers.add(checkNumber);
      }
      
      for(int i=0;i<checkNumbers.size();i++) {
         BinarySearch(checkNumbers.get(i), 0, numbers.size());
         System.out.println(result.get(i));
      }
   }
   
   public static void BinarySearch(int target, int left, int right) {
      if(left > right) {
         result.add(0);
         return;
      }
      
      int mid = (left+right) / 2;
      
      if(mid >= numbers.size()) {
         result.add(0);
         return;
      }
      
      if(numbers.get(mid) == target) {
         result.add(1);
         return;
      }
      else if(numbers.get(mid) > target) {
         BinarySearch(target, left, mid-1);
      } 
      else {
         BinarySearch(target, mid+1, right);
      }
   }
}