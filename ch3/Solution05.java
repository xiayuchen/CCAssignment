import java.util.Stack;

public class Solution05{
	public static Stack<Integer> sort_stack(Stack<Integer> input){
		//In this solution, we assume the input is a unsorted stack, and we return a stack where the number in it is all sorted
		//Every time we pop out the number from input, and pop out the number on the top of the stack result and add to input, when the peek of result
		//is smaller than the number from input
		//The solution will take O(n^2) time complexity
		Stack<Integer> result=new Stack<Integer>();
		while(!input.isEmpty()){
			int top=input.pop();
			if(result.isEmpty())
				result.push(top);
			else{
				if(top<result.peek()){
					result.push(top);
				}
				else{
					while(!result.isEmpty() && result.peek()<top){
						input.push(result.pop());
					}
					result.push(top);
				}
			}
		}
		return result;
	}
	public static void main(String [] args){	
		Stack<Integer> input= new Stack<Integer> ();
		int [] nums= new int[]{1,5,12,8,9,3,6};
		for (int i=0;i<nums.length;i++){
			input.push(nums[i]);
		}
		Stack<Integer> result=sort_stack(input);
		System.out.println("The sorting reuslt is:");
		while(!result.isEmpty()){
			System.out.print(result.pop()+"\t");
		}
	}
}
