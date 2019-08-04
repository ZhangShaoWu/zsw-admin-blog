package com.zsw.admin.blog.movie.entity;

import java.util.Date;

/**
 * µÁ”∞±Ì
 * @author admin
 * @date 2019-07-07 20:09:53
 */
public class MovieEntity{
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
    
	private String image;
	/**
    
	 */
    
	private String name;
	
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
        public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
        public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
