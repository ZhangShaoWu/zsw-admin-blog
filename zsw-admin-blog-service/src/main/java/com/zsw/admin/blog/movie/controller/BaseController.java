package com.zsw.admin.blog.movie.controller;

import com.admin.framework.common.utils.RedisUtil;
import com.admin.framework.component.utils.StringUtil;
import com.zsw.admin.blog.movie.entity.MovieEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author ZSW
 * @date 2019/3/28
 */
@Controller
@Slf4j
public class BaseController {

    @Autowired
    private HttpServletRequest request;


    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(String view){
        String requestURI = request.getRequestURI();
        System.out.print(requestURI);
        log.info("aaaaa");

        RedisUtil.getObj("aaa", MovieEntity.class);

        if(StringUtil.isEmpty(view)){
            return "index";
        }
        return view;
    }
}
