import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Location2589{
	
	int x;
	int y;
	int tc;
	
	public Location2589(int x, int y, int tc) {
		this.x = x;
		this.y = y;
		this.tc =tc;
	}
}

public class BaekjoonAlgo_2589 {

	static int n;
	static int m;
	static char[][] map;
	static int[][] visit;
	static int time;
	static Queue<Location2589> loc;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		n= sc.nextInt();
		m= sc.nextInt();
		map = new char[n][m];
		loc = new LinkedList<>();
		
		int maxTime = 0;
		
		for(int i =0;i<n;i++) {
			String str = sc.next();
			for(int j=0;j<m;j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j] == 'L') {
					visit = new int[n][m];
					loc.offer(new Location2589(i, j, 0));
					visit[i][j] = 1;
					int val = GetBFS();
					if(val > maxTime) {
						maxTime = val;
					}
					
					//System.out.println("(" + i + "," + j + ") : " + time);
				}
			}
		}
		
		System.out.println(maxTime);
	}
	
	public static int GetBFS() {
		int[] xx = {-1, 0, 1, 0};
		int[] yy = {0, 1, 0, -1};
		int tc = 0;
		
		while(!loc.isEmpty()) {
			for(int i=0;i<loc.size();i++) {
				int x = loc.peek().x;
				int y = loc.peek().y;
				tc = loc.poll().tc;
				
				for(int j=0;j<4;j++) {
					int ax = x + xx[j];
					int ay = y + yy[j];
					
					if(ax>=0 && ay>=0 && ax<n && ay<m && map[ax][ay] == 'L' && visit[ax][ay] == 0) {
						loc.offer(new Location2589(ax, ay, tc+1));
						visit[ax][ay] = 1;
					}
				}
			}
		}
		
		return tc;
	}

}
