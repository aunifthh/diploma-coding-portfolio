<?php
include("dbconn.php");

$userName=$_POST['userName'];
$userPassword=$_POST['userPassword'];

$cek_data=mysqli_query($dbconn, "SELECT * from user where userName = '$userName' and userPassword = '$userPassword'");
$cek = mysqli_num_rows($cek_data);

if ($cek>0){
	echo "Login successfully.";
} else {
	echo "Login unsuccessfully, try again.";
}
?>
