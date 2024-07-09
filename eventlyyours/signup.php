<?php
include("dbconn.php");

// Enable error reporting
ini_set('display_errors', 1);
ini_set('display_startup_errors', 1);
error_reporting(E_ALL);

if (!$dbconn) {
    die("Connection failed: " . mysqli_connect_error());
}

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $userName = $_POST['userName'];
    $userFname = $_POST['userFname'];
    $userLname = $_POST['userLname'];
    $userPassword = $_POST['userPassword'];
    $confirmPassword = $_POST['confirmPassword'];

    echo "Received data: <br>";
    echo "Username: $userName<br>";
    echo "First Name: $userFname<br>";
    echo "Last Name: $userLname<br>";
    echo "Password: $userPassword<br>";
    echo "Confirm Password: $confirmPassword<br>";

    if ($userPassword != $confirmPassword) {
        echo "Passwords do not match";
        exit;
    }

    // Check if username already exists
    $stmt = $dbconn->prepare("SELECT * FROM user WHERE userName = ?");
    if ($stmt === false) {
        die("Prepare failed: " . htmlspecialchars($dbconn->error));
    }

    $stmt->bind_param("s", $userName);
    if (!$stmt->execute()) {
        die("Execute failed: " . htmlspecialchars($stmt->error));
    }

    $result = $stmt->get_result();
    if ($result === false) {
        die("Get result failed: " . htmlspecialchars($stmt->error));
    }

    if ($result->num_rows > 0) {
        echo "Data is already in db";
    } else {
        // Insert new user data
        $stmt = $dbconn->prepare("INSERT INTO user (userName, userFname, userLname, userPassword) VALUES (?, ?, ?, ?)");
        if ($stmt === false) {
            die("Prepare failed: " . htmlspecialchars($dbconn->error));
        }

        $stmt->bind_param("ssss", $userName, $userFname, $userLname, $userPassword);
        if (!$stmt->execute()) {
            die("Execute failed: " . htmlspecialchars($stmt->error));
        } else {
            echo "Data has been saved successfully.";
        }
    }

    $stmt->close();
}

$dbconn->close();
?>
