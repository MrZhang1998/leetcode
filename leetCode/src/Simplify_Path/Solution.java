package Simplify_Path;

import java.util.Stack;

public class Solution
{
	public String simplifyPath(String path)
	{
		if(path == null || "".equals(path))
			return "";
		String[] paras = path.split("/");
		Stack<String> stack = new Stack<String>();
		for(String temp : paras)
		{
			if(temp.equals("")||temp.equals("."))
				continue;
			if(temp.equals(".."))
			{
				if(!stack.isEmpty())
					stack.pop();
			}
			else 
				stack.push(temp);
		}
		if(stack.isEmpty())
			return "/";
		String result = "";
		String[] array = stack.toArray(new String[0]);
		for(String temp : array)
			result = result + "/"+temp;
		return result;
	}

}
