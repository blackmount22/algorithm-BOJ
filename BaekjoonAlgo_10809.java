import java.util.Scanner;

public class BaekjoonAlgo_10809 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		String[] alpha = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
		
		for(int i=0;i<alpha.length;i++) {
			System.out.print(s.indexOf(alpha[i]) + " ");
		}
	}

}
