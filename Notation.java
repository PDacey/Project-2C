/**
 * Notation class contains methods that convert a infix to a postfix and vice versa. It also contains a method that will
 * evaluate a postfix expression and give its result.
 * @author Paul Dacey
 *
 */

public class Notation 
{
	/**
	 * Converts an infix expression to a postfix
	 * @param infix Infix expression to evaluate
	 * @return postfix expression
	 * @throws InvalidNotationFormatException Thrown if notation provided is invalid
	 */
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException
	{
		int left = 0;
		int right = 0;
		MyQueue<Character> queue = new MyQueue<Character>(infix.length());
		MyStack<Character> stack = new MyStack<Character>(infix.length());
		char[] charArr = new char[infix.length()];
		
		for(int i = 0; i < infix.length(); i++)
		{
			charArr[i] = infix.charAt(i);
		}

		try
		{
		for(int k = 0; k < charArr.length; k++)
		{
			if(Character.isDigit(charArr[k]))
			{
				queue.enqueue(charArr[k]);
				
			}
			if(charArr[k] == '(')
			{
				stack.push(charArr[k]);
				left++;
			}
			if(charArr[k] == '+' || charArr[k] == '-' || charArr[k] == '*' || charArr[k] == '/')
			{
				if(!stack.isEmpty())
				{
					if(!queue.isEmpty())
					{
						char top = (char) stack.top();
						if(top == '/' || top == '/' || charArr[k] == '-' && top == '-' || charArr[k] == '-' && top == '+'
							|| charArr[k] == '+' && top == '-' || charArr[k] == '+' && top == '+')
						{
							queue.enqueue(stack.pop());
						}
					}
					stack.push(charArr[k]);
					
					
				}
			}
			
			if(charArr[k] == ')')
			{
				right++;
				while((char) stack.top() != '(')
				{
					queue.enqueue(stack.pop());
					if(stack.isEmpty())
					{
						throw new InvalidNotationFormatException();
					}
				}
				stack.pop();
				
				
			}
	
		}

		}
		catch(StackOverflowException | StackUnderflowException | QueueOverflowException e)
		{
			
		}
		catch(Exception e)//used to catch all other exceptions to gently throw an exception
		{
			throw new InvalidNotationFormatException();
		}
		
		if(left != right)
		{
			throw new InvalidNotationFormatException();
		}
		
		return queue.toString();
	}

	/**
	 * Converts a postfix expression to an infix expression
	 * @param postfix Postfix expression to evaluate
	 * @return infix expression
	 * @throws InvalidNotationFormatException Thrown if notation given is invalid
	 */
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException 
	{
		String first,second = "";
		String result;
		//MyQueue<Character> queue = new MyQueue<Character>(postfix.length());
		MyStack<String> stack = new MyStack<>(postfix.length());
		
		char[] charArr = new char[postfix.length()];
		
		for(int i = 0; i < postfix.length(); i++)
		{
			charArr[i] = postfix.charAt(i);
		}
		
		try
		{
		for(int k = 0; k < charArr.length; k++)
		{
			if(Character.isDigit(charArr[k]))
			{
				stack.push(Character.toString(charArr[k]));
			}
			if(charArr[k] == '+' || charArr[k] == '-' || charArr[k] == '*' || charArr[k] == '/')
			{
				if(stack.size() < 2)
				{
					throw new InvalidNotationFormatException();
				}
				first = stack.pop();
				second = stack.pop();
				result = "(" + second + charArr[k] + first + ")";
				stack.push(result);
			}
			
			
			
			
			
			}
		}
		catch(StackOverflowException | StackUnderflowException e)
		{
			throw new InvalidNotationFormatException();
		} 
		catch(Exception e)//used to catch all other exceptions to gently throw an exception
		{
			throw new InvalidNotationFormatException();
		}
		
		if(stack.size() > 1)
		{
			throw new InvalidNotationFormatException();
		}
		
		return stack.toString();
	}

	/**
	 * Computes the value of the given postfix and returns the result
	 * @param postfix Postfix expression to evaluate
	 * @return Double containing the result of the expression
	 * @throws InvalidNotationFormatException Thrown if invalid notation was given
	 */
	public static double evaluatePostfixExpression(String postfix)  throws InvalidNotationFormatException
	{
		double first,second;
		MyStack<Double> stack = new MyStack<>(postfix.length());

		char[] charArr = new char[postfix.length()];
		
		for(int i = 0; i < postfix.length(); i++)
		{
			charArr[i] = postfix.charAt(i);
		}
		
		try
		{
			for(int k = 0; k < charArr.length; k++)
			{
				if(Character.isDigit(charArr[k]) || charArr[k] == '(')
				{
					stack.push(Double.parseDouble(Character.toString(charArr[k])));
				}
				
				if(charArr[k] == '+' || charArr[k] == '-' || charArr[k] == '*' || charArr[k] == '/')
				{
					if(stack.size() < 2)
					{
						throw new InvalidNotationFormatException();
					}
				
					second = stack.pop();
					first = stack.pop();
					
					if(charArr[k] == '+')
					{
						stack.push(first + second);
					}
					
					if(charArr[k] == '-')
					{
						stack.push(first - second);
					}
					
					if(charArr[k] == '*')
					{
						stack.push(first * second);
					}
					
					if(charArr[k] == '/')
					{
						stack.push(first / second);
					}
							
				
				}
				
				
			}
			
		}
		catch(StackOverflowException | StackUnderflowException e)
		{
			throw new InvalidNotationFormatException();
		}
		catch(Exception e)//used to catch all other exceptions to gently throw an exception
		{
			throw new InvalidNotationFormatException();
		}
		
		if(stack.size() > 1)
		{
			throw new InvalidNotationFormatException();
		}
		
		return Double.parseDouble(stack.toString());
		
	}

	
	
	
	
	
	
}
