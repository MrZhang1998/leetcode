package stringToInteger;

public class Solution
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		String str ="2147483648";
		System.out.println(solution.myAtoi(str));
		
	}
	
	public int myAtoi(String str) {
        str = str.trim();
        if("".equals(str))
        	return 0;
        if(str.charAt(0)!='-'&&str.charAt(0)!='+'&&(str.charAt(0)<'0'||str.charAt(0)>'9'))
        	return 0;
        
        boolean isNegative = isNegative(str);
        int index = str.length();
		for(int i = 1; i<str.length();i++)
		{
			if(str.charAt(i)<'0'|| str.charAt(i)>'9')
			{
				index = i;
				break;
			}
		}
		str = str.substring(0,index);
        if(str.startsWith("+")|| str.startsWith("-"))
        	str = str.substring(1,str.length());
        
        // if str is "+" or "-"
        if(str.equals(""))
        	return 0;
        // to deal with the the str like "++8"
        if(str.charAt(0)<'0'|| str.charAt(0)>'9')
        	return 0;
        long result = 0;
        for(int i = 0; i<str.length();i++)
        {
        	if(result<0x80000000)
        		return 0x80000000;
        	if(result>0x7fffffff)
        		return 0x7fffffff;
        	if(isNegative)
        		result = 10*result-(str.charAt(i)-'0');
        	else
        		result = 10*result+(str.charAt(i)-'0');
        }
        return (int) result;
    }
	
	private boolean isNegative(String str)
	{
		boolean negative = false;
		if(str.startsWith("+"))
			negative = false;
		if(str.charAt(0)>='0'&&str.charAt(0)<='9')
			negative = false;
		if(str.startsWith("-"))
			negative = true;
		
		return negative;
	}
	
}
