function redirect(URL)
{
	window.location = URL;
}
function validateCharString(inputString)
			{
				
				expectedCharPattern = new RegExp("^([a-zA-Z]*)$");
				if (expectedCharPattern.test(inputString))
				{
					return true;
				}
				else
				{
						return false;
				}
			
			}
function validateLength(inputString,expectedLength)
		{
				if(inputString.length>expectedLength)
				{
						return false;
				}
				else
				{
						return true;
				}
				
		}
function validateFirstName(inputBoxId)
{
		inputString=document.getElementById(inputBoxId).value;
		errorSpanId=inputBoxId+"-error-span";
		if(validateCharString(inputString))
		{
			clearSpan(errorSpanId);
		}
		else{
				showError(errorSpanId,"Invalid character string");
				
		}
		expectedLength=20;
			if(!validateLength(inputString,expectedLength))
			{
				showError(errorSpanId,document.getElementById(errorSpanId).innerHTML+", input length exceeds 20");	
			}
	
}
function validateOrganizationName(inputBoxId)
{
		inputString=document.getElementById(inputBoxId).value;
		errorSpanId=inputBoxId+"-error-span";
		
		if(validateCharString(inputString))
		{
			clearSpan(errorSpanId);
		}
		else{
				showError(errorSpanId,"Invalid organization name");
		}
}

function validateEmailId(inputBoxId)
		{
				inputEmailString=document.getElementById(inputBoxId).value;
				expectedEmailPattern = new RegExp("^([a-zA-Z0-9.]+@[a-zA-Z]+.[a-zA-Z]{2,})$");
				errorSpanId=inputBoxId+"-error-span";
		
				if (!expectedEmailPattern.test(inputEmailString))
				{
					showError(errorSpanId,"Invalid email input");
				}
				else
				{
						clearSpan(errorSpanId);
				}
				
				
		}
function validateContactNumber(inputBoxId)
	{
		inputNumberString=document.getElementById(inputBoxId).value;
		expectedNumberPattern = new RegExp("^([0-9]{10})$");
		errorSpanId=inputBoxId+"-error-span";
		
				if (!expectedNumberPattern.test(inputNumberString))
				{
					showError(errorSpanId,"Invalid Number input");
				}
				else
				{
						clearSpan(errorSpanId);
				}
			
	}		
function validateMessage(inputBoxId)
{
		inputString=document.getElementById(inputBoxId).value;
		errorSpanId=inputBoxId+"-error-span";
		
		if(validateCharString(inputString))
		{
			clearSpan(errorSpanId);
		}
		else{
				showError(errorSpanId,"Invalid character input in message");			
		}
		expectedLength=200;
			if(!validateLength(inputString,expectedLength))
			{
				showError(errorSpanId,document.getElementById(errorSpanId).innerHTML+", Length exceeds 200");		
				
			}
	
}
function validateSelectedCity(inputBoxId)
{
		inputString=document.getElementById(inputBoxId).value;
		errorSpanId=inputBoxId+"-error-span";
		
		if(inputString.length==0)
		{
				showError(errorSpanId,"No City Selected");
		}
		else{
				clearSpan(errorSpanId);
		}
		
}
function showError(spanId,errorMessage)
{
				document.getElementById(spanId).innerHTML=errorMessage;
				document.getElementById(spanId).style.color="red";
	
}
function clearSpan(spanId)
{
		document.getElementById(spanId).innerHTML="";
}
function validate(inputBoxId)
{
	
	switch(inputBoxId)
	{
		case 'first-name': 
					validateFirstName(inputBoxId); 
						break;		
		case 'mail-id': 
					validateEmailId(inputBoxId) ;
						break;
		case 'city': 
					validateSelectedCity(inputBoxId);
						break;
		case 'organization-name':
					validateOrganizationName(inputBoxId) ;
						break;
		case 'conntact-number':
					validateContactNumber(inputBoxId);
						break;
		case 'message': 
					validateMessage(inputBoxId);
						break;
		
	}
}

function checkAllInput()
{
	
	firstNameError=document.getElementById("first-name-error-span").innerHTML;
	mailIdError=document.getElementById("mail-id-error-span").innerHTML;
	cityError=document.getElementById("city-error-span").innerHTML;
	organizationNameError=document.getElementById("organization-name-error-span").innerHTML;
	contactNumberError=document.getElementById("contact-number-error-span").innerHTML;
	messageError=document.getElementById("message-error-span").innerHTML;
	
	firstNameInputValue=document.getElementById("first-name").value;
	mailIdInputValue=document.getElementById("mail-id").value;
	cityInputValue=document.getElementById("city").value;
	organizationNameInputValue=document.getElementById("organization-name").value;
	contactNumberInputValue=document.getElementById("contact-number").value;
	messageInputValue=document.getElementById("message").value;
	
	if(firstNameError.length==0&&mailIdError.length==0&&cityError.length==0&&organizationNameError.length==0&&contactNumberError.length==0&&messageError.length==0)
	{
		if(firstNameInputValue.length!=0&&mailIdInputValue.length!=0&&cityInputValue.length!=0&&organizationNameInputValue.length!=0&&contactNumberInputValue.length!=0&&messageInputValue.length!=0)
		{
			redirect("Contact.html");
		}
		else
		{
			showError('error-message','fill empty entries');
		}
	}
	else{
		showError('error-message','fill valid entries');
		
	}
}
