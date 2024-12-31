<?php
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $nik = $_POST['nik'];

    // Connection to MySQL database
    $conn = new mysqli("localhost", "root", "", "my_db");

    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    }

    $sql = "DELETE FROM karyawan WHERE nik='$nik'";

    if ($conn->query($sql) === TRUE) {
        echo "Karyawan deleted successfully";
    } else {
        echo "Error: " . $sql . "<br>" . $conn->error;
    }

    $conn->close();
}
?>
