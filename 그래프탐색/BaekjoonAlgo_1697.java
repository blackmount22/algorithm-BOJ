import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Number1697 {
	int num;
	int sec;
	
	public Number1697(int num, int sec) {
		// TODO Auto-generated constructor stub
		this.num = num;
		this.sec = sec;
	}
}

public class BaekjoonAlgo_1697 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int result = 0;
		int[] visit = new int[100001];
		visit[n] = 1;
		Queue<Number1697> q = new LinkedList<>();
		
		q.offer(new Number1697(n, result));
		
		while(!q.isEmpty()) {
			int curNum = q.peek().num;
			int secResult = q.poll().sec;
			
			if(curNum == k) {
				System.out.println(secResult);
				return;
			}
			
			int leftNum = curNum -1;
			int rightNum = curNum +1;
			int multiNum = curNum *2;
			
			if(leftNum >= 0 && leftNum < 100001) {
				if(visit[leftNum] ==0) {
					q.offer(new Number1697(leftNum, secResult + 1));
					visit[leftNum] = 1;
				}				
			}
			
			if(rightNum >= 0 && rightNum < 100001) {
				if(visit[rightNum] ==0) {
					q.offer(new Number1697(rightNum, secResult + 1));
					visit[rightNum] = 1;
				}				
			}
			
			if(multiNum >= 0 && multiNum < 100001) {
				if(visit[multiNum] ==0) {
					q.offer(new Number1697(multiNum, secResult + 1));
					visit[multiNum] = 1;
				}			
			}
		}
	}

}
