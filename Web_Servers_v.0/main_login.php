<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="UTF-8">
        <title><?php echo $title; ?></title>
        <link rel="stylesheet" type="text/css" href="Styles/Stylesheet.css" />
    </head>
    <body>
      
        <div id="wrapper">
            
            <div id="banner">
                <p> YourSpace+ </p>
            </div>
            
            <nav id="navigation">
	            <!--
                <ul id="nav">
                    <li><a href="#">Home</a></li>
                    <li><a href="#">My Page</a></li>
                    <li><a href="#">Logout</a></li>
                </ul>
                -->
            </nav>
            
            <div id="content_area">
                <?php echo $content; 
	                
                ?>
                
                <table id="login_table" align="center">
					<tr>
					<form name="form1" method="post" action="checklogin.php">
					<td>
					<table width="100%" border="0" cellpadding="3" cellspacing="1" bgcolor="#FFFFFF">
					<tr>
					<td colspan="3"><strong>Please enter your username and password below </strong></td>
					</tr>
					<tr>
					<td width="78">Username</td>
					<td width="6">:</td>
					<td width="294"><input name="myusername" type="text" id="myusername"></td>
					</tr>
					<tr>
					<td>Password</td>
					<td>:</td>
					<td><input name="mypassword" type="text" id="mypassword"></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td><input type="submit" name="Submit" value="Login"></td>
						</tr>
							</table>
						</td>
						</form>
						</tr>
					</table>
                
            </div>
            
            
                
            
              
        </div>
        
    </body>
</html>
