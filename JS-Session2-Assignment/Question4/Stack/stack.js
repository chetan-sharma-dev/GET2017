function Node(elementValue)
{
	this.data=elementValue;
	this.next=null;
}

function Stack()
{
	this.head = null; 
	this.last=null;
	this.length=0;
}


Stack.prototype.push= function(elementValue)
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
				newNode.next=this.head;
				this.head=newNode;
			}
			console.log('New element inserted at top of stack:'+this.head.data);
			this.length++;
		}
		else if(arguments.length>1)
		{
			console.log('Error: extra arguments passed');
		}
		else
		{
			console.log('Error: no value entered to push in stack');
		}
		
};

Stack.prototype.pop=function()
{		
		
		if(arguments.length==0)
		{
			if(this.length>0)
			{
				if(this.length==1)
				{
					this.last=null;
				}
					console.log('popped element is '+this.head.data);
					this.head=this.head.next;
				this.length--;
			}
			else 
			{
				console.log('Stack is empty');
			}
		}
		else{
			console.log('Error: extra arguments passed');
		}
		
};



var stackObject=new Stack();