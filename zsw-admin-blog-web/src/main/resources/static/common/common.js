/**
 * Created by ZSW on 2019/2/28.
 */
var ajax = {};
ajax.postJson = function (url,data,cb) {
    $.ajax({
        url:url,
        type:"post",
        dataType:"json",
        contentType:"application/json; charset=utf-8",
        data:JSON.stringify(data),
        success:function(resp){
            if(!resp.success){
                msg.error(resp.msg);
                return
            }
            cb(resp);
        }
    });
};
