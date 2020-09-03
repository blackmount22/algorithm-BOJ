package baekjoonPjt;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class TomatoLocation {
	int x;
	int y;
	
	public TomatoLocation(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}
}

public class Baekjoon7576 {

	static int n;
	static int m;
	static int[][] map;
	static int[][] visit;
	static Queue<TomatoLocation> queue = new LinkedList<TomatoLocation>();
	static int days= -1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		visit = new int[n][m];
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				map[j][i] = sc.nextInt();
				
				if(map[j][i] == 1) {
					queue.offer(new TomatoLocation(j, i));
				}
			}
		}
		
		bfs();
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(map[j][i] == 0) {
					days = -1;
				}
			}
		}
		
		System.out.println(days);
	}
	
	public static void bfs() {
		
		int[] xx = {-1,0,1,0};
		int[] yy = {0,1,0,-1};
		
		while(!queue.isEmpty()) {		
			
			int size = queue.size();
			
			for(int i=0;i<size;i++) {
				int x = queue.peek().x;
				int y = queue.poll().y;
				
				for(int j=0;j<4;j++) {
					int ax = x+xx[j];
					int ay = y+yy[j];

					if(ax >=0 && ax< n && ay>=0 && ay<m && map[ax][ay] == 0 && visit[ax][ay] == 0) {
						map[ax][ay] = 1;
						visit[ax][ay] = 1;
						queue.offer(new TomatoLocation(ax, ay));
					}
				}
			}
			
			days++;
		}
	}
}
