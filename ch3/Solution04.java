import java.util.Stack;

public class Solution04{
	static class MyQueue{
		Stack<Integer> input;
		Stack<Integer> output;
		public MyQueue(){
			input= new Stack<Integer>();
			output = new Stack<Integer> ();
		}
		public void add(int x){
			input.push(x);
		}
		public int poll(){
			if(output.isEmpty()){
				while(!input.isEmpty()){
					output.push(input.pop());
				}
			}
			if(output.isEmpty()){
				System.out.println("The queue is empty");
				return Integer.MIN_VALUE;
			}
			return output.pop();
		}
		public int peek(){
			if(output.isEmpty()){
				while(!input.isEmpty()){
					output.push(input.pop());
				}
			}
			if(output.isEmpty()){
				System.out.println("The queue is empty");
				return Integer.MIN_VALUE;
			}
			return output.peek();
		}
		public boolean isEmpty(){
			return input.isEmpty()&&output.isEmpty();
		}
		public int size(){
			return input.size()+output.size();
		}
	}
	public static void main(String [] args){
		MyQueue test_queue= new MyQueue();
		test_queue.add(1);
		test_queue.add(2);
		System.out.println("My queue add 1, 2");
		System.out.println("Myqueue peek: "+test_queue.peek());
		System.out.println("Myqueue poll: "+test_queue.poll());
		System.out.println("Myqueue peek: "+test_queue.peek());
		test_queue.add(3);
		test_queue.add(4);
		System.out.println("My queue add 3, 4");
		System.out.println("Myqueue poll: "+test_queue.poll());
		System.out.println("Myqueue poll: "+test_queue.poll());
		System.out.println("Myqueue poll: "+test_queue.poll());
	}
}
