<?php
if(isset($_POST['submit'])) 
{

$message=
'Subject:	'.$_POST['subject'].'<br />
Email:	'.$_POST['emailid'].'<br />
Comments:	'.$_POST['comments'].'
';
    require "phpmailer/class.phpmailer.php"; //include phpmailer class
      
    // Instantiate Class  
    $mail = new PHPMailer();  
      
    // Set up SMTP  
    $mail->IsSMTP();                // Sets up a SMTP connection  
    $mail->SMTPAuth = true;         // Connection with the SMTP does require authorization    
    $mail->SMTPSecure = "ssl";      // Connect using a TLS connection  
    $mail->Host = "smtp.gmail.com";  //Gmail SMTP server address
    $mail->Port = 465;  //Gmail SMTP port
    $mail->Encoding = '7bit';
    
    // Authentication  
    $mail->Username   = "roysupremo@gmail.com"; // Your full Gmail address
    $mail->Password   = ""; // Your Gmail password
      
    // Compose
    $mail->SetFrom($_POST['emailid']);
    $mail->AddReplyTo($_POST['emailid']);
    $mail->Subject = "New Contact Form Enquiry";      // Subject (which isn't required)  
    $mail->MsgHTML($message);
 
    // Send To  
    $mail->AddAddress("roysupremo@gmail.com", "Recipient Name"); // Where to send it - Recipient
    $result = $mail->Send();		// Send!  
	$message = $result ? 'Successfully Sent!' : 'Sending Failed!';      
	unset($mail);

}
?>
<html>
<head>
  <title>Contact Form</title>
</head>
<body>
					
		<div style="margin: 100px auto 0;width: 300px;">
			<h3>Invite a Friend!</h3>
			<form name="form1" id="form1" action="" method="post">
					<fieldset>
					  <input type="text" name="subject" placeholder="Subject" value="Join my Quinielero!" />
					  <br />
					  <input type="text" name="emailid" placeholder="Email" />
					  <br />
					  <textarea rows="10" cols="30" name="comments" placeholder="Comments"></textarea>
					  <br />
					  <input type="submit" name="submit" value="Send" />
					</fieldset>
			</form>
			<p><?php if(!empty($message)) echo $message; ?></p>
		</div>
</body>
</html>