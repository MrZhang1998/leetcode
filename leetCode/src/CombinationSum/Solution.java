package CombinationSum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		int [] candidates = new int[] {2,3,6,7};
		int target = 7;
		
		List<List<Integer>> combinationSum = solution.combinationSum(candidates, target);
		System.out.println(combinationSum);
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target)
	{
		List<Integer> list = new ArrayList<Integer>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		backTrace(candidates, target, list, result);
		return result;
	}
	// distinct
	private boolean contains(List<List<Integer>> result , List<Integer> list)
	{
		for(List<Integer> tempIntegers : result)
		{
			if(tempIntegers.size()!=list.size())
				continue;
			boolean r = true;
			for(int i = 0; i<tempIntegers.size();i++)
			{
				if(tempIntegers.get(i)!=list.get(i))
				{
					r = false;
					break;
				}
			}
			if(r)
				return true;
		}
		return false;
	}
	// the backTrace method
	private void backTrace(int[] candiadates, int target , List<Integer> list , List<List<Integer>> result)
	{
		if(target< 0)
			return;
		if(target == 0)
		{
			List<Integer> copy = new ArrayList<Integer>(list);
			Collections.sort(copy);
			if(!contains(result, copy))
				result.add(copy);
			return;
		}
		// try all case from index 0 to index length of candidates -1;
		for(int i = 0;i < candiadates.length ;i++)
		{
			list.add(candiadates[i]);
			backTrace( candiadates, target-candiadates[i], list, result);
			list.remove(list.size()-1);
		}
			
	}
}
