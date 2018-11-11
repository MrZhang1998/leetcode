package Rotate_List;

import AddTwoNumbers.ListNode;

public class Solution
{
	public ListNode rotateRight(ListNode head, int k)
	{
		if(head == null)
			return null;
		int length = getLength(head);
		if(k%length == 0)
			return head;
		
		ListNode new_head = new ListNode(4);
		k = k%length;
		int index = length - k +1; // 正数第几个节点
		int i = 1;
		ListNode last = head;
		ListNode node = head; // 遍历
		while(node!=null&&i<index)
		{
			i++;
			last = node;
			node = node.next;
		}
		last.next = null;
		new_head.next = node;
		while(node.next!=null)
		{
			node = node.next;
		}
		node.next = head;
		return new_head.next;
		
	}
	
	private int getLength(ListNode head)
	{
		int length = 0;
		while(head!=null)
		{
			length++;
			head = head.next;
		}
		return length;
	}
}
