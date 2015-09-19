public class Solution05{
	static class ListNode{
		public int val;
		public ListNode next;
		public ListNode(int value){
			val=value;
		}
	}
	public static ListNode adding_backward(ListNode head1, ListNode head2){
		//The code use constant space and O(n) time
		//This solution solve the problem in O(n) time complexity
		ListNode iter1=head1;
		ListNode iter2=head2;
		ListNode result=null;
		ListNode iter_r=result;
		int remain=0;
		while(iter1!=null || iter2!=null){
			int n1=(iter1!=null)?iter1.val:0;
			int n2=(iter2!=null)?iter2.val:0;
			int cur_n=(n1+n2+remain)%10;
			remain=(n1+n2+remain)/10;
			if(iter_r== null){
				result=new ListNode (cur_n);
				iter_r=result;
			}
			else{
				iter_r.next=new ListNode(cur_n);
				iter_r=iter_r.next;
			}
			iter1=(iter1!=null)?iter1.next:null;
			iter2=(iter2!=null)?iter2.next:null;
		}
		if(remain!=0)
			iter_r.next=new ListNode(remain);
		return result;
	}
	//If we want to achieve adding for linkedlist where integer are stored forward, we can create two stack storing the number stored in the two linkedlist,
	//And then we can create a new linkedlist, every time we pop out number from the stack and create a new listnode for the new linkedlist
	//And we should add the new listnode to the head of the linkedlist, rather than add to the end of the linkedlist for the adding_backward
	public static void main(String [] args){
		ListNode head1=new ListNode (1);
		ListNode head2= new ListNode (2);
		int [] nums1={4,9,9};
		int [] nums2={9,1};
		ListNode cur=head1;
		for(int i=0;i<nums1.length; i++){
			cur.next=new ListNode(nums1[i]);
			cur=cur.next;
		}
		cur=head2;
		for(int i=0;i<nums2.length; i++){
			cur.next=new ListNode(nums2[i]);
			cur=cur.next;
		}
		System.out.println("List 1 is");
		ListNode iter=head1;
		while(iter!=null){
			System.out.print(iter.val+"->");
			iter=iter.next;
		}
		System.out.print("null\n");
		System.out.println("List 2 is");
		iter=head2;
		while(iter!=null){
			System.out.print(iter.val+"->");
			iter=iter.next;
		}
		System.out.print("null\n");
		ListNode result=adding_backward(head1, head2);
		System.out.println("adding result is");
		iter=result;
		while(iter!=null){
			System.out.print(iter.val+"->");
			iter=iter.next;
		}
		System.out.print("null\n");
	}
}
