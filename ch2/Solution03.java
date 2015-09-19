public class Solution03{
	static class ListNode{
		public int val;
		public ListNode next;
		public ListNode(int value){
			val=value;
		}
	}
	public static void remove_middle(ListNode head){
		// We use faster and slow pointer to find the middle node of list
		//It takes O(n) time and constant space
		ListNode slow=head;
		ListNode fast=head;
		ListNode prev=head;
		while(fast!=null && fast.next!=null){
			fast=fast.next.next;
			prev=slow;
			slow=slow.next;
		}
		if(slow!=null){
			prev.next=slow.next;
		}
		return;
	}
	public static void main(String [] args){
		ListNode head= new ListNode(1);
		int [] nums={2,3,4,5};
		ListNode iter=head;
		for(int i=0;i<nums.length;i++){
			iter.next=new ListNode(nums[i]);
			iter=iter.next;
		}
		System.out.println("List before removing middle node");
		iter=head;
		while(iter!=null){
			System.out.print(iter.val+"->");
			iter=iter.next;
		}
		System.out.print("null\n");
		remove_middle(head);
		iter=head;
		System.out.println("List after removing middle node");
		while(iter!=null){
			System.out.print(iter.val+"->");
			iter=iter.next;
		}
		System.out.print("null");
	}
}
