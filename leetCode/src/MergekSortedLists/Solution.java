package MergekSortedLists;

import AddTwoNumbers.ListNode;

public class Solution
{
	public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode node = head;
        while(!isEnd(lists))
        {
        	int min = Integer.MAX_VALUE;
        	int index = 0;
        	for(int i =0 ;i<lists.length;i++)
        	{
        		int val = lists[i]==null?Integer.MAX_VALUE:lists[i].val;
        		if(val<min)
        		{
        			min = val;
        			index = i;
        		}
        	}
        	node.next = lists[index];
        	node = lists[index];
        	lists[index] = lists[index].next;
        }
        return head.next;
    }
	
	private boolean isEnd(ListNode[] list)
	{
		boolean result = true;
		for(int i = 0; i<list.length;i++)
		{
			if(list[i]!=null)
				return false;
		}
		return result;
	}
}
