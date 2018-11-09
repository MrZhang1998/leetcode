package JumpGame;

public class Solution
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int[] nums = new int[] {2,5,0,0};
		Solution solution = new Solution();
		boolean canJump = solution.canJump(nums);
		System.out.println(canJump);
	}

	public boolean canJump(int[] nums)
	{
		if(nums.length==0)
			return false;
		if(nums.length==1)
			return true;
		int index = 0;
		int cur_furthest = 0;
		int next_furthest = 0;
		while(index<nums.length)
		{
			for(;index<=cur_furthest;index++)
			{
				next_furthest = Math.max(next_furthest, nums[index]+index);
				if(next_furthest>=nums.length-1)
					return true;
			}
			if(cur_furthest == next_furthest)
				break;
			cur_furthest = next_furthest;
		}
		return false;
	}

}
