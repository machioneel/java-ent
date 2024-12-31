<?php
// Connection to MySQL database
$conn = new mysqli("localhost", "root", "", "my_db");

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$sql = "SELECT * FROM karyawan";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    $karyawanArray = array();

    while ($row = $result->fetch_assoc()) {
        $karyawanItem = array(
            'nik' => $row['nik'],
            'name' => $row['name'],
            'email' => $row['email']
        );

        array_push($karyawanArray, $karyawanItem);
    }

    echo json_encode($karyawanArray);
} else {
    echo "No karyawan found";
}

$conn->close();
?>
