function readyHome() {
    $.ajax({ url: "api/userInfo.do",
        method:"GET",
        success: function(dtt){
            if (dtt.status == "true"){
                $("#userInfo_image").prop("src",dtt.image);
                $("#userInfo_name").text(dtt.name);
            }else {
                alert(dtt.message);
            }
        }});
}