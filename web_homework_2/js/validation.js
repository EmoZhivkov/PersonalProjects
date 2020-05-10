function change_zodiac_sign() {
    var birth_date = document.user_form.birth_date.value;

    var date = new Date(birth_date);
    var month = date.getMonth() + 1;
    var day = date.getDay();

    var zodiac_sign = '';
    if ((month == 1 && day <= 20) || (month == 12 && day >= 22)) {
        zodiac_sign = 'capricorn';
    } else if ((month == 1 && day >= 21) || (month == 2 && day <= 18)) {
        zodiac_sign = 'aquarius';
    } else if ((month == 2 && day >= 19) || (month == 3 && day <= 20)) {
        zodiac_sign = 'pisces';
    } else if ((month == 3 && day >= 21) || (month == 4 && day <= 20)) {
        zodiac_sign = 'aries';
    } else if ((month == 4 && day >= 21) || (month == 5 && day <= 20)) {
        zodiac_sign = 'taurus';
    } else if ((month == 5 && day >= 21) || (month == 6 && day <= 20)) {
        zodiac_sign = 'gemini';
    } else if ((month == 6 && day >= 22) || (month == 7 && day <= 22)) {
        zodiac_sign = 'cancer';
    } else if ((month == 7 && day >= 23) || (month == 8 && day <= 23)) {
        zodiac_sign = 'leo';
    } else if ((month == 8 && day >= 24) || (month == 9 && day <= 23)) {
        zodiac_sign = 'virgo';
    } else if ((month == 9 && day >= 24) || (month == 10 && day <= 23)) {
        zodiac_sign = 'libra';
    } else if ((month == 10 && day >= 24) || (month == 11 && day <= 22)) {
        zodiac_sign = 'scorpio';
    } else if ((month == 11 && day >= 23) || (month == 12 && day <= 21)) {
        zodiac_sign = 'sagittarius';
    }

    var element = document.getElementById('zodiac_sign_display');
    element.innerHTML = zodiac_sign;

    document.user_form.zodiac_sign.value = zodiac_sign;

    return true;
}

function validate_image() {
    var file = document.getElementById("picture").files[0];

    var t = file.type.split('/').pop().toLowerCase();
    if (t != "jpeg" && t != "jpg" && t != "png"  && t != "gif") {
        print_error('picture_err', 'Please select a valid image file!');
        document.getElementById("picture").value = '';
        return false;
    }
    if (file.size > 1024000) {
        print_error('picture_err', 'The picture is too large. Max Upload size is 1MB.');
        document.getElementById("picture").value = '';
        return false;
    }
    return true;
}

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
        var regex = /[\p{L}]+/u;

        if (regex.test(first_name) === false) {
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
        var regex = /[\p{L}]+/u;

        if (regex.test(second_name) === false) {
            print_error("second_name_err", "Please enter a valid second name!");
            is_correct = false;
        } else {
            print_error("second_name_err", "");
        }
    }

    var course_year = document.user_form.course_year.value;
    var regex = /^[1-9][0-9]*$/;
    if ((course_year == "") || (!regex.test(course_year))) {
        print_error("course_year_err", "Please Enter Numeric Values Only bigger than 0.");
        is_correct = false;
    } else {
        print_error("course_year_err", "");
    }

    var course_name = document.user_form.course_name.value;
    if (course_name == "") {
        print_error('course_name_err', 'The given course name should not be blank!');
        is_correct = false;
    } else {
        var regex = /[\p{L}]+/u;

        if (regex.test(course_name) === false) {
            print_error("course_name_err", "Please enter a valid course name!");
            is_correct = false;
        } else {
            print_error("course_name_err", "");
        }
    }

    var fn = document.user_form.fn.value;
    var regex = /^[1-9][0-9]*$/;
    if ((fn == "") || (!regex.test(fn))) {
        print_error("fn_err", "Please Enter Numeric Values bigger than 0");
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

    var birth_date = document.user_form.birth_date.value;
    var date = new Date(birth_date);
    var today = new Date();
    if (date > today) {
        print_error("birth_date_err", "Birth date cannot be bigger than the current date.");
        is_correct = false;
    } else {
        print_error("birth_date_err", "");
    }

    var link = document.user_form.link.value;
    var regex = /https?:\/\/(?:www\.|(?!www))[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\.[^\s]{2,}|www\.[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\.[^\s]{2,}|https?:\/\/(?:www\.|(?!www))[a-zA-Z0-9]+\.[^\s]{2,}|www\.[a-zA-Z0-9]+\.[^\s]{2,}/;
    if ((link == "") || (!regex.test(link))) {
        print_error("link_err", "Invalid link address.");
        is_correct = false;
    } else {
        print_error("link_err", "");
    }

    var motivation = document.user_form.motivation.value;
    if (motivation == "") {
        print_error("motivation_err", "Motivation cannot be blank.");
        is_correct = false;
    } else {
        print_error("link_err", "");
    }

    return is_correct;
}