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
@TableName("gm_task_t")
public class Task extends Model<Task>{
	
	@TableId(type=IdType.AUTO)
	private Integer id;
	private String title;
	private String status;
	private String taskjf;
	private String userid;
	private String username;
	private String attribute2;
	private Date create_date;
	private Date lastup_date;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTaskjf() {
		return taskjf;
	}
	public void setTaskjf(String taskjf) {
		this.taskjf = taskjf;
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
	public String getAttribute2() {
		return attribute2;
	}
	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
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
	private static final long serialVersionUID = 1L;
	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
