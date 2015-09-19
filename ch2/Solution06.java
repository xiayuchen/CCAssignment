public class Solution06{
	static class ListNode{
		public int val;
		public ListNode next;
		public ListNode(int value){
			val=value;
		}
	}
	public static boolean is_palindrome(ListNode head){
		//To use a stack to store the values of the listnode is an easy way to solve the problem, but here I used the recursive approach that 
		// do not use extra data structure, every time we check the first and last element of the linkedlist, and then remove the head and last element from the list
		// and use the function with it
		//The time complexity of this algorithm is O(n^2), and use constant space
		if(head==null || head.next==null)
			return true;
		int head_value=head.val;
		ListNode prev=head;
		ListNode iter=head;
		while(iter.next!=null){
			prev=iter;
			iter=iter.next;
		}
		if(iter.val!=head_value)
			return false;
		else{
			prev.next=null;
			return is_palindrome(head.next);
		}
	}
	public static void main(String [] args){
		ListNode head= new ListNode(5);
		int [] nums={4,3,1,1,4,4,5};
		ListNode iter=head;
		for(int i=0;i<nums.length;i++){
			iter.next=new ListNode(nums[i]);
			iter=iter.next;
		}
		System.out.println("The List is ");
		iter=head;
		while(iter!=null){
			System.out.print(iter.val+"->");
			iter=iter.next;
		}
		System.out.print("null\n");
		boolean result = is_palindrome(head );
		System.out.println("Is the list palindrome? "+result);
		head= new ListNode(5);
		nums[4]=3;
		iter=head;
		for(int i=0;i<nums.length;i++){
			iter.next=new ListNode(nums[i]);
			iter=iter.next;
		}
		System.out.println("The List is ");
		iter=head;
		while(iter!=null){
			System.out.print(iter.val+"->");
			iter=iter.next;
		}
		System.out.print("null\n");
		result = is_palindrome(head );
		System.out.println("Is the list palindrome? "+result);
	}
}
