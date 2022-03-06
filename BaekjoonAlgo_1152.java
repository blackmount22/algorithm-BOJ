import java.util.Scanner;

public class BaekjoonAlgo_1152 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		String str= sc.nextLine();
		String[] arr =str.split(" ");
		
		int result = arr.length;
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i].equals("")) {
				result-=1;
			}
		}
		
		System.out.println(result);
	}

}
