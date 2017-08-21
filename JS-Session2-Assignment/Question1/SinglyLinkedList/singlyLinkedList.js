/**Node class
 having two members data and next part
data hold element value and next point to next node
*/
function Node(elementData)
{
	this.data=elementData;
	this.next=null;
}

/**SinglyLinkList class
	having data members head and length
	head is pointing front node of Linked List
*/
function SinglyLinkList()
{
	this.head = null; 
	this.length=0;

	/**
		SinglyLinkList class function for adding new element in LinkedList
	*/
	this.addNewElement= function(elementData)
	{
		if(arguments.length!=1)
		{
			console.log('Error: extra arguments passed');
			return;
		}
			if('undefined'!=typeof elementData)
			{
					console.log('New Element added having data : '+elementData);
					var newNode=new Node(elementData);
					/*
						checking whether head is null or not 
						if true means there is no node in list so add new node , and head will point to it 
						else iterate the last node and add new node at last
						and at last do increment in length of list 
					*/
					if(this.head==null)
						{
							this.head=newNode;
						}
					else{
						currentElement=this.head;
						while(currentElement.next != null)
							{
								currentElement=currentElement.next;
							}
						currentElement.next=newNode;
						
					}
					this.length++;
			}
			else
			{
				console.log('Error: no value entered to insert');
			}
		};
		
		


	/*
		showElements function is returning array of all elements
	*/
	this.showAllElements=function(){
		if(arguments.length!=0)
		{
			console.log('Error: extra arguments passed');
			return;
		}
	
		/*
				checking whether head is null or not 
				if true means there is no node in list so printing Empty List message 
				else iterate list and add elements to array and at last we are actually returning array
		*/
		if(this.head==null)
		{
			console.log('Empty list');
		}
		else
		{	
			var elementsArray=[];
			var elementIndex=0;
			currentElement=this.head;
			while(currentElement!= null)
				{
					elementsArray[elementIndex++]=currentElement.data;
					currentElement=currentElement.next;
				}
					console.log(elementsArray);
		}
		
	};
	
	/**
		function for removing element from given position
	*/
	this.deleteElementfrom=function(position){
		if(arguments.length!=1)
		{
			console.log('Error: extra arguments passed');
			return;
		}
		if( position>0&&position<=this.length)
		{
			/*
				if length is one means head element has to be deleted , so assigning head as null
				else deleting from desired position
			*/
			var deletedData='';
			 if(this.length==1)
			{
				deletedData=this.head.data;
				this.head=null;
				
			}
			else if(position==1)
			{
				deletedData=this.head.data;
				this.head=this.head.next;
			}
			else{
				var currentIndex=1;
				currentElement=this.head;
				var previousNode=null;
				/*
					iterating list till the position found
				*/
				while(position>currentIndex)
					{
						
						currentIndex++;
						previousNode=currentElement;
						currentElement=currentElement.next;
					}
					deletedData=currentElement.data;
					previousNode.next=currentElement.next;
					currentElement=null;
					
			}
			/*
				updating length after deletion
			*/
			this.length--;
			console.log('Element deleted from position : '+position+' is '+deletedData);
		}
		else if(this.length==0)
		{
			console.log('list is empty');
		}
		else {
			console.log('Invalid position entered');
		}
	};
	
	/**
	*	function searching for element data at given location in linkedlist 
	*/
	this.searchAt=function(position){
		if(arguments.length!=1)
		{
			console.log('Error: extra arguments passed');
			return;
		}
		if( position>0&&position<=this.length)
		{
			/*
				iterating list till the given valid position and printing element data 
			*/
				var currentIndex=1;
				currentElement=this.head;
				
				while(position>currentIndex)
					{
						currentIndex++;
						currentElement=currentElement.next;
					}
					console.log(currentElement.data);
			
		}
		else if(this.length==0)
		{
			console.log('list is empty');
		}
		else {
			console.log('Invalid position entered to search');
		}
		
	};
	
	/**
		function printing positions of data value in list
	*/
	this.searchFormValue=function(valueToSearch)
	{
		if(arguments.length!=1)
		{
			console.log('Error: extra arguments passed');
			return;
		}
		if('undefined'!=typeof valueToSearch)
		{
				if(this.length==0)
				{
					console.log('list is empty');
				}
				else{
					var valueOcceranceIndexArray=[];
					var elementIndex=0;
					var index=0;
					currentElement=this.head;
					while(currentElement!= null)
						{	
							elementIndex++;
							if(currentElement.data==valueToSearch)
							{	
								valueOcceranceIndexArray[index++]=elementIndex;
							}
							currentElement=currentElement.next;
						}
							if(index>0)
								console.log(valueOcceranceIndexArray);
							else
								console.log('No such Entry Found');
				}
		}
		else{
			console.log('Error: no value entered to search');
		}
		
	};

	/**
		function for adding new element at user given position
	*/
	this.addElementAt=function(position,elementData){
		if(arguments.length!=2)
		{
			console.log('Error: extra arguments passed');
			return;
		}
		if( position>0&&position<=this.length&&('undefined'!=typeof elementData))
		{ 	
				
					var newNode=new Node(elementData);
					/*
						if position is 1 then add node at front and update head
					*/
					if(position==1)
					{
						newNode.next=this.head;
						this.head=newNode;
					}
					else{
						var currentIndex=1;
						currentElement=this.head;
						
						while(currentElement.next!=null&&position>currentIndex)
							{
								currentElement=currentElement.next;
							}
							newNode.next=currentElement.next;
							currentElement.next=newNode;
					}
					this.length++;
					conosle.log('Element having value '+elementData+'  added at position '+position);
		
		
		}
		else if(this.length==0)
		{
			console.log('list is empty');
		}
		else if('undefined'!=typeof elementData)
		{
			console.log('Error:No Value Entered for search');
		}
		else {
			console.log('Error:Invalid position entered');
		}
	};
	
	/**
		function for updating new value at user given position if exist
	*/
	this.updateElementAt=function(position,elementData){
		if(arguments.length!=2)
		{
			console.log('Error: extra arguments passed');
			return;
		}
		if( position>0&&position<=this.length&&('undefined'!=typeof elementData))
		{
			/*
				iterating list and updating the position Value with user given value 
			*/

				var currentIndex=1;
				currentElement=this.head;
				
				while(position>currentIndex)
					{
						currentIndex
						currentElement=currentElement.next;
					}
					
					currentElement.data=elementData;
			conosle.log('Element having value '+elementData+'  added at position '+position);
		}
		else if(this.length==0)
		{
			console.log('list is empty');
		}
		else if('undefined'!=typeof elementData)
		{
			console.log('Error:No Value Entered for search');
		}
		else {
			console.log('Invalid position entered');
		}
	};
}


var singleObject=new SinglyLinkList();
