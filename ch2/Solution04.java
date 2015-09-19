public class Solution04{
	static class ListNode{
		public int val;
		public ListNode next;
		public ListNode(int value){
			val=value;
		}
	}
	public static ListNode partition(ListNode head, int target){
	// We create two linkedlist, one contains the nodes that are smaller than target, one contains the nodes bigger than target
	// and then we combine the two together
	//It takes no extra space and takes O(n) time
		ListNode head_smaller=null;
		ListNode head_bigger=null;
		ListNode cur_smaller=null;
		ListNode cur_bigger=null;
		ListNode iter=head;
		while(iter!=null){
			ListNode tmp=iter.next;
			if(iter.val<target){
				if(head_smaller==null){
					head_smaller=iter;
					cur_smaller=iter;
				}
				else{
					cur_smaller.next=iter;
					cur_smaller=cur_smaller.next;
				}
			}
			else if(iter.val>target){
				if(head_bigger==null){
					head_bigger=iter;
					cur_bigger=iter;
				}
				else{
					cur_bigger.next=iter;
					cur_bigger=cur_bigger.next;
				}
			}
			else{
				iter.next=head_bigger;
				head_bigger=iter;
				if(cur_bigger==null)
					cur_bigger=head_bigger;
			}
			iter=tmp;
		}
		if(cur_bigger!=null)
			cur_bigger.next=null;
		if(cur_smaller!=null)
			cur_smaller.next=null;
		if(head_smaller==null)
			return head_bigger;
		else{
			cur_smaller.next=head_bigger;
		}
		return head_smaller; 
	}
	public static void main(String [] args){
		ListNode head= new ListNode(5);
		int [] nums={4,3,2,1};
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
		int value=3;
		ListNode result = partition(head ,value);
		iter=result;
		System.out.println("List after removing middle node");
		while(iter!=null){
			System.out.print(iter.val+"->");
			iter=iter.next;
		}
		System.out.print("null");
	}
}
