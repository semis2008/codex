$(function () {
    var login = avalon.define({
        $id: "login",
        username: null,
        password: null,
        errorMsg: null,
        hasError: false,
        submit: function () {
            login.hasError = false;
            if (login.username == null || login.password == null || login.username == "" || login.password == "") {
                login.errorMsg="username or password can't be null!";
                login.hasError = true;
                return;
            }
            var req = {
                userName: login.username,
                passWord: login.password
            }
            $.ajax({
                url: "loginPost",
                type: "post",
                contentType: "application/json",
                dataType: "json",
                data: JSON.stringify(req),
                success: function (data) {
                    if (data.retcode == 0) {
                        window.location.href = "index";
                    } else {
                        login.hasError = true;
                        login.errorMsg = data.retdesc;
                    }
                }
            })
        }
    });
    avalon.scan();
})