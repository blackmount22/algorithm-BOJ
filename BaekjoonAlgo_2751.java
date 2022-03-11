import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BaekjoonAlgo_2751 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		ArrayList<Integer> ar = new ArrayList<Integer>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<n;i++) {
			ar.add(sc.nextInt());
		}
		
		Collections.sort(ar);
		
		for(int i=0;i<n;i++) {
			sb.append(ar.get(i)).append("\n");
		}
		
		System.out.println(sb);
	}

}
