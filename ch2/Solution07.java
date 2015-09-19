public class Solution07{
	static class Node {
		int value;
		Node next;
	}
	
	static Node buildLinkedList(Node[] nodes, int[] order) {
		Node previous = null;
		for(int index : order) {
			Node current = nodes[index];
			if(previous != null) {
				previous.next = current;
			}
			previous = current;
		}
		return nodes[order[0]];
	}
	
	static void print(Node node) {
		while(node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}
		System.out.println();
	}
	
	public static int[] intersect(Node l1, Node l2) {
		// We assume that the two list are not circular 
		Node iter= l1;
		Node list_end;
		while(iter.next!=null)
			iter=iter.next;
		list_end=iter;
		iter.next=l1;
		if(l2==null || l2.next==null)
			return null;
		Node fast=l2.next.next;
		Node slow=l2.next;
		while(fast!=null && slow!=null && fast.next!=null && fast!=slow){
			fast=fast.next.next;
			slow=slow.next;
		}
		if(fast== null|| fast.next==null || slow== null)
			return null;
		slow=l2;
		while(fast!=slow){
			fast=fast.next;
			slow=slow.next;
		}
		Node intersect_head=slow;
		int count=1;
		while(slow!=list_end){
			slow=slow.next;
			count++;
		}
		int [] result =new int[count];
		slow=intersect_head;
		count=0;
		while(slow!=list_end){
			result[count]=slow.value;
			slow=slow.next;
			count++;
		}
		result[count]=slow.value;
		return result;
	}
	
	public static void main(String[] args) {
		int size = 12;
		Node[] nodes = new Node[size];
		for(int i=0; i<size; i++) {
			nodes[i] = new Node();
			nodes[i].value = i;
		}
		
		int[] linkedList1 = {0, 1, 2, 3, 4, 5, 6, 7, 8};
		int[] linkedList2 = {9,10,11};//{9, 10, 3, 4, 5, 6, 7, 8, 11};
		
		Node l1 = buildLinkedList(nodes, linkedList1);
		Node l2 = buildLinkedList(nodes, linkedList2);
		
//		print(l1);
		
		int[] intersect = intersect(l1, l2);
		if(null == intersect)
			System.out.println("No intersection");
		else {
			for(int i=0; i<intersect.length; i++){
				System.out.print(intersect[i]+" ");
			}
		}
	}
}
