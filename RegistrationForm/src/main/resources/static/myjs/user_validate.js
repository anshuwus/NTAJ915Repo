 $(document).ready(function () {debugger
  
        //1. hide error section
        $("#mobileError").hide();
        $("#nameError").hide();
        $("#emailError").hide();
        $("#passwordError").hide();

        //2. define error variable
        var mobileError = false;
        var nameError = false;
        var emailError = false;
        var passwordError = false;

        //3. validate function
        function validate_mobile() {
          var val = $("#mobile").val();
          var exp = /^(0|91)?[6-9][0-9]{9}$/;
          if (val == "") {
            $("#mobileError").show();
            $("#mobileError").html("*Please enter valid 10 digit mobile no.");
            $("#mobileError").css("color", "red");
            mobileError = false;
          } else if (!exp.test(val)) {
            $("#mobileError").show();
            $("#mobileError").html("*Please enter valid 10 digit mobile no.");
            $("#mobileError").css("color", "red");
            mobileError = false;
          } else {
            $("#mobileError").hide();
            mobileError = true;
          }

          return mobileError;
        }

        function validate_name() {
          var val = $("#name").val();
          var exp = /^[A-Za-z\s]{3,60}$/;
          if (val == "") {
            $("#nameError").show();
            $("#nameError").html("*Please enter your name");
            $("#nameError").css("color", "red");
            nameError = false;
          } else if (!exp.test(val)) {
            $("#nameError").show();
            $("#nameError").html("*Please enter your name");
            $("#nameError").css("color", "red");
            nameError = false;
          } else {
            $("#nameError").hide();
            nameError = true;
          }

          return nameError;
        }

        function validate_email() {
          var val = $("#email").val();
          var exp = /^([a-zA-Z0-9_\.\-\+])+\@gmail.com+$/;
          if (val == "") {
            $("#emailError").show();
            $("#emailError").html("*Please enter your email id");
            $("#emailError").css("color", "red");
            emailError = false;
          } else if (!exp.test(val)) {
            $("#emailError").show();
            $("#emailError").html("*Please enter your valid email id");
            $("#emailError").css("color", "red");
            emailError = false;
          } else {
            $("#emailError").hide();
            emailError = true;
          }

          return emailError;
        }

        function validate_password() {
          //validation code here
          var val = $("#password").val();

          var exp = /^[A-Za-z0-9\_\.\@\$]{8,12}$/;
          if (val === "") {
            $("#passwordError").show();
            $("#passwordError").html("*Please Enter password");
            $("#passwordError").css("color", "red");
            passwordError = false;
          } else if (!exp.test(val)) {
            $("#passwordError").show();
            $("#passwordError").html(
              "*Password must be 8 characters long"
            );
            $("#passwordError").css("color", "red");
            passwordError = false;
          } else {
            $("#passwordError").hide();
            passwordError = true;
          }
          return passwordError;
        }

        //4. link action event
        $("#mobile").keyup(function () {
          validate_mobile();
        });

        $("#name").keyup(function () {
          validate_name();
        });

        $("#email").keyup(function () {
          validate_email();
        });

        $("#password").keyup(function () {
          validate_password();
        });

        //5. On submit
        $("#userForm").submit(function () {
          validate_email();
          validate_mobile();
          validate_name();
          validate_password();
          if (mobileError && nameError && emailError && passwordError)
            return true;
          else return false;
        });
      });