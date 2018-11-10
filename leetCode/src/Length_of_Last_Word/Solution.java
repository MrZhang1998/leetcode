package Length_of_Last_Word;

import java.util.Stack;

public class Solution
{
	public int lengthOfLastWord(String s)
	{
		if (s == null || s.equals(""))
			return 0;
		Stack<Integer> stack = new Stack<Integer>();
		char[] chars = s.toCharArray();
		int length = 0;
		for (int i = 0; i < chars.length; i++)
		{
			if (chars[i] == ' ')
			{
				if(length!=0)
					stack.push(length);
				length = 0;
			} else
			{
				length++;
			}
		}
		if(length!=0)
			stack.push(length);
		
		return stack.isEmpty()?0:stack.pop();
	}
}
