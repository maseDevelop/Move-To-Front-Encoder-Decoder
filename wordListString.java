

//Creates a word list that stores the most recently used word
public class wordListString{

	//Class Fields
	private tNode head;

	//private TokenNode class - Stores String data and a pointer to the next token
	private class tNode
	{
		//Class Fields
		public String token;
		public tNode  next;
		public boolean isOnDecodedList = false;
		//Constructor - Takes a string as argument
		public tNode(String  newtoken)
		{
			token = newtoken;
		}
	}//End of tNode class

	//Adds a TNode to the wordList
	public void add(String sToken)
	{
		tNode currNode = head;
		//Creating bool checker variable that will be used to check if it can be added to the list
		boolean canAdd = true;
		//Check if the word is already in the list
		while(currNode != null)
		{
			//checking if the token is already in the Set
			if(currNode.token.equals(sToken))
			{
				canAdd = false;
				break;
			}
			else
			{
				currNode = currNode.next;
			}
		}
		//If the checker is true it can add a new token to the list
		if(canAdd == true)
		{
			tNode newNode = new tNode(sToken);
			newNode.next = head;
			head = newNode;
		}
		return;
	}//End of Add

	// Gets the index of a given token and returns it
	// Once token found moves Node to head of list
	public int getIndex(String token)
	{
		tNode currNode = head;
		int index = 1;
		//Going through the list and get the index of the token is the list
		while(currNode != null)
		{
			if(currNode.token.equals(token))
			{
				if(currNode.isOnDecodedList == false)
				{
					currNode.isOnDecodedList = true;
					return 0;
				}
				else
				{
					return index;
				}
			}
			else
			{
				//Increasing index
				index ++;
				currNode = currNode.next;
			}
		}
		return 0;
	}
	//Moves a specified token to the front of the list
	public void moveToFront(String tokenToMove)
	{
		tNode currNode = head;
		tNode pNode = currNode;
		tNode cNode = currNode.next;

		if(pNode.token.equals(tokenToMove))
		{
			//Because token is already at the head dont move the head
			return;
		}
		//Looping through the list until the token is found
		while(cNode != null)
		{
			if(cNode.token.equals(tokenToMove))
			{
				//Rearraging list
				pNode.next = cNode.next;
				cNode.next =  head;
				head = cNode;
				return;
			}
			else
			{
				pNode = cNode;
				cNode = cNode.next;
			}
		}
		return;
	}
	//Given a index number it will return a string at that index in the list
	public String getStringAtIndex(String tokenInt)
	{
		tNode currNode = head;
		int index = 1;
		//Parsing the token into an into
		int tokenInteger = Integer.parseInt(tokenInt);
		//Itterating through the loop
		while(currNode != null)
		{
			if(index == tokenInteger)
			{
				return currNode.token;
			}
			else
			{
				currNode = currNode.next;
				index++;
			}L
		}
		return null;
	}

	//PrintList for Testing
	public void printListToken()
	{
		tNode currNode = head;
		System.out.println("-------------TokenList----------------");
		while(currNode != null)
		{
			System.out.println(currNode.token);
			currNode = currNode.next;
		}
	}

}//End bracket
