$(function () {
    queryList(1);


});

function queryList(page) {

    $.post("/jy/wt/queryList.html", {"page": page,"limit" : 6}, function (data) {

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

function addWordTextGo(){
    //
    layer.open({
        type: 2,
        title: 'Hx',
        shadeClose: true,
        shade: false,
        maxmin: true, //开启最大化最小化按钮
        area: ['360px', '600px'],
        content: '/jy/addWordText.html'
        ,btn: ['今日打卡', '没话可写'] //只是为了演示
        ,yes: function(index){
       // $(that).click(); //此处只是为了演示，实际使用可以剔除
            var body = layer.getChildFrame('body', index);//通过该对象可以获取iframe中的dom元素
            var username=body.find("#username").val();
            var wordTitle=body.find("#wordTitle").val();
            var wordContent=body.find("#wordContent").val();
            $.post("/jy/wt/insertWordText.json",{"username":username,"wordtitle":wordTitle,"wordcontent":wordContent},function(result){
                if(result.status==200){
                    layer.alert(""+result.message+"", {
                        skin: 'layui-layer-lan' //样式类名
                        ,closeBtn: 0
                    },function () {
                        queryList(1);
                        layer.closeAll();
                    });
                }else{
                    layer.alert(""+result.message+"", {
                        skin: 'layui-layer-lan' //样式类名
                        ,closeBtn: 0
                    });
                }
            });
    }
        ,btn2: function(){
        layer.close();
    }
    });
}
layui.use(['laypage', 'layer'], function () {
    var laypage = layui.laypage
        , layer = layui.layer;


    $.post("/jy/wt/queryListCount.json", function (data) {


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
