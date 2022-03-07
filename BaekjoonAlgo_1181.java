import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BaekjoonAlgo_1181 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		String[] arr = new String[testCase];
		String[] result = new String[testCase];
		
		for(int i=0;i<testCase;i++) {
			arr[i] = sc.next();
		}
		
		arr = Arrays.stream(arr).distinct().toArray(String[]::new); 
		Arrays.sort(arr);
		
		Arrays.sort(arr, new Comparator<String>() {
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}
		});
		
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);			
		}
	}

}
