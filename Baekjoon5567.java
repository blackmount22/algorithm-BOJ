package baekjoonPjt;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Location5567{
	int idx;
	
	public Location5567(int idx) {
		// TODO Auto-generated constructor stub
		this.idx = idx;
	}
}

public class Baekjoon5567 {

	static int n;
	static int m;
	static int[][] friendsMap;
	static int[] visit;
	static Queue<Integer> q = new LinkedList<Integer>();
	static int length =0;
	static int friendsCnt =0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		friendsMap = new int[n+1][n+1];
		visit = new int[n+1];
		
		for(int i=0;i<m;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			friendsMap[a][b] = 1;
			friendsMap[b][a] = 1;
			
			if(a == 1) {
				q.add(b);
				visit[b] =1;
			}
		}
		
		getBfs();
		
		for(int i=1;i<n+1;i++) {
			if(visit[i] == 1) {
				friendsCnt++;
			}
		}
		System.out.println(friendsCnt);
	}

	public static void getBfs() {
		while(!q.isEmpty()) {
			int idx = q.poll();
			visit[idx] =1;
			
			for(int j=2;j<=n;j++) {
				if(friendsMap[idx][j] == 1 && visit[j] == 0) {
					visit[j] = 1;
				}
			}		
		}
	}
}
