public class Solution02{
	static class ListNode{
		public int val;
		public ListNode next;
		public ListNode(int value){
			val=value;
		}
	}
	public static int k_to_last(ListNode head, int k){
		//This algorithm runs in constant space and O(n) time
		ListNode faster=head;
		ListNode slower=head;
		int count=0;
		while(count<k && faster!=null){
			faster=faster.next;
			count++;
		}
		if(faster==null && count!=k){
			System.out.println("List length is smaller than K!");
			return 0;
		}
		while(faster!=null){
			slower=slower.next;
			faster=faster.next;
		}
		return slower.val;
	}
	public static void main(String [] args){
		ListNode head= new ListNode(1);
		int [] nums={1,2,2,2,3,5,4,6,1,3};
		ListNode iter=head;
		for(int i=1;i<nums.length;i++){
			iter.next=new ListNode(nums[i]);
			iter=iter.next;
		}
		System.out.println("The whole list is");
		iter=head;
		while(iter!=null){
			System.out.print(iter.val+"->");
			iter=iter.next;
		}
		System.out.print("null\n");
		int k=3;
		int result=k_to_last(head,k);
		System.out.println("The k to the last element is "+result);
	}
}
