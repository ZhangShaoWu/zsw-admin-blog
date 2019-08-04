package com.zsw.admin.blog.movie.service.impl;

import com.admin.framework.common.entity.Page;
import com.admin.framework.common.entity.Resp;
import com.admin.framework.component.annotations.ParamAnnotation;
import com.admin.framework.component.annotations.ParamField;
import com.admin.framework.component.utils.ListUtil;
import com.admin.framework.component.utils.MapUtil;
import com.admin.framework.component.utils.StringUtil;
import com.zsw.admin.blog.movie.dao.MovieDao;
import com.zsw.admin.blog.movie.dao.MovieDetailDao;
import com.zsw.admin.blog.movie.dojo.MovieDetailDojo;
import com.zsw.admin.blog.movie.dojo.MovieDojo;
import com.zsw.admin.blog.movie.entity.MovieDetailEntity;
import com.zsw.admin.blog.movie.entity.MovieEntity;
import com.zsw.admin.blog.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 *
 * @author ZSW
 * @date 2019/2/26
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieDao movieDao;
    @Autowired
    private MovieDetailDao movieDetailDao;


    @Override
    @ParamAnnotation(fields = {
            @ParamField(name = "keyword",type = String.class),
            @ParamField(name = "pageSize",type = Integer.class),
            @ParamField(name = "pageNumber",type = Integer.class),
    })
    public Resp search(Map param) {
        String keyword = MapUtil.getString(param, "keyword");
        Integer pageSize = MapUtil.getInteger(param, "pageSize");
        Integer pageNumber = MapUtil.getInteger(param, "pageNumber");
        List<MovieEntity> page = new MovieDojo().nameContain(keyword).list();
        return Resp.success(page);
    }

    @Override
    @ParamAnnotation(fields = {
            @ParamField(name = "pageSize",type = Integer.class),
            @ParamField(name = "pageNumber",type = Integer.class)
    })
    public Resp list(Map param) {
        Page<MovieEntity> page = new Page<>();
        List<MovieEntity> data = movieDao.page(page, param);
        page.setData(data);
        return page;
    }

    @Override
    @ParamAnnotation(fields = {
            @ParamField(name = "movieId",type = Integer.class)
    })
    public Resp listDetail(Map param) {
        Integer movieId = MapUtil.getInteger(param, "movieId");
        MovieEntity movieEntity = new MovieDojo().idEqual(movieId).get();
        if(movieEntity == null){
            return Resp.error("资源不存在");
        }
        List<MovieDetailEntity> movieDetailEntities = new MovieDetailDojo()
                .movieIdEqual(movieId)
                .typeIsNotNull().list();
        List<MovieDetailEntity> detailEntities = new ArrayList<>();
        Map<String,List<MovieDetailEntity>> m = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        for(MovieDetailEntity detailEntity:movieDetailEntities){
            String type = detailEntity.getType();
            if(StringUtil.isEmpty(type)){
                detailEntities.add(detailEntity);
            }else{
                if(m.containsKey(type)){
                    m.get(type).add(detailEntity);
                }else{
                    List<MovieDetailEntity> list = new ArrayList<>();
                    list.add(detailEntity);
                    m.put(type,list);
                }
            }
        }
        List<Map> details = new ArrayList<>();
        if(!MapUtil.isEmpty(m)){
            for(Map.Entry<String,List<MovieDetailEntity>> en:m.entrySet()){
                String key = en.getKey();
                List<MovieDetailEntity> value = en.getValue();
                Map map = new HashMap(16);
                map.put("name",key);
                map.put("content",value);
                details.add(map);
            }
        }
        Map result = new HashMap(16);
        if(!ListUtil.isEmpty(detailEntities)){
            result.put("tabFlag",false);
            result.put("data",detailEntities);
        }
        if(!ListUtil.isEmpty(details)){
            result.put("tabFlag",true);
            result.put("data",details);
        }
        return Resp.success(result);
    }

}
