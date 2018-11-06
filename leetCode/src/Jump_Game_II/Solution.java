package Jump_Game_II;

public class Solution
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		int[] nums = new int[] {3,0,0,4};
		int jump = solution.jump(nums);
		System.out.println(jump);
	}

	public int jump(int[] nums)
	{
		if(nums.length == 1)
			return 0;
		int min = Integer.MAX_VALUE;
		int[] result = new int[1];
		result[0] = min;
		backTrace(0, nums,  0, result);
		return result[0];
	}
	
	private void backTrace(int cur_pos,int[] nums,int jumps,int[] value)
	{
		if(cur_pos>=nums.length)
			return;
		if(cur_pos == nums.length-1)
		{
			if(jumps<value[0])
			{
				value[0] = jumps;
			}
			return;
		}
		for(int i = cur_pos+1;i<=cur_pos+nums[cur_pos];i++)
		{
			backTrace(i,nums,jumps+1,value);
		}
			
	}

}
