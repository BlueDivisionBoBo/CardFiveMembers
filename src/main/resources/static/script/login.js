function loginIn() {
    var name = $("#username").val();
    var password = $("#password").val();
    if (name == null || "" == name.trim() || password == null || "" == password.trim()) {
        alert("用户名或密码..不能为空");
    }
    var data = {};
    data.name = name;
    data.password = password;
    data.date = new Date().getTime();
    PPn(data, loginAjax);
}

function PPn(data, callback) {
    $.ajax({
        url: "api//ppn",
        method: "GET",
        data: data,
        success: function (dtt) {
            if (dtt.status == "true") {
                //window.location.href = 'index.do';
                var hexStr = hex_md5(data.password);
                if (hexStr != null) {
                    data.password = hexStr.substr(0, dtt.ppnSub) + dtt.ppn + hexStr.substr(dtt.ppnSub, hexStr.length);
                    callback(data);
                } else {
                    //alert("系统异常");
                    $(".errorInfo").text("系统异常");
                }

            } else {
                // alert(dtt.message);
                $(".errorInfo").text(dtt.message);
            }
        }
    });
}

function loginAjax(data) {
    $.ajax({
        url: "api/user/login",
        method: "GET",
        data: data,
        success: function (dat) {
            if (dat.status == "true") {
                window.location.href = 'index.do';
            } else {
                //alert(dat.message);
                $(".errorInfo").text(dat.message);
            }
        }
    });
}


//input 输入框聚焦 失焦事件
function iptfoucs() {
    $("#username").on({
        'blur': function () {
            var tx = $(this).val();
            if(tx ==''){$(this).val("用户名")};
        },
        'focus':function () {
            $(this).val("");
            $(".errorInfo").text('');
        }
    });

    $("#password").on({
        'blur': function () {
            var tx = $(this).val();
            if(tx ==''){$(this).val("密码")};
        },
        'focus':function () {
            $(this).val("");
            $(".errorInfo").text('');
        }
    })

}

//获取验证码
$("#getValidcode").on("click",function(){
    var $this = $(this);
    var time = 60;
    var interval = setInterval(function(){
        if(--time){
            $this.attr("disabled","disabled");
            $this.val(time+"秒");
        }else{
            clearInterval(interval);
            $this.removeAttr("disabled");
            $this.val("重新获取");
        }
    },1000);
});

$(function(){
    iptfoucs();

})