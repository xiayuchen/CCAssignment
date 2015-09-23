import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution03{
	static class TreeNode{
		//This solution takes O(n) time and O(n) space
		int value;
		public TreeNode left, right;
		public TreeNode (int val){
			value=val;
		}
	}
	public static List<LinkedList<TreeNode>> depth_list(TreeNode root){
		List<LinkedList<TreeNode>> result= new ArrayList<LinkedList<TreeNode>>();
		int cur_dep=0;
		if(root==null)
			return result;
		Queue<TreeNode> store= new LinkedList<TreeNode> ();
		store.add(root);
		while(!store.isEmpty()){
			int size=store.size();
			result.add(new LinkedList<TreeNode>());
			for(int i=0; i<size;i++){
				TreeNode cur=store.poll();
				if(cur!=null){
					result.get(cur_dep).add(cur);
					store.add(cur.left);
					store.add(cur.right);
				}
			}
			cur_dep++;
		}
		return result;
	}
	public static void main(String [] args){
		TreeNode root=new TreeNode(1);
		TreeNode cur=root;
		cur.left= new TreeNode(2);
		cur.right = new TreeNode (3);
		cur=cur.left;
		cur.left = new TreeNode(4);
		cur=root.right;
		cur.left= new TreeNode(5);
		cur.right= new TreeNode(6);
		List<LinkedList<TreeNode>> result= depth_list(root);
		for(int i=0; i<result.size();i++){
			LinkedList<TreeNode> cur_list= result.get(i);
			for(int j=0; j<cur_list.size();j++){
				System.out.print(cur_list.get(j).value+" ");	
			}
			System.out.print('\n');
		}
	}
}
