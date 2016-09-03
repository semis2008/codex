$(function () {
    var index = avalon.define({
        $id: "index",
        setBG: function (bg) {
            $("body").attr("class",bg);
        }
    });
    avalon.scan();
})