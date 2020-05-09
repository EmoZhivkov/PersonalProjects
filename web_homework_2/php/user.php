<?php

class User {
    public $first_name;

    function __construct($first_name) {
        # TODO: Validate input
        $this->first_name = $first_name;
    }
}

?>