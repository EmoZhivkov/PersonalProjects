<?php

include "./database.php";
include "./user.php";

function add_user_to_database(){
    global $HOST, $DB_NAME, $USERNAME, $PASSWORD;

    if ($_SERVER["REQUEST_METHOD"] != "POST") {
        return;
    }

    $first_name = $_POST["first_name"];

    $user = new User($first_name);

    $database = new Database($HOST, $DB_NAME, $USERNAME, $PASSWORD);
    $database->add_user($user);
}

add_user_to_database()
?>