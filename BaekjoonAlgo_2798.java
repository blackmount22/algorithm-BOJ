import java.util.Scanner;

public class BaekjoonAlgo_2798 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] nums = new int[n];
		int result = 0;
		
		for(int i=0;i<n;i++) {
			nums[i] = sc.nextInt();
		}
		
		for(int i=0;i<n;i++) {
			
			for(int j=0;j<n;j++) {
				for(int k=0;k<n;k++) {
					if(i == j || i == k || j == k) continue;
					
					if(nums[i] + nums[j] + nums[k] <= m  && nums[i] + nums[j] + nums[k] > result) {
						result = nums[i] + nums[j] + nums[k];
					}
				}
			}
		}
		
		System.out.println(result);
		
	}

}
