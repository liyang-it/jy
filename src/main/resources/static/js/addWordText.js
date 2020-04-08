
layui.use(['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element', 'slider'], function(){
    var layer = layui.layer //弹层
        , form = layui.form
        ,layer = layui.layer
        ,layedit = layui.layedit
        ,laydate = layui.laydate
        ,carousel = layui.carousel //轮播
    //向世界问个好
    //layer.msg('Hello World');
    getName();
    //执行一个轮播实例
    carousel.render({
        elem: '#test1'
        ,width: '100%' //设置容器宽度
        ,height: 200
        ,arrow: 'always' //不显示箭头
        ,anim: 'fade' //切换动画方式

    });
    //底部信息
    var footerTpl = lay('#footer')[0].innerHTML;
    lay('#footer').html(layui.laytpl(footerTpl).render({}))
        .removeClass('layui-hide');
});
$(function(){
    var player = polyvObject('#f840f68b2e283c8122bc415a2ae59fee_f').videoPlayer({
        'width':'100%',
        'height':'250',
        'vid' : 'f840f68b2e283c8122bc415a2ae59fee_f' ,
        'forceH5':true,
        'loop': true,
        'speed': false,
        'autoplay': true

    });

    $("#button-addon2").click(function(){
        getName();
    });


});
function getName(){
    $.get("/jy/wt/getRandomName.json",function(data){
        $("#username").val(data);
    });

}
