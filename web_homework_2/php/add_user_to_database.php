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
    if (!preg_match("/^[a-zA-Z ]+$/", $first_name)) {
        echo "The first name should not be blank and should not contain any numbers or special symbols.</br>";
        $err = true;
    }

    $second_name = test_input($_POST["second_name"]);
    if (!preg_match("/^[a-zA-Z ]+$/", $second_name)) {
        echo "The second name should not be blank and should not contain any numbers or special symbols.</br>";
        $err = true;
    }

    if ($err) {
        echo "Did not fill out form correctly.";
        die();
    }

    $user = new User();
    $user->first_name = $first_name;
    $user->second_name = $second_name;

    $database = new Database($HOST, $DB_NAME, $USERNAME, $PASSWORD);
    $database->add_user($user);
}

add_user_to_database()
?>