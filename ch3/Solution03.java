import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution03{
	//The setofstacks can achieve pop and push in O(1) time
	//About the follow-up problem, the meaning of to pop out number from stack of index i should be discussed. If it means that we want to pop out 
	//the numbers that are inputed after i*stack_size-1 number, then it means that whenever we pop a number from stack i, all the stacks after i shoud
	//change to make stack i full after the pop operation
	//And if we assume that we just want to pop out the number from the i th stack, then we might need to have a array storing the state of fullness
	//of each stack, since each stack might be empty because of the popAt() function
	static class SetOfStacks{
	    int stack_size;
		List<Stack<Integer>> stacks;
		int num_of_stack;
		public SetOfStacks(int c){
			stacks=new ArrayList<Stack<Integer>> ();
			num_of_stack=0;
			stack_size=c;
		}
		public void push(int x){
			if(num_of_stack==0){
				stacks.add(new Stack<Integer>());
				num_of_stack++;
			}
			if(stacks.get(num_of_stack-1).size()>=stack_size){
				stacks.add(new Stack<Integer>());
				num_of_stack++;
			}
			stacks.get(num_of_stack-1).push(x);
		}
		public int pop(){
			if(num_of_stack==0){
				System.out.println("The stack is already empty! The following value is a defualt value");
				return Integer.MIN_VALUE;
			}
			else{
				int result=stacks.get(num_of_stack-1).pop();
				if(stacks.get(num_of_stack-1).size()==0){
					stacks.remove(num_of_stack-1);
					num_of_stack--;
				}
				return result;
			}
		}
	}
	public static void main(String [] args){
		SetOfStacks test_stack= new SetOfStacks(1);
		int [] nums={1,3,5,7,9};
		test_stack.push(nums[0]);
		test_stack.push(nums[1]);
		test_stack.push(nums[2]);
		System.out.println("pop out from stack "+ test_stack.pop());
		System.out.println("pop out from stack "+ test_stack.pop());
		test_stack.push(nums[3]);
		System.out.println("pop out from stack "+ test_stack.pop());
		test_stack.push(nums[4]);
		System.out.println("pop out from stack "+ test_stack.pop());
		System.out.println("pop out from stack "+ test_stack.pop());
		System.out.println("pop out from stack "+ test_stack.pop());
	}
}
