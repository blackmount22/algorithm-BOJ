import java.util.Scanner;

public class BOJ1018 {

	static char[][] map;
	static int min = 64;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		map = new char[n][m];
		
		for(int i=0;i<n;i++) {
			String str = sc.next();
			
			for(int j=0;j<m;j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		int end_n = n-7;
		int end_m = m-7;
		
		for(int i=0;i<end_n;i++) {
			for(int j=0;j<end_m;j++) {
				findMin(i, j);
			}
		}
		
		System.out.println(min);
	}
	
	public static void findMin(int x, int y) {
		int end_x = x + 8;
		int end_y = y + 8;
		int count = 0;
		
		char cur = map[x][y];
		
		for(int i=x;i<end_x;i++) {
			for(int j=y;j<end_y;j++) {
				if(cur != map[i][j]) {
//					if(x== 1 && y == 15) {
//						System.out.println("map["+i+"]["+j+"] : " + map[i][j]);						
//					}
					count++;
				}
				
				if(cur == 'B') cur = 'W';
				else cur = 'B';
			}
			
			if(cur == 'B') cur = 'W';
			else cur = 'B';
		}
		
		
		//System.out.println(x + "," + y + ": " + count);
		count = Math.min(count, 64 - count);
		
		min = Math.min(count, min);
	}

}
