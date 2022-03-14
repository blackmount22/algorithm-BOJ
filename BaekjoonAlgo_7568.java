import java.util.ArrayList;
import java.util.Scanner;

class info7568{
	int w;
	int h;
	
	public info7568(int w, int h) {
		// TODO Auto-generated constructor stub
		this.w = w;
		this.h = h;
	}
}

public class BaekjoonAlgo_7568 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int n= sc.nextInt();
		ArrayList<info7568> ar = new ArrayList<>();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<n;i++) {
			int w = sc.nextInt();
			int h = sc.nextInt();
			
			ar.add(new info7568(w, h));
		}
		
		for(int i=0;i<ar.size();i++) {
			int w1 = ar.get(i).w;
			int h1 = ar.get(i).h;
			int rankNum = 1;
			
			for(int j=0;j<ar.size();j++) {
				int w2 = ar.get(j).w;
				int h2 = ar.get(j).h;
				
				if(w2 > w1 && h2 > h1) {
					rankNum++;
				}
			}
			
			sb.append(rankNum + "\n");
		}
		
		System.out.println(sb);
	}

}
