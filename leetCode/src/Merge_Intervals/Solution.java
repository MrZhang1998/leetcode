package Merge_Intervals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

	public List<Interval> merge(List<Interval> intervals)
	{
		if(intervals.size()<=1)
			return intervals;
		List<Interval> result = new ArrayList<Interval>();
		intervals.sort(new Comparator<Interval>()
		{

			@Override
			public int compare(Interval o1, Interval o2)
			{
				// TODO Auto-generated method stub
				return Integer.compare(o1.start, o2.start);
			}
		});
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;
		for(Interval interval : intervals)
		{
			if(interval.start<=end)
			{
				end = Math.max(end, interval.end);
			}else {
				result.add(new Interval(start, end));
				start = interval.start;
				end = interval.end;
			}
		}
		result.add(new Interval(start,end));
		return result;
		
	}

	public static class Interval
	{
		int start;
		int end;

		Interval()
		{
			start = 0;
			end = 0;
		}

		Interval(int s, int e)
		{
			start = s;
			end = e;
		}
	}

}
