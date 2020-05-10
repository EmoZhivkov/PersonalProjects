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
            $sql = "INSERT INTO Users (first_name, second_name, course_year, course_name, fn, group_number, birth_date, zodiac_sign, link, motivation) VALUES (:first_name, :second_name, :course_year, :course_name, :fn, :group_number, :birth_date, :zodiac_sign, :link, :motivation)";
            $stmt = $this->conn->prepare($sql) or die("SQL statement failed");

            $stmt->bindParam(':first_name', $user->first_name);
            $stmt->bindParam(':second_name', $user->second_name);
            $stmt->bindParam(':course_year', $user->course_year);
            $stmt->bindParam(':course_name', $user->course_name);
            $stmt->bindParam(':fn', $user->fn);
            $stmt->bindParam(':group_number', $user->group_number);
            $stmt->bindParam(':birth_date', $user->birth_date);
            $stmt->bindParam(':zodiac_sign', $user->zodiac_sign);
            $stmt->bindParam(':link', $user->link);
            $stmt->bindParam(':motivation', $user->motivation);

            $stmt->execute();
            echo "New records created successfully";
        } catch (PDOException $e) {
            echo "Error: " . $e->getMessage();
        }
    }
}

?>