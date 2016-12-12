$(function () {
    navClickEvent();
    ajax({url: "api/userInfo.do", method: "GET", data: ""}, readyHome); // 加载用户信息
})

$(window).on('resize', function () {
    if ($(window).width() > 768) $('#sidebar-collapse').collapse('show');
    if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
})

//   左侧导航点击事件
function navClickEvent() {
    $(".menu li").on("click", function () {
        $(this).addClass('active').siblings().removeClass('active');
        var data_class = $(this).attr("data-class");
        if (data_class == "") {
            window.location.href = '/'
        } else {
            $(".maintent").css("display", "none");
            $("." + data_class).css("display", "block");
        }

    })
}


function readyHome(data) {
    if (data.status == "true") {
        $("#userInfo_image").prop("src", data['message'].image);
        $("#userInfo_name").text(data['message'].name);
    } else {
        alert(data.message);
    }
}