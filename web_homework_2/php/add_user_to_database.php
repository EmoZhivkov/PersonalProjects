<?php

include "./database.php";
include "./user.php";

function test_input($data) {
    $data = trim($data);
    $data = stripslashes($data);
    $data = htmlspecialchars($data);
    return $data;
}

function add_user_to_database(){
    global $HOST, $DB_NAME, $USERNAME, $PASSWORD;

    if ($_SERVER["REQUEST_METHOD"] != "POST") {
        return;
    }

    $err = false;

    $first_name = test_input($_POST["first_name"]);
    if (!preg_match("/^[a-zA-Z]+$/", $first_name)) {
        echo "The first name should not be blank and should not contain any numbers or special symbols.</br>";
        $err = true;
    }

    $second_name = test_input($_POST["second_name"]);
    if (!preg_match("/^[a-zA-Z]+$/", $second_name)) {
        echo "The second name should not be blank and should not contain any numbers or special symbols.</br>";
        $err = true;
    }

    $course_year = test_input($_POST["course_year"]);
    if (($course_year != "") && (!preg_match("/^[0-9]+$/", $course_year))) {
        echo "The course year should contain numeric values only.</br>";
        $err = true;
    }

    if (strlen($course_year) != 4) {
        echo "Course year must be 4 digits.</br>";
        $err = true;
    }

    $current_year = date("Y");
    if ($course_year > $current_year) {
        echo "Course year cannot be bigger than the current year.</br>";
        $err = true;
    }

    $course_name = test_input($_POST["course_name"]);
    if (!preg_match("/^[a-zA-Z]+$/", $course_name)) {
        echo "The course name should not be blank and should not contain any numbers or special symbols.</br>";
        $err = true;
    }

    $fn = test_input($_POST["fn"]);
    if (($fn != "") && (!preg_match("/^[0-9]+$/", $fn))) {
        echo "Please Enter Numeric Values Only.</br>";
        $err = true;
    } else if ($fn[0] == "0") {
        echo "The faculty number cannot start with a 0.</br>";
        $err = true;
    }

    if ($err) {
        echo "Did not fill out form correctly.";
        die();
    }

    $user = new User();
    $user->first_name = $first_name;
    $user->second_name = $second_name;
    $user->course_year = $course_year;
    $user->course_name = $course_name;
    $user->fn = $fn;

    $database = new Database($HOST, $DB_NAME, $USERNAME, $PASSWORD);
    $database->add_user($user);
}

add_user_to_database()
?>