function Node(elementValue)
{
	this.data=elementValue;
	this.next=null;
}

function Queue()
{
	this.head = null; 
	this.last=null;
	this.length=0;	
}

Queue.prototype.enqueue= function(elementValue)
	{
		if('undefined' != typeof elementValue && arguments.length==1)
		{
			var newNode=new Node(elementValue);
			if(this.head==null)
				{
					this.head=newNode;
					this.last=newNode;
					
				}
			else{
				currentElement=this.head;
				while(currentElement.next != null)
					{
						currentElement=currentElement.next;
					}
				currentElement.next=newNode;
				this.last=newNode;
			}
			console.log('Element '+newNode.data+'inserted in queue');
			this.length++;
		}
		else if(arguments.length>1)
		{
			console.log('Error: extra arguments passed');
		}
		else{
			console.log('Error: no value entered to enqueue in Queue');
		}
		
	};
	
Queue.prototype.dequeue=function(){
	if(arguments.length==0)
		{
			if(this.length>0)
			{
				if(this.length==1)
				{
					this.last=null;
				}
					console.log('Dequeued element is '+this.head.data);
					this.head=this.head.next;
				this.length--;
			}
			else 
			{
				console.log('Queue is empty');
			}
		}
		else{
			console.log('Error: extra arguments passed');
		}
		
	};

Queue.prototype.searchFormValues=function(valueToSearch)
	{
		if(this.length==0)
		{
			console.log('Queue is empty');
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
						valueOcceranceIndexArray[index++]=elementIndex;
					currentElement=currentElement.next;
				}
					if(index>0)
					{
						console.log('Given value'+valueToSearch+' found at : '+valueOcceranceIndexArray+' indexes');
					}
					else
					{
						console.log('No such Entry Found in Queue');
					}
		}
		
	};
	
Queue.prototype.traverse=function(){
	
		if(this.length==0)
		{
			console.log('Empty Queue');
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
					console.log('All Elements of  Queue are: '+elementsArray);
		}
		
	};



var queueObject=new Queue();