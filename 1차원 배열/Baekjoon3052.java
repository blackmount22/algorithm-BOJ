import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class BaekjoonAlgo_3052 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		List<Integer> li = new ArrayList<Integer>();
		
		for(int i=0;i<10;i++) {
			int n = sc.nextInt();
			
			int r = n % 42;
			li.add(r);
		}
		
		Set<Integer> set = new HashSet<Integer>(li);
		List<Integer> result = new ArrayList<Integer>(set);
		
		System.out.println(result.size());
		
	}

}
