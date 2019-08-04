package com.zsw.admin.blog.movie.entity;

import java.util.Date;

/**
 * 
 * @author admin
 * @date 2019-07-07 20:09:54
 */
public class MovieDetailEntity{
/**
    
	 */
    
	private Integer id;
	/**
    
	 */
    
	private Date createTime;
	/**
    
	 */
    
	private Date modifyTime;
	/**
    
	 */
    
	private Integer version;
	/**
    
	 */
    
	private Integer movieId;
	/**
    
	 */
    
	private String name;
	/**
    
	 */
    
	private String url;
	/**
    
	 */
    
	private String type;
	
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
        public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
        public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
        public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
        public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }
        public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
        public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
        public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
