
function loginIn(){
    var name =  $("#username").val();
    var password = $("#password").val();
    if(name== null || ""== name.trim() || password==null || ""==password.trim()){
        alert("用户名或密码..不能为空");
    }
    var data = {};
    data.name = name;
    data.password = password;
    data.date = new Date().getTime();
    PPn(data,loginAjax);
}

function PPn(data,callback) {
    $.ajax({ url: "api//ppn",
        method:"GET",
        data:data,
        success: function(dtt){
            if (dtt.status == "true"){
                //window.location.href = 'index.do';
                var hexStr = hex_md5(data.password);
                if (hexStr!=null){
                    data.password = hexStr.substr(0,dtt.ppnSub)+dtt.ppn+hexStr.substr(dtt.ppnSub,hexStr.length);
                    callback(data);
                }else {
                    alert("系统异常");
                }

            }else {
                alert(dtt.message);
            }
        }});
}

function loginAjax(data) {
    $.ajax({ url: "api/user/login",
        method:"GET",
        data:data,
        success: function(dat){
            if (dat.status == "true"){
                window.location.href = 'index.do';
            }else {
                alert(dat.message);
            }
        }});
}