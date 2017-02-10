<?php

ob_start();
$host="localhost:3036"; // Host name
//print("$host\n"); 
$username="bob123"; // Mysql username 
//print("$username"); 
$password="catmeow"; // Mysql password 
//print("$password"); 
$db_name="test_create_DB"; // Database name 
//print("$db_name"); 
$tbl_name="web_members"; // Table name 
//print("$tbl_name"); 

// Connect to server and select databse.
$conn = mysql_connect($host, $username, "")or die("cannot connect"); 
mysql_select_db("$db_name")or die("cannot select DB");

// Define $myusername and $mypassword 
$myusername=$_SESSION['myusername']; 
$mypassword=$_SESSION['mypassword']; 

// To protect MySQL injection (more detail about MySQL injection)
$myusername = stripslashes($myusername);
$mypassword = stripslashes($mypassword);
$myusername = mysql_real_escape_string($myusername);
$mypassword = mysql_real_escape_string($mypassword);
//$sql="SELECT * FROM tbl_name WHERE username=myusername and password=mypassword";
$sql = 'SELECT name FROM web_members';
$result=mysql_query($sql, $conn);

// Mysql_num_row is counting table row
$count=mysql_num_rows($result);

$data = mysql_fetch_assoc($result);
//echo $data['name'];

// If result matched $myusername and $mypassword, table row must be 1 row
if($count==2){

// Register $myusername, $mypassword and redirect to file "login_success.php"
//session_register("myusername");
//session_register("mypassword"); 
header("location:login_success.php");
}
else {
echo "Wrong Username or Password";
}
ob_end_flush();
?>