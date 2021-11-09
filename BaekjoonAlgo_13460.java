import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point{
	int rx;
	int ry;
	int bx;
	int by;
	int count;
	
	Point(int rx, int ry, int bx, int by, int count) {
		// TODO Auto-generated method stub
		this.rx = rx;
		this.ry = ry;
		this.bx = bx;
		this.by = by;
		this.count = count;	
	}
}

public class BaekjoonAlgo_13460 {

	static int n;
	static int m;
	static char[][] map;
	
	static int[] xx = {-1,0,1,0};
	static int[] yy = {0,1,0,-1};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
	
		n = sc.nextInt();
		m = sc.nextInt();
		map = new char[n][m];
		
		int redX =0;
		int redY =0;
		int blueX=0;
		int blueY=0;
		
		for(int i=0;i<n;i++) {
			String str = sc.next();
			
			for(int j=0;j<m;j++) {
				map[i][j] = str.charAt(j);
				
				if(map[i][j] == 'R') {
					redX = i;
					redY = j;
					
				} else if(map[i][j] == 'B') {
					blueX = i;
					blueY = j;
				}
			}
		}
		
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(redX, redY, blueX, blueY, 0));
		
		while(!q.isEmpty()) {
			
			Point p = q.poll();
			if(p.count == 10) break;
			
//			System.out.println(p.rx);
//			System.out.println(p.ry);
			System.out.println(p.bx);
			System.out.println(p.by);
			
			for(int i =0;i<4;i++) {
				int nrx = p.rx;
				int nry = p.ry;
				int nbx = p.bx;
				int nby = p.by;
			
				//System.out.println(nry + yy[i]);
				//System.out.println(nbx + "," + nby);
				
				while(map[nrx + xx[i]][nry + yy[i]] != '#') {
					nrx = nrx + xx[i];
					nry = nry + yy[i];
					
					if(map[nry][nrx] == '0') {
						break;
					}
				}

//				System.out.println(nby);
//				System.out.println(yy[i]);

				while(map[nbx + xx[i]][nby + yy[i]] != '#') {
					if(nbx == 1 && nby == 6) {
						System.out.println("????");
					}
					
					nbx = nbx + xx[i];
					nby = nby + yy[i];
					
					System.out.println("gg");
					
					if(map[nbx][nby] == '0') {
						break;
					}
				}
				
				// 파란 구슬 탈출 > 실패
				if(map[nbx][nby] == '0') {
					continue;
				}
				
				// 빨간 구슬 탈출 > 성공
				if(map[nrx][nry] == '0') {
					System.out.println(p.count+1);
					return;
				}
				
				// 겹치는 경우 처리 (0:왼쪽, 1:위, 2:오른쪽, 3:아래)
				if(nrx == nbx && nry == nby) {
					System.out.println("dd");
					// 왼쪽
					if(i==0) {
						if(p.rx > p.bx) {
							nrx++;
						} else {
							nbx++;
						}
					} else if(i==1) {
						if(p.ry > p.by) {
							nry++;
						} else {
							nby++;
						}
					} else if(i==2) {
						if(p.rx > p.bx) {
							nrx--;
						} else {
							nbx--;
						}
					} else if(i==3) {
						if(p.ry > p.by) {
							nry--;
						} else {
							nby--;
						}
					}
				}
			
				System.out.println("==========================");
				System.out.println("nrx:"+nrx);
				System.out.println("nry:"+nry);
				System.out.println("nbx:"+nbx);
				System.out.println("nby:"+nby);
				System.out.println("offer");

				q.offer(new Point(nrx, nry, nbx, nby, p.count+1));
			}
		}
		
		System.out.println(-1);
	}

}
