import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaekjoonAlgo_2941 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		int count = 0;
		
		String[] croAlpha = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		for(int i=0;i<croAlpha.length;i++) {	
			
			Pattern p = Pattern.compile(croAlpha[i]);
			Matcher m = p.matcher(str);
			
			for (int j = 0; m.find(j); j = m.end()) {
			    count++;
			    str = str.replaceAll(croAlpha[i], " ");
			}
		}
		
		str = str.replaceAll(" ", "");
		char[] arr = str.toCharArray();
		
		for(int i=0;i<arr.length;i++) {
			count++;
		}
		
		System.out.println(count);
	}
}
