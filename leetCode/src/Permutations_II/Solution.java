package Permutations_II;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		int[]nums = new int[] {1,1,2};
		List<List<Integer>> permute = solution.permuteUnique(nums);
		System.out.println(permute);
	}

	public List<List<Integer>> permuteUnique(int[] nums)
	{
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> temp = new ArrayList<Integer>();
		if(nums.length == 0)
			return result;
		boolean[] isVisited = new boolean[nums.length];
		Arrays.fill(isVisited, false);
		Arrays.sort(nums);
		backTrace(nums, isVisited, 0, temp, result);
		return result;
	}
	
	private void backTrace(int[] nums, boolean[] isVisited ,int index ,List<Integer> temp ,List<List<Integer>>result)
	{
		if(index == nums.length)
		{
			result.add(new ArrayList<Integer>(temp));
			return;
		}
		for(int i = 0; i<nums.length;i++)
		{
			if(isVisited[i]== false)
			{
				isVisited[i] = true;
				temp.add(nums[i]);
				System.out.println(nums[i]);
				backTrace(nums, isVisited, index+1, temp, result);
				isVisited[i] = false;
				temp.remove(temp.size()-1);
				while(i+1<nums.length && nums[i+1] == nums[i])
				{
					i++;
				}
			}
		}
	}

}
