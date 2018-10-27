package ValidParentheses;

import java.util.Stack;

public class Solution
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		System.out.println(solution.isValid("([{]})"));
	}

	public boolean isValid(String s)
	{
		Stack<Character> stack = new Stack<Character>();
		for(char c: s.toCharArray())
		{
			if(c =='(')
				stack.push(')');
			else if(c == '{')
				stack.push('}');
			else if(c == '[')
				stack.push(']');
			else if(stack.isEmpty()||stack.pop()!=c)
				return false;
		}
		return stack.isEmpty();
	}

}
