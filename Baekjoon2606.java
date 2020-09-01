package baekjoonPjt;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon2606 {

	static int pc;
	static int network;
	static int[][] map;
	static int[] visit;
	static int cnt =0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		pc = 0 ;
		network = 0;
		
		pc = sc.nextInt();
		network = sc.nextInt();
		map = new int[pc+1][pc+1];
		visit = new int[pc+1];
		
		for(int i=0;i<network;i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			map[n][m] = 1;
			map[m][n] = 1;
		}		
		
		virusMove();
		System.out.println(cnt-1); // 1번 컴퓨터를 제외 한 수
		
	}
	
	public static void virusMove() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		
		while(!queue.isEmpty()) {
			int startPc = queue.poll();
			
			for(int i=1;i<=pc;i++) {
				if(map[startPc][i] == 1 && visit[i] != 1) {
					// 방문하지 않은 연결된 PC 시작점 Queue에 추가
					queue.add(i);
					visit[i] = 1;
					cnt++;
				}
			}
		}
	}
}
