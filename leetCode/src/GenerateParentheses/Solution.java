package GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		List<String> list = solution.generateParenthesis(3);
		System.out.println(list);
	}

	public List<String> generateParenthesis(int n)
	{
		List<String> list = new ArrayList<String>();
		core(n, n, 0, "", list);
		return list;
	}
	
	private void core(int left,int right,int sum,String str, List<String> list)
	{
		if(sum<0)
			return;
		if(sum==0&&left == 0 && right == 0)
		{
			list.add(str);
			return;
		}
		if(left>0)
			core(left-1, right, sum+1, str+"(", list);
		if(right>0)
			core(left, right-1, sum-1, str+")", list);
		
	}

}
