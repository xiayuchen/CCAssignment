public class Solution08{
	static class ListNode{
		public int val;
		public ListNode next;
		public ListNode(int value){
			val=value;
		}
	}
	public static ListNode start_loop(ListNode head){
	// This algorithm also uses fast and slow pointer, and the time complexity of it is O(n)
		if(head==null || head.next==null)
			return null;
		ListNode faster=head.next.next;
		ListNode slower=head.next;
		while(faster!=null && slower!=null && faster!=slower){
			faster=faster.next.next;
			slower=slower.next;
		}
		if(faster==null || slower==null)
			return null;
		slower=head;
		while(slower!=faster){
			slower=slower.next;
			faster=faster.next;
		}
		return slower;
	}
	public static void main(String [] args){
		ListNode [] list =new ListNode [7];
		list[0]=new ListNode(0);
		for(int i=1;i<7;i++){
			list[i]=new ListNode(i);
			list[i-1].next=list[i];
		}
		list[6].next=list[3];
		ListNode result=start_loop(list[0]);
		System.out.println("The starting point of the circular list is "+result.val);
	}
}
