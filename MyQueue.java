/**
 * Generic type MyQueue class that acts as a queue
 * @author Paul Dacey
 */

import java.util.ArrayList;

@SuppressWarnings("unchecked")
public class MyQueue<T> implements QueueInterface
{
	/**
	 * Holds size of the queue array
	 */
	private int size;
	/**
	 * Generic queue array to store items in
	 */
	private T[] queue;
	/**
	 * front and rear values to indicate where the front and rear of the circular array are
	 */
	private int front,rear;
	
	/**
	 * Counter variable to count number of elements added to queue
	 */
	private int count = 0;
	
	/**
	 * Constructor to initialize variables
	 */
	MyQueue()
	{
		size = 5;
		queue = (T[]) new Object[size];
		front = -1;
		rear = -1;
	}
	
	/**
	 * Parameterized constructor to set size of the array and initialize variables
	 * @param num
	 */
	MyQueue(int num)
	{
		size = num;
		queue = (T[]) new Object[size];
		front = -1;
		rear = -1;
	}
	
	/**
	 * Determines if Queue is empty
	 * @return true if Queue is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		if(count == 0)
		{
			return true;
		}
		else
		{
			return false;
		}

	}

	/**
	 * Determines of the Queue is Full
	 * @return true if Queue is full, false if not
	 */
	@Override
	public boolean isFull() 
	{
		if(rear == size)
		{
			return true;
		}
		return false;
	}

	/**
	 * Deletes and returns the element at the front of the Queue
	 * @return the element at the front of the Queue
	 * @throws QueueUnderflowException if queue is empty
	 */
	@Override
	public T dequeue() throws QueueUnderflowException 
	{
		T temp;
		if(isEmpty())
		{
			throw new QueueUnderflowException();
		}
		
		temp = queue[front];
		if(rear == front)
		{
			front = -1;
			rear = -1;
		}
		else
		{
			front++;
		}
		count--;
		return temp;
	}

	/**
	 * Returns number of elements in the Queue
	 * @return the number of elements in the Queue
	 */
	@Override
	public int size() 
	{
		return count;
	}

	/**
	 * Adds an element to the end of the Queue
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful
	 * @throws QueueOverflowException if queue is full
	 */
	@Override
	public boolean enqueue(Object e) throws QueueOverflowException 
	{
		if(isFull())
		{
			throw new QueueOverflowException();
		}
		else
		{
			if(front == -1)
			{
				front = 0;
			}
			if(rear == -1)
			{
				rear = 0;
			}
			
			queue[rear] = (T) e;
			rear++;
			count++;
			return true;
		}
		
	}

	/**
	 * Returns the string representation of the elements in the Queue, 
	 * the beginning of the string is the front of the queue
	 * @return string representation of the Queue with elements
	 */
	@Override
	public String toString()
	{
		String temp = "";
		int num = rear-1;
		int start = front;
		
		while(num > front && start != rear)
		{
			if(num != front)
			{
				temp += queue[start];
				start++;
			}
			else
			{
				temp += queue[start];
				start++;
			}
			
			
			num--;
		}
		if(num == front)
		{
			temp += queue[start];
		}

		return temp;
	}
	
	/**
	 * Returns the string representation of the elements in the Queue, the beginning of the string is the front of the queue
	 * Place the delimiter between all elements of the Queue
	 * @return string representation of the Queue with elements separated with the delimiter
	 */
	@Override
	public String toString(String delimiter) 
	{
		String temp = "";
		int num = rear-1;
		int start = front;
		
		while(num > front && start != rear)
		{
			if(num != front)
			{
				temp += queue[start] + delimiter;
				start++;
			}
			else
			{
				temp += queue[start];
				start++;
			}
			
			
			num--;
		}
		if(num == front)
		{
			temp += queue[start];
		}
	

		return temp;
	}

	/**
	  * Fills the Queue with the elements of the ArrayList, First element in the ArrayList
	  * is the first element in the Queue
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE QUEUE, if you use the
	  * list reference within your Queue, you will be allowing direct access to the data of
	  * your Queue causing a possible security breech.
	  * @param list elements to be added to the Queue
	  * @throws QueueOverflowException if queue is full
	 
	  */
	@Override
	public void fill(ArrayList list)
	{
		ArrayList copy = new ArrayList<>();
		for(int k = 0; k < list.size(); k++)
		{
			copy.add(list.get(k));
		}
		
		boolean overflow = false;
		if(isEmpty())
		{
			for(int i = 0; i < copy.size(); i++)
			{
				if(!overflow)
				{
					try 
					{
						enqueue(copy.get(i));
					} 
					catch (QueueOverflowException e) 
					{
						
						overflow = true;
						break;
					}
				}
			}
			
			
			
			
			
		}
		
	}
	
	
	
	
}
