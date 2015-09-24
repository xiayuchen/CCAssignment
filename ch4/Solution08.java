import java.util.List;

public class Solution08{
	static class TreeNode{
		int value;
		TreeNode left,right;
		public TreeNode(int x){
			value=x;
		}
	}
	static boolean found1;
	static boolean found2;
	//We assume that the input of the function is the root node of the tree, and the two node are represented by the value of them
	//We use recursive approach, two boolean value found1 and found2 are used to store if each one of the two node are found
	//As the node found on the left sub tree should not interfere with the node found in the right subtree, every time when we start searching
	//at a node, the two value are set to false, and when we go back to the parent node, we need to combine the found1 and found2 of the left and right
	// sub tree to decide if the node should be returned 
	//This algorithm takes O(logn) time
	public static TreeNode lowest_ancestor(TreeNode root, int x, int y){
		found1=false;
		found2=false;
		if(root==null)
			return null;
		TreeNode tmp1=lowest_ancestor(root.left,x,y);
		boolean found1_l=found1;
		boolean found2_l=found2;
		TreeNode tmp2=lowest_ancestor(root.right,x,y);
		found1=found1||found1_l;
		found2=found2||found2_l;
		if(tmp1!=null)
			return tmp1;
		if(tmp2!=null)
			return tmp2;
		if(root.value==x)
			found1=true;
		if(root.value==y)
			found2=true;
		if(found1 && found2)
			return root;
		else
			return null;
	}
	public static void main(String [] args){
		TreeNode root = new TreeNode(6);
		TreeNode cur=root;
		cur.left=new TreeNode(4);
		cur.right=new TreeNode(8);
		cur=cur.left;
		cur.left=new TreeNode (1);
		cur.right=new TreeNode (5);
		cur=cur.left;
		cur.right=new TreeNode(3);
		cur=cur.right;
		cur.left=new TreeNode(2);
		cur=root.right;
		cur.right=new TreeNode(9);
		cur.left= new TreeNode (7);
		System.out.println("lowest_ancestore of node 2 and 3 "+lowest_ancestor(root,2,3).value);
		System.out.println("lowest_ancestore of node 1 and 9 "+lowest_ancestor(root,1,9).value);
		System.out.println("lowest_ancestore of node 3 and 5 "+lowest_ancestor(root,3,5).value);
	}
}
