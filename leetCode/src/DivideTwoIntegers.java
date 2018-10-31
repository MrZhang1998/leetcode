
public class DivideTwoIntegers
{
	public int divide(int dividend, int divisor)
	{
		boolean flag_dividend = false;
		boolean flag_divisor = false;
		long dividend_long = dividend;
		long divisor_long = divisor;
		dividend_long = Math.abs(dividend_long);
		divisor_long = Math.abs(divisor_long);
		long result = 0;
		while(dividend_long>divisor_long)
		{
			result++;
			dividend_long -= divisor_long;
		}
		
		if(flag_dividend == flag_divisor )
		{
			if(result>Integer.MAX_VALUE)
			{
				return Integer.MAX_VALUE;
			}else
			{
				return (int) result;
			}
				
		}	
		else
		{
			if(result<Integer.MIN_VALUE)
			{
				return Integer.MIN_VALUE;
			}else 
			{
				return 0 - (int) result;
			}
		}
			
	}
}
