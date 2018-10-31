package LongestValidParentheses;

import java.util.Arrays;
import java.util.Stack;

public class Solution
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		int i = solution.longestValidParentheses("((");
		System.out.println(i);
	}

	public int longestValidParentheses(String s)
	{
		if (s == null || s.equals(""))
			return 0;
		boolean[] flags = new boolean[s.length()];
		Arrays.fill(flags, false);
		char[] chars = s.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < chars.length; i++)
		{
			char temp = chars[i];
			if (temp == '(')
			{
				stack.push(temp);
			} else
			{
				if (!stack.isEmpty())
				{
					stack.pop();
					int index = i;
					flags[index] = true;
					while (index >= 0 && flags[index] == true)
					{
						index--;
					}
					flags[index] = true;
				}
			}

		}
		int max = 0;
		int temp = 0; // 连续true的个数
		for (int i = 0; i < flags.length; i++)
		{
			if (flags[i] == true)
			{
				temp++;
			} else
			{
				if (temp > max)
				{
					max = temp;
				}
				temp = 0;
			}
		}
		return max > temp ? max : temp;
	}

}
