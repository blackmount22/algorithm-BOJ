import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Location{
	
	int x;
	int y;
	
	public Location(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}
}

public class BaekjoonAlgo_14499 {

	static int n;
	static int m;
	static int[][] board;
	static int[] dice = {0,0,0,0,0,0};
	static int k;
	static int[] move;
	static Queue<Location> q;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		board = new int[n][m];
		q = new LinkedList<>();
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		q.offer(new Location(x, y));
		
		k = sc.nextInt(); //명령어 개수
		
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				board[i][j] = sc.nextInt();
			}
		}
		
		move = new int[k];
		
		for(int i=0;i<k;i++){
			move[i] = sc.nextInt();
		}
		
		moveDice();
	}
	
	public static void moveDice(){
		
		int[] xx = {0,0,0,-1,1};
		int[] yy = {0,1,-1,0,0};
		
		for(int i=0;i<k;i++){
			
			int x = q.peek().x;
			int y = q.poll().y;
			
			int ax = x+xx[move[i]];
			int ay = y+yy[move[i]];
			
			
			if(ax>=0 && ay>=0 && ax<n && ay<m){
				rollDice(move[i]);
				if(board[ax][ay] == 0){
					board[ax][ay] = dice[5];
				}else{
					dice[5] = board[ax][ay];
					board[ax][ay] = 0;
				}
				q.offer(new Location(ax, ay));
			}else{
				q.offer(new Location(x, y));
				continue;
			}
			
			System.out.println(dice[0]);
		}
		
		
	}
	
	public static void rollDice(int dir){
		
		// 1 : 왼 // 2 : 우 // 3 : 위 // 4 : 아래
		
		int temp=0;
		
		if(dir == 2){
			temp = dice[0];
			dice[0] = dice[2];
			dice[2] = dice[5];
			dice[5] = dice[3];
			dice[3] = temp;
		}else if(dir == 1){
			temp = dice[0];
			dice[0] = dice[3];
			dice[3] = dice[5];
			dice[5] = dice[2];
			dice[2] = temp;
		}else if(dir == 3){
			temp = dice[0];
			dice[0] = dice[4];
			dice[4] = dice[5];
			dice[5] = dice[1];
			dice[1] = temp;
		}else if(dir == 4){
			temp = dice[0];
			dice[0] = dice[1];
			dice[1] = dice[5];
			dice[5] = dice[4];
			dice[4] = temp;
		}
	}

	
	
}
