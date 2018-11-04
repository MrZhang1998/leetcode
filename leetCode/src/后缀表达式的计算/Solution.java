package 后缀表达式的计算;

import java.util.Stack;

public class Solution
{

	public static final int IS_NUM = 0;
	public static final int IS_OPERATION = 1;

	public int evalRPN(String[] tokens)
	{
		if (tokens.length == 1)
		{
			return Integer.valueOf(tokens[0]);
		}

		Stack<String> stack = new Stack<>();
		int result = 0;
		for (int i = 0; i < tokens.length; i++)
		{
			String toke = tokens[i];
			int symbol = judge(toke);
			if (symbol == IS_NUM)
			{
				stack.push(toke);
			} else
			{
				int num2 = Integer.valueOf(stack.pop());
				int num1 = Integer.valueOf(stack.pop());
				if (toke.equals("+"))
				{
					result = num1 + num2;
				} else if (toke.equals("-"))
				{
					result = num1 - num2;
				} else if (toke.equals("*"))
				{
					result = num1 * num2;
				} else
				{
					result = num1 / num2;
				}

				stack.push(String.valueOf(result));
			}
		}
		return result;
	}

	public int judge(String str)
	{
		if (str.startsWith("-") && str.length() > 1)
		{
			return IS_NUM;
		}
		char o_o = str.charAt(0);
		if (o_o >= '0' && o_o <= '9')
		{
			return IS_NUM;
		}
		return IS_OPERATION;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		String[] tokens = { "9", "3", "1", "-", "3", "*", "+", "10", "2", "/", "+" };
		Solution solution = new Solution();
		int result = solution.evalRPN(tokens);
		System.out.println(result);
	}

}
