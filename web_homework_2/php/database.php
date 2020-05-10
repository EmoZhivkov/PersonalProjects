<?php

$HOST = "localhost";
$DB_NAME = "62215_Emil_Zhivkov";
$USERNAME = "root";
$PASSWORD = "123456";

class Database {
    private $conn;

    function __construct($host, $db, $username, $pass) {
        try {
            $this->conn = new PDO("mysql:host=$host;dbname=$db;charset=utf8", $username, $pass);
        } catch (PDOException $e) {
            echo "Error: " . $e->getMessage();
        }
    }

    function add_user($user) {
        try {
            $sql = "INSERT INTO Users (first_name, second_name) VALUES (:first_name, :second_name)";
            $stmt = $this->conn->prepare($sql) or die("SQL statement failed");

            $stmt->bindParam(':first_name', $user->first_name);
            $stmt->bindParam(':second_name', $user->second_name);

            $stmt->execute();
            echo "New records created successfully";
        } catch (PDOException $e) {
            echo "Error: " . $e->getMessage();
        }
    }
}

?>