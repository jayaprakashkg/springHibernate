
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />



<title>Registration Form</title>
<link rel="stylesheet" type="text/css" href="./css/calendar.css" />
<link rel="stylesheet" type="text/css" href="./css/demo.css" />
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
<script type="text/javascript" src="./js/calendar.js"></script>
<script type="text/javascript" src="./js/script.js"></script>
<script type="text/javascript">
$( document ).ready(function() {
    
    calendar.set("birthday");
    $( "#signUp" ).click(function() {
    	validateAndSubmit();
    });
});

</script>

</head>

<body>



  		<div id="loadingss" hidden="true" align="center">
  			<p><img src="img/Fading lines.gif" /> Please Wait</p>
		</div>
 
<div id="div-regForm">

<div class="form-title">Sign Up</div>
<div class="form-sub-title">OUA-It's free and anyone can join</div>

<form id="regForm" action="../jai_jpa/register.action" method="post">

<table>
  <tbody>
  <tr>
    <td><label for="fname">First Name:</label></td>
    <td><div class="input-container"><input name="fname" id="fname" type="text" /></div></td>
  </tr>
  <tr>
    <td><label for="lname">Last Name:</label></td>
    <td><div class="input-container"><input name="lname" id="lname" type="text" /></div></td>
  </tr>
  <tr>
    <td><label for="email">Your Email:</label></td>
    <td><div class="input-container"><input name="email" id="email" type="text" /></div></td>
  </tr>
  <tr>
    <td><label for="pass">New Password:</label></td>
    <td><div class="input-container"><input name="pass" id="pass" type="password" /></div></td>
  </tr>
  <tr>
    <td><label for="pass">Re-enter Password:</label></td>
    <td><div class="input-container"><input name="repass" id="repass" type="password" /></div></td>
  </tr>
  <tr>
    <td><label for="sex-select">I am:</label></td>
    <td>
    <div class="input-container">
    <select name="gender" id="gender">
    	<option value="0">Select Gender:</option>
    	<option value="1">Female</option>
    	<option value="2">Male</option>
    </select>
    </div>
    
    </td>
  </tr>
  <tr>
    <td><label>Date of Birth:</label></td>
    <td>
    <div class="input-container">
   		<input type="text" name="birthday" id="birthday" />
    </div>
    </td>
  </tr>
  <tr>
  <td>
  	&nbsp;
  </td>
  
  <td>
  	<input type="button" class="greenButton" value="Sign Up" id="signUp"/>  	
  </td>
  </tr>
  
  
  </tbody>
</table>

</form>

<div id="error">
&nbsp;
</div>

</div>

</body>
</html>

