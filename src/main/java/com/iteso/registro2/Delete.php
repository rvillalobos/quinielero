<!doctype html>
<html>
<head>
    <title>Delete</title>
</head>
<body>
<h3>Delete Form</h3>
<form action="" method="POST">
    Put your username again to confirm: <input type="text" name="user"><br />
    <input type="submit" value="Delete" name="submit" />

</form>
<?php
if(isset($_POST["submit"])){

    if(!empty($_POST['user'])) {
        $user=$_POST['user'];

        $con=mysql_connect('localhost','root','') or die(mysql_error());
        mysql_select_db('user_registration') or die("cannot select DB");

        $query=mysql_query("SELECT * FROM login WHERE username='".$user."'");
        $numrows=mysql_num_rows($query);
        if($numrows==1)
        {
            $sql="DELETE FROM login WHERE username='".$user."'";
            $result=mysql_query($sql);


            if($result){
                echo "Account Successfully Deleted";
                header("Location: register.php");

            } else {
                echo "Failure deleting account!";
            }
        }
        else
            echo "Failure deleting account!";
    }
    else
        echo "Failure deleting account!";
}
?>

</body>
</html>