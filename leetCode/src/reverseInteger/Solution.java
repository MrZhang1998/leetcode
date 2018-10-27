package reverseInteger;

public class Solution
{	
	public int reverse(int x) 
	{
       boolean isNegtive = false;
       if(x<0)
       {
    	   isNegtive = true;
       }
       x= Math.abs(x);
       long result = 0;
       while(x>0)
       {
    	   if(result*10>0x7fffffff)
    		   return 0;
    	   result = result*10+x%10;
    	   x/=10;
       }
       if(isNegtive)
    	   return (int) (0-result);
       return (int) result;
    }
	
	public static void main(String[] args)
	{
		Solution solution = new Solution();
		int result = solution.reverse(1534236469);
		System.out.println(result);
	}
}
