import java.util.Scanner;

public class BOJ2566 {

	static int[][] map = new int[9][9];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int max = 0;
		int x = 1;
		int y = 1;
		
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				map[i][j] = sc.nextInt();
				
				if(map[i][j] > max) {
					max = map[i][j];
					x = i+1;
					y = j+1;
				}
			}
		}
		
		System.out.println(max);
		System.out.println(x + " " + y);
	}

}
