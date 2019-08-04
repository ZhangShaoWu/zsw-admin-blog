/**
 * Created by ZSW on 2019/8/3.
 */
var vm = new Vue({
    el:"#app",
    data:{},
    methods:{
        sortStart:function () {
            $(".box-card").css("box-shadow","10px 10px 5px #888888")
            Sortable.create(document.getElementById("cards"), {
                animation: 1500, //动画参数
                ghostClass: 'sortable-ghost',
            });
        },
        sortEnd:function () {
            location.reload();
        }
    }
});