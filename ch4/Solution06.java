public class Solution06{
//When a node has right subtree, the successor is its leftmost node in its right subtree, else we shoud iterate through the
//parent of the current node untill the node is not the right children of the ancestor
//The code runs in O(logn) time, where n is the number of nodes in the tree
	static class TreeNode{
		int value;
		TreeNode left,right;
		TreeNode parent;
		public TreeNode(int x, TreeNode p){
			value=x;
			parent=p;
		}
		public TreeNode(TreeNode t){
			value=t.value;
			parent=t.parent;
			left=t.left;
			right=t.right;
		}
	}
	public static TreeNode successor(TreeNode cur){ 
		if(cur.right!=null){
			cur=cur.right;
			while(cur.left!=null)
				cur=cur.left;
			return cur;
		}
		else{
			while(cur.parent!=null && cur==cur.parent.right)
				cur=cur.parent;
			return cur.parent;
		}
	}
	public static void main(String [] args){
		TreeNode root = new TreeNode(6,null);
		TreeNode cur=root;
		cur.left=new TreeNode(4,cur);
		cur.right=new TreeNode(8,cur);
		cur=cur.left;
		cur.left=new TreeNode (1,cur);
		cur.right=new TreeNode (5,cur);
		cur=cur.left;
		TreeNode first=cur;
		cur.right=new TreeNode(3,cur);
		cur=cur.right;
		cur.left=new TreeNode(2,cur);
		cur=root.right;
		cur.right=new TreeNode(9,cur);
		cur.left= new TreeNode (7,cur);
		while(first!=null){
			System.out.print(first.value);
			first=successor(first);
		}
		return;
	}
	
	
}
