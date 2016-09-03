$(function () {
    var regist = avalon.define({
        $id: "regist",
        username: null,
        password: null,
        passwordConf:null,
        phone:null,
        errorMsg: null,
        hasError: false,
        submit: function () {
            regist.hasError = false;
            if (isNull(regist.username)|| isNull(regist.password)|| isNull(regist.passwordConf)||isNull(regist.phone)) {
                regist.errorMsg="Input can't be null!";
                regist.hasError = true;
                return;
            }
            var req = {
                userName: regist.username,
                passWord: regist.password
            }
            $.ajax({
                url: "registUser",
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

function isNull(str) {
    return str == null || str == "";
}
