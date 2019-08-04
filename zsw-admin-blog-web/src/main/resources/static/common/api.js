/**
 * Created by ZSW on 2019/2/28.
 */
var api = {

};
api.movie = {
    root:"/movie/",
    list:function () {
        return api.movie.root + "list";
    },
    search:function () {
        return api.movie.root + "search";
    },
    listByMovie:function () {
        return api.movie.root + "list/by/movie";
    }
}

