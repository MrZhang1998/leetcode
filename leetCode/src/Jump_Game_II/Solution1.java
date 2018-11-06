package Jump_Game_II;

public class Solution1
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Solution1 solution = new Solution1();
		int[] nums = new int[] {1,1,1,2,1};
		int jump = solution.jump(nums);
		System.out.println(jump);
	}
	
	public int jump(int[] nums)
	{
		if(nums.length <= 1)
			return 0;
		int cur = 0; // 遍历nums的索引
		int next_furthest = 0; // 下次最多能走到哪
		int cur_max = 0;  // 本次做多能走到哪里
		int jumps = 0;
		while(cur<=next_furthest)
		{
			next_furthest = cur_max;
			for(;cur<=cur_max;cur++)
			{
				next_furthest = Math.max(next_furthest, nums[cur]+cur);
				if(next_furthest>=nums.length-1)
					return jumps+1;
			}
			jumps++;
			cur_max = next_furthest;
		}
		return -1;
	}
}
