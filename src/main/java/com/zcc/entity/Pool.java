/**
 * 版权：zcc
 * 作者：c0z00k8
 * @data 2018年9月13日
 */
package com.zcc.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * @author c0z00k8
 *
 */
@TableName("gm_pool_t")
public class Pool extends Model<Pool>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@TableId(type=IdType.AUTO)
	private Integer id;
	private String userid;
	private String username;
	private String gmnum;
	private String gmname;
	private String jf;
	private String status;
	private String buyinfo;
	private String winjf;
	private String getjf;
	private String count;
	private String sumjf;
	private Date create_date;
	private Date lastup_date;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getGmnum() {
		return gmnum;
	}
	public void setGmnum(String gmnum) {
		this.gmnum = gmnum;
	}
	public String getGmname() {
		return gmname;
	}
	public void setGmname(String gmname) {
		this.gmname = gmname;
	}
	public String getJf() {
		return jf;
	}
	public void setJf(String jf) {
		this.jf = jf;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBuyinfo() {
		return buyinfo;
	}
	public void setBuyinfo(String buyinfo) {
		this.buyinfo = buyinfo;
	}
	public String getWinjf() {
		return winjf;
	}
	public void setWinjf(String winjf) {
		this.winjf = winjf;
	}
	public String getGetjf() {
		return getjf;
	}
	public void setGetjf(String getjf) {
		this.getjf = getjf;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getSumjf() {
		return sumjf;
	}
	public void setSumjf(String sumjf) {
		this.sumjf = sumjf;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Date getLastup_date() {
		return lastup_date;
	}
	public void setLastup_date(Date lastup_date) {
		this.lastup_date = lastup_date;
	}
	
	
}
