$(document).ready(function () {
    $(".button").on('click', function () {
        changeZan();
    });
});
function changeZan() {
    var number = Number($(".zanNumber").html());
    if($(".zanImg").attr("data-zan-switch")=="off") {
        $(".zanImg").addClass("zan_on");
        $(".zanNumber").html(++number);
        $(".zanImg").attr("data-zan-switch", "on");
    } else {
        $(".zanImg").removeClass("zan_on")
        $(".zanNumber").html(--number);
        $(".zanImg").attr("data-zan-switch", "off");
    }
}