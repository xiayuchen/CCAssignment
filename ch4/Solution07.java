import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution07{
	public static List<Integer> visit_order(int n, List<List<Integer>> dependency){
	// in this function we assume that the node are represented by their index, input n means that there are n number, indexed as 0～n-1
	//And the dependency are List of List, each List is the pair of indexed node that are dependent, and pair (a,b) means that a should be visited after
	//b
	//We use topological sorting to solve the problem, the time complexity of it is O(n) n means the number of edges the dependency
		List<Integer> result=new ArrayList<Integer>();
		List<List<Integer>> dependent= new ArrayList<List<Integer>>();
		for(int i=0; i<n;i++)
			dependent.add(new ArrayList<Integer>());
		int [] degree= new int [n];
		for(int i=0;i<dependency.size(); i++){
			int before=dependency.get(i).get(1);
			int after=dependency.get(i).get(0);
			degree[after]++;
			dependent.get(before).add(after);
		}
		Queue<Integer> zero_degree=new LinkedList<Integer>();
		for(int i=0;i<n;i++){
			if(degree[i]==0)
				zero_degree.add(i);
		}
		while(!zero_degree.isEmpty()){
			int cur_node=zero_degree.poll();
			result.add(cur_node);
			List<Integer> con_cur=dependent.get(cur_node);
			for(int i=0;i<con_cur.size();i++){
				int tmp=con_cur.get(i);
				degree[tmp]--;
				if(degree[tmp]<=0)
					zero_degree.add(tmp);
			}
		}
		if(result.size()==n)
			return result;
		else
			return null;
	}
	public static void main(String [] args){
		List<List<Integer>> depend=new ArrayList<List<Integer>>();
		depend.add(new ArrayList<Integer>(Arrays.asList(3,0)));
		depend.add(new ArrayList<Integer>(Arrays.asList(1,5)));
		depend.add(new ArrayList<Integer>(Arrays.asList(3,1)));
		depend.add(new ArrayList<Integer>(Arrays.asList(0,5)));
		depend.add(new ArrayList<Integer>(Arrays.asList(2,3)));
		List<Integer> result=visit_order(6,depend);
		if(result==null)
			System.out.println("no such result!");
		else{
			for(int i=0;i<result.size();i++){
				System.out.print(result.get(i)+"\t");
			}
		}
	}
}
