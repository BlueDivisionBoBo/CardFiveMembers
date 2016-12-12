function ajax(jsom,callBack) {
    $.ajax({
        url: jsom.url,
        method: jsom.method,
        data: jsom.data,
        success: function (dtt) {
            callBack(dtt);
        },
        error:function () {
            alert("网络异常");
        }
    });
}