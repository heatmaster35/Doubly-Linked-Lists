/*##########################
# Name: Leo Gomez          #
# CruzID: legomez          #
# Class: CMPS-12B          #
# Date: Nov 5, 2014        #
# filename: dllist.java    #
# Details:has the functions#
#  for doubly linked lists #
############################
*/
// dllist.java
// Template code for doubly-linked list of strings.
import java.util.NoSuchElementException;

public class dllist
{
	public enum Position {FIRST, PREVIOUS, FOLLOWING, LAST};
	private class node 
	{
		String item;
		node prev;
		node next;
	}
	private int top = 0;
	private node first = null;
	private node current = null;
	private node last = null;
	private int currentPosition = 0;
	public void setPosition (Position pos) 
	{
		switch(pos)
		{
		case FOLLOWING:
			current = current.next;
			currentPosition--;
			if (currentPosition < 0)
				currentPosition = 0;
			break;

		case PREVIOUS:
			current = current.prev;
			currentPosition++;
			break;

		case FIRST:
			current = first;
			currentPosition = 0;
			break;

		case LAST:
			current = last;
			currentPosition = top;
			break;
		default: break;
		}

	}
	public boolean isEmpty () 
	{
		return first==null;
	
	}
	public String getItem () 
	{
		if(first.item != null)
			return current.item;
		else
			throw new NoSuchElementException();
	}
	public int getPosition () 
	{
		if(currentPosition >= 0)
			return currentPosition;
		else
			throw new NoSuchElementException();
	}
	public void delete () 
	{
		if (first == null)
			throw new NoSuchElementException();	
		else if ((current.next == null) && (current.prev == null))
		{
			first = null;
			last = null;
			current = null;
			top--;
			currentPosition--;
		}else if (current.next == null)
		{
			setPosition(dllist.Position.PREVIOUS);
			current.next = null;
			first = current;
			top--;
			currentPosition = 0;
		}else if (current.prev == null)
		{
			setPosition(dllist.Position.FOLLOWING);
			current.prev = null;
			last = current;
			top--;
			currentPosition = top;
		}else
		{
			setPosition(dllist.Position.PREVIOUS);
			current.next = current.next.next;
			setPosition(dllist.Position.FOLLOWING);
			current.prev = current.prev.prev;
			top--;
			currentPosition--;
		}
	}
	public void insert (String item, Position pos) 
	{
		node newNode = new node();
		newNode.item = item;
		if(isEmpty())
		{
			first = newNode;
			last = newNode;
			current = newNode;
			first.next = null;
			first.prev = null;
		}else
		{
			switch(pos)
			{
			case FOLLOWING:
				newNode.next = current.next;
				current.next = newNode;
				newNode.prev = current;
				if(newNode.next != null)
					newNode.next.prev = newNode;
                                if(newNode.next == null)
                                        first = newNode;
				current = newNode;
                                if (currentPosition < 0)
                                         currentPosition = 0;
				top++;
				break;

			case PREVIOUS:	
				newNode.prev = current.prev;
				current.prev = newNode;
				newNode.next = current;
				if(newNode.prev != null)
					newNode.prev.next = newNode;
                                if(newNode.prev == null)
                                        last = newNode;
				current = newNode;
				currentPosition++;
				top++;
				break;

			case FIRST:
				first.next = newNode;
				newNode.prev = first;
				newNode.next = null;
				first = newNode;
				current = newNode;
				top++;
				currentPosition = 0;
				break;

			case LAST:
				last.prev = newNode;
				newNode.next = last;
				newNode.prev = null;
				last = newNode;
				current = newNode;
				top++;
				currentPosition = top;
				break;
			default: 
				throw new IllegalArgumentException();
			}
		}
	}

}

