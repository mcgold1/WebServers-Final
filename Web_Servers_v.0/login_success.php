<!DOCTYPE html>
// Check if session is not registered, redirect back to main page. 
// Put this code in first line of web page. 

<!--
This is where I will put stuff for after the user logs in.	
-->

<?php
session_start();
if(!session_is_registered(myusername)){
header("location:main_login.php");
}
?>

<html>
<body>
Login Successful
</body>
</html>