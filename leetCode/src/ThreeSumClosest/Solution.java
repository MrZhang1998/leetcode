package ThreeSumClosest;

public class Solution
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

	public int threeSumClosest(int[] nums, int target)
	{
		int min = nums[0]+nums[1]+nums[2];
		int divide = Math.abs(min-target);
		for(int i = 0; i<nums.length-2;i++)
		{
			for(int j = i+1;j<nums.length-1;j++)
			{
				for(int k = j+1;k<nums.length;k++)
				{
					if(divide>Math.abs(nums[i]+nums[j]+nums[k]-target))
						min = nums[i]+nums[j]+nums[k];
					if(target == nums[i]+nums[j]+nums[k])
						return target;
				}
			}
		}
		return min;
	}

}
