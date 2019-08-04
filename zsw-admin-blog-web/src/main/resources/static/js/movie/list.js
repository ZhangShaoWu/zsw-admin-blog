/**
 * Created by ZSW on 2019/3/28.
 */
var vm = new Vue({
    el:"#app",
    data:{
        movies: [],
        page:{},
        loading:true,
        details:[],
        tabFlag:false,
        dialogVisible:false,
        activeName:""
    },
    mounted:function () {
        var page = {
            pageSize:10,
            pageNumber:1
        }
        this.list(page);
    },
    methods:{
        list:function (page) {
            ajax.postJson(api.movie.list(),page,function (resp) {
                var data = resp.data;
                vm.movies = data;
                vm.loading = false;
                vm.setPage(resp);
            })
        },
        search:function () {
            vm.loading = true;
            var keyword = vm.keyword;
            if(utils.strIsEmpty(keyword)){
                msg.error("请输入关键字");
                return;
            }
            ajax.postJson(api.movie.search(),{"keyword":keyword},function(resp){
                vm.movies = resp.data;
                vm.loading = false;
                vm.setPage(resp);
            });
        },
        show:function (data) {
            var movieId = data.id;
            ajax.postJson(api.movie.listByMovie(),{"movieId":movieId},function(resp){
                console.log(resp);
                var data = resp.data;
                var content = data.data;
                vm.tabFlag = data.tabFlag;
                vm.details = content;
                vm.dialogVisible = true;
                if(data.tabFlag){
                    vm.activeName = content[0].name;
                }
            });
        },
        setPage:function (data) {
            var pageSizes = [];
            for(var x = 1 ; x <= 5 ; x++){
                pageSizes[x] = Math.round(x*10);
            }
            vm.page = {
                currentPage:data.currentPage,
                pageSize:data.pageSize,
                total:data.total,
                totalPage:data.totalPage,
                pageSizes:pageSizes
            }
        },
        handleSizeChange:function(val) {
            var page = {
                pageSize:val,
                pageNumber:vm.page.currentPage
            };
            vm.list(page)
        },
        handleCurrentChange:function(val) {
            var page = {
                pageSize:vm.page.currentPage,
                pageNumber:val
            };
            vm.list(page)
        }
    }


});