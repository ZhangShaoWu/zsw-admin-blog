package com.zsw.admin.blog.movie.controller;

import com.admin.framework.common.entity.Resp;
import com.zsw.admin.blog.movie.dao.MovieDao;
import com.zsw.admin.blog.movie.dojo.MovieDojo;
import com.zsw.admin.blog.movie.entity.MovieEntity;
import com.zsw.admin.blog.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 *
 * @author ZSW
 * @date 2019/2/26
 */
@RequestMapping("/movie")
@RestController
public class MovieController{



    @Autowired
    private MovieService movieService;


    @Autowired
    private MovieDao movieDao;

    @RequestMapping("/search")
    public Resp search(@RequestBody Map param){
        return movieService.search(param);
    }

    @RequestMapping("/list")
    public Resp list(@RequestBody Map param){
        return movieService.list(param);
    }

    @RequestMapping("/list/by/movie")
    public Resp listByMovie(@RequestBody Map param){
        return movieService.listDetail(param);
    }

    @RequestMapping("/test")
    public void test(){
        List<MovieEntity> movieEntity = new MovieDojo().idEqual(1).createTimeBetween("1","2").list();
        int x = 0;
    }
}
