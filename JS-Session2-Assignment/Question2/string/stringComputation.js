function getResult(){
	
    var input = document.getElementById("content").value;
	if(input.length==0)
	{
		document.getElementById("result").innerHTML = 'Empty String';
		document.getElementById("result").style.color='red';
		
		return;
	}
	document.getElementById("result").style.color='black';
    var index=0;
    document.getElementById("result").innerHTML = input;
    while(index < input.length-1){
        var string="";
        var count=index;
        while(input.charAt(index) == input.charAt(index+1)){
            index++;
        }
        if(index!=count){
            for(var jindex=count;jindex<=index;jindex++){
                string+=input.charAt(jindex);
            }
        }
        
        if(string!=""){
            
        input=input.replace(string,"");
        document.getElementById("result").innerHTML += " -> " +input;
        index=0;
        }
        else{
            index++;
        }
    }
    document.getElementById("content").value="";
    document.getElementById("content").focus();
}