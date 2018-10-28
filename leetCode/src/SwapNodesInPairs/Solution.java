package SwapNodesInPairs;

import AddTwoNumbers.ListNode;
import javafx.scene.Node;

public class Solution
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

	public ListNode swapPairs(ListNode head)
	{
		if(head == null)
			return null;
		if(head.next == null)
			return head;
		ListNode node = head; // iterator node
		ListNode new_head  = head.next;
		ListNode tail = head; // the tail of new list
		while(node!=null&&node.next !=null)
		{
			ListNode left = node;
			ListNode right = node.next;
			node = right.next; // prevent from breaking the list
			tail.next = right;
			right.next = left;
			tail = left;
		}
		// if the list.length is odd
		if(node!=null)
		{
			tail.next = node;
		}else {
			tail.next = null;
		}
		
		return new_head;
	}	

}
