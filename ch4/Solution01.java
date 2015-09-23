import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution01{
//In this solution we use BFS, time complexity of it is O(n)
	static class node{
		int index;
		public boolean added;
		public boolean visited;
		public List<node> connected;
		public node(int i){
			index=i;
			added=false;
			visited=false;
			connected=new ArrayList<node>();
		}
	}
	public static boolean connected(node n1, node n2){
		if(n1==n2)
			return true;
		Queue<node> to_visit=new LinkedList<node>();
		to_visit.add(n1);
		n1.added=true;
		while(!to_visit.isEmpty()){
			node cur=to_visit.poll();
			for(int i=0; i<cur.connected.size();i++){
				node new_node=cur.connected.get(i);
				if(new_node==n2)
					return true;
				if(new_node.added==false){
					to_visit.add(new_node);
				}
			}
			cur.visited=true;
		}
		return false;
	}
	public static void main(String [] args){
		node node1,node2,node3,node4,node5,node6;
		node1=new node(1);
		node2=new node(2);
		node3= new node(3);
		node4 = new node(4);
		node5 = new node(5);
		node6= new node(6);
		node1.connected.add(node2);
		node2.connected.add(node4);
		node2.connected.add(node5);
		node4.connected.add(node6);
		node3.connected.add(node6);
		System.out.println("if node1 and node 6 are connected? "+connected(node1,node6));
		System.out.println("if node1 and node 1 are connected? "+connected(node1,node1));
		System.out.println("if node1 and node 3 are connected? "+connected(node1,node3));
	}
}
