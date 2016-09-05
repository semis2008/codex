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
            if(regist.username.length<4) {
                regist.errorMsg="username is too short!";
                regist.hasError = true;
                return;
            }
            if(regist.password!=regist.passwordConf) {
                regist.errorMsg="Please enter the same password again!";
                regist.hasError = true;
                return;
            }
            if(regist.password!=regist.passwordConf) {
                regist.errorMsg="Please enter the same password again!";
                regist.hasError = true;
                return;
            }
            var phoneReg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
            if(!phoneReg.test(regist.phone))
            {
                regist.errorMsg="Please enter the correct phone!";
                regist.hasError = true;
                return;return false;
            }
            var req = {
                userName: regist.username,
                passWord: regist.password,
                phone:regist.phone
            }
            $.ajax({
                url: "registSubmit",
                type: "post",
                contentType: "application/json",
                dataType: "json",
                data: JSON.stringify(req),
                success: function (data) {
                    if (data.retcode == 0) {
                        window.location.href = "login";
                    } else {
                        regist.hasError = true;
                        regist.errorMsg = data.retdesc;
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
