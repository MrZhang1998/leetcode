package MergeTwoSortedLists;

import AddTwoNumbers.ListNode;

public class Solution
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
        	return l2;
        if(l2 == null)
        	return l1;
        ListNode head = new ListNode(-1, null);
        ListNode node = head;
        while(l1!=null&&l2!=null)
        {
        	if(l1.val<l2.val) {
        		node.next = l1;
        		node = l1;
        		l1 = l1.next;
        	}else {
				node.next = l2;
				node= l2;
				l2 = l2.next;
			}
        }
        while(l1!=null)
        {
        	node.next = l1;
        	node = l1;
        	l1 = l1.next;
        }
        while(l2!=null)
        {
        	node.next = l2;
        	node = l2;
        	l2 = l2.next;
        }
        return head.next;
    }

}
