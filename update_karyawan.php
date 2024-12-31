<?php
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $karyawan = json_decode($_POST['karyawan']);

    $nik = $karyawan->nik;
    $name = $karyawan->name;
    $email = $karyawan->email;

    // Connection to MySQL database
    $conn = new mysqli("localhost", "root", "", "my_db");

    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    }

    $sql = "UPDATE karyawan SET name='$name', email='$email' WHERE nik='$nik'";

    if ($conn->query($sql) === TRUE) {
        echo "Karyawan updated successfully";
    } else {
        echo "Error: " . $sql . "<br>" . $conn->error;
    }

    $conn->close();
}
?>
