package com.zsw.admin.blog.movie.service;



import com.admin.framework.common.entity.Resp;

import java.util.Map;

/**
 *
 * @author ZSW
 * @date 2019/2/26
 */
public interface MovieService {

    /**
     * 搜索
     * @param param
     * @return
     */
    Resp search(Map param);

    /**
     * 获取列表
     * @param param
     * @return
     */
    Resp list(Map param);

    /**
     * 获取movieId列表
     * @param param
     * @return
     */
    Resp listDetail(Map param);

}
