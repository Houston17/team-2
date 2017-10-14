<html>
	<body>
		<?php
			if (isset($_REQUEST['submitted'])){
				// Initialize error array.
			  $errors = array();
			  // Check for a proper First name
			  if (!empty($_REQUEST['name'])){
				  $name = $_REQUEST['name'];
				  $pattern = "/^[a-zA-Z\_]{2,20}/";// This is a regular expression that checks if the name is valid characters
				  if (preg_match($pattern,$name)){ $name = $_REQUEST['name'];
				  }else{ $errors[] = 'Your Name can only contain _, A-Z, or a-z, 2-20 long.';}
				}else {$errors[] = 'You forgot to enter your Name.';}
				// Check for a proper Last name
			  if (!empty($_REQUEST['email'])) {
				  $email = $_REQUEST['email'];
					if (!filter_var($email, FILTER_VALIDATE_EMAIL)){
						$errors[] = 'Invalid email format';}
			  }else {$errors[] = 'You forgot to enter your email address.';}
			}	
			if (isset($_REQUEST['submitted'])){
			  if (empty($errors)){ 
			  $headers="From: $email";
			  $to="kvnsheu168@gmail.com";
			  $subject="Comment by $name @ leshadow.com";
			  $message=$_REQUEST['message'];
			  mail($to,$subject,$message,$headers);}
			}
			//Print Errors
		  if (isset($_REQUEST['submitted'])){
			  // Print any error messages. 
			  if (!empty($errors)){ 
				  echo '<hr /><h3>The following occurred:</h3><ul>'; 
				  // Print each error. 
				  foreach ($errors as $msg) {echo '<li>'. $msg . '</li>';}
				  echo '</ul><h3>Your message could not be sent due to input errors.</h3><hr />';
			  }else{echo '<hr /><h3 align="center">Your message was sent. Thank you!</h3><hr /><p>Below is the message that you sent.</p>'; 
			  	echo $message;
			  }
		  }
		?>
	</body>
</html>