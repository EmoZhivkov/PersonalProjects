function print_error(elemId, hintMsg) {
    document.getElementById(elemId).innerHTML = hintMsg;
}

// Defining a function to validate form
function validate_form() {
    // Retrieving the values of form elements
    var first_name = document.user_form.first_name.value;
    if (first_name == "") {
        print_error('first_name_err', 'The given name should not be blank!');
        return false;
    } else {
        var regex = /^[a-zA-Z\s]+$/;

        if(regex.test(first_name) === false) {
            print_error("first_name_err", "Please enter a valid first name!");
            return false;
        } else {
            print_error("first_name_err", "");
        }
    }

    var second_name = document.user_form.second_name.value;
    if (second_name == "") {
        print_error('second_name_err', 'The given name should not be blank!');
        return false;
    } else {
        var regex = /^[a-zA-Z\s]+$/;

        if(regex.test(second_name) === false) {
            print_error("second_name_err", "Please enter a valid second name!");
            return false;
        } else {
            print_error("second_name_err", "");
        }
    }

    return true;
}