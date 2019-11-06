$(function () {
    queryList(1);


});

function queryList(page) {

    $.post("/wt/queryList.html", {"page": page}, function (data) {

        for (var i = 0; i < data.length; i++) {

            $("#pushDate" + (i + 1)).html(data[i].createdtime);
            $("#title" + (i + 1)).html(data[i].wordtitle);
            $("#name" + (i + 1)).html(data[i].username);
            $("#content" + (i + 1)).html(data[i].wordcontent);

        }
    })

}
function video_music(){
    layer.alert('见到你真的很高兴,接口正在写！', {icon: 6});
}
function vedio(){
    //iframe窗

    layer.open({
        type: 2,
        title: 'Hx',
        shadeClose: true,
        shade: false,
        maxmin: true, //开启最大化最小化按钮
        area: ['auto', '600px'],
        content: '/resourceHtml.html'
    });

}
layui.use(['laypage', 'layer'], function () {
    var laypage = layui.laypage
        , layer = layui.layer;


    $.post("/wt/queryListCount.json", function (data) {


        laypage.render({
            elem: 'demo2'
            , count: data
            , layout: ['prev', 'next']
            , jump: function (obj, first) {
                if (!first) {
                    window.location.href = "#about";
                    layer.msg('第 ' + obj.curr + ' 页');
                    queryList(obj.curr);

                }
            }
        });


    });


});
