package 最长回文串;

public class Solution
{
	
	public String longestPalindrome(String s) 
	{
		if(s.length()==1)
			return s;
		int length = s.length();
		String result = "";
		String temp = "";
		for(int i = 0; i<length-1;i++)
		{
			temp = getSub(i, i,length,s);
			if(temp.length()>result.length())
				result = temp;
			
			// deal the double char like "abba";
			if(s.charAt(i)==s.charAt(i+1))
			{
				temp = getSub(i, i+1,length,s);
				if(temp.length()>result.length())
					result = temp;
			}
		}
		return result;
    }
	private String getSub(int first,int last,int length,String s)
	{
		while(first>=0&&last<length&&s.charAt(first)==s.charAt(last))
		{
			first--;
			last++;
		}
		first++;
		String temp = s.substring(first,last);
		return temp;
	}
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		String string = solution.longestPalindrome("cd");
		System.out.println(string);
	}

}
