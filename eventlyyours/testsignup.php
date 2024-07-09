<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Test Signup Form</title>
</head>
<body>
    <form action="signup.php" method="post">
        <label for="userName">Username:</label>
        <input type="text" id="userName" name="userName"><br><br>
        <label for="userFname">First Name:</label>
        <input type="text" id="userFname" name="userFname"><br><br>
        <label for="userLname">Last Name:</label>
        <input type="text" id="userLname" name="userLname"><br><br>
        <label for="userPassword">Password:</label>
        <input type="password" id="userPassword" name="userPassword"><br><br>
        <label for="confirmPassword">Confirm Password:</label>
        <input type="password" id="confirmPassword" name="confirmPassword"><br><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
