import java.util.Scanner;

class Chon{
	int x;
	
	public Chon(int x) {
		this.x = x;
	}
}

public class BaekjoonAlgo_2644 {

	static int pCnt = 0;
	static int[] visit;
	static int[][] map;
	static int start;
	static int end;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		pCnt = sc.nextInt();
		
		map = new int[pCnt+1][pCnt+1];
		visit = new int[pCnt+1];
		
		start = sc.nextInt();
		end = sc.nextInt();
		int con = sc.nextInt();
		
		for(int i=0;i<con;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			map[x][y] = 1;
			map[y][x] = 1;
		}
		
		getDFS(start, end, 0);
		System.out.println(-1);
	}
	
	public static void getDFS(int x, int y, int chon){
		if(x == end) {
			System.out.println(chon);
			System.exit(0);
		}
		
		visit[x] = 1;
		
		for(int i=1;i<=pCnt;i++) {
			if(map[x][i] == 1 && visit[i] == 0) {
				//System.out.println("i : " +i + ", visit[i]: " +visit[i]);
				getDFS(i, y, chon+1);
			}
		}
	}

}
