import java.util.ArrayList;
import java.util.List;


public class Solution12{
	//In this solution, for each node in the tree, we calculate the sum of all the path that ended at it, when the sum is equal to our target
	//the result will increase by 1
	//So this solution runs in O(nlogn), and the space complexity of it is O(logn)
	static class TreeNode{
		int value;
		TreeNode left,right;
		public TreeNode(int x){
			value=x;
		}
	}
	static int result=0;
	public static void path(TreeNode root,List<Integer> path, int target){
		if(root==null)
			return;
		path.add(root.value);
		int s=0;
		for(int i=path.size()-1;i>=0;i--){
			s=s+path.get(i);
			if(s==target)
				result++;
		}
		path(root.left, new ArrayList<Integer>(path),target);
		path(root.right,new ArrayList<Integer>(path), target);
			
	}
	public static int path_num(TreeNode root, int target){
		result=0;
		path(root,new ArrayList<Integer>(), target);
		return result;
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
		System.out.println("number of path for sum 9 "+ path_num(root,9));
	}
}
