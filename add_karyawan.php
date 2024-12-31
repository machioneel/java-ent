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

    $sql = "INSERT INTO karyawan (nik, name, email) VALUES ('$nik', '$name', '$email')";

    if ($conn->query($sql) === TRUE) {
        echo "Karyawan added successfully";
    } else {
        echo "Error: " . $sql . "<br>" . $conn->error;
    }

    $conn->close();
}
?>
