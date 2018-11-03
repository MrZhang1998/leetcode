package Combination_Sum_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
	}

	public List<List<Integer>> combinationSum2(int[] candidates, int target)
	{
		List<Integer> list = new ArrayList<Integer>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		backTrace(0, target, candidates, list, result);
		return result;
	}
	
	private void backTrace(int start, int target, int[]candidates,List<Integer> list,List<List<Integer>> result)
	{
		if(target< 0)
		{
			return;
		}
		if(target == 0)
		{
			result.add(new ArrayList<Integer>(list));
			return;
		}
		for(int i = start; i<candidates.length; i++)
		{
			if(i>0&& candidates[i] == candidates[i-1] && i!=start)
				continue;
			list.add(candidates[i]);
			backTrace(i+1, target-candidates[i], candidates, list, result);
			list.remove(list.size()-1);
		}
	}

}
