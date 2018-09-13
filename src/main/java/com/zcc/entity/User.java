/**
 * 版权：zcc
 * 作者：c0z00k8
 * @data 2018年9月12日
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
@TableName("gm_user_t")
public class User extends Model<User>{
	
	private static final long serialVersionUID = 1L;
	@Override
	protected Serializable pkVal() {
		return this.id;
	}
	
	@TableId(type=IdType.AUTO)
	private Integer id;
	private String account;
	private String password;
	private String username;
	private String safepwd;
	private String telephone;
	private String alipaypic;
	private String weixinpic;
	private String bank_num;
	private String bank_name;
	private Integer jfcenter;
	private Integer jftask;
	private Integer jfbusiness;
	private Integer jfzhuce;
	private Integer jf_diya;
	private Integer task_token;
	private Integer usedtoken;
	private Integer pretake;
	private String pid;
	private String status;
	private String jfold;
	private Integer version;
	private Date create_date;
	private Date lastup_date;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSafepwd() {
		return safepwd;
	}
	public void setSafepwd(String safepwd) {
		this.safepwd = safepwd;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAlipaypic() {
		return alipaypic;
	}
	public void setAlipaypic(String alipaypic) {
		this.alipaypic = alipaypic;
	}
	public String getWeixinpic() {
		return weixinpic;
	}
	public void setWeixinpic(String weixinpic) {
		this.weixinpic = weixinpic;
	}
	public String getBank_num() {
		return bank_num;
	}
	public void setBank_num(String bank_num) {
		this.bank_num = bank_num;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public Integer getJfcenter() {
		return jfcenter;
	}
	public void setJfcenter(Integer jfcenter) {
		this.jfcenter = jfcenter;
	}
	public Integer getJftask() {
		return jftask;
	}
	public void setJftask(Integer jftask) {
		this.jftask = jftask;
	}
	public Integer getJfbusiness() {
		return jfbusiness;
	}
	public void setJfbusiness(Integer jfbusiness) {
		this.jfbusiness = jfbusiness;
	}
	public Integer getJfzhuce() {
		return jfzhuce;
	}
	public void setJfzhuce(Integer jfzhuce) {
		this.jfzhuce = jfzhuce;
	}
	public Integer getJf_diya() {
		return jf_diya;
	}
	public void setJf_diya(Integer jf_diya) {
		this.jf_diya = jf_diya;
	}
	public Integer getTask_token() {
		return task_token;
	}
	public void setTask_token(Integer task_token) {
		this.task_token = task_token;
	}
	public Integer getUsedtoken() {
		return usedtoken;
	}
	public void setUsedtoken(Integer usedtoken) {
		this.usedtoken = usedtoken;
	}
	public Integer getPretake() {
		return pretake;
	}
	public void setPretake(Integer pretake) {
		this.pretake = pretake;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getJfold() {
		return jfold;
	}
	public void setJfold(String jfold) {
		this.jfold = jfold;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
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
