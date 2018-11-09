package Insert_Interval;

import java.util.ArrayList;
import java.util.List;
public class Solution
{

	public List<Interval> insert(List<Interval> intervals, Interval newInterval)
	{
		List<Interval> result = new ArrayList<Interval>();
		if(intervals.size() == 0)
		{
			result.add(newInterval);
			return result;
		} 
		int insert_index = 0;
		while(insert_index<intervals.size()&&newInterval.start>intervals.get(insert_index).start)
		{
			insert_index++;
		}
		if(insert_index == intervals.size())
			intervals.add(newInterval);
		else
			intervals.add(insert_index, newInterval);
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
