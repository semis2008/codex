$(function () {
    var index = avalon.define({
        $id: "index",
        setBG: function (bg) {
            $("body").attr("class",bg);
        },
        logout:function(){
            $.ajax({
                url: "logout",
                type: "post",
                contentType: "application/json",
                dataType: "json",
                success: function () {
                    window.location.href = "login";
                }
            })
        }
    });
    avalon.scan();
})