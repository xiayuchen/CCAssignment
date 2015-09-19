import java.util.HashSet;

public class Solution01{
	static class ListNode{
		public int val;
		public ListNode next;
		public ListNode(int value){
			val=value;
		}
	}
	public static void remove_dul(ListNode head){
		//To use a hashmap, we can implement the algorithm in O(n) time,
		// If we do not want to use extra space, we can visit each node and compare it with value of all the node after it, this will take O(n^2)time
		HashSet<Integer> value_set= new HashSet<Integer>();
		ListNode iter=head;
		ListNode prev=head;
		value_set.add(iter.val);
		iter=iter.next;
		while(iter!=null){
			if(!value_set.contains(iter.val)){
				prev.next=iter;
				prev=prev.next;
				value_set.add(iter.val);
			}
			iter=iter.next;
		}
		prev.next=null;
		return;
	}
	public static void main(String [] args){
		ListNode head= new ListNode(1);
		int [] nums={1,2,2,2,3,5,4,6,1,3};
		ListNode iter=head;
		for(int i=1;i<nums.length;i++){
			iter.next=new ListNode(nums[i]);
			iter=iter.next;
		}
		System.out.println("List before removing dulplicate");
		iter=head;
		while(iter!=null){
			System.out.print(iter.val+"->");
			iter=iter.next;
		}
		System.out.print("null\n");
		remove_dul(head);
		iter=head;
		System.out.println("List after removing dulplicate");
		while(iter!=null){
			System.out.print(iter.val+"->");
			iter=iter.next;
		}
		System.out.print("null");
	}
}
