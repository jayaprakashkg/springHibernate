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
		  alert(jsonResp.message);
		  document.getElementById("regForm").reset();
		  $('#errormsg').html("");
		},
    	error: function(e) {
    		//alert(e);
    	}
	});
	return true;
}


function error(act,txt)
{
	var modified = "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
					"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
			"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color='red'>"+txt+"</font>";
	$('#errormsg').html(modified);
}