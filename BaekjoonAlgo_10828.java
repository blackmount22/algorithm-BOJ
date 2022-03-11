import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class BaekjoonAlgo_10828 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			String command = sc.next();
			
			if(command.equals("push")) {
				int value = sc.nextInt();
				stack.push(value);
			} else if(command.equals("pop")){
				if(stack.empty()) {
					sb.append(-1 +"\n");
				} else {
					sb.append(stack.pop()+"\n");
				}
			} else if(command.equals("size")) {
				sb.append(stack.size()+"\n");
			} else if(command.equals("empty")) {
				if(stack.empty()) {
					sb.append(1 +"\n");
				} else {
					sb.append(0 +"\n");
				}
			} else if(command.equals("top")) {
				if(stack.empty()) {
					sb.append(-1 +"\n");
				} else {
					sb.append(stack.peek()+"\n");
				}
			}
		}
		
		System.out.println(sb);
	}

}
