$(function(){
    layer.msg('部分网站使用的是国外服务器！加载可能会缓慢', {icon: 1});
    //询问框

    $.get("/wt/getResource.json",function(result){
        var vedio="";
        var music="";
        var epub="";
        //循环影视
        $.each(result.vedio,function(index,value){

            vedio+="  <li class=layui-timeline-item\" onclick=\"hrefGo('"+value.linkAddres+"')\">\n" +
                "  <i class=\"layui-icon layui-timeline-axis\"></i>\n" +
                "   <div class=\"layui-timeline-content layui-text\"><h3 class=\"layui-timeline-title\"  style=\"color: #0C0C0C;text-decoration-color: #1da1f2;text-decoration: underline;\" >"+value.linkByname+"</h3>" +
                "<p  style=\"font-size: 12px;\">"+value.linkDescribe+"</p></div></li><hr style=\"size: 50px;;align-content: center; background-color: #1c7430;\">";

        });
        //循环music
        $.each(result.music,function(index,value){

            music+="  <li class=layui-timeline-item\" onclick=\"hrefGo('"+value.linkAddres+"')\">\n" +
                "  <i class=\"layui-icon layui-timeline-axis\"></i>\n" +
                "   <div class=\"layui-timeline-content layui-text\"><h3 class=\"layui-timeline-title\"  style=\"color: #0C0C0C;text-decoration-color: #1da1f2;text-decoration: underline;\" >"+value.linkByname+"</h3>" +
                "<p  style=\"font-size: 12px;\">"+value.linkDescribe+"</p></div></li><hr style=\"size: 50px;;align-content: center; background-color: #1c7430;\">";

        });
        //循环epub
        $.each(result.epub,function(index,value){

            epub+="  <li class=layui-timeline-item\" onclick=\"hrefGo('"+value.linkAddres+"')\">\n" +
                "  <i class=\"layui-icon layui-timeline-axis\"></i>\n" +
                "   <div class=\"layui-timeline-content layui-text\"><h3 class=\"layui-timeline-title\"  style=\"color: #0C0C0C;text-decoration-color: #1da1f2;text-decoration: underline;\" >"+value.linkByname+"</h3>" +
                "<p  style=\"font-size: 12px;\">"+value.linkDescribe+"</p></div></li><hr   style=\"size: 50px;;align-content: center; background-color: #1c7430;\">";

        });
        $("#vedio").html(vedio);
        $("#music").html(music);
        $("#epub").html(epub);



    });
    hrefGo=function(s){
        window.location.href=s;
    }
});