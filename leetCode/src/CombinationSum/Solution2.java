package CombinationSum;

import java.util.ArrayList;
import java.util.List;

public class Solution2
{
	public List<List<Integer>> combinationSum(int[] candidates, int target)
	{
		List<Integer> list = new ArrayList<Integer>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		backTrace(0,candidates, target, list, result);
		return result;
	}
	
	// the backTrace method
		private void backTrace(int start,int[] candiadates, int target , List<Integer> list , List<List<Integer>> result)
		{
			if(target< 0)
				return;
			if(target == 0)
			{
				List<Integer> copy = new ArrayList<Integer>(list);
				result.add(copy);
				return;
			}
			
			for(int i = start;i < candiadates.length ;i++)
			{
				list.add(candiadates[i]);
				backTrace( i,candiadates, target-candiadates[i], list, result);
				list.remove(list.size()-1);
			}
				
		}
}
