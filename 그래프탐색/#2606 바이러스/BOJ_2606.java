import java.util.Scanner;

public class Main {

	static int cnt = 0;
	static int connection = 0;
	static int[][] map;
	static int[] visit;
	static int result = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		cnt = sc.nextInt();
		connection = sc.nextInt();
		
		map = new int[cnt+1][cnt+1];
		visit = new int[cnt+1];
		
		for(int i=0;i<connection;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			map[x][y] = 1;
			map[y][x] = 1;
		}
		
		GetDfs(1);
		
		System.out.println(result);
	}
	
	public static void GetDfs(int x){
		visit[x] = 1;
		
		for(int i=1;i<cnt+1;i++) {
			if(x != i && map[x][i] == 1 && visit[i] == 0) {
				GetDfs(i);
				result++;
			}
		}
	}

}
