 $(document).ready(function () {debugger
      
        //1. hide error section
        $("#userRolesError").hide();
     
          //2. define error variable
        var userRolesError = false;
     
        //3. validate function
        function validate_userType() {debugger
          var val = $("#userRoles").val();
          var exp = /^[A-Za-z/-/s]{3,20}$/;
          if (val == "") {
            $("#userRolesError").show();
            $("#userRolesError").html("*Please enter roles for access our App services");
            $("#userRolesError").css("color", "red");
            userRolesError = false;
          } else if (!exp.test(val)) {
            $("#userRolesError").show();
            $("#userRolesError").html("*Please enter roles for access our App services");
            $("#userRolesError").css("color", "red");
            userRolesError = false;
          } else {
            $("#userRolesError").hide();
            userRolesError = true;
          }

          return userRolesError;
        }

        //4. link action event
        $("#userRoles").keyup(function () {debugger
          validate_userType();
        });

            //5. On submit
        $("#userTypeForm").submit(function () {
          validate_userType();
          if (userRolesError)
            return true;
          else return false;
        });
      });