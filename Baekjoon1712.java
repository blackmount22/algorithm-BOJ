package baekjoonPjt;

import java.util.Scanner;

public class Baekjoon1712 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b= sc.nextInt();
        int c = sc.nextInt();

        // B가 C보다 클경우 절대 손익분기점이 나올 수 없음.
        if(b >= c){
            System.out.println(-1);
            return;
        }

        System.out.println((a / (c-b)) +1);
    }
}
