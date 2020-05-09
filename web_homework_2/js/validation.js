function print_error(elemId, hintMsg) {
    document.getElementById(elemId).innerHTML = hintMsg;
}

// Defining a function to validate form
function validate_form() {
    // Retrieving the values of form elements
    var first_name = document.user_form.first_name.value;

    if (first_name === "") {
        print_error('first_name_err', 'The given name should not be blank!')
        return false;
    }
    return true;
}