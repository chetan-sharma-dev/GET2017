function sum(x,y){
	
	if(y!=null)
	{	
		try{
			
			return parseInt(x)+parseInt(y);
		}
		catch(Error)
		{
			return 'Error : Passed Parameters are not Integer ';
		}
	}
	else{
		return function(y){
			try{
				return parseInt(x)+parseInt(y);
			}
			catch(Error)
			{
				return 'Error : Passed Parameters are not Integer ';
			}
			
			};
	}
}
console.log(sum(10,20));
console.log(sum(10)(20));