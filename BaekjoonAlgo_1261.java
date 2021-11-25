import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Loc{
	
	int x;
	int y;
	int block;
	
	public Loc(int x, int y, int block) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.block = block;
	}
	
}

public class BaekjoonAlgo_1261 {

	static int m;
	static int n;
	static int[][] map;
	static int[][] visit;
	static int[][] dist; //좌표상 최단 거리
	static PriorityQueue<Loc> q;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		m = sc.nextInt(); // 가로의 크기
		n = sc.nextInt(); // 세로의 크기
		
		map = new int[n][m];
		visit = new int[n][m];
		dist = new int[n][m];
		q = new PriorityQueue<>(new Comparator<Loc>() {
			public int compare(Loc l1, Loc l2){
				return Integer.compare(l1.block, l2.block);
			}
		});
		
		for(int i=0;i<n;i++){
			String str = sc.next();
			for(int j=0;j<m;j++){
				map[i][j] = str.charAt(j)-'0';
				dist[i][j] = 99999999;
			}
		}
		
		dist[0][0] = 0;
		q.offer(new Loc(0, 0, 0));
		
		getDijkstra();
		System.out.println(dist[n-1][m-1]);
		
	}
	
	public static void getDijkstra(){
		
		int[] xx = {-1,0,1,0};
		int[] yy = {0,1,0,-1};
		
		while(!q.isEmpty()){
			
			int x = q.peek().x;
			int y = q.peek().y;
			int cnt = q.poll().block;
			
			for(int i=0;i<4;i++){
				
				int ax = x+xx[i];
				int ay = y+yy[i];
				
				if(ax>=0 && ay>=0 && ax<n && ay<m){
					if(dist[ax][ay] > cnt + map[ax][ay] && visit[ax][ay] == 0){
						dist[ax][ay] = cnt + map[ax][ay];
						q.offer(new Loc(ax, ay, dist[ax][ay]));
					}
					visit[ax][ay] = 1;
				}
			}
			
		}
	}
	
}
