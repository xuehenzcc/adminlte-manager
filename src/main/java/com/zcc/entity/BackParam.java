/**
 * 版权：zcc
 * 作者：c0z00k8
 * @data 2018年8月27日
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
@TableName("gm_backparam_t")
public class BackParam extends Model<BackParam>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@TableId(type=IdType.UUID)
	private String id;
	private String number;
	private String name;
	private String data;
	private Date createdate;
	private Date lastupdate;
	private String auto;
	private String remark;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Date getLastupdate() {
		return lastupdate;
	}

	public void setLastupdate(Date lastupdate) {
		this.lastupdate = lastupdate;
	}

	public String getAuto() {
		return auto;
	}

	public void setAuto(String auto) {
		this.auto = auto;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
