<?php
$host = "localhost";
$user = "root";
$pass = "";
$dbname = "eventlyours";

$dbconn = mysqli_connect($host, $user, $pass, $dbname);

if (!$dbconn) {
    die("Connection failed: " . mysqli_connect_error());
}
?>


