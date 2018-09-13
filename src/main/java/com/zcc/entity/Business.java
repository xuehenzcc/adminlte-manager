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
@TableName("gm_business_t")
public class Business extends Model<Business>{

	private static final long serialVersionUID = 1L;
	@Override
	protected Serializable pkVal() {
		return this.id;
	}
	
	@TableId(type=IdType.AUTO)
	private Integer id;
	private String userid;
	private String sellername;
	private String sellweixin;
	private String sellali;
	private String sellcard;
	private Integer selljf;
	private Date buytime;
	private Date configtime;
	private Date finishtime;
	private String status;
	private String buyercard;
	private String buyerid;
	private String buyeraccount;
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
	public String getSellername() {
		return sellername;
	}
	public void setSellername(String sellername) {
		this.sellername = sellername;
	}
	public String getSellweixin() {
		return sellweixin;
	}
	public void setSellweixin(String sellweixin) {
		this.sellweixin = sellweixin;
	}
	public String getSellali() {
		return sellali;
	}
	public void setSellali(String sellali) {
		this.sellali = sellali;
	}
	public String getSellcard() {
		return sellcard;
	}
	public void setSellcard(String sellcard) {
		this.sellcard = sellcard;
	}
	public Integer getSelljf() {
		return selljf;
	}
	public void setSelljf(Integer selljf) {
		this.selljf = selljf;
	}
	public Date getBuytime() {
		return buytime;
	}
	public void setBuytime(Date buytime) {
		this.buytime = buytime;
	}
	public Date getConfigtime() {
		return configtime;
	}
	public void setConfigtime(Date configtime) {
		this.configtime = configtime;
	}
	public Date getFinishtime() {
		return finishtime;
	}
	public void setFinishtime(Date finishtime) {
		this.finishtime = finishtime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBuyercard() {
		return buyercard;
	}
	public void setBuyercard(String buyercard) {
		this.buyercard = buyercard;
	}
	public String getBuyerid() {
		return buyerid;
	}
	public void setBuyerid(String buyerid) {
		this.buyerid = buyerid;
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
	public String getBuyeraccount() {
		return buyeraccount;
	}
	public void setBuyeraccount(String buyeraccount) {
		this.buyeraccount = buyeraccount;
	}


}
