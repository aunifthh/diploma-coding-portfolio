<?php
/* include db connection file */
include("dbconn.php");

// Debugging: Output received data
echo "Received Data: ";
print_r($_POST); // Print the entire POST array

// Helper function to check and clean input data
function get_post_value($key) {
    return isset($_POST[$key]) ? trim($_POST[$key]) : null;
}

// Get and clean input data
$eventTitle = get_post_value('eventTitle');
$eventDesc = get_post_value('eventDesc');
$eventDate = get_post_value('eventDate');

// Check if all required fields are provided
if ($eventTitle && $eventDesc && $eventDate) {
    // Prepare the SQL statement with placeholders
    $stmt = $dbconn->prepare("INSERT INTO event (eventTitle, eventDesc, eventDate) VALUES (?, ?, ?)");
    if ($stmt) {
        // Bind parameters to the placeholders
        $stmt->bind_param("sss", $eventTitle, $eventDesc, $eventDate);
        
        // Execute the statement and check for success
        if ($stmt->execute()) {
            echo "Data has been saved";
        } else {
            echo "Error: " . $stmt->error;
        }
        
        // Close the statement
        $stmt->close();
    } else {
        echo "Error: " . $dbconn->error;
    }
} else {
    echo "Required fields are missing or empty";
}

// Close the database connection
mysqli_close($dbconn);
?>
