import java.util.Stack;

public class Solution02{
	static class minStack{
		//We store the inputed number by the value of the number substitute the minimun number, when the value is smaller than 0, we update the min value
		//This code will implement the min stack in O(1) time
		public Stack<Integer> data;
		public Integer cur_min;
		public minStack(){
			data= new Stack<Integer> ();
			cur_min=0;
		}
		public void push(int x){
			if(data.isEmpty()){
				cur_min=x;
				data.push(0);
			}
			else{
				int tmp=x-cur_min;
				data.push(tmp);
				if(tmp<0)
					cur_min=x;
			}
		}
		public int pop(){
			if(data.isEmpty()){
				System.out.println("The stack is already empty!");
				return 0;
			}
			int topnum=data.pop();
			if(topnum<0){
				int tmp=cur_min;
				cur_min=cur_min-topnum;
				return tmp;
			}
			else{
				return topnum+cur_min;
			}
		}
		public int min(){
			return cur_min;
		}
	}
	public static void main(String [] args){
		minStack test_stack= new minStack();
		int [] nums= {10,9,11,17,15,7,4};
		System.out.println("Input data");
		for(int i=0;i<nums.length; i++){
			test_stack.push(nums[i]);
			System.out.print(nums[i]+" ");
		}
		System.out.print('\n');
		System.out.println("Current min value of the stack is "+ test_stack.min());
		for(int i=0;i<nums.length; i++){
			System.out.println("pop out number: "+test_stack.pop()+" current min value is: "+test_stack.min() );
		}
	}
}
