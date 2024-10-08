function alertInfo(info) {
    syalert.syopen('alert2')
    $(".sy-title").html("温馨提示");
    $(".sy-content").html(info);
    $("#btn_Ok").text("确定");
}

function ok() {
    ok('alert2');
} 