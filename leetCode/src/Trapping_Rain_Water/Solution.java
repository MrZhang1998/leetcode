package Trapping_Rain_Water;

import java.util.Stack;

public class Solution
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		int[] height = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int trap = solution.trap(height);
		System.out.println(trap);
	}

	public int trap(int[] height)
	{
		if (height.length < 3)
			return 0;
		Stack<Integer> stack = new Stack<Integer>();
		int water = 0;
		int i = 0;
		while (i < height.length)
		{
			if (stack.isEmpty() || height[i] <= height[stack.peek()])
			{
				stack.push(i++);
			} else
			{
				int h = stack.pop();
				if (!stack.isEmpty())
				{
					int min = Math.min(height[i], height[stack.peek()]);
					int trap = (min - height[h]) * (i - stack.peek() - 1);
					water += trap;
				}
			}
		}
		return water;
	}

}
