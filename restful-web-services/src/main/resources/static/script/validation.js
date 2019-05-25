$(function() {

    $("#firstname_error_message").hide();


    var error_firstname = false;


    $("#form_firstname").focusout(function() {

        check_firstname();

    });



    function check_firstname() {

        var firstname_length = $("#form_firstname").val().length;

        if(firstname_length < 5 || firstname_length > 20) {
            $("#firstname_error_message").html("Should be between 5-20 characters");
            $("#firstname_error_message").show();
            error_firstname = true;
        } else {
            $("#firstname_error_message").hide();
        }

    }










});



