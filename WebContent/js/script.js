var firstName;
var lastName;
var mailId;
var passWord;
var rePassWord;
var dob;
var gender;
 
function validateAndSubmit()
{
	firstName = $("#fname").val();
	lastName = $("#lname").val();
	mailId = $("#email").val();
	passWord = $("#pass").val();
	rePassWord = $("#repass").val();
	dob = $("#birthday").val();
	gender = $('#gender option:selected').val();
	
	//alert(firstName +":"+LastName+":"+mailId+":"+passWord+":"+rePassWord+":"+dob+":"+gender);
	
	if(validateForm(firstName, "First Name"))
	{
		if(validateForm(lastName, "Last Name"))
		{
			if(validateForm(mailId, "Email Id"))
			{
				if(isValidEmail(mailId))
				{
					if(validateGender(gender))
					{
						if(validateForm(dob, "Valid date of birth"))
						{
							if(passWord.length != 0 && (passWord == rePassWord)) 
							{								
								//$("#regForm").submit();
								//$('#regForm').hide();
								$('#loadingss').show();
								submitRegistForm();
							}
							else
							{
								error(1,"Password not matches");
								return false;
							}							
						}	
					}					
				}
				else
				{
					error(1, "Required Valid Email Id");
				}
			}
		}
	}
	
	//$("#regForm").submit();
	
//	error(1,"All fields are required.");
}

function validateGender(valueSelected)
{
	 if( valueSelected == 0 ) {
		 error(1,"Please selcect Gender.");
		 return false;
	 }
	 return true;
}

function validateForm(fieldValue, fieldName)
{
	 if( fieldValue.length == 0 ) {
		 error(1,"Required "+fieldName);
		 return false;
	 }
	 return true;
}

function isValidEmail(email) {
	  var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	  return regex.test(email);
}

function sleep(milliseconds) {
    var start = new Date().getTime();
    for (var i = 0; i < 1e7; i++) {
      if ((new Date().getTime() - start) > milliseconds){
        break;
      }
    }
}

function submitRegistForm()
{
	$.ajax({
	   	type: 'GET',
	    url: '/jai_jpa/registerAjax.action',
	    async: false,
	    contentType: "application/json",
       // dataType: 'json',
	    data  : {
	    	fname : firstName,
	    	lname : lastName, 
	    	email : mailId, 
	    	gender : gender, 
	    	birthday : dob, 
	    	pass : passWord 	    	
	    },		  	    
	  success: function(jsonResp) {
		  
		  	$('#loadingss').hide();
		  	//$('#div-regForm').show();
		 // $("#regForm").reset();
		  alert(jsonResp.message);
		  document.getElementById("regForm").reset();
		},
    	error: function(e) {
    		//alert(e);
    	}
	});
	return true;
}
/*$(document).ready(function(){
	
	$('#regForm').submit(function(e) {

		register();
		e.preventDefault();
		
	});
	
});


function register()
{
	hideshow('loading',1);
	error(0);
	
	$.ajax({
		type: "POST",
		url: "submit.php",
		data: $('#regForm').serialize(),
		dataType: "json",
		success: function(msg){
			
			if(parseInt(msg.status)==1)
			{
				window.location=msg.txt;
			}
			else if(parseInt(msg.status)==0)
			{
				error(1,msg.txt);
			}
			
			hideshow('loading',0);
		}
	});

}
*/

function hideshow(el,act)
{
	if(act) $('#'+el).css('visibility','visible');
	else $('#'+el).css('visibility','hidden');
}

function error(act,txt)
{
	hideshow('error',act);
	if(txt) $('#error').html(txt);
}