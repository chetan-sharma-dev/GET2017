function Node(elementValue)
{
	this.previous=null;
	this.data=elementValue;
	this.next=null;
}

function CommonClassForQueueAndStack()
{
	this.head = null;
	this.end=null;	
	this.length=0;
	
	this.addNewElement= function(elementValue)
	{
		var newNode=new Node(elementValue);
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
			newNode.previous=currentElement;
			this.end=newNode;
		}
		this.end=newNode;
		this.length++;
		
	};
	this.dequeue=function(){
		if(this.length>0)
		{
			if(this.length==1)
			{
				this.end=null;
			}
				console.log('Dequeued element is '+this.head.data);
				this.head=this.head.next;
				this.head.previous=null;
			this.length--;
		}
		else 
		{
			console.log('Queue is empty');
		}
		
	};
	this.pop=function(){
		if(this.length>0)
		{
			console.log('popped element is '+this.end.data);
			this.end=this.end.previous;
			if(this.length==1)
			{
				this.end=null;
			}
			else{
				this.end.next=null;
			}
				this.length--;
		}
		else 
		{
			console.log('Stack is empty');
		}
		
	};
	
	this.showElements=function(){
		
		
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
	
	
	
	
}

var commonObject=new CommonClassForQueueAndStack();