public class Solution01{
	static class ThreeStack{
		//In this solution, we assign constant space to store each stack, when instantiate a ThreeStack, a capacity of each stack is inputed
		//then a array of three times the size of the stack is created, an array of pointers will store the index of the top element
		//
		int [] pointer;
		int [] data;
		int stack_capacity;
		public ThreeStack(int cap){
			pointer=new int [3];
			stack_capacity=cap;
			data=new int [3*cap];
		}
		//for push, poll, peek, we input the stack num 0,1,2 to indicate the stack that we want to do the operation
		//And for push, we assume that the stack will not be full
		public void push(int stack_num, int value){
			data[stack_num*stack_capacity+pointer[stack_num]]=value;
			pointer[stack_num]++;
		}
		public int pop(int stack_num){
			if(pointer[stack_num]==0){
				System.out.println("The stack you want to visit is empty!");
				return Integer.MIN_VALUE;
			}
			else{
				pointer[stack_num]--;
				return data[stack_num*stack_capacity+pointer[stack_num]];
			}
		}
		public int peek(int stack_num){
			if(pointer[stack_num]==0){
				System.out.println("The stack you want to visit is empty!");
				return Integer.MIN_VALUE;
			}
			else{
				return data[stack_num*stack_capacity+pointer[stack_num]-1];
			}
		}
	}
	public static void main(String [] args){
		ThreeStack test= new ThreeStack(30);
		test.push(0, 1);
		test.push(0,2);
		test.push(0,3);
		test.push(1,4);
		test.push(1,5);
		test.push(1,6);
		System.out.println("pop from stack 0: the number is "+test.pop(0));
		System.out.println("pop from stack 1: the number is "+ test.pop(1));
		System.out.println("pop from stack 2: the number is "+ test.pop(2));
		test.push(2,7);
		System.out.println("peek from stack 2: the number is "+ test.peek(2));
	}
}
