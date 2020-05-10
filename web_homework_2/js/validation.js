function print_error(elemId, hintMsg) {
    document.getElementById(elemId).innerHTML = hintMsg;
}

// Defining a function to validate form
function validate_form() {
    // Retrieving the values of form elements
    var is_correct = true;

    var first_name = document.user_form.first_name.value;
    if (first_name == "") {
        print_error('first_name_err', 'The given name should not be blank!');
        is_correct = false;
    } else {
        var regex = /^[a-zA-Z\s]+$/;

        if(regex.test(first_name) === false) {
            print_error("first_name_err", "Please enter a valid first name!");
            is_correct = false;
        } else {
            print_error("first_name_err", "");
        }
    }

    var second_name = document.user_form.second_name.value;
    if (second_name == "") {
        print_error('second_name_err', 'The given name should not be blank!');
        is_correct = false;
    } else {
        var regex = /^[a-zA-Z\s]+$/;

        if(regex.test(second_name) === false) {
            print_error("second_name_err", "Please enter a valid second name!");
            is_correct = false;
        } else {
            print_error("second_name_err", "");
        }
    }

    var course_year = document.user_form.course_year.value;
    var current_year=new Date().getFullYear();
    var regex = /^[0-9]+$/;

    if ((course_year == "") || (!regex.test(course_year))) {
        print_error("course_year_err", "Please Enter Numeric Values Only bigger than 0.");
        is_correct = false;
    } else if (course_year.length != 4) {
        print_error("course_year_err", "Course year must be 4 digits.");
        is_correct = false;
    } else if (course_year > current_year) {
        print_error("course_year_err", "Course year cannot be bigger than the current year.");
        is_correct = false;
    } else {
        print_error("course_year_err", "");
    }

    var course_name = document.user_form.course_name.value;
    if (course_name == "") {
        print_error('course_name_err', 'The given course name should not be blank!');
        is_correct = false;
    } else {
        var regex = /^[a-zA-Z\s]+$/;

        if(regex.test(course_name) === false) {
            print_error("course_name_err", "Please enter a valid course name!");
            is_correct = false;
        } else {
            print_error("course_name_err", "");
        }
    }

    var fn = document.user_form.fn.value;
    var regex = /^[0-9]+$/;
    if ((fn == "") || (!regex.test(fn))) {
        print_error("fn_err", "Please Enter Numeric Values Only bigger than 0");
        is_correct = false;
    } else if (fn.charAt(0) == "0") {
        print_error("fn_err", "The faculty number cannot start with a 0");
        is_correct = false;
    } else {
        print_error("fn_err", "");
    }

    var group_number = document.user_form.group_number.value;
    var regex = /^[1-9][0-9]*$/;
    if ((group_number == "") || (!regex.test(group_number))) {
        print_error("group_number_err", "Please Enter Numeric Values bigger than 0.");
        is_correct = false;
    } else {
        print_error("group_number_err", "");
    }

    return is_correct;
}