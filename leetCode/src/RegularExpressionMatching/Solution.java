package RegularExpressionMatching;


public class Solution
{
	public static void main(String[] args)
	{
		Solution solution = new Solution();
		boolean result = solution.isMatch("", "c*c*");
		System.out.println(result);
	}

	public boolean isMatch(String s, String p)
	{
		
		if(p.equals("")&&s.equals(""))
			return true;
		else
			return matchCore(s, p, 0, 0);
			
	}

	private boolean matchCore(String s, String p, int index_s, int index_p)
	{
		
		if (index_p == p.length() && index_s != s.length())
			return false;
		
		if(index_p == p.length())
			return true;
		
		if(index_p+1<p.length()&&p.charAt(index_p+1)=='*')
		{
			if(matchChar(index_s,index_p,s,p))
				return matchCore(s, p, index_s+1, index_p)||
						matchCore(s, p, index_s, index_p+2);
			
			return matchCore(s, p, index_s, index_p+2);
			
		}
		else  
		{
			if(matchChar(index_s,index_p,s,p))
				return matchCore(s, p, index_s+1, index_p+1);
			else
				return false;
		}
	}
	
	private boolean matchChar(int index_s , int index_p,String s, String p )
	{
		if(index_s == s.length())
		{
			return true;
		}
		if(index_s>s.length())
			return false;
		if(s.charAt(index_s) == p.charAt(index_p)||p.charAt(index_p)=='.')
			return true;
		else
			return false;
	}
}
